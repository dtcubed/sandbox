package org.dtcubed.et;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
// Don't go too overboard. SHA-1 is enough (for now).
// import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.util.encoders.Hex;

public class EtCrypto {
	
	public static String c2p(String cText) {

		String msg = "In c2p()\n";
		System.out.print(msg);
		return msg;

	}
	
	public static String p2c(String pText) {

		String msg = "In p2c()\n";
		System.out.print(msg);
		return msg;

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

}