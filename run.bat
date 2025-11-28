@echo off
title Hospital Management System

cd /d "F:\Codes\project\HospitalManagementSystem"

javac *.java

if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Compilation Failed!
    echo Please check the Java files for errors.
    pause
    exit /b
)

echo.
echo Starting Hospital Management System...
echo -------------------------------------
java HospitalManagementSystem

echo.