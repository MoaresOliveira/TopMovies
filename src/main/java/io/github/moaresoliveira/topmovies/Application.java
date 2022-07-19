package io.github.moaresoliveira.topmovies;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("movie-list.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        URL url = Application.class.getResource("imdb.png");
        Image image = new Image(url.toString());
        stage.setResizable(false);
        if(!image.isError()){
            stage.getIcons().add(image);
        }
        stage.setTitle("Top 250 Movies");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}