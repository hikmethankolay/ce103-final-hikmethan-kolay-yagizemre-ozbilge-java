@echo off
@setlocal enableextensions
@cd /d "%~dp0"

echo Running Application
java -jar car_maintenance_app/target/car_maintenance_app-1.0-SNAPSHOT.jar

echo Operation Completed!
pause