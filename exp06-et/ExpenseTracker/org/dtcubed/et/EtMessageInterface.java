package org.dtcubed.et;

import java.rmi.*;

public interface EtMessageInterface extends Remote
{
	String processMessage(String msg) throws RemoteException;
	String processCipherHex(String msg) throws RemoteException;
}
