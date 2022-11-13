package com.task.contenttrackmanagement.schedular;

import com.task.contenttrackmanagement.types.CTMConstants;
import com.task.contenttrackmanagement.types.TalkType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public record Talk(String title, int duration, TalkType talkType, int talkTime){

    @Override
    public String toString() {


        StringBuilder talkStr = new StringBuilder();

        talkStr
            .append("> ")
                .append(formattedTime())
                .append(title)
                .append(" ")
                .append(appendDuration())
                .append(CTMConstants.NEW_LINE);

        return talkStr.toString();
    }

//    private String formattedTime() {
//        Duration duration = Duration.ofMinutes(talkTime);
//        int hours = duration.toHoursPart();
//        int mins = duration.toMinutesPart();
//
//        if(hours > 12) {
//            return hours - 12 + ":" + mins + "PM ";
//        } else {
//            return hours + ":" + mins + "AM ";
//        }
//
//    }

    private String formattedTime() {
        DateFormat _sdf = new SimpleDateFormat("HH:mma ");
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.AM_PM, Calendar.AM);
            cal.set(Calendar.HOUR, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            cal.add(Calendar.MINUTE, talkTime);
            return _sdf.format(cal.getTime()).toUpperCase();
    }

    private String appendDuration() {
        StringBuilder durationStr = new StringBuilder();

        switch (talkType) {
            case NORMAL -> durationStr.append(duration).append(CTMConstants.TALK_MINUTES);
            case LIGHTENING -> durationStr.append(CTMConstants.TALK_LIGHTNING);
            default -> durationStr.append("");
        }

        return durationStr.toString();
    }
}
