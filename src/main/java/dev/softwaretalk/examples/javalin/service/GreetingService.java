package dev.softwaretalk.examples.javalin.service;

import dev.softwaretalk.examples.javalin.dto.GreetingDto;

public class GreetingService {

    public String sayHi() {
        return "Hi!";
    }

    public String generateGreeting(GreetingDto greeting) {
        return greeting.getGreeting() + ", " + greeting.getName() + "!";
    }
}
