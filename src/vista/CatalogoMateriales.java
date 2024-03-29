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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.LoginModel;
import modelo.Materiales;
import persistencia.BD;
import persistencia.MetodosGlobales;

/**
 *
 * @author vikto
 */
public class CatalogoMateriales extends javax.swing.JInternalFrame {

    Materiales materiales = new Materiales();
    LoginModel login = new LoginModel();
    
    //OBJETITO PARA HACER UNA INSTANCIA
    private static CatalogoMateriales catalogoMateriales;
    
    
//    ImageIcon iconModif = new ImageIcon(getClass().getResource("/imagenes/editar.png"));
//    ImageIcon iconElimina = new ImageIcon(getClass().getResource("/imagenes/quitar.png"));
    
    //CREA INTANCIA, PARA CUANDO SEA LLAMADA SE ABRÁ SOLAMENTE UNA VEZ
    public static CatalogoMateriales getInstancia(){
        if(catalogoMateriales == null){
            catalogoMateriales = new CatalogoMateriales();
        }
            return catalogoMateriales;
    }
    
    public CatalogoMateriales() {
        initComponents();
        
        jbtnEliminarMaterial.setEnabled(false);
        jbtnModificarMaterial.setEnabled(false);
        
        MetodosGlobales.LimpiaTabla(jTableMateriales);
        materiales.TablaConsultaMateriales(); 
        
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("C")){
            jbtnEliminarMaterial.setVisible(false);
            jbtnModificarMaterial.setVisible(false);
            jbtnAgregarMaterial.setVisible(false);
            jbtnAgregarProveedorMaterial.setVisible(false);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(5)).setWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(5)).setMinWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(5)).setMaxWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(6)).setWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(6)).setMinWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(6)).setMaxWidth(0);
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("R")){
            jBtnBuscarMaterial.setVisible(false);
            jbtnEliminarMaterial.setVisible(false);
            jbtnModificarMaterial.setVisible(false);
            
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("U")){
            jBtnBuscarMaterial.setVisible(false);
            jbtnEliminarMaterial.setVisible(false);
            jbtnModificarMaterial.setVisible(true);
            jbtnAgregarMaterial.setVisible(false);
            jbtnAgregarProveedorMaterial.setVisible(false);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(6)).setWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(6)).setMinWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(6)).setMaxWidth(0);
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("D")){
            jBtnBuscarMaterial.setVisible(false);
            jbtnModificarMaterial.setVisible(false);
            jbtnAgregarMaterial.setVisible(false);
            jbtnAgregarProveedorMaterial.setVisible(false);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(5)).setWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(5)).setMinWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(5)).setMaxWidth(0);
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("CR")){
            jbtnEliminarMaterial.setVisible(false);
            jbtnModificarMaterial.setVisible(false);
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("CU")){
            jbtnEliminarMaterial.setVisible(false);
            jbtnAgregarMaterial.setVisible(false);
            jbtnAgregarProveedorMaterial.setVisible(false);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(6)).setWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(6)).setMinWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(6)).setMaxWidth(0);
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("CD")){
            jbtnAgregarMaterial.setVisible(false);
            jbtnModificarMaterial.setVisible(false);
            jbtnAgregarProveedorMaterial.setVisible(false);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(5)).setWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(5)).setMinWidth(0);
            jTableProveedoresMaterial.getColumn(jTableProveedoresMaterial.getColumnName(5)).setMaxWidth(0);
        }
         if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("RD")){
            jbtnModificarMaterial.setVisible(false);
            jBtnBuscarMaterial.setVisible(false);
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("RU")){
            jbtnEliminarMaterial.setVisible(false);
            jBtnBuscarMaterial.setVisible(false);
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("UD")){
            jbtnAgregarMaterial.setVisible(false);
            jBtnBuscarMaterial.setVisible(false);
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("CRU")){
            jbtnEliminarMaterial.setVisible(false);
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("CUD")){
            jbtnAgregarMaterial.setVisible(false);
            jbtnAgregarProveedorMaterial.setVisible(false);
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("RUD")){
            jBtnBuscarMaterial.setVisible(false);
        }
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("CRD")){
            jbtnModificarMaterial.setVisible(false);
        }
        
        
        
