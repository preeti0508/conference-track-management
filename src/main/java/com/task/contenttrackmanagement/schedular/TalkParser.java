package com.task.contenttrackmanagement.schedular;

import com.task.contenttrackmanagement.types.CTMConstants;
import com.task.contenttrackmanagement.types.TalkType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
public class TalkParser {
    private static Logger logger = LoggerFactory.getLogger("TalkParser");

    public static Talk parseInputLine(String line) {
        if (line.length() == 0) {
            return null;
        }

        Matcher match = CTMConstants.INPUT_LINE_PATTERN.matcher(line);
        if (match.find() == false) {
            logger.warn("Invalid input line: " + line);
            return null;
        }

        String name = match.group(CTMConstants.TALK_NAME_INDEX);
        name = name.replaceAll("> ","");
        String durationInString = match.group(CTMConstants.TALK_DURATION_INDEX);

        TalkType type;

        if (match.group(CTMConstants.TALK_DURATION_TYPE_INDEX).equalsIgnoreCase("min")) {
            type = TalkType.NORMAL;
        } else {
            type = TalkType.LIGHTENING;
            durationInString = CTMConstants.LIGHTNING_TALK_DURATION;
        }

        int duration = Integer.parseInt(durationInString);

        Talk talk = new Talk(name.trim(), duration, type, 0);
        if (talk.duration() > CTMConstants.MAX_TALK_DURATION) {
            logger.warn("Duration of talk '" + name + "' is more than the maximum duration"
                    + " allowed for an talk. Dropping this talk for scheduling.");
            return null;
        }

        return talk;
    }
}
