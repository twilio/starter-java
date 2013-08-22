package controllers;

import java.util.HashMap;
import java.util.Map;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

public class Application extends Controller {

    // Load configuration from [project]/conf/application.conf
    public static String TWILIO_ACCOUNT_SID = play.Play.application().configuration().getString("twilio.accountSid");
    public static String TWILIO_AUTH_TOKEN = play.Play.application().configuration().getString("twilio.authToken");
    public static String TWILIO_NUMBER = play.Play.application().configuration().getString("twilio.number");

    // create an authenticated REST client
    public static TwilioRestClient client = new TwilioRestClient(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
    public static Account mainAccount = client.getAccount();
  
    // Render the home page for our application
    public static Result index() {
        return ok(index.render());
    }

    // Handle a POST request to make an outbound call
    public static Result call() throws TwilioRestException {
        // Get POST data
        Map<String, String[]> params = request().body().asFormUrlEncoded();
        String to = params.get("to")[0];

        // Make a call
        CallFactory callFactory = mainAccount.getCallFactory();
        Map<String, String> callParams = new HashMap<String, String>();
        callParams.put("To", to);
        callParams.put("From", TWILIO_NUMBER);
        callParams.put("Url", "http://twimlets.com/message?Message%5B0%5D=http://demo.kevinwhinnery.com/audio/zelda.mp3");
        callFactory.create(callParams);
        
        return ok("Call is inbound!");
    }

    // Handle a POST request to send a text message
    public static Result message() throws TwilioRestException {
    	// Get POST data
        Map<String, String[]> params = request().body().asFormUrlEncoded();
        String to = params.get("to")[0];
    	
    	SmsFactory smsFactory = mainAccount.getSmsFactory();
        Map<String, String> smsParams = new HashMap<String, String>();
        smsParams.put("To", to);
        smsParams.put("From", TWILIO_NUMBER);
        smsParams.put("Body", "Good luck on your Twilio quest!");
        smsFactory.create(smsParams);
    	
        return ok("Message incoming!");
    }

    // Render a TwiML document to give instructions for an outbound call
    public static Result hello() throws TwiMLException {
        TwiMLResponse response = new TwiMLResponse();
        Say one = new Say("Hello there! You have successfully configured a web hook.");
        Say two = new Say("Good luck on your Twilio quest!");
        two.setVoice("woman");

        response.append(one);
        response.append(two);

        response().setContentType("text/xml");
        return ok(response.toXML());
    }
  
}
