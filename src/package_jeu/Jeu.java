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
	private Pomme p = new Pomme();
	private View vue = new View(j,p);

	public Jeu() {
		this.setTitle("Snake");
		this.setSize(750, 750);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	    this.setContentPane(vue);
	}


	private void move() {
		addKeyListener(this);
			int x = j.getJoueur().x, y = j.getJoueur().y;
			if (j.getDirection() == 1)
				x--;
			if (j.getDirection() == 2)
				x++;
			if(j.getDirection() == 3)
				y--;
			if(j.getDirection() == 4)
				y++;
			
			j.setJoueurX(x);
			j.setJoueurY(y);
			vue.repaint();

			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		
	}
	
	private boolean collision() {
			int leftJ, leftP;
		    int rightJ, rightP;
		    int topJ, topP;
		    int bottomJ, bottomP;

		    leftJ = j.getJoueur().x;
		    rightJ = j.getJoueur().x + j.getJoueur().width;
		    topJ = j.getJoueur().y;
		    bottomJ = j.getJoueur().y + j.getJoueur().height;

		    leftP = p.getPomme().x;
		    rightP = p.getPomme().x + p.getPomme().width;
		    topP = p.getPomme().y;
		    bottomP = p.getPomme().y + p.getPomme().height;

		    if(bottomJ <= topP)
		        return false;
		    if(topJ >= bottomP)
		        return false;
		    if(rightJ <= leftP)
		        return false;
		    if(leftJ >= rightP)
		        return false;

		    return true;
	}
	
	private void aMangé() {
		j.ajoutSerpent();
		p.nouvellePomme();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		while (true) {
			jeu.move();
			if(jeu.collision())
				jeu.aMangé();
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
