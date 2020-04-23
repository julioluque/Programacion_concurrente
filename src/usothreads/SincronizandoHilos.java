package usothreads;

public class SincronizandoHilos {

	public static void main(String[] arg) {

		HilosVarios hilo0 = new HilosVarios();
		HilosVarios2 hilo1 = new HilosVarios2(hilo0);
		HilosVarios3 hilo2 = new HilosVarios3(hilo1);

		System.out.println(">>>>> STATUS 1: HILO NUEVO ");
		hilo2.start();
		try {
			hilo2.join();
			System.out.println("<<<<< STATUS 4: HILO MUERTO\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(">>>>> STATUS 1: HILO NUEVO ");
		hilo1.start();
		try {
			hilo1.join();
			System.out.println("<<<<< STATUS 4: HILO MUERTO\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(">>>>> STATUS 1: HILO NUEVO ");
		hilo0.start();
		try {
			hilo0.join();
			System.out.println("<<<<< STATUS 4: HILO MUERTO\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("FINALIZO LA APLICACION");
	}
}

class HilosVarios extends Thread {

	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("  ||| STATUS 2: HILO EN EJECUCION |" + getName() + "| Ejecutando Nro " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}

class HilosVarios2 extends Thread {

	private Thread hilo;

	public HilosVarios2(Thread hilo) {
		this.hilo = hilo;
	}

	public void run() {
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < 15; i++) {
			System.out.println("  ||| STATUS 2: HILO EN EJECUCION |" + getName() + "| Ejecutando Nro " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class HilosVarios3 extends Thread {

	private Thread hilo;

	public HilosVarios3(Thread hilo) {
		this.hilo = hilo;
	}

	public void run() {
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < 15; i++) {
			System.out.println("  ||| STATUS 2: HILO EN EJECUCION |" + getName() + "| Ejecutando Nro " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
