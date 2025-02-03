package SQL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VentanaInicioAplicacion;
import view.VentanaInicioSesion;
import view.VentanaRegistroUsuario;

public class Control implements ActionListener{
    private Conexion mySQL;
    private ConexionBaseDatosSingleton conexion;
    private VentanaInicioAplicacion ventanaInicial = new VentanaInicioAplicacion();
    private VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion();
    private VentanaRegistroUsuario ventanaRegistroUsuario = new VentanaRegistroUsuario();    

    public Control (Conexion conexionsql){
        this.mySQL = conexionsql;
        this.conexion = ConexionBaseDatosSingleton.obtenerConexion();
        this.asignarOyentes();

        ventanaInicial.setVisible(true);
		ventanaInicioSesion.setVisible (false);
		ventanaRegistroUsuario.setVisible(false);

    }
    
    public void crearUsuario(String usuario, String contra) {
        String sesion = String.format(
            "INSERT INTO sesiones (usuario, contra) VALUES ('%s', '%s')",
            usuario, contra
        );
        mySQL.ejecutarConsulta(sesion);
    }
    
    public void asignarOyentes(){
        this.ventanaInicial.getPanelInicio().getBotonIniciarSesion().addActionListener(this);
        this.ventanaInicial.getPanelInicio().getBotonRegistrar().addActionListener(this);
        this.ventanaInicioSesion.getPanelSesion().getBotonVolver().addActionListener(this);
        this.ventanaRegistroUsuario.getPanelRegister().getBotonVolver().addActionListener(this);
        this.ventanaRegistroUsuario.getPanelRegister().getBotonRegistrarse().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals("INICIAR_SESION_BOTON_INICIO")){
            this.ventanaInicial.setVisible(false);
            this.ventanaInicioSesion.setVisible(true);
            
        }else if(comando.equals("REGISTRARME_BOTON_INICIO")){
            this.ventanaInicial.setVisible(false);
            this.ventanaRegistroUsuario.setVisible(true);
            
        }
        if(comando.equals("VOLVER_INICIO_SESION")){
            this.ventanaInicial.setVisible(true);
            this.ventanaInicioSesion.setVisible(false);
        }
        if(comando.equals("VOLVER_INICIO_REGISTRO")){
            this.ventanaInicial.setVisible(true);
            this.ventanaRegistroUsuario.setVisible(false);
        }
        if(comando.equals("PANEL_REGISTRARME")){
            this.ventanaRegistroUsuario.setVisible(false);
            this.ventanaInicioSesion.setVisible(true);  
            String usuario = this.ventanaRegistroUsuario.getPanelRegister().getCampoNombre().getText();
            String contra = this.ventanaRegistroUsuario.getPanelRegister().getCampoContrasena().getText();
            crearUsuario(usuario, contra);
        }
    }
}
