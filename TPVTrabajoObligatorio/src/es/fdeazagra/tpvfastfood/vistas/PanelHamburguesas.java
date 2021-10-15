package es.fdeazagra.tpvfastfood.vistas;

import es.fdeazagra.tpvfastfood.acciones.AccionesTicket;
import es.fdeazagra.tpvfastfood.gestionbd.Producto;
import es.fdeazagra.tpvfastfood.principal.TPVFrame;

/**
 * Clase con el panel de los productos de la categoría hamburguesas.
 *
 * @author Fernando Martínez de Azagra
 */
public class PanelHamburguesas extends javax.swing.JPanel {

    private final TPVFrame frame;

    /**
     * Constructor del panel con los productos de la categoría hamburguesas.
     * 
     * @param frame ventana principal de la aplicación.
     */
    public PanelHamburguesas(TPVFrame frame) {
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

        btnProducto7 = new javax.swing.JButton();
        btnProducto8 = new javax.swing.JButton();
        btnProducto9 = new javax.swing.JButton();
        btnProducto10 = new javax.swing.JButton();
        btnProducto11 = new javax.swing.JButton();
        btnProducto12 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(200, 300));
        setPreferredSize(new java.awt.Dimension(400, 600));
        setLayout(new java.awt.GridLayout(3, 2, 3, 3));

        btnProducto7.setBackground(new java.awt.Color(153, 255, 0));
        btnProducto7.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto7.setText("Sencilla");
        btnProducto7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto7ActionPerformed(evt);
            }
        });
        add(btnProducto7);

        btnProducto8.setBackground(new java.awt.Color(153, 255, 0));
        btnProducto8.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto8.setText("Con Queso");
        btnProducto8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto8ActionPerformed(evt);
            }
        });
        add(btnProducto8);

        btnProducto9.setBackground(new java.awt.Color(153, 255, 0));
        btnProducto9.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto9.setText("Con Bacon");
        btnProducto9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto9ActionPerformed(evt);
            }
        });
        add(btnProducto9);

        btnProducto10.setBackground(new java.awt.Color(153, 255, 0));
        btnProducto10.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto10.setText("Doble");
        btnProducto10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto10ActionPerformed(evt);
            }
        });
        add(btnProducto10);

        btnProducto11.setBackground(new java.awt.Color(153, 255, 0));
        btnProducto11.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto11.setText("Especial");
        btnProducto11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto11ActionPerformed(evt);
            }
        });
        add(btnProducto11);

        btnProducto12.setBackground(new java.awt.Color(153, 255, 0));
        btnProducto12.setFont(new java.awt.Font("Century Schoolbook", 1, 21)); // NOI18N
        btnProducto12.setText("Vegana");
        btnProducto12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProducto12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProducto12ActionPerformed(evt);
            }
        });
        add(btnProducto12);
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Método que acciona el botón para añadir el producto 7 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto7ActionPerformed
         
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(7));
        accion.productoATicket(Producto.listaDeProductos.get(7));

    }//GEN-LAST:event_btnProducto7ActionPerformed

    /**
     * Método que acciona el botón para añadir el producto 8 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto8ActionPerformed
        
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(8));
        accion.productoATicket(Producto.listaDeProductos.get(8));
    }//GEN-LAST:event_btnProducto8ActionPerformed

    /**
     * Método que acciona el botón para añadir el producto 9 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto9ActionPerformed
        
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(9));
        accion.productoATicket(Producto.listaDeProductos.get(9));
    }//GEN-LAST:event_btnProducto9ActionPerformed

    /**
     * Método que acciona el botón para añadir el producto 10 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto10ActionPerformed
        
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(10));
        accion.productoATicket(Producto.listaDeProductos.get(10));
    }//GEN-LAST:event_btnProducto10ActionPerformed

    /**
     * Método que acciona el botón para añadir el producto 11 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto11ActionPerformed
        
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(11));
        accion.productoATicket(Producto.listaDeProductos.get(11));
    }//GEN-LAST:event_btnProducto11ActionPerformed

    /**
     * Método que acciona el botón para añadir el producto 12 al ticket.
     * 
     * @param evt ActionEvernt
     */
    private void btnProducto12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProducto12ActionPerformed
        
        AccionesTicket accion = new AccionesTicket(frame);
        accion.productoAPantalla(Producto.listaDeProductos.get(12));
        accion.productoATicket(Producto.listaDeProductos.get(12));
    }//GEN-LAST:event_btnProducto12ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProducto10;
    private javax.swing.JButton btnProducto11;
    private javax.swing.JButton btnProducto12;
    private javax.swing.JButton btnProducto7;
    private javax.swing.JButton btnProducto8;
    private javax.swing.JButton btnProducto9;
    // End of variables declaration//GEN-END:variables
}