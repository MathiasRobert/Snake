package package_jeu;

public class Case implements Constantes{
	
	private int indiceX;
	private int indiceY;
	
	public Case(int indiceX, int indiceY) {
		this.indiceX = indiceX;
		this.indiceY = indiceY;
	}
	
	public int getIndiceX() {
		return indiceX;
	}
	public void setIndiceX(int indiceX) {
		this.indiceX = indiceX;
	}
	public int getIndiceY() {
		return indiceY;
	}
	public void setIndiceY(int indiceY) {
		this.indiceY = indiceY;
	}
	public int getX() {
		return indiceX * CASE_EN_PIXELS;
	}
	public int getY() {
		return indiceY * CASE_EN_PIXELS;
	}
	public int getLargeur() {
		return CASE_EN_PIXELS;
	}
	public int getHauteur() {
		return CASE_EN_PIXELS;
	}
	
	// renvoie true si la case est contenue dans le plateau de jeu
    public boolean estValide() {
          return this.indiceX >= 0 && this.indiceX < NBRE_DE_COLONNES
                 && this.indiceY >= 0 && this.indiceY < NBRE_DE_LIGNES;
    }
    
    @Override
    public boolean equals(Object obj) {
          if (obj instanceof Case) {
                Case box = (Case) obj;
                return this.indiceX == box.indiceX
                       && this.indiceY == box.indiceY;
          }
          return false;
    }
	
}
