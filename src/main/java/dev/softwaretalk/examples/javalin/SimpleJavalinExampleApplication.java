package dev.softwaretalk.examples.javalin;

public class SimpleJavalinExampleApplication {

    public static void main(String[] args) {
        new JavalinServerConfig().start(7000);
    }
}