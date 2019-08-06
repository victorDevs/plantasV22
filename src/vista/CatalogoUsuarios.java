/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuarios;
import persistencia.BD;
import persistencia.MetodosGlobales;

/**
 *
 * @author Luis
 */
public class CatalogoUsuarios extends javax.swing.JInternalFrame {

    
    private static CatalogoUsuarios catalogoUsuarios;
    
    Usuarios usuarios = new Usuarios();
    
    MetodosGlobales metodosGlobales = new MetodosGlobales();//PARA PODER CONSUMIR LOS MÉTODOS QUE TODO EL PROYECTO PUEDA UTILIZAR, ESTA CLASE SE UTILIZA CUANDO LOS MÉTODOS NO SON ESTATICOS
    
    public static CatalogoUsuarios getInstancia(){
        if(catalogoUsuarios == null){
            catalogoUsuarios = new CatalogoUsuarios();
        }
        return catalogoUsuarios;
    }
    
    public CatalogoUsuarios() {
        initComponents();
        LimpiaTablaUsuarios();//LIMPIAR TABLA USUARIOS
        usuarios.TablaConsultaUsuarios();//CONSULTAR TABLA USUARIOS
        
        //LLAMAR COMBO PARA MOSTRAR EL LISTADO DEL PERFIL PARA EL USUARIO
        usuarios.ListadoComboPerfil(jCBPerfil);
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCBPerfil = new javax.swing.JComboBox<>();
        jTxtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtUsuario = new javax.swing.JTextField();
        jbtnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jCBRol = new javax.swing.JComboBox<>();
        jbtnModificar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnLimpiar = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTxtCorreo = new javax.swing.JTextField();
        jTxtContrasena = new javax.swing.JPasswordField();
        jTxtRepeContrasena = new javax.swing.JPasswordField();

        setClosable(true);
        setTitle("Catálago de Usuarios");

        jLabel1.setText("Nombre");

        jCBPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Perfil");

        jLabel3.setText("Usuario");

        jLabel4.setText("Contraseña");

        jbtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar16.png"))); // NOI18N
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jLabel5.setText("Rol");

        jCBRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/girar.png"))); // NOI18N
        jbtnModificar.setText("Modificar");
        jbtnModificar.setEnabled(false);
        jbtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarActionPerformed(evt);
            }
        });

        jbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basura.png"))); // NOI18N
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.setEnabled(false);

        jbtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar16.png"))); // NOI18N
        jbtnLimpiar.setText("Limpiar");

        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jbtnBuscar.setText("Búsqueda");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("Repetir Contraseña");

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Usuario", "Perfil", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsuarios);
        if (jTableUsuarios.getColumnModel().getColumnCount() > 0) {
            jTableUsuarios.getColumnModel().getColumn(0).setMinWidth(35);
            jTableUsuarios.getColumnModel().getColumn(0).setMaxWidth(35);
        }

        jLabel7.setText("Correo Institucional");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(701, 701, 701)
                                .addComponent(jbtnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(54, 54, 54)
                                                        .addComponent(jCBPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel2)))
                                            .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTxtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTxtRepeContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(52, 52, 52)
                                        .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jbtnAgregar)
                                .addGap(47, 47, 47)
                                .addComponent(jbtnModificar)
                                .addGap(60, 60, 60)
                                .addComponent(jbtnEliminar)
                                .addGap(61, 61, 61)
                                .addComponent(jbtnLimpiar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnBuscar)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jCBPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jTxtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtRepeContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAgregar)
                    .addComponent(jbtnModificar)
                    .addComponent(jbtnEliminar)
                    .addComponent(jbtnLimpiar))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        Frame frame = JOptionPane.getFrameForComponent(this);
        BuscaUsuario buscaUsuario = new BuscaUsuario(frame,true);
        Dimension desktopSize = Main.jDesktopMain.getSize();
        Dimension FrameSize = buscaUsuario.getSize();
        buscaUsuario.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        buscaUsuario.show();
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jTableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuariosMouseClicked
        jbtnAgregar.setEnabled(false);
        jbtnEliminar.setEnabled(true);
        jbtnModificar.setEnabled(true);
        jbtnLimpiar.setEnabled(true);
        
        if (evt.getClickCount() == 1) {
            usuarios.ApuntaUsuario();
            jTxtNombre.setText(usuarios.getNombre());
            jTxtUsuario.setText(usuarios.getUsuario());
            jTxtContrasena.setText(usuarios.getContrasena());
            jTxtRepeContrasena.setText(usuarios.getContrasena());
            jTxtCorreo.setText(usuarios.getCorreo());
            jCBPerfil.setSelectedItem(usuarios.getPerfil());
            jCBRol.setSelectedItem(usuarios.getRol());
        }
    }//GEN-LAST:event_jTableUsuariosMouseClicked

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        // TODO add your handling code here:
        if (jTxtNombre.getText().equals("") || jCBPerfil.getSelectedIndex()==0
                || jTxtUsuario.getText().equals("") || jTxtContrasena.getText().equals("") || jTxtRepeContrasena.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Llena todos los campos obligatorios",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
        } else {
            if(jTxtContrasena.getText().trim().equals(jTxtRepeContrasena.getText().trim())){
                if(metodosGlobales.validaCorreo(jTxtCorreo.getText())==false){
                    JOptionPane.showMessageDialog(rootPane, "El correo es incorrecto",
                                    "Aviso",JOptionPane.WARNING_MESSAGE);
                }else{
                    if(BD.conectarBD()){
                        usuarios.setNombre(jTxtNombre.getText());
                        usuarios.setUsuario(jTxtUsuario.getText());
                        usuarios.setPerfil((String)jCBPerfil.getSelectedItem());
                        usuarios.setContrasena(jTxtContrasena.getText());
                        usuarios.setCorreo(jTxtCorreo.getText());
                        try {
                            usuarios.RegistraUsuario();
    //                        ope.buscaUsuario();
                            JOptionPane.showMessageDialog(rootPane, "Registro exitoso",
                                "Aviso",JOptionPane.INFORMATION_MESSAGE);
                            LimpiaCampos();
                            MetodosGlobales.LimpiaTabla(jTableUsuarios);
                            usuarios.TablaConsultaUsuarios();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(rootPane, "No se registro el operador",
                                "Error",JOptionPane.ERROR_MESSAGE);
                            System.out.println("Error al regiatrar un operador: "+e);
                            BD.cerrarConexion();
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Error de conexión",
                                "Error",JOptionPane.ERROR_MESSAGE);
                        BD.cerrarConexion();
                    }
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Las contraseñas deben coincidir",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
                jTxtContrasena.requestFocusInWindow(); 
            }
        }
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed
        if(metodosGlobales.validaCorreo(jTxtCorreo.getText())==false){
                JOptionPane.showMessageDialog(rootPane, "El correo es incorrecto",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
        }else{
            if (jTxtNombre.getText().equals("") || jCBPerfil.getSelectedIndex()==0
                    || jTxtUsuario.getText().equals("") || jTxtContrasena.getText().equals("") || jTxtRepeContrasena.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Llena todos los campos obligatorios",
                                    "Aviso",JOptionPane.WARNING_MESSAGE);
            }else{
                if (JOptionPane.showConfirmDialog(rootPane, "Se modificará el usuario, ¿Desea continuar?",
                        "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 

                    if(BD.conectarBD()){
                        usuarios.setNombre(jTxtNombre.getText());
                        usuarios.setPerfil((String)jCBPerfil.getSelectedItem());
                        usuarios.setUsuario(jTxtUsuario.getText());
                        usuarios.setContrasena(jTxtContrasena.getText());
                        usuarios.setCorreo(jTxtCorreo.getText());                            
                        try {
                            usuarios.ActualizarUsuario(jTableUsuarios);
                            JOptionPane.showMessageDialog(rootPane, "Actualización exitosa",
                                "Aviso",JOptionPane.INFORMATION_MESSAGE);
                            LimpiaCampos();
                            MetodosGlobales.LimpiaTabla(jTableUsuarios);
                            usuarios.TablaConsultaUsuarios();
                            jbtnModificar.setEnabled(false);
                            jbtnEliminar.setEnabled(false);
                            jbtnAgregar.setEnabled(true);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(rootPane, "No se actualizó el usuario: "+e,
                                "Error",JOptionPane.ERROR_MESSAGE);
                            BD.cerrarConexion();
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Error de conexión",
                                "Error",JOptionPane.ERROR_MESSAGE);
                        BD.cerrarConexion();
                    }
                }
            }
        }
    }//GEN-LAST:event_jbtnModificarActionPerformed

    
     public void LimpiaTablaUsuarios(){
        try {
            DefaultTableModel modelo = (DefaultTableModel)jTableUsuarios.getModel();
            int filas = jTableUsuarios.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            System.out.println("Limpieza exitosa!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al intentar limpiar la tabla Clientes: "+e,
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public  void LimpiaCampos(){
        jTxtNombre.setText(null);
        //jCBPerfil.setSelectedIndex(0);
        jTxtUsuario.setText(null);
        jTxtContrasena.setText(null);
        jTxtRepeContrasena.setText(null);
        jTxtCorreo.setText(null);
        jTxtCorreo.setText(null);
        usuarios.ListadoComboPerfil(jCBPerfil);
        
        jbtnAgregar.setEnabled(true);
        jbtnEliminar.setEnabled(false);
        jbtnModificar.setEnabled(false);
        jbtnLimpiar.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCBPerfil;
    private javax.swing.JComboBox<String> jCBRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableUsuarios;
    private javax.swing.JPasswordField jTxtContrasena;
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JPasswordField jTxtRepeContrasena;
    private javax.swing.JTextField jTxtUsuario;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnLimpiar;
    private javax.swing.JButton jbtnModificar;
    // End of variables declaration//GEN-END:variables
}
