package org.dtcubed.et;

import java.rmi.*;

public interface EtMessageInterface extends Remote
{
	String echoMsg(String msg) throws RemoteException;
}
