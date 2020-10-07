package monopoly;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import monopoly.De;
import monopoly.Joueur;
import monopoly.Plateau;

public class MonopolyMain extends JFrame{
	
	static ArrayList<Joueur> Joueurs = new ArrayList<Joueur>();
	static ArrayList<Joueur> JoueurListe = new ArrayList<Joueur>();

    Plateau plateau;
	private JPanel contenu;
	static JTextArea consoledinfo;
	JPanel zone_info_joueur;
	CardLayout c1 = new CardLayout();
	JButton bouton_caisse;
	JButton bouton_tirer_de;
	JButton bouton_chance;
	JButton Bouton_achat;
	JButton Bouton_maison;
	static Joueur Joueur1 = new Joueur(1, Color.BLUE);
	static Joueur Joueur2 = new Joueur(2, Color.RED);
	static Joueur Joueur3 = new Joueur(3, Color.BLACK);
	static Joueur Joueur4 = new Joueur(4, Color.GREEN);//Il faut remplacer %2 par %4 dans le code pour 4 joueurs
	static JTextArea panelJoueur1TextArea;
	static De de1 = new De(300, 400, 40, 40);
	static De de2 = new De(250, 400, 40, 40);

	static int i=0;
	static int no_case=0;



	
	public MonopolyMain() {
		JoueurListe.add(Joueur1);
		JoueurListe.add(Joueur2);
		JoueurListe.add(Joueur3);
		JoueurListe.add(Joueur4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1080,900);
		contenu = new JPanel();
		contenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenu);
		contenu.setLayout(null);

		JLayeredPane positionneur = new JLayeredPane();
		positionneur.setBorder(new LineBorder(Color.orange));
		positionneur.setBounds(6, 6,680,680);
		contenu.add(positionneur);

		plateau = new Plateau(6,6,900,900);
		plateau.setBackground(Color.decode("#1e90ff"));
		positionneur.add(plateau, new Integer(0));

		
		Joueurs.add(Joueur1);
		positionneur.add(Joueur1, new Integer(1));

		
		Joueurs.add(Joueur2);
		positionneur.add(Joueur2, new Integer(1));
		
		Joueurs.add(Joueur3);
		positionneur.add(Joueur3, new Integer(1));
		
		Joueurs.add(Joueur4);
		positionneur.add(Joueur4, new Integer(1));

		JPanel fenetre_droite = new JPanel();
		fenetre_droite.setBackground(Color.orange);
		fenetre_droite.setBorder(new LineBorder(new Color(0, 0, 0)));
		fenetre_droite.setBounds(800, 25, 419, 600);
		contenu.add(fenetre_droite);
		fenetre_droite.setLayout(null);

