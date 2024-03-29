/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.LoginModel;
import modelo.Proveedores;
import persistencia.ProveedoresPersistencia;
import persistencia.BD;
import persistencia.MetodosGlobales;


/**
 *
 * @author vikto
 */
public class CatalogoProveedores extends javax.swing.JInternalFrame {

    Proveedores prov = new Proveedores();
    ProveedoresPersistencia proveePersi = new ProveedoresPersistencia();
    MetodosGlobales metodosGlobales = new MetodosGlobales();
    LoginModel login = new LoginModel();
    
    
     static int clics=0;//para habiitar y deshabilitar el teléfono2
     //VARIABLES PARA CAMBIAR LA IMAGEN DEL BOTÓN QUITAR O AGREGAR TELÉFONO 2
     static ImageIcon iconoBtnAnadir = new ImageIcon("src/imagenes/anadir.png");     
     static ImageIcon iconoBtnQuitar = new ImageIcon("src/imagenes/quitar16px.png");

    /**
     * Creates new form CatalogoMateriales
     */
     
     private static CatalogoProveedores catalogoProveedores;
     
     public static CatalogoProveedores getInstancia(){
         if (catalogoProveedores == null) {
             catalogoProveedores = new CatalogoProveedores();
         }
         return catalogoProveedores;
     }
     
