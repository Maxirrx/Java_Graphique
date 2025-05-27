package fsiAdministration.controllers;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.DAO.CoursDAO;
import fsiAdministration.DAO.EtudiantDAO;
import fsiAdministration.DAO.SectionDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.ResourceBundle;

public class PageEtudiantController extends MenuController implements Initializable {

    private Etudiant etu;

    @FXML
    private Text nom, prenom, datedenaissance, section, cours;

    @FXML
    private Button bmodif, bsupp;
    SectionDAO sectionDAO = new SectionDAO();
    CoursDAO coursDAO = new CoursDAO();


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


    }



    @FXML
    public void bmodifclick(ActionEvent event) {}

    @FXML
    public void bsuppclick(ActionEvent event) {}
}

