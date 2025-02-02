package view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase que contiene la ventana de registro de usuario.
 * 
 * @author Grupo JAN
 */
public class VentanaRegistroUsuario extends JFrame {
    private PanelRegistroUsuario panelRegister;

    /**
     * Constructor con los parámetros de la ventana de registro de usuario.
     */
    public VentanaRegistroUsuario() {
        setTitle("Registro");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        inicializarComponentes();

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    /**
     * Método que inicia la ventana de registro de usuario.
     */
    public void inicializarComponentes() {
        panelRegister = new PanelRegistroUsuario();
        add(panelRegister);
    }

    /**
     * Obtener el panel de registro.
     * 
     * @return el panel de registro.
     */
    public PanelRegistroUsuario getPanelRegister() {
        return panelRegister;
    }

    /**
     * Definir el panel de registro.
     * 
     * @param panelRegister el panel de registro a definir.
     */
    public void setPanelRegister(PanelRegistroUsuario panelRegister) {
        this.panelRegister = panelRegister;
    }

    /**
     * Clase interna que contiene el panel de registro de usuario.
     */
    class PanelRegistroUsuario extends JPanel {
        private Image imagenFondo;
        private JLabel eContrasena;
        private JLabel eNombre;
        private JTextField campoNombre;
        private JTextField campoContrasena;
        private JButton botonRegistrarse;
        private JButton botonVolver;

        /**
         * Constructor del panel de registro de usuario.
         */
        public PanelRegistroUsuario() {
            setLayout(null);
            try {
                // Cargar imagen desde el directorio resources del proyecto
                InputStream is = getClass().getClassLoader().getResourceAsStream("resources/imagenCuadradaAzul.jpg");
                if (is != null) {
                    imagenFondo = ImageIO.read(is);
                } else {
                    System.err.println("No se pudo cargar la imagen.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            inicializarComponentes();
            setVisible(true);
        }

        /**
         * Método que permite cambiar el fondo del panel.
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Establecer color de fondo
            g.setColor(new Color(0, 74, 173));
            g.fillRect(0, 0, getWidth(), getHeight());

            // Dibujar la imagen con transparencia
            if (imagenFondo != null) {
                // Tamaño
                int ximage = 400;
                int yimage = 400;

                // Escalar la imagen
                Image imagenEscalada = imagenFondo.getScaledInstance(ximage, yimage, Image.SCALE_SMOOTH);

                // Convertir Graphics a Graphics2D para usar transparencia
                Graphics2D g2d = (Graphics2D) g;

                // Guardar la configuración original
                Composite originalComposite = g2d.getComposite();

                // Aplicar transparencia (0.0f = completamente transparente, 1.0f = completamente opaco)
                float alpha = 0.2f; // Ajusta este valor para más o menos transparencia
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

                // Dibujar la imagen con transparencia
                // Coordenadas
                int x = 140; // Margen izquierdo
                int y = 30; // Margen superior
                g2d.drawImage(imagenEscalada, x, y, this);

                // Restaurar la configuración original
                g2d.setComposite(originalComposite);
            }
        }

        /**
         * Método que inicia el panel del registro del usuario.
         */
        public void inicializarComponentes() {
            botonVolver = new JButton("Volver");
            botonVolver.setActionCommand("VOLVER_INICIO_REGISTRO");
            botonVolver.setBounds(40, 400, 100, 30);
            add(botonVolver);

            eNombre = new JLabel("Nombre: ");
            eNombre.setBounds(170, 130, 100, 20);
            eNombre.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
            eNombre.setFont(new Font("Arial", Font.BOLD, 16)); // Cambiar fuente y tamaño
            add(eNombre);

            campoNombre = new JTextField();
            campoNombre.setBounds(250, 130, 200, 20);
            add(campoNombre);

            eContrasena = new JLabel("Contraseña: ");
            eContrasena.setBounds(145, 250, 100, 20);
            eContrasena.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
            eContrasena.setFont(new Font("Arial", Font.BOLD, 16)); // Cambiar fuente y tamaño
            add(eContrasena);

            campoContrasena = new JTextField("");
            campoContrasena.setBounds(250, 250, 200, 20);
            add(campoContrasena);

            botonRegistrarse = new JButton("REGISTRARME");
            botonRegistrarse.setActionCommand("PANEL_REGISTRARME");
            botonRegistrarse.setBounds(250, 350, 200, 30);
            botonRegistrarse.setForeground(Color.black); // Cambiar el color del texto
            botonRegistrarse.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente, negrita, tamaño
            add(botonRegistrarse);
        }
    }
}