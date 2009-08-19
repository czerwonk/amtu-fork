@echo off
set CLASSPATH=..\..\lib\axis.jar;..\..\lib\commons-discovery.jar;..\..\lib\commons-lang-2.0.jar;..\..\lib\commons-logging.jar;..\..\lib\amtu.jar
set CLASSPATH=%CLASSPATH%;..\..\lib\jaxrpc.jar;..\..\lib\activation.jar;..\..\lib\mailapi.jar;..\..\lib\saaj.jar;..\..\lib\smtp.jar;..\..\lib\wsdl4j.jar;..\..\lib\xercesImpl.jar;..\..\lib\xml-apis.jar

java -cp %CLASSPATH% com.amazon.merchants.transport.preferences.Configure %1

pause
