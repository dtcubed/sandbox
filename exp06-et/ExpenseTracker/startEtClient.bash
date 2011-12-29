#!/usr/bin/bash

export ET_ADMIN_PASSWORD=test

export ET_ACCOUNT=household
export ET_ACCOUNT_PASSWORD=sshsha2hashssh

export ET_SERVER_IP_ADDRESS=192.168.237.1
export ET_SERVER_PORT=5555


#####
# Path(s) to External Jar(s)
#####
P01="C:\ExpenseTracker\external-jars\bouncycastle\bcprov-jdk16-146.jar"

#####
# Even though executing via Cygwin, the -classpath
# path separator is ";" for Windows and ":" for Unix/MacOS.
#####

java -classpath ".;$P01" org.dtcubed.et.EtClient


