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
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PageSectionController  extends MenuController implements Initializable {

    private Section section;

    @FXML
    private Text nom;

    @FXML
    private Button bmodif, bsupp;

    SectionDAO sectionDAO = new SectionDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setSection(Section s) {
        this.section = s;
        Afficherlesdonnee(section);
    }

    public void Afficherlesdonnee(Section s) {
        nom.setText(s.getLibelleSection());



    }



    @FXML
    public void bmodifclick(ActionEvent event) {}

    @FXML
    public void bsuppclick(ActionEvent event) {
        sectionDAO.delete(section);
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
