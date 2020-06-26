/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enora
 *
 */
public class GameBoard {
	private int nbColonne;
    private int hauteurColonne;
    private List<Columns> colonnes;

    /**
     * Constructeur
     */
    public GameBoard() {
        this.nbColonne = 7;
        this.hauteurColonne = 6;
        this.colonnes = new ArrayList<Columns>(nbColonne);
        for (int i = 0; i < nbColonne; i++) {
            colonnes.add(new Columns(hauteurColonne));
        }
    }

    public GameBoard(BoardParameters param) {
        this.nbColonne = param.getNbColonne();
        this.hauteurColonne = param.getHauteurColonne();
        this.colonnes = new ArrayList<Columns>(nbColonne);
        for (int i = 0; i < nbColonne; i++) {
            colonnes.add(new Columns(hauteurColonne));
        }
    }

    public GameBoard(int nbColonne, int hauteurColonne) {
        this.nbColonne = nbColonne;
        this.hauteurColonne = hauteurColonne;
        this.colonnes = new ArrayList<Columns>(nbColonne);
        for (int i = 0; i < nbColonne; i++) {
            colonnes.add(new Columns(hauteurColonne));
        }
    }

    //Autres
    public void JouerPion(Joueur joueur, int colonneIndex) {
        Checker nouveauPion = new Checker(joueur);
        colonnes.get(colonneIndex).Empile(nouveauPion);
        VerifVictoire(nouveauPion, colonneIndex);
    }

    public boolean VerifVictoire(Checker pion, int colonneIndex) {
        int compteurHauteur = 1;
        Columns colonne = colonnes.get(colonneIndex);
        int indexPion = colonne.getCheckers().indexOf(pion);

        while (colonne.getChecker(indexPion++).getColor() == pion.getColor()) {
            compteurHauteur++;
        }
        indexPion = colonne.getCheckers().indexOf(pion);
        while (colonne.getChecker(indexPion--).getColor() == pion.getColor()) {
            compteurHauteur++;
        }
        if(compteurHauteur >= 4){
            return true;
        }
        return false;
    }
}
