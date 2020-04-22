package threadsreview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Creamos el marco de la aplicacion, donde definiremos el espacio de movimiento
 * y el espacio para los botones
 * 
 * @author Alfredo
 *
 */
//@SuppressWarnings("serial")
public class MarcoDeLaAplicacion extends JFrame {

	private static final long serialVersionUID = 12081985L;	
	
	private EspacioDePelotas espacioDePelotas;

	public MarcoDeLaAplicacion() {

		setBounds(600, 300, 400, 350);
		setTitle("Rebotes");

		espacioDePelotas = new EspacioDePelotas();
		add(espacioDePelotas, BorderLayout.CENTER);

		JPanel espacioDeBotones = new JPanel();

		ponerBoton(espacioDeBotones, "Empezar!", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comenzarJuego();
			}
		});

		ponerBoton(espacioDeBotones, "Salir", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		add(espacioDeBotones, BorderLayout.SOUTH);
	}

	public void ponerBoton(Container contenedor, String titulo, ActionListener oyente) {
		JButton boton = new JButton(titulo);
		contenedor.add(boton);
		boton.addActionListener(oyente);
	}

	public void comenzarJuego() {
		Pelota pelota = new Pelota();
		espacioDePelotas.add(pelota);

		for (int i = 1; i <= 3000; i++) {
			pelota.moverPelota(espacioDePelotas.getBounds());
			espacioDePelotas.paint(espacioDePelotas.getGraphics());
		}
	}

}
