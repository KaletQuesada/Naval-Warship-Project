package com.mycompany.thebattleships;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class PlayScreen extends Controllers {

    @FXML
    private ChoiceBox <String> difficultyChoiceBox;

    @FXML
    public void initialize(){
        ObservableList<String> options = FXCollections.observableArrayList(
                "Easy",
                "Medium",
                "Hard"
        );
        difficultyChoiceBox.setItems(options);
    }

    @Override
    @FXML
    public void backButton() throws IOException{
        App.setRoot("TitleScreen");
    }
}