package monopoly;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory; 

public class Case extends JPanel {

	int number;
	private String nom;
	JLabel ecriture;
    private	String type_case;
	int groupe;
	
	
	public String getnom() {
		return nom;
	}
	
	public int getId() {
		return number;
	}
	
	public String getType() {
		return type_case;
	}
	
	
public Case(int n, int x, int y, int largeur, int hauteur, String nom_c, final int rotation, String type_c,int groupe) {
		Color couleur_case=Color.BLACK;
		int epaisseur=1;
		switch(groupe) {
		case 1:
			couleur_case=Color.red;
			epaisseur=20;
			break;
		case 3:
			couleur_case=Color.green;
			epaisseur=20;
			break;
		case 5:
			couleur_case=Color.blue;
			epaisseur=20;
			break;
		case 6:
			couleur_case=Color.yellow;
			epaisseur=20;
			break;
		case 7:
			couleur_case=Color.cyan;
			epaisseur=20;
			break;
		case 8:
			couleur_case=Color.magenta;
			epaisseur=20;
			break;
		case 9:
			couleur_case=Color.gray;
			epaisseur=20;
			break;
		case 10:
			couleur_case=Color.pink;
			epaisseur=20;
			break;
		}
		setBorder(BorderFactory.createMatteBorder(epaisseur, 1, 1, 1, couleur_case));

		setBounds(x, y, largeur, hauteur);
		nom = nom_c;
		type_case=type_c;
		this.setLayout(null);

		if(rotation == 0) {
			ecriture = new JLabel(nom_c);
			ecriture.setFont(new Font("Lucida Grande", Font.LAYOUT_LEFT_TO_RIGHT, 12));
			ecriture.setHorizontalAlignment(SwingConstants.CENTER);
			ecriture.setBounds(0,20,this.getWidth(),20);
			this.add(ecriture);
		} else {	
			
			
			ecriture = new JLabel(nom_c) {
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D)g;
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);
					AffineTransform aT = g2.getTransform();
					Shape oldshape = g2.getClip();
					double x = getWidth()/2.0;
					double y = getHeight()/2.0;
					aT.rotate(Math.toRadians(rotation), x, y);
					g2.setTransform(aT);
					g2.setClip(oldshape);
					super.paintComponent(g);
				}
			};
			
			if(rotation == -90 ) {
				ecriture.setBounds(0, 0, this.getWidth(), this.getHeight());
			}
			if(rotation == 0 ) {
				ecriture.setBounds(0, 0, this.getWidth(), this.getHeight());
			}
			ecriture.setFont(new Font("Lucida Grande", Font.LAYOUT_NO_START_CONTEXT, 12));
			ecriture.setHorizontalAlignment(SwingConstants.CENTER);

			this.add(ecriture);
		} 

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
/// a remplir apres 

	}

	
	

}

