package Model;

/**
 * ParametersPlateau
 */
public class ParametersPlateau {

    private int nbColonne;
    private int hauteurColonne;

    /**
     * @param nbColonne
     * @param hauteurColonne
     */
    public ParametersPlateau(int nbColonne, int hauteurColonne) {
        this.nbColonne = nbColonne;
        this.hauteurColonne = hauteurColonne;
    }

	public int getNbColonne() {
		return nbColonne;
	}

	public int getHauteurColonne() {
		return hauteurColonne;
	}


    
    

}