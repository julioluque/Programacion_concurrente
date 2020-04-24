package modulobancario;

public class Ventanilla {

	public static void main(String[] args) {

		int cuentas = 100;
		double saldoInicial = 2000;
		Banco banco = new Banco(cuentas, saldoInicial);

		for (int cuenta = 0; cuenta < cuentas; cuenta++) {
			HilosTransferencias gestor = new HilosTransferencias(banco, cuenta, saldoInicial, cuentas);
			Thread t = new Thread(gestor);
			t.start();
		}

	}

}
