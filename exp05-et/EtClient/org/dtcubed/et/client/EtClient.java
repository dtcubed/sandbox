package org.dtcubed.et.client;

import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
import java.util.Scanner;

import org.dtcubed.et.clientservercommon.EtMessageInterface;

public class EtClient {

	// EtServer connection details.
	// private static String etServerIPAddress = ""; // Can be a hostname too.
	// private static String etServerPort = "";
	private static String etServerIPAddress = System
			.getenv("ET_SERVER_IP_ADDRESS");
	private static String etServerPort = System.getenv("ET_SERVER_PORT");

	// Components of an Expense message.
	// private static String account = "household"; // For portability between
	// MSFT and UNIX, all lower-case.
	private static String account = System.getenv("ET_ACCOUNT");
	private static String amount = ""; // Insist on 2 decimal places.
	private static String categoryCode = "000000000000000"; // "Uncategorized";
	private static String dateIncurred = ""; // Format: YYYYMMDD
	private static String note = "Maximum of 255 characters"; // Maximum: 255
	// characters.
	// Disallow any
	// downstream
	// delimiters.
	// private static String password = ""; // SHA-2 Hash of cleartext.
	private static String password = System.getenv("ET_ACCOUNT_PASSWORD");

	private static void printMenu() {

		String msg = "\n";

		msg += "-----------------------------------------------------\n";
		msg += "--------- Account Information -----------------------\n";
		msg += "-----------------------------------------------------\n";
		msg += "1) Account      : [" + account + "]\n";
		msg += "2) EtServer IP  : [" + etServerIPAddress + "]\n";
		msg += "3) EtServer Port: [" + etServerPort + "]\n";
		msg += "4) Password     : [" + password + "]\n";
		msg += "-----------------------------------------------------\n";
		msg += "--------- Expense Information------------------------\n";
		msg += "-----------------------------------------------------\n";
		msg += "a) Amount       : [" + amount + "]\n";
		msg += "c) Category Code: [" + categoryCode + "]\n";
		msg += "d) Date Incurred: [" + dateIncurred + "]\n";
		msg += "n) Note         : [" + note + "]\n";
		msg += "-----------------------------------------------------\n";
		msg += "e) EXIT         s) SUBMIT\n\n";
		msg += "Command         : ";

		System.out.print(msg);

	}

	private static void submitExpense() {

		EtMessageInterface etRmiServer;
		Registry registry;
		String msg = "\n";

		msg += "Sending: [" + note + "] To: [" + etServerIPAddress + ":"
				+ etServerPort + "]";

		System.out.println(msg);

		try {
			// get the registry
			registry = LocateRegistry.getRegistry(etServerIPAddress,
					(new Integer(etServerPort)).intValue());
			// look up the remote object
			etRmiServer = (EtMessageInterface) (registry.lookup("rmiServer"));
			// call the remote method
			System.out.println("Echo back:[" + etRmiServer.echoMsg(note) + "]");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		boolean debuggingThis = false;
		boolean keepGoing = true;
		char inputChar = 'x';
		Scanner scan = new Scanner(System.in);

		// Set values via Environment Variables if appropriate.

		do {

			printMenu();

			try {

				// Isolate and process the 1st character of input line.
				inputChar = scan.nextLine().charAt(0);

				if (debuggingThis)
					System.out.println("Processing character: [" + inputChar
							+ "]");

				switch (inputChar) {

				case '1':
					System.out.print("Account: ");
					account = scan.nextLine();
					break;
				case '2':
					System.out.print("EtServer IP: ");
					etServerIPAddress = scan.nextLine();
					break;
				case '3':
					System.out.print("EtServer Port: ");
					etServerPort = scan.nextLine();
					break;
				case '4':
					System.out.print("Password: ");
					password = scan.nextLine();
					break;
				case 'a':
				case 'A':
					System.out.print("Amount: ");
					amount = scan.nextLine();
					break;
				case 'c':
				case 'C':
					System.out.print("Category Code: ");
					categoryCode = scan.nextLine();
					break;
				case 'd':
				case 'D':
					System.out.print("Date Incurred: ");
					dateIncurred = scan.nextLine();
					break;
				case 'e':
				case 'E':
					System.out.print("\nBye Bye!\n");
					keepGoing = false;
					break;
				case 'n':
				case 'N':
					System.out.print("Note: ");
					note = scan.nextLine();
					break;
				case 's':
				case 'S':
					submitExpense();
					break;
				default:
					break;
				}

			} catch (StringIndexOutOfBoundsException ex) {

				// A do nothing exception handler.
				// If the user just hits "Enter", this code will be entered.
				;
			}

		} while (keepGoing);

	}
}
