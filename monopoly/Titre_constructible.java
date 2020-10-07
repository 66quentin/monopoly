package monopoly;
import java.util.*;


/**
 * Class Titre_constructible_
 */
public class Titre_constructible extends  Titre_de_propriete{

  //
  // Fields
  //

  protected int Prix_hotel;
  protected int Prix_maison;
  protected int nb_maison;
  protected int nb_hotel;
  
  //
  // Constructors
  //
  public Titre_constructible (int n, int h, int m) {
		super(n);
		// TODO Auto-generated constructor stub
		Num_titre_prop=n;
		Prix_hotel=h;
		Prix_maison=m;
		nb_maison=0;
		nb_hotel=0;

}
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of Prix_hotel
   * @param newVar the new value of Prix_hotel
   */
  private void setPrix_hotel (int newVar) {
    Prix_hotel = newVar;
  }
  public void ajouterMaison() {
	  nb_maison++;
  }
  
  public void ajouterHotel() {
	  nb_hotel++;
	  nb_maison=0;
  }
  
  public int nbHotel() {
	  return nb_hotel;
  }
  
  public int nbMaison() {
	  return nb_maison;
  }
  
  public int getPrixMaison() {
	  return Prix_maison;
  }
 
  public int getPrixHotel() {
	  return Prix_hotel;
  }
  /**
   * Get the value of Prix_hotel
   * @return the value of Prix_hotel
   */
  private int getPrix_hotel () {
    return Prix_hotel;
  }

  /**
   * Set the value of Prix_maison
   * @param newVar the new value of Prix_maison
   */
  private void setPrix_maison (int newVar) {
    Prix_maison = newVar;
  }

  /**
   * Get the value of Prix_maison
   * @return the value of Prix_maison
   */
  private int getPrix_maison () {
    return Prix_maison;
  }
 

  //
  // Other methods
  //

}
