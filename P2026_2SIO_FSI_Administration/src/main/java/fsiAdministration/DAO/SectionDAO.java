package fsiAdministration.DAO;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.BO.Section;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectionDAO extends DAO<Section>{

    @Override
    public boolean create(Section obj) {
        boolean controle = false;
        try{
            Connection connect = BDDManager.getInstance();
            String sql = "Insert into Section(libellesection) values (?);";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,obj.getLibelleSection());


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
    public boolean delete(Section obj) {
        String sql = "DELETE FROM Section WHERE idSection = ?";
        try {
            Connection connect = BDDManager.getInstance();
            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setInt(1, obj.getIdSection());

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Section obj) {
        boolean controle = false;
        try{
            Connection connect = BDDManager.getInstance();
            String sql = "UPDATE Section SET libellesection = ? where idSection = ?;";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,obj.getLibelleSection());
            statement.setInt(2,obj.getIdSection());


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
    public Section find(int id) {
        Section section = null;

        try {
            Connection connect = BDDManager.getInstance();
            String sql = "SELECT * FROM section WHERE idsection = ?";

            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int idSection = rs.getInt("idsection");
                String libelle = rs.getString("libellesection");

                section = new Section(idSection, libelle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return section;
    }

    @Override
    public List<Section> findAll() {
        List<Section> sections = new ArrayList<>();
        Section section;

        try {
            Connection connect = BDDManager.getInstance();

            String sql = "SELECT * FROM section";
            Statement ps = connect.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()) {
                section = new Section(
                        rs.getInt("idSection"),
                        rs.getString ("libelleSection")
                );
                sections.add(section);
            }

        } catch (SQLException e) {
            return null;
        }
        return sections;
    }

}
