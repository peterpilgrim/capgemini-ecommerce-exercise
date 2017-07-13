// Build file for Peter Pilgrim for Cap Gemini E-commerce Exercise

// Define the project name
name := "capgemini-ecommerce-exercise"

// Define the version
version := "1.0"

// What version of Scala do we need?
scalaVersion := "2.12.2"

/*
  "org.scala-lang" % "scala-reflect" % "2.11.8",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.5",
 */
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.12" % "test",
  "org.mockito" % "mockito-all" % "1.10.8" % "test",
  "org.scalactic" %% "scalactic" % "3.0.0",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

connectInput in run := true

mainClass in (Compile,run) := Some("uk.co.xenonique.capgemini.CheckoutApplication")

// fork a new JVM for 'run' and 'test:run'
fork := true

// fork a new JVM for 'test:run', but not 'run'
fork in Test := true

// add a JVM option to use when forking a JVM for 'run'
javaOptions += "-Xmx512M"

