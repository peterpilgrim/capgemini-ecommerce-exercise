#!/bin/bash
# Pack up the source distribution

## Optional command to create JAR file
sbt package

scala -classpath "./target/scala-2.12/capgemini-ecommerce-exercise_2.12-1.0.jar"    uk.co.xenonique.capgemini.CheckoutApplication

# End.
