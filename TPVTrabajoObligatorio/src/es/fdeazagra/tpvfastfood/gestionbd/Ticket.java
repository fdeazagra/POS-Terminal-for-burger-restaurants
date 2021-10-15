package es.fdeazagra.tpvfastfood.gestionbd;

/**
 * Clase con el modelo de datos del ticket de caja.
 *
 * @author Fernando Martínez de Azagra
 */
public class Ticket {
    
    private static final String NOMBRE = "The Burger Corner";
    private static final String CIF = "B-XXXXXXXX";
    private static final String DIRECCION = "Calle del gourmet, 1"
                                           + "\n 50001 Zaragoza";

    private String productos;
    private String fecha;
    private String hora;
    private double total;
    private String idCliente;
   
    /**
     * Constructor que recibe todos los parámetros del ticket.
     *
     * @param productos Array de Strings de los productos del ticket.
     * @param fecha String de la fecha del ticket.
     * @param hora String de la hora del ticket.
     * @param total double del total de la suma de todos los productos.
     * @param idCliente String con el id del cliente.
     */
 
    public Ticket(String productos, String fecha, String hora, 
                        double total, String idCliente) {
        
        this.productos = productos;
        this.fecha = fecha;
        this.hora = hora;
        this.total = total;
        this.idCliente = idCliente;
    }

    
    /**
     * Getter de los productos incluidos en el ticket.
     *
     * @return String productos.
     */
    public String getProductos() {
        return productos;
    }

    /**
     * Setter de los productos a incluir en el ticket.
     * 
     * @param productos.
     */
    public void setProductos(String productos) {
        this.productos = productos;
    }

    /**
     * Getter de la fecha del ticket.
     *
     * @return String fecha.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Setter de la fecha del ticket.
     *
     * @param fecha.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Getter de la hora del ticket.
     *
     * @return String hora.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Setter de la hora del ticket.
     *
     * @param hora.
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
   
    /**
     * Getter del precio total del ticket.
     *
     * @return double total.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Setter del precio total del ticket.
     *
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Getter del idCliente del ticket.
     *
     * @return String idCliente.
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Setter del idCliente del ticket.
     *
     * @param idCliente
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    
    /**
     * Getter de los campos con los datos fiscales del restaurante.
     *
     * @return String.
     */
    public String getDatosFiscales(){
        return NOMBRE + "\n" + "Cif: " + CIF + "\n" + DIRECCION;
    }
    
    @Override
    public String toString(){
        
        String precioFinal = String.valueOf(getTotal()) + " €";
        
        
        return NOMBRE + "\n" + "Cif: " + CIF + "\n" + DIRECCION + "\n\n"
                + "Fecha: " + getFecha() + " " + getHora() + "\n"
                + getProductos() + "\n" + "Total: " + precioFinal
                + "\n\n" + "Código cliente: " + getIdCliente();
    }
    
    
}
                                                                                                                                                                                                                                                                                                                                      
                                             





















                                                                                                                                                                                                                           