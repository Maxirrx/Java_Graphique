package fsiAdministration.controllers;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.BO.Section;
import fsiAdministration.DAO.EtudiantDAO;
import fsiAdministration.DAO.SectionDAO;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListeEtuSectionController  extends MenuController implements Initializable {

    @FXML
    private TableView<Etudiant> tvEtudiants;

    @FXML
    private TableColumn<Etudiant, String> tcNomPrenomEtud;

    @FXML
    private TableColumn<Etudiant, String> tcSection;

    EtudiantDAO etudDAO = new EtudiantDAO();
    SectionDAO sectionDAO = new SectionDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Etudiant> etudiants = etudDAO.findAll();
        ObservableList<Etudiant> mesEtud = FXCollections.observableArrayList(etudiants);

        tcNomPrenomEtud.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getNomEtudiant() + " " + cellData.getValue().getPrenomEtudiant()
                )
        );

        tcSection.setCellValueFactory(cellData -> {
            int idSec = cellData.getValue().getIdSection();
            Section sec = sectionDAO.find(idSec);
            return new ReadOnlyStringWrapper(sec.getLibelleSection());
        });

        tvEtudiants.setItems(mesEtud);

    }
}
