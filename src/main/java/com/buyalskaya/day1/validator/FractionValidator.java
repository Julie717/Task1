package com.buyalskaya.day1.validator;

public class FractionValidator {
    public static final double MIN_FRACTION = -50000;
    public static final double MAX_FRACTION = 50000;

    public boolean validateFraction(String number) {
        if (number == null) return false;
        try {
            double fraction = Double.parseDouble(number);
            return validateFraction(fraction);
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean validateFraction(double number) {
        return ((number >= MIN_FRACTION) && (number <= MAX_FRACTION));
    }
}
