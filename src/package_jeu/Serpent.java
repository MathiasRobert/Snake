package package_jeu;

import java.awt.Graphics;
import java.util.LinkedList;

public class Serpent implements Constantes{

	private LinkedList<Case> listSerp;
	private Direction direction;
	private boolean estMort;
	private int nbrePommeMangé;
	private int moveCounter;

	public Serpent() {
        this.listSerp = new LinkedList<Case>();
        this.listSerp.add(new Case(14, 15));
        this.listSerp.add(new Case(15, 15));
        this.listSerp.add(new Case(16, 15));
        this.listSerp.add(new Case(17, 15));
        this.listSerp.add(new Case(18, 15));
        this.listSerp.add(new Case(19, 15));
        direction = Direction.VERS_LA_GAUCHE;
        estMort = false;
        nbrePommeMangé = 0;
	}
  
	public void calcul(Pomme pomme) {
		// incrémenter le compteur
        this.moveCounter++;
        // vérifier qu'il est temps d'animer le serpent
        if (this.moveCounter >= 4) {
              // remettre le compteur à zéro 
              this.moveCounter = 0;
              if(peutManger(pomme)) {
            	  mange();
            	  pomme.nouvellePomme();
              } else if(peutAvancer())
            	  avance();
              else {
            	  estMort = true;
              }
        }
	}
  
  
	public void affichage(Graphics g) {
		// dessin du serpent
        for (Case box : this.listSerp) {
              g.fillRect(box.getX(), box.getY(), box.getLargeur(), box.getHauteur());
        }
	}
	
	private Case getNextCase() {
	      Case tete = this.listSerp.getFirst();
	      switch (this.direction) {
	            case VERS_LE_HAUT:
	                  return new Case(tete.getIndiceX(), tete.getIndiceY() - 1);
	            case VERS_LA_DROITE:
	                  return new Case(tete.getIndiceX() + 1, tete.getIndiceY());
	            case VERS_LE_BAS:
	                  return new Case(tete.getIndiceX(), tete.getIndiceY() + 1);
	            case VERS_LA_GAUCHE:
	                  return new Case(tete.getIndiceX() - 1, tete.getIndiceY());
	      }
	      return null;
	}
	
	private void avance() {
	      // ajoute en tête de liste la case sur laquelle
	      // le serpent doit se déplacer
	      this.listSerp.addFirst(getNextCase());
	      // supprime le dernier élément de la liste
	      this.listSerp.removeLast();
	}
	
	private boolean peutAvancer() {
	      Case nextCase = getNextCase();
	      return nextCase.estValide() && !this.listSerp.contains(nextCase);
	}
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public boolean getEstMort() {
        return this.estMort;
	}
	
	private void mange() {
	      // ajoute en tête de liste la case sur laquelle
	      // le serpent doit se déplacer
	      this.listSerp.addFirst(getNextCase());
	      this.nbrePommeMangé++;
	}
	private boolean peutManger(Pomme pomme) {
	      return pomme.equals(getNextCase());
	}
	
	/**
	 * @return the nbrePommeMangé
	 */
	public int getNbrePommeMangé() {
		return nbrePommeMangé;
	}
	
}
