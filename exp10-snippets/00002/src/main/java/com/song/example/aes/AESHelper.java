package com.song.example.aes;
    
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
    
public class AESHelper {
    private final String ALGORITHM = "AES/CBC/PKCS5PADDING";
    private final String STR_ENCODE = "UTF-8";
        
    private SecretKeySpec key;
    private IvParameterSpec iv;
        
    public AESHelper(AESKeystore keystore) throws Exception {
        key = new SecretKeySpec(keystore.getKey(), "AES");
        iv = new IvParameterSpec(keystore.getIV());
    }
        
    private Cipher getCipherInstance(int mode) throws Exception {
        Cipher aesCipher = Cipher.getInstance(ALGORITHM);
        aesCipher.init(mode, key, iv);
        
        return aesCipher;
    }
    
    public byte[] encryptBytes(byte[] data) throws Exception {
        return getCipherInstance(Cipher.ENCRYPT_MODE).doFinal(data);
    }
    
    public byte[] decryptBytes(byte[] encrypted) throws Exception {
        return getCipherInstance(Cipher.DECRYPT_MODE).doFinal(encrypted);
    }
    
    public byte[] encryptString(String data) throws Exception {
        return encryptBytes(data.getBytes(STR_ENCODE));
    }
    
    public String decryptString(byte[] encrypted) throws Exception {
        return new String(decryptBytes(encrypted), STR_ENCODE);
    }
}

