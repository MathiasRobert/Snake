package package_jeu;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Joueur extends JPanel{

	private final int LARGEUR_SERPENT = 50;
	private final int HAUTEUR_SERPENT = 50;

	private Rectangle joueur = new Rectangle(200, 200, LARGEUR_SERPENT, HAUTEUR_SERPENT);

	private int direction = 2;
	
	public void paintComponent(Graphics g){
	    //On choisit une couleur de fond pour le rectangle
	    g.setColor(Color.white);
	    //On le dessine de sorte qu'il occupe toute la surface
	    g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(joueur.x, joueur.y, joueur.width,joueur.height);
	  }

	/**
	 * 
	 * @return the direction
	 */

	public int getDirection() {

		return direction;

	}

	/**
	 * 
	 * @param direction
	 *            the direction to set
	 */

	public void setDirection(int direction) {

		this.direction = direction;

	}

	/**
	 * 
	 * @return the joueur
	 */

	public Rectangle getJoueur() {

		return joueur;

	}

	/**
	 * 
	 * @param x the joueur to set
	 */

	public void setJoueurX(int x) {

		this.joueur.x = x;

	}

	/**
	 * 
	 * @param y the joueur to set
	 */

	public void setJoueurY(int y) {

		this.joueur.y = y;

	}
	
	/**
	 * 
	 * @param 
	 */

	public void ajoutSerpent() {

		this.joueur.width += LARGEUR_SERPENT;

	}

}
