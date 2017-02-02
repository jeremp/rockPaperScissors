# Rock Paper Scissors

The [famous hand game](https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors)... in Java

## About the sources

* handsing-core : contains all the **business** code.
* handsign-web : a [Spring-Boot](https://projects.spring.io/spring-boot/) application to bundle the game into a Web Application.

You can implement your own version of this game by extending the *RuleEngine* class. The RockPaperScissorRuleEngine is provided, we could easily implements the [Rock-Paper-Scissors-Spock-Lizard](https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors#Additional_weapons) alternative by example.

## How to play ?

You have to build it from sources.

### Requirements 

* Java 8 (JDK)
* Maven 3.x

### how to build it ?

1. Clone this repository
2. Build the **handsign-core** project
. `cd rockPaperScissors/handsign-core`
. `mvn install` 
. The test coverage report is generated in *target/site/jacoco*
3. build the **handsign-web** project
. change directory to `rockPaperScissors\handsign-web`
. `mvn install` 
. the executable jar is generated into the *target* dir

### How to run it ?

1. Run `java -jar rps-web-0.0.1-SNAPSHOT.jar`
2. Open your favorite browser on http://localhost:8080  

> The server default port is *8080* but you can change it with the `-Dserver.port` option
> Example : `java -jar -Dserver.port=9000 rps-web-0.0.1-SNAPSHOT.jar`
