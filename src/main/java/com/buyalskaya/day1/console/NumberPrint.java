package com.buyalskaya.day1.console;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberPrint {

    public void printNumber(int number1, int number2, String caption) {
        System.out.println(caption + number1 + " is " + number2);
    }

    public void printNumber(double number, String caption) {
        System.out.printf(caption + " = %5.2", number);
    }

    public void printArrayAndBoolean(int[] numbers, boolean isTrue, String caption) {
        System.out.println(caption + "{" +
                Arrays.stream(numbers)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                "} is " + isTrue);
    }

    public void printNumberAndBoolean(int number, boolean isTrue, String caption) {
        System.out.println(caption + number + " is " + isTrue);
    }
}
