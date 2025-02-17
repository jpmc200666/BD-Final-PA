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
import javax.swing.JTextArea;

public class VentanaRecibo extends JFrame {
	private PanelRecibo panelRecibo;

	public VentanaRecibo() {
		setTitle("Recibo");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
		inicializarComponentes();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}

	public void inicializarComponentes() {
		panelRecibo = new PanelRecibo();
		add(panelRecibo);
	}

	public PanelRecibo getPanelRecibo() {
		return panelRecibo;
	}

	public void setPanelRecibo(PanelRecibo panelRecibo) {
		this.panelRecibo = panelRecibo;
	}

	public class PanelRecibo extends JPanel {
		private Image imagenFondo;
		private JLabel eTotalPagar;
		private JLabel eNombre;
		private JLabel ePizzas;
		private JButton botonCerrar;
		private JButton botonVolver;
		private JTextArea listaPizzas;

		public PanelRecibo() {
			setLayout(null);
			cargarImagenFondo();
			inicializarComponentes();
			setVisible(true);
		}

		private void cargarImagenFondo() {
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
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Establecer color de fondo
			g.setColor(new Color(0, 74, 173));
			g.fillRect(0, 0, getWidth(), getHeight());

			// Dibujar la imagen con transparencia
			if (imagenFondo != null) {
				int ximage = 400;
				int yimage = 400;
				Image imagenEscalada = imagenFondo.getScaledInstance(ximage, yimage, Image.SCALE_SMOOTH);

				Graphics2D g2d = (Graphics2D) g;
				Composite originalComposite = g2d.getComposite();

				float alpha = 0.2f; // Ajusta este valor para más o menos transparencia
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

				int x = 140; // Margen izquierdo
				int y = 30; // Margen superior
				g2d.drawImage(imagenEscalada, x, y, this);

				g2d.setComposite(originalComposite);
			}
		}

		public void inicializarComponentes() {
			botonVolver = new JButton("Hacer otro pedido");
			botonVolver.setActionCommand("VOLVER_RECIBO");
			botonVolver.setBounds(40, 400, 140, 30);
			add(botonVolver);

			eNombre = new JLabel("Cliente: ");
			eNombre.setBounds(200, 50, 200, 20);
			eNombre.setForeground(Color.WHITE);
			eNombre.setFont(new Font("Arial", Font.BOLD, 16));
			add(eNombre);

			ePizzas = new JLabel("Porciones de pizza: ");
			ePizzas.setBounds(105, 60, 200, 100);
			ePizzas.setForeground(Color.WHITE);
			ePizzas.setFont(new Font("Arial", Font.BOLD, 16));
			add(ePizzas);

			listaPizzas = new JTextArea(
		            "    Pepperoni = \n" +
		                    "    Hawaiana = \n" +
		                    "    Mexicana = \n" +
		                    "    Ranchera = \n" +
		                    "     Mariscos = \n" +
		                    "             BBQ = \n" +
		                    "  Napolitana = \n" +
		                    "Vegetariana = \n" +
		                    "    Carnivora = "
		                );
			listaPizzas.setEditable(false);
			listaPizzas.setBounds(280, 105, 200, 160);
			listaPizzas.setFont(new Font("Arial", Font.BOLD, 14));
			add(listaPizzas);

			eTotalPagar = new JLabel("Total a pagar: ");
			eTotalPagar.setBounds(160, 300, 1200, 20);
			eTotalPagar.setForeground(Color.WHITE);
			eTotalPagar.setFont(new Font("Arial", Font.BOLD, 16));
			add(eTotalPagar);

			botonCerrar = new JButton("CERRAR");
			botonCerrar.setActionCommand("RECIBO_CERRAR");
			botonCerrar.setBounds(250, 350, 200, 30);
			botonCerrar.setForeground(Color.black);
			botonCerrar.setFont(new Font("Arial", Font.BOLD, 20));
			add(botonCerrar);
		}

		public Image getImagenFondo() {
			return imagenFondo;
		}

		public void setImagenFondo(Image imagenFondo) {
			this.imagenFondo = imagenFondo;
		}

		public JLabel geteTotalPagar() {
			return eTotalPagar;
		}

		public void seteTotalPagar(JLabel eTotalPagar) {
			this.eTotalPagar = eTotalPagar;
		}

		public JLabel geteNombre() {
			return eNombre;
		}

		public void seteNombre(JLabel eNombre) {
			this.eNombre = eNombre;
		}

		public JLabel getePizzas() {
			return ePizzas;
		}

		public void setePizzas(JLabel ePizzas) {
			this.ePizzas = ePizzas;
		}

		public JButton getBotonCerrar() {
			return botonCerrar;
		}

		public void setBotonCerrar(JButton botonCerrar) {
			this.botonCerrar = botonCerrar;
		}

		public JButton getBotonVolver() {
			return botonVolver;
		}

		public void setBotonVolver(JButton botonVolver) {
			this.botonVolver = botonVolver;
		}

		public JTextArea getListaPizzas() {
			return listaPizzas;
		}

		public void setListaPizzas(JTextArea listaPizzas) {
			this.listaPizzas = listaPizzas;
		}

	}
}