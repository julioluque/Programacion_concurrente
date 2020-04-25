package modulobancario;

/**
 * Controla transferencias simultaneas
 * @author Alfredo
 *
 */
public class HilosTransferencias implements Runnable {

	private Banco banco;
	private int cuentaOrigen;
	private int cuentaDestino;
	private double montoATransferir;

	public HilosTransferencias(Banco banco, int origen, int destino, double monto) {
		this.banco = banco;
		cuentaOrigen = origen;
		cuentaDestino = destino;
		montoATransferir = monto;
	}

	@Override
	public void run() {

		try {
			while (true) {
				banco.transferir(cuentaOrigen, cuentaDestino, montoATransferir);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Error de TimeOut -> Excepcion: \n");
			e.printStackTrace();
		}
	}
}
