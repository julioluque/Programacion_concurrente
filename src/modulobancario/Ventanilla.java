package modulobancario;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Ventanilla {

	public static void main(String[] args) {

		int cantidadDeCuentas = 100;
		double saldoAperturaDeCuenta = 2000;
		double limitePorTransferencia = 100;
		Banco banco = new Banco(cantidadDeCuentas, saldoAperturaDeCuenta);

		for (int i = 0; i < cantidadDeCuentas; i++) {
			
			// operacion por ventanilla
			int cuentaOrigen = i;
			int cuentaDestino = (int) (Math.random() * cantidadDeCuentas);
			double montoATransferir = Math.random() * limitePorTransferencia;

			HilosTransferencias gestor = new HilosTransferencias(banco, cuentaOrigen, cuentaDestino, montoATransferir);
			
			Thread t = new Thread(gestor);
			t.start();
			
//			try {
//				PrintStream out = new PrintStream(new FileOutputStream("logHilos.txt"));
//				System.setOut(out);
//				
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
		}

	}

}
