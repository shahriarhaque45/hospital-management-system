@echo off
cd /d "%~dp0"

echo Compiling...
javac *.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b
)

echo Running...
java HospitalManagementSystem
pause