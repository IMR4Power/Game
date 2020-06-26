/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enora
 *
 */
public class Columns {
    private int hauteur;
    private List<Checker> Checkers;

    //Constructeur
    public Columns() {
        this.hauteur = 6;
        Checkers = new ArrayList<Checker>(6);
    }

    public Columns(int hauteur) {
        this.hauteur = hauteur;
        this.Checkers = new ArrayList<Checker>(hauteur);
    }

    //Accesseur
    public Checker getChecker(int index) {
        if (index >= Checkers.size()) {
            return null;
        }
        return Checkers.get(index);
    }

    public List<Checker> getCheckers(){
        return Checkers;
    }

    public int getHauteur(){
        return hauteur;
    }

    //Autres
    public void Empile(Checker Checker) {
        Checkers.add(Checker);
    }

    public void Clean() {
        Checkers.clear();
    }
}
