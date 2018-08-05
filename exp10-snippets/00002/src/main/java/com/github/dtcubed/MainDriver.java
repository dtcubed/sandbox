package com.github.dtcubed;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.json.simple.JSONObject;

import java.io.StringWriter;

public class MainDriver {

    /*
    private static final Logger logger = LogManager.getLogger(MainDriver.class);
    */

    public static void main(String[] args) throws Throwable {

        /*
         https://stackoverflow.com/questions/6736235/set-java-system-properties-with-a-configuration-file
         The System property (below) has to be set before log4j2 knows how to find its configuration file.
        */
        System.setProperty( "log4j.configurationFile", "support/xml/log4j2.xml" );
        Logger logger = LogManager.getRootLogger();
        logger.info("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));


        /*
         Example code started from:
         https://www.tutorialspoint.com/json/json_java_example.htm
        */

        JSONObject obj = new JSONObject();

        obj.put("name","foo");
        obj.put("num",new Integer(100));
        obj.put("balance",new Double(1000.21));
        obj.put("is_vip",new Boolean(true));

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);

        String jsonText = out.toString();
        //System.out.print(jsonText);
        logger.info("JSON Text: [" + jsonText + "]");


    }
}
