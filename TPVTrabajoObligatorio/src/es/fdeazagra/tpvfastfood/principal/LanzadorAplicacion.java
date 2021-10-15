package es.fdeazagra.tpvfastfood.principal;

import java.sql.SQLException;

/**
 * Clase lanzadora de la aplicación.
 * 
 * @author Fernando Martínez de Azagra
 */
public class LanzadorAplicacion {
    
    public static void main(String[] args) throws SQLException {
        TPVFrame frame = new TPVFrame();
        frame.setVisible(true);

    }
}
