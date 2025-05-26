package fsiAdministration.controllers;

import fsiAdministration.BO.Cours;
import fsiAdministration.BO.Etudiant;
import fsiAdministration.DAO.CoursDAO;
import fsiAdministration.DAO.EtudiantDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;



public class ListeCoursController extends MenuController implements Initializable {

    @FXML
    private TableView<Cours> tvCours;

    @FXML
    private TableColumn<Cours, String> tclibCours;

    CoursDAO coursDAO = new CoursDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tclibCours.setCellValueFactory(new PropertyValueFactory<>("libellecours"));

        ObservableList<Cours> mesEtud = FXCollections.observableArrayList(coursDAO.findAll());

        tvCours.setItems(mesEtud);
    }
}
