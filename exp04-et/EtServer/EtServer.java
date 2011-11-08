/**
 ** Title:                EtServer.java
 **
 **/

import java.net.*;
import java.io.*;

public class EtServer extends Thread {
        protected Socket clientSocket;

        public static void main(String[] args) throws IOException {
                int serverPort = 31313;
                ServerSocket serverSocket = null;

                try {
                        serverSocket = new ServerSocket(serverPort);
                        System.out.println("EtServer Socket Created");
                        try {
                                while (true) {
                                        System.out.println("Waiting for EtClient Connection");
                                        new EtServer(serverSocket.accept());
                                }
                        } catch (IOException e) {
                                System.err.println("Accept failed.");
                                System.exit(1);
                        }
                } catch (IOException e) {
                        System.err.println("Could not listen on port: [" + serverPort + "]");
                        System.exit(1);
                } finally {
                        try {
                                serverSocket.close();
                        } catch (IOException e) {
                                System.err.println("Could not close port: [" + serverPort + "]");
                                System.exit(1);
                        }
                }
        }

        private EtServer(Socket clientSoc) {
                clientSocket = clientSoc;
                start();
        }

        public void run() {
                System.out.println("New EtServer Thread Started");

                try {
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(
                                        clientSocket.getInputStream()));

                        String inputLine;

                        while ((inputLine = in.readLine()) != null) {
                                System.out.println("Server: " + inputLine);
                                out.println(inputLine);

                                if (inputLine.equals("BYE"))
                                        break;
                        }

                        out.close();
                        in.close();
                        clientSocket.close();
                } catch (IOException e) {
                        System.err.println("Problem with Communication Server");
                        System.exit(1);
                }
        }
}
