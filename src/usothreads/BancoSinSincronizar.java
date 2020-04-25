package usothreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
	private ReentrantLock cierreBanco = new ReentrantLock();
	private Condition saldoSuficiente;

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

		// EL bloqueo se establece en base a una condicion. Condicion = saldo sufuciente
		saldoSuficiente = cierreBanco.newCondition();
	}

	/**
	 * Metodo que controle cuenta origen cuenta destino cantidad de dinero
	 * 
	 * @param cuentaOrigen
	 * @param cuentaDestino
	 * @param cantidad
	 * @throws InterruptedException
	 */
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {

		cierreBanco.lock();

		try {

//			validamos que el saldo no sea mayor a la cantidad a transferir
			while (cuentas[cuentaOrigen] < cantidad) {
				System.out.println("--------------- SALDO INSUFICIENTE ------- cuenta Origen: " + cuentaOrigen
						+ "... saldo: " + cuentas[cuentaOrigen] + " ... cantidad: " + cantidad);
				saldoSuficiente.await();
			}

			System.out.println("--------------- CANTIDAD OK ----------- cuenta Origen: " + cuentaOrigen + "... saldo: "
					+ cuentas[cuentaOrigen] + " ... cantidad: " + cantidad);

//			informa el hilo que va a ejecutar
			System.out.println(Thread.currentThread());

//			Descontamos del saldo de la cuenta origen, la cantidad que queremos transferir
			cuentas[cuentaOrigen] -= cantidad;

//			Informa la cuenta origne, destino y dinero a trasnferir
			System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);

//			incrementamos el saldo de la cuenta destino con la cantidad transferida
			cuentas[cuentaDestino] += cantidad;

			System.out.printf(" Saldo total : %10.2f%n", getSaldoTotal());

			saldoSuficiente.signalAll();

		} finally {

			cierreBanco.unlock();
		}
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
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("  ||| EXCEPCION");
		}
	}

}
