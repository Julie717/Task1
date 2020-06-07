package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.DateYearMonth;
import com.buyalskaya.day1.entity.Month;
import com.buyalskaya.day1.validator.DateValidator;

public class DateService {
    public static final String EXCEPTION_CAPTION_INCORRECT_DATE = "This date is incorrect";

    public int amountOfDaysInMonth(DateYearMonth dateYearMonth) {
        DateValidator dateValidation = new DateValidator();
        if (dateValidation.validateYearMonth(dateYearMonth)) {
            int year = dateYearMonth.getYear();
            int month = dateYearMonth.getMonth();
            int days = 0;
            for (Month m : Month.values()) {
                if (m.ordinal() == month - 1) {
                    days = m.getAmountOfDays();
                }
            }
            if (month == 2 && isLeapYear(year)) {
                days++;
            }
            return days;
        } else {
            throw new NumberFormatException(EXCEPTION_CAPTION_INCORRECT_DATE);
        }
    }

    private boolean isLeapYear(int year) {
        return ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)));
    }

}

