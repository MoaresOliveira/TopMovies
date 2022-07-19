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
import java.util.Map;
import java.util.stream.Collectors;

public class ImdbApi {

    private String API_KEY = System.getenv("API_KEY");
    private String URL = "https://imdb-api.com/en/API/Top250Movies/"+ API_KEY;
    private String url = "https://alura-filmes.herokuapp.com/conteudos";

    public void call() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(API_KEY);
        List<Filme> listaDeFilmes = JsonParser.parse(body).stream().map(Filme::new).collect(Collectors.toList());
        for (Filme filme : listaDeFilmes) {
            System.out.println("\u001b[0mTitulo:\u001b[1m " + filme.getTitle());
            System.out.println("\u001b[0mPoster:\u001b[1m " + filme.getImage());
            System.out.println("\u001b[0mClassificação:\u001b[1m " + filme.getRating());
            System.out.println("\u001b[33m\u001b[40m" + filme.getStarRating()+"\u001b[0m");
            System.out.println();
        }

    }


}
