package dev.softwaretalk.examples.javalin.service.quote.impl;

import com.github.javafaker.Friends;
import dev.softwaretalk.examples.javalin.dto.QuoteDto;
import dev.softwaretalk.examples.javalin.service.quote.QuoteProvider;
import dev.softwaretalk.examples.javalin.service.quote.SupportedQuote;

public class FriedsQuote implements QuoteProvider {

    private final SupportedQuote quote;

    public FriedsQuote() {
        quote = SupportedQuote.FRIENDS;
    }

    @Override
    public QuoteDto createQuote() {
        return new QuoteDto(quote.getFrom(), ((Friends) quote.getInstance()).quote());
    }
}
