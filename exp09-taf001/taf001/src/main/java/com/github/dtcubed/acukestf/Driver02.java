package com.github.dtcubed.acukestf;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver02 {

    public static void main(String[] args) {

        String logMsg;

        String runBaseDirectory = "support/run/";

        Date date  = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss-SSS");
        String runId = dateFormat.format(date);

        String runDirectory = runBaseDirectory + runId + "/";

        // MUST be set so that Log4j2 knows where its configuration file file is.
        System.setProperty( "log4j.configurationFile", "support/xml/log4j2.xml" );
        // The following System Property is DE-REFERENCED from within the Log4j2 configuration file.
        System.setProperty( "log4j.uniqueRunDirectory", runDirectory );

        File fileRunBaseDirectory = new File(runBaseDirectory);

        File fileRunDirectory     = new File(runDirectory);

        // Ensure that the base directory exists.
        if (fileRunBaseDirectory.isDirectory()) {

            // Ensure that the proposed run directory does NOT exist (as either a directory or a file).
            // Since the proposed run directory is based on a time-stamp down to the millisecond, we have a
            // problem if it does already exist.
            if (!(fileRunDirectory.exists())) {

                // Now, make the creation attempt.
                if (!(fileRunDirectory.mkdir())) {

                    logMsg = String.format("Failed to create directory: [%s]", runDirectory);
                    System.err.println(logMsg);
                    System.exit(1);
                }
            }
            else {

                logMsg = String.format("Proposed Run Directory: [%s] already exists!", runDirectory);
                System.err.println(logMsg);
                System.exit(1);
            }

        }
        else {

            logMsg = String.format("Run Base Directory: [%s] does not already exist!", runBaseDirectory);
            System.err.println(logMsg);
            System.exit(1);
        }

        /*
        Now that we have a UNIQUE application RUN directory established, we can initialize the Log4j2 logger.
        */
        Logger logger = LogManager.getRootLogger();

        logMsg = String.format("Unique Run Directory: [%s] Config file: [%s]",
                System.getProperty("log4j.uniqueRunDirectory"),
                System.getProperty("log4j.configurationFile"));

        logger.info(logMsg);

        if (args.length == 2) {

            String testSuiteFile      = args[0];
            String featureFileBaseDir = args[1];

            logMsg = String.format("%s: [%s] ", testSuiteFile, featureFileBaseDir);

            logger.info(logMsg);

            try {

                HashMap<String, Integer> tagCount = Utilities.get_feature_files_tag_count(featureFileBaseDir);

                if (Utilities.test_suite_ok_to_execute(testSuiteFile, tagCount)) {

                    if (Utilities.build_run_feature_file(testSuiteFile, featureFileBaseDir, runDirectory)) {

                        if (!(Utilities.execute_run_feature_file(runDirectory))) {

                            logger.error("Problem Executing Run Feature File");
                            System.exit(1);

                        }

                    } else {

                        logger.error("Problem Building Run Feature File");
                        System.exit(1);
                    }

                } else {

                    logger.error("Suite is NOT OK to execute!");
                    System.exit(1);
                }

            } catch (Throwable e) {

                logger.fatal(e.getStackTrace());
                System.exit(1);

            }

        } else {

            //String errMsg = "Expecting arguments <testSuiteFile> <featureFileBaseDir>";
            //System.err.println(errMsg);
            logMsg = "Expecting arguments <testSuiteFile> <featureFileBaseDir>";
            logger.error(logMsg);
            System.exit(1);
        }

    }
}

