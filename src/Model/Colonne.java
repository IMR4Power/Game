package Model;

import java.util.ArrayList;
import java.util.List;

public class Colonne {
    private int hauteur;
    private List<Pion> pions;

    public Colonne() {
        this.hauteur = 6;
        pions = new ArrayList<Pion>(6);
    }

    public Colonne(int hauteur) {
        this.hauteur = hauteur;
        this.pions = new ArrayList<Pion>(hauteur);
    }

    public void Empile(Pion pion) {
        pions.add(pion);
    }

    public void Clean() {
        pions.clear();
    }

    public Pion getPion(int index) {
        if (index >= pions.size()) {
            return null;
        }
        return pions.get(index);
    }

    public List<Pion> getPions(){
        return pions;
    }

    public int getHauteur(){
        return hauteur;
    }
}