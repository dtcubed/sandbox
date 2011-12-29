package org.dtcubed.et;

import java.rmi.*;

public interface EtMessageInterface extends Remote
{
	void createEtAdminDb(String adminPassword) throws RemoteException;
	void createEtDb(String basename) throws RemoteException;
	String processCipherHex(String msg) throws RemoteException;
	String processMessage(String msg) throws RemoteException;
	void stopServer() throws RemoteException;
}
