package dev.softwaretalk.examples.javalin.service.quote;

import dev.softwaretalk.examples.javalin.dto.QuoteDto;

public interface QuoteProvider {

    QuoteDto createQuote();
}
