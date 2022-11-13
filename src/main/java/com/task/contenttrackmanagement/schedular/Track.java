package com.task.contenttrackmanagement.schedular;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<Session> sessions;

    public Track() {
        sessions = new ArrayList<>();
    }

    public void addSession(Session session){ sessions.add(session); }

    public List<Session> getSessions() {
        return sessions;
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
