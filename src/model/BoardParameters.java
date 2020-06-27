/**
 * 
 */
package model;

/**
 * @author enora
 *
 */
public class BoardParameters {
    private int nbColumns;
    private int nbRow;

    /**
     * Constructeur
     * @param nbColonne
     * @param hauteurColonne
     */
    public BoardParameters(int row, int columns) {
        this.nbColumns = columns;
        this.nbRow = row;
    }

    //Accesseur
	public int getNbColonne() {
		return nbColumns;
	}

	public int getHauteurColonne() {
		return nbRow;
	}
}
