Just documenting some external dependencies for this s/w to work.

1) Via Eclipse IDE and CLI script(s), the following Bouncy Castle 
   "external" JAR serves as a "provider" to plug-in / utilize the 
   Java encryption extension framework:

   "C:\ExpenseTracker\external-jars\bouncycastle\bcprov-jdk16-146.jar"

2) Via Eclipse IDE and CLI script(s), the following Xerial "external" 
   JAR to provides access to SQLite database files:

   "C:\ExpenseTracker\external-jars\sqlite\sqlite-jdbc-3.7.2.jar"

3) To use unlimited key size in the encryption / decryption area,
   the Java Cryptography Extension (JCE) must be installed. Briefly,
   this just involved acquiring and overlaying two (2) JAR files
   for _every_ Java Runtime Environment (JRE) that will be utilized.
   The two (2) JAR files that need to be replaced in the 
   "jre/lib/security" sub-directory are: (a) local_policy.jar and
   (b) US_export_policy.jar. 

   As of this writing, the Java Cryptography Extension (JCE) files 
   could be acquired at the bottom of the page off of this link:
 
   http://www.oracle.com/technetwork/java/javase/downloads/index.html

   Beside the two (2) JAR files, there was a "COPYRIGHT.html" and a
   "README.txt" file that came with the JCE download. The "README.txt"
   file contains good informational links to related topics.
