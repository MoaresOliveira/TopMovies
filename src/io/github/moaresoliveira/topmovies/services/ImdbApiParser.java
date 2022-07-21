package io.github.moaresoliveira.topmovies.services;

import io.github.moaresoliveira.topmovies.model.Conteudo;
import io.github.moaresoliveira.topmovies.util.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbApiParser implements ApiParser {


    @Override
    public List<Conteudo> parse(String json){
        List<Map<String, String>> jsonList = JsonParser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> jsonItem: jsonList) {
            String titulo = jsonItem.get("title");
            String urlImagem =
                    jsonItem.get("image")
                            .replaceAll("(@+)(.*).jpg$","$1.jpg");

            var conteudo = new Conteudo(titulo,urlImagem);
            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
