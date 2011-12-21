#!/usr/bin/bash

#####
# Path(s) to External Jar(s)
#####
P01="C:\ExpenseTracker\external-jars\sqlite\sqlite-jdbc-3.7.2.jar"

#####
# Even though executing via Cygwin, the -classpath
# path separator is ";" for Windows and ":" for Unix/MacOS.
#####

java -classpath ".;$P01" org.dtcubed.et.EtServer

#java -classpath ".;$P01" org.dtcubed.et.Sample

