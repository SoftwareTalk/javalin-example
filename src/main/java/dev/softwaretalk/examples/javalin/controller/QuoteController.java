package dev.softwaretalk.examples.javalin.controller;

import dev.softwaretalk.examples.javalin.dto.QuoteDto;
import dev.softwaretalk.examples.javalin.service.quote.QuoteProvider;
import dev.softwaretalk.examples.javalin.service.quote.SupportedQuote;
import dev.softwaretalk.examples.javalin.service.quote.impl.FriedsQuote;
import dev.softwaretalk.examples.javalin.service.quote.impl.HarryPotterQuote;
import dev.softwaretalk.examples.javalin.service.quote.impl.HimymQuote;
import io.javalin.http.Context;

import java.util.EnumMap;
import java.util.List;
import java.util.Random;

public class QuoteController {

    private static final EnumMap<SupportedQuote, QuoteProvider> supportedProvider;
    private static final List<SupportedQuote> VALUES = List.of(SupportedQuote.values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    static {
        //this can be refactored to initialize all Impls of QuoteProvider by searching in CP
        supportedProvider = new EnumMap<>(SupportedQuote.class);
        supportedProvider.put(SupportedQuote.FRIENDS, new FriedsQuote());
        supportedProvider.put(SupportedQuote.HIMYM, new HimymQuote());
        supportedProvider.put(SupportedQuote.HARRY_POTTER, new HarryPotterQuote());
    }

    public static void randomQuote(Context ctx) {
        ctx.json(quote(VALUES.get(RANDOM.nextInt(SIZE))));
    }

    public static void frieds(Context ctx) {
        ctx.json(quote(SupportedQuote.FRIENDS));
    }

    public static void himym(Context ctx) {
        ctx.json(quote(SupportedQuote.HIMYM));
    }

    public static void harryPotter(Context ctx) {
        ctx.json(quote(SupportedQuote.HARRY_POTTER));
    }

    private static QuoteDto quote(SupportedQuote quote) {
        return supportedProvider.get(quote).createQuote();
    }
}
