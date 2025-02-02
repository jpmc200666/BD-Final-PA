package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase que contiene la ventana de inicio de sesión.
 * 
 * @author Grupo JAN
 */
public class VentanaInicioSesion extends JFrame {
	private PanelInicioSesion panelSesion;

	/**
	 * Constructor que contiene la ventana de los parámetros de inicio de sesión.
	 */
	public VentanaInicioSesion() {
		setTitle("Inicio de Sesion");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.gray);
		setLayout(new BorderLayout(10, 10));
		inicializarComponentes();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}

	/**
	 * Método para iniciar la ventana de inicio de sesión.
	 */
	public void inicializarComponentes() {
		panelSesion = new PanelInicioSesion();
		add(panelSesion);
	}

	/**
	 * Obtener el panel de inicio de sesión.
	 * 
	 * @return el panel de inicio de sesión.
	 */
	public PanelInicioSesion getPanelSesion() {
		return panelSesion;
	}

	/**
	 * Definir el panel de inicio de sesión.
	 * 
	 * @param panelSesion el panel de inicio de sesión a definir.
	 */
	public void setPanelSesion(PanelInicioSesion panelSesion) {
		this.panelSesion = panelSesion;
	}

	/**
	 * Clase interna que contiene el panel de inicio de sesión.
	 */
	class PanelInicioSesion extends JPanel {
		private Image imagenFondo;
		private JLabel eUsuario;
		private JLabel eContrasena;
		private JTextField campoUsuario;
		private JTextField campoContrasena;
		private JButton botonIniciarSesion;
		private JButton botonVolver;

		/**
		 * Constructor que contiene los parámetros del panel de inicio de sesión.
		 */
		public PanelInicioSesion() {
			setLayout(null);
			try {
				// Cargar imagen desde el directorio resources del proyecto
				InputStream is = getClass().getClassLoader().getResourceAsStream("resources/imagenCuadradaRoja.jpg");
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
		 * Método para poner una imagen de fondo.
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Establecer color de fondo
			g.setColor(new Color(204, 46, 34));
			g.fillRect(0, 0, getWidth(), getHeight());

			// Dibujar la imagen en las coordenadas (x, y) y escalarla al tamaño deseado
			// manualmente
			if (imagenFondo != null) {
				int ximage = 130;
				int yimage = 130;

				// Escalar la imagen para que se ajuste al tamaño deseado manualmente
				Image imagenEscalada = imagenFondo.getScaledInstance(ximage, yimage, Image.SCALE_SMOOTH);

				// Dibujar la imagen escalada en las coordenadas (x, y)
				int x = 520; // Margen izquierdo
				int y = 310; // Margen superior
				g.drawImage(imagenEscalada, x, y, this);
			}
		}

		/**
		 * Método para mostrar un mensaje de error al iniciar sesión.
		 */
		public void mensajeErrorInicioSesion() {
			JOptionPane.showMessageDialog(null, "Usuario/Contraseña Incorrectos");
		}

		/**
		 * Método que inicia el panel de inicio de sesión.
		 */
		public void inicializarComponentes() {
			eUsuario = new JLabel("Usuario: ");
			eUsuario.setBounds(170, 153, 70, 12);
			eUsuario.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
			eUsuario.setFont(new Font("Arial", Font.BOLD, 16)); // Cambiar fuente y tamaño
			add(eUsuario);

			eContrasena = new JLabel("Contraseña: ");
			eContrasena.setBounds(145, 253, 100, 12);
			eContrasena.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
			eContrasena.setFont(new Font("Arial", Font.BOLD, 16)); // Cambiar fuente y tamaño
			add(eContrasena);

			campoUsuario = new JTextField("");
			campoUsuario.setBounds(250, 150, 200, 20);
			add(campoUsuario);

			campoContrasena = new JTextField();
			campoContrasena.setBounds(250, 250, 200, 20);
			add(campoContrasena);

			botonIniciarSesion = new JButton("INICIAR SESION");
			botonIniciarSesion.setActionCommand("PANEL_INICIAR_SESION");
			botonIniciarSesion.setBounds(250, 350, 200, 30);
			add(botonIniciarSesion);

			botonVolver = new JButton("Volver");
			botonVolver.setActionCommand("VOLVER_INICIO_SESION");
			botonVolver.setBounds(40, 400, 100, 30);
			add(botonVolver);
		}

		/**
		 * Obtener la imagen de fondo.
		 * 
		 * @return la imagen de fondo.
		 */
		public Image getImagenFondo() {
			return imagenFondo;
		}

		/**
		 * Definir la imagen de fondo.
		 * 
		 * @param imagenFondo la imagen de fondo a definir.
		 */
		public void setImagenFondo(Image imagenFondo) {
			this.imagenFondo = imagenFondo;
		}

		/**
		 * Obtener la etiqueta de usuario.
		 * 
		 * @return la etiqueta de usuario.
		 */
		public JLabel geteUsuario() {
			return eUsuario;
		}

		/**
		 * Definir la etiqueta de usuario.
		 * 
		 * @param eUsuario la etiqueta de usuario a definir.
		 */
		public void seteUsuario(JLabel eUsuario) {
			this.eUsuario = eUsuario;
		}

		/**
		 * Obtener la etiqueta de contraseña.
		 * 
		 * @return la etiqueta de contraseña.
		 */
		public JLabel geteContrasena() {
			return eContrasena;
		}

		/**
		 * Definir la etiqueta de contraseña.
		 * 
		 * @param eContrasena la etiqueta de contraseña a definir.
		 */
		public void seteContrasena(JLabel eContrasena) {
			this.eContrasena = eContrasena;
		}

		/**
		 * Obtener el campo de texto del usuario.
		 * 
		 * @return el campo de texto del usuario.
		 */
		public JTextField getCampoUsuario() {
			return campoUsuario;
		}

		/**
		 * Definir el campo de texto del usuario.
		 * 
		 * @param campoUsuario el campo de texto del usuario a definir.
		 */
		public void setCampoUsuario(JTextField campoUsuario) {
			this.campoUsuario = campoUsuario;
		}

		/**
		 * Obtener el campo de texto de la contraseña.
		 * 
		 * @return el campo de texto de la contraseña.
		 */
		public JTextField getCampoContrasena() {
			return campoContrasena;
		}

		/**
		 * Definir el campo de texto de la contraseña.
		 * 
		 * @param campoContrasena el campo de texto de la contraseña a definir.
		 */
		public void setCampoContrasena(JTextField campoContrasena) {
			this.campoContrasena = campoContrasena;
		}

		/**
		 * Obtener el botón de iniciar sesión.
		 * 
		 * @return el botón de iniciar sesión.
		 */
		public JButton getBotonIniciarSesion() {
			return botonIniciarSesion;
		}

		/**
		 * Definir el botón de iniciar sesión.
		 * 
		 * @param botonIniciarSesion el botón de iniciar sesión a definir.
		 */
		public void setBotonIniciarSesion(JButton botonIniciarSesion) {
			this.botonIniciarSesion = botonIniciarSesion;
		}

		/**
		 * Obtener el botón de volver.
		 * 
		 * @return el botón de volver.
		 */
		public JButton getBotonVolver() {
			return botonVolver;
		}

		/**
		 * Definir el botón de volver.
		 * 
		 * @param botonVolver el botón de volver a definir.
		 */
		public void setBotonVolver(JButton botonVolver) {
			this.botonVolver = botonVolver;
		}
	}
}