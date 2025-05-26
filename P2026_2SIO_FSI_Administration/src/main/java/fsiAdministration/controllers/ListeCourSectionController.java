package fsiAdministration.controllers;

import fsiAdministration.BO.Cours;
import fsiAdministration.BO.Etudiant;
import fsiAdministration.BO.Section;
import fsiAdministration.DAO.CoursDAO;
import fsiAdministration.DAO.EtudiantDAO;
import fsiAdministration.DAO.SectionDAO;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListeCourSectionController  extends MenuController implements Initializable {

    @FXML
    private TableView<Cours> tvCoursSection;

    @FXML
    private TableColumn<Cours, String> tcCours;

    @FXML
    private TableColumn<Cours, String> tcSection;

    CoursDAO coursDAO = new CoursDAO();
    SectionDAO sectionDAO = new SectionDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Cours> cours = coursDAO.findAll();
        ObservableList<Cours> lescours = FXCollections.observableArrayList(cours);

        tcCours.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLibellecours()));

        tcSection.setCellValueFactory(cellData -> {
            int idSec = cellData.getValue().getIdsection();
            Section sec = sectionDAO.find(idSec);
            return new ReadOnlyStringWrapper(sec.getLibelleSection());
        });

        tvCoursSection.setItems(lescours);

    }
}
