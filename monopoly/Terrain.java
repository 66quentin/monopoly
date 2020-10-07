package monopoly;
import java.util.*;




/**
 * Class Terrain
 */
public class Terrain extends Propriete {

  //
  // Fields
  //
	protected int groupe2;
	protected Titre_constructible titre_c;

  public Terrain(int n, int x, int y, int largeur, int hauteur, String nom_c,
			int rotation, String type_c,int groupe, int pr, int co, int n2, int h, int m) {
		super(n, x, y, largeur, hauteur, nom_c, rotation, type_c, groupe, pr, co,n2);
		// TODO Auto-generated constructor stub
		groupe2=groupe;
		titre_c= new Titre_constructible(n2,h,m);
	}

  
  
  public void constuire_Maison() {
	   titre_c.ajouterMaison(); 
  }
  
  public void constuire_Hotel() {
	   titre_c.ajouterHotel(); 
 }
  
  public int getNbHotel() {
	  return titre_c.nbHotel(); 
}
  
  public int getNbMaison() {
	   return titre_c.nbMaison(); 
}
  
  public int getPrixMaison() {
	   return titre_c.getPrixMaison(); 
}
  
  public int getPrixHotel() {
	   return titre_c.getPrixHotel(); 
}
  public int loyer_p() {
	  int calcul=(getNbMaison()+5*getNbHotel())*(getPrix()/3);
	  return calcul;
  }
  
  public int getGroupe() {
	  return groupe2; 
}

}
