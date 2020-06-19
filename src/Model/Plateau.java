package Model;

import java.util.List;
import java.util.ArrayList;

/**
 * Plateau
 * ATTENTION
 * Le plateau doit avoir une taille minimale de 4x4 pour qu'il y ai un victoire
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
        if (nbColonne >= 4 || hauteurColonne >= 4) {
            this.nbColonne = nbColonne;
            this.hauteurColonne = hauteurColonne;
        } else {
            this.nbColonne = 4;
            this.hauteurColonne = 4;
        }
        this.colonnes = new ArrayList<Colonne>(nbColonne);
        for (int i = 0; i < nbColonne; i++) {
            colonnes.add(new Colonne(hauteurColonne));
        }
    }

    //Autres
    public void JouerPion(Joueur joueur, int colonneIndex) {
        Pion nouveauPion = new Pion(joueur);
        colonnes.get(colonneIndex).Empile(nouveauPion);
        VerifVictoire(nouveauPion, colonneIndex);
    }

    public boolean VerifVictoire(Pion pion, int colonneIndex) {
        int compteurHauteur = 1;
        Colonne colonne = colonnes.get(colonneIndex);
        int indexPion = colonne.getPions().indexOf(pion);

        while (colonne.getPion(indexPion++).getColor() == pion.getColor()) {
            compteurHauteur++;
        }
        indexPion = colonne.getPions().indexOf(pion);
        while (colonne.getPion(indexPion--).getColor() == pion.getColor()) {
            compteurHauteur++;
        }
        if(compteurHauteur >= 4){
            return true;
        }
        return false;
    }

}