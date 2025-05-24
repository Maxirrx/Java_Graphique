package fsiAdministration.controllers;

import fsiAdministration.BO.Section;
import fsiAdministration.DAO.SectionDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListeSectionController extends MenuController implements Initializable {

    @FXML
    private TableView<Section> tvSections;

    @FXML
    private TableColumn<Section, String> tcNomSection;

    @FXML
    private TableColumn<Section, String> voirSection;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SectionDAO sexDAO = new SectionDAO();
        List<Section> MesSections = sexDAO.findAll();
        ObservableList<Section> MesSectionsOL= FXCollections.observableArrayList(MesSections);
        tcNomSection.setCellValueFactory(cellData -> cellData.getValue().libelleSectionProperty());
        voirSection.setCellValueFactory(cellData -> cellData.getValue().libelleSectionProperty());

        tvSections.setItems(MesSectionsOL);

    }
}
