package fsiAdministration.controllers;

import fsiAdministration.BO.Cours;
import fsiAdministration.BO.Etudiant;
import fsiAdministration.DAO.CoursDAO;
import fsiAdministration.DAO.EtudiantDAO;
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

        ObservableList<Cours> mescours = FXCollections.observableArrayList(coursDAO.findAll());

        tvCours.setItems(mescours);

        tvCours.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Cours coursclick = tvCours.getSelectionModel().getSelectedItem();
                if (coursclick != null) {

                    Stage currentStage = (Stage) tvCours.getScene().getWindow();
                    redirigerVersCours(coursclick, currentStage);

                }
            }
        });
    }

    private void redirigerVersCours(Cours cours, Stage currentStage) {
        currentStage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_cours.fxml"));
            Parent root = loader.load();

            PageCoursController controller = loader.getController();
            controller.setCours(cours);

            Stage stage = new Stage();
            stage.setTitle("Détail cours");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
