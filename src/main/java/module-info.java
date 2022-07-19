module io.github.moaresoliveira.topmovies {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.net.http;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.google.gson;

    opens io.github.moaresoliveira.topmovies to javafx.fxml;
    exports io.github.moaresoliveira.topmovies;
    exports io.github.moaresoliveira.topmovies.model;
    opens io.github.moaresoliveira.topmovies.model to javafx.fxml;
    exports io.github.moaresoliveira.topmovies.util;
    opens io.github.moaresoliveira.topmovies.util to javafx.fxml;
    exports io.github.moaresoliveira.topmovies.service;
    opens io.github.moaresoliveira.topmovies.service to javafx.fxml;
    exports io.github.moaresoliveira.topmovies.controller;
    opens io.github.moaresoliveira.topmovies.controller to javafx.fxml;
}