/**
 * 
 */
package package_jeu;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author mathiasrobert
 *
 */
public class Jeu extends JFrame implements Constantes {

<<<<<<< Updated upstream
	private Joueur j = new Joueur();
	private Pomme p = new Pomme();
	private View vue = new View(j,p);

	public Jeu() {
		this.setTitle("Snake");
		this.setSize(750, 750);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	    this.setContentPane(vue);
	}


	private void move() {
		addKeyListener(this);
			int x = j.getJoueur().x, y = j.getJoueur().y;
			if (j.getDirection() == 1)
				x--;
			if (j.getDirection() == 2)
				x++;
			if(j.getDirection() == 3)
				y--;
			if(j.getDirection() == 4)
				y++;
			
			j.setJoueurX(x);
			j.setJoueurY(y);
			vue.repaint();

			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		
=======
	private ModeleDuJeu modele;

	public Jeu() {
		// titre de la fenêtre
	      super("Snake");
	      // créer le modèle du jeu
	      this.modele = new ModeleDuJeu();
	      // fermeture de l'application lorsque la fenêtre est fermée
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      // pas de redimensionnement possible de la fenêtre
	      setResizable(false);
	      // créer un conteneur qui affichera le jeu
	      final JPanel content = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                  super.paintComponent(g);
	                  // affichage du modèle du jeu
	                  Jeu.this.modele.affichage(g);
	            }
	      };
	      // dimension de ce conteneur 
	      content.setPreferredSize(new Dimension(NBRE_DE_COLONNES * CASE_EN_PIXELS, NBRE_DE_LIGNES * CASE_EN_PIXELS));
	      // ajouter le conteneur à la fenêtre
	      setContentPane(content);
	      // s'assurer du focus pour le listener clavier
	      setFocusable(false);
	      content.setFocusable(true);
	      // le listener gérant les entrées au clavier
	      content.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                  Jeu.this.modele.gestionDuClavier(e);
	            }
	      });
	      // Créer un thread infini
	      Thread thread = new Thread(new Runnable() {                  
	            @Override
	            public void run() {
	                  while (true) { // boucle infinie
	                        // à chaque fois que la boucle est exécutée, la
	                        // méthode de calcul du jeu est appelée.
	                        // Comme la boucle est infinie, la méthode de calcul
	                        // sera appelée en cycle perpétuel.
	                	  	content.addKeyListener(new KeyAdapter() {
	                	  		@Override
	                	  		public void keyPressed(KeyEvent e) {
	            	                Jeu.this.modele.gestionDuClavier(e);
	                	  		}
	                	  	});
	                        Jeu.this.modele.calcul();
	                        // demander à l'EDT de redessiner le conteneur
	                        content.repaint();
	                        try {
	                            Thread.sleep(DELAY);
	                        } catch (InterruptedException e) {
	                        	e.printStackTrace();
	                        }
	                  }                        
	            }
	      });
	      // lancer le thread
	      thread.start();
	      
>>>>>>> Stashed changes
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
<<<<<<< Updated upstream
		Jeu jeu = new Jeu();
		while (true) {
			jeu.move();
			if(jeu.collision())
				jeu.aMangé();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
=======
		// création de la fenêtre
        Jeu jeu = new Jeu();
        // dimensionnement de la fenêre "au plus juste" suivant
        // la taille des composants qu'elle contient
        jeu.pack();
        // centrage sur l'écran
        jeu.setLocationRelativeTo(null);
        // affichage
        jeu.setVisible(true);
>>>>>>> Stashed changes
	}
}

