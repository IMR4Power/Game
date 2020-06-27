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
public class Columns {
    private int hauteur;
    private List<Checker> checkers;

    // Constructeur
    public Columns() {
        this.hauteur = 6;
        checkers = new ArrayList<Checker>(6);
    }

    public Columns(int hauteur) {
        this.hauteur = hauteur;
        this.checkers = new ArrayList<Checker>(hauteur);
    }

    // Accesseur
    public Checker getChecker(int index) {
        if (index >= checkers.size()) {
            return null;
        }
        return checkers.get(index);
    }

    public List<Checker> getCheckers() {
        return checkers;
    }

    public int getHauteur() {
        return hauteur;
    }

    // Autres
    public void Empile(Checker checker) {
        if (IsFull()) {
            return;
        }
        checkers.add(checker);
    }

    public boolean IsFull(){
        if(checkers.size() == hauteur) return true;
        else return false;
    }

    public void Clean() {
        checkers.clear();
    }
}
