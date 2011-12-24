#!/usr/bin/bash


export ET_SERVER_PORT=5555


#####
# Path(s) to External Jar(s)
#####
P01="C:\ExpenseTracker\external-jars\bouncycastle\bcprov-jdk16-146.jar"
P02="C:\ExpenseTracker\external-jars\sqlite\sqlite-jdbc-3.7.2.jar"

#####
# Even though executing via Cygwin, the -classpath
# path separator is ";" for Windows and ":" for Unix/MacOS.
#####

java -classpath ".;$P01;$P02" org.dtcubed.et.EtServer

