package io.github.moaresoliveira.topmovies;

import io.github.moaresoliveira.topmovies.services.ImdbApi;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        ImdbApi api = new ImdbApi();
        api.call();
    }
}
