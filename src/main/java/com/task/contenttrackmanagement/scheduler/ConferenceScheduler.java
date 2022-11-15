package com.task.contenttrackmanagement.scheduler;

import com.task.contenttrackmanagement.types.SessionType;
import com.task.contenttrackmanagement.types.TalkType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.task.contenttrackmanagement.types.CTMConstants.*;

/**
 * This class is responsible for creating different sessions (Morning, Noon, Afternoon) and
 * fill various session with talks
 *
 * @author Preeti Verma
 */
@Component
public class ConferenceScheduler {
    private static Logger logger = LoggerFactory.getLogger("ConferenceScheduler");
    private List<Track> tracks;

    private int actualNetworkTalkStartTime;

    /**
     * This method takes the List of strings, create the sessions and fill
     * them with talks
     * @param input This represents the list of string consisting of talks
     * @return scheduled conference consisting of arranged talks
     */
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
            actualNetworkTalkStartTime = findActualNetworkEventStartTime(afternoonSession.getRemainingDuration(),
                    SessionType.NETWORKING);
            Talk networkingTalk = new Talk(NETWORKING_TALK_NAME, NETWORKING_TALK_DURATION,
                    TalkType.NETWORKING,actualNetworkTalkStartTime);
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

    /**\
     * This method find the start time for the Networking talk event
     * @param remainingDuration represent the leftover time in afternoon session
     * @param networkingTalk represent the default start time of networking talk
     * @return the actual time when networking talk is scheduled either at default 4 PM or 5 PM
     */
    private int findActualNetworkEventStartTime(int remainingDuration, SessionType networkingTalk) {
        int actualNetworkTalkStartTime = networkingTalk.startTime;
        if(remainingDuration <= 0)
            actualNetworkTalkStartTime = 1020;
        return actualNetworkTalkStartTime;
    }

    /**
     * This method fill the sessions - Morning or Afternoon with talks
     * based on duration
     * Internally the talk is instantiated with talk tile, duration, talk type and talktime
     * @param session represents the Morning or Afternoon session
     * @param talks represents the talks along with duration
     */
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
