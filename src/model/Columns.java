package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enora
 *
 */
public class Columns {
    private int height;
    private List<Checker> checkers;

    // Constructeur
    public Columns() {
        this(6);
    }

    public Columns(int height) {
        this.height = height;
        this.checkers = new ArrayList<>(height);
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

    public int getHeight() {
        return height;
    }

    // Autres
    public void push(Checker checker) {
        if (isFull()) {
            return;
        }
        checkers.add(checker);
    }

    public boolean isFull() {
        return checkers.size() == height;
    }

    public void Clean() {
        checkers.clear();
    }
}
