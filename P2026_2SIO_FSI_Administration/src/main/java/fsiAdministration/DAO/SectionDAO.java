package fsiAdministration.DAO;

import fsiAdministration.BO.Etudiant;
import fsiAdministration.BO.Section;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SectionDAO extends DAO<Section>{

    @Override
    public boolean create(Section obj) {
        return false;
    }

    @Override
    public boolean delete(Section obj) {
        return false;
    }

    @Override
    public boolean update(Section obj) {
        return false;
    }

    @Override
    public Section find(int id) {
        return null;
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
