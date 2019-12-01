package in.co.sattamaster.ui.DateTime.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Converter {

    public static String formatDate(Date chosenDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd"); // Set your date format
        return sdf.format(chosenDate);
    }

    public static String humanDate(Date chosenDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM, yyy"); // Set your date format
        return sdf.format(chosenDate);
    }

    public static String formatTime(Calendar time){

        int hour = time.get(Calendar.HOUR_OF_DAY);
        int min = time.get(Calendar.MINUTE);
        boolean pm = false;

        String curTime = String.format("%02d:%02d", hour, min);


      /*  if(hour>12){
            pm = true;
            hour = hour + 12;
        } */

        return curTime;
    }

    public static String getHourCurrent(Calendar time){

        int hour = time.get(Calendar.HOUR);
        String am_pm;
        boolean pm = false;

        if (time.get(Calendar.AM_PM)==Calendar.PM){
            am_pm = " pm";
        } else {
            am_pm =  " am";

        }


      //  return pm ? hour +":"+"00"+":"+" PM" : hour +":"+"00"+":"+" AM";
        return hour +":"+"00"+ am_pm;

    }

    public static String getHourBefore(Calendar time){

        int hour = time.get(Calendar.HOUR);
        String am_pm;

       // int hour = 0;


        if (hour==0){
            hour = 11;
        } else if (hour==1){
            hour = 12;
        } else {
            hour--;
        }
        boolean pm = false;

        if (time.get(Calendar.AM_PM)==Calendar.PM){
            am_pm = " pm";
        } else {
            am_pm =  " am";

        }


       // return pm ? hour +":"+"00"+":"+" PM" : hour +":"+"00"+":"+" AM";

        return hour +":"+"00"+ am_pm;

    }

    public static String getHourNext(Calendar time){

        int hour = time.get(Calendar.HOUR);
       // int hour=0;
        String am_pm;

        if (hour==0){
            hour = 1;
        } else {
            hour++;
        }

        if (time.get(Calendar.AM_PM)==Calendar.PM){
            if (time.get(Calendar.AM_PM)==Calendar.PM && hour == 12){
                am_pm = " am";
            } else {
                am_pm =  " pm";
            }
        } else {
            if (time.get(Calendar.AM_PM)==Calendar.AM && hour == 12){
                am_pm = " pm";
            } else {
                am_pm =  " am";

            }
        }

        return hour +":"+"00"+ am_pm;

    }
}
