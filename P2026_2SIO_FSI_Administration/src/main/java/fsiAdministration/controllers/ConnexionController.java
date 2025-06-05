package fsiAdministration.controllers;

import fsiAdministration.BO.Utilisateur;
import fsiAdministration.DAO.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConnexionController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private TextField tfLogin;
    @FXML
    private PasswordField tfMDP;
    @FXML
    private Button bConnexion;

    @FXML
    public void bConnexionClick(ActionEvent event) {
        String login = tfLogin.getText();
        String mdp = tfMDP.getText();


        UtilisateurDAO userDAO = new UtilisateurDAO();
        Utilisateur user = userDAO.find(login, mdp);


        if (user.getLoginUtilisateur() != null) {
            showAccueil();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fsiAdministration/views/popup_alerte.fxml"));
                Parent root = loader.load();

                ControllerAlerte controller = loader.getController();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));

                stage.initModality(Modality.APPLICATION_MODAL);
                controller.setErreurcode(1);

                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void showAccueil(){
         Stage stageP = (Stage) bConnexion.getScene().getWindow();
         //on ferme l'écran
          stageP.close();
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
