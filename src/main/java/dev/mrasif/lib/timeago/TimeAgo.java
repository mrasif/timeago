package dev.mrasif.lib.timeago;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeAgo {

    /**
     *
     * @param past is a object of Date
     * @return string data
     */
    public static final String format(Date past){
        Date now=new Date();
        return past!=null?format(past,now):null;
    }

    /**
     *
     * @param parseFormat string simpleDateFormat
     * @param pastDate string timestamp
     * @return string result
     * @throws ParseException date parse exception
     */
    public static final String format(String parseFormat, String pastDate) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(parseFormat);
        Date past=simpleDateFormat.parse(pastDate);
        Date now=new Date();
        return past!=null?format(past,now):null;
    }

    /**
     *
     * @param parseFormat string simpleDateFormat
     * @param pastDate string timestamp
     * @param currentDate string timestamp
     * @return string result
     * @throws ParseException date parse exception
     */
    public static final String format(String parseFormat, String pastDate, String currentDate) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(parseFormat);
        Date past=simpleDateFormat.parse(pastDate);
        Date now=simpleDateFormat.parse(currentDate);
        return format(past,now);
    }

    /**
     *
     * @param past is a object of Date class
     * @param now is a object of Date class
     * @return string data
     */
    public static final String format(Date past, Date now) {
        if (past==null || now==null){
            return null;
        }
        long days= TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());
        long hours=TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
        long minutes=TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
        long ms=TimeUnit.MILLISECONDS.toMillis(now.getTime() - past.getTime());
        long seconds=ms/1000;
        String result=null;
        if (days>0 && days<30) {
            result=(days>1?days+" days ago":"yesterday");
        }
        else if(days>=30 && days<365){
            long months=(days/30);
            result=(months>1?months+" months ago":"a month ago");
        }
        else if(days>=365){
            long years=(days/365);
            result=(years>1?years+" years ago":"a year ago");
        }
        else if(days==0 && hours>0){
            result=(hours>1?hours+" hours ago":"an hour ago");
        }
        else if(hours==0 && minutes>0){
            result=(minutes>1?minutes+" minutes ago":"a minute ago");
        }
        else if(minutes==0 && seconds>0){
            result=(seconds>1?seconds+" seconds ago":"a second ago");
        }
        else{
            result="a moment ago";
        }
        return result;
    }
}
