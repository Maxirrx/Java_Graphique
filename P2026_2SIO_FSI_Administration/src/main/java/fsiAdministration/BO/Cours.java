package fsiAdministration.BO;

import javafx.beans.property.SimpleStringProperty;

public class Cours {

    private int idcours;
    private SimpleStringProperty libellecours;
    private String descriptioncours;
    private int idsection;

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    public String getLibellecours() {
        return libellecours.get();
    }

    public void setLibellecours(String libellecours) {
        this.libellecours.set(libellecours);
    }

    public String getDescriptioncours() {
        return descriptioncours;
    }

    public void setDescriptioncours(String descriptioncours) {
        this.descriptioncours = descriptioncours;
    }

    public int getIdsection() {
        return idsection;
    }

    public void setIdsection(int idsection) {
        this.idsection = idsection;
    }

    public Cours(int idcours, String libellecours, String descriptioncours, int idsection) {
        this.idcours = idcours;
        this.libellecours = new SimpleStringProperty(libellecours);
        this.descriptioncours = descriptioncours;
        this.idsection = idsection;
    }
}
