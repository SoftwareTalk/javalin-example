package dev.softwaretalk.examples.javalin;

import dev.softwaretalk.examples.javalin.controller.GreetingController;
import dev.softwaretalk.examples.javalin.service.quote.QuoteController;
import dev.softwaretalk.examples.javalin.service.quote.SupportedQuote;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinServerConfig {

    private final Javalin app = Javalin.create()
            .routes(() -> {
                path("/greeting", () -> {
                    post("/", GreetingController::generateGreeting);
                    get("/hi", GreetingController::sayHi);
                });
            })
            .routes(() -> {
                path("/quote", () -> {
                    get("/", QuoteController::randomQuote);
                    get("/" + SupportedQuote.FRIENDS, QuoteController::frieds);
                    get("/" + SupportedQuote.HIMYM, QuoteController::himym);
                    get("/" + SupportedQuote.HARRY_POTTER, QuoteController::harryPotter);
                });
            });

    public void start(int port) {
        app.start(port);
    }

    public void stop() {
        app.stop();
    }
}
