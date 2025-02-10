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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaMenuPizzas extends JFrame {
	private PanelMenuPizza panelMenuPizza;

	public VentanaMenuPizzas() {
		setTitle("Menu de Pizzas");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
		inicializarComponentes();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false); 
	}

	public void inicializarComponentes() {
		panelMenuPizza = new PanelMenuPizza();
		add(panelMenuPizza);
	}

	public  PanelMenuPizza getPanelMenuPizza(){
		return panelMenuPizza;
	}

	public class PanelMenuPizza extends JPanel {

		private Image imagenFondo;
		private JButton botonPizzaPepperoni;
		private JButton botonPizzaVegetariana;
		private JButton botonPizzaHawaiana;
		private JButton botonPizzaMexicana;
		private JButton botonPizzaBBQ;
		private JButton botonPizzaCarnívora;
		private JButton botonPizzaMariscos;
		private JButton botonPizzaNapolitana;
		private JButton botonPizzaRanchera;
		private JButton botonTerminarPedido;

		private JLabel labelPizzaPepperoni;
		private JLabel labelPizzaVegetariana;
		private JLabel labelPizzaHawaiana;
		private JLabel labelPizzaMexicana;
		private JLabel labelPizzaBBQ;
		private JLabel labelPizzaCarnívora;
		private JLabel labelPizzaMariscos;
		private JLabel labelPizzaNapolitana;
		private JLabel labelPizzaRanchera;

		private JLabel nPepperoni;
		private JLabel nVegetariana;
		private JLabel nHawaiana;
		private JLabel nMexicana;
		private JLabel nBBQ;
		private JLabel nCarnívora;
		private JLabel nMariscos;
		private JLabel nNapolitana;
		private JLabel nRanchera;

		public PanelMenuPizza() {
			setLayout(null); // Usar layout nulo para posicionamiento manual
			try {
				// Cargar imagen de fondo
				InputStream is = getClass().getClassLoader().getResourceAsStream("resources/imagenCuadradaAzul.jpg");
				if (is != null) {
					imagenFondo = ImageIO.read(is);
				} else {
					System.err.println("No se pudo cargar la imagen de fondo.");
				}

				// Inicializar componentes (botones e imágenes)
				inicializarComponentes();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
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
				float alpha = 0.2f;
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
				int x = 190;
				int y = 30;
				g2d.drawImage(imagenEscalada, x, y, this);
				g2d.setComposite(originalComposite);
			}
		}

		public void inicializarComponentes() {
			// Crear botones
			
			botonTerminarPedido = new JButton("Realizar Pedido");
			botonTerminarPedido.setBounds(250, 470, 300, 50);
			botonTerminarPedido.setFont(new Font("Arial", Font.BOLD, 20));
			botonTerminarPedido.setForeground(Color.black);
			botonTerminarPedido.setActionCommand("terminar_pedido");
			add(botonTerminarPedido);

			botonPizzaPepperoni = new JButton("Pedir porcion de pepperoni");
			botonPizzaPepperoni.setBounds(50, 120, 200, 30);
			botonPizzaPepperoni.setActionCommand("pepperoni");
			add(botonPizzaPepperoni);

			botonPizzaVegetariana = new JButton("Pedir porcion de Vegetariana");
			botonPizzaVegetariana.setBounds(50, 260, 200, 30);
			botonPizzaVegetariana.setActionCommand("vegetariana");
			add(botonPizzaVegetariana);

			botonPizzaHawaiana = new JButton("Pedir porcion de Hawaiana");
			botonPizzaHawaiana.setBounds(50, 400, 200, 30);
			botonPizzaHawaiana.setActionCommand("hawaiana");
			add(botonPizzaHawaiana);

			botonPizzaMexicana = new JButton("Pedir porcion de Mexicana");
			botonPizzaMexicana.setBounds(300, 120, 200, 30);
			botonPizzaMexicana.setActionCommand("mexicana");
			add(botonPizzaMexicana);

			botonPizzaBBQ = new JButton("Pedir porcion de BBQ");
			botonPizzaBBQ.setBounds(300, 260, 200, 30);
			botonPizzaBBQ.setActionCommand("bbq");
			add(botonPizzaBBQ);

			botonPizzaCarnívora = new JButton("Pedir porcion de Carnívora");
			botonPizzaCarnívora.setBounds(300, 400, 200, 30);
			botonPizzaCarnívora.setActionCommand("carnivora");
			add(botonPizzaCarnívora);

			botonPizzaMariscos = new JButton("Pedir porcion de Mariscos");
			botonPizzaMariscos.setBounds(550, 120, 200, 30);
			botonPizzaMariscos.setActionCommand("mariscos");
			add(botonPizzaMariscos);

			botonPizzaNapolitana = new JButton("Pedir porcion de Napolitana");
			botonPizzaNapolitana.setBounds(550, 260, 200, 30);
			botonPizzaNapolitana.setActionCommand("napolitana");
			add(botonPizzaNapolitana);

			botonPizzaRanchera = new JButton("Pedir porcion de Ranchera");
			botonPizzaRanchera.setBounds(550, 400, 200, 30);
			botonPizzaRanchera.setActionCommand("ranchera");
			add(botonPizzaRanchera);

			// Crear y posicionar imágenes
			labelPizzaPepperoni = crearImagen("resources/pepperoni.jpg", 70, 20);
			labelPizzaVegetariana = crearImagen("resources/vegetariana.jpg", 70, 160);
			labelPizzaHawaiana = crearImagen("resources/hawaiana.jpg", 70, 300);
			labelPizzaMexicana = crearImagen("resources/mexicana.jpg", 320, 20);
			labelPizzaBBQ = crearImagen("resources/bbq.jpg", 320, 160);
			labelPizzaCarnívora = crearImagen("resources/carnivora.jpg", 320, 300);
			labelPizzaMariscos = crearImagen("resources/mariscos.jpg", 570, 20);
			labelPizzaNapolitana = crearImagen("resources/napolitana.jpg", 570, 160);
			labelPizzaRanchera = crearImagen("resources/ranchera.jpg", 570, 300);
			
			// numero de porciones de pizza
			nPepperoni = new JLabel("0");
	        nPepperoni.setBounds(210, 60, 10, 10);
	        nPepperoni.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        add(nPepperoni);

	       	nVegetariana = new JLabel("0");
	        nVegetariana.setBounds(210, 200, 10, 10);
	        nVegetariana.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        add(nVegetariana);

	        nHawaiana = new JLabel("0");
	        nHawaiana.setBounds(210, 340, 10, 10);
	        nHawaiana.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        add(nHawaiana);

	       	nMexicana = new JLabel("0");
	        nMexicana.setBounds(470, 60, 10, 10);
	        nMexicana.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        add(nMexicana);

	        nBBQ = new JLabel("0");
	        nBBQ.setBounds(470, 200, 10, 10);
	        nBBQ.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        add(nBBQ);

	       	nCarnívora = new JLabel("0");
	        nCarnívora.setBounds(470, 340, 10, 10);
	        nCarnívora.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        add(nCarnívora);

	        nMariscos = new JLabel("0");
	        nMariscos.setBounds(710, 60, 10, 10);
	        nMariscos.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        add(nMariscos);

	        nNapolitana = new JLabel("0");
	        nNapolitana.setBounds(710, 200, 10, 10);
	        nNapolitana.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        add(nNapolitana);

	        nRanchera = new JLabel("0");
	        nRanchera.setBounds(710, 340, 10, 10);
	        nRanchera.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        add(nRanchera);
		}

		public JLabel getNPepperoni(){
			return nPepperoni;
		}

		public JLabel getNVegetariana(){
			return nVegetariana;
		}
		public JLabel getNMexicana(){
			return nMexicana;
		}
		public JLabel getNHawaiana(){
			return nHawaiana;
		}
		public JLabel getNBBQ(){
			return nBBQ;
		}
		public JLabel getNCarnivora(){
			return nCarnívora;
		}
		public JLabel getNMariscos(){
			return nMariscos;
		}
		public JLabel getNRanchera(){
			return nRanchera;
		}
		public JLabel getNNapolitana(){
			return nNapolitana;
		}

		public JButton getBotonPizzaPepperoni(){
			return botonPizzaPepperoni;
		}
		public JButton getBotonPizzaVegetariana(){
			return botonPizzaVegetariana;
		}

		public JButton getBotonPizzaHawaiana(){
			return botonPizzaHawaiana;
		}

		public JButton getBotonPizzaMexicana(){
			return botonPizzaMexicana;
		}

		public JButton getBotonPizzaBBQ(){
			return botonPizzaBBQ;
		}

		public JButton getBotonPizzaCarnivora(){
			return botonPizzaCarnívora;
		}

		public JButton getBotonPizzaMariscos(){
			return botonPizzaMariscos;
		}

		public JButton getBotonPizzaNapolitana(){
			return botonPizzaNapolitana;
		}

		public JButton getBotonPizzaRanchera(){
			return botonPizzaRanchera;
		}

		public JButton getBotonTerminarPedido(){
			return botonTerminarPedido;
		}

		private JLabel crearImagen(String rutaImagen, int x, int y) {
			try {
				InputStream is = getClass().getClassLoader().getResourceAsStream(rutaImagen);
				if (is != null) {
					Image imagen = ImageIO.read(is);
					if (imagen != null) {
						Image imagenEscalada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
						JLabel label = new JLabel(new ImageIcon(imagenEscalada));
						label.setBounds(x, y, 100, 100); // Posicionar la imagen
						add(label);
						return label;
					} else {
						System.err.println("La imagen no se pudo cargar (es null): " + rutaImagen);
					}
				} else {
					System.err.println("No se pudo encontrar el recurso: " + rutaImagen);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
}