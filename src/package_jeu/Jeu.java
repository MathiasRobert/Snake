/**
 * 
 */
package package_jeu;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author mathiasrobert
 *
 */
public class Jeu extends JFrame implements Constantes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ModeleDuJeu modele;
	private JButton réessayer;
	private JButton quitter;


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
	            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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
	      
	      //Initialise les boutons du menu réessayer
	      initMenuRéessayer(content);
	      
	      // Créer un thread infini
	      Thread thread = new Thread(new Runnable() {                  
	            @Override
	            public void run() {
	                  while (true) { // boucle infinie
	                        // à chaque fois que la boucle est exécutée, la
	                        // méthode de calcul du jeu est appelée.
	                        // Comme la boucle est infinie, la méthode de calcul
	                        // sera appelée en cycle perpétuel.
	                        if(Jeu.this.modele.calcul()) {
	                        	  content.add(réessayer);
	                          	  content.add(quitter);
	                        }

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
	
	private void initMenuRéessayer(final JPanel content) {
		// Créer les bouttons
	      content.setLayout(null);
	      réessayer = new JButton("Réessayer");
	      réessayer.setBounds(325, 500, 100, 50);
	      quitter = new JButton("Quitter");
	      quitter.setBounds(475, 500, 100, 50);

	      // le listener gérant les entrées du bouton réessayer
	      réessayer.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                  Jeu.this.modele.réessayer();
	                  content.remove(réessayer);
	                  content.remove(quitter);
	                  content.requestFocus();
	            }
	      });
	      
	      // le listener gérant les entrées du bouton quitter
	      quitter.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                  System.exit(0);
	            }
	      });
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

