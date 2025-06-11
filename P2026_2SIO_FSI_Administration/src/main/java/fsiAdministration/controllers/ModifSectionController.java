package fsiAdministration.controllers;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.BO.Section;
import fsiAdministration.DAO.SectionDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ModifSectionController extends MenuController implements Initializable {

    private int idSection;

    @FXML
    private TextField tflibelle;
    @FXML
    private Button bRetour;


    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    public void bRetourClick(ActionEvent event) {
        Stage stagea = (Stage) bRetour.getScene().getWindow();
        stagea.close();


        try {

            // Charger le fichier FXML pour la pop-up
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_accueil.fxml"));
            Parent root = fxmlLoader.load();

            // Obtenir le contrôleur de la nouvelle fenetre
            AccueilController accueilController = fxmlLoader.getController();

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("Accueil FSI ADMINISTRATION");
            stage.setScene(new Scene(root));

            // Configurer la fenêtre en tant que modal
            stage.initModality(Modality.APPLICATION_MODAL);

            // Afficher la fenêtre et attendre qu'elle se ferme
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void bEnregistrerClick(ActionEvent event) {

        String nom= tflibelle.getText();


        if(!tflibelle.getText().isEmpty()) {
            Section newsex = new Section(idSection, nom);
            System.out.println("on est bon");

            SectionDAO sectionDAO = new SectionDAO();
            sectionDAO.update(newsex);
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/popup_alerte.fxml"));
                Parent root = loader.load();

                ControllerAlerte controller = loader.getController();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));

                stage.initModality(Modality.APPLICATION_MODAL);
                controller.setErreurcode(2);

                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Stage stagea = (Stage) bRetour.getScene().getWindow();
        stagea.close();


        try {

            // Charger le fichier FXML pour la pop-up
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_accueil.fxml"));
            Parent root = fxmlLoader.load();

            // Obtenir le contrôleur de la nouvelle fenetre
            AccueilController accueilController = fxmlLoader.getController();

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("Accueil FSI ADMINISTRATION");
            stage.setScene(new Scene(root));

            // Configurer la fenêtre en tant que modal
            stage.initModality(Modality.APPLICATION_MODAL);

            // Afficher la fenêtre et attendre qu'elle se ferme
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void bEffacerClick(ActionEvent event) {

        tflibelle.clear();
    }

    public void setlesdonne(Section section) {
        tflibelle.setText(section.getLibelleSection());
        this.idSection = section.getIdSection();


    }
}

