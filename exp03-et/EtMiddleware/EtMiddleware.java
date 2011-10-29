/**
 ** Title:                EtMiddleware.java
 **
 **/

import java.net.*;
import java.io.*;

public class EtMiddleware extends Thread {
	protected Socket clientSocket;

	public static void main(String[] args) throws IOException {
		int middlewarePort = 31313;
		ServerSocket middlewareSocket = null;

		try {
			middlewareSocket = new ServerSocket(middlewarePort);
			System.out.println("EtMiddleware Socket Created");
			try {
				while (true) {
					System.out.println("Waiting for EtClient Connection");
					new EtMiddleware(middlewareSocket.accept());
				}
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
		} catch (IOException e) {
			System.err.println("Could not listen on port: [" + middlewarePort + "]");
			System.exit(1);
		} finally {
			try {
				middlewareSocket.close();
			} catch (IOException e) {
				System.err.println("Could not close port: [" + middlewarePort + "]");
				System.exit(1);
			}
		}
	}

	private EtMiddleware(Socket clientSoc) {
		clientSocket = clientSoc;
		start();
	}

	public void run() {
		System.out.println("New EtMiddleware Thread Started");

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
