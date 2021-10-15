package es.fdeazagra.tpvfastfood.gestionbd;

import es.fdeazagra.tpvfastfood.principal.TPVFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase con las acciones de los tickets y la base de datos.
 *
 * @author Fernando Martínez de Azagra
 */
public class ServiceTicket {
    
    private final TPVFrame frame;
    Connection connection = null;
    private int numId = 0;

    /**
     * Constructor mínimo parametrizado.
     * 
     * @param frame TPVFrame.
     */
    public ServiceTicket(TPVFrame frame) {
        this.frame = frame;
    }
    
    /**
     * Método para guardar los datos de un ticket en la base de datos.
     * 
     * @param ticket Ticket
     * @throws java.sql.SQLException
     */
    public void saveTicket(Ticket ticket) throws SQLException {
        
        String idCliente = ticket.getIdCliente();
        String productos = ticket.getProductos();
        String fecha = ticket.getFecha();
        String hora = ticket.getHora();
        double total = ticket.getTotal();
        
        if ("".equals(idCliente)) idCliente = "1";
        numId = Integer.parseInt(idCliente);
        
        try {
            // Llamamos al método que establece la conexión a MySQL
            connection = GestionSql.openConnection();

            // Creamos la sentencia SQL para insertar los datos obtenidos.
            String sql = "INSERT INTO Ticket (id_cliente, productos, fecha,"
                    + " hora, total) VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, numId);
            ps.setString(2, productos);
            ps.setString(3, fecha);
            ps.setString(4, hora);
            ps.setDouble(5, total);

            int result = ps.executeUpdate();

            // Comprobamos que se han insertado correctamente
            if(result == 1) {
                
                System.out.println("Ticket guardado");
                
                } else {
                
                    JOptionPane.showMessageDialog(null, "Ticket no guardado");
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
     * Método para listar todos los tickets de un mismo cliente
     * registrados en la base de datos.
     * 
     * @throws java.sql.SQLException
     */
    public void ticketsCliente() throws SQLException {
        
        String titulos[] = 
            {"ID CLIENTE", "ID TICKET", "FECHA", "HORA", "TOTAL"};
        
        DefaultTableModel modelo = 
                        (DefaultTableModel) frame.getTblPantalla().getModel();
        
        String selec = JOptionPane.showInputDialog(null,
                "Introduzca número id del cliente", JOptionPane.QUESTION_MESSAGE);
        
        vaciaTabla();
        modelo.setColumnIdentifiers(titulos);
        
        try {
                
            numId = Integer.parseInt(selec);
                
            } catch (NumberFormatException e) {
                
                JOptionPane.showMessageDialog(null,
                        "Es necesario el Id de un cliente registrado");
            }
        
        try {
            
            // Llamamos al método que establece la conexión a MySQL.
            connection = GestionSql.openConnection();
            
            // Creamos la sentencia SQL  para consultar todos los registros 
            // de la tabla Ticket con el teléfono indicado.
            String sql = ("SELECT * FROM Ticket WHERE id_cliente = '"+numId+"'");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            // Comprobamos si el resulset está vacío            
            if (!rs.isBeforeFirst()) {
                    
                JOptionPane.showMessageDialog(null, "Cliente no encontrado");
               
            }
            
            // Añadimos todos los registros a la tabla
            while (rs.next()) {
                int id = rs.getInt(1); 
                int idCliente = rs.getInt(2); 
                //String productos = rs.getString(3); 
                String fecha = rs.getString(4);
                String hora = rs.getString(5);
                double total = rs.getDouble(6);
                
                modelo.addRow(new Object[]
                        {idCliente, id, fecha, hora, total}); 
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
     * Método para listar todos los tickets de una fecha registrados 
     * en la base de datos.
     * 
     * @throws java.sql.SQLException
     */
    public void ticketsFecha() throws SQLException {
        
        String titulos[] = 
            {"FECHA", "HORA", "ID CLIENTE", "ID TICKET", "TOTAL"};
        
        DefaultTableModel modelo = 
                        (DefaultTableModel) frame.getTblPantalla().getModel();
        
        String selec = JOptionPane.showInputDialog(null,
                    "Introduzca fecha con formato: dd/mm/aaaa", 
                        JOptionPane.QUESTION_MESSAGE);
        
        vaciaTabla();
        modelo.setColumnIdentifiers(titulos);
        
        try {
            
            // Llamamos al método que establece la conexión a MySQL.
            connection = GestionSql.openConnection();
            
            // Creamos la sentencia SQL  para consultar todos los registros 
            // de la tabla Ticket con la fecha indicada.
            String sql = ("SELECT * FROM Ticket WHERE fecha = '"+selec+"'");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            // Comprobamos si el resulset está vacío            
            if (!rs.isBeforeFirst()) {
                    
                JOptionPane.showMessageDialog(null, "Ningún ticket esa fecha");
               
            }
            
            // Añadimos todos los registros a la tabla
            while (rs.next()) {
                int id = rs.getInt(1); 
                int idCliente = rs.getInt(2); 
                String fecha = rs.getString(4);
                String hora = rs.getString(5);
                double total = rs.getDouble(6);
                
                modelo.addRow(new Object[]
                        {fecha, hora, idCliente, id, total}); 
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
     * Método para limpiar la tabla de datos.
     */
    public void vaciaTabla(){
        
        DefaultTableModel modelo = 
                (DefaultTableModel) frame.getTblPantalla().getModel();
        
        for (int i=0; i<frame.getTblPantalla().getRowCount(); i++){
            modelo.removeRow(i);
            i-=1;
        }
    }
    
}
