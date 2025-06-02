package fsiAdministration.BO;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;


public class Etudiant {

    private int idEtudiant;
    private SimpleStringProperty nomEtudiant;
    private SimpleStringProperty prenomEtudiant;
    private Date datedenaissance;
    private int idSection;

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }



    public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant,Date datedenaissance, int idSection) {
        this.idEtudiant = idEtudiant;
        this.nomEtudiant = new SimpleStringProperty(nomEtudiant);
        this.prenomEtudiant = new SimpleStringProperty(prenomEtudiant);
        this.datedenaissance = datedenaissance;
        this.idSection = idSection;

    }

    public Date getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant.get();
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant.set(nomEtudiant);
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant.get();
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant.set(prenomEtudiant);
    }

    public SimpleStringProperty nomEtudiantProperty() {
        return nomEtudiant;
    }



    public SimpleStringProperty prenomEtudiantProperty() {
        return prenomEtudiant;
    }

}
