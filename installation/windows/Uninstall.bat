@echo off
cd service\bin
call Uninstall.bat
call Configure.bat -uninstall
cd ..\..
echo You can now safely delete these folders manually when you have finished with them.
pause