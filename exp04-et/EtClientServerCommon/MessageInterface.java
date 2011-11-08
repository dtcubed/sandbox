import java.rmi.*;
public interface MessageInterface extends Remote
{
	String echoMsg(String msg) throws RemoteException;
    	void receiveMessage(String x) throws RemoteException;
    	String say() throws RemoteException;
}
