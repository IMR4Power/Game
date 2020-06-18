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
     * 
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

    

    
}