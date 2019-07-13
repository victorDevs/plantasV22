/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Materiales;
import modelo.Proveedores;
import persistencia.IconCellRenderer;

/**
 *
 * @author alber
 */
public class AgregarProveedorMaterial extends javax.swing.JDialog {

    /**
     * Creates new form AgregarProveedorMaterial
     */
    Proveedores proveedores = new Proveedores();
    
    //VARIABLES PARA AGREGAR A LA TABLA PROVEEDORESMATERIALES
     ImageIcon iconoEditar = new ImageIcon("src/imagenes/anadir.png");
     JLabel labelIconEditar = new JLabel();
    //PARA LOS BOTONES DE LA TABLA PROVEEDORESMATERIALES 
    ImageIcon iconModif = new ImageIcon(getClass().getResource("/imagenes/editar.png"));
    ImageIcon iconElimina = new ImageIcon(getClass().getResource("/imagenes/quitar.png"));
    
    //CREAMOS ESTOS BOTONES PARA ANEXARLOS A LA TABLA DE PROVEEDORESMATERIALES
     JButton btnModificar = new JButton(iconModif);
     JButton btnEliminar = new JButton(iconElimina);
     
    public AgregarProveedorMaterial(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        proveedores.leerDatosLista(jListProveedores); 
        
        String e = jListProveedores.getSelectedValue();
        jTxtDescripcion.setText(e);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSelecPrioridad = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProveedores = new javax.swing.JList<>();
        jTxtDescripcion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jRBPrimario = new javax.swing.JRadioButton();
        jRBSecundario = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar descripción del Material por Proveedor");

        jListProveedores.setToolTipText("");
        jScrollPane1.setViewportView(jListProveedores);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ok.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Descripción del Materaal por el proveedor");

        buttonGroupSelecPrioridad.add(jRBPrimario);
        jRBPrimario.setText("Primario");

        buttonGroupSelecPrioridad.add(jRBSecundario);
        jRBSecundario.setText("Secundario");

        jLabel2.setText("Proveedores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel1))
                                    .addComponent(jTxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jRBPrimario)
                                .addGap(37, 37, 37)
                                .addComponent(jRBSecundario))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRBPrimario)
                            .addComponent(jRBSecundario))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String nomProveedor = "";
       int id=0;
       String tipo = "";
       String descripción = "";
       int validaPrimario = 0;
       String rbPrimario = "";
               
       if(jListProveedores.getSelectedIndex() >=0){
           if(!jTxtDescripcion.getText().equals("")){
               if(jRBPrimario.isSelected() || jRBSecundario.isSelected()){
                   
                   nomProveedor = jListProveedores.getSelectedValue();
                   proveedores.optenerIdProveedor(nomProveedor);
                   id= proveedores.getIdProveedor();
                   descripción = jTxtDescripcion.getText();
                   
                   
                   if(jRBPrimario.isSelected()){
                        tipo = "Primario";
                        rbPrimario = "Primario";
                    }
                    if(jRBSecundario.isSelected()){
                       tipo = "Secundario";
                    }
                    int filas =CatalogoMateriales.jTableProveedoresMaterial.getRowCount();
                    for(int i=0; i<filas; i++){
                        if(CatalogoMateriales.jTableProveedoresMaterial.getValueAt(i, 3).equals(rbPrimario) ){
                            validaPrimario = 1;
                        }
                    }
                    
                    if(validaPrimario==1){
                        JOptionPane.showMessageDialog(rootPane, "Ya existe un proveedor primario",
                                     "Aviso",JOptionPane.WARNING_MESSAGE);
                    }else{
                        DefaultTableModel dtm = (DefaultTableModel)CatalogoMateriales.jTableProveedoresMaterial.getModel();
                        CatalogoMateriales.jTableProveedoresMaterial.setDefaultRenderer(Object.class, new IconCellRenderer());
                        btnModificar.setName("modif");
                        btnEliminar.setName("elimi");
                        
                        Object nuevo[] ={"",id,nomProveedor,tipo,descripción,btnModificar,btnEliminar};
                        dtm.addRow(nuevo);
                    }
                     
               }else{
                    JOptionPane.showMessageDialog(rootPane, "Seleccion si el Proveedor es Primario o Secundario",
                                     "Aviso",JOptionPane.WARNING_MESSAGE);
                }
           }else{
                JOptionPane.showMessageDialog(rootPane, "Imposible registrar. Descripción Vacía",
                            "Aviso",JOptionPane.WARNING_MESSAGE);
           }
            
       }else{
           JOptionPane.showMessageDialog(rootPane, "Seleccion un Proveedor de la lista",
                            "Aviso",JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarProveedorMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedorMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedorMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedorMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarProveedorMaterial dialog = new AgregarProveedorMaterial(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroupSelecPrioridad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JList<String> jListProveedores;
    private javax.swing.JRadioButton jRBPrimario;
    private javax.swing.JRadioButton jRBSecundario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtDescripcion;
    // End of variables declaration//GEN-END:variables
}
