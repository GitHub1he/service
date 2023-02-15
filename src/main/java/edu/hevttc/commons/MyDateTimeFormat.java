package edu.hevttc.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateTimeFormat {

    private static SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Date stringToDate(String strDate){
        Date date=null;
        try {
            date=sdf1.parse(strDate);
        } catch (ParseException e) {
            try {
                date= sdf2.parse(strDate);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return date;
    }

    public static String dateToString(Date date){
        return sdf1.format(date);
    }

    public static String dateTimeToString(Date date){
        return sdf2.format(date);
    }
}

