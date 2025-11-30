#!/bin/bash

# This script compiles and runs the CuraLink application.

# Create the output directory if it doesn't exist
mkdir -p bin

# Compile all .java files from the src directory
# The -d flag specifies the output directory for the .class files
# The --source-path flag specifies the root directory of the source files
echo "Compiling source files..."
javac -d bin --source-path src src/com/curalink/management/CuraLink.java

# Check if compilation was successful
if [ $? -ne 0 ]; then
  echo "Compilation failed. Please check the error messages above."
  exit 1
fi

# Run the application
# The -cp flag sets the classpath to the 'bin' directory where the .class files are located
echo "Running CuraLink..."
java -cp bin com.curalink.management.CuraLink
