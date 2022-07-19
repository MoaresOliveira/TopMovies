package io.github.moaresoliveira.topmovies.model;

import java.util.Map;

public class Filme {

    private String title;
    private String year;
    private String image;
    private Double rating;

    public Filme() {
    }

    public Filme(Map<String, String> filme) {
        this.title = filme.get("title");
        this.year = filme.get("year");
        this.image = filme.get("image");
        this.setRating(filme.get("imDbRating"));
    }

    public String getStarRating(){
            String estrelas = "";
            for (int i = 0; i < rating; i++) {
                estrelas += "\uD83C\uDF1F";
            }
            return estrelas;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = Double.parseDouble(rating);
    }
}
