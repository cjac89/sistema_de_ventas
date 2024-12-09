package controlador;

import java.sql.Statement;
import java.sql.ResultSet;
import conexion.Conexion;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import modelo.Usuario;

public class Ctrl_Usuario {

    // Método para iniciar sesión
    public boolean loginUser(Usuario objeto) throws ClassNotFoundException {
        boolean respuesta = false;
        java.sql.Connection cn = Conexion.conectar();
        // Consulta SQL para verificar el usuario y contraseña
        String sql = "select usuario, password from tb_usuario where usuario = '" + objeto.getUsuario() + "' and password = '" + objeto.getPassword() + "'";
        
        Statement st;
        try {
            // Crear statement y ejecutar la consulta
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);  // Usar executeQuery() para obtener un ResultSet
            
            // Verificar si se encontró un usuario que coincida con las credenciales
            while (rs.next()) {
                respuesta = true;  // Si hay resultados, se puede iniciar sesión
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }
        
        return respuesta;  // Devuelve true si el usuario y la contraseña son correctos, false de lo contrario
    }
}
