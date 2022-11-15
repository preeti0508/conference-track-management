package com.task.contenttrackmanagement;

import com.task.contenttrackmanagement.scheduler.Conference;
import com.task.contenttrackmanagement.scheduler.ConferenceScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Conference Management System</h1>
 * This is the main class it accepts the request and
 * send it to the Conference Track controller
 *
 * @author Preeti Verma
 */
@SpringBootApplication
public class CTMApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("CTMApplication");
		SpringApplication.run(CTMApplication.class, args);


		List<String> input = new ArrayList<>();

		input.add(">  Writing Fast Tests Against Enterprise Rails 180min");
		input.add(">  Ruby Errors from Mismatched Gem Versions 120min");
		input.add(">  Common Ruby Errors 60min");
		/*input.add(">  Rails for Python Developers lightning");
		input.add(">  Communicating Over Distance 60min");
		input.add(">  Accounting-Driven Development 45min");
		input.add(">  Woah 30min");
		input.add(">  Sit Down and Write 30min");
		input.add(">  Pair Programming vs Noise 45min");
		input.add(">  Rails Magic 60min");
		input.add(">  Ruby on Rails: Why We Should Move On 60min");
		input.add(">  Clojure Ate Scala (on my project) 45min");
		input.add(">  Programming in the Boondocks of Seattle 30min");
		input.add(">  Ruby vs. Clojure for Back-End Development 30min");
		input.add(">  Ruby on Rails Legacy App Maintenance 60min");
		input.add(">  A World Without HackerNews 30min");
		input.add(">  User Interface CSS in Rails Apps 30min");*/

		ConferenceScheduler	 scheduler = new ConferenceScheduler();

		Conference conference = scheduler.schedule(input);

		System.out.println(conference);
	}
}
