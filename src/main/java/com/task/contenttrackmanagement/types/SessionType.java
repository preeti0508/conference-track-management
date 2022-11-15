package com.task.contenttrackmanagement.types;

/**
 * It represents the Session type
 *
 * @author Preeti Verma
 */
public enum SessionType {
    MORNING(540),
    LUNCH(720),
    AFTERNOON(780),
    NETWORKING(1020);

    public final int startTime;

    SessionType(int startTime) {
        this.startTime = startTime;
    }
}
