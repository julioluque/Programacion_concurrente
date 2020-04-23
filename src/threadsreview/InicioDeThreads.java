package threadsreview;

import java.io.Serializable;

import javax.swing.JFrame;

public class InicioDeThreads implements Serializable {

	private static final long serialVersionUID = 12081985L;

	public static void main(String[] args) {

		JFrame marco = new AplicacionController();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}
}
