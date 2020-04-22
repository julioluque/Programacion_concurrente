package threadsreview;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Creamos el marco de la aplicacion, donde definiremos el espacio de movimiento
 * y el espacio para los botones
 * 
 * @author Alfredo
 *
 */
//@SuppressWarnings("serial")
public class AplicacionController extends JFrame {

	private static final long serialVersionUID = 12081985L;

	private AreaDeJuego areaDeJuego;

	public AplicacionController() {

		setBounds(600, 300, 400, 350);
		setTitle("Rebotes");

		areaDeJuego = new AreaDeJuego();
		add(areaDeJuego, BorderLayout.CENTER);

		JPanel areaDeBotones = new JPanel();

		ponerBoton(areaDeBotones, "Empezar!", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comenzarJuego();
			}
		});

		ponerBoton(areaDeBotones, "Salir", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		add(areaDeBotones, BorderLayout.SOUTH);
	}

	public void ponerBoton(Container contenedor, String titulo, ActionListener oyente) {
		JButton boton = new JButton(titulo);
		contenedor.add(boton);
		boton.addActionListener(oyente);
	}

	/**
	 * Define cantidad de repeticiones que sera controlada por el objeto Pelota
	 */
	public void comenzarJuego() {
		Pelota pelota = new Pelota();
		areaDeJuego.add(pelota);
		
		Runnable pelotaAEjecutar = new PelotaHilos(pelota, areaDeJuego);

		Thread hilo_1 = new Thread(pelotaAEjecutar);
		
		hilo_1.start();
	}

}
