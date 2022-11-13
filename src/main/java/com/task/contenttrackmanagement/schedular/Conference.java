package com.task.contenttrackmanagement.schedular;

import java.util.List;

import static com.task.contenttrackmanagement.types.CTMConstants.NEW_LINE;
import static com.task.contenttrackmanagement.types.CTMConstants.NEW_LINE_BEGIN;


public record Conference(List<Track> tracks) {
    public Conference(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < tracks.size(); i++) {
            str.append(NEW_LINE_BEGIN + " Track " + (i + 1) +":"+ NEW_LINE);
            str.append(tracks.get(i));
        }
        return str.toString();
    }
}