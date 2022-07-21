package io.github.moaresoliveira.topmovies.services;

import io.github.moaresoliveira.topmovies.model.Filme;
import io.github.moaresoliveira.topmovies.util.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ClienteHttp {

    public static String requestData(String url) {

        try {

            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
