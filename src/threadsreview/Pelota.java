package threadsreview;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

/**
 * Controlador el movimiento de pelota segun coordenadas x e y
 * 
 * @author Alfredo
 *
 */
public class Pelota implements Serializable {

	private static final long serialVersionUID = 12081985L;

	private double x = 0;
	private double y = 0;
//	private double dx = 1;
//	private double dy = 1;
	
	private double dx = Math.random()*10;
	private double dy = Math.random()*10;

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

		if (x < borde.getMinX()) {
			x = borde.getMinX();
			dx = -dx;
		}

		if (x + TAMX >= borde.getMaxX()) {
			x = borde.getMaxX() - TAMX;
			dx = -dx;
		}

		if (y < borde.getMinY()) {
			y = borde.getMinY();
			dy = -dy;
		}

		if (y + TAMY >= borde.getMaxY()) {
			y = borde.getMaxY() - TAMY;
			dy = -dy;
		}
	}
}
