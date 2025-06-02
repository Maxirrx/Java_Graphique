package fsiAdministration.controllers;

import fsiAdministration.BO.Cours;
import fsiAdministration.BO.Etudiant;
import fsiAdministration.BO.Section;
import fsiAdministration.DAO.CoursDAO;
import fsiAdministration.DAO.SectionDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ModifCoursController extends MenuController implements Initializable {
    @FXML
    private TextField tflibelle, tfdesc;
    @FXML
    private Button bRetour;

    private int idcours;
    @FXML
    private ListView<Section> lvSectionEtud ;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Section> lessections = new ArrayList<>();
        SectionDAO sectiondao = new SectionDAO();
        lessections = sectiondao.findAll();



        ObservableList<Section> section = FXCollections.observableArrayList(lessections);
        lvSectionEtud.setItems(section);
    }

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
        String desc= tfdesc.getText();
        int section = lvSectionEtud.getItems().get(lvSectionEtud.getSelectionModel().getSelectedIndex()).getIdSection();



        if(!tflibelle.getText().isEmpty() && !tfdesc.getText().isEmpty() && !lvSectionEtud.getItems().isEmpty()) {
            Cours newcours = new Cours(idcours, nom, desc, section);
            System.out.println("on est bon");

            CoursDAO coursDAO = new CoursDAO();
            coursDAO.update(newcours);
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

    public void setlesdonne(Cours cours) {
        tflibelle.setText(cours.getLibellecours());
        tfdesc.setText(cours.getDescriptioncours());
        this.idcours = cours.getIdcours();

        int idSectionEtud = cours.getIdsection();
        Section sectionAAfficher = lvSectionEtud.getItems().stream()
                .filter(sec -> sec.getIdSection() == idSectionEtud)
                .findFirst()
                .orElse(null);

        if (sectionAAfficher != null) {
            lvSectionEtud.getSelectionModel().select(sectionAAfficher);
        }
    }
}
