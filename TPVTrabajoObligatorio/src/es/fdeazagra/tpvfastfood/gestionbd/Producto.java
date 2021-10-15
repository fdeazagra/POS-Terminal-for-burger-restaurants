package es.fdeazagra.tpvfastfood.gestionbd;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase con el modelo de datos del producto.
 *
 * @author Fernando Martínez de Azagra
 */
public class Producto {
    
    private String codigo, descripcion;
    private double precio;
    public static List<Producto> listaDeProductos = new ArrayList<>();
    
    /**
     * Constructor mínimo.
     */ 
    public Producto(){
        
        codigo = "";
        descripcion = "";
        precio = 0;
        
    }
    /**
     * Constructor que recibe como parámetros 
     * la descripción del producto y su precio.
     *
     * @param codigo String codigo del producto.
     * @param descripcion String descripción del producto.
     * @param precio double precio del producto.
     */
    public Producto(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;

    }
    
    /**
     * Getter del código del producto.
     *
     * @return String codigo.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Getter de la descripción del producto.
     *
     * @return String descripcion.
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Getter del precio del producto.
     *
     * @return int precio.
     */
    public double getPrecio() {
        return precio;
    }
    
    @Override
    public String toString() {
        return codigo + " " + descripcion + " " + precio + "€";
    }    

    /**
     * Método que añade los productos a la lista.
     */
    public void inicializarLista() {
        
        
        Producto producto = new Producto ("0", "Código control", 0);
        listaDeProductos.add(producto);
        
        // Menús:
        producto = new Producto ("1", "Menú nº1", 8.5);
        listaDeProductos.add(producto);
        
        producto = new Producto("2", "Menú nº2", 9.5);
        listaDeProductos.add(producto);
        
        producto = new Producto("3", "Menú nº3", 7.5);
        listaDeProductos.add(producto);
        
        producto = new Producto("4", "Menú nº4", 8.5);
        listaDeProductos.add(producto);
        
        producto = new Producto("5", "Menú nº5", 9.5);
        listaDeProductos.add(producto);
        
        producto = new Producto("6", "Menú nº6", 8.5);
        listaDeProductos.add(producto);
        
        // Hamburguesas:
        producto = new Producto("7", "Hamburguesa sencilla", 4.0); 
        listaDeProductos.add(producto);
        
        producto = new Producto("8", "Hamburguesa con queso", 4.5); 
        listaDeProductos.add(producto);
        
        producto = new Producto("9", "Hamburguesa con bacon", 4.5); 
        listaDeProductos.add(producto);
        
        producto = new Producto("10", "Hamburguesa doble", 6.0); 
        listaDeProductos.add(producto);
        
        producto = new Producto("11", "Hamburguesa especial", 6.5); 
        listaDeProductos.add(producto);
        
        producto = new Producto("12", "Hamburguesa vegana", 4.5); 
        listaDeProductos.add(producto);
        
        // Extras:
        producto = new Producto("13", "Patatas fritas", 2.5); 
        listaDeProductos.add(producto);
        
        producto = new Producto("14", "Nuggets de pollo", 2.5); 
        listaDeProductos.add(producto);
        
        producto = new Producto("15", "Alitas de pollo", 3.5); 
        listaDeProductos.add(producto);
        
        producto = new Producto("16", "Ensalada mediterranea", 5.5); 
        listaDeProductos.add(producto);
        
        producto = new Producto("17", "Helado sabores", 2.5); 
        listaDeProductos.add(producto);
        
        producto = new Producto("18", "Tarta chocolate", 4.0); 
        listaDeProductos.add(producto);
        
        // Bebidas:
        producto = new Producto("19", "Vino joven", 2.0); 
        listaDeProductos.add(producto);
        
        producto = new Producto("20", "Caña cerveza", 2.0); 
        listaDeProductos.add(producto);
        
        producto = new Producto("21", "Caña cerveza sin alcohol", 2.0); 
        listaDeProductos.add(producto);
        
        producto = new Producto("22", "Refresco", 2.5); 
        listaDeProductos.add(producto);
        
        producto = new Producto("23", "Zumo", 2.0); 
        listaDeProductos.add(producto);
        
        producto = new Producto("24", "Batido", 2.0); 
        listaDeProductos.add(producto);
        
        producto = new Producto("25", "Café", 1.5); 
        listaDeProductos.add(producto);
        
        producto = new Producto("26", "Infusión", 1.5); 
        listaDeProductos.add(producto);
        
        producto = new Producto("27", "Agua", 1.5); 
        listaDeProductos.add(producto);
        
    }
    
    
}