//        DefaultTableModel modelo = (DefaultTableModel)jTableProveedoresMaterial.getModel();
//        jTableProveedoresMaterial.setDefaultRenderer(Object.class, new IconCellRenderer());
//        JButton btnModificar = new JButton(iconModif);
//        btnModificar.setName("modif");
//        JButton btnEliminar = new JButton(iconElimina);
//        btnEliminar.setName("elimi");
// 
//
//        Object[] fila = new Object[5];
//        for (int i = 0; i < 10; i++) {
//
//        Object nuevo[] ={"","","","",btnModificar,btnEliminar};
//        modelo.addRow(nuevo);
//        }

//      ACEPTA PURO NÚNERO
        jTxtRendimiento.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                //if(!Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
                if(!Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)){
                    getToolkit().beep();
                    e.consume();
                    //JOptionPane.showMessageDialog(rootPane, "Ingresa números");
                }
            }
        });
        //ACEPTA NÚMERO CON PUNTO DECIMAL
        jTxtPrecio.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.' || jTxtPrecio.getText().contains(".")) ) {
                    getToolkit().beep();    
                    e.consume();
                }
            }
        });
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
        jTxtNombreMaterial = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMateriales = new javax.swing.JTable();
        jbtnAgregarMaterial = new javax.swing.JButton();
        jbtnEliminarMaterial = new javax.swing.JButton();
        jbtnLimpiarMaterial = new javax.swing.JButton();
        jbtnModificarMaterial = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCBUnidad = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTxtRendimiento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtDescripciónBM = new javax.swing.JTextField();
        jbtnAgregarProveedorMaterial = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProveedoresMaterial = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jBtnBuscarMaterial = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxtPrecio = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Catálogo de Materiales");
        setAutoscrolls(true);

        jLabel1.setText("Nombre:");

        jTableMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre de Material", "Unidad", "Rendimiento", "Descripción BM", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMateriales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMaterialesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMateriales);
        if (jTableMateriales.getColumnModel().getColumnCount() > 0) {
            jTableMateriales.getColumnModel().getColumn(0).setMinWidth(30);
            jTableMateriales.getColumnModel().getColumn(0).setMaxWidth(30);
            jTableMateriales.getColumnModel().getColumn(2).setMinWidth(60);
            jTableMateriales.getColumnModel().getColumn(2).setMaxWidth(60);
            jTableMateriales.getColumnModel().getColumn(3).setMinWidth(90);
            jTableMateriales.getColumnModel().getColumn(3).setMaxWidth(90);
            jTableMateriales.getColumnModel().getColumn(5).setMinWidth(75);
            jTableMateriales.getColumnModel().getColumn(5).setMaxWidth(75);
        }

        jbtnAgregarMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar16.png"))); // NOI18N
        jbtnAgregarMaterial.setText("Agregar");
        jbtnAgregarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarMaterialActionPerformed(evt);
            }
        });

        jbtnEliminarMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basura.png"))); // NOI18N
        jbtnEliminarMaterial.setText("Eliminar");
        jbtnEliminarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarMaterialActionPerformed(evt);
            }
        });

        jbtnLimpiarMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar16.png"))); // NOI18N
        jbtnLimpiarMaterial.setText("Limpiar");
        jbtnLimpiarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimpiarMaterialActionPerformed(evt);
            }
        });

        jbtnModificarMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/girar.png"))); // NOI18N
        jbtnModificarMaterial.setText("Modificar");
        jbtnModificarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarMaterialActionPerformed(evt);
            }
        });

        jLabel3.setText("Unidad");

        jCBUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Unidad", "LAM", "Pza", "Lat", "Por", "Lt", "Rol", "Mil", "M2" }));

        jLabel4.setText("Rendimiento");

        jTxtRendimiento.setToolTipText("");

        jLabel5.setText("Descripción BM");

        jbtnAgregarProveedorMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadir.png"))); // NOI18N
        jbtnAgregarProveedorMaterial.setText("Seleccionar Proveedores");
        jbtnAgregarProveedorMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarProveedorMaterialActionPerformed(evt);
            }
        });

        jTableProveedoresMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Id Proveedor", "Proveedor", "Tipo Proveedor", "Descripción Proveedor", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProveedoresMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProveedoresMaterialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProveedoresMaterial);
        if (jTableProveedoresMaterial.getColumnModel().getColumnCount() > 0) {
            jTableProveedoresMaterial.getColumnModel().getColumn(0).setMinWidth(40);
            jTableProveedoresMaterial.getColumnModel().getColumn(0).setMaxWidth(40);
            jTableProveedoresMaterial.getColumnModel().getColumn(1).setMinWidth(85);
            jTableProveedoresMaterial.getColumnModel().getColumn(1).setMaxWidth(85);
            jTableProveedoresMaterial.getColumnModel().getColumn(3).setMinWidth(100);
            jTableProveedoresMaterial.getColumnModel().getColumn(3).setMaxWidth(100);
            jTableProveedoresMaterial.getColumnModel().getColumn(5).setMinWidth(50);
            jTableProveedoresMaterial.getColumnModel().getColumn(5).setMaxWidth(50);
            jTableProveedoresMaterial.getColumnModel().getColumn(6).setMinWidth(65);
            jTableProveedoresMaterial.getColumnModel().getColumn(6).setMaxWidth(65);
        }

        jLabel7.setText("Proveedores");

        jBtnBuscarMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jBtnBuscarMaterial.setText("Busqueda");
        jBtnBuscarMaterial.setFocusable(false);
        jBtnBuscarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarMaterialActionPerformed(evt);
            }
        });

        jLabel2.setText("Materiales");

        jLabel6.setText("Precio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jbtnAgregarMaterial)
                .addGap(47, 47, 47)
                .addComponent(jbtnModificarMaterial)
                .addGap(49, 49, 49)
                .addComponent(jbtnEliminarMaterial)
                .addGap(65, 65, 65)
                .addComponent(jbtnLimpiarMaterial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnBuscarMaterial))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(263, 780, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtNombreMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtDescripciónBM, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jbtnAgregarProveedorMaterial)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jBtnBuscarMaterial)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtNombreMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jCBUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtDescripciónBM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnAgregarProveedorMaterial))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAgregarMaterial)
                    .addComponent(jbtnEliminarMaterial)
                    .addComponent(jbtnLimpiarMaterial)
                    .addComponent(jbtnModificarMaterial))
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAgregarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarMaterialActionPerformed

        
        if (jTxtNombreMaterial.getText().equals("") || jCBUnidad.getSelectedIndex()==0
                || jTxtRendimiento.getText().equals("") || jTxtPrecio.getText().equals("") 
                || jTxtDescripciónBM.getText().equals("")) {//VALIDA QUE NO HAYA CAMPOS VACÍOS
            JOptionPane.showMessageDialog(rootPane, "Llena todos los campos obligatorios",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
        } else {
            if(materiales.noRepetirMaterial(jTxtNombreMaterial.getText().trim())==1){//VALIDA SI EL MATERIAL YA SE ENCUENTRA REGISTRADO EN LA BD
                JOptionPane.showMessageDialog(rootPane, "Lo sentimos. Este material ya existe",
                                "Aviso",JOptionPane.WARNING_MESSAGE); 
            }else{
                if(jTableProveedoresMaterial.getRowCount() <=0){//VALIDA QUE NO ESTE LA TABLA DE PROVEEDORES VACÍA
                    JOptionPane.showMessageDialog(rootPane, "Ingresa al menos un Proveedor para registrar el Material",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
                }else{
                    if(BD.conectarBD()){
                        materiales.setNombre(jTxtNombreMaterial.getText());
                        materiales.setUnidad(jCBUnidad.getSelectedItem().toString());
                        materiales.setRendimiento(jTxtRendimiento.getText());
                        materiales.setPrecio(Double.parseDouble(jTxtPrecio.getText()));
                        materiales.setDescripcionBM(jTxtDescripciónBM.getText());

                        try {
                            materiales.registrarMaterial();
    //                        ope.buscaUsuario();
                            JOptionPane.showMessageDialog(rootPane, "Registro exitoso",
                                "Aviso",JOptionPane.INFORMATION_MESSAGE);
                            LimpiaCampos();
                            MetodosGlobales.LimpiaTabla(jTableMateriales);
                            materiales.TablaConsultaMateriales();
                            MetodosGlobales.LimpiaTabla(jTableProveedoresMaterial);
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
            
        }
    }//GEN-LAST:event_jbtnAgregarMaterialActionPerformed

    private void jbtnAgregarProveedorMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarProveedorMaterialActionPerformed
        Frame frame = JOptionPane.getFrameForComponent(this);
        AgregarProveedorMaterial agregarProveedor = new AgregarProveedorMaterial(frame,true);
        Dimension desktopSize = Main.jDesktopMain.getSize();
        Dimension FrameSize = agregarProveedor.getSize();
        agregarProveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        agregarProveedor.show();
    }//GEN-LAST:event_jbtnAgregarProveedorMaterialActionPerformed

    private void jTableMaterialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMaterialesMouseClicked
        if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("R") || login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("RD") || 
                login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("RU")){
            JOptionPane.showMessageDialog(rootPane, "Lo sentimos, no tienes los permisos para consultar la información",
                                "Aviso",JOptionPane.INFORMATION_MESSAGE);
            jbtnEliminarMaterial.setEnabled(true);
            jbtnModificarMaterial.setEnabled(true);
            jbtnAgregarMaterial.setEnabled(false);
        }else{
            jbtnAgregarMaterial.setEnabled(false);
            jbtnEliminarMaterial.setEnabled(true);
            jbtnModificarMaterial.setEnabled(true);
            jbtnLimpiarMaterial.setEnabled(true);

            if (evt.getClickCount() == 1) {
                if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("UD") || login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("RUD"))JOptionPane.showMessageDialog(rootPane, "Lo sentimos, no tienes los permisos para consultar la información","Aviso",JOptionPane.INFORMATION_MESSAGE);
                materiales.ApuntaMaterial();
                jTxtNombreMaterial.setText(materiales.getNombre());
                jCBUnidad.setSelectedItem(materiales.getUnidad());
                jTxtRendimiento.setText(materiales.getRendimiento());
                jTxtPrecio.setText(Double.toString(materiales.getPrecio()));
                jTxtDescripciónBM.setText(materiales.getDescripcionBM());
                
                int cuentaFilas = jTableProveedoresMaterial.getRowCount();
                if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("CR")){//VALIDA PERMISOS
                    for(int i=0; i<cuentaFilas; i++){
                        Object value = jTableProveedoresMaterial.getValueAt(i, 5);//BOTÓN EDITAR
                        Object value2 = jTableProveedoresMaterial.getValueAt(i, 6);//BOTÓN ELIMINAR
                        if(value instanceof JButton){
                            JButton boton = (JButton) value;
                            if(boton.getName().equals("modif")){
                                if(!jTableProveedoresMaterial.getValueAt(i, 0).equals("")){
                                    boton.setEnabled(false);
                                }
                            }   
                        }
                        if(value2 instanceof JButton){
                            JButton boton = (JButton) value2;
                            if(boton.getName().equals("elimi")){
                                if(!jTableProveedoresMaterial.getValueAt(i, 0).equals("")){
                                    boton.setEnabled(false);
                                }
                            }   
                        }
                    }
                }
                if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("CRU")){//VALIDA PERMISOS
                    for(int i=0; i<cuentaFilas; i++){
                        Object value2 = jTableProveedoresMaterial.getValueAt(i, 6);//BOTÓN ELIMINAR
                        if(value2 instanceof JButton){
                            JButton boton = (JButton) value2;
                            if(boton.getName().equals("elimi")){
                                if(!jTableProveedoresMaterial.getValueAt(i, 0).equals("")){
                                    boton.setEnabled(false);
                                }
                            }   
                        }
                    }
                }
                if(login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("CRD")){//VALIDA PERMISOS
                    for(int i=0; i<cuentaFilas; i++){
                        Object value = jTableProveedoresMaterial.getValueAt(i, 5);//BOTÓN EDITAR
                        if(value instanceof JButton){
                            JButton boton = (JButton) value;
                            if(boton.getName().equals("modif")){
                                if(!jTableProveedoresMaterial.getValueAt(i, 0).equals("")){
                                    boton.setEnabled(false);
                                }
                            }   
                        }
                    }
                }
            }
        }
        
    }//GEN-LAST:event_jTableMaterialesMouseClicked

    private void jbtnModificarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarMaterialActionPerformed
         if (JOptionPane.showConfirmDialog(rootPane, "Se modificará el material, ¿Desea continuar?",
            "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 
            jbtnModificarMaterial.setEnabled(false);
            jbtnEliminarMaterial.setEnabled(false);
            jbtnAgregarMaterial.setEnabled(true);
            if (jTxtNombreMaterial.getText().equals("") || jCBUnidad.getSelectedIndex()==0
                    || jTxtRendimiento.getText().equals("") || jTxtPrecio.getText().equals("") 
                    || jTxtDescripciónBM.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Llena todos los campos obligatorios",
                                    "Aviso",JOptionPane.WARNING_MESSAGE);
            } else {
                if(BD.conectarBD()){
                    materiales.setNombre(jTxtNombreMaterial.getText());
                    materiales.setUnidad(jCBUnidad.getSelectedItem().toString());
                    materiales.setRendimiento(jTxtRendimiento.getText());
                    materiales.setPrecio(Double.parseDouble(jTxtPrecio.getText()));
                    materiales.setDescripcionBM(jTxtDescripciónBM.getText());                            
                    try {
                        materiales.ActualizarProveedor(jTableMateriales);
                        JOptionPane.showMessageDialog(rootPane, "Actualización exitosa",
                            "Aviso",JOptionPane.INFORMATION_MESSAGE);
                        LimpiaCampos();
                        MetodosGlobales.LimpiaTabla(jTableMateriales);
                        materiales.TablaConsultaMateriales();
                        MetodosGlobales.LimpiaTabla(jTableProveedoresMaterial);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "No se actualizó el material: "+e,
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
    }//GEN-LAST:event_jbtnModificarMaterialActionPerformed

    private void jbtnEliminarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarMaterialActionPerformed
         if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el material, ¿Desea continuar?",
            "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
             jbtnModificarMaterial.setEnabled(false);
            jbtnEliminarMaterial.setEnabled(false);
            jbtnAgregarMaterial.setEnabled(true);
            if(BD.conectarBD()){
                try {
                    materiales.EliminaMaterial(jTableMateriales);
                    JOptionPane.showMessageDialog(rootPane, "El material se eliminó con éxito",
                        "Aviso",JOptionPane.INFORMATION_MESSAGE);
                    LimpiaCampos();
                    MetodosGlobales.LimpiaTabla(jTableMateriales);
                    materiales.TablaConsultaMateriales();
                    MetodosGlobales.LimpiaTabla(jTableProveedoresMaterial);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "No se eliminó el material: "+e,
                        "Aviso",JOptionPane.WARNING_MESSAGE);
                    BD.cerrarConexion();
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Error de conexión",
                        "Error",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }
        }
    }//GEN-LAST:event_jbtnEliminarMaterialActionPerformed

    private void jbtnLimpiarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimpiarMaterialActionPerformed
        LimpiaCampos();
        jTxtNombreMaterial.requestFocusInWindow();
        
        MetodosGlobales.LimpiaTabla(jTableMateriales);
        materiales.TablaConsultaMateriales();
        MetodosGlobales.LimpiaTabla(jTableProveedoresMaterial);
        
        
    }//GEN-LAST:event_jbtnLimpiarMaterialActionPerformed

    private void jBtnBuscarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarMaterialActionPerformed
        Frame frame = JOptionPane.getFrameForComponent(this);
        BuscaMaterial buscaMaterial = new BuscaMaterial(frame,true);
        Dimension desktopSize = Main.jDesktopMain.getSize();
        Dimension FrameSize = buscaMaterial.getSize();
        buscaMaterial.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        buscaMaterial.show();
    }//GEN-LAST:event_jBtnBuscarMaterialActionPerformed

    private void jTableProveedoresMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProveedoresMaterialMouseClicked
        int column = jTableProveedoresMaterial.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/jTableProveedoresMaterial.getRowHeight();
        int fila = jTableProveedoresMaterial.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel)jTableProveedoresMaterial.getModel();
        
        if(row < jTableProveedoresMaterial.getRowCount() && row >=0 && column < jTableProveedoresMaterial.getColumnCount() && column >= 0){
            Object value = jTableProveedoresMaterial.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                
                if(boton.getName().equals("modif")){
                    if(boton.isEnabled()==false){
                        JOptionPane.showMessageDialog(rootPane, "Lo sentimos, no tienes permisos para editar esta información.",
                                        "Aviso",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        Frame frame = JOptionPane.getFrameForComponent(this);
                        ModificarProveedorMaterial modificarProveedor = new ModificarProveedorMaterial(frame,true);
                        Dimension desktopSize = Main.jDesktopMain.getSize();
                        Dimension FrameSize = modificarProveedor.getSize();
                        modificarProveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                        modificarProveedor.show();
                    }
                }
                if(boton.getName().equals("elimi")){
                    if(boton.isEnabled()==false){
                        JOptionPane.showMessageDialog(rootPane, "Lo sentimos, no tienes permisos para eliminar esta información.",
                                        "Aviso",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el proveedor "+jTableProveedoresMaterial.getValueAt(fila, 2)+" ¿Desea continuar?",
                        "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                            if(jTableProveedoresMaterial.getValueAt(fila, 0).equals("")){//SI LA COLUMNA FOLIO ESTA VACIA, PASA A ELIMINAR SOLAMENTE LA FILA SIN BD
                                dtm.removeRow(jTableProveedoresMaterial.getSelectedRow());//SE LIMPIA LA TABLA MATERIALES PARA QUE DEJE DE ESTAR SELECCIONADA
                                MetodosGlobales.LimpiaTabla(jTableMateriales);//SE ACTUALIZA LA TABLA PARA QUE VUELVA A MOSTRAR LOS DATOS
                                materiales.TablaConsultaMateriales();
                            }else{//SINO ENTONCES ELIMINA LA FILA CON BD
                                if(BD.conectarBD()){
                                    try {
                                        materiales.EliminaMaterialProveedorUnoenUno(jTableProveedoresMaterial);
                                        JOptionPane.showMessageDialog(rootPane, "El proveedor se eliminó con éxito",
                                            "Aviso",JOptionPane.INFORMATION_MESSAGE);
                                        dtm.removeRow(jTableProveedoresMaterial.getSelectedRow());//ELIMINA LA FILA SELECCIONADA DEL JTABLE

                                        MetodosGlobales.LimpiaTabla(jTableMateriales);//SE LIMPIA LA TABLA MATERIALES PARA QUE DEJE DE ESTAR SELECCIONADA
                                        materiales.TablaConsultaMateriales();//SE ACTUALIZA LA TABLA PARA QUE VUELVA A MOSTRAR LOS DATOS

                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(rootPane, "No se eliminó el Proveedor: "+e,
                                            "Aviso",JOptionPane.WARNING_MESSAGE);
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
                }
            }
        }
    }//GEN-LAST:event_jTableProveedoresMaterialMouseClicked


     public static void LimpiaCampos(){
        jTxtNombreMaterial.setText(null);
        jCBUnidad.setSelectedIndex(0);
        jTxtRendimiento.setText(null);
        jTxtPrecio.setText(null);
        jTxtDescripciónBM.setText(null);
        
        jbtnAgregarMaterial.setEnabled(true);
        jbtnEliminarMaterial.setEnabled(false);
        jbtnModificarMaterial.setEnabled(false);
    }
        
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscarMaterial;
    public static javax.swing.JComboBox<String> jCBUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTableMateriales;
    public static javax.swing.JTable jTableProveedoresMaterial;
    public static javax.swing.JTextField jTxtDescripciónBM;
    public static javax.swing.JTextField jTxtNombreMaterial;
    public static javax.swing.JTextField jTxtPrecio;
    public static javax.swing.JTextField jTxtRendimiento;
    public static javax.swing.JButton jbtnAgregarMaterial;
    private javax.swing.JButton jbtnAgregarProveedorMaterial;
    public static javax.swing.JButton jbtnEliminarMaterial;
    private javax.swing.JButton jbtnLimpiarMaterial;
    public static javax.swing.JButton jbtnModificarMaterial;
    // End of variables declaration//GEN-END:variables
}
