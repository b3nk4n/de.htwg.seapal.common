import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "common"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "com.google.inject" % "guice" % "3.0"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here  
      
    resolvers += "HTWG Repo Util" at "http://lenny2.in.htwg-konstanz.de:8081/artifactory/libs-snapshot-local",

    publishTo := Some("HTWG Repo Util" at "http://lenny2.in.htwg-konstanz.de:8081/artifactory/libs-snapshot-local;build.timestamp=" + new java.util.Date().getTime) 
  
  )

}
