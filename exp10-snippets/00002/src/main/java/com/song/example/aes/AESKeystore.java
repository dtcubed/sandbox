package com.song.example.aes;
    
import java.security.SecureRandom;
    
public class AESKeystore {
    private byte[] key;
    private byte[] iv;
    
    public byte[] getKey() { return key; }
    public byte[] getIV() { return iv; }
    
    private AESKeystore(byte[] key, byte[] iv) {
        this.key = key;
        this.iv = iv;
    }
    
    public static AESKeystore create() {
        // Hard-coded to 16 * 8 = 128 bit
        // To use 32 * 8 = 256 bit, you need to download
        // Java Cryptography Extension (JCE) Unlimited Strength
        // for the java version
        byte[] key = new byte[16];
        byte[] iv = new byte[16];
        
        SecureRandom rnd = new SecureRandom();
        rnd.nextBytes(key);
        rnd.nextBytes(iv);
        
        return create(key, iv);
    }
    
    public static AESKeystore create(byte[] key, byte[] iv) {
        return new AESKeystore(key, iv);
    }
}

