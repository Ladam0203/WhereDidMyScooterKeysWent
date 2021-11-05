package ui.javafx;

import bll.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.UI;
import ui.console.Console;

import java.io.IOException;
import java.util.Objects;

public class JavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent loader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameView.fxml")));
        Stage stage = new Stage();
        stage.setTitle("Where did my scooter keys went?");
        stage.setScene(new Scene(loader));
        stage.show();
    }
}
