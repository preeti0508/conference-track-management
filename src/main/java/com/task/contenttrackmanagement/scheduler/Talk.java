package com.task.contenttrackmanagement.scheduler;

import com.task.contenttrackmanagement.types.CTMConstants;
import com.task.contenttrackmanagement.types.TalkType;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class represents the Talk which denote the desired event
 * Talk event will have a title, duration, talk type and talk time represented as minutes
 * associated with it
 *
 * @author Preeti Verma
 */
public record Talk(String title, int duration, TalkType talkType, int talkTime){

    /**
     * This method generates the desired talk output format
     *
     * @return this Talk event detailed as per time its scheduled
     */
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

    /**
     * This method format the talk start time
     * @return this return the talk event scheduled time
     */
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

    /**
     * This method append the talk whether its in min or lightining
     * @return the appended string with min or lightning
     */
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
