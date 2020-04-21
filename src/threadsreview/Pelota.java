package threadsreview;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pelota {

	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;

	private static final int TAMX = 15;
	private static final int TAMY = 15;

	// Definimos posicion y forma de pelota
	public Ellipse2D getForma() {

		return new Ellipse2D.Double(x, y, TAMX, TAMY);
	}

	// Movimiento de pelota, si llega al borde, invierte movimiento.
	public void moverPelota(Rectangle2D borde) {

		x += dx;
		y += dy;

	}
}
