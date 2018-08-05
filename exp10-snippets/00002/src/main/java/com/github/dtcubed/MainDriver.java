package com.github.dtcubed;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainDriver {

    /*
    System.setProperty( "log4j.configurationFile", "support/xml/log4j2.xml" );
    private static final Logger logger = LogManager.getLogger(MainDriver.class);
    */

    public static void main(String[] args) {

        /*
         https://stackoverflow.com/questions/6736235/set-java-system-properties-with-a-configuration-file
         The System property (below) has to be set before log4j2 knows how to find its configuration file.
        */

        System.setProperty( "log4j.configurationFile", "support/xml/log4j2.xml" );
        Logger logger = LogManager.getRootLogger();

        logger.trace("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));

        logger.debug("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));

        logger.info("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));

        logger.warn("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));

        logger.error("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));

        logger.fatal("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));

        logger.fatal("Another FATAL");

        System.out.println("hello world");

    }
}
