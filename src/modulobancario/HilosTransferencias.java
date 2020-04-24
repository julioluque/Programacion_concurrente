package modulobancario;

public class HilosTransferencias implements Runnable {

	private Banco banco;
	private int cuentas;
	private int cuentaOrigen;
	private double montoMaximo;

	public HilosTransferencias(Banco banco, int origen, double cantidad, int cuentas) {
		this.banco = banco;
		this.cuentas = cuentas;
		cuentaOrigen = origen;
		montoMaximo = cantidad;

	}

	@Override
	public void run() {

		try {
			while (true) {
				int cuentaDestino = (int) (Math.random() * cuentas);
				double monto = Math.random() * montoMaximo;

				banco.transferir(cuentaOrigen, cuentaDestino, monto);

				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
