package com.consoleman.wavegen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/controller.fxml"));
        primaryStage.setTitle("Oscillator");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                launch(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}
