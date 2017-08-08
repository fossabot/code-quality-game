# Code Quality Game [![Build Status](https://travis-ci.org/mechero/code-quality-game.svg?branch=master)](https://travis-ci.org/mechero/code-quality-game)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bhttps%3A%2F%2Fgithub.com%2Fricardogarfe%2Fcode-quality-game.svg?type=shield)](https://app.fossa.io/projects/git%2Bhttps%3A%2F%2Fgithub.com%2Fricardogarfe%2Fcode-quality-game?ref=badge_shield)
A simple gamified web to improve code quality using SonarQube. 

## Introduction
This is a (micro) web page that shows a ranking of developers by the quantity of technical debt they are fixing in SonarQube. It encourages a 'nice competition' and tries to solve one of the main problems of fixing legacy code: **it's boring**. 

You can find more information about the goal of this project in [my blog post](https://maceroblog.wordpress.com/2015/06/23/a-gamification-experiment-with-sonarqube/)

## Requirements
* Java 1.8+
* Maven: it's needed only to build the project, later you can deploy directly the jar file.
* A SonarQube server to connect to. The application is tested with version 5.2.
  * You may need to create a user in SonarQube for this application to connect (if your server doesn't provide anonymous access). 

## Configuration
First you'll need to list the users that are going to participate in the game. This is done through the `users.xml` file.
```xml
<user id="pauldark" alias="Paul Dark" team="Team Alpha" />
```
It's important that the `id` matches with the SonarQube username. The `alias` will be used for the rankings and the `team` is used for aggregated Ranking per teams. 

In case your Sonarqube server doesn´t have anonymous access you need to specify credentials for accessing the API. You can create an user with basic permissions for that.

```
# Sample credentials for accessing the API
sonarUser=cqgameUser
sonarPassword=cqgam3
```

Given that this application does not have memory it will use only the issues existing in Sonar. This is why I recommend you to extend the time window to delete old issues in Sonar (Project Settings -> General -> Database Cleaner -> 'Delete closed issues after' = 90). All the points/badges obtained will belong to that period of time, this is good to promote 'continuous fixing'.

### Legacy Date
This application is intended to be used for fixing Legacy Code (old, ugly, error-prone). To avoid giving points for fixing recent violations you can configure the maximum date that you are considering for Legacy Code within the configuration. 

## How to play
The application looks for issues assigned to every user and it assign points for them once they are resolved. So playing is easy:
* Ensure that the code you're going to refactor is covered by Unit Tests.
* Assign to you in SonarQube the different issues that you're going to fix.
* Fix the issues! Once the code is reviewed with Sonar the issue will become Resolved and you will obtain points for that.

## Badges
This is a work in progress, some things should be improved. Right now there are two sample badges that you can win. One is related with the date in which you start playing, if you are an early adopter you will obtain some extra points (obviously you will lose them after the SonarQube issue cleaner comes into play). The second one is related with the Unit Test Coverage and there are different ranges. Explore the code to know more about them.


## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bhttps%3A%2F%2Fgithub.com%2Fricardogarfe%2Fcode-quality-game.svg?type=large)](https://app.fossa.io/projects/git%2Bhttps%3A%2F%2Fgithub.com%2Fricardogarfe%2Fcode-quality-game?ref=badge_large)