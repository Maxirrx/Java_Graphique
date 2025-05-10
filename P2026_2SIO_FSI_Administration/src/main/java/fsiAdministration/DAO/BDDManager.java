package fsiAdministration.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDDManager {

    //private static String url ="jdbc:postgresql://localhost:5432/FSI_GestionAdmin";
    private static String url ="jdbc:postgresql://localhost:5432/fsi_gestionadmin";
    private static String user ="postgres";
    private static String pass ="23032005";

    private static Connection connect;

    public static Connection getInstance(){
        if (connect == null){
            try{
                connect = DriverManager.getConnection(url,user,pass);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connect;
    }
}
