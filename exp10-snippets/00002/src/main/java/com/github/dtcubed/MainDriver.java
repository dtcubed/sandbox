package com.github.dtcubed;

/*
SNIPPET: Illustrates AES Symmetric Encryption/Decryption of JSON things.
*/
/*
  We are using the examples illustrated here:
  https://www.codeproject.com/Articles/1085427/Symmetric-Key-Encryption-by-AES
*/
import com.song.example.aes.AESHelper;
import com.song.example.aes.AESKeystore;

import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.json.simple.JSONObject;

public class MainDriver {

    /*
    private static final Logger logger = LogManager.getLogger(MainDriver.class);
    */

    public static void main(String[] args) throws Throwable {

        /*
         https://stackoverflow.com/questions/6736235/set-java-system-properties-with-a-configuration-file
         The System property (below) has to be set before log4j2 knows how to find its configuration file.
        */
        System.setProperty( "log4j.configurationFile", "support/xml/log4j2.xml" );
        Logger logger = LogManager.getRootLogger();
        logger.info("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));

        /*
         Example code started from:
         https://www.tutorialspoint.com/json/json_java_example.htm
        */
        JSONObject obj = new JSONObject();

        obj.put("name","foo");
        obj.put("num",new Integer(100));
        obj.put("balance",new Double(1000.21));
        obj.put("is_vip",new Boolean(true));

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);

        String jsonText = out.toString();
        //System.out.print(jsonText);
        logger.info("JSON Text: [" + jsonText + "]");

        // START USING AES example classes
        AESKeystore keystore = AESKeystore.create();

        byte[] encrypted = null;
        String decrypted = null;

        // This illustrates String encryption/decryption.
        encrypted = new AESHelper(keystore).encryptString(jsonText);
        decrypted = new AESHelper(keystore).decryptString(encrypted);

        logger.info("JSON Text Decrypted: [" + decrypted + "]");

        // BINARY encryption/decryption is illustrated in the UNIT TEST BELOW
    }
}


/*
Pertinent UNIT Test:

package com.song.example.aes;

import java.util.Arrays;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class Test1Correctness {
    private AESKeystore keystore;

    @BeforeTest
    public void init() { keystore = AESKeystore.create(); }

    @Test(description = "testBinaryEncryption()")
    public void testBinaryEncryption() {
        byte[] data = new byte[1024];
        new Random().nextBytes(data);

        byte[] encrypted = null;
        byte[] decrypted = null;

        try {
            encrypted = new AESHelper(keystore).encryptBytes(data);
        } catch(Exception e) {
            Assert.fail("Failed to encrypt the data");
        }

        try {
            decrypted = new AESHelper(keystore).decryptBytes(encrypted);
        } catch(Exception e) {
            Assert.fail("Failed to decrypt the data");
        }

        Assert.assertEquals(decrypted.length, data.length);
        Assert.assertTrue(Arrays.equals(data, decrypted));
    }

    @Test(description = "testStringEncryption()")
    public void testStringEncryption() {
        final String data = "This is the test string";

        byte[] encrypted = null;
        String decrypted = null;

        try {
            encrypted = new AESHelper(keystore).encryptString(data);
        } catch(Exception e) {
            Assert.fail("Failed to encrypt the data");
        }

        try {
            decrypted = new AESHelper(keystore).decryptString(encrypted);
        } catch(Exception e) {
            Assert.fail("Failed to decrypt the data");
        }

        Assert.assertEquals(decrypted.length(), data.length());
        Assert.assertEquals(decrypted, data);
    }
}
*/
