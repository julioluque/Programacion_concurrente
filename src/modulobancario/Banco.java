package modulobancario;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Controla el flujo de transferencias
 * 
 * @author Alfredo
 *
 */
public class Banco {

	private final double[] montoCuentasList;

	private ReentrantLock bloqueoSincronizador = new ReentrantLock();

	private Condition fondosInsuficientes;

	public Banco(int cuenta, double saldoInicial) {
		montoCuentasList = new double[cuenta];

		for (int nroCuenta = 0; nroCuenta < montoCuentasList.length; nroCuenta++) {
			montoCuentasList[nroCuenta] = saldoInicial;
		}
	}

	/**
	 * Metodo encargado de generar una sola transferencia cada vez que se lo invoca
	 * 
	 * @param cuentaOrigen
	 * @param cuentaDestino
	 * @param cantidadATransferir
	 */
	public void transferir(int cuentaOrigen, int cuentaDestino, double cantidadATransferir) {

		bloqueoSincronizador.lock();

		try {
			System.out.print("\n" + Thread.currentThread());

			while (montoCuentasList[cuentaOrigen] < cantidadATransferir) {
				System.out.printf(
						"--- FONDOS INSUFICIENTES --- \n Tu cuenta: %3d \t Tu saldo %10.2f \t Monto a Transferir %8.2f %n",
						cuentaOrigen, montoCuentasList[cuentaOrigen], cantidadATransferir);
				
				fondosInsuficientes.await();

			}

			System.out.printf(
					"--- TRANSFERENCIA AUTORIZADA --- \n Tu cuenta: %3d \t Tu saldo %10.2f \t Monto a Transferir %8.2f %n",
					cuentaOrigen, montoCuentasList[cuentaOrigen], cantidadATransferir);

			montoCuentasList[cuentaOrigen] -= cantidadATransferir;
			double saldo = getSaldoTotal();
			montoCuentasList[cuentaDestino] += cantidadATransferir;

			System.out.printf("%10.2f de %3d para %3d | Saldos [anterior:%10.2f  Total:%10.2f] %n", cantidadATransferir,
					cuentaOrigen, cuentaDestino, saldo, getSaldoTotal());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println();
		} finally {
			bloqueoSincronizador.unlock();
		}
	}

	/**
	 * Suma los saldos de las cuentas posterior a las transferencias.
	 * 
	 * @return El importe debe mantenerse constante como fue definido en ventanilla
	 */
	public double getSaldoTotal() {
		double sumaSaldo = 0;
		for (double a : montoCuentasList) {
			sumaSaldo += a;
		}
		return sumaSaldo;
	}

}
