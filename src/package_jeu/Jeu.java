/**
 * 
 */
package package_jeu;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

/**
 * @author mathiasrobert
 *
 */
public class Jeu extends JFrame implements KeyListener {

	private Joueur j = new Joueur();

	public Jeu() {
		this.setTitle("Snake");
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		// On choisit une couleur de fond pour le rectangle
		g.setColor(Color.white);
		// On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.DARK_GRAY);
		g.fill3DRect(j.getJoueur().x, j.getJoueur().y, j.getJoueur().width,
				j.getJoueur().height, true);
	}

	private void move() {
		addKeyListener(this);
		this.repaint();

		if (j.getDirection() == 1)
			j.setJoueurX(j.getJoueur().x - 1);
		if (j.getDirection() == 2)
			j.setJoueurX(j.getJoueur().x + 1);
		if(j.getDirection() == 3)
			j.setJoueurY(j.getJoueur().y - 1);
		if(j.getDirection() == 4)
			j.setJoueurY(j.getJoueur().y + 1);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		while (true) {
			jeu.move();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'q' && j.getDirection() != 2)
			j.setDirection(1);
		if (e.getKeyChar() == 'd' && j.getDirection() != 1)
			j.setDirection(2);
		if (e.getKeyChar() == 'z' && j.getDirection() != 4)
			j.setDirection(3);
		if (e.getKeyChar() == 's' && j.getDirection() != 3)
			j.setDirection(4);
	}

}
