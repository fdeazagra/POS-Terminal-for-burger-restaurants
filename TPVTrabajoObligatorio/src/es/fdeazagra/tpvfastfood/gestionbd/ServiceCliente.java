package es.fdeazagra.tpvfastfood.gestionbd;

import es.fdeazagra.tpvfastfood.principal.TPVFrame;
import es.fdeazagra.tpvfastfood.vistas.PanelClientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase con las acciones de los clientes y la base de datos.
 *
 * @author Fernando Martínez de Azagra
 */
public class ServiceCliente {
    
    private final TPVFrame frame;
    private final PanelClientes panel;
    private int numId = 0;
    Connection connection = null;

    /**
     * Constructor mínimo parametrizado.
     * 
     * @param panel PanelClientes.
     * @param frame TPVFrame.
     */
    public ServiceCliente(PanelClientes panel, TPVFrame frame) {
        this.panel = panel;
        this.frame = frame;
    }
    
    /**
     * Método para solicitar la clave de un cliente (su teléfono) al usuario.
     * 
     * @return String seleccion
     */ 
    public String pideClaveCliente(){
        
        // Borramos los datos de los campos del panel
        limpiaPanel();
        
        String seleccion = JOptionPane.showInputDialog(
            panel, "Introduzca teléfono del cliente", JOptionPane.QUESTION_MESSAGE);
        return seleccion;   
    }
    
    /**
     * Método para guardar los datos de un cliente en la base de datos.
     * 
     * @throws java.sql.SQLException
     */
    public void saveCliente() throws SQLException {
        
        try {
            
            // Obtenemos los datos introducidos en los campos por el usuario. 
            String nombre = panel.getTxtNombre().getText();
            String apellido1 = panel.getTxtApellido1().getText();
            String apellido2 = panel.getTxtApellido2().getText();
            String telefono = panel.getTxtTelefono().getText();
            String email = panel.getTxtEmail().getText();
            
             if(!("".equals(nombre) | "".equals(apellido1)| "".equals(apellido2) 
                     | "".equals(telefono) | "".equals(email))){
                 
                // Llamamos al método que establece la conexión a MySQL
                connection = GestionSql.openConnection();

                // Creamos la sentencia SQL para insertar los datos obtenidos.
                String sql = "INSERT INTO Cliente (nombre, apellido1, apellido2,"
                        + " telefono, email) VALUES ( ?, ?, ?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, nombre);
                ps.setString(2, apellido1);
                ps.setString(3, apellido2);
                ps.setString(4, telefono);
                ps.setString(5, email);

                int result = ps.executeUpdate();

                // Comprobamos que se han insertado correctamente
                if(result == 1) {
                    JOptionPane.showMessageDialog(null, "Cliente guardado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
                }
                 
                 
             } else {
                 
                 JOptionPane.showMessageDialog(null,"Rellene todos los campos");
                 
             }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
               connection.close();
            }
        }
    }
    
    /**
     * Método para buscar un cliente en la base de datos a partir de su teléfono.
     * 
     * @throws java.sql.SQLException
     */
    public void getCliente() throws SQLException {
        
        try{
            
            // Obtenemos el número que introduce el usuario.
            String clave = pideClaveCliente();
            
            // Llamamos al método que establece la conexión a MySQL.
            connection = GestionSql.openConnection();
            
            // Creamos la sentencia SQL  para consultar el resto de campos 
            // correspondientes al registro del id obtenido.
            String sql = ("SELECT id, nombre, apellido1, apellido2, telefono, email"
                    + " FROM Cliente WHERE telefono = '"+clave+"'");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Informamos al usuario de los datos obtenidos.
            if (rs.next() != false) {
                
                panel.getLblId().setText(rs.getString(1));
                panel.getTxtNombre().setText(rs.getString(2));
                panel.getTxtApellido1().setText(rs.getString(3));
                panel.getTxtApellido2().setText(rs.getString(4));
                panel.getTxtTelefono().setText(rs.getString(5));
                panel.getTxtEmail().setText(rs.getString(6));
                rs.next();
                
            } else {
                
                limpiaPanel();
                JOptionPane.showMessageDialog(null, "Teléfono no encontrado");
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
               connection.close();
            }
        }
        
    }
    
