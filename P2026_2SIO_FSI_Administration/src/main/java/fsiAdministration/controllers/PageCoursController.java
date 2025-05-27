package fsiAdministration.controllers;

import fsiAdministration.BO.Cours;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PageCoursController  extends MenuController implements Initializable {

    Cours cours = new Cours();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setCours(Cours cours) {
        this.cours = cours;

    }

}
