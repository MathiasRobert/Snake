package package_jeu;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class Joueur{

	private final int LARGEUR_SERPENT = 50;
	private final int HAUTEUR_SERPENT = 50;

	private List<Rectangle> joueur = new LinkedList();
	
	public Joueur() {
		joueur.add(rectangle(100,100));
	}

	private int direction = 2;

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

	public List getJoueur() {

		return joueur;

	}
	
	/**
	 * 
	 * @param 
	 */

	public void ajoutSerpent() {

		joueur.add(rectangle(joueur.get(joueur.size()-1).x+LARGEUR_SERPENT,joueur.get(joueur.size()-1).y));

	}
	
	private Rectangle rectangle(int x, int y) {
		Rectangle r = new Rectangle(x,y,LARGEUR_SERPENT, HAUTEUR_SERPENT);
		return r;
	}
}
