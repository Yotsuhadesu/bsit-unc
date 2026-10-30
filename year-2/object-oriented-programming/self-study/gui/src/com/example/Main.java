package com.example;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();   // root node
        // add a scene, pass the root node as a parameter to the scene
        Scene scene = new Scene(root, Color.BLACK);  // pass in a background color

        // set the logo
        Image icon = new Image(getClass().getResourceAsStream("/com/example/ojosama.jpg"));  
        stage.getIcons().add(icon);
        // set a title for the stage
        stage.setTitle("Ojou-sama, it's time to go to bed.");

        // set dimensions for the stage
        stage.setWidth(480);
        stage.setHeight(480);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Are you using your phone again?");

        stage.setScene(scene);
        stage.show();   // shows the stage
    }
}