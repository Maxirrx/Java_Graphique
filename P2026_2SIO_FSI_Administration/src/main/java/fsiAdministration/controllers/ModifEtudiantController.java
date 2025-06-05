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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ModifEtudiantController  extends MenuController implements Initializable {

    @FXML
    private TextField tfNomEtud, tfPrenomEtud;

    @FXML
    private DatePicker datenaissance;
    @FXML
    private Button bRetour;
    @FXML
    private ListView<Section> lvSectionEtud ;
    private SectionDAO sectiondao = new SectionDAO();

    private int idEtudiant;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Section> lessections = new ArrayList<>();
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
        Date date = Date.valueOf(datenaissance.getValue());

        if(!tfNomEtud.getText().isEmpty() && tfPrenomEtud.getText() != "" && !lvSectionEtud.getItems().isEmpty()) {
            Etudiant newEtud = new Etudiant(idEtudiant, nom, prenom, date,section);
            System.out.println(newEtud.getIdEtudiant());

            EtudiantDAO etudDAO = new EtudiantDAO();
            etudDAO.update(newEtud);
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

        tfNomEtud.clear();
        tfPrenomEtud.clear();
        lvSectionEtud.getItems().clear();
        datenaissance.setValue(null);
    }

    public void setlesdonne(Etudiant etudiant) {
        tfNomEtud.setText(etudiant.getNomEtudiant());
        tfPrenomEtud.setText(etudiant.getPrenomEtudiant());
        datenaissance.setValue(etudiant.getDatedenaissance().toLocalDate());
        this.idEtudiant = etudiant.getIdEtudiant();


        int idSectionEtud = etudiant.getIdSection();
        Section sectionAAfficher = lvSectionEtud.getItems().stream()
                .filter(sec -> sec.getIdSection() == idSectionEtud)
                .findFirst()
                .orElse(null);

        if (sectionAAfficher != null) {
            lvSectionEtud.getSelectionModel().select(sectionAAfficher);
        }
    }
}
