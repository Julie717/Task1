package com.buyalskaya.day1.entity;

import java.util.StringJoiner;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Time time = (Time) obj;
        return ((time.hour == hour) &&
                (time.minute == minute) &&
                (time.second == second));
    }

    @Override
    public int hashCode() {
        return 31 * hour + minute + second;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Time.class.getSimpleName() + "[", "]")
                .add("hour=" + hour)
                .add("minute=" + minute)
                .add("second=" + second)
                .toString();
    }
}
