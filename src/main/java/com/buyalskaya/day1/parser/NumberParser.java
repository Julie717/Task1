package com.buyalskaya.day1.parser;

import com.buyalskaya.day1.exception.InputDataFormatException;
import com.buyalskaya.day1.validator.FractionValidator;
import com.buyalskaya.day1.validator.NumberValidator;

public class NumberParser {
    public static final String EXCEPTION_CAPTION_INCORRECT_DATA = "These data are incorrect";

    public int integerParser(String number) throws InputDataFormatException {
        NumberValidator numberValidation = new NumberValidator();
        if (numberValidation.validateNumber(number)) {
            int numberInteger = Integer.parseInt(number);
            return numberInteger;
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_DATA);
        }
    }

    public int[] arrayIntegerParser(String... number) throws InputDataFormatException {
        int size = number.length;
        int[] numberInteger = new int[size];
        for (int i = 0; i < size; i++) {
            numberInteger[i] = integerParser(number[i]);
        }
        return numberInteger;
    }

    public double doubleParser(String number) throws InputDataFormatException {
        FractionValidator fractionValidator = new FractionValidator();
        if (fractionValidator.validateFraction(number)) {
            double numberDouble = Double.parseDouble(number);
            return numberDouble;
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_DATA);
        }
    }
}