package dev.softwaretalk.examples.javalin.service.quote;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SupportedQuote {

    FRIENDS("Friends", new Faker().friends()),
    HIMYM("How I Met Your Mother", new Faker().howIMetYourMother()),
    HARRY_POTTER("Harry Potter", new Faker().harryPotter());

    private final String from;
    private Object instance;
}
