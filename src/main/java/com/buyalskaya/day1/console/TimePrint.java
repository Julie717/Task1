package com.buyalskaya.day1.console;

import com.buyalskaya.day1.entity.Time;

public class TimePrint {

    public void printTime(Time time, int seconds) {
        System.out.printf("%d seconds = %2d:%2d:%2d",
                seconds,
                time.getHour(),
                time.getMinute(),
                time.getSecond());
    }
}
