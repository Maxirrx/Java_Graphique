package fsiAdministration.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAlerte implements Initializable {
    @FXML
    private Text alerte;
    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
    public void setErreurcode(int erreurcode) {
        switch(erreurcode){
            case 1:
                alerte.setText("Les données fournis ne sont pas les bonnes");
                break;
            case 2:
                alerte.setText("tout les champs ne sont pas remplis");
                break;

        }
    }

}

