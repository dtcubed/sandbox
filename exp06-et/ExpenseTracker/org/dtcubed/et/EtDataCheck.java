package org.dtcubed.et;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EtDataCheck {
	
	public static boolean isValidAmount (String amount) {
		
		// Insist upon at least 1 digit in front of the decimal place
		// and exactly 2 digits after. This Java regex technique requires
		// 2 back slashes in front of the decimal point to indicate a
		// literal ".".
		Pattern amountPattern = Pattern.compile("^[0-9]{1,}\\.[0-9]{2}$");
		
		Matcher matcher = amountPattern.matcher(amount);
		
        // TODO: maybe, ensure that the amount is positive too?		
		return(matcher.matches());		
	}
	
	public static boolean isValidYYYYMMDD (String yyyymmdd) {
		
		// We are just doing a rough check right now.
		// TODO: If the rough regex check passes, go further and see that
		// we can successfully convert this to a Calendar object.
		// Therefore, we would ensure that the date is actually valid.
		Pattern yyyymmddPattern = Pattern.compile("^[1-3][0-9]{3}[0-1][0-9][0-3][0-9]$");
		
		Matcher matcher = yyyymmddPattern.matcher(yyyymmdd);
		
		return(matcher.matches());		
	}
}
