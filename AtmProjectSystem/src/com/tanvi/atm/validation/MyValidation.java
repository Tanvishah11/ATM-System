package com.tanvi.atm.validation;

import java.util.HashSet;
import java.util.Set;

public class MyValidation {
	
	public static boolean isValidCardNumber(String cardNo) {
        return cardNo.length() == 16 && cardNo.matches("\\d+"); // Check if it's 16 digits and numeric
    }

    // Function to validate PIN length
    public static boolean isValidPIN(String cardPin) {
        return cardPin.length() == 4 && cardPin.matches("\\d+"); // Check if it's 4 digits and numeric
    }    
    public static boolean hasUniqueDigits(String cardPin) {
        Set<Character> digitSet = new HashSet<>();

        for (char digit : cardPin.toCharArray()) {
            if (!digitSet.add(digit)) {
                return false; // Repeated digit
            }
        }

        return true; // All digits are unique
    }


}
