package hobby.siva.smsapplication.util;

import android.text.format.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 14/03/19
 */
public class TimeValidator {

    private static final String TIME_FORMAT = "h:mm aa";

    public static String getTimeStamp(long time){
        return (String) DateUtils.getRelativeTimeSpanString(time, System.currentTimeMillis(), DateUtils.HOUR_IN_MILLIS);
    }

    public static String getFormattedTime(long time){
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT, Locale.getDefault());
        return dateFormat.format(time);
    }

    public static boolean isToday(String time) {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        Calendar messageTime = Calendar.getInstance();
        messageTime.setTimeInMillis(Long.parseLong(time));
        messageTime.set(Calendar.HOUR_OF_DAY, 0);
        messageTime.set(Calendar.MINUTE, 0);
        messageTime.set(Calendar.SECOND, 0);
        messageTime.set(Calendar.MILLISECOND, 0);
        return today.equals(messageTime);
    }
}