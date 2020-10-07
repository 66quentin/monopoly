package monopoly;
import java.util.*;


/**
 * Class Titre_de_propriété
 */
public class Titre_de_propriete {

  //
  // Fields
  //

  protected int Num_titre_prop;
  protected int Montant_loyer;
  
  //
  // Constructors
  //
  public Titre_de_propriete(int n) { 
	  Num_titre_prop=n;
	  
  };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of Num_titre_prop
   * @param newVar the new value of Num_titre_prop
   */
  private void setNum_titre_prop (int newVar) {
    Num_titre_prop = newVar;
  }

  /**
   * Get the value of Num_titre_prop
   * @return the value of Num_titre_prop
   */
  private int getNum_titre_prop () {
    return Num_titre_prop;
  }

  /**
   * Set the value of Montant_loyer
   * @param newVar the new value of Montant_loyer
   */
  private void setMontant_loyer (int newVar) {
    Montant_loyer = newVar;
  }

  /**
   * Get the value of Montant_loyer
   * @return the value of Montant_loyer
   */
  private int getMontant_loyer () {
    return Montant_loyer;
  }

  //
  // Other methods
  //

  /**
   */


}
