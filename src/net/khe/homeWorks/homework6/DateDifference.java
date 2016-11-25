package net.khe.homeWorks.homework6;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by hyc on 2016/11/16.
 */
public class DateDifference {
    public static int dateDifference(Date date1,Date date2){
        long time = date2.getTime()-date1.getTime();
        double day = (double)time/1000.0/3600.0/24.0;
        return Math.round((float) day);
    }

    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime()+2000000000L);
        DateFormat format = DateFormat.getDateInstance();
        String date1Str = format.format(date1);
        String date2Str = format.format(date2);
        System.out.printf("%s - %s = ",date2Str,date1Str);
        System.out.println(dateDifference(date1,date2));
    }
}
