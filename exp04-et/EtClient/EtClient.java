/**
 ** Title:                EtClient.java
 **
 **/

import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;

public class EtClient
{
    static public void main(String args[])
    {
       ReceiveMessageInterface rmiServer;
       Registry registry;
       
       String serverAddress=args[0];
       String serverPort=args[1];
       String text=args[2];
       
       /*
       String serverAddress="192.168.13.100";
       String serverPort="3232";
       String text="TEST from RMI Client";
       */
       System.out.println("sending "+text+" to "+serverAddress+":"+serverPort);
       try{
           // get the registry 
           registry=LocateRegistry.getRegistry(
               serverAddress,
               (new Integer(serverPort)).intValue()
           );
           // look up the remote object
           rmiServer=
              (ReceiveMessageInterface)(registry.lookup("rmiServer"));
           // call the remote method
           // rmiServer.receiveMessage(text);
           System.out.println("Echo back:[" + rmiServer.echoMsg(text) + "]");
       }
       catch(RemoteException e){
           e.printStackTrace();
       }
       catch(NotBoundException e){
           e.printStackTrace();
       }
    }
}

