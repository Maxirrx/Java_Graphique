package fsiAdministration.DAO;

import fsiAdministration.BO.Cours;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursDAO extends DAO<Cours> {
    @Override
    public boolean create(Cours obj) {
        boolean controle = false;
        try{
            Connection connect = BDDManager.getInstance();
            String sql = "Insert into Cours(libellecours, descriptioncours, idsection) values (?,?,?);";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,obj.getLibellecours());
            statement.setString(2,obj.getDescriptioncours());
            statement.setInt(3,obj.getIdsection());

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
    public boolean delete(Cours obj) {
        String sql = "DELETE FROM Cours WHERE idCours = ?";
        try {
            Connection connect = BDDManager.getInstance();
            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setInt(1, obj.getIdcours());

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Cours obj) {
        boolean controle = false;
        try{
            Connection connect = BDDManager.getInstance();
            String sql = "UPDATE Cours SET libellecours = ?, descriptioncours = ?, idsection = ? where idCours = ?;";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,obj.getLibellecours());
            statement.setString(2,obj.getDescriptioncours());
            statement.setInt(3,obj.getIdsection());
            statement.setInt(4,obj.getIdcours());

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
    public Cours find(int id) {
        return null;
    }

    @Override
    public List<Cours> findAll() {
        List<Cours> lescours = new ArrayList<>();
        Cours etud;

        try {
            Connection connect = BDDManager.getInstance();

            String sql = "SELECT * FROM cours";
            Statement ps = connect.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()) {
                etud = new Cours(
                        rs.getInt("idcours"),
                        rs.getString ("libellecours"),
                        rs.getString("descriptioncours"),
                        rs.getInt("idsection")
                );
                lescours.add(etud);
            }

        } catch (SQLException e) {
            return null;
        }
        return lescours;
    }
}