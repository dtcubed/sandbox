package org.dtcubed.et;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;

import org.dtcubed.et.EtCrypto;

public class EtClient {

	// EtServer connection details.
	private static String etServerIPAddress = System.getenv("ET_SERVER_IP_ADDRESS");
	private static String etServerPort = System.getenv("ET_SERVER_PORT");

	// Components of an Expense message. 
	// For portability between MSFT and UNIX, all lower-case.
	private static String account = System.getenv("ET_ACCOUNT");
	// Insist on 2 decimal places.
	private static String amount = ""; 
	// "Uncategorized";
	private static String categoryCode = "000000000000000"; 
	// Format: YYYYMMDD
	private static String dateIncurred = ""; 	
	// Maximum of 255 characters. Dis-allow any downstream delimiters.
	private static String note = "Maximum of 255 characters"; 
	// SHA-2 Hash of cleartext.
	private static String password = System.getenv("ET_ACCOUNT_PASSWORD");

	private static void printMenu() {

		String msg = "\n";

		msg += "-----------------------------------------------------\n";
		/*
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
		*/
		msg += "n) Note         : [" + note + "]\n";
		msg += "-----------------------------------------------------\n";
		msg += "e) EXIT         s) SUBMIT\n";
		msg += "y) SHA-1 Note   z) Encrypt Note\n";
		msg += "Command         : ";

		System.out.print(msg);

	}

	private static void submitExpense() {

		EtMessageInterface etRmiServer;
		Registry registry;
		String expenseMessage = "";
		String msg = "\n";
		
		expenseMessage += account + "," + password + "," + amount + ",";
		expenseMessage += dateIncurred + "," + categoryCode + "," + note;
		
		// Contruct a "special" message to cause the Server side to exit.
		if (note.compareTo("STOP") == 0) {
			
			expenseMessage = "STOP";
		}

		msg += "Sending : [" + expenseMessage + "]\nTo: [" + etServerIPAddress + ":"
				+ etServerPort + "]";

		System.out.println(msg);

		try {
			// get the registry
			registry = LocateRegistry.getRegistry(etServerIPAddress,
					(new Integer(etServerPort)).intValue());
			// look up the remote object
			etRmiServer = (EtMessageInterface) (registry.lookup("rmiServer"));
			// call the remote method
			System.out.println("Received: [" + etRmiServer.processMessage(expenseMessage) + "]");
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		} 
		catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		boolean debuggingThis = false;
		boolean keepGoing = true;
		char inputChar = 'x';
		Scanner scan = new Scanner(System.in);
		String tempRetValue = "";

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
				case 'y':
				case 'Y':
					tempRetValue = EtCrypto.sha1digest(note);
					System.out.print("\nSHA1: [" + tempRetValue + "]\n");
					break;
				case 'z':
				case 'Z':
			        String passphrase = "The quick brown fox jumped over the lazy brown dog";
					tempRetValue = EtCrypto.p2chex(passphrase, note);	
					System.out.print("\nP2C: [" + tempRetValue + "]\n");
					tempRetValue = EtCrypto.chex2p(passphrase, tempRetValue);
					System.out.print("\nPlaintext: [" + tempRetValue + "]\n");					
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
