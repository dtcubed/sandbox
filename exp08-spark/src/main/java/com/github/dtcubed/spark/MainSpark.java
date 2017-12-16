package com.github.dtcubed.spark;

import static spark.Spark.*;

public class MainSpark {
 
   /**************************************************************************/
   public static void main(String[] args) { 

      String logMsg;

      logMsg = String.format("STARTING UP Sparky");
      System.out.println(logMsg);
      get("/hello", (request, response) -> "Hello World!");
      // System.exit(0);
   } 
   /**************************************************************************/
}

