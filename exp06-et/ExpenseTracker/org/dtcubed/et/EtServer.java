package org.dtcubed.et;

import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;


@SuppressWarnings("serial")
public class EtServer extends java.rmi.server.UnicastRemoteObject
		implements EtMessageInterface {
	
	int thisPort;
	String thisAddress;
	Registry registry; // rmi registry for lookup the remote objects.
	
	public String echoMsg(String msg) throws RemoteException {

		System.out.println("Got: [" + msg + "]");
		return msg;
	}

	public EtServer() throws RemoteException {
		try {
			// get the address of this host.
			thisAddress = (InetAddress.getLocalHost()).toString();
		} catch (Exception e) {
			throw new RemoteException("can't get inet address.");
		}
		thisPort = 13131; // this port(registry’s port)
		System.out.println("this address=" + thisAddress + ",port=" + thisPort);
		try {
			// create the registry and bind the name and object.
			registry = LocateRegistry.createRegistry(thisPort);
			registry.rebind("rmiServer", this);
		} catch (RemoteException e) {
			throw e;
		}
	}

	static public void main(String args[]) {
		
		String myClassPath = System.getenv("CLASSPATH");
		System.out.println("Value is: [" + myClassPath + "]");

		try {
			@SuppressWarnings("unused")
			EtServer etS = new EtServer();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
