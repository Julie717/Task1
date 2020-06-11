package com.buyalskaya.day1.exception;

public class InputDataFormatException extends Exception{
    public InputDataFormatException() {
    }

    public InputDataFormatException(String message) {
        super(message);
    }

    public InputDataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputDataFormatException(Throwable cause) {
        super(cause);
    }
}
