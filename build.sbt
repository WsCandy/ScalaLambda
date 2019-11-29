name := "scala-lambda"
version := "1.0"
scalaVersion := "2.13.1"
retrieveManaged := true

libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.2.0"
libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "2.2.7"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.10.1"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.10.1"
libraryDependencies += "com.twitter" %% "util-core" % "19.11.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

mainClass in (Compile, run) := Some("lambda.Main")

assemblyOutputPath in assembly := file("./assembly.jar")