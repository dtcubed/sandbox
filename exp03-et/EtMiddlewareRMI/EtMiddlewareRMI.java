/**
 ** Title:                EtMiddlewareRMI.java
 ** Experimenting with RMI.
 ** Base example found here:
 ** http://yama-linux.cc.kagoshima-u.ac.jp/~yamanoue/researches/java/rmi-ex2/
 **/
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.net.*;

public class EtMiddlewareRMI extends java.rmi.server.UnicastRemoteObject
		implements ReceiveMessageInterface {
	
	int thisPort;
	String thisAddress;
	Registry registry; // rmi registry for lookup the remote objects.
	private String msg = "hello";
	
	public String echoMsg(String msg) throws RemoteException {
		System.out.println("Got: [" + msg + "]");
		return msg;
	}

	// This method is called from the remote client by the RMI.
	// This is the implementation of the “ReceiveMessageInterface”.
	public void receiveMessage(String x) throws RemoteException {
		System.out.println(x);
	}
	
	public String say() throws RemoteException {
		return msg;
	}

	public EtMiddlewareRMI() throws RemoteException {
		try {
			// get the address of this host.
			thisAddress = (InetAddress.getLocalHost()).toString();
		} catch (Exception e) {
			throw new RemoteException("can't get inet address.");
		}
		thisPort = 3232; // this port(registry’s port)
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
		try {
			@SuppressWarnings("unused")
			EtMiddlewareRMI s = new EtMiddlewareRMI();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}

/*
 * import java.rmi.*; import java.rmi.registry.*; import java.rmi.server.*;
 * import java.net.*;
 * 
 * public class RmiServer extends java.rmi.server.UnicastRemoteObject implements
 * ReceiveMessageInterface { int thisPort; String thisAddress; Registry
 * registry; // rmi registry for lookup the remote objects.
 * 
 * // This method is called from the remote client by the RMI. // This is the
 * implementation of the “ReceiveMessageInterface”. public void
 * receiveMessage(String x) throws RemoteException { System.out.println(x); }
 * 
 * public RmiServer() throws RemoteException { try{ // get the address of this
 * host. thisAddress= (InetAddress.getLocalHost()).toString(); } catch(Exception
 * e){ throw new RemoteException("can't get inet address."); } thisPort=3232; //
 * this port(registry’s port)
 * System.out.println("this address="+thisAddress+",port="+thisPort); try{ //
 * create the registry and bind the name and object. registry =
 * LocateRegistry.createRegistry( thisPort ); registry.rebind("rmiServer",
 * this); } catch(RemoteException e){ throw e; } }
 * 
 * static public void main(String args[]) { try{ RmiServer s=new RmiServer(); }
 * catch (Exception e) { e.printStackTrace(); System.exit(1); } } }
 */

