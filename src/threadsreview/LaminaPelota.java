package threadsreview;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Lamina que dibuja la pelota
 * 
 * @author Alfredo
 *
 */
public class LaminaPelota extends JPanel {

	ArrayList<Pelota> pelotas = new ArrayList<Pelota>();

//	Agregamos una nueva pelota a la lamina
	public void add(Pelota p) {
		pelotas.add(p);
	}

	public void pintarComponente(Graphics g) {
		super.paintComponents(g);

		Graphics2D g2 = (Graphics2D) g;

		for (Pelota p : pelotas) {
			g2.fill(p.getForma());
		}
	}

}
