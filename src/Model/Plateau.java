package Model;

import java.util.List;
import java.util.ArrayList;

/**
 * Plateau
 */
public class Plateau {
    private int nbColonne;
    private int hauteurColonne;
    private List<Colonne> colonnes;

    /**
     * Constructeur
     */
    public Plateau() {
        this.nbColonne = 7;
        this.hauteurColonne = 6;
        this.colonnes = new ArrayList<Colonne>(nbColonne);
        for (int i = 0; i < nbColonne; i++) {
            colonnes.add(new Colonne(hauteurColonne));
        }
    }

    public Plateau(ParametersPlateau param) {
        this.nbColonne = param.getNbColonne();
        this.hauteurColonne = param.getHauteurColonne();
        this.colonnes = new ArrayList<Colonne>(nbColonne);
        for (int i = 0; i < nbColonne; i++) {
            colonnes.add(new Colonne(hauteurColonne));
        }
    }

    public Plateau(int nbColonne, int hauteurColonne) {
        this.nbColonne = nbColonne;
        this.hauteurColonne = hauteurColonne;
        this.colonnes = new ArrayList<Colonne>(nbColonne);
        for (int i = 0; i < nbColonne; i++) {
            colonnes.add(new Colonne(hauteurColonne));
        }
    }

    // Autres
    public boolean JouerPion(Joueur joueur, int colonneIndex) {
        Pion nouveauPion = new Pion(joueur);
        colonnes.get(colonneIndex).Empile(nouveauPion);
        return verifVictoire(nouveauPion, colonneIndex);
    }

    private boolean verifVictoire(Pion pion, int colonneIndex) {
        int compteurHauteur = 0;
        Colonne colonne = colonnes.get(colonneIndex);
        int indexPion = colonne.getPions().indexOf(pion);
        int indexDepart = indexPion;

        try {
            while (colonne.getPion(indexPion++).getCouleur() == pion.getCouleur()) {
                compteurHauteur++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        indexPion = indexDepart-1;
        try {

            while (colonne.getPion(indexPion--).getCouleur() == pion.getCouleur()) {
                compteurHauteur++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (compteurHauteur >= 4) {
            return true;
        }

        indexPion = indexDepart;
        int compteurLargeur = 0;
        int colonneDepart = colonneIndex;
        try {

            while (colonnes.get(colonneIndex++).getPion(indexPion).getCouleur() == pion.getCouleur()) {
                compteurLargeur++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        colonneIndex = colonneDepart-1;
        // indexPion = colonne.getPions().indexOf(pion);
        try {

            while (colonnes.get(colonneIndex--).getPion(indexPion).getCouleur() == pion.getCouleur()) {
                compteurLargeur++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (compteurLargeur >= 4) {
            return true;
        }


        int compteurDiagGHBD = 0; // diagonnal de en haut à gauche vers en bas à droite
        colonneIndex = colonneDepart;
        indexPion = indexDepart;
        try {
            while (colonnes.get(colonneIndex--).getPion(indexPion++).getCouleur() == pion.getCouleur()) {
                compteurDiagGHBD++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        colonneIndex = colonneDepart+1;
        indexPion = indexDepart-1;
        try {
            while (colonnes.get(colonneIndex++).getPion(indexPion--).getCouleur() == pion.getCouleur()) {
                compteurDiagGHBD++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (compteurDiagGHBD >= 4) {
            return true;
        }

        int compteurDiagDHBG = 0; // diagonnal de en haut à droite vers en bas à gauche
        colonneIndex = colonneDepart;
        indexPion = indexDepart;
        try {
            while (colonnes.get(colonneIndex++).getPion(indexPion++).getCouleur() == pion.getCouleur()) {
                compteurDiagDHBG++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        colonneIndex = colonneDepart-1;
        indexPion = indexDepart+1;
        try {
            while (colonnes.get(colonneIndex--).getPion(indexPion--).getCouleur() == pion.getCouleur()) {
                compteurDiagDHBG++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (compteurDiagDHBG >= 4) {
            return true;
        }

        return false;
    }

	public boolean IsFull() {
        for (Colonne colonne : colonnes) {
            if(colonne.getPions().size() != this.hauteurColonne){
                return false;
            }
        }
		return true;
	}

}