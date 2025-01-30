

public class Control {
    private Conexion MySQL;
    private ConexionBaseDatosSingleton conexion;

    public Control (Conexion conexionsql){
        this.MySQL = conexionsql;
        this.conexion = ConexionBaseDatosSingleton.obtenerConexion();
    }
    
    public void crearReserva(String usuario, String contra) {
        String consulta = String.format(
            "INSERT INTO sesiones (usuario, contra) VALUES ('%s', '%s')",
            usuario, contra
        );
        MySQL.ejecutarConsulta(consulta);
    }
}
