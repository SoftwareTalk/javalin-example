package dev.softwaretalk.examples.javalin;

import dev.softwaretalk.examples.javalin.dto.QuoteDto;
import dev.softwaretalk.examples.javalin.service.quote.SupportedQuote;
import kong.unirest.HttpStatus;
import kong.unirest.Unirest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuoteControllerTest {

    private static final JavalinServerConfig SERVER = new JavalinServerConfig();

    @BeforeAll
    public static void init() {
        SERVER.start(4567);
    }

    @Test
    public void randomQuoteReturnsOneSupportedQuote() {
        var response = Unirest
                .get(serverUrl())
                .asObject(QuoteDto.class);

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.OK);

        var body = response.getBody();
        assertThat(body.getFrom())
                .satisfiesAnyOf(
                        s -> s.contains("Friends"),
                        s -> s.contains("How I Met Your Mother"),
                        s -> s.contains("Harry Potter")
                );

        assertThat(body.getQuote())
                .isNotBlank();
    }

    @Test
    public void friendsApiReturnFriendsQuote() {
        var response = Unirest
                .get(serverUrl() + "/" + SupportedQuote.FRIENDS)
                .asObject(QuoteDto.class);

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.OK);

        var body = response.getBody();
        assertThat(body.getFrom())
                .isEqualTo("Friends");

        assertThat(body.getQuote())
                .isNotBlank();
    }

    @Test
    public void himymApiReturnHimymQuote() {
        var response = Unirest
                .get(serverUrl() + "/" + SupportedQuote.HIMYM)
                .asObject(QuoteDto.class);

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.OK);

        var body = response.getBody();
        assertThat(body.getFrom())
                .isEqualTo("How I Met Your Mother");

        assertThat(body.getQuote())
                .isNotBlank();
    }

    @Test
    public void harryPotterApiReturnharryPotterQuote() {
        var response = Unirest
                .get(serverUrl() + "/" + SupportedQuote.HARRY_POTTER)
                .asObject(QuoteDto.class);

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.OK);

        var body = response.getBody();
        assertThat(body.getFrom())
                .isEqualTo("Harry Potter");

        assertThat(body.getQuote())
                .isNotBlank();
    }

    private String serverUrl() {
        return "http://localhost:4567/quote";
    }

    @AfterAll
    public static void shutdown() {
        SERVER.stop();
    }

}