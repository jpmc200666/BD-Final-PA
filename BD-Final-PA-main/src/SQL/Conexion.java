package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Conexion {
    private Connection conexion;
    
    public void conectar(){
        try {
            // Carga del driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // URL, usuario y contraseña para la conexión
            String url = "jdbc:mysql://localhost:3306/distripizza"; // Cambia 'hospital' por tu base de datos
            String usuario = "root"; // Cambia 'root' por tu usuario
            String contrasena = "admin"; // Cambia 'tu_contrasena' por tu contraseña
            // Establece la conexión
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión a MySQL exitosa.");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    public void ejecutarConsulta(String consulta) {
        try {
            Statement statement = conexion.createStatement();
            statement.executeUpdate(consulta);
            System.out.println("Consulta ejecutada: " + consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión MySQL cerrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean validarConsulta(String usuario) {
        try {
            String validacionSql = "SELECT count(id) FROM sesiones WHERE usuario = ?";

            PreparedStatement statement = conexion.prepareStatement(validacionSql);
            statement.setString(1, usuario);
            ResultSet rs = statement.executeQuery();
            
            if(rs.next()){
                if(rs.getInt(1) == 0){
                    return false;
                }
                else{
                    return true;
                }
            }
            else{
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
    public boolean logIn(Usuarios usr) {
        try {
            String validacionSql = "SELECT id, usuario, contra FROM sesiones WHERE usuario = ?";

            PreparedStatement statement = conexion.prepareStatement(validacionSql);
            statement.setString(1, usr.getUsuario());
            ResultSet rs = statement.executeQuery();
            
            if(rs.next()){
                if(usr.getContra().equals(rs.getString(3))){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}