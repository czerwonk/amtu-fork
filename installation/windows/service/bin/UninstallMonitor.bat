@echo off

rem
rem Find the AppServer service configuration.
rem
set _MONITOR_CONF=..\conf\monitor.conf

rem
rem Remove the Monitor service.
rem At runtime, the current directory will be that of Wrapper.exe
rem
wrapper.exe -r %_MONITOR_CONF%
if not errorlevel 1 goto end
pause

:end
set _MONITOR_CONF=

