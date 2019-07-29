package com.production.outlau.codenamesti.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class TimeCard {

//    String timeZone = "GMT+1";

    String datetime;
    Date date;
    public TimeCard(String datetime){
        this.datetime = datetime;
        this.date = setDate(datetime);
    }

    public String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        return sdf.format(date);
    }

    public String getTimeString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        return sdf.format(date);
    }

    public Date getDate(){ return date; }

    private Date setDate(String datetime){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//            sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
            return sdf.parse(datetime);
        } catch (ParseException e){
            System.out.println("UH OH");
        }
        return null;
    }

}
