package package_jeu;

/**
 * @author matrobert
 *
 */
public interface Constantes {
	/** 
     * nombre de colonnes de la surface de jeu 
     */
    public final static int NBRE_DE_COLONNES = 60;
    
    /** 
     * nombre de lignes de la surface de jeu 
     */
    public final static int NBRE_DE_LIGNES = 60;
    
    /** 
     * dimension d'une case en pixels 
     */
    public final static int CASE_EN_PIXELS = 15;
    
    /**
     * Délai d'animation du jeu
     */
    public final int DELAY = 25;
    
	public enum Direction {

	      VERS_LE_HAUT,
	      VERS_LA_DROITE,
	      VERS_LE_BAS,
	      VERS_LA_GAUCHE;
	      
	}
}
