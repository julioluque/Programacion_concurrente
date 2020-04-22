package threadsreview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MarcoDeRebote extends JFrame {

	public MarcoDeRebote() {
		
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
	
	private EspacioDePelotas espacioDePelotas;
}
