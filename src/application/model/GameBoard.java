package application.model;

import application.model.entities.BoardParameters;
import application.model.entities.Checker;
import application.model.entities.Column;
import application.model.entities.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class representing a game board and its current state
 */
public class GameBoard {
    private final int nbColumns;
    private final int colHeight;
    private final List<Column> columns;

    /**
     * Constructeur
     */
    public GameBoard() {
        this(7, 6);
    }

    /**
     * Creates a new GameBoard with the given parameters
     *
     * @param param GameParameters used for this game board with columns number and rows number
     */
    public GameBoard(BoardParameters param) {
        this(param.getNbCol(), param.getNbRows());
    }

    /**
     * Creates a game board with a given number of columns and rows
     *
     * @param nbColumns The number of columns
     * @param colHeight The number of rows
     */
    public GameBoard(int nbColumns, int colHeight) {
        this.nbColumns = nbColumns;
        this.colHeight = colHeight;

        this.columns = new ArrayList<>(nbColumns);
        for (int i = 0; i < nbColumns; i++) {
            columns.add(new Column(colHeight));
        }
    }

    /**
     * Returns the list of all the columns game board
     *
     * @return The list of all the columns
     */
    public List<Column> getColumns() {
        return columns;
    }


    /**
     * Add a checker for a given user in the given column (according to index)
     * <p>
     * The player is taken to create a checker with the user's color
     *
     * @param player       The player who has played
     * @param colonneIndex The column's index where to put the checker
     * @return Tells if this new checker made the player win or not
     */
    public boolean playChecker(Player player, int colonneIndex) {
        Checker newChecker = new Checker(player);
        columns.get(colonneIndex).push(newChecker);
        return checkVictory(newChecker, colonneIndex);
    }

    /**
     * Resets the game by reseting all the cherckers in all columns
     */
    public void resetGame() {
        for (Column col : columns) {
            col.clear();
        }
    }

    /**
     * Check if placing the given checker in the given column make the game end.
     *
     * @param checker The new checker added
     * @param colIdx  The column's index where the checker is put
     * @return True if this checker makes the player win, else false
     */
    private boolean checkVictory(Checker checker, int colIdx) {
        int heightCounter = 0;
        Column col = columns.get(colIdx);
        int indexChecker = col.getCheckers().indexOf(checker);
        int startIndex = indexChecker;

        try {
            while (col.getChecker(indexChecker++).getColor() == checker.getColor()) {
                heightCounter++;
            }
        } catch (Exception ignored) {

        }

        indexChecker = startIndex - 1;

        try {
            while (col.getChecker(indexChecker--).getColor() == checker.getColor()) {
                heightCounter++;
            }
        } catch (Exception ignored) {

        }

        if (heightCounter >= 4) {
            return true;
        }

        indexChecker = startIndex;
        int widthCounter = 0;
        int startCol = colIdx;

        try {

            while (columns.get(colIdx++).getChecker(indexChecker).getColor() == checker.getColor()) {
                widthCounter++;
            }
        } catch (Exception ignored) {

        }

        colIdx = startCol - 1;
        // indexChecker = colonne.getCheckers().indexOf(pion);
        try {

            while (columns.get(colIdx--).getChecker(indexChecker).getColor() == checker.getColor()) {
                widthCounter++;
            }
        } catch (Exception ignored) {

        }

        if (widthCounter >= 4) {
            return true;
        }


        int diagGHBDCounter = 0; // diagonnal de en haut à gauche vers en bas à droite
        colIdx = startCol;
        indexChecker = startIndex;

        try {
            while (columns.get(colIdx--).getChecker(indexChecker++).getColor() == checker.getColor()) {
                diagGHBDCounter++;
            }
        } catch (Exception ignored) {

        }

        colIdx = startCol + 1;
        indexChecker = startIndex - 1;

        try {
            while (columns.get(colIdx++).getChecker(indexChecker--).getColor() == checker.getColor()) {
                diagGHBDCounter++;
            }
        } catch (Exception ignored) {

        }

        if (diagGHBDCounter >= 4) {
            return true;
        }

        int diagDHBGCounter = 0; // diagonnal de en haut à droite vers en bas à gauche
        colIdx = startCol;
        indexChecker = startIndex;

        try {
            while (columns.get(colIdx++).getChecker(indexChecker++).getColor() == checker.getColor()) {
                diagDHBGCounter++;
            }
        } catch (Exception ignored) {

        }

        colIdx = startCol - 1;
        indexChecker = startIndex - 1;

        try {
            while (columns.get(colIdx--).getChecker(indexChecker--).getColor() == checker.getColor()) {
                diagDHBGCounter++;
            }
        } catch (Exception ignored) {

        }

        return diagDHBGCounter >= 4;
    }

    /**
     * Tells if all the columns og the game board are full or not
     *
     * @return True if they are all full, else false
     */
    public boolean isFull() {
        for (Column col : columns) {
            if (col.getCheckers().size() != this.colHeight) {
                return false;
            }
        }
        return true;
    }
}
