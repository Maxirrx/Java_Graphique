package fsiAdministration.controllers;

import fsiAdministration.BO.Etudiant;
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

        tvEtudiants.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Etudiant etudiantclick = tvEtudiants.getSelectionModel().getSelectedItem();
                if (etudiantclick != null) {

                    Stage currentStage = (Stage) tvEtudiants.getScene().getWindow();
                    redirigerVersEtudiant(etudiantclick, currentStage);

                }
            }
        });
    }

    private void redirigerVersEtudiant(Etudiant etudiant, Stage currentStage) {
        currentStage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_etudiant.fxml"));
            Parent root = loader.load();

            PageEtudiantController controller = loader.getController();
            controller.setEtudiant(etudiant);

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
