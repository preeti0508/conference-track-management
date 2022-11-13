package com.task.contenttrackmanagement.types;

public enum SessionType {
    MORNING(540),
    LUNCH(720),
    AFTERNOON(780),
    NETWORKING(960);

    public int startTime;

    SessionType(int startTime) {
        this.startTime = startTime;
    }
}
