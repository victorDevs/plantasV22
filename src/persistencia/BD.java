package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BD {

    public static Connection conexion = null;
    
    /**
     * Constructor de la clase
     */
    public BD() {
    }
    
    /**
     * Crear conexión con la Base de datos
     * @return estado de la conexión
     */
    public static boolean conectarBD() {
        //Cargar el Driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar driver:" + ex);
            return false;
        }
        //Establecer la conexión con la Base de Datos
        try {
//            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/plantasbd","root","10240498");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/plantasbd","root","");
        } catch (SQLException ex) {
            System.out.println("Error al establecer conexión a la base de datos:" + ex);
            return false;
        }
        return true;
    }
    
    /**
     * Ejecutar instrucciones SQL INSERT, UPDATE y DELETE
     * @param sql instrucción a ejecutar
     * @return estado de la acción
     */
    public static boolean ejecutarSQL(String sql) {
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en instrucción: "+ex);
            return false;
        }
    }
    /**
     * Ejecutar instrucción SELECT SQL
     * @param sql isntrucción a ejecutar
     * @return resultado de la consulta
     */
    
    public static ResultSet ejecutarSQLSelect(String sql) {
        try {
            Statement sentencia = conexion.createStatement();
            return sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar instrucción:"+ex);
            return null;
        }
    }
    
    /**
     * Ejecuta una transacción
     * @param sql arreglo de instrucciones SQL
     * @return estado de la operación
     */
    public static boolean ejecutarTransaccion(String[] sql)
    {
        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            for (int i = 0; i < sql.length; i++) {
               //JOptionPane.showMessageDialog(null, sql[i]);
               sentencia.executeUpdate(sql[i]);
            }
            conexion.commit();
            return true;
        } catch (SQLException ex) {
            try {
                conexion.rollback();
                return false;
            } catch (SQLException ex1) {
                return false;
            }
        }
    }
    /**
     * Cierra la conexión con la base de datos
     */
    public static void cerrarConexion()
    {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar conexión");
        }
    }
   
} // Fin de la clase

