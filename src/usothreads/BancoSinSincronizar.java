package usothreads;

public class BancoSinSincronizar {

	public static void main(String[] args) {

		Banco b = new Banco();

		for (int i = 0; i < 100; i++) {
			EjecucionTransfrencias r = new EjecucionTransfrencias(b, i, 2000);
			Thread t = new Thread(r);
			t.start();
		}
	}

}

class Banco {
	private final double[] cuentas;

	/**
	 * Crear 100 cuentas corrientes y qeucada cuenta almacena 2000 pesos
	 */
	public Banco() {
		// iniciamos 100 cuentas. 0 a 99
		cuentas = new double[100];

		// cargamos cada cuenta con 2000 pesos
		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i] = 2000;
			System.out.println("Cuenta corriente: " + i + "/$" + cuentas[i]);

		}
	}

	/**
	 * Metodo que controle cuenta origen cuenta destino cantidad de dinero
	 * 
	 * @param cuentaOrigen
	 * @param cuentaDestino
	 * @param cantidad
	 */
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {

//		validamos que el saldo no sea mayor a la cantidad a transferir
		if (cuentas[cuentaOrigen] < cantidad) {
			return;
		}

//		informa el hilo que va a ejecutar
//		System.out.println(Thread.currentThread());

//		Descontamos del saldo de la cuenta origen, la cantidad que queremos transferir
		cuentas[cuentaOrigen] -= cantidad;
		System.out.println("-----------------------------------");
//		Informa la cuenta origne, destino y dinero a trasnferir
		System.out.printf("\n(-) %10.2f de %d para %d | Saldo total : %10.2f%n", cantidad, cuentaOrigen, cuentaDestino,
				getSaldoTotal());

//		incrementamos el saldo de la cuenta destino con la cantidad transferida
		cuentas[cuentaDestino] += cantidad;
		System.out.printf("\n(+) %10.2f de %d para %d | Saldo total : %10.2f%n", cantidad, cuentaOrigen, cuentaDestino,
				getSaldoTotal());

//		System.out.printf("Saldo total : %10.2f%n", getSaldoTotal());
	}

	/**
	 * Verifica el saldo total del banco Deberia mantenerse en 2000
	 * 
	 * @return
	 */
	public double getSaldoTotal() {
		double sumaCuentas = 0;

		for (double a : cuentas) {
			sumaCuentas += a;
		}
		return sumaCuentas;
	}

}

/**
 * 
 * @author Alfredo
 *
 */
class EjecucionTransfrencias implements Runnable {
	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;

	/**
	 * @param b   Objeto Banco
	 * @param de  Cuenta Origen
	 * @param max Imoprte maximo
	 */
	public EjecucionTransfrencias(Banco b, int de, double max) {
		banco = b;
		deLaCuenta = de;
		cantidadMax = max;
	}

	@Override
	public void run() {

		try {
			while (true) {
				int paraLaCuenta = (int) (Math.random() * 100);
				double cantidad = Math.random() * cantidadMax;

				banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
//				Thread.sleep((int) Math.random() * 10);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("  ||| EXCEPCION");
		}
	}

}
