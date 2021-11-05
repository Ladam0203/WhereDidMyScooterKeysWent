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
    private Button btnNorth, btnEast, btnSouth, btnWest;


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

        if (game.getExitDirections().contains("north"))
            btnNorth.setDisable(false);
        else
            btnNorth.setDisable(true);
        if (game.getExitDirections().contains("east"))
            btnEast.setDisable(false);
        else
            btnEast.setDisable(true);
        if (game.getExitDirections().contains("south"))
            btnSouth.setDisable(false);
        else
            btnSouth.setDisable(true);
        if (game.getExitDirections().contains("west"))
            btnWest.setDisable(false);
        else
            btnWest.setDisable(true);
    }

    public void goNorth()
    {
        txfInput.setText(Command.GO + " north");
        sendInput();
    }
    public void goEast()
    {
        txfInput.setText(Command.GO + " east");
        sendInput();
    }
    public void goSouth()
    {
        txfInput.setText(Command.GO + " south");
        sendInput();
    }
    public void goWest()
    {
        txfInput.setText(Command.GO + " west");
        sendInput();
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
