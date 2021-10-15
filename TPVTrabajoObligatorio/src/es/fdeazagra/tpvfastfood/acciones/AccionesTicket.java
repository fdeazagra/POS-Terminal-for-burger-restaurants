package es.fdeazagra.tpvfastfood.acciones;

import es.fdeazagra.tpvfastfood.gestionbd.Producto;
import es.fdeazagra.tpvfastfood.gestionbd.Ticket;
import es.fdeazagra.tpvfastfood.principal.TPVFrame;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase con las acciones relacionadas con el ticket.
 *
 * @author Fernando Martínez de Azagra
 */
public class AccionesTicket {
    
    private final TPVFrame frame;
    public static List<Producto> productosTicket = new ArrayList<>();
    Producto producto = new Producto();
    private static double total = 0;
    private static double precioUltimoProducto = 0;

    /**
     * Constructor mínimo.
     * 
     * @param frame 
     */
    public AccionesTicket(TPVFrame frame) {
        this.frame = frame;
        
    }   
    
   /**
    * Método que nos devuelve la fecha actual.
    *
    * @return fecha String  con el día, mes y año.
    */
    public String fechaActual(){
        
        Date objDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = (dateFormat.format(objDate));
        return fecha;
    }
    
   /**
    * Método que nos devuelve la hora actual.
    *
    * @return hora String con la hora, minutos y segundos.
    */
    public String horaActual(){
        
        Date objDate = new Date();
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");        
        String hora = (hourFormat.format(objDate));
        return hora;
    }
    
   /**
    * Método para añadir productos al ticket.
    *
    * @param producto Producto correspondiente al botón pulsado.
    */
    public void productoATicket(Producto producto){

        double precio = producto.getPrecio();
        total += precio;
        precioUltimoProducto = precio;
        productosTicket.add(producto);
        totalAPantalla();
        
    }
    
   /**
    * Método para añadir productos a la pantalla de tickets.
    *
    * @param producto Producto correspondiente al botón pulsado.
    */
    public void productoAPantalla(Producto producto){
        
        String codigo = producto.getCodigo();
        String descripcion = producto.getDescripcion();
        String precio = String.valueOf(producto.getPrecio() + " €");
                   
        DefaultTableModel modelo = 
                (DefaultTableModel) frame.getTblTabla().getModel();
        
        modelo.addRow(new Object[]{codigo, descripcion, precio});
        
    }
    
   /**
    * Método para añadir el total en la pantalla de tickets.
    */
    public void totalAPantalla(){
        
        String precio = String.valueOf(total) + " € ";
        frame.getLblTotal().setText(precio);
    }
    
    
   /**
    * Método para realizar un descuento.
    */
    public void descuentoCliente(){
        
        double descuento = 10 * total/100;
        
        String valorDescuento = "-" + String.valueOf(descuento) + " € ";
        
        DefaultTableModel modelo = 
                (DefaultTableModel) frame.getTblTabla().getModel();
        
        modelo.addRow(new Object[]{"","descuento cliente 10%",valorDescuento});
        Producto temp = new Producto("","descuento cliente 10%",(descuento*-1));
        productosTicket.add(temp);
        
        total -= descuento;
        totalAPantalla();
  
    }
    
   /**
    * Método para vaciar y reiniciar la lista de productos.
    */
    public void vaciaLista(){
        productosTicket.removeAll(productosTicket);
        total = 0;
        totalAPantalla();
    }
    
   /**
    * Método para borrar y reiniciar la tabla de la pantalla de los tickets.
    */
    public void vaciaDatos(){
        
        DefaultTableModel modelo = 
                (DefaultTableModel) frame.getTblTabla().getModel();
        
        for (int i=0; i<frame.getTblTabla().getRowCount(); i++){
            modelo.removeRow(i);
            i-=1;
        }
        
        frame.getLblIdCliente().setText("");
        frame.getLblNombreCliente().setText("");
    }
    
   /**
    * Método para comprobar si la pantalla de tickets está vacía.
    */
    public boolean compruebaTablaVacia(){
        
        boolean control;
        int fila = frame.getTblTabla().getRowCount();
        
        DefaultTableModel modelo = 
                (DefaultTableModel) frame.getTblTabla().getModel();
        
        if (fila != 0){ control = true;} else { control = false;}
        
        return control;
        
    }
   /**
    * Método para retroceder el último movimiento de la tabla de los tickets.
    */
    public void retrocedeVenta(){
        
        int fila = frame.getTblTabla().getRowCount();
        
        DefaultTableModel modelo = 
                (DefaultTableModel) frame.getTblTabla().getModel();
        
        if (fila != 0){ 
            
            modelo.removeRow(fila-1);
            productosTicket.remove(fila-1);
            total -= precioUltimoProducto;
            totalAPantalla();
            
        } else {
           
            JOptionPane.showMessageDialog(null, "¡Pantalla vacía!");
        }
    }
    
   /**
    * Método para crear tickets a partir de lo introducido por el usuario.
    * 
     * @return Ticket completo.
    */
    public Ticket creaTicket(){
        
        String result = "\n";
        String temp;
        String idCliente = frame.getLblIdCliente().getText();
        
        for (int i = 0; i < productosTicket.size(); i++) {
           
                producto = (Producto) productosTicket.get(i);
                
                String descripcion = producto.getDescripcion();
                double precio = producto.getPrecio();
                temp = descripcion + "   " + precio + " €\n";
                result = result + temp;
        }
        
        Ticket ticket = new Ticket(result, fechaActual(), horaActual(),
                                    total, idCliente);
        
        return ticket;
                
    }
}
