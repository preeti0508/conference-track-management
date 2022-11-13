package com.task.contenttrackmanagement.schedular;

import com.task.contenttrackmanagement.types.SessionType;
import com.task.contenttrackmanagement.types.TalkType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.task.contenttrackmanagement.types.CTMConstants.*;

@Component
public class ConferenceScheduler {
    private static Logger logger = LoggerFactory.getLogger("ConferenceScheduler");
    private List<Track> tracks;

    public Conference schedule(List<String> input){
        tracks = new ArrayList<>();
        List<Talk> talks = new ArrayList<>();

        input.forEach((line) -> {
            Talk talk = TalkParser.parseInputLine(line.trim());
            if (talk != null) {
                talks.add(talk);
            }
        });

        Conference conference = new Conference(tracks);
        while (talks.size() != 0) {
            Session morningSession = new Session(MORNING_SESSION_DURATION, SessionType.MORNING);
            fillSessionWithTalks(morningSession, talks);

            Session lunchSession = new Session(LUNCH_DURATION, SessionType.LUNCH);
            lunchSession.addTalk(new Talk(LUNCH_TALK_NAME, LUNCH_DURATION, TalkType.NONE,
                    lunchSession.getSessionType().startTime));

            Session afternoonSession = new Session(AFTERNOON_SESSION_DURATION, SessionType.AFTERNOON);
            fillSessionWithTalks(afternoonSession, talks);

            Session networkSession = new Session(NETWORKING_TALK_DURATION, SessionType.NETWORKING);
            Talk networkingTalk = new Talk(NETWORKING_TALK_NAME, NETWORKING_TALK_DURATION,
                    TalkType.NETWORKING, networkSession.getSessionType().startTime);
            networkSession.addTalk(networkingTalk);

            Track track = new Track();
            track.addSession(morningSession);
            track.addSession(lunchSession);
            track.addSession(afternoonSession);
            track.addSession(networkSession);
            conference.addTrack(track);
        }

        logger.debug("Completed scheduling of talks.");

        return conference;
    }

    private void fillSessionWithTalks(Session session, List<Talk> talks) {
        int talkTime = session.getSessionType().startTime;
        for (Iterator<Talk> talkIterator = talks.iterator(); talkIterator.hasNext();) {
            Talk talk = talkIterator.next();
            if (session.ifTalkFits(talk)) {
                session.addTalk(new Talk(talk.title(), talk.duration(), talk.talkType(), talkTime));
                talkTime += talk.duration();
                talkIterator.remove();
            }
        }
    }
}
