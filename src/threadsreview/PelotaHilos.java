package threadsreview;

import java.awt.Component;

public class PelotaHilos implements Runnable{

	private Pelota pelota;
	private Component componente;
	
	public PelotaHilos (Pelota p, Component c) {
		pelota = p;
		componente = c;
	}

	@Override
	public void run() {
		
		System.out.println("Inicio Hilo ...");
		int repeticiones = (int) (Math.random()*3000);
		
		for (int i = 1; i <= repeticiones; i++) {
			pelota.moverPelota(componente.getBounds());
			componente.paint(componente.getGraphics());

			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				System.out.println("Hubo un error al ejecutarse un hilo de ejecucion ...");
				e.printStackTrace();
			}
		}

	}
	
	
	
}
