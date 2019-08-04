package com.twilio.starter.controller;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import spark.Request;
import spark.Response;
import spark.Route;

public class TwimlController {

    // Render a TwiML document to give instructions for an outbound call
    public static Route handlePost = (Request request, Response response) -> {
        Say one = new Say.Builder("Hello there! You have successfully configured a web hook.").build();
        Say two = new Say.Builder("Good luck on your Twilio quest!").build();

        VoiceResponse voiceResponse = new VoiceResponse.Builder().say(one).say(two).build();

        response.type("text/xml");
        return voiceResponse.toXml();
    };
}
