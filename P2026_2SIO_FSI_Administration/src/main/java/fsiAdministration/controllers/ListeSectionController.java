package fsiAdministration.controllers;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.BO.Section;
import fsiAdministration.DAO.SectionDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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

        tvSections.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Section sectionclick = tvSections.getSelectionModel().getSelectedItem();
                if (sectionclick != null) {

                    Stage currentStage = (Stage) tvSections.getScene().getWindow();
                    redirigerVersSection(sectionclick, currentStage);

                }
            }
        });
    }
    private void redirigerVersSection(Section section, Stage currentStage) {
        currentStage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_section.fxml"));
            Parent root = loader.load();

            PageSectionController controller = loader.getController();
            controller.setSection(section);

            Stage stage = new Stage();
            stage.setTitle("Détail de l'étudiant");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
