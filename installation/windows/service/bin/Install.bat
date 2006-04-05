@echo off

echo Installing Services
call InstallAMT.bat
call InstallMonitor.bat

echo Starting Services
net start AMT_Monitor
