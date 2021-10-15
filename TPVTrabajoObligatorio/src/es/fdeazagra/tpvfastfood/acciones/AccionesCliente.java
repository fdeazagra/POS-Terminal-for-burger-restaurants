package es.fdeazagra.tpvfastfood.acciones;

import es.fdeazagra.tpvfastfood.gestionbd.ServiceTicket;
import es.fdeazagra.tpvfastfood.principal.TPVFrame;
import es.fdeazagra.tpvfastfood.vistas.PanelClientes;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 * Clase con las acciones relacionadas con el cliente.
 *
 * @author Fernando Martínez de Azagra
 */
public class AccionesCliente {
    
    private final TPVFrame frame;
    private PanelClientes panel;
    /**
     * Constructor mínimo.
     * 
     * @param frame 
     * @param panel 
     */
    public AccionesCliente(TPVFrame frame, PanelClientes panel) {
        this.frame = frame;
        this.panel = panel;
        
    }
    
    /**
     * Método para poner el id y el nombre de un cliente en las etiquetas
     * de la pantalla principal.
     */
    public void clienteAPantalla(){
        
        String id = panel.getLblId().getText();
        String nombre = panel.getTxtNombre().getText() + " "
                        + panel.getTxtApellido1().getText() + " "
                        + panel.getTxtApellido2().getText();
        
        frame.getLblIdCliente().setText(id);
        frame.getLblNombreCliente().setText(nombre);
    }
    
    /**
     * Método para solicitar contraseña para el cobro de cliente habitual.
     */
    public void solicitaPassword(){
        
        JPanel pan = new JPanel();
        JLabel label = new JLabel("Introduzca contraseña:");
        JPasswordField pass = new JPasswordField(10);
        pan.add(label);
        pan.add(pass);
        
        String[] opciones = new String[]{"OK", "Cancelar"};
        
        int option = JOptionPane.showOptionDialog(null, pan, "Cliente habitual",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, opciones, opciones[0]);
        
        if(option == 0){
            
            char[] password = pass.getPassword();
            char[] comprueba = {'a', 'd', 'm', 'i', 'n'};
            
            if (Arrays.equals(comprueba, password)){
                
                JOptionPane.showMessageDialog(null, "Contraseña correcta");
                
                AccionesTicket accion = new AccionesTicket(frame);
                ServiceTicket sql = new ServiceTicket(frame);
                
                accion.descuentoCliente();
                
                JOptionPane.showMessageDialog
                                (null, accion.creaTicket().toString());
                
                try {
                    sql.saveTicket(accion.creaTicket());
                } catch (SQLException ex) {
            
                    Logger.getLogger(TPVFrame.class.getName())
                            .log(Level.SEVERE,null,ex);
                }
                
                accion.vaciaLista();
                accion.vaciaDatos();
            
            } else {
                
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            }
        }

    }
}
