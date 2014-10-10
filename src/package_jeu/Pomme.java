package package_jeu;


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
	
}
