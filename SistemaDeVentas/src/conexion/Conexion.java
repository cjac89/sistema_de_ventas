
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Conexion {
    //conexion local
    public static Connection conectar() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");  // Carga el controlador JDBC de MySQL
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_sistema_ventas", "root", "yomismo2012");

            return cn;
            
        }catch (SQLException e) {
            System.out.println("Error en la conexion local" + e);
        }
        return null;
        
        
    }
    
}
