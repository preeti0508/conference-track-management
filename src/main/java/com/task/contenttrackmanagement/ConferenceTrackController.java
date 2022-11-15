package com.task.contenttrackmanagement;

import com.task.contenttrackmanagement.scheduler.Conference;
import com.task.contenttrackmanagement.scheduler.ConferenceScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Rest controller to process the request to manage the conference talks.
 *
 * @author Preeti Verma
 */
@RestController
@RequestMapping("/api/manage")
public class ConferenceTrackController {

    @Autowired
    private ConferenceScheduler conferenceScheduler;

    @PostMapping("/track")
    String manageTrack(@RequestBody String talkRequest) {
        List<String> talks = Arrays.stream(talkRequest.split("\n")).toList();
        Conference conference = conferenceScheduler.schedule(talks);
        return conference.toString();
    }
}

