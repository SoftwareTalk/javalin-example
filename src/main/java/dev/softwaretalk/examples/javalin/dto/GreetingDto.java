package dev.softwaretalk.examples.javalin.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GreetingDto {

    String greeting;
    String name;
}
