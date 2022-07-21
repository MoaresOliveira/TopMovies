package io.github.moaresoliveira.topmovies;

import io.github.moaresoliveira.topmovies.model.Conteudo;
import io.github.moaresoliveira.topmovies.model.Filme;
import io.github.moaresoliveira.topmovies.services.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) {
//        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&count=15";
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        String json = ClienteHttp.requestData(url);
        ApiParser apiParser = new ImdbApiParser();//new NasaApiParser();
        List<Conteudo> conteudos = apiParser.parse(json);
        var stickerGenerator = new StickerGenerator();
        for (Conteudo conteudo : conteudos) {
            try {
                stickerGenerator.createSticker(new URL(conteudo.getUrlImage()).openStream(),conteudo.getTitle().replaceAll("\\r",""),conteudo.getTitle());
                System.out.println("\u001b[0mTitulo:\u001b[1m " + conteudo.getTitle());
                System.out.println("\u001b[0mImage:\u001b[1m " + conteudo.getUrlImage());
                System.out.println();
            } catch (IOException e) {
                continue;
            }


        }
    }
}
