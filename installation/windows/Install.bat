@echo off
call Configure.bat
cd service\bin
call Install.bat
cd ..\..
pause