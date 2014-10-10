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
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// création de la fenêtre
        Jeu jeu = new Jeu();
        // dimensionnement de la fenêre "au plus juste" suivant
        // la taille des composants qu'elle contient
        jeu.pack();
        // centrage sur l'écran
        jeu.setLocationRelativeTo(null);
        // affichage
        jeu.setVisible(true);
	}
}

