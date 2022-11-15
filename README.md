# Conference Track Management
RESTful service to manage the conference talks and arrange them in the tracks.

## Problem statement

You are planning a big programming conference and have received many proposals which
have passed the initial screen process but you're having trouble fitting them into the time
constraints of the day -- there are so many possibilities! So you write a program to do it for
you.
* The conference has multiple tracks each of which has a morning and afternoon session.
* Each session contains multiple talks.
* Morning sessions begin at 9am and must finish by 12 noon, for lunch.
* Afternoon sessions begin at 1pm and must finish in time for the networking event.
* The networking event can start no earlier than 4:00 and no later than 5:00.
* No talk title has numbers in it.
* All talk lengths are either in minutes (not hours) or lightning (5 minutes).
* Presenters will be very punctual; there needs to be no gap between sessions.
Note that depending on how you choose to complete this problem, your solution may give a
different ordering or combination of talks into tracks. This is acceptable; you don't need to
exactly duplicate the sample output given here.

### Test input:
```text
Writing Fast Tests Against Enterprise Rails 60min
Overdoing it in Python 45min
Lua for the Masses 30min
Ruby Errors from Mismatched Gem Versions 45min

Common Ruby Errors 45min
Rails for Python Developers lightning
Communicating Over Distance 60min
Accounting-Driven Development 45min
Woah 30min
Sit Down and Write 30min
Pair Programming vs Noise 45min
Rails Magic 60min
Ruby on Rails: Why We Should Move On 60min
Clojure Ate Scala (on my project) 45min
Programming in the Boondocks of Seattle 30min
Ruby vs. Clojure for Back-End Development 30min
Ruby on Rails Legacy App Maintenance 60min
A World Without HackerNews 30min
User Interface CSS in Rails Apps 30min
```
### Test output:
```text
Track 1:
09:00AM Writing Fast Tests Against Enterprise Rails 60min
10:00AM Overdoing it in Python 45min
10:45AM Lua for the Masses 30min
11:15AM Ruby Errors from Mismatched Gem Versions 45min
12:00PM Lunch
01:00PM Common Ruby Errors 45min
01:45PM Rails for Python Developers lightning
01:50PM Communicating Over Distance 60min
02:50PM Accounting-Driven Development 45min
03:35PM Woah 30min
04:05PM Sit Down and Write 30min
04:35PM Networking Event
Track 2:
09:00AM Pair Programming vs Noise 45min
09:45AM Rails Magic 60min
10:45AM Ruby on Rails: Why We Should Move On 60min
12:00PM Lunch
01:00PM Clojure Ate Scala (on my project) 45min
01:45PM Programming in the Boondocks of Seattle 30min
02:15PM Ruby vs. Clojure for Back-End Development 30min
02:45PM Ruby on Rails Legacy App Maintenance 60min
03:45PM A World Without HackerNews 30min
04:15PM User Interface CSS in Rails Apps 30min
04:45PM Networking Event
```

## Overview of Technical stack
* Java 17 
* Spring Boot 2.7.5
	- spring-boot-starter
	- spring-boot-starter-web
* Swagger 3.0.0
* Apache Maven

### REST Endpoint :
* POST `/api/manage/track` -  Endpoint is used to manage the conference talks. It takes conference talks as string and
returns conference tracks. To test this, copy the "test input" from above block and provide as a request body.

### Swagger UI
All endpoints can also be accessed using the swagger UI using any browser.
```
URL:
http://localhost:8080/swagger-ui/index.html
```

### Configurable Parameters
User can change the below configurable parameters using the `applicaiton.yml` file present in the `resources` directory

```
server:
  port: 8080
```

### Unit Test Cases
Implemented unit test cases to test the solution.

### How to start
If you want to start the application out of an IDE. Use `CTMApplication` to run the application.
