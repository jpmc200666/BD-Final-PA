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
import javax.swing.JPanel;

/**
 * Clase que contiene la ventana de inicio de la aplicación.
 * 
 * @author Grupo JAN
 */
public class VentanaInicioAplicacion extends JFrame {
	private PanelInicioAplicacion panelInicio;

	public VentanaInicioAplicacion() {
		setTitle("Inicio de Aplicacion");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.gray);
		setLayout(new BorderLayout(10, 10));
		inicializarComponentes();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void inicializarComponentes() {
		panelInicio = new PanelInicioAplicacion();
		add(panelInicio);
	}

	public PanelInicioAplicacion getPanelInicio() {
		return panelInicio;
	}

	public void setPanelInicio(PanelInicioAplicacion panelInicio) {
		this.panelInicio = panelInicio;
	}

	/**
	 * Clase interna que contiene el panel de inicio de sesión.
	 */
	class PanelInicioAplicacion extends JPanel {
		private Image imagenFondo;
		private JButton botonIniciarSesion;
		private JButton botonRegistrar;

		public PanelInicioAplicacion() {
			setLayout(null);
			try {
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

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(new Color(0, 74, 173));
			g.fillRect(0, 0, getWidth(), getHeight());

			if (imagenFondo != null) {
				int ximage = 400;
				int yimage = 400;
				Image imagenEscalada = imagenFondo.getScaledInstance(ximage, yimage, Image.SCALE_SMOOTH);
				Graphics2D g2d = (Graphics2D) g;
				Composite originalComposite = g2d.getComposite();
				float alpha = 0.2f;
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
				int x = 50;
				int y = 50;
				g2d.drawImage(imagenEscalada, x, y, this);
				g2d.setComposite(originalComposite);
			}
		}

		public void inicializarComponentes() {
			botonIniciarSesion = new JButton("INICIAR SESIÓN");
			botonIniciarSesion.setActionCommand("INICIAR_SESION_BOTON_INICIO");
			botonIniciarSesion.setBounds(150, 150, 200, 50);
			botonIniciarSesion.setForeground(Color.black);
			botonIniciarSesion.setFont(new Font("Impact", Font.PLAIN, 25));
			add(botonIniciarSesion);

			botonRegistrar = new JButton("REGISTRARME");
			botonRegistrar.setActionCommand("REGISTRARME_BOTON_INICIO");
			botonRegistrar.setBounds(150, 300, 200, 50);
			botonRegistrar.setFont(new Font("Impact", Font.PLAIN, 25));
			botonRegistrar.setForeground(Color.black);
			add(botonRegistrar);
		}

		public Image getImagenFondo() {
			return imagenFondo;
		}

		public void setImagenFondo(Image imagenFondo) {
			this.imagenFondo = imagenFondo;
		}

		public JButton getBotonIniciarSesion() {
			return botonIniciarSesion;
		}

		public void setBotonIniciarSesion(JButton botonIniciarSesion) {
			this.botonIniciarSesion = botonIniciarSesion;
		}

		public JButton getBotonRegistrar() {
			return botonRegistrar;
		}

		public void setBotonRegistrar(JButton botonRegistrar) {
			this.botonRegistrar = botonRegistrar;
		}
	}
}