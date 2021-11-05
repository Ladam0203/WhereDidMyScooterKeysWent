package ui.javafx;

import bll.Game;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.lang.management.BufferPoolMXBean;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ui.UI;

public class JavaFXController implements Initializable, UI { //should implement UI
    @FXML
    TextArea txaConsole;
    @FXML
    TextField txfInput;

    Game game;

    @FXML
    private void sendInput(KeyEvent key)
    {
        if (key.getCode() == KeyCode.ENTER)
        {
            game.execute();
            txfInput.setText("");
        }
    }

    @Override
    public String acquireNextInputLine() {
        return txfInput.getText();
    }

    @Override
    public void displayNextOutputLine(String outputline) {
        txaConsole.setText("-" + outputline + "\n");
    }

    @Override
    public void displayError(String inputline) {
        txaConsole.setText("-" + inputline + "\n");
    }

    @Override
    public void exitEnvironment() {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = new Game(this);
        game.start();
    }
}
