package monopoly;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Joueur extends JPanel {

	private int num_j;
	int position=0;
	JLabel ecriture;
	private ArrayList<Integer> patrimoine = new ArrayList<Integer>(); 
	private int solde = 150000; 
	protected String ListeProp = " : ";

	public ArrayList<Integer> getpatrimoine() {
		return patrimoine;
	}
	
	public int getsolde() {
		return solde;
	}

	

	

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getnum_j() {
		return num_j;
	}


	public Joueur(int x, int y, int largeur, int hauteur) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(x, y, 20, 20);
		this.setLayout(null);
	}

	public Joueur(int num_j, Color color) {
		// TODO Auto-generated constructor stub
		this.num_j = num_j;
		this.setBackground(color);
		ecriture = new JLabel(""+num_j);
		ecriture.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		ecriture.setForeground(Color.WHITE);
		this.add(ecriture);
		if(this.num_j==1){
		this.setBounds(570,583, 20, 28);
		}
		if(this.num_j==2){
	    this.setBounds(600,583, 20, 28);
		}
	}



	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}


	int[] pos_x_j1 = {481,431,381,331,281,231,181,131,81,     31,31,31,31,31,31,31,31,31,31,31,81,131,181,231,281,331,381,431,481,531,531,531,531,531,531,531,531,531,531,531};

	int[] pos_y_j1 = {583,583,583,583,583,583,583,583,583,    583,533,483,433,383,333,283,233,183,33   , 33, 33, 33, 33, 33, 33,33, 33, 33, 33, 33,     133,183,233,283,333,383,433,483,533,583};
	
	int[] pos_x_j2 = {511,461,411,361,311,261,211,161,111,    61,61,61,61,61,61,61,61,61,61,  61,111,161,211,261,311,361,411,461,511, 561,   561,561,561,561,561,561,561,561,561,561};

	int[] pos_y_j2 = {583,583,583,583,583,583,583,583,583,    583,533,483,433,383,333,283,233,183,33   , 33, 33, 33, 33, 33, 33,33, 33, 33, 33, 33,     133,183,233,283,333,383,433,483,533,583};
	
	int[] pos_x_j3 = {481,431,381,331,281,231,181,131,81,     31,31,31,31,31,31,31,31,31,31,31,81,131,181,231,281,331,381,431,481,531,531,531,531,531,531,531,531,531,531,531};

	int[] pos_y_j3 = {583,583,583,583,583,583,583,583,583,    583,533,483,433,383,333,283,233,183,33   , 33, 33, 33, 33, 33, 33,33, 33, 33, 33, 33,     133,183,233,283,333,383,433,483,533,583};
	
	int[] pos_x_j4 = {511,461,411,361,311,261,211,161,111,    61,61,61,61,61,61,61,61,61,61,  61,111,161,211,261,311,361,411,461,511, 561,   561,561,561,561,561,561,561,561,561,561};

	int[] pos_y_j4 = {583,583,583,583,583,583,583,583,583,    583,533,483,433,383,333,283,233,183,33   , 33, 33, 33, 33, 33, 33,33, 33, 33, 33, 33,     133,183,233,283,333,383,433,483,533,583};
	
	public void deplacer(int nouvelle_pos) {
		
		
		/*int nouvelle_pos = (position + Totalde) % 40;
	       position = nouvelle_pos;
		*/  
			this.setLocation(pos_x_j1[nouvelle_pos], pos_y_j1[nouvelle_pos]);
		
			this.setLocation(pos_x_j2[nouvelle_pos], pos_y_j2[nouvelle_pos]);
			
			this.setLocation(pos_x_j3[nouvelle_pos], pos_y_j3[nouvelle_pos]);
			
			this.setLocation(pos_x_j4[nouvelle_pos], pos_y_j4[nouvelle_pos]);
	    
	}
	
	public void debiter(int argent) {
		this.solde = solde-argent;
		
	}
	
	public static void transaction(Joueur joueur1, Joueur joueur2, int somme) {
		joueur1.debiter(somme);
		joueur2.debiter(-somme);
	}
	
	public void acheter(Propriete prop) {
		if(this.getsolde() > prop.getPrix()) {
		 	if(prop.getProprietaire()==0){
		 		debiter(prop.getPrix());
		 		prop.setProprietaire(num_j);
		 		JoueurListeProp(prop.getnom());
		 	}
		 }
	    
	}
	public void JoueurListeProp(String nom) {
		ListeProp=ListeProp+nom+", ";
	}
	
	public String getListe() {
		return ListeProp;
	}
		
		
	}



	

//}