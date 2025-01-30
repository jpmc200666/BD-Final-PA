
public class App {
    public static void main(String[] args) throws Exception {
        // Hospital A usando MySQL
        Conexion MySQL = new Conexion();
        MySQL.conectar();
    
        Control control = new Control(MySQL);
        control.crearReserva("Juan Pérez", "Dra. Maria");
        MySQL.cerrarConexion(); 
    }
}
