package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enora
 */
public class GameBoard {
    private int nbColumns;
    private int colHeight;
    private List<Columns> columns;

    /**
     * Constructeur
     */
    public GameBoard() {
        this(7, 6);
    }

    public GameBoard(BoardParameters param) {
        this(param.getNbCol(), param.getNbRows());
    }

    public GameBoard(int nbColumns, int colHeight) {
        this.nbColumns = nbColumns;
        this.colHeight = colHeight;

        this.columns = new ArrayList<>(nbColumns);
        for (int i = 0; i < nbColumns; i++) {
            columns.add(new Columns(colHeight));
        }
    }


    public List<Columns> getColumns() {
        return columns;
    }


    // Autres
    public boolean playChecker(Player player, int colonneIndex) {
        Checker newChecker = new Checker(player);
        columns.get(colonneIndex).push(newChecker);
        return checkVictory(newChecker, colonneIndex);
    }

    private boolean checkVictory(Checker checker, int colIdx) {
        int heightCounter = 0;
        Columns col = columns.get(colIdx);
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
        indexChecker = startIndex + 1;

        try {
            while (columns.get(colIdx--).getChecker(indexChecker--).getColor() == checker.getColor()) {
                diagDHBGCounter++;
            }
        } catch (Exception ignored) {

        }

        return diagDHBGCounter >= 4;
    }

    public boolean isFull() {
        for (Columns col : columns) {
            if (col.getCheckers().size() != this.colHeight) {
                return false;
            }
        }
        return true;
    }
}
