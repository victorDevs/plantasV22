/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Proveedores;
import persistencia.BD;
import static vista.CatalogoProveedores.jTableProveedores;

/**
 *
 * @author alber
 */
public class BuscaProveedor extends javax.swing.JDialog {

    Proveedores prov = new Proveedores();
    
    public BuscaProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jCBBuscadorProveedor = new javax.swing.JComboBox<>();
        jTxtBuscadorProveedor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Proveedor");
        setPreferredSize(new java.awt.Dimension(518, 187));
        setResizable(false);

        jCBBuscadorProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Opción", "Nombre", "Correo", "Domicilio", "Contacto", "Teléfono" }));
        jCBBuscadorProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBBuscadorProveedor.setFocusable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar16.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCBBuscadorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtBuscadorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtBuscadorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCBBuscadorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String convertir="";//variaable para convertir el combobox a columnas de la base de datos
        //INICIA EL CONVERSOR DE LOS CAMPOS PARA LA BD
        if(jCBBuscadorProveedor.getSelectedIndex()==1){
            convertir = "nombre";
        }
        if(jCBBuscadorProveedor.getSelectedIndex()==2){
            convertir = "correo";
        }
        if(jCBBuscadorProveedor.getSelectedIndex()==3){
            convertir = "domicilio";
        }
        if(jCBBuscadorProveedor.getSelectedIndex()==4){
            convertir = "contacto";
        }
        if(jCBBuscadorProveedor.getSelectedIndex()==5){
            convertir = "tel";
        }
        //FIN DE CONVERSOR

        if(jTxtBuscadorProveedor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo de texto vacío",
                "Aviso",JOptionPane.WARNING_MESSAGE);
            LimpiaTablaProveedores();
            prov.TablaConsultaProveedores();
            jTxtBuscadorProveedor.requestFocusInWindow();
        }else{
            if (jCBBuscadorProveedor.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(null, "Selecciona una opcicón de busqueda",
                    "Aviso",JOptionPane.WARNING_MESSAGE);
            }else{
                if(BD.conectarBD()){
                    try {
                        LimpiaTablaProveedores();
                        prov.buscarProveedor(convertir, jTxtBuscadorProveedor.getText().trim());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "No se consultó  correctamente la tabla de proveedores: "+e,
                            "Aviso",JOptionPane.WARNING_MESSAGE);
                        BD.cerrarConexion();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error de conexión",
                        "Error",JOptionPane.ERROR_MESSAGE);
                    BD.cerrarConexion();
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        LimpiaTablaProveedores();
        prov.TablaConsultaProveedores();
        jTxtBuscadorProveedor.requestFocusInWindow();
        jTxtBuscadorProveedor.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscaProveedor dialog = new BuscaProveedor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
      public void LimpiaTablaProveedores(){
        try {
            DefaultTableModel modelo = (DefaultTableModel)jTableProveedores.getModel();
            int filas = jTableProveedores.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            System.out.println("Limpieza de tabla exitosa! en busqueda de proveedor");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al intentar limpiar la tabla Proveedores: "+e,
                    "Tabla Proveedores",JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCBBuscadorProveedor;
    private javax.swing.JTextField jTxtBuscadorProveedor;
    // End of variables declaration//GEN-END:variables
}
