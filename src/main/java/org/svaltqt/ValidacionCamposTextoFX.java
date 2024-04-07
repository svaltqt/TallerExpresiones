package org.svaltqt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ValidacionCamposTextoFX extends Application {
    private static Stage stg;

    public Stage getMainStage() {
        return stg;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/VentanaPrincipal.fxml"));
        primaryStage.setTitle("Biling Information");
        primaryStage.setScene((new Scene(root, 954, 488)));
        primaryStage.show();
    }

    public void changeScene(String fxml, Stage stage) throws IOException {

        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.setWidth(600);
        stg.setHeight(500);
        stg.getScene().setRoot(pane);

    }

    public static void main(String[] args) {
        launch();
    }

}