package com.task.contenttrackmanagement.types;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

/**
 * Represents various application specific constants
 *
 * @author Preeti Verma
 */
public class CTMConstants {

    public static final String TALK_MINUTES = "min";
    public static final String TALK_LIGHTNING = "lightning";
    public static final String LIGHTNING_TALK_DURATION = "5";
    public static final String NEW_LINE = System.getProperty("line.separator");
    public static final Pattern INPUT_LINE_PATTERN = Pattern.compile("^(.+)\\s(\\d+)?\\s?((min)|(lightning))$");
    public static final int TALK_NAME_INDEX = 1;
    public static final int TALK_DURATION_INDEX = 2;
    public static final int TALK_DURATION_TYPE_INDEX = 3;
    public static final int MORNING_SESSION_DURATION = 180;
    public static final int MORNING_SESSION_START_TIME = 9 * 60;
    public static final int LUNCH_DURATION = 60;
    public static final int LUNCH_DURATION_START = 12 * 60;
    public static final int AFTERNOON_SESSION_DURATION = 240;
    public static final int AFTERNOON_SESSION_START_TIME = 1 * 60;

    public static final int MAX_TALK_DURATION = Collections.max(Arrays.asList(
            MORNING_SESSION_DURATION, AFTERNOON_SESSION_DURATION));

    public static final String LUNCH_TALK_NAME = "Lunch";
    public static final String NETWORKING_TALK_NAME = "Networking Event";
    public static final int NETWORKING_TALK_DURATION = 60;
    public static final int NETWORKING_SESSION_START_TIME = 16 * 60;   //4 PM


}
