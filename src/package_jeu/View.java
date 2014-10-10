package package_jeu;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class View extends JPanel{
	
	private Joueur joueur;
	private Pomme pomme;
	
	public View(Joueur j, Pomme p) {
		this.joueur = j;
		this.pomme = p;
	}
	
	public void paintComponent(Graphics g){
		//On choisit une couleur de fond pour le rectangle
	    g.setColor(Color.white);
	    //On le dessine de sorte qu'il occupe toute la surface
	    g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.DARK_GRAY);
		for(Rectangle j : joueur.getJoueur())
		g.fillRect(joueur.getJoueur().x, joueur.getJoueur().y, joueur.getJoueur().width,joueur.getJoueur().height);
		g.setColor(Color.red);
		g.fillRect(pomme.getPomme().x, pomme.getPomme().y, pomme.getPomme().width,pomme.getPomme().height);
	  }
}
