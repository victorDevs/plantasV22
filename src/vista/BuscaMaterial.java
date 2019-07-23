/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import javax.swing.JOptionPane;
import modelo.Materiales;
import persistencia.BD;
import persistencia.MetodosGlobales;

/**
 *
 * @author alber
 */
public class BuscaMaterial extends javax.swing.JDialog {

    /**
     * Creates new form BuscaMaterial
     */
    
    Materiales materiales = new Materiales();
    
    public BuscaMaterial(java.awt.Frame parent, boolean modal) {
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

        jButton1 = new javax.swing.JButton();
        jTxtBuscadorMaterial = new javax.swing.JTextField();
        jCBBuscadorMaterial = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Material");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCBBuscadorMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Opción", "Nombre", "Descripción BM", "Descripción Proveedor", "Proveedor" }));
        jCBBuscadorMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBBuscadorMaterial.setFocusable(false);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar16.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jCBBuscadorMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtBuscadorMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtBuscadorMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCBBuscadorMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if(jCBBuscadorMaterial.getSelectedIndex()==1){
            convertir = "materiales.nombre";
        }
        if(jCBBuscadorMaterial.getSelectedIndex()==2){
            convertir = "materiales.descripcionBM";
        }
        if(jCBBuscadorMaterial.getSelectedIndex()==3){
            convertir = "materialproveedor.descripcionProveedor";
        }
        if(jCBBuscadorMaterial.getSelectedIndex()==4){
            convertir = "proveedores.nombre";
        }
         //FIN DE CONVERSOR

        if(jTxtBuscadorMaterial.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo de texto vacío",
                "Aviso",JOptionPane.WARNING_MESSAGE);
            MetodosGlobales.LimpiaTabla(CatalogoMateriales.jTableMateriales);
            materiales.TablaConsultaMateriales();
            jTxtBuscadorMaterial.requestFocusInWindow();
        }else{
            if (jCBBuscadorMaterial.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(null, "Selecciona una opcicón de busqueda",
                    "Aviso",JOptionPane.WARNING_MESSAGE);
            }else{
                if(BD.conectarBD()){
                    try {
                        MetodosGlobales.LimpiaTabla(CatalogoMateriales.jTableMateriales);
                        materiales.buscarMaterial(convertir, MetodosGlobales.aceptarComillaSimple(jTxtBuscadorMaterial.getText().trim()));
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
        MetodosGlobales.LimpiaTabla(CatalogoMateriales.jTableMateriales);
        MetodosGlobales.LimpiaTabla(CatalogoMateriales.jTableProveedoresMaterial);
        materiales.TablaConsultaMateriales();
        jTxtBuscadorMaterial.requestFocusInWindow();
        jTxtBuscadorMaterial.setText("");
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
            java.util.logging.Logger.getLogger(BuscaMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscaMaterial dialog = new BuscaMaterial(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCBBuscadorMaterial;
    private javax.swing.JTextField jTxtBuscadorMaterial;
    // End of variables declaration//GEN-END:variables
}
