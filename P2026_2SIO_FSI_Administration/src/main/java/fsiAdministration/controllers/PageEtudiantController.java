package fsiAdministration.controllers;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.DAO.CoursDAO;
import fsiAdministration.DAO.EtudiantDAO;
import fsiAdministration.DAO.SectionDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PageEtudiantController extends MenuController implements Initializable {

    private Etudiant etu;

    @FXML
    private Text nom, prenom, datedenaissance, section, cours;

    @FXML
    private Button bmodif, bsupp;
    SectionDAO sectionDAO = new SectionDAO();
    EtudiantDAO etudiantDAO = new EtudiantDAO();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void setEtudiant(Etudiant e) {
        this.etu = e;
        Afficherlesdonnee(etu);
    }

    public void Afficherlesdonnee(Etudiant e) {
        nom.setText(e.getNomEtudiant());
        prenom.setText(e.getPrenomEtudiant());
        section.setText(sectionDAO.find(e.getIdSection()).getLibelleSection());
        datedenaissance.setText(String.valueOf(e.getDatedenaissance()));


    }



    @FXML
    public void bmodifclick(ActionEvent event) {
        Stage stagea = (Stage) nom.getScene().getWindow();
        stagea.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/page_modif_etudiant.fxml"));
            Parent root = loader.load();

            ModifEtudiantController controller = loader.getController();
            controller.setlesdonne(etu);

            Stage stage = new Stage();
            stage.setTitle("Modifier l'étudiant");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void bsuppclick(ActionEvent event) {
        etudiantDAO.delete(etu);
        Stage currentStage = (Stage) nom.getScene().getWindow();
        currentStage.close();

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
}

