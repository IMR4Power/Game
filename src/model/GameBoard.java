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


	public List<Columns> getColumns() {
		return colonnes;
	}

    
    // Autres
    public boolean JouerPion(Joueur joueur, int colonneIndex) {
        Checker nouveauPion = new Checker(joueur);
        colonnes.get(colonneIndex).Empile(nouveauPion);
        return verifVictoire(nouveauPion, colonneIndex);
    }

    private boolean verifVictoire(Checker checker, int colonneIndex) {
        int compteurHauteur = 0;
        Columns colonne = colonnes.get(colonneIndex);
        int indexChecker = colonne.getCheckers().indexOf(checker);
        int indexDepart = indexChecker;

        try {
            while (colonne.getChecker(indexChecker++).getColor() == checker.getColor()) {
                compteurHauteur++;
            }
        } catch (Exception e) {
            
        }
        indexChecker = indexDepart-1;
        try {

            while (colonne.getChecker(indexChecker--).getColor() == checker.getColor()) {
                compteurHauteur++;
            }
        } catch (Exception e) {
            
        }
        if (compteurHauteur >= 4) {
            return true;
        }

        indexChecker = indexDepart;
        int compteurLargeur = 0;
        int colonneDepart = colonneIndex;
        try {

            while (colonnes.get(colonneIndex++).getChecker(indexChecker).getColor() == checker.getColor()) {
                compteurLargeur++;
            }
        } catch (Exception e) {
            
        }
        colonneIndex = colonneDepart-1;
        // indexChecker = colonne.getCheckers().indexOf(pion);
        try {

            while (colonnes.get(colonneIndex--).getChecker(indexChecker).getColor() == checker.getColor()) {
                compteurLargeur++;
            }
        } catch (Exception e) {
            
        }
        if (compteurLargeur >= 4) {
            return true;
        }


        int compteurDiagGHBD = 0; // diagonnal de en haut à gauche vers en bas à droite
        colonneIndex = colonneDepart;
        indexChecker = indexDepart;
        try {
            while (colonnes.get(colonneIndex--).getChecker(indexChecker++).getColor() == checker.getColor()) {
                compteurDiagGHBD++;
            }
        } catch (Exception e) {
            
        }
        colonneIndex = colonneDepart+1;
        indexChecker = indexDepart-1;
        try {
            while (colonnes.get(colonneIndex++).getChecker(indexChecker--).getColor() == checker.getColor()) {
                compteurDiagGHBD++;
            }
        } catch (Exception e) {
            
        }
        if (compteurDiagGHBD >= 4) {
            return true;
        }

        int compteurDiagDHBG = 0; // diagonnal de en haut à droite vers en bas à gauche
        colonneIndex = colonneDepart;
        indexChecker = indexDepart;
        try {
            while (colonnes.get(colonneIndex++).getChecker(indexChecker++).getColor() == checker.getColor()) {
                compteurDiagDHBG++;
            }
        } catch (Exception e) {
            
        }
        colonneIndex = colonneDepart-1;
        indexChecker = indexDepart+1;
        try {
            while (colonnes.get(colonneIndex--).getChecker(indexChecker--).getColor() == checker.getColor()) {
                compteurDiagDHBG++;
            }
        } catch (Exception e) {
            
        }
        if (compteurDiagDHBG >= 4) {
            return true;
        }

        return false;
    }

	public boolean IsFull() {
        for (Columns colonne : colonnes) {
            if(colonne.getCheckers().size() != this.hauteurColonne){
                return false;
            }
        }
		return true;
	}
}
