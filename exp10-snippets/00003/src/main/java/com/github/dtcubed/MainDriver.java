package com.github.dtcubed;

/*
SNIPPET: Illustrates RSA Asymmetric Encryption/Decryption of things with a Mkyong example.
*/

import com.mkyong.asymmetric.AsymmetricCryptography;
import com.mkyong.keypair.GenerateKeys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;

/*
Examples:
https://www.mkyong.com/java/java-asymmetric-cryptography-example/
http://www.java-redefined.com/2013/08/asymmetric-key-encryption-decryption.html
http://www.java2s.com/Tutorial/Java/0490__Security/AnexampleofusingRSAtoencryptasingleasymmetrickey.htm
https://www.quickprogrammingtips.com/java/java-asymmetric-encryption-decryption-example-with-rsa.html
Good insight:
https://stackoverflow.com/questions/10007147/getting-a-illegalblocksizeexception-data-must-not-be-longer-than-256-bytes-when
 */

public class MainDriver {

    /*
    System.setProperty( "log4j.configurationFile", "support/xml/log4j2.xml" );
    private static final Logger logger = LogManager.getLogger(MainDriver.class);
    */

    public static void main(String[] args) throws Throwable {

        final String PUBLIC_KEY  = "support/run/publicKey";
        final String PRIVATE_KEY = "support/run/privateKey";

        /*
         https://stackoverflow.com/questions/6736235/set-java-system-properties-with-a-configuration-file
         The System property (below) has to be set before log4j2 knows how to find its configuration file.
        */

        System.setProperty( "log4j.configurationFile", "support/xml/log4j2.xml" );
        Logger logger = LogManager.getRootLogger();

        logger.info("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));

        GenerateKeys gk;
        try {
            //gk = new GenerateKeys(1024); // WORKS
            //gk = new GenerateKeys(2048); // WORKS
            gk = new GenerateKeys(4096);
            gk.createKeys();
            gk.writeToFile(PUBLIC_KEY, gk.getPublicKey().getEncoded());
            gk.writeToFile(PRIVATE_KEY, gk.getPrivateKey().getEncoded());
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        AsymmetricCryptography ac = new AsymmetricCryptography();
        PrivateKey privateKey = ac.getPrivate(PRIVATE_KEY);
        PublicKey publicKey = ac.getPublic(PUBLIC_KEY);

        String msg = "Cryptography is fun!";
        String encrypted_msg = ac.encryptText(msg, privateKey);
        String decrypted_msg = ac.decryptText(encrypted_msg, publicKey);
        System.out.println("Original Message: " + msg +
                "\nEncrypted Message: " + encrypted_msg
                + "\nDecrypted Message: " + decrypted_msg);

        if (new File("support/run/text.txt").exists()) {
            logger.info("TEXT FILE TO BE ENCRYPTED EXISTS");
            ac.encryptFile(ac.getFileInBytes(new File("support/run/text.txt")),
                    new File("support/run/text_encrypted.txt"), privateKey);
            ac.decryptFile(ac.getFileInBytes(new File("support/run/text_encrypted.txt")),
                    new File("support/run/text_decrypted.txt"), publicKey);
        } else {
            System.out.println("Create a file text.txt under folder support/run");
        }

        System.out.println("END OF SNIPPET 00003");

    }
}
