package SQL;

public class App {
	public static void main(String[] args) throws Exception {
		
		
		// Hospital A usando MySQL
		Conexion MySQL = new Conexion();
		MySQL.conectar();

		new Control(MySQL);
	}
}
