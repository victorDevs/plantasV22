/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Clientes;
import modelo.LoginModel;
import modelo.Personal;
import modelo.Procesos;
import modelo.Proveedores;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import vista.BuscaProveedor;
import persistencia.BD;
import persistencia.MetodosGlobales;


/**
 *
 * @author vikto
 */
public class CatalogoPersonal extends javax.swing.JInternalFrame {

    Personal per = new Personal();
    Procesos pro = new Procesos();
    LoginModel login = new LoginModel();
    
    String strFileName = "";

    MetodosGlobales metodosGlobales = new MetodosGlobales();
     
     private static CatalogoPersonal catalogoPersonal;
     
     public class Imagen extends javax.swing.JPanel {
        public Imagen() {
            this.setSize(250, 150); //se selecciona el tamaño del panel
        }
        
        //Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {
            Dimension height = getSize();

            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource("/codes/BarCode_"+per.getIdPersonal()+".JPEG")); 

            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 10, 20, height.width-15, height.height-15, null);

            setOpaque(false);
            super.paintComponent(grafico);
        }
    }
     
     public static CatalogoPersonal getInstancia(){
         if (catalogoPersonal == null) {
             catalogoPersonal = new CatalogoPersonal();
         }
         return catalogoPersonal;
     }
     
    public CatalogoPersonal() {
        initComponents();
        btnEliminar.setEnabled(false);
        btnModifyPersonal.setEnabled(false);
//        jDCFechaNacimiento.setEnabled(false);
        LimpiaTablaPersonal();
        per.TablaConsultaPersonal();
        pro.buscaPersonal(jCbProceso);
        
//        Imagen Imagen = new Imagen();
//        jPanelCodeBarras.add(Imagen);
//        jPanelCodeBarras.repaint();
        
        jTxtTelefono.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '-') ) {
                    getToolkit().beep();    
                    e.consume();
                }
                
                if(jTxtTelefono.getText().length() == 13){
                    getToolkit().beep();
                    e.consume(); 
                }
            }
        });
        
        //OCULTA LOS OBEJETOS PARA LA FECHA DE REGISTRO DEL PERSONAL
         jLblFechaRegistro.setVisible(false);
         jLblMuestraFechaRegistro.setVisible(false);
         jLblHoraRegistro.setVisible(false);
         jLblMuestraHoraRegistro.setVisible(false);
         
        
         //VALIDACIÓN DE PERMISOS
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("C")){
//            btnEliminar.setVisible(false);
//            btnModifyPersonal.setVisible(false);
//            btnAddPersonal.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("R")){
//            btnEliminar.setVisible(false);
//            btnModifyPersonal.setVisible(false);
//            btnBuscar.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("U")){
//            btnEliminar.setVisible(false);
//            btnAddPersonal.setVisible(false);
//            btnBuscar.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("D")){
//            btnModifyPersonal.setVisible(false);
//            btnAddPersonal.setVisible(false);
//            btnBuscar.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("CR")){
//            btnModifyPersonal.setVisible(false);
//            btnEliminar.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("CU")){
//            btnAddPersonal.setVisible(false);
//            btnEliminar.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("CD")){
//            btnAddPersonal.setVisible(false);
//            btnModifyPersonal.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("RD")){
//            btnModifyPersonal.setVisible(false);
//            btnBuscar.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("RU")){
//            btnEliminar.setVisible(false);
//            btnBuscar.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("UD")){
//            btnAddPersonal.setVisible(false);
//            btnBuscar.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("CRU")){
//            btnEliminar.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("CUD")){
//            btnAddPersonal.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("RUD")){
//            btnBuscar.setVisible(false);
//        }
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("CRD")){
//            btnModifyPersonal.setVisible(false);
//        }
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
        jTxtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePersonal = new javax.swing.JTable();
        btnAddPersonal = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTxtAptPaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtAptMaterno = new javax.swing.JTextField();
        jTxtDomicilio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnModifyPersonal = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTxtTelefono = new javax.swing.JTextField();
        jTxtCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCbProceso = new javax.swing.JComboBox<>();
        jDCFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jPanelCodeBarras = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLblFechaRegistro = new javax.swing.JLabel();
        jLblMuestraFechaRegistro = new javax.swing.JLabel();
        jLblHoraRegistro = new javax.swing.JLabel();
        jLblMuestraHoraRegistro = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Catálogo de Personal");
        setAutoscrolls(true);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Fecha Nacimiento:");

        jTablePersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre de Personal", "Apellido Paterno", "Apellido Materno", "Proceso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePersonal);
        if (jTablePersonal.getColumnModel().getColumnCount() > 0) {
            jTablePersonal.getColumnModel().getColumn(0).setMinWidth(30);
            jTablePersonal.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        btnAddPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar16.png"))); // NOI18N
        btnAddPersonal.setText("Agregar");
        btnAddPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPersonalActionPerformed(evt);
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

        jLabel3.setText("Apellido Paterno:");

        jLabel4.setText("Apellido Materno:");

        jTxtAptMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAptMaternoActionPerformed(evt);
            }
        });

        jLabel5.setText("Domicilio:");

        btnModifyPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/girar.png"))); // NOI18N
        btnModifyPersonal.setText("Modificar");
        btnModifyPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyPersonalActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        btnBuscar.setText("Búsqueda");
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("Teléfono:");

        jLabel7.setText("Correo:");

        jLabel8.setText("Proceso:");

        jCbProceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanelCodeBarras.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Barras"));

        javax.swing.GroupLayout jPanelCodeBarrasLayout = new javax.swing.GroupLayout(jPanelCodeBarras);
        jPanelCodeBarras.setLayout(jPanelCodeBarrasLayout);
        jPanelCodeBarrasLayout.setHorizontalGroup(
            jPanelCodeBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );
        jPanelCodeBarrasLayout.setVerticalGroup(
            jPanelCodeBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtObservaciones);

        jLabel9.setText("Observaciones");

        jLblFechaRegistro.setText("Fecha de Registro");
        jLblFechaRegistro.setEnabled(false);

        jLblMuestraFechaRegistro.setEnabled(false);

        jLblHoraRegistro.setText("Hora de Registro");
        jLblHoraRegistro.setEnabled(false);

        jLblMuestraHoraRegistro.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDCFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtDomicilio))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtAptPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtAptMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAddPersonal)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnModifyPersonal)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnEliminar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnLimpiar))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCbProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel9)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jPanelCodeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLblFechaRegistro)
                        .addGap(13, 13, 13)
                        .addComponent(jLblMuestraFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLblHoraRegistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblMuestraHoraRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLblMuestraFechaRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLblMuestraHoraRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLblFechaRegistro))
                    .addComponent(jLblHoraRegistro))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelCodeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnModifyPersonal)
                            .addComponent(btnAddPersonal))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtAptPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtAptMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(jTxtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDCFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jCbProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtAptMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAptMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAptMaternoActionPerformed

    private void btnAddPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPersonalActionPerformed
        // TODO add your handling code here:
        String proceso = (String) jCbProceso.getSelectedItem();
        Date date = jDCFechaNacimiento.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if(jTxtNombre.getText().equals("") || jTxtAptPaterno.getText().equals("")
                || jTxtAptMaterno.getText().equals("") || jTxtDomicilio.getText().equals("") 
                || jTxtTelefono.equals("") || jTxtCorreo.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Llena todos los campos obligatorios",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
        } else {
            if(metodosGlobales.validaFecha(jDCFechaNacimiento)==null){
                JOptionPane.showMessageDialog(rootPane, "Campo de fecha vacío o formato incorrecto",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
            }else{
                if(metodosGlobales.validaCorreo(jTxtCorreo.getText().trim())==false){
                    JOptionPane.showMessageDialog(rootPane, "El correo es incorrecto",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
                }else{
                    if(proceso.equals(" ***** AREA 1 ***** ") || proceso.equals(" ***** AREA 2 ***** ") || proceso.equals(" ***** AREA 3 ***** ")){
                        JOptionPane.showMessageDialog(rootPane, "Seleccione un proceso válido",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
                    }else{
                        if(BD.conectarBD()){
                            per.setNombre(jTxtNombre.getText());
                            per.setApellidoPaterno(jTxtAptPaterno.getText());
                            per.setApellidoMaterno(jTxtAptMaterno.getText());
                            per.setFechaNacimiento(sdf.format(date));
                            per.setDomicilio(jTxtDomicilio.getText());
                            per.setTelefono(jTxtTelefono.getText());
                            per.setCorreo(jTxtCorreo.getText());
                            per.setProceso(proceso);
                            per.setObservaciones(txtObservaciones.getText());
                            try {
                                if(per.RegistraPersonal()){
                                    String procesoString = per.getProceso();
                                    String[] procesoSplit = procesoString.split(" ");
                                    if(procesoSplit[0].equals("Calidad")){
                                        per.setIdPersonal(per.getlasIdInsert());
                                        if(per.getIdPersonal() > 0){
                                            Barcode barcode = null;
                                            String strCode = per.getIdPersonal()+"";
//                                            System.out.println("strCode: "+strCode);
                                            try {
                                                barcode = BarcodeFactory.createCode39(strCode, true);
                                            } catch (Exception e) {
                                                JOptionPane.showMessageDialog(null, "El código de barras para el trabajador no se creó correctamente: "+e,
                                                        "Aviso", JOptionPane.WARNING_MESSAGE);
                                            }
                                            barcode.setDrawingText(true);
                                            barcode.setBarWidth(2);
                                            barcode.setBarHeight(60);

                                            try {
                                                strFileName = "C:\\Users\\vikto\\OneDrive\\Documentos\\NetBeansProjects\\plantasV2\\src\\codes\\BarCode_"+strCode+".JPEG";
//                                                strFileName = "C:\\Users\\alber\\Documents\\NetBeansProjects\\plantasV2\\src\\codes\\BarCode_"+strCode+".JPEG";
                                                File file = new File(strFileName);
                                                file.setExecutable(true);
                                                file.setReadable(true);
                                                file.setWritable(true);
                                                FileOutputStream fos = new FileOutputStream(file);
                                                BarcodeImageHandler.writeJPEG(barcode, fos);
//                                                System.out.println("Archivo creado: "+strFileName);
                                            } catch (Exception e) {
                                                JOptionPane.showMessageDialog(null, "La imagen del código de barras no se guardo como imagen correctamente"+e,
                                                        "Aviso", JOptionPane.WARNING_MESSAGE);
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(rootPane, "El id del personal no se obtuvo correctamente. Contacte con el administrador del sistema",
                                            "Error",JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                    JOptionPane.showMessageDialog(rootPane, "Registro exitoso",
                                            "Aviso",JOptionPane.INFORMATION_MESSAGE);
                                    LimpiaCampos();
                                    LimpiaTablaPersonal();
                                    per.TablaConsultaPersonal();
                                }else{
                                    JOptionPane.showMessageDialog(rootPane, "No se registro el personal",
                                            "Error",JOptionPane.ERROR_MESSAGE);
                                    BD.cerrarConexion();
                                }
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(rootPane, "No se registro el personal.",
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
        }
    }//GEN-LAST:event_btnAddPersonalActionPerformed

    private void jTablePersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePersonalMouseClicked
        // TODO add your handling code here:
        DefaultComboBoxModel comboProceso = new DefaultComboBoxModel();
        
//        if(login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("R") || login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("RD") 
//                    || login.validaPermisos("personal", Main.menuNomUsuario.getText()).equals("CRD")){
//                btnEliminar.setEnabled(true);
//                btnLimpiar.setEnabled(true);
//        }else{
            btnAddPersonal.setEnabled(false);
            btnEliminar.setEnabled(true);
            btnModifyPersonal.setEnabled(true);
            btnLimpiar.setEnabled(true);
        
            if (evt.getClickCount() == 1) {
                jLblFechaRegistro.setVisible(true);
                jLblMuestraFechaRegistro.setVisible(true);
                jLblHoraRegistro.setVisible(true);
                jLblMuestraHoraRegistro.setVisible(true);
                per.ApuntaPersonal();
                jTxtNombre.setText(per.getNombre());
                jTxtAptPaterno.setText(per.getApellidoPaterno());
                jTxtAptMaterno.setText(per.getApellidoMaterno());
                Date date = null;
                String textFecha = per.getFechaNacimiento();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                df.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
                try {
                    date = new java.sql.Date(df.parse(textFecha).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(CatalogoPersonal.class.getName()).log(Level.SEVERE, null, ex);
                }
                jDCFechaNacimiento.setDate(date);
                jTxtDomicilio.setText(per.getDomicilio());
                jTxtTelefono.setText(per.getTelefono());
                jTxtCorreo.setText(per.getCorreo());
                comboProceso.addElement(per.getProceso());
                jCbProceso.setModel(comboProceso);
                txtObservaciones.setText(per.getObservaciones());
                jLblMuestraFechaRegistro.setText(per.getFechaRegistro());
                jLblMuestraHoraRegistro.setText(per.getHoraRegistro());

                File codeBarFile = new File("C:\\Users\\vikto\\OneDrive\\Documentos\\NetBeansProjects\\plantasV2\\src\\codes\\BarCode_"+per.getIdPersonal()+".JPEG");
    //            strFileName = "C:\\Users\\alber\\Documents\\NetBeansProjects\\plantasV2\\src\\codes\\BarCode_"+per.getIdPersonal()+".JPEG";
                if(codeBarFile.exists()){
                    Imagen Imagen = new Imagen();
                    jPanelCodeBarras.add(Imagen);
                    jPanelCodeBarras.repaint();
                }else{
                    jPanelCodeBarras.removeAll();
                    jPanelCodeBarras.repaint();
                }
//            }
        }
    }//GEN-LAST:event_jTablePersonalMouseClicked

    private void btnModifyPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyPersonalActionPerformed
        // TODO add your handling code here:
        String proceso = (String) jCbProceso.getSelectedItem();
        if(metodosGlobales.validaCorreo(jTxtCorreo.getText().trim())==false){
            JOptionPane.showMessageDialog(rootPane, "El correo es incorrecto",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
        }else{
            if(metodosGlobales.validaFecha(jDCFechaNacimiento)==null){
                    JOptionPane.showMessageDialog(rootPane, "Campo de fecha vacío o formato incorrecto",
                                "Aviso",JOptionPane.WARNING_MESSAGE);
            }else{
                if (JOptionPane.showConfirmDialog(rootPane, "Se modificará el personal, ¿Desea continuar?",
                    "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    Date date = jDCFechaNacimiento.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    btnModifyPersonal.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    btnAddPersonal.setEnabled(true);
                    if(jTxtNombre.getText().equals("") || jTxtAptPaterno.getText().equals("")
                        || jTxtAptMaterno.getText().equals("") || sdf.format(date).equals("") 
                        || jTxtDomicilio.equals("") || jTxtTelefono.equals("") || jTxtCorreo.equals("") || proceso.equals(" - Proceso - ")) {
                            JOptionPane.showMessageDialog(rootPane, "Llena todos los campos obligatorios",
                                                "Aviso",JOptionPane.WARNING_MESSAGE);
                    }else{
                        if(BD.conectarBD()){
                            per.setNombre(jTxtNombre.getText());
                            per.setApellidoPaterno(jTxtAptPaterno.getText());
                            per.setApellidoMaterno(jTxtAptMaterno.getText());
                            per.setFechaNacimiento(sdf.format(date));
                            per.setDomicilio(jTxtDomicilio.getText());
                            per.setTelefono(jTxtTelefono.getText());
                            per.setCorreo(jTxtCorreo.getText());
                            per.setProceso(proceso);                             
                            try {
                                per.ActualizarPersonal(jTablePersonal);
                                JOptionPane.showMessageDialog(rootPane, "Actualización exitosa",
                                    "Aviso",JOptionPane.INFORMATION_MESSAGE);
                                LimpiaCampos();
                                LimpiaTablaPersonal();
                                per.TablaConsultaPersonal();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(rootPane, "No se actualizó el personal: "+e,
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
        }
    }//GEN-LAST:event_btnModifyPersonalActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        LimpiaCampos();
        jTxtNombre.requestFocusInWindow();
        
        MetodosGlobales.LimpiaTabla(jTablePersonal);
        per.TablaConsultaPersonal();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el personal, ¿Desea continuar?",
            "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){    
            if(BD.conectarBD()){
                try {
                    per.EliminaPersonal(jTablePersonal);
                    JOptionPane.showMessageDialog(rootPane, "El personal se eliminó con éxito",
                        "Aviso",JOptionPane.INFORMATION_MESSAGE);
                    LimpiaCampos();
                    LimpiaTablaPersonal();
                    per.TablaConsultaPersonal();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "No se eliminó el personal: "+e,
                        "Aviso",JOptionPane.WARNING_MESSAGE);
                    BD.cerrarConexion();
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Error de conexión",
                        "Error",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
//        BuscadorProveedor miVentanaBuscar = null;
//        
//        miVentanaBuscar = new BuscadorProveedor(miVentanaBuscar,true);
//        miVentanaBuscar.setVisible(true);

        Frame frame = JOptionPane.getFrameForComponent(this);
        BuscaPersonal buscaPer = new BuscaPersonal(frame,true);
        Dimension desktopSize = Main.jDesktopMain.getSize();
        Dimension FrameSize = buscaPer.getSize();
        buscaPer.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        buscaPer.show();
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void LimpiaTablaPersonal(){
        try {
            DefaultTableModel modelo = (DefaultTableModel)jTablePersonal.getModel();
            int filas = jTablePersonal.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            System.out.println("Limpieza exitosa en LimpiaTablaPersonal!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al intentar limpiar la tabla Clientes: "+e,
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public  void LimpiaCampos(){
        jTxtNombre.setText(null);
        jTxtAptPaterno.setText(null);
        jTxtAptMaterno.setText(null);
        jDCFechaNacimiento.setDate(null);
        jTxtDomicilio.setText(null);
        jTxtTelefono.setText(null);
        jTxtCorreo.setText(null);
        pro.buscaPersonal(jCbProceso);
        txtObservaciones.setText(null);
        
        jPanelCodeBarras.removeAll();
        jPanelCodeBarras.repaint();
        
        btnAddPersonal.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModifyPersonal.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAddPersonal;
    private javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    public static javax.swing.JButton btnModifyPersonal;
    public static javax.swing.JComboBox<String> jCbProceso;
    public static com.toedter.calendar.JDateChooser jDCFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLblFechaRegistro;
    private javax.swing.JLabel jLblHoraRegistro;
    private javax.swing.JLabel jLblMuestraFechaRegistro;
    private javax.swing.JLabel jLblMuestraHoraRegistro;
    private javax.swing.JPanel jPanelCodeBarras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTablePersonal;
    public static javax.swing.JTextField jTxtAptMaterno;
    public static javax.swing.JTextField jTxtAptPaterno;
    public static javax.swing.JTextField jTxtCorreo;
    public static javax.swing.JTextField jTxtDomicilio;
    public static javax.swing.JTextField jTxtNombre;
    public static javax.swing.JTextField jTxtTelefono;
    private javax.swing.JTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
