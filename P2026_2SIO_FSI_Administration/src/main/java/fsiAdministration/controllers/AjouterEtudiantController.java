package fsiAdministration.controllers;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.BO.Section;
import fsiAdministration.DAO.EtudiantDAO;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AjouterEtudiantController extends MenuController implements Initializable {

    @FXML
    private TextField tfNomEtud, tfPrenomEtud;
    @FXML
    private Button bRetour;
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

        String nom= tfNomEtud.getText();
        String prenom = tfPrenomEtud.getText();
        int section = lvSectionEtud.getItems().get(lvSectionEtud.getSelectionModel().getSelectedIndex()).getIdSection();

        if(!tfNomEtud.getText().isEmpty() && tfPrenomEtud.getText() != "" && !lvSectionEtud.getItems().isEmpty()) {
            Etudiant newEtud = new Etudiant(0, nom, prenom, section);
            System.out.println("on est bon");

            EtudiantDAO etudDAO = new EtudiantDAO();
            etudDAO.create(newEtud);
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

        tfNomEtud.clear();
        tfPrenomEtud.clear();
    }
}
