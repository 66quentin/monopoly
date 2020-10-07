package monopoly;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class De extends JPanel {
	
	int valeur_de = 1;
	Random aleatoire = new Random();
	
	
	public De(int x, int y, int largeur, int longueur ) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(x, y, largeur, longueur );
		
	}
	
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
				g.drawString(String.valueOf(valeur_de),getWidth()/2 ,getHeight()/2 );
			
			
		}
	
	

	public void Tirer_De(){ 
		valeur_de = aleatoire.nextInt(6) + 1;
		repaint();
		
	}
	
	public int getvaleur_de(){
		return valeur_de;
	}
	
	public De(int x, int y, int largeur, int longueur, String labelString) {
		setBounds(x, y, largeur, longueur );
		setBorder(new LineBorder(new Color(0, 0, 0)));
	}
	
	public void initde(){
		valeur_de=1;
	}

	
	
	

}
