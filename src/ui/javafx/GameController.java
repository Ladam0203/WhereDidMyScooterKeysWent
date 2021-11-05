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

public class GameController implements UI { //should implement UI
    @FXML
    TextArea txaConsole;
    @FXML
    TextField txfInput;

    @Override
    public String acquireNextInputLine() {
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void displayNextOutputLine(String outputline) {
        txaConsole.appendText(outputline);
    }

    @Override
    public void displayError(String inputline) {

    }

    @Override
    public void exitEnvironment() {

    }
}
