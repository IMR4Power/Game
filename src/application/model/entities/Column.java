package application.model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enora
 */
public class Column {
    private int height;
    private List<Checker> checkers;

    // Constructeur
    public Column() {
        this(6);
    }

    public Column(int height) {
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

    public void clear() {
        checkers.clear();
    }
}
