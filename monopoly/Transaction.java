package monopoly;


/**
 * Class Transaction
 */
public class Transaction extends  Case {
	
	
	
 private int montant;
 
 
 
 
 
  public Transaction(int n,int x, int y, int largeur, int hauteur, String nom_c, int rotation, String type_c,int couleur,int mnt) {
		super(n,x, y, largeur, hauteur, nom_c, rotation, type_c,couleur);
		// TODO Auto-generated constructor stub
	   montant=mnt;
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
   * Set the value of montant
   * @param newVar the new value of montant
   */
  private void setMontant (int newVar) {
    montant = newVar;
  }

  /**
   * Get the value of montant
   * @return the value of montant
   */
  public int getMontant () {
    return montant;
  }

  //
  // Other methods
  //

}
