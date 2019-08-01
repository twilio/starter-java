# Welcome to the Java Guild!

As members of the Java Guild, you will be working through the challenges of TwilioQuest using the Java programming language and the [Spark Framework](http://sparkjava.com/).  This project is pre-configured to have some interesting functionality built in using the Twilio Java helper library.

## Setting Up

As a first step, you should [download this project](https://github.com/twilio/starter-java), or clone it if you are a Git user.  Navigate to the directory for this project, and open it with your favorite text editor.

Before you can run this project, you will need to set three system environment variables.  These are:

* `TWILIO_ACCOUNT_SID` : Your Twilio "account SID" - it's like your username for the Twilio API.  This and the auth token (below) can be found [on the console](https://www.twilio.com/console).
* `TWILIO_AUTH_TOKEN` : Your Twilio "auth token" - it's your password for the Twilio API.  This and the account SID (above) can be found [on the console](https://www.twilio.com/console).
* `TWILIO_PHONE_NUMBER` : A Twilio number that you own, that can be used for making calls and sending messages.  You can find a list of phone numbers you control (and buy another one, if necessary) [in the account portal](https://www.twilio.com/console/phone-numbers/incoming).

For Mac and Linux, environment variables can be set by opening a terminal window and typing the following three commands - replace all the characters after the `=` with values from your Twilio account:

    export TWILIO_ACCOUNT_SID=ACXXXXXXXXX
    export TWILIO_AUTH_TOKEN=XXXXXXXXX
    export TWILIO_PHONE_NUMBER=+16518675309

To make these changes persist for every new terminal (on OS X), you can edit the file `~/.bash_profile` to contain the three commands above.  This will set these environment variables for every subsequent session. Once you have edited the file to contain these commands, run `source ~/.bash_profile` in the terminal to set up these variables.

On Windows, the easiest way to set permanent environment variables (as of Windows 8) is using the `setx` command.  Note that there is no `=`, just the key and value separated by a space:

    setx TWILIO_ACCOUNT_SID ACXXXXXXXXX
    setx TWILIO_AUTH_TOKEN XXXXXXXXX
    setx TWILIO_PHONE_NUMBER +16518675309

## Running the Application
Now that our project is ready, we need to build it using [maven](https://maven.apache.org/):

```
mvn clean install
```

Start the application:
```
java -jar target/starter-java-with-dependencies.jar 
```

Now you can visit [http://localhost:4567/](http://localhost:4567)

Try out the text message and voice call demos by entering your mobile phone number and clicking the button.  If you receive a text message and a call, everything is working!

## Begin Questing!
This is but your first step into a larger world.  [Return to TwilioQuest](http://quest.twilio.com) to continue your adventure.  Huzzah!