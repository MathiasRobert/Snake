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
	private JButton jouerMenu;
	private JButton quitterMenu;
	private JButton réessayerRéessayer;
	private JButton quitterRéessayer;
	private JButton retourJeu;
	private boolean jouer;


	public Jeu() {
		  // titre de la fenêtre
	      super("Snake");
	      jouer = false;
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
	      
	      final JPanel menu = new JPanel() {
	            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

				@Override
	            protected void paintComponent(Graphics g) {
	                  super.paintComponent(g);
	                  }
	      };
	      
	      
	      //Initialise le menu
	      initMenu(menu,content);
	      //Initialise les boutons du menu réessayer
	      initMenuRéessayer(content);
	      //Initialise le contenu durant le jeu
	      initContent(content,menu);
	      
	      // Créer un thread infini
	      Thread thread = new Thread(new Runnable() {                  
	            @Override
	            public void run() {
	                  while (true) { // boucle infinie
	                        // à chaque fois que la boucle est exécutée, la
	                        // méthode de calcul du jeu est appelée.
	                        // Comme la boucle est infinie, la méthode de calcul
	                        // sera appelée en cycle perpétuel.
	                	  	if(jouer) {
	                	  		if(Jeu.this.modele.calcul()) {
		                        	  content.add(réessayerRéessayer);
		                          	  content.add(quitterRéessayer);
		                          	  content.remove(retourJeu);
		                        }

		                        // demander à l'EDT de redessiner le conteneur
		                        content.repaint();
	                	  	}
	                        try {
	                            Thread.sleep(DELAY);
	                        } catch (InterruptedException e) {
	                        	e.printStackTrace();
	                        }
	                  }                        
	            }
	      });
	      thread.start();
	}
	
	private void initContent(final JPanel content, final JPanel menu) {
		// dimension de ce conteneur 
	      content.setPreferredSize(new Dimension(NBRE_DE_COLONNES * CASE_EN_PIXELS, NBRE_DE_LIGNES * CASE_EN_PIXELS));
	      // le listener gérant les entrées au clavier
	      content.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                  Jeu.this.modele.gestionDuClavier(e);
	            }
	      });
	      content.setLayout(null);
	      retourJeu = new JButton("Retour");
	      retourJeu.setBounds(NBRE_DE_COLONNES * CASE_EN_PIXELS - 120, 20, 100, 50);
	      content.add(retourJeu);
	   // le listener gérant les entrées du bouton retour
	      retourJeu.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	            	setContentPane(menu);
	      	      	pack();
	      	      	// s'assurer du focus pour le listener clavier
	      	      	content.setFocusable(false);
	      	      	setFocusable(false);
	      	      	menu.setFocusable(true); 
	      	      	menu.requestFocus();
	                jouer = false;
	                Jeu.this.modele.recommencer();
	            }
	      });
	}
	
	private void initMenuRéessayer(final JPanel content) {
		// Créer les bouttons
	      réessayerRéessayer = new JButton("Réessayer");
	      réessayerRéessayer.setBounds(325, 500, 100, 50);
	      quitterRéessayer = new JButton("Quitter");
	      quitterRéessayer.setBounds(475, 500, 100, 50);

	      // le listener gérant les entrées du bouton réessayer
	      réessayerRéessayer.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                  Jeu.this.modele.recommencer();
	                  content.remove(réessayerRéessayer);
	                  content.remove(quitterRéessayer);
	                  content.add(retourJeu);
	                  content.requestFocus();
	            }
	      });
	      
	      // le listener gérant les entrées du bouton quitter
	      quitterRéessayer.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                  System.exit(0);
	            }
	      });
	}
	
	private void initMenu(final JPanel menu, final JPanel content) {
		// Créer les bouttons
	      menu.setLayout(null);
	      jouerMenu = new JButton("Jouer");
	      jouerMenu.setBounds(325, 500, 100, 50);
	      quitterMenu = new JButton("Quitter");
	      quitterMenu.setBounds(475, 500, 100, 50);
	      menu.add(jouerMenu);
	      menu.add(quitterMenu);
	      // le listener gérant les entrées du bouton jouer
	      jouerMenu.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	      	      	setContentPane(content);
	      	      	pack();
	      	      	// s'assurer du focus pour le listener clavier
	      	      	menu.setFocusable(false);
	      	      	setFocusable(false);
	      	      	content.setFocusable(true); 
	      	      	content.requestFocus();
	                jouer = true;
	            }
	      });
	      
	      // le listener gérant les entrées du bouton quitter
	      quitterMenu.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                  System.exit(0);
	            }
	      });
	      // dimension de ce conteneur 
	      menu.setPreferredSize(new Dimension(NBRE_DE_COLONNES * CASE_EN_PIXELS, NBRE_DE_LIGNES * CASE_EN_PIXELS));
	      // ajouter le conteneur à la fenêtre
	      setContentPane(menu);
	      // s'assurer du focus pour le listener clavier
	      setFocusable(false);
	      menu.setFocusable(true); 
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

