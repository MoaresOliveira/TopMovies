package io.github.moaresoliveira.topmovies.controller;

import io.github.moaresoliveira.topmovies.model.Filme;
import io.github.moaresoliveira.topmovies.service.ImdbApi;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class MovieListController {
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vBox;
    @FXML
    private BorderPane borderPane;

    @FXML
    protected void buscar() {
        this.scrollPane.setFitToHeight(true);
        this.scrollPane.prefWidthProperty().bind(borderPane.widthProperty());
        this.scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.vBox.prefWidthProperty().bind(scrollPane.widthProperty());
        ImdbApi api = new ImdbApi();
        List<Filme> filmes = api.call();
        for (Filme filme : filmes) {
            this.vBox.getChildren().add(getFilme(filme));
        }

    }

    private HBox getFilme(Filme filme){
        Insets padding = new Insets(10);
        Image image = new Image(filme.getImage());
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        Label title = getLabel(filme.getTitle());
        title.setWrapText(true);
        Label year = getLabel(filme.getYear());
        VBox vBox1 = new VBox(title,year);
        vBox1.setAlignment(Pos.TOP_CENTER);
        vBox1.setPadding(padding);
        vBox1.setPrefWidth(250);
        Label rating = getLabel("imDbRating: "+ filme.getRating().toString());
        Label starRating = getLabel(filme.getStarRating());
        starRating.setTextFill(Color.DARKGOLDENROD);
        VBox vBox2 = new VBox(rating,starRating);
        vBox2.setAlignment(Pos.TOP_CENTER);
        vBox2.setPadding(padding);
        HBox pane = new HBox(imageView,vBox1,vBox2);
        pane.setPadding(padding);
        pane.setLayoutX(0);
        return pane;
    }

    private Label getLabel(String string){
        Font fonte = new Font("Arial", 14);
        Label label = new Label(string);
        label.setFont(fonte);
        return label;
    }
}