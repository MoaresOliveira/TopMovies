package io.github.moaresoliveira.services;

import io.github.moaresoliveira.util.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class ImdbApi {

    private String API_KEY = System.getenv("API_KEY");
    private String language = "pt-br";
    private String URL = "https://imdb-api.com/"+language+"/API/Top250Movies/"+ API_KEY;
    private String url = "https://alura-filmes.herokuapp.com/conteudos";

    public void call() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(API_KEY);
        List<Map<String, String>> listaDeFilmes = JsonParser.parse(body);
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("\u001b[0mTitulo:\u001b[1m " + filme.get("title"));
            System.out.println("\u001b[0mPoster:\u001b[1m " + filme.get("image"));
            System.out.println("\u001b[0mClassificação:\u001b[1m " + filme.get("imDbRating"));
            System.out.println("\u001b[33m\u001b[40m" + estrelas(filme.get("imDbRating"))+"\u001b[0m");
            System.out.println();
        }

    }

    private static String estrelas(String rating){
        Double classified = Double.parseDouble(rating);
        String estrelas = "";
        for (int i = 0; i < classified; i++) {
            estrelas += '\u1234';
        }
        return estrelas;
    }


}
