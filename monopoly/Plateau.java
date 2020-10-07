package monopoly;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import monopoly.Case;
import monopoly.Transaction;

	public class Plateau extends JPanel {

		static ArrayList<Object> toutes_case = new ArrayList<Object>();
		//private ArrayList<Case> toutes_case = new ArrayList<Case>();
		
	
		
		public ArrayList<Object> gettoutes_case(){
			return toutes_case;
		}
		
		
		public static Object getCaseAtIndex(int position) {
			return  toutes_case.get(position);
		}
		
		public static boolean constructible(int groupe, int id) {
			boolean res=true;
			int k=0;
			while(k<toutes_case.size()) {
				Case x = (Case)getCaseAtIndex(k);
				if(x.getType()=="Terrain" ) {
					Terrain y = (Terrain)x;
					if(y.getGroupe()== groupe && y.getProprietaire() != id)
						res=false;
				}
				k++;	
			}
			return  false;
		}
		


		public Plateau(int xCoord, int yCoord, int width, int height) {
			setBorder(new LineBorder(new Color(0, 0, 0)));
			setBounds(xCoord, yCoord,660, 660);
			this.setLayout(null);
			initcase();
		}

		private void initcase() {
			// TODO Auto-generated method stub
			String[] nom_case = {
					"DEPART",
					"B. Belville",
					"Caisse",
					"R. Courbe",
					"Impots",
					"Gare Montparnasse",
					"R. Vaugirard",
					"Chance",
					"R. Courcelles",
					"A. Republique",
					"PRISON",
					"B. Villette",
					"Electricite",
					"A. Neuilly",
					"R. Paradis",
					"Gare Lyon",
					"A. Mozart",
					"Caisse",
					"B. St Michel",
					"Pl. Pigale",
					"PARC",
					"A. Matignon",
					"Chance",
					"B. Male-Sherbes",
					"A. Henri-Martin",
					"Gare NORD",
					"Fb. St Honore",
					"Pl. Bourse",
					"EAUX",
					"R. Lafayette",
					"PRISON",
					"A. Breteuil",
					"A. Foch",
					"Caisse",
					"B. Capucines",
					"Gare Saint-Lazare",
					"Chance",
					"A. Champs-Elysees",
					"TAXE",
					"R. Paix",
					
			};
			
				
			
			// Cases bas
			Transaction Case00 = new Transaction(0,556,556,100,100,nom_case[0],0,"Transaction",0,20000);
			this.add(Case00);
			toutes_case.add(Case00);
			
     		
			Propriete Case01 = new Terrain(1,506,556,50,100,nom_case[1],-90,"Terrain",1,3000,1,1,1000,1500);
			this.add(Case01);
			toutes_case.add(Case01);
			
			Caisse_de_communaute Case02 = new Caisse_de_communaute(2,456,556,50,100,nom_case[2],-90,"Caisse",0);
			this.add(Case02);
			toutes_case.add(Case02);
			
			Propriete Case03 = new Terrain(3,406,556,50,100,nom_case[3],-90,"Terrain",1,3000,1,2,1000,1500);
			this.add(Case03);
			toutes_case.add(Case03);
			
			Transaction Case04 = new Transaction(4,356,556,50,100,nom_case[4],-90,"Transaction",0,-20000);
			this.add(Case04);
			toutes_case.add(Case04);
			
			Propriete Case05 = new Gare(5,306,556,50,100,nom_case[5],-90,"Gare",2,2500,0,3);
			this.add(Case05);
			toutes_case.add(Case05);
			
			Propriete Case06 = new Terrain(6,256,556,50,100,nom_case[6],-90,"Terrain",3,3000,1,4,1500,2000);
			this.add(Case06);
			toutes_case.add(Case06);
			
			Case_chance Case07 = new Case_chance(7,206,556,50,100,nom_case[7],-90,"Chance",0);
			this.add(Case07);
			toutes_case.add(Case07);
			
			Propriete Case08 = new Terrain(8,156,556,50,100,nom_case[8],-90,"Terrain",3,3500,1,5,1500,2000);
			this.add(Case08);
			toutes_case.add(Case08);
			
			Propriete Case09 = new Terrain(9,106,556,50,100,nom_case[9],-90,"Terrain",3,3500,1,6,1500,2000);
			this.add(Case09);
			toutes_case.add(Case09);
		    	
			// Cases a gauche 
			Case Case10 = new Case(10,6,556,100,100,nom_case[10],0,"Prison",4);
			this.add(Case10);
			toutes_case.add(Case10);
				
		
			Propriete Case11 = new Terrain(11,6,506,100,50,nom_case[11],0,"Terrain",5,4000,1,7,1500,2500);
			this.add(Case11);
			toutes_case.add(Case11);
			
			Compagnie_de_distribution Case12 = new Compagnie_de_distribution(12,6,456,100,50,nom_case[12],0,"Compagnie",0,2000,0,8);
			this.add(Case12);
			toutes_case.add(Case12);
			
			Propriete Case13 = new Terrain(13,6,406,100,50,nom_case[13],0,"Terrain",5,4000,1,9,2000,2500);
			this.add(Case13);
			toutes_case.add(Case13);
			
			
			Propriete Case14 = new Terrain(14,6,356,100,50,nom_case[14],0,"Terrain",5,4000,1,10,2000,2500);
			this.add(Case14);
			toutes_case.add(Case14);
			
			Propriete Case15 = new Gare(15,6,306,100,50,nom_case[15],0,"Gare",2,2500,0,11);
			this.add(Case15);
			toutes_case.add(Case15);
			
			Propriete Case16 = new Terrain(16,6,256,100,50,nom_case[16],0,"Terrain",6,4000,1,12,2000,2500);
			this.add(Case16);
			toutes_case.add(Case16);
			
			Caisse_de_communaute Case17 = new Caisse_de_communaute(17,6,206,100,50,nom_case[17],0,"Caisse",0);
			this.add(Case17);
			toutes_case.add(Case17);
			
			Propriete Case18 = new Terrain(18,6,156,100,50,nom_case[18],0,"Terrain",6,4000,1,13,2000,2500);
			this.add(Case18);
			toutes_case.add(Case18);
			
			Propriete Case19 = new Terrain(19,6,106,100,50,nom_case[19],0,"Terrain",6,4000,1,14,2000,2500);
			this.add(Case19);
			toutes_case.add(Case19);

			
			
			
   
			// Cases haut
			Transaction Case20 = new Transaction(20,6,6,100,100,nom_case[20],0,"Transaction",0,2000);
			this.add(Case20);
			toutes_case.add(Case20);
		
			
			Propriete Case21 = new Terrain(21,106,6,50,100,nom_case[21],-90,"Terrain",7,4500,1,15,2000,2500);
			this.add(Case21);
			toutes_case.add(Case21);
			
			Case_chance Case22 = new Case_chance(22,156,6,50,100,nom_case[22],-90,"Chance",0);
			this.add(Case22);
			toutes_case.add(Case22);
			
			
			Propriete Case23 = new Terrain (23,206,6,50,100,nom_case[23],-90,"Terrain",7,4500,1,16,2000,2500);
			this.add(Case23);
			toutes_case.add(Case23);
			
			Propriete  Case24 = new Terrain (24,256,6,50,100,nom_case[24],-90,"Terrain",7,4500,1,17,2000,2500);
			this.add(Case24);
			toutes_case.add(Case24);
			
			Propriete  Case25 = new Gare (25,306,6,50,100,nom_case[25],-90,"Gare",2,3000,0,18);
			this.add(Case25);
			toutes_case.add(Case25);
			

			Propriete  Case26 = new Terrain (26,356,6,50,100,nom_case[26],-90,"Terrain",8,4500,1,19,2000,300);
			this.add(Case26);
			toutes_case.add(Case26);
			
			
			Propriete  Case27 = new Terrain (27,406,6,50,100,nom_case[27],-90,"Terrain",8,5000,1,20,2000,3000);
			this.add(Case27);
			toutes_case.add(Case27);
			
			Compagnie_de_distribution Case28 = new Compagnie_de_distribution(28,456,6,50,100,nom_case[28],-90,"Compagnie",0,3000,0,21);
			this.add(Case28);
			toutes_case.add(Case28);
			
		
			Propriete Case29 = new Terrain(29,506,6,50,100,nom_case[29],-90,"Terrain",8,5000,1,22,2000,3000);
			this.add(Case29);
			toutes_case.add(Case29);
			
			// Cases a droite 
			Prison Case30= new Prison(30,556,6,100,100,nom_case[30],0,"Prison",0);
			this.add(Case30);
			toutes_case.add(Case30);
					

			Propriete Case31 = new Terrain(31,556,106,100,50,nom_case[31],0,"Terrain",9,5000,1,23,2000,3000);
            this.add(Case31);
			toutes_case.add(Case31);
			
			Propriete Case32 = new Terrain(32,556,156,100,50,nom_case[32],0,"Terrain",9,5000,1,24,2000,3000);
     		this.add(Case32);
			toutes_case.add(Case32);
			
			
			Caisse_de_communaute Case33 = new Caisse_de_communaute(33,556,206,100,50,nom_case[33],0,"Caisse",0);
			this.add(Case33);
			toutes_case.add(Case33);
			
			Propriete Case34 = new Terrain(34,556,256,100,50,nom_case[34],0,"Terrain",9,5000,1,25,2000,3000);
			this.add(Case34);
			toutes_case.add(Case34);
			
			Propriete Case35 = new Gare(35,556,306,100,50,nom_case[35],0,"Gare",2,3000,0,26);
			this.add(Case35);
			toutes_case.add(Case35);
			
			
			Case_chance Case36 = new Case_chance(36,556,356,100,50,nom_case[36],0,"Chance",0);
			this.add(Case36);
			toutes_case.add(Case36);
			
			
			
			Propriete Case37 = new Terrain(37,556,406,100,50,nom_case[37],0,"Terrain",10,5000,1,27,3000,4000);
			this.add(Case37);
			toutes_case.add(Case37);
			
			
			Transaction Case38 = new Transaction(38,556,456,100,50,nom_case[38],0,"Transaction",0,-10000);
			this.add(Case38);
			toutes_case.add(Case38);
			
			
			Propriete Case39 = new Terrain(39,556,506,100,50,nom_case[39],0,"Terrain",10,5000,1,28,3000,4000);
			this.add(Case39);
			toutes_case.add(Case39);
			
			
						
						
			

			JLabel dessin_monopoly = new JLabel("MONOPOLY Fawzi Quentin"){
				protected void paintComponent(Graphics g) { 
					Graphics2D g2 = (Graphics2D)g;
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);
					AffineTransform aT = g2.getTransform();
					Shape oldshape = g2.getClip();
					double x = getWidth()/2.0;
					double y = getHeight()/2.0;
					aT.rotate(Math.toRadians(0), x, y);
					g2.setTransform(aT);
					g2.setClip(oldshape);
					super.paintComponent(g);
				}
			};
			dessin_monopoly.setForeground(Color.WHITE);
			dessin_monopoly.setBackground(Color.orange);
			dessin_monopoly.setOpaque(true);
			dessin_monopoly.setHorizontalAlignment(SwingConstants.CENTER);
			dessin_monopoly.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			dessin_monopoly.setBounds(179, 277, 263, 55);
			this.add(dessin_monopoly);
			
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}




	}

