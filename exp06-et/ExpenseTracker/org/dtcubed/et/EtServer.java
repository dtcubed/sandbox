package org.dtcubed.et;

import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

import org.dtcubed.et.EtCrypto;
import org.dtcubed.et.EtDatabase;


@SuppressWarnings("serial")
public class EtServer extends UnicastRemoteObject implements EtMessageInterface {
	
	int thisPort;
	String thisAddress;
	Registry registry; // rmi registry for lookup the remote objects.
	
	public void createEtAdminDb(String adminPassword) throws RemoteException {
		
		try {
			EtDatabase.createEtAdminDatabase(adminPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	public void createEtDb(String basename) throws RemoteException {
		
		try {
			EtDatabase.createEtDatabase(basename);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	public String processCipherHex(String msg) throws RemoteException {
		
		System.out.println("Processing: [" + msg + "]");
		String passphrase = "The quick brown fox jumped over the lazy brown dog";
		
		String plainText = EtCrypto.chex2p(passphrase, msg);
		
		return plainText;
	}
	
	public String processMessage(String msg) throws RemoteException {

		// TODO: Ciphertext to plaintext here.
		
		System.out.println("Processing: [" + msg + "]");
		
		// Split into 2 parts, using comma as the delimiter.
		String[] part = msg.split(",", 2);
		
		// After the split, part 0 contains the sha1 digest part 1
		System.out.println("Part 0: [" + part[0] + "]");
		System.out.println("Part 1: [" + part[1] + "]");
		
		// Now, re-compute the sha1 digest for a server side comparison.
		String serverSideDigest = EtCrypto.sha1digest(part[1]);
				
		// If the digests don't compare, return.
		if (serverSideDigest.compareTo(part[0]) != 0) {
			
			// throw new RemoteException("this should never happen");
			return "digest mis-compare";
		}
		
		// Now, split part 1 into 2 pieces to isolate the request type.
		// part = part[1].split(",", 2);
		
		// Now, split part 1 into its various pieces as delimited by ",".
		part = part[1].split(",");
		
		if (part[0].equals("ADMIN-CREATE-ADMIN-DB")) {
			
			System.out.println("In: [ADMIN-CREATE-ADMIN-DB]");
			
			try {
				EtDatabase.createEtAdminDatabase(part[1]);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
		
		if (part[0].equals("ADMIN-CREATE-ET-DB")) {
			
			System.out.println("In: [ADMIN-CREATE-ET-DB]");	
			
			System.out.println("Submitted AdminPW: [" + part[1] + "]");	
			
			String retrievedAdminPassword = "";
			
			try {
				retrievedAdminPassword = EtDatabase.getAdminPassword();
			}
			catch (Exception e) {
				;
			}
			System.out.println("Retrieved AdminPW: [" + retrievedAdminPassword + "]");	
			
			// If the retrieved "admin" password in the "admin" db doesn't equal the
			// one passed in, return our error indicator.
			if (!(retrievedAdminPassword.equals(part[1]))) {
				
				return "E";
			}
			
			try {
				EtDatabase.createEtDatabase(part[2], part[3]);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "E";
			}
		}
		
		if (part[0].equals("ADMIN-SHUTDOWN-SERVER")) {
			
			System.out.println("In: [ADMIN-SHUTDOWN-SERVER]");	
			
			System.out.println("Submitted AdminPW: [" + part[1] + "]");	
			
			String retrievedAdminPassword = "";
			
			try {
				retrievedAdminPassword = EtDatabase.getAdminPassword();
			}
			catch (Exception e) {
				;
			}
			System.out.println("Retrieved AdminPW: [" + retrievedAdminPassword + "]");	
			
			// If the retrieved "admin" password in the "admin" db doesn't equal the
			// one passed in, return our error indicator.
			if (!(retrievedAdminPassword.equals(part[1]))) {
				
				return "E";
			}
			
			System.exit(0);
		}
			
		// public static void insertExpense(String dbBasename, String dbPassword, String amt, String dateExpIncurred,
	    //        String categoryCode, String note) throws ClassNotFoundException {
		
		if (part[0].equals("INSERT-EXPENSE")) {
			
			System.out.println("In: [INSERT-EXPENSE]");	
			
			try {
				
				EtDatabase.insertExpense(part[1], part[2], part[3], part[4], part[5], part[6]);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "E";
			}
		}

		
		/*
		
		// Split the message into "tokens" using a comma as a delimiter.
		String[] token = msg.split(",");
		System.out.println("Amount: [" + token[2] + "]");
		boolean retVal = EtDataCheck.isValidAmount(token[2]);
		System.out.println("RetVal: [" + retVal + "]");
		System.out.println("Date: [" + token[3] + "]");
		retVal = EtDataCheck.isValidYYYYMMDD(token[3]);
		System.out.println("RetVal: [" + retVal + "]");		
		return msg;
		*/
		return "OK";
	}
	
	public void stopServer() throws RemoteException {

		System.out.println("STOPPING SERVER");
		
		System.exit(0);
	}

	public EtServer(int portToListenOn) throws RemoteException {
		
		try {
			// get the address of this host.
			thisAddress = (InetAddress.getLocalHost()).toString();
		} 
		catch (Exception e) {
			
			throw new RemoteException("can't get inet address.");
		}
		
		System.out.println("this address=" + thisAddress + ",port=" + portToListenOn);
		
		try {
			
			// create the registry and bind the name and object.
			registry = LocateRegistry.createRegistry(portToListenOn);
			registry.rebind("rmiServer", this);
			
		} 
		catch (RemoteException e) {
			
			throw e;
		}
	}

	static public void main(String args[]) {
		
		int portToListenOn = (int) 31313;
		
		String etServerPort = System.getenv("ET_SERVER_PORT");
		
		if (etServerPort == null) {
			
			etServerPort = "31313";
			
		}
		
		try {
			
			portToListenOn = Integer.parseInt(etServerPort);
			
		}
		catch (Exception e) {
			
			portToListenOn = (int) 31313;
		}
		finally {
			
			if ((portToListenOn < 0) || (portToListenOn > 65536)) {
				
				portToListenOn = (int) 31313;
				
			}		
		}

		try {
			@SuppressWarnings("unused")
			EtServer etS = new EtServer(portToListenOn);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
