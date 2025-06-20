package fsiAdministration.controllers;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController {


    @FXML
    protected MenuItem bListeEtud, bAjouterEtud, bListeSection, bAjouterSection, bQuitter, bAccueil, bListeEtuSex, bListeCourSex, bAjouterCours, bListeCours;


    protected String nomduuser;


    public void setuti(String nom){
        this.nomduuser = nom;
    }

    @FXML
    public void bQuitterClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void bAccueilClick(ActionEvent event) {
        Stage StageAfermer = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
        StageAfermer.close();

        try {

            // Charger le fichier FXML pour la pop-up
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_accueil.fxml"));
            Parent root = fxmlLoader.load();

            // Obtenir le contrôleur de la nouvelle fenetre
            AccueilController accueilController = fxmlLoader.getController();
            accueilController.setuti(nomduuser);
            accueilController.setbienvenue();
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
    public void bListEtudClick(ActionEvent event) {
        Stage StageAfermer = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
        StageAfermer.close();

        try {


            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_liste_etudiant.fxml"));
            Parent root = fxmlLoader.load();


            // Obtenir le contrôleur de la nouvelle fenetre
            ListeEtudiantController listeEtudiantController = fxmlLoader.getController();
            listeEtudiantController.setuti(nomduuser);

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("Liste etudiant");
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
    public void bAjouterEtudClick(ActionEvent event) {
        Stage StageAfermer = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
        StageAfermer.close();

        try {


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_ajout_etudiant.fxml"));
            Parent root = fxmlLoader.load();


            // Obtenir le contrôleur de la nouvelle fenetre
            AjouterEtudiantController ajouterEtudiantController = fxmlLoader.getController();
            ajouterEtudiantController.setuti(nomduuser);

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("ajouter un etudiant");
            stage.setScene(new Scene(root));

            // Configurer la fenêtre en tant que modal
            stage.initModality(Modality.APPLICATION_MODAL);

            // Afficher la fenêtre et attendre qu'elle se ferme
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void bListeSectionClick(ActionEvent event) {
        Stage StageAfermer = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
        StageAfermer.close();

        try {


            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_liste_section.fxml"));
            Parent root = fxmlLoader.load();


            // Obtenir le contrôleur de la nouvelle fenetre
            ListeSectionController abc = fxmlLoader.getController();
            abc.setuti(nomduuser);

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("Liste Section");
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
    public void bAjouterSectionClick(ActionEvent event) {
        Stage StageAfermer = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
        StageAfermer.close();

        try {


            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_ajout_section.fxml"));
            Parent root = fxmlLoader.load();


            // Obtenir le contrôleur de la nouvelle fenetre
            AjoutSectionController abc = fxmlLoader.getController();
            abc.setuti(nomduuser);

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("Ajout Section");
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
    public void bListeEtuSexClick(ActionEvent event) {
        Stage StageAfermer = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
        StageAfermer.close();

        try {


            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_liste_etu_section.fxml"));
            Parent root = fxmlLoader.load();


            // Obtenir le contrôleur de la nouvelle fenetre
            ListeEtuSectionController abc = fxmlLoader.getController();
            abc.setuti(nomduuser);

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("Ajout Section");
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
    public void bListeCoursClick(ActionEvent event) {
        Stage StageAfermer = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
        StageAfermer.close();

        try {


            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_liste_cours.fxml"));
            Parent root = fxmlLoader.load();


            // Obtenir le contrôleur de la nouvelle fenetre
            ListeCoursController abc = fxmlLoader.getController();
            abc.setuti(nomduuser);

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("Ajout Section");
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
    public void bListeCourSexClick(ActionEvent event) {
        Stage StageAfermer = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
        StageAfermer.close();

        try {


            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_liste_cours_section.fxml"));
            Parent root = fxmlLoader.load();


            // Obtenir le contrôleur de la nouvelle fenetre
            ListeCourSectionController abc = fxmlLoader.getController();
            abc.setuti(nomduuser);

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("Ajout Section");
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
    public void bAjouterCoursClick(ActionEvent event) {
        Stage StageAfermer = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
        StageAfermer.close();

        try {


            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_ajout_cours.fxml"));
            Parent root = fxmlLoader.load();


            // Obtenir le contrôleur de la nouvelle fenetre
            AjouterCoursController abc = fxmlLoader.getController();
            abc.setuti(nomduuser);

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("Ajout Section");
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
    public void bAjouterSection(ActionEvent event) {
        Stage StageAfermer = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
        StageAfermer.close();

        try {


            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_ajout_section.fxml"));
            Parent root = fxmlLoader.load();


            // Obtenir le contrôleur de la nouvelle fenetre
            ListeCourSectionController abc = fxmlLoader.getController();
            abc.setuti(nomduuser);

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("Ajout Section");
            stage.setScene(new Scene(root));

            // Configurer la fenêtre en tant que modal
            stage.initModality(Modality.APPLICATION_MODAL);

            // Afficher la fenêtre et attendre qu'elle se ferme
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
