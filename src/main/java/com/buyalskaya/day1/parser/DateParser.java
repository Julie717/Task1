package com.buyalskaya.day1.parser;

import com.buyalskaya.day1.entity.DateYearMonth;
import com.buyalskaya.day1.exception.InputDataFormatException;
import com.buyalskaya.day1.validator.DateValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {
    private static final String CHECK_DATE = "(0?[1-9]|[12]\\d|3[01])[\\./](0?[1-9]|1[0-2])[\\./](\\d{1,4})";
    public static final String EXCEPTION_CAPTION_INCORRECT_DATA = "This date is incorrect";

    public DateYearMonth dateParser(String date) throws InputDataFormatException{
        DateValidator dateValidator = new DateValidator();
        if (dateValidator.validateStringDate(date)) {
            Pattern pattern = Pattern.compile(CHECK_DATE);
            Matcher matcher = pattern.matcher(date);
            matcher.find();
            int year = Integer.parseInt(matcher.group(3));
            int month = Integer.parseInt(matcher.group(2));
            DateYearMonth dateYearMonth = new DateYearMonth(year, month);
            return dateYearMonth;
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_DATA);
        }
    }
}
