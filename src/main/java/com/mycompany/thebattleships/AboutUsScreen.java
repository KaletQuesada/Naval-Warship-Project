package com.mycompany.thebattleships;

import javafx.fxml.FXML;

import java.io.IOException;

public class AboutUsScreen extends Controllers{

    @Override
    @FXML
    public void backButton() throws IOException {
        App.setRoot("TitleScreen");
    }
}