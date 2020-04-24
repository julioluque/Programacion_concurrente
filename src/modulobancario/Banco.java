package modulobancario;

public class Banco {

	private final double[] montoCuentasList;

	public Banco(int cuenta, double saldoInicial) {
		montoCuentasList = new double[cuenta];

		for (int nroCuenta = 0; nroCuenta < montoCuentasList.length; nroCuenta++) {
			montoCuentasList[nroCuenta] = saldoInicial;
		}
	}

	public void transferir(int cuentaOrigen, int cuentaDestino, double cantidadATransferir) {

		
		if (montoCuentasList[cuentaOrigen] < cantidadATransferir) {
			return;
		} else {

			System.out.printf("SALDO ANTERIOR: DE: %2d = $ -%9.2f 'Saldo ####' | PARA %2d = $ +%9.2f 'Saldo ####'| Saldo total : %10.2f%n", 
					cuentaOrigen, cantidadATransferir, cuentaDestino, cantidadATransferir, getSaldoTotal());
			
			montoCuentasList[cuentaOrigen] -= cantidadATransferir;
//			System.out.printf("\nDE: %3d $ -%10.2f 'Saldo ####' | PARA %3d $ +%10.2f 'Saldo ####'| Saldo total : %10.2f%n", 
//					cuentaOrigen, cantidadATransferir, cuentaDestino, cantidadATransferir, getSaldoTotal());

			montoCuentasList[cuentaDestino] += cantidadATransferir;

			System.out.printf("SALDO ACTUAL  : DE: %2d = $ -%9.2f 'Saldo ####' | PARA %2d = $ +%9.2f 'Saldo ####'| Saldo total : %10.2f%n", 
					cuentaOrigen, cantidadATransferir, cuentaDestino, cantidadATransferir, getSaldoTotal());
			
//			System.out.printf("(+) %10.2f de %3d para %3d | Saldo total : %10.2f%n", cantidadATransferir, cuentaOrigen,
//					cuentaDestino, getSaldoTotal());

		}
	}

	public double getSaldoTotal() {
		double sumaSaldo = 0;
		for (double a : montoCuentasList) {
			sumaSaldo += a;
		}
		return sumaSaldo;
	}

}
