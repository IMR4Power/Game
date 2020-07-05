package application.model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a column
 */
public class Column {
    private final int height;

    /**
     * List of checkers representing the state of the current column
     */
    private final List<Checker> checkers;

    /**
     * Default constructor creating a column with a height of 6
     */
    public Column() {
        this(6);
    }

    /**
     * Creates a Column with a given height
     *
     * @param height The column height
     */
    public Column(int height) {
        this.height = height;
        this.checkers = new ArrayList<>(height);
    }

    /**
     * Returns a checker at <em>index</em> position in the column
     *
     * @param index The index where to pick the checker
     * @return Returns the checker at the given position or null if there is none
     */
    public Checker getChecker(int index) {
        if (index >= checkers.size()) {
            return null;
        }
        return checkers.get(index);
    }

    /**
     * Returns the whole list of checkers
     *
     * @return The list of all the checkers of the column
     */
    public List<Checker> getCheckers() {
        return checkers;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Add a checker in the column.
     *
     * @param checker The checker to add inside the column
     */
    public void push(Checker checker) {
        if (isFull()) {
            return;
        }
        checkers.add(checker);
    }

    /**
     * Tells if a column is full or not
     *
     * @return True if the column is full of checkers, else false
     */
    public boolean isFull() {
        return checkers.size() == height;
    }

    /**
     * Removes all the checkers of the column
     */
    public void clear() {
        checkers.clear();
    }
}
