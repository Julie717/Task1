package com.buyalskaya.day1.entity;

import java.util.StringJoiner;

public class DateYearMonth {
    private int year;
    private int month;

    public DateYearMonth() {
    }

    public DateYearMonth(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        DateYearMonth dateYearMonth = (DateYearMonth) obj;
        return ((dateYearMonth.year == year) && (dateYearMonth.month == month));
    }

    @Override
    public int hashCode() {
        return (int) (31 * year + month);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DateYearMonth.class.getSimpleName() + "[", "]")
                .add("year=" + year)
                .add("month=" + month)
                .toString();
    }
}