		Bouton_achat = new JButton("Acheter");
		Bouton_achat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Bouton_achat.setEnabled(false);
				JoueurListe.get((i+1)%2).acheter((Propriete)Plateau.getCaseAtIndex(no_case));
				Case g = (Case)Plateau.getCaseAtIndex(no_case);
				if(g.getType()=="Terrain") {
					Terrain f=(Terrain)Plateau.getCaseAtIndex(no_case);
					if(Plateau.constructible(f.getGroupe(),JoueurListe.get((i+1)%2).getnum_j())) {
						consoledinfo.setText("Propriete achetee ! Acheter une maison ("+f.getPrix()+"€)ou bien a joueur "+ JoueurListe.get(i).getnum_j()+" de jouer ");
						Bouton_maison.setEnabled(true);
					}else {
						consoledinfo.setText("Propriete achetee ! A joueur "+ JoueurListe.get(i).getnum_j()+" de jouer ");
					}
				}else {
					consoledinfo.setText("Propriete achetee ! A joueur "+ JoueurListe.get(i).getnum_j()+" de jouer ");
				}

			}
		});
		Bouton_achat.setBounds(150, 478, 127, 29);
		fenetre_droite.add(Bouton_achat);
		Bouton_achat.setEnabled(false);

		bouton_chance = new JButton("Carte chance");
		bouton_chance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bouton_chance.setEnabled(false);
				bouton_tirer_de.setEnabled(true);

				consoledinfo.setText(Case_chance.tirer_carte(JoueurListe.get((i+1)%2))+" ! A joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer ");

			}

		});
		bouton_chance.setBounds(150, 520, 127, 29);
		fenetre_droite.add(bouton_chance);
		bouton_chance.setEnabled(false);

		positionneur.add(de1, new Integer(1));

		positionneur.add(de2, new Integer(1));
        
		bouton_tirer_de = new JButton("Tirer les des");

		bouton_tirer_de.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				de1.Tirer_De();
				de2.Tirer_De(); 
				int ancien = JoueurListe.get(i).getPosition();
				int nouvelle_pos=(ancien+de1.getvaleur_de()+de2.getvaleur_de())%40;
				JoueurListe.get(i).setPosition(nouvelle_pos);
				JoueurListe.get(i).deplacer(nouvelle_pos);
				if(ancien > nouvelle_pos)
					JoueurListe.get(i).debiter(-20000);
				verifier(JoueurListe.get(i).position+1,i);
				i=(i+1)%2;

			}

		

		});
		
		
		bouton_tirer_de.setBounds(150, 320, 127, 29);
		fenetre_droite.add(bouton_tirer_de);

		bouton_caisse = new JButton("Carte caisse");
		bouton_caisse.setBounds(150, 560, 127, 29);
		bouton_caisse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bouton_caisse.setEnabled(false);
				bouton_tirer_de.setEnabled(true);

				consoledinfo.setText(Caisse_de_communaute.tirer_carte(JoueurListe.get((i+1)%2))+" ! A joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer ");
				
			}

		

		});
		
		

		
		
		fenetre_droite.add(bouton_caisse);
		bouton_caisse.setEnabled(false);
		
		Bouton_maison = new JButton("Achat maison");

		Bouton_maison.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Terrain f = (Terrain)Plateau.getCaseAtIndex(no_case);
				f.constuire_Maison();
				consoledinfo.setText("1 maison construite (-"+f.getPrixMaison()+"€) pour "+f.getNbMaison()+" maison(s) et "+f.getNbHotel()+" hotels. Acheter un maison a nouveau ou bien a joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer");
				JoueurListe.get(i).debiter(f.getPrixMaison());
				if(f.getNbMaison()>3) {
					f.constuire_Hotel();
					consoledinfo.setText("Un hotel a ete construit ! A joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer");
					Bouton_maison.setEnabled(false);


				}

				

			}

		

		});
		
		
		Bouton_maison.setBounds(150, 435, 127, 29);
		fenetre_droite.add(Bouton_maison);
		Bouton_maison.setEnabled(false);

		JPanel test = new JPanel();
		test.setBounds(81, 212, 246, 68);
		fenetre_droite.add(test);
		test.setLayout(null);

		zone_info_joueur = new JPanel();
		zone_info_joueur.setBounds(81, 28, 246, 169);
		fenetre_droite.add(zone_info_joueur);
		zone_info_joueur.setLayout(c1);
   //------------------------------------------------------------------
		JPanel panelJoueur1 = new JPanel();
		panelJoueur1.setBackground(Color.BLUE);
		zone_info_joueur.add(panelJoueur1, "1");
		panelJoueur1.setLayout(null);
  //----------------------------------------------------------------
		JLabel panelJoueur1Title = new JLabel("Informations");
		panelJoueur1Title.setForeground(Color.BLACK);
		panelJoueur1Title.setHorizontalAlignment(SwingConstants.CENTER);
		panelJoueur1Title.setBounds(0, 6, 240, 16);
		panelJoueur1.add(panelJoueur1Title);

		panelJoueur1TextArea = new JTextArea();
		panelJoueur1TextArea.setBounds(10, 34, 230, 129);
		panelJoueur1.add(panelJoueur1TextArea);
		panelJoueur1TextArea.setLineWrap(true);


	  //-------------------------------------------------------------------

		
		

		consoledinfo = new JTextArea();
		consoledinfo.setColumns(20);
		consoledinfo.setRows(5);
		consoledinfo.setBounds(6, 6, 234, 56);
		test.add(consoledinfo);
		consoledinfo.setLineWrap(true);
		consoledinfo.setText("A joueur "+ JoueurListe.get(i).getnum_j()+" de jouer");


	}
	
	

	
	public static void errorBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.ERROR_MESSAGE);
	}

	public void verifier(int pos, int id) {
		no_case=pos;
		Case c = (Case)Plateau.getCaseAtIndex(pos);
	    Bouton_achat.setEnabled(false);
	    bouton_chance.setEnabled(false);
		bouton_caisse.setEnabled(false);
		Bouton_maison.setEnabled(false);
		switch(c.getType()) {
		case "Gare":
		case "Compagnie":
			Propriete a = (Propriete)Plateau.getCaseAtIndex(pos);
			if(a.Disponibilite()) {
				consoledinfo.setText("Souhaitez-vous acheter la propriete "+a.getnom()+" ("+a.getPrix()+"€)? Sinon a joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer ");
			    Bouton_achat.setEnabled(true);
			}else {
				consoledinfo.setText("Vous payez le loyer. A joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer ");
				Joueur.transaction(JoueurListe.get(i), JoueurListe.get((i+1)%2), a.loyer());
			}
			break;
		case "Terrain":
			Terrain e = (Terrain)Plateau.getCaseAtIndex(pos);
			if(e.Disponibilite()) {
				consoledinfo.setText("Souhaitez-vous acheter la propriete "+e.getnom()+" ("+e.getPrix()+"€)? Sinon a joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer ");
			    Bouton_achat.setEnabled(true);
			}else if(e.getProprietaire()!=JoueurListe.get(i).getnum_j()){
				consoledinfo.setText("Vous payez le loyer a "+ JoueurListe.get((i+1)%2).getnum_j()+" ("+e.getNbMaison()+" maison(s) et "+e.getNbHotel()+" hotel(s)). A joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer ");
				Joueur.transaction(JoueurListe.get((i+1)%2), JoueurListe.get(i), e.loyer_p());
			}else {
				if(Plateau.constructible(e.getGroupe(),JoueurListe.get(i).getnum_j()) && e.getNbHotel()==0) {
					Bouton_maison.setEnabled(true);
					consoledinfo.setText("Souhaitez-vous acheter une maison ? ("+e.getPrix()+"€)? Vous avez  "+e.getPrixMaison()+" maison(s) et "+e.getNbHotel()+" hotel(s). Sinon a joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer ");
				}else {
					consoledinfo.setText("Vous ne pouvez pas construire ce terrain: il faut toutes les proprietes du groupe ou et pas d hotel. A joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer ");
				}
			}
			
			break;
		case "Transaction":
			Transaction d=(Transaction)Plateau.getCaseAtIndex(pos);
			JoueurListe.get(i).debiter(-d.getMontant());
			consoledinfo.setText("Action sur votre compte: "+d.getMontant()+"€. A joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer ");
			break;
		case "Chance":
			consoledinfo.setText("Tirer une carte chance. Puis a joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer ");
		    bouton_chance.setEnabled(true);
			bouton_tirer_de.setEnabled(false);
		    break;

		case "Caisse":
			consoledinfo.setText("Tirer une carte caisse de communaute. Puis a joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer ");
			bouton_caisse.setEnabled(true);
			bouton_tirer_de.setEnabled(false);
			break;
		case "Prison":
			consoledinfo.setText("Direction la prison ! A joueur "+ JoueurListe.get((i+1)%2).getnum_j()+" de jouer");
			JoueurListe.get((i+1)%2).setPosition(10);
			break;
		}

	}
	
	public static void gagnant(int i) {
		panelJoueur1TextArea.setText("GAGNANT : JOUEUR "+i+1);
	}

	public static void main(String[] args) {

		MonopolyMain frame = new MonopolyMain();
		frame.setVisible(true);
		boolean fin=false;
		int id_gagnant=-1;
		
		while(!fin) {
			String liste_prop=" ";
			
			panelJoueur1TextArea.setText("Solde de joueur1:"+JoueurListe.get(0).getsolde()+" €\nSolde de joueur2:"+JoueurListe.get(1).getsolde()+" €\n(R. rue, B. boulevard, A. avenue, Pl. place)\nProprietes du joueur "+ JoueurListe.get((i+1)%2).getListe());

			if(JoueurListe.get(0).getsolde()<=0) {
				fin=true;
				id_gagnant=1;
			}else if(JoueurListe.get(1).getsolde()<=0) {
				fin=true;
				id_gagnant=0;
			}
		}
		gagnant(id_gagnant);



	}

}