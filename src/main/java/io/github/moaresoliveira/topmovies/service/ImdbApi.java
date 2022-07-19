package io.github.moaresoliveira.topmovies.service;


import io.github.moaresoliveira.topmovies.model.Filme;
import io.github.moaresoliveira.topmovies.util.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.stream.Collectors;

public class ImdbApi {

    private final String API_KEY = System.getenv("API_KEY");
    private String URL = "https://imdb-api.com/en/API/Top250Movies/"+ API_KEY;
    private String url = "https://alura-filmes.herokuapp.com/conteudos";

    public List<Filme> call() {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String body = response.body();
        List<Filme> listaDeFilmes = JsonParser.parse(body).stream().map(Filme::new).collect(Collectors.toList());

        return listaDeFilmes;
    }

}
