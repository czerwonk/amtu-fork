@echo off
echo Stopping Monitor
net stop AMT_Monitor

echo Stopping AMT
net stop AMT

echo Uninstalling Monitor.
call UninstallMonitor.bat

echo Uninstalling AMT.
call UninstallAMT.bat

pause
