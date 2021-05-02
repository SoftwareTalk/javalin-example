package dev.softwaretalk.examples.javalin.service.quote.impl;

import com.github.javafaker.HowIMetYourMother;
import dev.softwaretalk.examples.javalin.dto.QuoteDto;
import dev.softwaretalk.examples.javalin.service.quote.QuoteProvider;
import dev.softwaretalk.examples.javalin.service.quote.SupportedQuote;

public class HimymQuote implements QuoteProvider {

    private final SupportedQuote quote;

    public HimymQuote() {
        quote = SupportedQuote.HIMYM;
    }

    @Override
    public QuoteDto createQuote() {
        return new QuoteDto(quote.getFrom(), ((HowIMetYourMother) quote.getInstance()).quote());
    }
}
