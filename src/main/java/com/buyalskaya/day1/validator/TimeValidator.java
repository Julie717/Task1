package com.buyalskaya.day1.validator;

public class TimeValidator {
    public static final int MIN_SECOND = 0;
    public static final int MAX_SECOND = 60000;

    public boolean validateSecond(String second) {
        NumberValidator numberValidation = new NumberValidator();
        boolean isNumberSecond = numberValidation.validateNumber(second);
        boolean validateTime = false;
        if (isNumberSecond) {
            int secondInteger = Integer.parseInt(second);
            validateTime = validateSecond(secondInteger);
        }
        return validateTime;
    }

    public boolean validateSecond(int second) {
        return ((second >= MIN_SECOND) && (second <= MAX_SECOND));
    }
}
