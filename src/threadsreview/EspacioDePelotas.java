package threadsreview;

import javax.swing.*;
import java.util.*;
import java.awt.*;

/**
 * Contruimos un espacio de movimiento y controla los graficos del objeto Pelota
 * 
 * @author Alfredo
 *
 */
//@SuppressWarnings("serial")
public class EspacioDePelotas extends JPanel {

	private static final long serialVersionUID = 12081985L;
	
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
