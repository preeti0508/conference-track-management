package com.task.contenttrackmanagement.scheduler;

import java.util.List;

import static com.task.contenttrackmanagement.types.CTMConstants.NEW_LINE;

/**
 * This class maintains the number of Tracks
 *
 * @author Preeti Verma
 */
public record Conference(List<Track> tracks) {

    public void addTrack(Track track) {
        tracks.add(track);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < tracks.size(); i++) {
            str.append("Track ").append(i + 1).append(":").append(NEW_LINE);
            str.append(tracks.get(i));
        }
        return str.toString();
    }
}