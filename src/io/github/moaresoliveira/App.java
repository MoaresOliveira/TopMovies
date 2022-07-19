package io.github.moaresoliveira;

import io.github.moaresoliveira.services.ImdbApi;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        ImdbApi api = new ImdbApi();
        api.call();
    }
}
