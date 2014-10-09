package package_jeu;

import java.awt.Rectangle;

public class Joueur {

	private Rectangle joueur = new Rectangle(200, 200, 50, 50);

	private int direction = 1;

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
	 * @param x
	 *            the joueur to set
	 */

	public void setJoueurX(int x) {

		this.joueur.x = x;

	}

	/**
	 * 
	 * @param y
	 *            the joueur to set
	 */

	public void setJoueurY(int y) {

		this.joueur.y = y;

	}

}
