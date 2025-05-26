package fsiAdministration.controllers;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.BO.Section;
import fsiAdministration.DAO.SectionDAO;
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

public class ListeSectionController extends MenuController implements Initializable {

    @FXML
    private TableView<Section> tvSections;

    @FXML
    private TableColumn<Section, String> tcNomSection;

    @FXML
    private TableColumn<Section, String> voirSection;

    SectionDAO sexDAO = new SectionDAO();


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        tcNomSection.setCellValueFactory(new PropertyValueFactory<>("libelleSection"));
        voirSection.setCellValueFactory(new PropertyValueFactory<>("idSection"));

        ObservableList<Section> mesSex = FXCollections.observableArrayList(sexDAO.findAll());

        tvSections.setItems(mesSex);

    }
}
