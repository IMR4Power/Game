package Model;

/**
 * ParametersPlateau
 */
public class ParametersPlateau {

    private int nbColonne;
    private int hauteurColonne;

    /**
     * Constructeur
     * @param nbColonne
     * @param hauteurColonne
     */
    public ParametersPlateau(int nbColonne, int hauteurColonne) {
        if(nbColonne >= 4 || hauteurColonne >= 4){
            this.nbColonne = nbColonne;
            this.hauteurColonne = hauteurColonne;
        } else {
            this.nbColonne = 4;
            this.hauteurColonne = 4;
        }
        
    }

    //Accesseur
	public int getNbColonne() {
		return nbColonne;
	}

	public int getHauteurColonne() {
		return hauteurColonne;
	}

}