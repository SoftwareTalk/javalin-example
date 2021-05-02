package dev.softwaretalk.examples.javalin.controller;

import dev.softwaretalk.examples.javalin.dto.GreetingDto;
import dev.softwaretalk.examples.javalin.service.GreetingService;
import io.javalin.http.Context;

public class GreetingController {

    private static GreetingService SERVICE_INSTANCE;

    public static void sayHi(Context ctx) {
        ctx.result(service().sayHi());
    }

    public static void generateGreeting(Context ctx) {
        GreetingDto greeting = ctx.bodyAsClass(GreetingDto.class);
        ctx.result(service().generateGreeting(greeting));
    }

    private static GreetingService service() {
        if (SERVICE_INSTANCE == null) {
            SERVICE_INSTANCE = new GreetingService();
        }
        return SERVICE_INSTANCE;
    }
}
