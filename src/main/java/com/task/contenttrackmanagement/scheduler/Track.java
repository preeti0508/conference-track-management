package com.task.contenttrackmanagement.scheduler;

import java.util.ArrayList;
import java.util.List;

/**
 * This class maintains the number of sessions for Track
 *
 * @author Preeti Verma
 */
public class Track {

    private final List<Session> sessions;

    public Track() {
        sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    @Override
    public String toString() {
        StringBuilder printStr = new StringBuilder();

        for (Session session : sessions) {
            printStr.append(session);
        }
        return printStr.toString();
    }
}
