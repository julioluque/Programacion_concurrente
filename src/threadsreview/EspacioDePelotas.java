package threadsreview;

import javax.swing.*;
import java.util.*;
import java.awt.*;
/**
 * Lamina que dibuja la pelota
 * 
 * @author Alfredo
 *
 */
@SuppressWarnings("serial")
public class EspacioDePelotas extends JPanel {

	ArrayList<Pelota> pelotas = new ArrayList<Pelota>();

//	Agregamos una nueva pelota a la lamina
	public void add(Pelota p) {
		pelotas.add(p);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		for (Pelota p : pelotas) {
			g2.fill(p.getForma());
		}
	}

}
