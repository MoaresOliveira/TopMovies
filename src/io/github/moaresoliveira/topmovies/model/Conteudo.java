package io.github.moaresoliveira.topmovies.model;

public class Conteudo {

    private String title;
    private String urlImage;

    public Conteudo(String title, String urlImage) {
        this.title = title;
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlImage() {
        return urlImage;
    }
}
