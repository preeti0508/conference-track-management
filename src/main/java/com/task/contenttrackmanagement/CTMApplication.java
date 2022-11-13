package com.task.contenttrackmanagement;

import com.task.contenttrackmanagement.schedular.Conference;
import com.task.contenttrackmanagement.schedular.ConferenceScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CTMApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("CTMApplication");
		SpringApplication.run(CTMApplication.class, args);


		List<String> input = new ArrayList<>();

		input.add(">  Writing Fast Tests Against Enterprise Rails 60min");
		input.add(">  Overdoing it in Python 45min");
		input.add(">  Lua for the Masses 30min");
		input.add(">  Ruby Errors from Mismatched Gem Versions 45min");
		input.add(">  Common Ruby Errors 45min");
		input.add(">  Rails for Python Developers lightning");
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
		input.add(">  User Interface CSS in Rails Apps 30min");

		ConferenceScheduler	 scheduler = new ConferenceScheduler();

		Conference conference = scheduler.schedule(input);

		System.out.println(conference);
	}
}
