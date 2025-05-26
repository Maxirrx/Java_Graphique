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
        return false;
    }

    @Override
    public boolean update(Cours obj) {
        return false;
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