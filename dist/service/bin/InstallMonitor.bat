@echo off
rem
rem Find the Monitor service configuration.
rem
set _MONITOR_CONF=..\conf\monitor.conf
rem
rem Install the Monitor service.
rem At runtime, the current directory will be that of Wrapper.exe
rem
wrapper.exe -i %_MONITOR_CONF%
rem
if not errorlevel 1 goto end
pause
set _MONITOR_CONF=
:end
