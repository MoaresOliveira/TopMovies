package io.github.moaresoliveira.topmovies.services;

import io.github.moaresoliveira.topmovies.model.Conteudo;

import java.util.List;

public interface ApiParser {

    List<Conteudo> parse(String json);

}
