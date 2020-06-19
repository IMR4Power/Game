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
        if(nbColonne < 4) nbColonne = 4;
        if(hauteurColonne < 4) hauteurColonne = 4;
        this.nbColonne = nbColonne;
        this.hauteurColonne = hauteurColonne;        
    }

    //Accesseur
	public int getNbColonne() {
		return nbColonne;
	}

	public int getHauteurColonne() {
		return hauteurColonne;
	}

}