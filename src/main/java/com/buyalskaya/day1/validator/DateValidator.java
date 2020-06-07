package com.buyalskaya.day1.validator;

import com.buyalskaya.day1.entity.DateYearMonth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {
    private static final String CHECK_DATE = "(0?[1-9]|[12]\\d|3[01])[\\./](0?[1-9]|1[0-2])[\\./](\\d{1,4})";
    public static final int MIN_MONTH = 1;
    public static final int MAX_MONTH = 12;
    public static final int MIN_YEAR = 0;
    public static final int MAX_YEAR = 5000;

    public boolean validateStringDate(String date) {
        Pattern pattern = Pattern.compile(CHECK_DATE);
        Matcher matcher = pattern.matcher(date);
        return pattern.matches(CHECK_DATE, date);
    }

    public boolean validateYearMonth(DateYearMonth dateYearMonth) {
        int year = dateYearMonth.getYear();
        int month = dateYearMonth.getMonth();
        boolean validateYear = ((year >= MIN_YEAR) && (year <= MAX_YEAR));
        boolean validateMonth = ((month >= MIN_MONTH) && (month <= MAX_MONTH));
        return validateYear && validateMonth;
    }
}
