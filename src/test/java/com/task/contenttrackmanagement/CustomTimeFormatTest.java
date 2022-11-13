package com.task.contenttrackmanagement;

import org.junit.jupiter.api.Test;


public class CustomTimeFormatTest {
    @Test
    public void testMinutesToDisplayTime() {
        assertEquals("01:00 AM", CustomTimeFormat.convertMinutesToDisplayTime(60));
        assertEquals("12:00 AM", CustomTimeFormat.convertMinutesToDisplayTime(0));
        assertEquals("12:00 PM", CustomTimeFormat.convertMinutesToDisplayTime(12 * 60));
        assertEquals("01:00 PM", CustomTimeFormat.convertMinutesToDisplayTime(13 * 60));
        assertEquals("11:59 PM", CustomTimeFormat.convertMinutesToDisplayTime(12 * 60 + 11 * 60 + 59));
    }

}
