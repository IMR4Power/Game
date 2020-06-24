package Model;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private Plateau plateau;
    private List<Joueur> ListJoueurs;
    private int joueurActuel, nbJoueurs;

    // Constructeur
    public Partie(Plateau plateau, int joueurActuel, int nbJoueurs) {
        this.plateau = plateau;
        this.joueurActuel = joueurActuel;
        this.nbJoueurs = nbJoueurs;
        this.ListJoueurs = new ArrayList<Joueur>(nbJoueurs);
    }

    public Partie(Plateau plateau, ArrayList<Joueur> ListJoueurs, int joueurActuel) {
        this.plateau = plateau;
        this.joueurActuel = joueurActuel;
        this.nbJoueurs = ListJoueurs.size();
        this.ListJoueurs = ListJoueurs;
    }

    public Partie(List<Joueur> ListJoueurs) {
        this.plateau = new Plateau();
        this.joueurActuel = 0;
        this.nbJoueurs = ListJoueurs.size();
        this.ListJoueurs = ListJoueurs;
        System.out.println("Commencer une nouvelle partie avec " + nbJoueurs + " joueurs");
    }

    public Partie(List<Joueur> ListJoueurs, ParametersPlateau params) {
        this.plateau = new Plateau(params);
        this.joueurActuel = 0;
        this.nbJoueurs = ListJoueurs.size();
        this.ListJoueurs = ListJoueurs;
    }

    // Accesseur
    public Plateau getplateau() {
        return plateau;
    }

    public int getjoueurActuel() {
        return joueurActuel;
    }

    public int getnbJoueurs() {
        return nbJoueurs;
    }

    public boolean JouerPion(Joueur j, int colonneIndex) {
        if (this.plateau.JouerPion(j, colonneIndex)) {
            System.out.println(ListJoueurs.get(joueurActuel).getName() + " a gagné la partie");
            return true;
        } else if (this.plateau.IsFull()) {
            System.out.println("Egalité");
            return true;
        }
        return false;
    }

    public boolean JouerPion(int colonneIndex) {
        if (JouerPion(ListJoueurs.get(joueurActuel), colonneIndex)) {
            return true;
        }
        joueurActuel = (joueurActuel + 1) % ListJoueurs.size();
        return false;
    }
}