/**
 * 
 */
package model;

/**
 * @author enora
 *
 */
public class BoardParameters {
    private int nbColonne;
    private int hauteurColonne;

    /**
     * Constructeur
     * @param nbColonne
     * @param hauteurColonne
     */
    public BoardParameters(int nbColonne, int hauteurColonne) {
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
