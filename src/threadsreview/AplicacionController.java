package threadsreview;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sun.rmi.runtime.NewThreadAction;

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

	JButton botonIniciar1, botonIniciar2, botonIniciar3, botonIniciarTodos;
	JButton botonDetener1, botonDetener2, botonDetener3, botonDetenerTodos;

	public AplicacionController() {

		setBounds(770, 0, 600, 745);
		setTitle("Rebotes");

		areaDeJuego = new AreaDeJuego();
		add(areaDeJuego, BorderLayout.CENTER);

		JPanel areaDeBotones = new JPanel();
		add(areaDeBotones, BorderLayout.SOUTH);

		botonIniciar1 = new JButton("Go 1");
		botonIniciar2 = new JButton("Go 2");
		botonIniciar3 = new JButton("Go 3");
		botonIniciarTodos = new JButton("Go All");

		areaDeBotones.add(botonIniciar1);
		areaDeBotones.add(botonIniciar2);
		areaDeBotones.add(botonIniciar3);
		areaDeBotones.add(botonIniciarTodos);

		botonDetener1 = new JButton("X 1");
		botonDetener2 = new JButton("X 2");
		botonDetener3 = new JButton("X 3");
		botonDetenerTodos = new JButton("X All");

		areaDeBotones.add(botonDetener1);
		areaDeBotones.add(botonDetener2);
		areaDeBotones.add(botonDetener3);
		areaDeBotones.add(botonDetenerTodos);

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

		botonIniciarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comenzar(e);
			}
		});

		botonDetenerTodos.addActionListener(new ActionListener() {
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

		Pelota pelota1 = new Pelota();
		areaDeJuego.add(pelota1);
		Runnable pelotaAEjecutar1 = new PelotaHilos(pelota1, areaDeJuego);

		Pelota pelota2 = new Pelota();
		areaDeJuego.add(pelota2);
		Runnable pelotaAEjecutar2 = new PelotaHilos(pelota2, areaDeJuego);

		Pelota pelota3 = new Pelota();
		areaDeJuego.add(pelota3);
		Runnable pelotaAEjecutar3 = new PelotaHilos(pelota3, areaDeJuego);

		if (evento.getSource().equals(botonIniciar1)) {
			hilo1 = new Thread(pelotaAEjecutar);
			hilo1.start();
		} else if (evento.getSource().equals(botonIniciar2)) {
			hilo2 = new Thread(pelotaAEjecutar);
			hilo2.start();
		} else if (evento.getSource().equals(botonIniciar3)) {
			hilo3 = new Thread(pelotaAEjecutar);
			hilo3.start();
		} else if (evento.getSource().equals(botonIniciarTodos)) {
			hilo1 = new Thread(pelotaAEjecutar1);
			hilo2 = new Thread(pelotaAEjecutar2);
			hilo3 = new Thread(pelotaAEjecutar3);
			hilo1.start();
			hilo2.start();
			hilo3.start();
		}
	}

	public void detener(ActionEvent evento) {

		if (evento.getSource().equals(botonDetener1)) {
			hilo1.interrupt();
			System.out.println("||||| ACTION: Se detuvo el hilo 1. INFO: " + getName());

		} else if (evento.getSource().equals(botonDetener2)) {
			hilo2.interrupt();
			System.out.println("||||| ACTION: Se detuvo el hilo 2. INFO: " + getName());

		} else if (evento.getSource().equals(botonDetener3)) {
			hilo3.interrupt();
			System.out.println("||||| ACTION: Se detuvo el hilo 3. INFO: " + getName());
		} else if (evento.getSource().equals(botonDetenerTodos)) {
			hilo1.interrupt();
			hilo2.interrupt();
			hilo3.interrupt();
			System.out.println("||||| ACTION: Se detuvieron todos los hilos... ");
		}

	}
}
