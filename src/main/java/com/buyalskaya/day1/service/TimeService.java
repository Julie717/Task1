package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.Time;
import com.buyalskaya.day1.validator.TimeValidator;

public class TimeService {
    public static int SECONDS_IN_HOUR = 3600;
    public static int SECONDS_IN_MINUTE = 60;
    public static final String EXCEPTION_CAPTION_INCORRECT_TIME = "This time is incorrect";

    public Time calculateTime(int seconds) {
        TimeValidator timeValidation = new TimeValidator();
        if (timeValidation.validateSecond(seconds)) {
            int hour = seconds / SECONDS_IN_HOUR;
            int temp = seconds - hour * SECONDS_IN_HOUR;
            int minute = temp / SECONDS_IN_MINUTE;
            int second = temp - minute * SECONDS_IN_MINUTE;
            Time time = new Time(hour, minute, second);
            return time;
        } else {
            throw new NumberFormatException(EXCEPTION_CAPTION_INCORRECT_TIME);
        }
    }
}