    public CatalogoProveedores() {
        initComponents();
        btnEliminar.setEnabled(false);
        btnModifyProveedor.setEnabled(false);
        MetodosGlobales.LimpiaTabla(jTableProveedores);
        prov.TablaConsultaProveedores();
        
        //Inhabilita el campo del teléfono 2
        jTxtTel2.setEnabled(false);
        jLabel6.setEnabled(false);
        
        proveePersi.ajustarTabla(jTableProveedores);
        
        jTxtNombreProveedor.requestFocusInWindow();//PARA QUE EL PUNTERO SIEMPRE APUNTE AL TEXTBOX DEL NOMBRE DEL PROVEEDOR
        
        jTxtTel.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '-') ) {
                    getToolkit().beep();    
                    e.consume();
                }
                
                if(jTxtTel.getText().length() == 13){
                    getToolkit().beep();
                    e.consume(); 
                }
            }
        });
        
        jTxtTel2.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '-') ) {
                    getToolkit().beep();    
                    e.consume();
                }
                
                if(jTxtTel2.getText().length() == 13){
                    getToolkit().beep();
                    e.consume(); 
                }
            }
        });
        
        //VALIDACIÓN DE PERMISOS
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("C")){
            btnEliminar.setVisible(false);
            btnModifyProveedor.setVisible(false);
            btnAddProveedor.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("R")){
            btnEliminar.setVisible(false);
            btnModifyProveedor.setVisible(false);
            btnBuscar.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("U")){
            btnEliminar.setVisible(false);
            btnAddProveedor.setVisible(false);
            btnBuscar.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("D")){
            btnModifyProveedor.setVisible(false);
            btnAddProveedor.setVisible(false);
            btnBuscar.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("CR")){
            btnModifyProveedor.setVisible(false);
            btnEliminar.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("CU")){
            btnAddProveedor.setVisible(false);
            btnEliminar.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("CD")){
            btnAddProveedor.setVisible(false);
            btnModifyProveedor.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("RD")){
            btnModifyProveedor.setVisible(false);
            btnBuscar.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("RU")){
            btnEliminar.setVisible(false);
            btnBuscar.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("UD")){
            btnAddProveedor.setVisible(false);
            btnBuscar.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("CRU")){
            btnEliminar.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("CUD")){
            btnAddProveedor.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("RUD")){
            btnBuscar.setVisible(false);
        }
        if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("CRD")){
            btnModifyProveedor.setVisible(false);
        }
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
        jTxtNombreProveedor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProveedores = new javax.swing.JTable();
        btnAddProveedor = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jTxtTel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtDomicilio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtContacto = new javax.swing.JTextField();
        jTxtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnModifyProveedor = new javax.swing.JButton();
        btnAgregarTel = new javax.swing.JButton();
        jTxtTel2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Catálogo de Proveedores");
        setAutoscrolls(true);

        jLabel1.setText("Nombre");

        jLabel2.setText("Teléfono");

        jTableProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre de Proveedor", "Domicilio", "Teléfono", "Teléfono 2", "Contacto", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProveedores);
        if (jTableProveedores.getColumnModel().getColumnCount() > 0) {
            jTableProveedores.getColumnModel().getColumn(0).setMinWidth(10);
        }

        btnAddProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar16.png"))); // NOI18N
        btnAddProveedor.setText("Agregar");
        btnAddProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProveedorActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar16.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel3.setText("Domicilio");

        jLabel4.setText("Contacto");

        jTxtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtContactoActionPerformed(evt);
            }
        });

        jLabel5.setText("Correo:");

        btnModifyProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/girar.png"))); // NOI18N
        btnModifyProveedor.setText("Modificar");
        btnModifyProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyProveedorActionPerformed(evt);
            }
        });

        btnAgregarTel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadir.png"))); // NOI18N
        btnAgregarTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTelActionPerformed(evt);
            }
        });

        jLabel6.setText("Teléfono 2");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        btnBuscar.setText("Búsqueda");
        btnBuscar.setFocusable(false);
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
                .addGap(55, 55, 55)
                .addComponent(btnAddProveedor)
                .addGap(42, 42, 42)
                .addComponent(btnModifyProveedor)
                .addGap(45, 45, 45)
                .addComponent(btnEliminar)
                .addGap(46, 46, 46)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTxtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAgregarTel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 354, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarTel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTxtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnModifyProveedor)
                    .addComponent(btnAddProveedor))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtContactoActionPerformed

    private void btnAddProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProveedorActionPerformed
        // TODO add your handling code here:
        if (jTxtNombreProveedor.getText().equals("") || jTxtDomicilio.getText().equals("")
                || jTxtContacto.getText().equals("") || jTxtTel.getText().equals("") || jTxtCorreo.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Llena todos los campos obligatorios",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
        } else {
            if(metodosGlobales.validaCorreo(jTxtCorreo.getText())==false){
                JOptionPane.showMessageDialog(rootPane, "El correo es incorrecto",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
            }else{
                if(BD.conectarBD()){
                    prov.setNombre(jTxtNombreProveedor.getText());
                    prov.setDomicilio(jTxtDomicilio.getText());
                    prov.setTel(jTxtTel.getText());
                    prov.setTel2(jTxtTel2.getText());
                    prov.setContacto(jTxtContacto.getText());
                    prov.setCorreo(jTxtCorreo.getText());
                    try {
                        prov.RegistraProveedor();
//                        ope.buscaUsuario();
                        JOptionPane.showMessageDialog(rootPane, "Registro exitoso",
                            "Aviso",JOptionPane.INFORMATION_MESSAGE);
                        LimpiaCampos();
                        LimpiaTablaProveedores();
                        prov.TablaConsultaProveedores();
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
        }
    }//GEN-LAST:event_btnAddProveedorActionPerformed

    private void jTableProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProveedoresMouseClicked
        // TODO add your handling code here:
        
        
        
        if (evt.getClickCount() == 1) {
            if(login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("R") || login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("RD") 
                    || login.validaPermisos("proveedores", Main.menuNomUsuario.getText()).equals("CRD")){
                btnEliminar.setEnabled(true);
                btnLimpiar.setEnabled(true);
            }else{
                btnAddProveedor.setEnabled(false);
                btnEliminar.setEnabled(true);
                btnModifyProveedor.setEnabled(true);
                btnLimpiar.setEnabled(true);
                
                prov.ApuntaProveedor();
                Date date = null;
                jTxtNombreProveedor.setText(prov.getNombre());
                jTxtDomicilio.setText(prov.getDomicilio());
                jTxtTel.setText(prov.getTel());
                jTxtTel2.setText(prov.getTel2());
                jTxtContacto.setText(prov.getContacto());
                jTxtCorreo.setText(prov.getCorreo());
                //VALIDA SI EL CAMPO DEL TELÉFONO 2 TIENE NÚMERO
                if(jTxtTel2.getText().equals("")){
                    jTxtTel2.setEnabled(false);
                    jLabel6.setEnabled(false);
                    btnAgregarTel.setIcon(iconoBtnAnadir);
                    clics = 0;//significa que no ha dado clic
                }else{
                    jTxtTel2.setEnabled(true);
                    jLabel6.setEnabled(true);
                    btnAgregarTel.setIcon(iconoBtnQuitar);
                    clics = 1;//sifnifica que ha dado un clic
                }
                //FIN DE LA VALIDACIÓN TELÉFONO 2
            }
        }
        
    }//GEN-LAST:event_jTableProveedoresMouseClicked

    private void btnModifyProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyProveedorActionPerformed
        // TODO add your handling code here:
        if(metodosGlobales.validaCorreo(jTxtCorreo.getText())==false){
                JOptionPane.showMessageDialog(rootPane, "El correo es incorrecto",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
        }else{
            if (JOptionPane.showConfirmDialog(rootPane, "Se modificará el proveedor, ¿Desea continuar?",
                "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 
                btnModifyProveedor.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnAddProveedor.setEnabled(true);
                if (jTxtNombreProveedor.getText().equals("") || jTxtDomicilio.getText().equals("")
                        || jTxtContacto.getText().equals("") || jTxtTel.getText().equals("") || jTxtCorreo.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Llena todos los campos obligatorios",
                                        "Aviso",JOptionPane.WARNING_MESSAGE);
                } else {
                    if(BD.conectarBD()){
                        prov.setNombre(jTxtNombreProveedor.getText());
                        prov.setDomicilio(jTxtDomicilio.getText());
                        prov.setTel(jTxtTel.getText());
                        prov.setTel2(jTxtTel2.getText());
                        prov.setContacto(jTxtContacto.getText());
                        prov.setCorreo(jTxtCorreo.getText());                              
                        try {
                            prov.ActualizarProveedor(jTableProveedores);
                            JOptionPane.showMessageDialog(rootPane, "Actualización exitosa",
                                "Aviso",JOptionPane.INFORMATION_MESSAGE);
                            LimpiaCampos();
                            LimpiaTablaProveedores();
                            prov.TablaConsultaProveedores();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(rootPane, "No se actualizó el proveedor: "+e,
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
    }//GEN-LAST:event_btnModifyProveedorActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        LimpiaCampos();
        
        MetodosGlobales.LimpiaTabla(jTableProveedores);
        prov.TablaConsultaProveedores();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(prov.validaProveedorMaterial(jTableProveedores) == 1){
            JOptionPane.showMessageDialog(rootPane, "No es posible eliminar el proveedor.\n Este proveedor esta ligado a uno o más materiales.",
                        "Aviso",JOptionPane.WARNING_MESSAGE);
            BD.cerrarConexion();
        }else{
            if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el proveedor, ¿Desea continuar?",
                "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){    
                btnModifyProveedor.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnAddProveedor.setEnabled(true);
                if(BD.conectarBD()){
                    try {
                        prov.EliminaProveedor(jTableProveedores);
                        JOptionPane.showMessageDialog(rootPane, "El proveedor se eliminó con éxito",
                            "Aviso",JOptionPane.INFORMATION_MESSAGE);
                        LimpiaCampos();
                        LimpiaTablaProveedores();
                        prov.TablaConsultaProveedores();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "No se eliminó el proveedor: "+e,
                        "Aviso",JOptionPane.WARNING_MESSAGE);
                        BD.cerrarConexion();
                    }
                }
            }else{
                BD.cerrarConexion();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTelActionPerformed
       
        if(clics == 0){
            jTxtTel2.setEnabled(true);
            jLabel6.setEnabled(true);
            btnAgregarTel.setIcon(iconoBtnQuitar);
            clics = 1;
            jTxtTel2.requestFocusInWindow();//PARA QUE EL PUNTERO SIEMPRE APUNTE AL TEXTBOX DEL TEL2
        }else{
            if(clics == 1){
                jTxtTel2.setEnabled(false);
                jLabel6.setEnabled(false); 
                btnAgregarTel.setIcon(iconoBtnAnadir);       
                clics = 0;
                jTxtTel2.setText("");
            }
        }
        
        
        
        
    }//GEN-LAST:event_btnAgregarTelActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
//        BuscadorProveedor miVentanaBuscar = null;
//        
//        miVentanaBuscar = new BuscadorProveedor(miVentanaBuscar,true);
//        miVentanaBuscar.setVisible(true);
        

//        BuscarProveedor buscarProveedor = new BuscarProveedor();
//        Main.jDesktopMain.add(buscarProveedor);
//        buscarProveedor.toFront();
//        buscarProveedor.setVisible(true);
//        Dimension desktopSize = Main.jDesktopMain.getSize();
//        Dimension FrameSize = buscarProveedor.getSize();
//        buscarProveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
//        buscarProveedor.show();
        Frame frame = JOptionPane.getFrameForComponent(this);
        BuscaProveedor buscaProveedor = new BuscaProveedor(frame,true);
        Dimension desktopSize = Main.jDesktopMain.getSize();
        Dimension FrameSize = buscaProveedor.getSize();
        buscaProveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        buscaProveedor.show();
        
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void LimpiaTablaProveedores(){
        try {
            DefaultTableModel modelo = (DefaultTableModel)jTableProveedores.getModel();
            int filas = jTableProveedores.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            System.out.println("Limpieza exitosa!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al intentar limpiar la tabla Proveedores: "+e,
                    "Tabla Proveedores",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void LimpiaCampos(){
        jTxtNombreProveedor.setText(null);
        jTxtDomicilio.setText(null);
        jTxtTel.setText(null);
        jTxtContacto.setText(null);
        jTxtCorreo.setText(null);
        jTxtTel2.setText(null);
        
        jTxtTel2.setEnabled(false);
        jLabel6.setEnabled(false);
        btnAgregarTel.setIcon(iconoBtnAnadir);
        clics = 0;//sifnifica que no ha dado un clic
        
        jTxtNombreProveedor.requestFocusInWindow();//PARA QUE EL PUNTERO SIEMPRE APUNTE AL TEXTBOX DEL NOMBRE DEL PROVEEDOR
        
        btnAddProveedor.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModifyProveedor.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAddProveedor;
    public static javax.swing.JButton btnAgregarTel;
    private javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    public static javax.swing.JButton btnModifyProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableProveedores;
    public static javax.swing.JTextField jTxtContacto;
    public static javax.swing.JTextField jTxtCorreo;
    public static javax.swing.JTextField jTxtDomicilio;
    public static javax.swing.JTextField jTxtNombreProveedor;
    public static javax.swing.JTextField jTxtTel;
    public static javax.swing.JTextField jTxtTel2;
    // End of variables declaration//GEN-END:variables
}
