package SQL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import view.VentanaInicioAplicacion;
import view.VentanaInicioSesion;
import view.VentanaMenuPizzas;
import view.VentanaRecibo;
import view.VentanaRegistroUsuario;

public class Control implements ActionListener{
    private Conexion mySQL;
    private ConexionBaseDatosSingleton conexion;
    private VentanaInicioAplicacion ventanaInicial = new VentanaInicioAplicacion();
    private VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion();
    private VentanaRegistroUsuario ventanaRegistroUsuario = new VentanaRegistroUsuario();    
    private VentanaMenuPizzas ventanaMenuPizzas = new VentanaMenuPizzas();
    private VentanaRecibo ventanaRecibo = new VentanaRecibo();
    String usuario;

    public Control (Conexion conexionsql){
        this.mySQL = conexionsql;
        this.conexion = ConexionBaseDatosSingleton.obtenerConexion();
        this.asignarOyentes();

        ventanaInicial.setVisible(true);
		ventanaInicioSesion.setVisible (false);
		ventanaRegistroUsuario.setVisible(false);
        ventanaMenuPizzas.setVisible(false);;
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
        this.ventanaInicioSesion.getPanelSesion().getBotonIniciarSesion().addActionListener(this);
        this.ventanaRegistroUsuario.getPanelRegister().getBotonVolver().addActionListener(this);
        this.ventanaRegistroUsuario.getPanelRegister().getBotonRegistrarse().addActionListener(this);
        this.ventanaMenuPizzas.getPanelMenuPizza().getBotonPizzaVegetariana().addActionListener(this);
        this.ventanaMenuPizzas.getPanelMenuPizza().getBotonPizzaMexicana().addActionListener(this);
        this.ventanaMenuPizzas.getPanelMenuPizza().getBotonPizzaBBQ().addActionListener(this);
        this.ventanaMenuPizzas.getPanelMenuPizza().getBotonPizzaHawaiana().addActionListener(this);
        this.ventanaMenuPizzas.getPanelMenuPizza().getBotonPizzaMariscos().addActionListener(this);
        this.ventanaMenuPizzas.getPanelMenuPizza().getBotonPizzaRanchera().addActionListener(this);
        this.ventanaMenuPizzas.getPanelMenuPizza().getBotonPizzaNapolitana().addActionListener(this);
        this.ventanaMenuPizzas.getPanelMenuPizza().getBotonPizzaCarnivora().addActionListener(this);
        this.ventanaMenuPizzas.getPanelMenuPizza().getBotonPizzaPepperoni().addActionListener(this);
        this.ventanaMenuPizzas.getPanelMenuPizza().getBotonTerminarPedido().addActionListener(this);
        this.ventanaRecibo.getPanelRecibo().getBotonVolver().addActionListener(this);
        this.ventanaRecibo.getPanelRecibo().getBotonVolver().addActionListener(this);
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
            this.usuario = this.ventanaRegistroUsuario.getPanelRegister().getCampoNombre().getText();
            String contra = this.ventanaRegistroUsuario.getPanelRegister().getCampoContrasena().getText();
            if(usuario.equals("")|contra.equals("")){
                JOptionPane.showMessageDialog(null, "Lo sentimos, los espacios no pueden estar vacios");
            }else{
                boolean val = mySQL.validarConsulta(usuario);
                if(val == true){
                    JOptionPane.showMessageDialog(null, "Lo sentimos, este usuario ya existe, por favor escriba otro");
                }else{
                    this.ventanaRegistroUsuario.setVisible(false);
                    this.ventanaInicioSesion.setVisible(true);              
                    crearUsuario(usuario, contra);
                }
            }
        }
        if(comando.equals("PANEL_INICIAR_SESION")){
            this.usuario = this.ventanaInicioSesion.getPanelSesion().getCampoUsuario().getText();
            String contra = this.ventanaInicioSesion.getPanelSesion().getCampoContrasena().getText();
            Usuarios usr = new Usuarios(usuario, contra);
            if(mySQL.logIn(usr) == true ){
                this.ventanaInicioSesion.setVisible(false);
                this.ventanaMenuPizzas.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Lo sentimos, el usuario y/o contrasena son incorrectos");
            }
        }
        if(comando.equals("pepperoni")){
            String pedido = this.ventanaMenuPizzas.getPanelMenuPizza().getNPepperoni().getText();
            int cantPedido = Integer.parseInt(pedido);
            int updateCantPedido = cantPedido + 1;
            this.ventanaMenuPizzas.getPanelMenuPizza().getNPepperoni().setText(Integer.toString(updateCantPedido));
        }
        if(comando.equals("vegetariana")){
            String pedido = this.ventanaMenuPizzas.getPanelMenuPizza().getNVegetariana().getText();
            int cantPedido = Integer.parseInt(pedido);
            int updateCantPedido = cantPedido + 1;
            this.ventanaMenuPizzas.getPanelMenuPizza().getNVegetariana().setText(Integer.toString(updateCantPedido));
        }
        if(comando.equals("hawaiana")){
            String pedido = this.ventanaMenuPizzas.getPanelMenuPizza().getNHawaiana().getText();
            int cantPedido = Integer.parseInt(pedido);
            int updateCantPedido = cantPedido + 1;
            this.ventanaMenuPizzas.getPanelMenuPizza().getNHawaiana().setText(Integer.toString(updateCantPedido));
        }
        if(comando.equals("mexicana")){
            String pedido = this.ventanaMenuPizzas.getPanelMenuPizza().getNMexicana().getText();
            int cantPedido = Integer.parseInt(pedido);
            int updateCantPedido = cantPedido + 1;
            this.ventanaMenuPizzas.getPanelMenuPizza().getNMexicana().setText(Integer.toString(updateCantPedido));
        }
        if(comando.equals("bbq")){
            String pedido = this.ventanaMenuPizzas.getPanelMenuPizza().getNBBQ().getText();
            int cantPedido = Integer.parseInt(pedido);
            int updateCantPedido = cantPedido + 1;
            this.ventanaMenuPizzas.getPanelMenuPizza().getNBBQ().setText(Integer.toString(updateCantPedido));
        }
        if(comando.equals("carnivora")){
            String pedido = this.ventanaMenuPizzas.getPanelMenuPizza().getNCarnivora().getText();
            int cantPedido = Integer.parseInt(pedido);
            int updateCantPedido = cantPedido + 1;
            this.ventanaMenuPizzas.getPanelMenuPizza().getNCarnivora().setText(Integer.toString(updateCantPedido));
        }
        if(comando.equals("mariscos")){
            String pedido = this.ventanaMenuPizzas.getPanelMenuPizza().getNMariscos().getText();
            int cantPedido = Integer.parseInt(pedido);
            int updateCantPedido = cantPedido + 1;
            this.ventanaMenuPizzas.getPanelMenuPizza().getNMariscos().setText(Integer.toString(updateCantPedido));
        }
        if(comando.equals("napolitana")){
            String pedido = this.ventanaMenuPizzas.getPanelMenuPizza().getNNapolitana().getText();
            int cantPedido = Integer.parseInt(pedido);
            int updateCantPedido = cantPedido + 1;
            this.ventanaMenuPizzas.getPanelMenuPizza().getNNapolitana().setText(Integer.toString(updateCantPedido));
        }
        if(comando.equals("ranchera")){
            String pedido = this.ventanaMenuPizzas.getPanelMenuPizza().getNRanchera().getText();
            int cantPedido = Integer.parseInt(pedido);
            int updateCantPedido = cantPedido + 1;
            this.ventanaMenuPizzas.getPanelMenuPizza().getNRanchera().setText(Integer.toString(updateCantPedido));
        }
        if(comando.equals("terminar_pedido")){
            int nPepperoni = Integer.parseInt(this.ventanaMenuPizzas.getPanelMenuPizza().getNPepperoni().getText());
            int nVegetariana = Integer.parseInt(this.ventanaMenuPizzas.getPanelMenuPizza().getNVegetariana().getText());
            int nMexicana = Integer.parseInt(this.ventanaMenuPizzas.getPanelMenuPizza().getNMexicana().getText());
            int nBBQ = Integer.parseInt(this.ventanaMenuPizzas.getPanelMenuPizza().getNBBQ().getText());
            int nMariscos = Integer.parseInt(this.ventanaMenuPizzas.getPanelMenuPizza().getNMariscos().getText());
            int nRanchera = Integer.parseInt(this.ventanaMenuPizzas.getPanelMenuPizza().getNRanchera().getText());
            int nCarnivora = Integer.parseInt(this.ventanaMenuPizzas.getPanelMenuPizza().getNCarnivora().getText());
            int nHawaina = Integer.parseInt(this.ventanaMenuPizzas.getPanelMenuPizza().getNHawaiana().getText());
            int nNapolitana = Integer.parseInt(this.ventanaMenuPizzas.getPanelMenuPizza().getNNapolitana().getText());
            Pedido pedido = new Pedido(nPepperoni, nVegetariana, nHawaina, nCarnivora, nMexicana, nMariscos, nRanchera, nNapolitana, nBBQ);
            int cuenta = pedido.cuenta();
            if(cuenta > 0){
                this.ventanaMenuPizzas.setVisible(false);
                this.ventanaRecibo.setVisible(true);
                this.ventanaRecibo.getPanelRecibo().geteNombre().setText("Cliente: " + usuario);
                this.ventanaRecibo.getPanelRecibo().geteTotalPagar().setText("Total a pagar: " + cuenta);
                this.ventanaRecibo.getPanelRecibo().getePizzas().setText(
                "Porciones de pizza: Pepperoni = " + pedido.getnPepperoni() + "\n"+
                "                    Hawaiana =" + pedido.getnHawaiana()+"\n"+
                "                    Mexicana = " + pedido.getnMexicana()+"\n"+
                "                    Ranchera = " + pedido.getnRanchera()+"\n"+
                "                    Mariscos = " + pedido.getnMariscos()+"\n"+
                "                    BBQ = " + pedido.getnBBQ()+"\n"+
                "                    Napolitana= " + pedido.getnNapolitana()+"\n"+
                "                    Vegetariana = " + pedido.getnVegetariana()+"\n"+
                "                    Carnivora = " + pedido.getnCarnívora());
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione una opcion por favor");
            }
        }
        if(comando.equals("VOLVER_RECIBO")){
            this.ventanaMenuPizzas.setVisible(true);
                this.ventanaRecibo.setVisible(false);
        }
    }
}
