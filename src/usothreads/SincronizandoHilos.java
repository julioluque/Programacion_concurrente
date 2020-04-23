package usothreads;

public class SincronizandoHilos {

	public static void main(String[] arg) {

		HilosVarios hilo0 = new HilosVarios();
		HilosVarios2 hilo1 = new HilosVarios2(hilo0);
		HilosVarios3 hilo2 = new HilosVarios3(hilo1);

		hilo2.start();

		hilo1.start();

		hilo0.start();

		System.out.println("FINALIZO LA APLICACION");
	}
}

class HilosVarios extends Thread {

	public HilosVarios() {
		System.out.println(">>>>> STATUS 1: HILO NUEVO " + HilosVarios.class);
	}
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("  ||| STATUS 2: HILO EN EJECUCION |" + getName() + "| Ejecutando Nro " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("<<<<< STATUS 4: HILO MUERTO\n");
	}

}

class HilosVarios2 extends Thread {

	private Thread hilo;

	public HilosVarios2(Thread hilo) {
		this.hilo = hilo;
		System.out.println(">>>>> STATUS 1: HILO NUEVO " + hilo);

	}

	public void run() {
		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 15; i++) {
			System.out.println("  ||| STATUS 2: HILO EN EJECUCION |" + getName() + "| Ejecutando Nro " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("<<<<< STATUS 4: HILO MUERTO\n");

	}

}

class HilosVarios3 extends Thread {

	private Thread hilo;

	public HilosVarios3(Thread hilo) {
		this.hilo = hilo;
		System.out.println(">>>>> STATUS 1: HILO NUEVO " + hilo);
	}

	public void run() {

		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 15; i++) {
			System.out.println("  ||| STATUS 2: HILO EN EJECUCION |" + getName() + "| Ejecutando Nro " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("<<<<< STATUS 4: HILO MUERTO\n");

	}

}
