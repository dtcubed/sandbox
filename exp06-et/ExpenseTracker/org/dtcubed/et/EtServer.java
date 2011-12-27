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
	
	public String processCipherHex(String msg) throws RemoteException {
		
		System.out.println("Processing: [" + msg + "]");
		String passphrase = "The quick brown fox jumped over the lazy brown dog";
		
		String plainText = EtCrypto.chex2p(passphrase, msg);
		
		return plainText;
	}
	
	public String processMessage(String msg) throws RemoteException {

		System.out.println("Processing: [" + msg + "]");
		
		if (msg.compareTo("STOP") == 0) {
			
			System.exit(0);
		}
		
		// Split the message into "tokens" using a comma as a delimiter.
		String[] token = msg.split(",");
		System.out.println("Amount: [" + token[2] + "]");
		boolean retVal = EtDataCheck.isValidAmount(token[2]);
		System.out.println("RetVal: [" + retVal + "]");
		System.out.println("Date: [" + token[3] + "]");
		retVal = EtDataCheck.isValidYYYYMMDD(token[3]);
		System.out.println("RetVal: [" + retVal + "]");
		
		try {
			EtDatabase.createEtDatabase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
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
