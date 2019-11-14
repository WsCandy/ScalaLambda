javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

name := "scala-lambda"
version := "1.0"
scalaVersion := "2.13.1"
retrieveManaged := true

libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.2.0"
libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "2.2.7"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

mainClass in (Compile, run) := Some("lambda.Main")

assemblyOutputPath in assembly := file("./assembly.jar")