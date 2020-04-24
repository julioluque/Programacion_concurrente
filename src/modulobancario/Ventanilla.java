package modulobancario;

public class Ventanilla {

	public static void main(String[] args) {

		int cantidadDeCuentas = 100;
		double saldoAperturaDeCuenta = 2000;
		Banco banco = new Banco(cantidadDeCuentas, saldoAperturaDeCuenta);

		for (int i = 0; i < cantidadDeCuentas; i++) {
			
			// operacion por ventanilla
			int cuentaOrigen = i;
			int cuentaDestino = (int) (Math.random() * cantidadDeCuentas);
			double montoATransferir = Math.random() * saldoAperturaDeCuenta;

			HilosTransferencias gestor = new HilosTransferencias(banco, cuentaOrigen, cuentaDestino, montoATransferir);
			
			Thread t = new Thread(gestor);
			t.start();
		}

	}

}
