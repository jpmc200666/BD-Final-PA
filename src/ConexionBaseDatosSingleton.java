public class ConexionBaseDatosSingleton {
    private static ConexionBaseDatosSingleton instancia;
    private Object conexion;

    private ConexionBaseDatosSingleton() {
        conectarABaseDatos();
    }

    public static synchronized ConexionBaseDatosSingleton obtenerConexion() {
        if (instancia == null) {
            instancia = new ConexionBaseDatosSingleton();
        }
        return instancia;
    }

    private void conectarABaseDatos() {
        this.conexion = null; 
    }

    public Object getConexion() {
        return conexion;
    }
}
