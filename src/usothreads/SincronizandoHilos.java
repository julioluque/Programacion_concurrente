package usothreads;

public class SincronizandoHilos {

	public static void main(String[] arg) {

		HilosVarios hilo1 = new HilosVarios();
		HilosVarios hilo2 = new HilosVarios();
		HilosVarios hilo3 = new HilosVarios();

		System.out.println(">>>>> STATUS: 1 HILO NUEVO ");
		hilo1.start();
		try {
			hilo1.join();
			System.out.println("<<<<< STATUS: 4 HILO MUERTO\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(">>>>> STATUS: 1 HILO NUEVO ");
		hilo2.start();
		try {
			hilo2.join();
			System.out.println("<<<<< STATUS: 4 HILO MUERTO\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(">>>>> STATUS: 1 HILO NUEVO ");
		hilo3.start();
		try {
			hilo3.join();
			System.out.println("<<<<< STATUS: 4 HILO MUERTO\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class HilosVarios extends Thread {

	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("||||| STATUS 2: HILO EN EJECUCION |" + getName() + "| Ejecutando Nro " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}