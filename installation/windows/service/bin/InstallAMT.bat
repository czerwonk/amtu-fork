@echo off
rem
rem Find the AMT service configuration.
rem
set _AMT_CONF=..\conf\amt.conf
rem
rem Install the MX4J AMT service.
rem At runtime, the current directory will be that of Wrapper.exe
rem
wrapper.exe -i %_AMT_CONF%
rem
if not errorlevel 1 goto end
pause
set _AMT_CONF=
:end
