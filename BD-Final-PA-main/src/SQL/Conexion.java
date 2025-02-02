package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
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
            String contrasena = "mysql"; // Cambia 'tu_contrasena' por tu contraseña
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
}
