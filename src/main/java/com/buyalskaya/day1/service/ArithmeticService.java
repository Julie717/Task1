package com.buyalskaya.day1.service;

import com.buyalskaya.day1.exception.InputDataFormatException;
import com.buyalskaya.day1.validator.NumberValidator;

import static java.lang.Math.pow;

public class ArithmeticService {
    private static final String EXCEPTION_CAPTION_INCORRECT_NUMBER = "These data are incorrect";
    private static final int MIN_AMOUNT_OF_EVEN_NUMBERS = 2;

    public int lastDigitOfSquareNumber(int number) throws InputDataFormatException {
        NumberValidator numberValidation = new NumberValidator();
        if (numberValidation.validateNumber(number)) {
            int lastDigitOfSquareNumber = (int) pow(number, 2) % 10;
            return lastDigitOfSquareNumber;
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_NUMBER);
        }
    }

    public boolean isEven(int number) throws InputDataFormatException {
        NumberValidator numberValidation = new NumberValidator();
        if (numberValidation.validateNumber(number)) {
            return number % 2 == 0;
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_NUMBER);
        }
    }

    public boolean isEvenTwoNumbers(int... arrayNumber) throws InputDataFormatException {
        int amountOfEven = 0;
        for (int i = 0; i < arrayNumber.length; i++) {
            if (isEven(arrayNumber[i])) {
                amountOfEven = amountOfEven + 1;
            }
        }
        return amountOfEven >= MIN_AMOUNT_OF_EVEN_NUMBERS;
    }


    public int sumDivides(int number) throws InputDataFormatException {
        NumberValidator numberValidation = new NumberValidator();
        if (numberValidation.validatePositiveNumber(number)) {
            int sum = 1;
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    sum = sum + i;
                }
            }
            return sum;
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_NUMBER);
        }
    }

    public boolean isPerfectNumber(int number) throws InputDataFormatException {
        return sumDivides(number) == number;
    }
}
