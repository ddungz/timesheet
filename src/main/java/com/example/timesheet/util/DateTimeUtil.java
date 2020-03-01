package com.example.timesheet.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateTimeUtil {

    public static String formatDate(String dateStr, String fromFormat, String toFormat) throws ParseException {
        if(dateStr == null)
            throw new ParseException("Cannot parse null of a date string", 0);
        SimpleDateFormat formatter = new SimpleDateFormat(toFormat);
        Date date = new SimpleDateFormat(fromFormat).parse(dateStr);
        return formatter.format(date);
    }
}
