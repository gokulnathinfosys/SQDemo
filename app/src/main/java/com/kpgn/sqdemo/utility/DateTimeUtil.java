package com.kpgn.sqdemo.utility;

import java.text.DateFormat;
import java.util.Date;

public class DateTimeUtil {

    public String getFormattedDateTime(Date date) {
        try {
            return DateFormat.getDateInstance().format(date);
        } catch (Exception e) {
            return "";
        }
    }
}
