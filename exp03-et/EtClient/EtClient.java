/**
 ** Title:                EtClient.java
 **
 **/

import java.io.*;
import java.net.*;

public class EtClient {
	public static void main(String[] args) throws IOException {

		int middlewarePort = 31313;
		String hostToConnectTo = "127.0.0.1";

		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			echoSocket = new Socket(hostToConnectTo, middlewarePort);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket
					.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: [" + hostToConnectTo
					+ "]");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: ["
					+ hostToConnectTo + "]");
			System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(
				System.in));
		String userInput;

		System.out.println("Type Message (\"BYE\" to quit)");
		while ((userInput = stdIn.readLine()) != null) {
			out.println(userInput);

			// end loop
			if (userInput.equals("BYE"))
				break;

			System.out.println("echo: " + in.readLine());
		}

		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}
