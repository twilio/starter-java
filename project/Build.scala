import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "starter-java"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "com.twilio.sdk" % "twilio-java-sdk" % "3.3.16"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
