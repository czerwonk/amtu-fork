@echo off
echo Installing AMT as Windows Service.
call InstallAMT.bat

echo Installing Monitor as Windows Service.
call InstallMonitor.bat

echo Starting Monitor
net start AMT_Monitor

echo Starting AMT
net start AMT
