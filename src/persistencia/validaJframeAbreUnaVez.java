/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import modelo.Clientes;
import modelo.Materiales;
import modelo.Personal;
import modelo.Proveedores;
import vista.CatalogoClientes;
import vista.CatalogoMateriales;
import vista.CatalogoPersonal;
import vista.CatalogoProveedores;

/**
 *
 * @author alber
 */
public class validaJframeAbreUnaVez {
    private static JDesktopPane jDesktopPane;
    Proveedores proveedores = new Proveedores();
    Materiales materiales = new Materiales();
    Clientes clientes = new Clientes();
    Personal personal =  new Personal();
            
    public validaJframeAbreUnaVez(JDesktopPane jDesktopPane){
        validaJframeAbreUnaVez.jDesktopPane = jDesktopPane;
    }
    
    public void abrirInternalFrameProveedor(JInternalFrame jInternalFrame){
        if(jInternalFrame.isVisible()){
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        }else{
            jDesktopPane.add(jInternalFrame);
            Dimension desktopSize = jDesktopPane.getSize();
            Dimension FrameSize = jInternalFrame.getSize();
            jInternalFrame.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            jInternalFrame.show();
            
            //LIMPIAR CAMPOS AL VOLVER ABRIR LA VENTANA
            CatalogoProveedores.LimpiaCampos();
            MetodosGlobales.LimpiaTabla(CatalogoProveedores.jTableProveedores);
            proveedores.TablaConsultaProveedores();  
        }
    }
    
    public void abrirInternalFrameMateriales(JInternalFrame jInternalFrame){
        if(jInternalFrame.isVisible()){
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        }else{
            jDesktopPane.add(jInternalFrame);
            Dimension desktopSize = jDesktopPane.getSize();
            Dimension FrameSize = jInternalFrame.getSize();
            jInternalFrame.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            jInternalFrame.show();
            
            //LIMPIAR CAMPOS AL VOLVER ABRIR LA VENTANA
            CatalogoMateriales.LimpiaCampos();
            MetodosGlobales.LimpiaTabla(CatalogoMateriales.jTableMateriales);
            materiales.TablaConsultaMateriales();
            MetodosGlobales.LimpiaTabla(CatalogoMateriales.jTableProveedoresMaterial);
        }
    }
    
    public void abrirInternalFrameClientes(JInternalFrame jInternalFrame){
        if(jInternalFrame.isVisible()){
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        }else{
            jDesktopPane.add(jInternalFrame);
            Dimension desktopSize = jDesktopPane.getSize();
            Dimension FrameSize = jInternalFrame.getSize();
            jInternalFrame.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            jInternalFrame.show();
            
            //LIMPIAR CAMPOS AL VOLVER ABRIR LA VENTANA
            CatalogoClientes.LimpiaCampos();
            clientes.TablaConsultaClientes();
        }
    }
    
    public void abrirInternalFramePedidos(JInternalFrame jInternalFrame){
        if(jInternalFrame.isVisible()){
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        }else{
            jDesktopPane.add(jInternalFrame);
            Dimension desktopSize = jDesktopPane.getSize();
            Dimension FrameSize = jInternalFrame.getSize();
            jInternalFrame.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            jInternalFrame.show();
//            Proveedores proveedores = new Proveedores();
//            proveedores.TablaConsultaProveedores();
        }
    }
    
    public void abrirInternalFramePersonal(JInternalFrame jInternalFrame){
        if(jInternalFrame.isVisible()){
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        }else{
            jDesktopPane.add(jInternalFrame);
            Dimension desktopSize = jDesktopPane.getSize();
            Dimension FrameSize = jInternalFrame.getSize();
            jInternalFrame.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            jInternalFrame.show();
            
            //LIMPIAR CAMPOS AL VOLVER ABRIR LA VENTANA
            //CatalogoPersonal.LimpiaCampos();
//            personal.TablaConsultaPersonal();
        }
    }
}
