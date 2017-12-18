package com.github.dtcubed.spark;

import static spark.Spark.*;

public class MainSpark {

    /**************************************************************************/
    public static void main(String[] args) {

        String logMsg;

        logMsg = String.format("STARTING UP Sparky");
        System.out.println(logMsg);

        // Spark will run on port 8080 instead of default 4567
        port(8080);

        // You can also configure the minimum numbers of threads, and the idle timeout
        int maxThreads = 8;
        int minThreads = 2;
        int timeOutMillis = 30000;
        threadPool(maxThreads, minThreads, timeOutMillis);

        // Start the web server overtly even though it would start automatically upon declaring routes.
        init();

        get("/hello", (request, response) -> "Hello World!");
        get("/test", (request, response) -> "TEST TEST TEST TEST TEST!");
        get("/get/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });
        post("/post/:name", (request, response) -> {
            // return "Hello POST: " + request.params(":name");
           // Works return "Request Body[: " + request.body() + "]";
            response.status(401);
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
