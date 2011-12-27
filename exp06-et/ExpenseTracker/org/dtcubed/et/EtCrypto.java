package org.dtcubed.et;

// NOTE: much of this code adapted from example here:
// http://stackoverflow.com/questions/2052213/an-example-of-encrypting-an-xml-file-in-java-using-bouncy-castle

import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
// Don't go too overboard. SHA-1 is enough (for now).
// import org.bouncycastle.crypto.digests.SHA512Digest;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

public class EtCrypto {
	
    // private static final String salt = "A long, but constant phrase that will be used each time as the salt.";
    private static final String salt = "You don't pull on Superman's cape, you don't spit into the wind.";
    private static final int iterations = 2000;
    private static final int keyLength = 256;
    private static final SecureRandom random = new SecureRandom();
	
	public static String chex2p(String passphrase, String cthex) {

		// String msg = "In c2p(), cText: [" + cText + "]\n";
		// System.out.print(msg);
		
		String plainText = "";
		
		try {
			
			System.out.print("01  ");
			
			Security.insertProviderAt(new BouncyCastleProvider(), 1);
			
			System.out.print("02  ");
			
			byte [] cipherTextByteArray = Hex.decode(cthex);
			
			System.out.print("03  ");
			
			plainText = EtCrypto.decrypt(passphrase, cipherTextByteArray);
			
			
			System.out.print("04  ");
			
		}
		catch (Exception e) {
					
			System.out.print("05  ");
			
		}
			
		return plainText;

	}
	
	// Going to use:
	// Symetric encryption (shared secret).
	// AES, what level?
	// CBC mode w/ random init random initialization vector ?
	// The initialization vector can be communicated with the 
	// cipher text and can be sent in the clear.
	
	public static String p2chex(String passphrase, String plaintext) {

		// String msg = "In p2c(), pText: [" + pText + "]\n";
		// System.out.print(msg);
		String cthex = "";
		
		try {
			
			System.out.print("01  ");
			
			Security.insertProviderAt(new BouncyCastleProvider(), 1);
			
			System.out.print("02  ");
		
			byte [] cipherTextByteArray = EtCrypto.encrypt(passphrase, plaintext);
			
			System.out.print("03  ");
			
			cthex = new String(Hex.encode(cipherTextByteArray));
			
			System.out.print("04  ");
			
		}
		catch (Exception e) {
					
			System.out.print("05  ");
			
		}
		return cthex;
	}
	
	public static String sha1digest(String inputStr) {
			
		byte[] inputStrBytes = inputStr.getBytes();	
		// Don't go too overboard. SHA-1 is enough (for now).
		// Digest digest = new SHA512Digest();	
		Digest digest = new SHA1Digest();
		digest.update(inputStrBytes, 0, inputStrBytes.length);
		byte[] digestValue = new byte[digest.getDigestSize()];
	    digest.doFinal(digestValue, 0);
	    
	    return(new String(Hex.encode(digestValue)));	    
	}
	
    private static byte [] encrypt(String passphrase, String plaintext) throws Exception {
        SecretKey key = generateKey(passphrase);
               
        // dtcubed START
        /*
        int max;
        max = Cipher.getMaxAllowedKeyLength("AES/CTR/NOPADDING");
        System.out.println("AES/CTR/NOPADDING" + ": " + Integer.toString(max) + " bits");
        */
        // dtcubed END
        
        Cipher cipher = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher.init(Cipher.ENCRYPT_MODE, key, generateIV(cipher), random);
        return cipher.doFinal(plaintext.getBytes());
    }

    private static String decrypt(String passphrase, byte [] ciphertext) throws Exception {
        SecretKey key = generateKey(passphrase);

        Cipher cipher = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher.init(Cipher.DECRYPT_MODE, key, generateIV(cipher), random);
        return new String(cipher.doFinal(ciphertext));
    }

    private static SecretKey generateKey(String passphrase) throws Exception {
        PBEKeySpec keySpec = new PBEKeySpec(passphrase.toCharArray(), salt.getBytes(), iterations, keyLength);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWITHSHA256AND256BITAES-CBC-BC");
        return keyFactory.generateSecret(keySpec);
    }

    private static IvParameterSpec generateIV(Cipher cipher) throws Exception {
        byte [] ivBytes = new byte[cipher.getBlockSize()];
        random.nextBytes(ivBytes);
        return new IvParameterSpec(ivBytes);
    }
    
    public static void main(String [] args) throws Exception {
    	
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
        String passphrase = "The quick brown fox jumped over the lazy brown dog";
        String plaintext = "hello world";
        byte [] ciphertext = encrypt(passphrase, plaintext);
        String recoveredPlaintext = decrypt(passphrase, ciphertext);
        System.out.println(recoveredPlaintext);
    }

}