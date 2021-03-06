package es.fdeazagra.tpvfastfood.vistas;

import es.fdeazagra.tpvfastfood.acciones.AccionesTicket;
import es.fdeazagra.tpvfastfood.gestionbd.Producto;
import es.fdeazagra.tpvfastfood.principal.TPVFrame;

/**
 * Clase con el panel con los productos de la categoría extras.
 *
 * @author Fernando Martínez de Azagra
 */
public class PanelExtras extends javax.swing.JPanel {

    private final TPVFrame frame;
    
    /**
     * Constructor del panel con los productos de la categoría extras.
     * 
     * @param frame ventana principal de la aplicación.
     */
    public PanelExtras(TPVFrame frame) {
        initComponents();
        this.frame = frame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProducto13 = new javax.swing.JButton();
        btnProducto14 = new javax.swing.JButton();
        btnProducto15 = new javax.swing.JButton();
        btnProducto16 = new javax.swing.JButton();
        btnProducto17 = new javax.swing.JButton();
        btnProducto18 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(200, 300));
        setPreferredSize(new java.awt.Dimension(400, 600));
        setLayout(new java.awt.GridLayout(3, 2, 3, 3));

        btnProducto13.setBackground(new java.awt.Color(255, 153, 0));
        btnProducto13.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto13.setText("Patatas");
        btnProducto13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto13ActionPerformed(evt);
            }
        });
        add(btnProducto13);

        btnProducto14.setBackground(new java.awt.Color(255, 153, 0));
        btnProducto14.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto14.setText("Nuggets");
        btnProducto14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto14ActionPerformed(evt);
            }
        });
        add(btnProducto14);

        btnProducto15.setBackground(new java.awt.Color(255, 153, 0));
        btnProducto15.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto15.setText("Alitas");
        btnProducto15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto15ActionPerformed(evt);
            }
        });
        add(btnProducto15);

        btnProducto16.setBackground(new java.awt.Color(255, 153, 0));
        btnProducto16.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto16.setText("Ensalada");
        btnProducto16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto16ActionPerformed(evt);
            }
        });
        add(btnProducto16);

        btnProducto17.setBackground(new java.awt.Color(255, 153, 0));
        btnProducto17.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto17.setText("Helado");
        btnProducto17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto17ActionPerformed(evt);
            }
        });
        add(btnProducto17);

        btnProducto18.setBackground(new java.awt.Color(255, 153, 0));
        btnProducto18.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto18.setText("Tarta");
        btnProducto18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto18ActionPerformed(evt);
            }
        });
        add(btnProducto18);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que acciona el botón para añadir el producto 13 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto13ActionPerformed
        
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(13));
        accion.productoATicket(Producto.listaDeProductos.get(13));
    }//GEN-LAST:event_btnProducto13ActionPerformed

    /**
     * Método que acciona el botón para añadir el producto 14 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto14ActionPerformed
        
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(14));
        accion.productoATicket(Producto.listaDeProductos.get(14));
    }//GEN-LAST:event_btnProducto14ActionPerformed

    /**
     * Método que acciona el botón para añadir el producto 15 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto15ActionPerformed
        
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(15));
        accion.productoATicket(Producto.listaDeProductos.get(15));
    }//GEN-LAST:event_btnProducto15ActionPerformed
/**
     * Método que acciona el botón para añadir el producto 16 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto16ActionPerformed
        
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(16));
        accion.productoATicket(Producto.listaDeProductos.get(16));
    }//GEN-LAST:event_btnProducto16ActionPerformed

    /**
     * Método que acciona el botón para añadir el producto 17 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto17ActionPerformed
        
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(17));
        accion.productoATicket(Producto.listaDeProductos.get(17));
    }//GEN-LAST:event_btnProducto17ActionPerformed

    /**
     * Método que acciona el botón para añadir el producto 18 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto18ActionPerformed
        
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(18));
        accion.productoATicket(Producto.listaDeProductos.get(18));
    }//GEN-LAST:event_btnProducto18ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProducto13;
    private javax.swing.JButton btnProducto14;
    private javax.swing.JButton btnProducto15;
    private javax.swing.JButton btnProducto16;
    private javax.swing.JButton btnProducto17;
    private javax.swing.JButton btnProducto18;
    // End of variables declaration//GEN-END:variables
}
