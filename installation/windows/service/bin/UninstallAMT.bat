@echo off

rem
rem Find the AppServer service configuration.
rem
set _AMT_CONF=..\conf\amt.conf

rem
rem Remove the MX4J AMT service.
rem At runtime, the current directory will be that of Wrapper.exe
rem
wrapper.exe -r %_AMT_CONF%
if not errorlevel 1 goto end
pause

:end
set _AMT_CONF=

