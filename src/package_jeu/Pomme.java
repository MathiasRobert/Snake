package package_jeu;

<<<<<<< Updated upstream

import java.awt.Rectangle;


public class Pomme{
	
	private Rectangle pomme = new Rectangle(250,250,50,50);
	
	

	/**
	 * @return the pomme
	 */
	public Rectangle getPomme() {
		return pomme;
	}

	/**
	 * @param x the pomme to set
	 */
	public void setPommeX(int x) {
		this.pomme.x = x;
	}
	
	/**
	 * @param y the pomme to set
	 */
	public void setPommeY(int y) {
		this.pomme.y = y;
	}
	
	/**
	 * @param y the pomme to set
	 */
	public void nouvellePomme() {
		int lower = 1;
		int higher = 750 - 50;

		int randomX = (int)(Math.random() * (higher-lower)) + lower;
		int randomY = (int)(Math.random() * (higher-lower)) + lower;
		this.pomme.x = randomX;
		this.pomme.y = randomY;
	}
=======
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Pomme extends Case {
>>>>>>> Stashed changes
	
	private final static Random RND = new Random();
	private int angle;
    
    public Pomme() {
          super(getRandomX(), getRandomY());
    }
    
    private static int getRandomX() {
          return RND.nextInt(NBRE_DE_COLONNES);
    }
    
    private static int getRandomY() {
          return RND.nextInt(NBRE_DE_LIGNES);
    }
    
    public void nouvellePomme() {
        setIndiceX(getRandomX());
        setIndiceY(getRandomY());
        this.angle = 0;
    }
    public void affichage(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;
        // objet initial
        AffineTransform tr = g2.getTransform();
        g.setColor(Color.RED);
        // rotation
        g2.setTransform(AffineTransform.getRotateInstance(
                        Math.toRadians(this.angle),
                        getX() + (getLargeur() / 2),
                        getY() + (getHauteur() / 2)));
        g.fillRect(getX() + 2, getY() + 2, getLargeur() - 4, getHauteur() - 4);
        // annulation de la rotation
        g2.setTransform(tr);
    }
    public void calcul() {
        // incrémentation de l'angle de 4 degrés
        this.angle += 4;
    }
}
