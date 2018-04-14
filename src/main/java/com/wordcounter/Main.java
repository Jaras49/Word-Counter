package com.wordcounter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Main extends Application {

    private static final String APP_VERSION = "WordCounterApp 0.5v";
    private static Stage primaryStage;

    private static void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }

    public static Stage getStage() {
        return Main.primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../resources/GUI/MainWindow.fxml"));
        setPrimaryStage(primaryStage);
        Parent root = loader.load();

        primaryStage.setTitle(APP_VERSION);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setOpacity(0.9);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
