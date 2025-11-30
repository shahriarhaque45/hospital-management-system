@echo off
title CuraLink Hospital Management System

echo Compiling project...
rem This command compiles all .java files from the 'src' directory and places the compiled .class files into the 'bin' directory.
javac -d bin --source-path src src/com/curalink/management/CuraLink.java

if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Compilation Failed!
    pause
    exit /b
)

echo Compilation successful. Starting application...
echo.

rem This command runs the application by specifying the classpath to the 'bin' directory where the compiled classes are located.
java -cp bin com.curalink.management.CuraLink

echo.
echo Application finished.
pause
