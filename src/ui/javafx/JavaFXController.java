package ui.javafx;

import be.Item;
import bll.Game;
import enums.Command;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ui.UI;

public class JavaFXController implements Initializable, UI {  //needs refactoring :)
    //IDEA: txf view right click menu (observe/drop/consume etc. - requires more access to data?)
    @FXML
    private TextArea txaConsole;
    @FXML
    private TextField txfInput;
    @FXML
    private ListView<Item> lsvInventory;
    @FXML
    private Label lblRoomName;
    @FXML
    private ListView<String> lsvRoomItems;
    @FXML
    ListView<String> lsvExits;


    Game game;

    @FXML
    private void enterInput(KeyEvent key)
    {
        if (key.getCode() == KeyCode.ENTER)
        {
            sendInput();
        }
    }

    private void sendInput()
    {
        game.execute();
        txfInput.setText("");
        displayGUIData();
    }

    private void displayGUIData()
    {
        lblRoomName.setText("Room: [" + game.getCurrentRoomName() + "]");
        lsvRoomItems.setItems(FXCollections.observableArrayList(game.getCurrentRoomItems().stream().map(Item::getName).toList()));
        lsvInventory.setItems(FXCollections.observableArrayList(game.getPlayerInventory()));
        lsvExits.setItems(FXCollections.observableArrayList(game.getExitDirections()));
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
        displayGUIData();
    }
}
