package dev.softwaretalk.examples.javalin.dto;


import lombok.Value;

@Value
public class QuoteDto {
    String from;
    String quote;
}
