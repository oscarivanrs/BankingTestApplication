package com.test.account.banking.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Dates {
    
    public static Date getDate(String date)
    {
        try {
			return (new SimpleDateFormat("yyyy-M-dd", Locale.ENGLISH)).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
            return null;
		}
    }

    public static String today()
    {
        return (new SimpleDateFormat("yyyy-MM-dd")).format( new Date());
    }
}
