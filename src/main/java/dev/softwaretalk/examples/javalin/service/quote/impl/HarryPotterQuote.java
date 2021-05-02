package dev.softwaretalk.examples.javalin.service.quote.impl;

import com.github.javafaker.HarryPotter;
import dev.softwaretalk.examples.javalin.dto.QuoteDto;
import dev.softwaretalk.examples.javalin.service.quote.QuoteProvider;
import dev.softwaretalk.examples.javalin.service.quote.SupportedQuote;

public class HarryPotterQuote implements QuoteProvider {

    private final SupportedQuote quote;

    public HarryPotterQuote() {
        quote = SupportedQuote.HARRY_POTTER;
    }

    @Override
    public QuoteDto createQuote() {
        return new QuoteDto(quote.getFrom(), ((HarryPotter) quote.getInstance()).quote());
    }
}
