package es.fdeazagra.tpvfastfood.gestionbd;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 * Clase para la conexión MySQL.
 * 
 * @author Fernando Martínez de Azagra
 * 
 */
public class GestionSql {
    
    private static final String MYSQL_DB = "jdbc:mysql://localhost:3306/tpv_burger";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWORD = "";
    public static Connection connection = null;
    
    /**
     * Método para conectar a la base de datos.
     *
     * @return java.sql.Connection connection o null.
     * @throws java.sql.SQLException
     */
    public static Connection openConnection() throws  SQLException{
        
        try {
            connection = 
                DriverManager.getConnection(MYSQL_DB, MYSQL_USER, MYSQL_PASSWORD);
            System.out.println("connect ok!!");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"La conexión ha fallado");
        }
        return null;
    }
    

}
