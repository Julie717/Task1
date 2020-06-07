package com.buyalskaya.day1.validator;

public class NumberValidator {
    public static final int MIN_NUMBER_INT = -50000;
    public static final int MAX_NUMBER_INT = 50000;

    public boolean validateNumber(String number) {
        if (number == null) return false;
        try {
            int numberInt = Integer.parseInt(number);
            return validateNumber(numberInt);
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean validateNumber(int number) {
        return ((number >= MIN_NUMBER_INT) && (number <= MAX_NUMBER_INT));
    }

    public boolean validatePositiveNumber(int number) {
        return ((number > 0) && (number <= MAX_NUMBER_INT));
    }

    public boolean validateNumber(String... number) {
        for (String num : number) {
            if (validateNumber(num) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean validateNumber(int... number) {
        for (Integer num : number) {
            if (validateNumber(num) == false) return false;
        }
        return true;
    }
}
