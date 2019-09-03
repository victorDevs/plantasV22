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
import modelo.Clientes;
import modelo.Pedidos;
import modelo.Proveedores;
import persistencia.BD;
import persistencia.FormatoColorTabla;
import persistencia.MetodosGlobales;
import persistencia.validaJframeAbreUnaVez;


/**
 *
 * @author vikto
 */
public class AdministrarPedidos extends javax.swing.JInternalFrame {

    Clientes cli = new Clientes();
    MetodosGlobales metodosGlobales = new MetodosGlobales();
    Pedidos pedidos = new Pedidos();
    validaJframeAbreUnaVez validajFraAbreUnaVez;

    /**
     * Creates new form CatalogoMateriales
     */
     
     private static AdministrarPedidos catalogoProveedores;
     
     public static AdministrarPedidos getInstancia(){
         if (catalogoProveedores == null) {
             catalogoProveedores = new AdministrarPedidos();
         }
         return catalogoProveedores;
     }
     
    public AdministrarPedidos() {
        //this.validajFraAbreUnaVez = new validaJframeAbreUnaVez(Main.jDesktopMain);
        initComponents();
        
        jTableAdminPedidos.setDefaultRenderer(Object.class, new FormatoColorTabla());
        
        MetodosGlobales.LimpiaTabla(jTableAdminPedidos);
        pedidos.TablaConsultaPedidos();
        
        
//        btnEliminar.setEnabled(false);
//        btnModifyCliente.setEnabled(false);
//        LimpiaTablaClientes();
//        cli.TablaConsultaClientes();
//        
//        jTxtTel.addKeyListener(new KeyAdapter(){
//            public void keyTyped(KeyEvent e){
//                char c = e.getKeyChar();
//                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '-') ) {
//                    getToolkit().beep();    
//                    e.consume();
//                }
//                
//                if(jTxtTel.getText().length() == 13){
//                    getToolkit().beep();
//                    e.consume(); 
//                }
//            }
//        });
        
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
        jTxtBuscador = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAdminPedidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jCBBuscarPor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDCFechaFin = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setTitle("Administrador de Pedidos");
        setAutoscrolls(true);

        jLabel1.setForeground(java.awt.Color.blue);
        jLabel1.setText("Añadir un pedido...");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jTableAdminPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Fecha", "Fecha Int.", "Fecha Cli.", "Precio", "Subtotal", "IVA", "Total", "Observaciones", "Estatus", "Editar", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAdminPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAdminPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAdminPedidos);
        if (jTableAdminPedidos.getColumnModel().getColumnCount() > 0) {
            jTableAdminPedidos.getColumnModel().getColumn(0).setMinWidth(10);
            jTableAdminPedidos.getColumnModel().getColumn(9).setMinWidth(70);
            jTableAdminPedidos.getColumnModel().getColumn(9).setMaxWidth(70);
            jTableAdminPedidos.getColumnModel().getColumn(10).setMinWidth(60);
            jTableAdminPedidos.getColumnModel().getColumn(10).setMaxWidth(60);
            jTableAdminPedidos.getColumnModel().getColumn(11).setMinWidth(60);
            jTableAdminPedidos.getColumnModel().getColumn(11).setMaxWidth(60);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jButton1.setText("Buscar");

        jCBBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Folio", "Estilo", "Cliente", "Fecha", "Fecha Interna", "Fecha Cliente", "Precio", "Estatus", "Rango Precios" }));

        jLabel2.setText("Buscar por");

        jLabel3.setText("Inicio");

        jLabel4.setText("Fin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCBBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)
                                .addComponent(jDCFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 378, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCBBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jDCFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAdminPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAdminPedidosMouseClicked
        // TODO add your handling code here:
//        btnAddCliente.setEnabled(false);
//        btnEliminar.setEnabled(true);
//        btnModifyCliente.setEnabled(true);
//        btnLimpiar.setEnabled(true);
//        
//        if (evt.getClickCount() == 1) {
//            cli.ApuntaCliente();
//            Date date = null;
//            jTxtBuscador.setText(cli.getNombre());
//            jTxtDomicilio.setText(cli.getDomicilio());
//            jTxtTel.setText(cli.getTelefono());
//            jTxtContacto.setText(cli.getContacto());
//            jTxtCorreo.setText(cli.getCorreo());
//        }
        
    }//GEN-LAST:event_jTableAdminPedidosMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        //validajFraAbreUnaVez.abrirInternalFramePedidos(CatalogoPedidos.getInstancia());
        Frame frame = JOptionPane.getFrameForComponent(this);
        CatalogoPedido catPedido = new CatalogoPedido(frame,true);
        Dimension desktopSize = Main.jDesktopMain.getSize();
        Dimension FrameSize = catPedido.getSize();
        catPedido.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        catPedido.show();
    }//GEN-LAST:event_jLabel1MouseClicked

    public void LimpiaTablaClientes(){
        try {
            DefaultTableModel modelo = (DefaultTableModel)jTableAdminPedidos.getModel();
            int filas = jTableAdminPedidos.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            System.out.println("Limpieza exitosa!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al intentar limpiar la tabla Clientes: "+e,
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void LimpiaCampos(){
//        jTxtBuscador.setText(null);
//        jTxtDomicilio.setText(null);
//        jTxtTel.setText(null);
//        jTxtContacto.setText(null);
//        jTxtCorreo.setText(null);
//        
//        btnAddCliente.setEnabled(true);
//        btnEliminar.setEnabled(false);
//        btnModifyCliente.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCBBuscarPor;
    private com.toedter.calendar.JDateChooser jDCFechaFin;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableAdminPedidos;
    public static javax.swing.JTextField jTxtBuscador;
    // End of variables declaration//GEN-END:variables
}
