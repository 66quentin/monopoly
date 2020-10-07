package monopoly;

import java.util.ArrayList;

/**
 * Class Caisse_de_communauté
 */
public class Caisse_de_communaute extends Case {

	public Caisse_de_communaute(int n,int x, int y, int largeur, int hauteur,
			String nom_c, int rotation, String type_c, int groupe) {
		super(n,x, y, largeur, hauteur, nom_c, rotation, type_c,groupe);
		// TODO Auto-generated constructor stub
	}
	
	public static String tirer_carte(Joueur J) {
		ArrayList<String> carte_chance = new ArrayList<String>();
		carte_chance.add("Cette annee, vous gagnez plus: le fisc vous prend 10.000€");
		carte_chance.add("Vous offrez un cadeau de 5.000€ à votre cousin");
		carte_chance.add("On vous accuse de vol: direction la prison");
		carte_chance.add("Vous trouvez 1.000€ par terre");
		int a=(int)Math.random()*carte_chance.size();
		String carte_tire=carte_chance.get(a);
		switch(a) {
			case 0:
				J.debiter(10000);
				break;
			case 1:
				J.debiter(5000);
				break;
			case 2:
				J.setPosition(10);
				break;
			case 3:
				J.debiter(-1000);
				break;
		}
		return carte_tire;

	}

  //
  // Fields
  //

  
  //
  // Constructors
  //
 


  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  //
  // Other methods
  //

}
