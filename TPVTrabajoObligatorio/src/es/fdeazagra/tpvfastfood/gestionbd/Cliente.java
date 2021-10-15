package es.fdeazagra.tpvfastfood.gestionbd;

/**
 * Clase con el modelo de datos del cliente.
 *
 * @author Fernando Martínez de Azagra
 */
public class Cliente {
    
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;
    
    /**
     * Constructor que recibe todos los parámetros del formulario.
     *
     * @param id int número identificación del cliente.
     * @param nombre String nombre del cliente.
     * @param apellido1 String apellido1 del cliente.
     * @param apellido2 String apellido2 del cliente.
     * @param telefono String número de teléfono del cliente.
     * @param email String email del cliente.
     */
    public Cliente(int id, String nombre, String apellido1, String apellido2,
            String telefono, String email) {
        
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.email = email;

        
    }
    
    @Override
    public String toString() {
        return "Id: " + getId() + " Nombre: " + getNombre() + "\n "
                + "Apellidos: " + getApellido1() + " " + getApellido2()+ "\n" 
                + "Teléfono: " + getTelefono() + " " 
                + "Email: " + getEmail();
        }

     /**
     * Getter del id del cliente.
     *
     * @return int id del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del id del cliente.
     *
     * @param id int id del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }
    
     /**
     * Getter del nombre del cliente.
     *
     * @return String nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre del cliente.
     *
     * @param nombre String nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del primer apellido del cliente.
     *
     * @return String apellido1.
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Setter del primer apellido del cliente.
     *
     * @param apellido1 String apellido paterno.
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Getter del segundo apellido del cliente.
     *
     * @return String apellido2.
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Setter del segundo apellido del cliente.
     *
     * @param apellido2 String apellido materno.
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Getter del teléfono del cliente.
     *
     * @return String telefono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter del teléfono del cliente.
     *
     * @param telefono String teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Getter del email del cliente.
     *
     * @return String email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter del email del cliente.
     *
     * @param email String email del cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }
     
    /**
     * Método que devuelve el nombre y los dos apellidos del cliente.
     *
     * @return String nombre completo del cliente.
     */
    public String getNombreCompleto() {
        return getNombre() + " " + getApellido1() + " " + getApellido2();
    }

}
