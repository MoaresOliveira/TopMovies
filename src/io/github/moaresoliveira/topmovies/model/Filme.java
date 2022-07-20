package io.github.moaresoliveira.topmovies.model;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        this.setImage(filme.get("image"));
        this.setRating(filme.get("imDbRating"));
    }

    public String getStarRating(){
        String estrelas = "";
        for (int i = 0; i < rating; i++) {
            estrelas += "⭐";
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
        Pattern pattern = Pattern.compile("(@)(\\S{1,})(.jpg)");
        Matcher matcher = pattern.matcher(image);
        if(matcher.find()){
            this.image = matcher.replaceFirst("$1$3");
        }
        this.image = image.replaceAll("@\\S{1,}.jpg","@.jpg");
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = Double.parseDouble(rating);
    }
}

