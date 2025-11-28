@echo off
title Hospital Management System
color 0F

cd /d "F:\Codes\project\HospitalManagementSystem"

javac *.java

if %errorlevel% neq 0 (
    color 0C
    echo [ERROR] Compilation failed!
    pause
    exit /b
)

java HospitalManagementSystem

pause