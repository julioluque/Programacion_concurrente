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
	private Thread hilo1, hilo2, hilo3;

	JButton botonIniciar1, botonIniciar2, botonIniciar3;
	JButton botonDetener1, botonDetener2, botonDetener3;

	public AplicacionController() {

		setBounds(870, 0, 500, 745);
		setTitle("Rebotes");

		areaDeJuego = new AreaDeJuego();
		add(areaDeJuego, BorderLayout.CENTER);

		JPanel areaDeBotones = new JPanel();
		add(areaDeBotones, BorderLayout.SOUTH);

		botonIniciar1 = new JButton("Go 1");
		botonIniciar2 = new JButton("Go 2");
		botonIniciar3 = new JButton("Go 3");

		areaDeBotones.add(botonIniciar1);
		areaDeBotones.add(botonIniciar2);
		areaDeBotones.add(botonIniciar3);

		botonDetener1 = new JButton("X 1");
		botonDetener2 = new JButton("X 2");
		botonDetener3 = new JButton("X 3");

		areaDeBotones.add(botonDetener1);
		areaDeBotones.add(botonDetener2);
		areaDeBotones.add(botonDetener3);

		botonIniciar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comenzar(e);
			}
		});

		botonIniciar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comenzar(e);
			}
		});

		botonIniciar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comenzar(e);
			}
		});

		botonDetener1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detener(e);
			}
		});

		botonDetener2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detener(e);
			}
		});

		botonDetener3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detener(e);
			}
		});
	}

	/**
	 * Define cantidad de repeticiones que sera controlada por el objeto Pelota
	 */
	public void comenzar(ActionEvent evento) {
		Pelota pelota = new Pelota();
		areaDeJuego.add(pelota);

		Runnable pelotaAEjecutar = new PelotaHilos(pelota, areaDeJuego);

		if (evento.getSource().equals(botonIniciar1)) {
			hilo1 = new Thread(pelotaAEjecutar);
			hilo1.start();
		} else if (evento.getSource().equals(botonIniciar2)) {
			hilo2 = new Thread(pelotaAEjecutar);
			hilo2.start();
		} else if (evento.getSource().equals(botonIniciar3)) {
			hilo3 = new Thread(pelotaAEjecutar);
			hilo3.start();
		}
	}

	public void detener(ActionEvent evento) {

		if (evento.getSource().equals(botonDetener1)) {
			hilo1.interrupt();
			System.out.println("||||| ACTION: Se detuvo el hilo 1. INFO: " + hilo1);

		} else if (evento.getSource().equals(botonDetener2)) {
			hilo2.interrupt();
			System.out.println("||||| ACTION: Se detuvo el hilo 2. INFO: " + hilo2);

		} else if (evento.getSource().equals(botonDetener3)) {
			hilo3.interrupt();
			System.out.println("||||| ACTION: Se detuvo el hilo 3. INFO: " + hilo3);
		}
	}

}
