package com.task.contenttrackmanagement.schedular;

import com.task.contenttrackmanagement.types.SessionType;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private List<Talk> talks;

    private int remainingDuration;

    private SessionType sessionType;

    public Session(int remainingDuration, SessionType sessionType) {
        this.sessionType = sessionType;
        this.remainingDuration = remainingDuration;
        talks = new ArrayList<>();
    }

    public Session(List<Talk> talks, int remainingDuration, SessionType sessionType) {
        this.talks = talks;
        this.remainingDuration = remainingDuration;
        this.sessionType = sessionType;
    }

    public List<Talk> getTalks() {
        return talks;
    }
    public void addTalk(Talk talk) {
        if (remainingDuration < talk.duration()) {
            throw new IllegalStateException("Not enough room in this slot to fit the event: '"
                    + talk.title() + "'");
        }
        talks.add(talk);
        remainingDuration -= talk.duration();
    }

    public boolean ifTalkFits(Talk talk) { return remainingDuration >= talk.duration(); }

    @Override
    public String toString() {
        StringBuilder printStr = new StringBuilder();

        for (Talk talk : talks) {
            printStr.append(talk);
        }

        return printStr.toString();
    }

    public SessionType getSessionType() {
        return sessionType;
    }
}
