package fsiAdministration.DAO;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.BO.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO extends DAO<Etudiant>{


    @Override
    public boolean create(Etudiant obj) {
        boolean controle = false;
        try{
            Connection connect = BDDManager.getInstance();
            String sql = "Insert into Etudiant(nomEtudiant, prenomEtudiant, idSection) values (?,?,?);";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,obj.getNomEtudiant());
            statement.setString(2,obj.getPrenomEtudiant());
            statement.setInt(3,obj.getIdSection());

            int rowsInserer = statement.executeUpdate();
            if (rowsInserer > 0) {
                controle= true;
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return controle;
    }



    @Override
    public boolean delete(Etudiant obj) {
        String sql = "DELETE FROM Etudiant WHERE id = ?";
        try {
             Connection connect = BDDManager.getInstance();
             PreparedStatement statement = connect.prepareStatement(sql);

            statement.setInt(1, obj.getIdEtudiant());

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Etudiant obj) {
        boolean controle = false;
        try {
            Connection connect = BDDManager.getInstance();
            String sql = "UPDATE Etudiant SET nomEtudiant = ?, prenomEtudiant = ?, idSection = ? WHERE idEtudiant = ?";

            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, obj.getNomEtudiant());
            statement.setString(2, obj.getPrenomEtudiant());
            statement.setInt(3, obj.getIdSection());
            statement.setInt(4, obj.getIdEtudiant());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                controle = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return controle;
    }

    @Override
    public Etudiant find(int id) {
        return null;
    }

    @Override
    public List findAll() {
        List<Etudiant> mesEtud = new ArrayList<>();
        Etudiant etud;

        try {
            Connection connect = BDDManager.getInstance();

            String sql = "SELECT * FROM etudiant";
            Statement ps = connect.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()) {
                etud = new Etudiant(
                        rs.getInt("idEtudiant"),
                        rs.getString ("nomEtudiant"),
                        rs.getString("prenomEtudiant"),
                        rs.getInt("idSection")
                        );
                mesEtud.add(etud);
            }

        } catch (SQLException e) {
            return null;
        }
        return mesEtud;
    }
}
