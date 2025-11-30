#!/bin/bash


mkdir -p bin

echo "Compiling source files..."
javac -d bin --source-path src src/com/curalink/management/CuraLink.java

if [ $? -ne 0 ]; then
  echo "Compilation failed. Please check the error messages above."
  exit 1
fi

echo "Running CuraLink..."
java -cp bin com.curalink.management.CuraLink
