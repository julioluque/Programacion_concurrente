package threadsreview;

import java.awt.Component;

import com.sun.media.sound.SoftTuning;

public class PelotaHilos implements Runnable {

	private Pelota pelota;
	private Component componente;

	public PelotaHilos(Pelota p, Component c) {
		pelota = p;
		componente = c;
	}

	@Override
	public void run() {

		System.out.println(">>>>> Inicio Hilo. Estado de interrupcion = " + Thread.currentThread().isInterrupted());

		/*
		 * EJECUCION CONTROLADA CON LIMITACION DE REPETICIONES, USAMOS SLEEP Y CONTROL DE EXCEPCION
		 * 
		 * int repeticiones = (int) (Math.random() * 3000);
		 * 
		 * for (int i = 1; i <= repeticiones; i++) {
		 * pelota.moverPelota(componente.getBounds());
		 * componente.paint(componente.getGraphics());
		 * 
		 * try { Thread.sleep(4); } catch (InterruptedException e) {
		 * System.out.println("Hilo bloqueado, no se puede interrumpir");
		 * e.printStackTrace(); System.out.println("XXXXX saliendo de la aplicacion");
		 * System.exit(0); } }
		 */

		/*
		 * EJECUCION CON ESTADO DE HILO GENERAL ACTIVO, INFINITO
		 * 
		 * while (!Thread.interrupted()) { pelota.moverPelota(componente.getBounds());
		 * componente.paint(componente.getGraphics()); }
		 */

		/*
		 * EJECUCION CON ESTADO DE HILO ESPECIFICO ACTIVO, INFINITO
		 */
		while (!Thread.currentThread().isInterrupted()) {
			pelota.moverPelota(componente.getBounds());
			componente.paint(componente.getGraphics());
		}
		System.out.println("<<<<< Fin del hilo. Estado de interrupcion = " + Thread.currentThread().isInterrupted());
	}

}
