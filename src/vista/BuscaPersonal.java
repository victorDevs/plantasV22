/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;
import modelo.Personal;
import persistencia.BD;
import persistencia.MetodosGlobales;

/**
 *
 * @author alber
 */
public class BuscaPersonal extends javax.swing.JDialog {

    Personal personal = new Personal();
    
    public BuscaPersonal(java.awt.Frame parent, boolean modal) {
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

        jCBBuscadorPersonal = new javax.swing.JComboBox<>();
        jTxtBuscadorPersonal = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Personal");

        jCBBuscadorPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Opción", "Nombre", "A. Paterno", "A. Materno", "Fecha Nacimiento", "Domicilio", "Teléfono", "Correo", "Proceso" }));
        jCBBuscadorPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBBuscadorPersonal.setFocusable(false);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar16.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jCBBuscadorPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtBuscadorPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtBuscadorPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCBBuscadorPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        MetodosGlobales.LimpiaTabla(CatalogoPersonal.jTablePersonal);
        personal.TablaConsultaPersonal();
        jTxtBuscadorPersonal.requestFocusInWindow();
        jTxtBuscadorPersonal.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String convertir="";//variaable para convertir el combobox a columnas de la base de datos
        //INICIA EL CONVERSOR DE LOS CAMPOS PARA LA BD
        if(jCBBuscadorPersonal.getSelectedIndex()==1){
            convertir = "nombre";
        }
        if(jCBBuscadorPersonal.getSelectedIndex()==2){
            convertir = "apellidoPaterno";
        }
        if(jCBBuscadorPersonal.getSelectedIndex()==3){
            convertir = "apellidoMaterno";
        }
        if(jCBBuscadorPersonal.getSelectedIndex()==4){
            convertir = "fechaNacimiento";
        }
        if(jCBBuscadorPersonal.getSelectedIndex()==5){
            convertir = "domicilio";
        }
        if(jCBBuscadorPersonal.getSelectedIndex()==6){
            convertir = "telefono";
        }
        if(jCBBuscadorPersonal.getSelectedIndex()==7){
            convertir = "correo";
        }
        if(jCBBuscadorPersonal.getSelectedIndex()==8){
            convertir = "proceso";
        }
        //FIN DE CONVERSOR

        if(jTxtBuscadorPersonal.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo de texto vacío",
                "Aviso",JOptionPane.WARNING_MESSAGE);
            MetodosGlobales.LimpiaTabla(CatalogoPersonal.jTablePersonal);
            personal.TablaConsultaPersonal();
            jTxtBuscadorPersonal.requestFocusInWindow();
        }else{
            if (jCBBuscadorPersonal.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(null, "Selecciona una opcicón de busqueda",
                    "Aviso",JOptionPane.WARNING_MESSAGE);
            }else{
                if(BD.conectarBD()){
                    try {
                          
                        MetodosGlobales.LimpiaTabla(CatalogoPersonal.jTablePersonal);
                        personal.buscarPersonal(convertir, MetodosGlobales.aceptarComillaSimple(jTxtBuscadorPersonal.getText().trim()));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "No se consultó  correctamente la tabla de personal: "+e,
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
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscaPersonal dialog = new BuscaPersonal(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> jCBBuscadorPersonal;
    private javax.swing.JTextField jTxtBuscadorPersonal;
    // End of variables declaration//GEN-END:variables
}
