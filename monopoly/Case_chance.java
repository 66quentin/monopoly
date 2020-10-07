package monopoly;

import java.util.ArrayList;

/**
 * Class Case_chance
 */
public class Case_chance extends Case {

	public Case_chance(int n,int x, int y, int largeur, int hauteur, String nom_c,
			int rotation, String type_c, int groupe) {
		super(n,x, y, largeur, hauteur, nom_c, rotation, type_c, groupe);
		// TODO Auto-generated constructor stub
	}
	public static String tirer_carte(Joueur J) {
		ArrayList<String> carte_chance = new ArrayList<String>();
		carte_chance.add("Vous gagnez au Loto et gagner 10.000€");
		carte_chance.add("C'est votre anniversaire, vous gagnez 5.000€");
		carte_chance.add("La vie redemarre à 0: on vous place case depart !");
		carte_chance.add("Petite visite en prison");
		int a=(int)Math.random()*carte_chance.size();
		String carte_tire=carte_chance.get(a);
		switch(a) {
			case 0:
				J.debiter(-10000);
				break;
			case 1:
				J.debiter(-5000);
				break;
			case 2:
				J.setPosition(0);
				break;
			case 3:
				J.setPosition(10);
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
