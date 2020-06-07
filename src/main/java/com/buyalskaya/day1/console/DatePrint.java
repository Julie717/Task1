package com.buyalskaya.day1.console;

import com.buyalskaya.day1.entity.DateYearMonth;

public class DatePrint {

    public void printDate(DateYearMonth dateYearMonth, int amountOfDays) {
        System.out.printf("%2d.%4d is %2d days\n", dateYearMonth.getMonth(),
                dateYearMonth.getYear(), amountOfDays);
    }
}
