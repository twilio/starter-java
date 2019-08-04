package com.twilio.starter;

import com.twilio.Twilio;
import com.twilio.starter.controller.CallController;
import com.twilio.starter.controller.MessageController;
import com.twilio.starter.controller.TwimlController;

import static spark.Spark.*;

public class Application {

    private static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        staticFileLocation("/public");

        post("/call", CallController.handlePost);
        post("/message", MessageController.handlePost);
        post("/hello", TwimlController.handleGet);
    }
}
