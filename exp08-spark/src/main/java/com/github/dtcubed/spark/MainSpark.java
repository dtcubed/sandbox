package com.github.dtcubed.spark;

import org.json.JSONObject;

import static spark.Spark.*;

public class MainSpark {

    /**************************************************************************/
    public static void main(String[] args) {

        System.out.printf("STARTING UP SPARKY\n");

        // Spark will run on port 8080 instead of default 4567
        port(8080);

        // You can also configure the minimum numbers of threads, and the idle timeout
        int maxThreads = 8;
        int minThreads = 2;
        int timeOutMillis = 30000;
        threadPool(maxThreads, minThreads, timeOutMillis);

        // Start the web server overtly even though it would start automatically upon declaring routes.
        init();

        /*
        Read the documentation. There is a lot more that one can do with other types of web
        requests (GET, PUT, etc.). For our purposes, we are only going to use the POST request
        and declare a single "route". We don't need to use parameterized URI's either.
        Definitely, following the KISS principle.
       */
        post("/post/request", (request, response) -> {

            JSONObject json_object = new JSONObject(request.body());

            String msg_id   = json_object.getString("id");
            String msg_type = json_object.getString("type");

            System.out.printf("Extracted Msg Id  : [%s]\n", msg_id);
            System.out.printf("Extracted Msg Type: [%s]\n", msg_type);

            return request.body();
        });

        System.out.print("========================================\n");
        System.out.print("Enter something to STOP the Web Server\n");
        System.out.print("========================================\n");

        String input = System.console().readLine();
        // Stop the web server and clear all routes.
        stop();
        // System.exit(0);
    }
    /**************************************************************************/
}
