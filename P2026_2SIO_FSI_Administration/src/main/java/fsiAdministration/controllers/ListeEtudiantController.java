package fsiAdministration.controllers;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.DAO.EtudiantDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListeEtudiantController extends MenuController implements Initializable {
    @FXML
    private TableView<Etudiant> tvEtudiants;

    @FXML
    private TableColumn<Etudiant, String> tcNomEtud;

    @FXML
    private TableColumn<Etudiant, String> tcPrenomEtud;

    EtudiantDAO etudDAO = new EtudiantDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tcNomEtud.setCellValueFactory(new PropertyValueFactory<>("nomEtudiant"));
        tcPrenomEtud.setCellValueFactory(new PropertyValueFactory<>("prenomEtudiant"));

        ObservableList<Etudiant> mesEtud = FXCollections.observableArrayList(etudDAO.findAll());

        tvEtudiants.setItems(mesEtud);

    }

}
