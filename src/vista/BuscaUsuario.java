/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuarios;
import persistencia.BD;
import static vista.CatalogoUsuarios.jTableUsuarios;

/**
 *
 * @author Luis
 */
public class BuscaUsuario extends javax.swing.JDialog {

    Usuarios usuarios = new Usuarios();
    
    public BuscaUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCBBuscadorUsuarios = new javax.swing.JComboBox<>();
        jTxtBuscadorUsuario = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnBuscarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Usuario");

        jCBBuscadorUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Opción", "Nombre", "Usuario", "Perfil", "Rol", "Correo" }));
        jCBBuscadorUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBBuscadorUsuarios.setFocusable(false);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar16.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscarUsuario.setText("Buscar");
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarUsuario)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCBBuscadorUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtBuscadorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jTxtBuscadorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCBBuscadorUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(btnBuscarUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        LimpiaTablaUsuarios();
        usuarios.TablaConsultaUsuarios();
        jTxtBuscadorUsuario.requestFocusInWindow();
        jTxtBuscadorUsuario.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        String convertir="";//variaable para convertir el combobox a columnas de la base de datos
        //INICIA EL CONVERSOR DE LOS CAMPOS PARA LA BD
        if(jCBBuscadorUsuarios.getSelectedIndex()==1){
            convertir = "nombre";
        }
        if(jCBBuscadorUsuarios.getSelectedIndex()==2){
            convertir = "usuario";
        }
        if(jCBBuscadorUsuarios.getSelectedIndex()==3){
            convertir = "perfil";
        }
        if(jCBBuscadorUsuarios.getSelectedIndex()==4){
            convertir = "rol";
        }
        if(jCBBuscadorUsuarios.getSelectedIndex()==5){
            convertir = "correo";
        }
        //FIN DE CONVERSOR

        if(jTxtBuscadorUsuario.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo de texto vacío",
                "Aviso",JOptionPane.WARNING_MESSAGE);
            LimpiaTablaUsuarios();
            usuarios.TablaConsultaUsuarios();
            jTxtBuscadorUsuario.requestFocusInWindow();
        }else{
            if (jCBBuscadorUsuarios.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(null, "Selecciona una opcicón de busqueda",
                    "Aviso",JOptionPane.WARNING_MESSAGE);
            }else{
                if(BD.conectarBD()){
                    try {
                        LimpiaTablaUsuarios();
                        usuarios.buscarUsuario(convertir, jTxtBuscadorUsuario.getText().trim());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "No se consultó  correctamente la tabla de usuarios: "+e,
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
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    public void LimpiaTablaUsuarios(){
        try {
            DefaultTableModel modelo = (DefaultTableModel)jTableUsuarios.getModel();
            int filas = jTableUsuarios.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            System.out.println("Limpieza de tabla exitosa! en busqueda de usuario");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al intentar limpiar la tabla usuario: "+e,
                    "Tabla Proveedores",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(BuscaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscaUsuario dialog = new BuscaUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> jCBBuscadorUsuarios;
    private javax.swing.JTextField jTxtBuscadorUsuario;
    // End of variables declaration//GEN-END:variables
}
