package fsiAdministration.controllers;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.DAO.EtudiantDAO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.security.auth.callback.LanguageCallback;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class AccueilController extends MenuController implements Initializable {

    @FXML
    private Label idbv;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    public void setbienvenue() {
        idbv.setText("BIENVENUE " + nomduuser);

    }
}
