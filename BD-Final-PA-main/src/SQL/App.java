package SQL;

import view.VentanaInicioAplicacion;
import view.VentanaInicioSesion;
import view.VentanaRegistroUsuario;

public class App {
	public static void main(String[] args) throws Exception {
		// Crear e iniciar la ventana de inicio de la aplicacion
		VentanaInicioAplicacion ventanaInicial = new VentanaInicioAplicacion();
		ventanaInicial.setVisible(false);

		// Crear e iniciar la ventana de inicio de sesión
		VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion();
		ventanaInicioSesion.setVisible(true);
		
		// Crear e iniciar la ventana de registro de usuario
		VentanaRegistroUsuario ventanaRegistroUsuario = new VentanaRegistroUsuario();
		ventanaRegistroUsuario.setVisible(false);
		
		// Hospital A usando MySQL
		Conexion MySQL = new Conexion();
		MySQL.conectar();

		Control control = new Control(MySQL);
		control.crearReserva("Juan Pérez", "Dra. Maria");
		MySQL.cerrarConexion();
	}
}
