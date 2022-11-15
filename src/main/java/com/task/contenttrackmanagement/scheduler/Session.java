package com.task.contenttrackmanagement.scheduler;

import com.task.contenttrackmanagement.types.SessionType;

import java.util.ArrayList;
import java.util.List;


/**
 * This class represents the session
 *
 * @author Preeti Verma
 */
public class Session {

    /**
     * Represents the list of talks
     */
    private List<Talk> talks;

    /**
     * Represents the remaining duration of current session
     */
    private int remainingDuration;
    /**
     * Represents the type of session
     */
    private SessionType sessionType;

    public Session(int remainingDuration, SessionType sessionType) {
        this.sessionType = sessionType;
        this.remainingDuration = remainingDuration;
        talks = new ArrayList<>();
    }

    public int getRemainingDuration() {
        return remainingDuration;
    }

    /**
     * This method add a talk to List of talks based on talk duration and session remaining duration
     *
     * @param talk represents the talk that has duration associated with it
     */
    public void addTalk(Talk talk) {
        if (remainingDuration < talk.duration()) {
            throw new IllegalStateException("Not enough room in this slot to fit the event: '"
                    + talk.title() + "'");
        }
        talks.add(talk);
        remainingDuration -= talk.duration();
    }

    /**
     * \
     * This method determines if the provided talk can fit in the current session
     *
     * @param talk Represents the talk that needs to fit in current session
     * @return This method return boolean where true indicates that talk can fit in session else talk does not fit in session
     */
    public boolean ifTalkFits(Talk talk) {
        return remainingDuration >= talk.duration();
    }

    @Override
    public String toString() {
        StringBuilder printStr = new StringBuilder();

        for (Talk talk : talks) {
            printStr.append(talk);
        }

        return printStr.toString();
    }

    /**
     * This method determines the current Session type
     *
     * @return this session type
     */
    public SessionType getSessionType() {
        return sessionType;
    }
}
