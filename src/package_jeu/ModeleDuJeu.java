package package_jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class ModeleDuJeu implements Constantes{
	
	private Serpent serpent;
	private Pomme pomme;
	private boolean partieFini;
	
	public ModeleDuJeu() {
		serpent = new Serpent();
		pomme = new Pomme();
		partieFini = false;
	}
	
	 // le calcul du jeu
    public void calcul() {
    	// calcul du serpent
    	this.pomme.calcul();
        this.serpent.calcul(this.pomme);  
        if(this.serpent.getEstMort())
        	partieFini = true;
    }
    
    // le dessin graphique du jeu
    public void affichage(Graphics g) {
    	serpent.affichage(g);
    	pomme.affichage(g);
    	if (this.partieFini) {
            String str = "Game over";
            g.setColor(Color.RED);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
            FontMetrics fm = g.getFontMetrics();
            int x = (g.getClipBounds().width - fm.stringWidth(str)) / 2;
            int y = (g.getClipBounds().height / 2) + fm.getMaxDescent();
            g.drawString(str, x, y);
    	}
    	// affichage du score
        g.setColor(Color.BLUE);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        g.drawString(String.valueOf(serpent.getNbrePommeMangé()), 5, 25);
    }
    
    public void gestionDuClavier(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_RIGHT && serpent.getDirection() != Direction.VERS_LA_GAUCHE) { // touche flèche droite
        	serpent.setDirection(Direction.VERS_LA_DROITE);
        } else if (event.getKeyCode() == KeyEvent.VK_LEFT && serpent.getDirection() != Direction.VERS_LA_DROITE) { // touche flèche gauche
        	serpent.setDirection(Direction.VERS_LA_GAUCHE);
        } else if (event.getKeyCode() == KeyEvent.VK_UP && serpent.getDirection() != Direction.VERS_LE_BAS) { // touche flèche haut
        	serpent.setDirection(Direction.VERS_LE_HAUT);
        } else if (event.getKeyCode() == KeyEvent.VK_DOWN && serpent.getDirection() != Direction.VERS_LE_HAUT) { // touche flèche bas
        	serpent.setDirection(Direction.VERS_LE_BAS);
        }
  }
}
