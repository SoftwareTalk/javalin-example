package dev.softwaretalk.examples.javalin;

import dev.softwaretalk.examples.javalin.dto.GreetingDto;
import kong.unirest.HttpStatus;
import kong.unirest.Unirest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingControllerTest {

    private static final JavalinServerConfig SERVER = new JavalinServerConfig();

    @BeforeAll
    public static void init() {
        SERVER.start(1234);
    }

    @Test
    public void returnsHiForSimpleGet() {
        var response = Unirest.get(serverUrl() + "/hi").asString();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.OK);

        assertThat(response.getBody())
                .isEqualTo("Hi!");
    }

    @Test
    public void greetingWillBeGeneratedFromBackend() {
        var response = Unirest.post(serverUrl())
                .body(GreetingDto.builder()
                        .greeting("What's up")
                        .name("SoftwareTalk"))
                .asString();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.OK);

        assertThat(response.getBody())
                .isEqualTo("What's up, SoftwareTalk!");
    }

    private String serverUrl() {
        return "http://localhost:1234/greeting";
    }

    @AfterAll
    public static void shutdown() {
        SERVER.stop();
    }

}