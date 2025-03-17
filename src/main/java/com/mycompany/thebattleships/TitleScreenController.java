/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.thebattleships;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author nilo
 */
public class TitleScreenController implements Initializable {

    @FXML
    public void exitGame(){
        Platform.exit();
    }

    @FXML
    public void buttonAboutUs() throws IOException {
        App.setRoot("AboutUsScreen");
    }

    @FXML
    public void buttonPlay() throws IOException{
        App.setRoot("PlayScreen");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
