/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Clientes;
import modelo.Estilos;
import modelo.Pedidos;
import modelo.Personal;
import persistencia.BD;
import persistencia.MetodosGlobales;

/**
 *
 * @author Luis
 */
public class CatalogoPedido extends javax.swing.JDialog {

    Clientes cli = new Clientes();
    Pedidos ped = new Pedidos();
    Estilos est = new Estilos();
    Personal per = new Personal();

    
    MetodosGlobales metodosGlobales = new MetodosGlobales();
    public static List<JTextField> txtFieldTallas;
    public static List<JLabel> labelTallas;
    
     
    public CatalogoPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        txtFieldTallas = new ArrayList<>();
        labelTallas = new ArrayList<>();
        initComponents();
        
        llamaDatosPedido();
        
        cli.llenaComboClientes(jCBClientes);
        est.llenaComboEstilos(jCBEstilos);
        
        ped.llenaPanelTallas("Nacional",jPanelTallas,txtFieldTallas,labelTallas);
        jTxtSubTotal.setEditable(false);
        jTxtIva.setEditable(false);
        jTxtTotal.setEditable(false);
    }

    public void llamaDatosPedido(){
       
        int fila = AdministrarPedidos.jTableAdminPedidos.getSelectedRow();
        ped.setIdPedido(Integer.parseInt(AdministrarPedidos.jTableAdminPedidos.getValueAt(fila, 0).toString()));
        ped.consultaPedidos();
        jCBClientes.setSelectedItem(ped.getNombreCliente());
        
        Date date = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
        try {
                date = new java.sql.Date(df.parse((String)AdministrarPedidos.jTableAdminPedidos.getValueAt(fila, 1)).getTime());
        } catch (ParseException ex) {
                Logger.getLogger(CatalogoPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        jDCFecha1.setDate(date);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jCBClientes = new javax.swing.JComboBox<>();
        jDCFecha1 = new com.toedter.calendar.JDateChooser();
        jCBEstilos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jDCFechaInterna = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDCFechaCliente = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtObservaciones = new javax.swing.JTextArea();
        jTxtSubTotal = new javax.swing.JTextField();
        jTxtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTxtIva = new javax.swing.JTextField();
        btnAddCliente = new javax.swing.JButton();
        jPanelTallas = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCBTipoTallas = new javax.swing.JComboBox<>();
        jTxtPrecio = new javax.swing.JTextField();
        jBtnCalcTotales = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnModifyCliente = new javax.swing.JButton();
        jcbPersonal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Catálogo de Pedidos");

        jLabel13.setText("Cliente");

        jCBClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCBEstilos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBEstilos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEstilosActionPerformed(evt);
            }
        });

        jLabel6.setText("Estilo");

        jLabel7.setText("Fecha interna");

        jLabel8.setText("Fecha cliente");

        jLabel9.setText("Subtotal");

        jLabel10.setText("IVA");

        jLabel11.setText("Total");

        jTxtObservaciones.setColumns(20);
        jTxtObservaciones.setRows(5);
        jScrollPane2.setViewportView(jTxtObservaciones);

        jTxtSubTotal.setForeground(java.awt.Color.blue);
        jTxtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtSubTotalActionPerformed(evt);
            }
        });

        jTxtTotal.setForeground(java.awt.Color.blue);
        jTxtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtTotalActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha");

        jTxtIva.setForeground(java.awt.Color.blue);
        jTxtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIvaActionPerformed(evt);
            }
        });

        btnAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar16.png"))); // NOI18N
        btnAddCliente.setText("Agregar");
        btnAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClienteActionPerformed(evt);
            }
        });

        jPanelTallas.setBorder(javax.swing.BorderFactory.createTitledBorder("Tallas"));
        jPanelTallas.setLayout(new java.awt.GridLayout(0, 22));

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

        jLabel12.setText("Tipo de talla");

        jLabel4.setText("Precio");

        jCBTipoTallas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nacional", "Americano", "Frances" }));
        jCBTipoTallas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBTipoTallasItemStateChanged(evt);
            }
        });
        jCBTipoTallas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBTipoTallasMouseClicked(evt);
            }
        });
        jCBTipoTallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoTallasActionPerformed(evt);
            }
        });

        jTxtPrecio.setForeground(java.awt.Color.blue);
        jTxtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtPrecioActionPerformed(evt);
            }
        });

        jBtnCalcTotales.setText("Calcular totales");
        jBtnCalcTotales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCalcTotalesActionPerformed(evt);
            }
        });

        jLabel5.setText("Observaciones");

        btnModifyCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/girar.png"))); // NOI18N
        btnModifyCliente.setText("Modificar");
        btnModifyCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyClienteActionPerformed(evt);
            }
        });

        jcbPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPersonalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnCalcTotales)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTallas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(btnAddCliente)
                                .addGap(18, 18, 18)
                                .addComponent(btnModifyCliente)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDCFechaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCBTipoTallas, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCBClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDCFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCBEstilos, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDCFechaInterna, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcbPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCBEstilos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addComponent(jDCFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCBClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel13)))
                        .addComponent(jDCFechaInterna, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jDCFechaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel11)
                        .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jTxtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jTxtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBTipoTallas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(34, 34, 34)
                .addComponent(jPanelTallas, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnCalcTotales)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnModifyCliente)
                    .addComponent(btnAddCliente))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtSubTotalActionPerformed

    private void jTxtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtTotalActionPerformed

    private void jTxtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtIvaActionPerformed

    private void btnAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClienteActionPerformed
        // TODO add your handling code here:
        ArrayList arrayListTallas = new ArrayList();
        String estilo = (String) jCBEstilos.getSelectedItem();
        String cliente = (String) jCBClientes.getSelectedItem();
        String tipoTalla = (String) jCBTipoTallas.getSelectedItem();
        Date date1 = jDCFecha1.getDate();
        Date dateInterna = jDCFechaInterna.getDate();
        Date dateCliente = jDCFechaCliente.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (cliente.equals("-- Seleccione --") || metodosGlobales.validaFecha(jDCFecha1)==null || estilo.equals("-- Seleccione --")
            || metodosGlobales.validaFecha(jDCFechaInterna)==null || metodosGlobales.validaFecha(jDCFechaCliente)==null
            || jTxtPrecio.getText().equals("")
            || jTxtSubTotal.getText().equals("") || jTxtIva.getText().equals("") || jTxtTotal.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Llena todos los campos obligatorios",
                "Aviso",JOptionPane.WARNING_MESSAGE);
        }
        else {
            //                for (int i = 0; i < txtFieldTallas.size(); i++) {
                //                    if(!txtFieldTallas.get(i).getText().equals("")){
                    //                        System.out.println("item JTextField de tallas: "+txtFieldTallas.get(i).getName());
                    //                    }
                //                }
            if(BD.conectarBD()){
                Pedidos.setTxtFieldTallas(txtFieldTallas);
                ped.setNombreCliente(cliente);
                ped.setFecha(sdf.format(date1));
                ped.setNombreEstilo(estilo);

                ped.setFecha(sdf.format(date1));
                ped.setFechaInterna(sdf.format(dateInterna));
                ped.setFechaCliente(sdf.format(dateCliente));

                ped.setPrecio(Double.parseDouble(jTxtPrecio.getText()));
                ped.setSubtotal(Double.parseDouble(jTxtSubTotal.getText().replace("$", "")));
                ped.setIva(Double.parseDouble(jTxtIva.getText().replace("$", "")));
                ped.setTotal(Double.parseDouble(jTxtTotal.getText().replace("$", "")));
                ped.setTipoTalla(tipoTalla);
                ped.setObservaciones(jTxtObservaciones.getText());
                ped.setEstatus("Proceso");
                
                try {
                    ped.RegistraPedido(per.getIdPersonal());
                    for (int i = 0; i < txtFieldTallas.size()-1; i++) {
                        if(!txtFieldTallas.get(i).getText().equals("")){
                            ped.registrarTallas(Double.parseDouble(labelTallas.get(i).getText()),Integer.parseInt(txtFieldTallas.get(i).getText()));
                        }
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro exitoso",
                        "Aviso",JOptionPane.INFORMATION_MESSAGE);

                    //                        LimpiaCampos();
                    //                        LimpiaTablaClientes();
                    //                        cli.TablaConsultaClientes();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "No se registro el pedido",
                        "Error",JOptionPane.ERROR_MESSAGE);
                    //                        System.out.println("Error al registrar un cliente: "+e);
                    BD.cerrarConexion();
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Error de conexión",
                    "Error",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }
        }
    }//GEN-LAST:event_btnAddClienteActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        //        if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el cliente, ¿Desea continuar?",
            //            "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        //            if(BD.conectarBD()){
            //                try {
                //                    cli.EliminaCliente(jTableClientes);
                //                    JOptionPane.showMessageDialog(rootPane, "El cliente se eliminó con éxito",
                    //                        "Aviso",JOptionPane.INFORMATION_MESSAGE);
                //                    LimpiaCampos();
                //                    LimpiaTablaClientes();
                //                    cli.TablaConsultaClientes();
                //                } catch (Exception e) {
                //                    JOptionPane.showMessageDialog(rootPane, "No se eliminó el cliente: "+e,
                    //                        "Aviso",JOptionPane.WARNING_MESSAGE);
                //                    BD.cerrarConexion();
                //                }
            //            }else{
            //                JOptionPane.showMessageDialog(rootPane, "Error de conexión",
                //                        "Error",JOptionPane.ERROR_MESSAGE);
            //                BD.cerrarConexion();
            //            }
        //        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        LimpiaCampos();
        btnAddCliente.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModifyCliente.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jCBTipoTallasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBTipoTallasItemStateChanged
        // TODO add your handling code here:
                //System.out.println(evt.getItem().toString());
        jPanelTallas.removeAll();
        jPanelTallas.updateUI();
        ped.llenaPanelTallas(evt.getItem().toString(),jPanelTallas,txtFieldTallas,labelTallas);
    }//GEN-LAST:event_jCBTipoTallasItemStateChanged

    private void jCBTipoTallasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBTipoTallasMouseClicked
        // TODO add your handling code here:
        //        System.out.println(this.getTitle());
    }//GEN-LAST:event_jCBTipoTallasMouseClicked

    private void jCBTipoTallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoTallasActionPerformed
        // TODO add your handling code here:
        //        System.out.println(this.getTitle());
    }//GEN-LAST:event_jCBTipoTallasActionPerformed

    private void jTxtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtPrecioActionPerformed

    private void jBtnCalcTotalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCalcTotalesActionPerformed
        // TODO add your handling code here:
        int totalCantTallas = 0;
        double precio = !jTxtPrecio.getText().equals("") ? Double.parseDouble(jTxtPrecio.getText()) : 0;
        for (int i = 0; i < txtFieldTallas.size()-1; i++) {
            if(!txtFieldTallas.get(i).getText().equals("")){
                totalCantTallas += Integer.parseInt(txtFieldTallas.get(i).getText());
            }
        }
        txtFieldTallas.get(txtFieldTallas.size()-1).setText(""+totalCantTallas);
        if(!jTxtPrecio.getText().equals("")){
            double subTotal = precio * totalCantTallas;
            jTxtSubTotal.setText("$"+subTotal);
            double iva = subTotal * 0.16;
            jTxtIva.setText("$"+iva);
            double total = subTotal + iva;
            jTxtTotal.setText("$"+total);
        }
    }//GEN-LAST:event_jBtnCalcTotalesActionPerformed

    private void btnModifyClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyClienteActionPerformed
        // TODO add your handling code here:
        //        if (JOptionPane.showConfirmDialog(rootPane, "Se modificará el cliente, ¿Desea continuar?",
            //            "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        //            btnModifyCliente.setEnabled(false);
        //            btnEliminar.setEnabled(false);
        //            btnAddCliente.setEnabled(true);
        //            if (jTxtNombreCliente.getText().equals("") || jTxtDomicilio.getText().equals("")
            //                    || jTxtContacto.getText().equals("") || jTxtTel.getText().equals("") || jTxtCorreo.equals("")) {
            //                JOptionPane.showMessageDialog(rootPane, "Llena todos los campos obligatorios",
                //                                    "Aviso",JOptionPane.WARNING_MESSAGE);
            //            } else {
            //                if(BD.conectarBD()){
                //                    cli.setNombre(jTxtNombreCliente.getText());
                //                    cli.setDomicilio(jTxtDomicilio.getText());
                //                    cli.setTelefono(jTxtTel.getText());
                //                    cli.setContacto(jTxtContacto.getText());
                //                    cli.setCorreo(jTxtCorreo.getText());
                //                    try {
                    //                        cli.ActualizarCliente(jTableClientes);
                    //                        JOptionPane.showMessageDialog(rootPane, "Actualización exitosa",
                        //                            "Aviso",JOptionPane.INFORMATION_MESSAGE);
                    //                        LimpiaCampos();
                    //                        LimpiaTablaClientes();
                    //                        cli.TablaConsultaClientes();
                    //                    } catch (Exception e) {
                    //                        JOptionPane.showMessageDialog(rootPane, "No se actualizó el cliente: "+e,
                        //                            "Error",JOptionPane.ERROR_MESSAGE);
                    //                        BD.cerrarConexion();
                    //                    }
                //                }else{
                //                    JOptionPane.showMessageDialog(rootPane, "Error de conexión",
                    //                            "Error",JOptionPane.ERROR_MESSAGE);
                //                    BD.cerrarConexion();
                //                }
            //            }
        //        }
    }//GEN-LAST:event_btnModifyClienteActionPerformed

    private void jCBEstilosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEstilosActionPerformed
        if(jCBEstilos.getSelectedIndex()==0){
            per.setEstilo("");
            per.setProceso("");
            per.setIdEstilo(0);
        }else{
            per.setEstilo(jCBEstilos.getSelectedItem().toString());//MANDA EL NOMBRE DEL ESTILO PARA PODER OBTENER EL NOMBRE DEL PROCESO DEL ESTILO
        }
        per.llenaComboPersonal(jcbPersonal);//LLENA TODO EL COMBO DE PERSONAL
    }//GEN-LAST:event_jCBEstilosActionPerformed

    private void jcbPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPersonalActionPerformed
        per.setNombre(jcbPersonal.getSelectedItem().toString());
        per.obtieneIdPersonalCombo();
    }//GEN-LAST:event_jcbPersonalActionPerformed

       public static void LimpiaCampos(){
//        jTxtNombreCliente.setText(null);
//        jTxtDomicilio.setText(null);
//        jTxtTel.setText(null);
//        jTxtContacto.setText(null);
//        jTxtCorreo.setText(null);
    }
       
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
            java.util.logging.Logger.getLogger(CatalogoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatalogoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatalogoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CatalogoPedido dialog = new CatalogoPedido(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModifyCliente;
    private javax.swing.JButton jBtnCalcTotales;
    private javax.swing.JComboBox<String> jCBClientes;
    public static javax.swing.JComboBox<String> jCBEstilos;
    private javax.swing.JComboBox<String> jCBTipoTallas;
    private com.toedter.calendar.JDateChooser jDCFecha1;
    private com.toedter.calendar.JDateChooser jDCFechaCliente;
    private com.toedter.calendar.JDateChooser jDCFechaInterna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanelTallas;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField jTxtIva;
    private javax.swing.JTextArea jTxtObservaciones;
    public static javax.swing.JTextField jTxtPrecio;
    public static javax.swing.JTextField jTxtSubTotal;
    public static javax.swing.JTextField jTxtTotal;
    public static javax.swing.JComboBox<String> jcbPersonal;
    // End of variables declaration//GEN-END:variables
}
