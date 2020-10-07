package monopoly;
import java.util.*;


/**
 * Class Propriété
 */
public class Propriete extends Case {
  
  private int proprietaire;
  private int prix;
  private int constructible;
  protected Titre_de_propriete titre_prop;
  
  public Propriete (int n,int x, int y, int largeur, int hauteur, String nom_c, int rotation, String type_c, int groupe, int pr, int co,int n2) {
		super(n,x, y, largeur, hauteur, nom_c, rotation, type_c, groupe);
		// TODO Auto-generated constructor stub
		proprietaire=0;
		prix=pr;
		constructible=co; // si 1 oui sinon on peut pas construire 
		titre_prop=new Titre_de_propriete(n2);
  
  }
  
  public boolean Disponibilite() {
	  if(this.proprietaire==0){
		  return true;
	  }else {
		  return false;
	  }
		  
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

  /**
   * Set the value of proprietaire
   * @param newVar the new value of proprietaire
   */
  public void setProprietaire (int id) {
	  proprietaire = id;
  }

  /**
   * Get the value of proprietaire
   * @return the value of proprietaire
   */
  public int getProprietaire () {
    return proprietaire;
  }
  
  public int loyer () {
	    return getPrix()/2;
	  }

  /**
   * Set the value of prix
   * @param newVar the new value of prix
   */
  private void setPrix (int newVar) {
    prix = newVar;
  }

  /**
   * Get the value of prix
   * @return the value of prix
   */
  public int getPrix () {
    return prix;
  }
  
  private int getConstructible () {
	    return constructible;
	  }

  //
  // Other methods
  //

  /**
   */


  /**
   * @return       boolean
   */
 


  /**
   */



}