    /**
     * Método para eliminar un cliente de la base de datos a partir de su id.
     * 
     * @throws java.sql.SQLException
     */
    public void deleteCliente() throws SQLException {
        
        try{
            
            // Obtenemos el número del usuario en el campo id.
            String id = panel.getLblId().getText();
            
            try {
                
                numId = Integer.parseInt(id);
                
            } catch (NumberFormatException e) {
                
                JOptionPane.showMessageDialog(null,
                        "Es necesario el Id de un cliente registrado");
            }
            
            // Llamamos al método que establece la conexión a MySQL.
            connection = GestionSql.openConnection();
            
            // Creamos la sentencia SQL para borrar los registros  
            // de tickets con el id obtenido.
            String sql2 = ("DELETE FROM Ticket "
                         + "WHERE Ticket.id_cliente = '" + numId + "'" );
            
            PreparedStatement ps2 = connection.prepareStatement(sql2);            
            int result2 = ps2.executeUpdate();
            
            // Informamos de si la operación se ha realizado correctamente.
            if(result2 == 1) {
                JOptionPane.showMessageDialog(null, "Tickets borrados");
                limpiaPanel();
            } 
            
            // Creamos la sentencia SQL para borrar el registro Cliente 
            // con el id obtenido.
            String sql = ("DELETE FROM Cliente "
                         + "WHERE Cliente.id = '" + numId + "'" );
            
            PreparedStatement ps = connection.prepareStatement(sql);            
            int result = ps.executeUpdate();
            
            // Informamos de si la operación se ha realizado correctamente.
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "Registro borrado");
                limpiaPanel();
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
               connection.close();
            }
        }
        
    }

    /**
     * Método para editar y actualizar los datos de un cliente en la base de 
     * datos a partir de su id.
     * 
     * @throws java.sql.SQLException
     */
    public void updateCliente() throws SQLException {
        
        String id = panel.getLblId().getText();
        
        try{
            
            numId = Integer.parseInt(id);
            
        } catch (NumberFormatException e) {
            
                JOptionPane.showMessageDialog(null,
                    "Es necesario el Id de un cliente registrado");
        }
        
        try{
        
            // Obtenemos los datos introducidos en los campos.
            String nombre = panel.getTxtNombre().getText();
            String apellido1 = panel.getTxtApellido1().getText();
            String apellido2 = panel.getTxtApellido2().getText();
            String telefono = panel.getTxtTelefono().getText();
            String email = panel.getTxtEmail().getText();
            int result = 0;
            boolean control = false;
            
            // Llamamos al método que establece la conexión a MySQL
            connection = GestionSql.openConnection();

            // Comprobamos si los campos contienen datos y creamos la 
            // sentencia SQL para actualizarlos.
            if (!"".equals(nombre)) {
                
                String sql = ("UPDATE Cliente SET nombre = ?"
                                + " WHERE Cliente.id = '" + numId + "'" );
                PreparedStatement ps = connection.prepareStatement(sql);
                
                ps.setString(1, nombre);
                result = ps.executeUpdate();
                
                if(result == 1) control = true;
            }
            
            if (!"".equals(apellido1)) {
                
                String sql = ("UPDATE Cliente SET apellido1 = ?"
                                + " WHERE Cliente.id = '" + numId + "'" );
                PreparedStatement ps = connection.prepareStatement(sql);
                
                ps.setString(1, apellido1);
                result = ps.executeUpdate();
                
                if(result == 1) control = true;
            }
            
            if (!"".equals(apellido2)) {
              
                String sql = ("UPDATE Cliente SET apellido2 = ?"
                                + " WHERE Cliente.id = '" + numId + "'" );
                PreparedStatement ps = connection.prepareStatement(sql);
                
                ps.setString(1, apellido2);
                result = ps.executeUpdate();
                
                if(result == 1) control = true;
            }
            
            if (!"".equals(telefono)) {
                
                String sql = ("UPDATE Cliente SET telefono = ?"
                                + " WHERE Cliente.id = '" + numId + "'" );
                PreparedStatement ps = connection.prepareStatement(sql);
                
                ps.setString(1, telefono);
                result = ps.executeUpdate();
                
                if(result == 1) control = true;
            }
            
            if (!"".equals(email)) {
                
                String sql = ("UPDATE Cliente SET email = ?"
                                + " WHERE Cliente.id = '" + numId + "'" );
                PreparedStatement ps = connection.prepareStatement(sql);
                
                ps.setString(1, email);
                result = ps.executeUpdate();
                
                if(result == 1) control = true;
            }
            
            // Comprobamos que se haya introducido datos en al menos 1 campo.
            if(control == true) {
               
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                
            } else {
               
                JOptionPane.showMessageDialog(null, 
                        "Busque cliente para actualizar");
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
               connection.close();
            }
        }
    }
    
    /**
     * Método para listar los clientes registrados en la base de datos.
     * 
     * @throws java.sql.SQLException
     */
    public void listaClientes() throws SQLException {
        
        ServiceTicket service = new ServiceTicket(frame);
        
        String titulos[] = 
            {"ID", "NOMBRE", "APELLIDO 1", "APELLIDO 2", "TELÉFONO"};
        
        DefaultTableModel modelo = 
                        (DefaultTableModel) frame.getTblPantalla().getModel();
        
        modelo.setColumnIdentifiers(titulos);
        service.vaciaTabla();
        
        try {
            
            // Llamamos al método que establece la conexión a MySQL.
            connection = GestionSql.openConnection();
            
            // Creamos la sentencia SQL  para consultar todos los registros 
            // de la tabla cliente de la base de datos.
            String sql = ("SELECT * FROM Cliente");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Añadimos todos los registros a una tabla
            while (rs.next()) {
                int id = rs.getInt(1); 
                String nombre = rs.getString(2); 
                String apellido1 = rs.getString(3); 
                String apellido2 = rs.getString(4);
                String telefono = rs.getString(5);
                String email = rs.getString(6);
                modelo.addRow(new Object[]
                        {id, nombre, apellido1, apellido2, telefono, email});
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
               connection.close();
            }
        }
    }
   /**
    * Método para borrar todos los campos con datos del cliente.
    */
    public void limpiaPanel() {
       
        panel.getLblId().setText(null);
        panel.getTxtNombre().setText(null);
        panel.getTxtApellido1().setText(null);
        panel.getTxtApellido2().setText(null);
        panel.getTxtTelefono().setText(null);
        panel.getTxtEmail().setText(null);
        
        frame.getLblIdCliente().setText("");
        frame.getLblNombreCliente().setText("");
    }
}
