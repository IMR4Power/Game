package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enora
 */
public class Game {
    private GameBoard gameBoard;
    private List<Player> playerList;
    private int currentPlayer, nbPlayer;

    //Constructeur
    public Game(GameBoard gameBoard, int currentPlayer, int nbPlayer) {
        this.gameBoard = gameBoard;
        this.currentPlayer = currentPlayer;
        this.nbPlayer = nbPlayer;
        this.playerList = new ArrayList<>(nbPlayer);
    }

    public Game(GameBoard gameBoard, List<Player> playerList, int currentPlayer) {
        this.gameBoard = gameBoard;
        this.currentPlayer = currentPlayer;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
    }

    public Game(List<Player> playerList) {
        this.gameBoard = new GameBoard();
        this.currentPlayer = 0;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
    }

    public Game(List<Player> playerList, BoardParameters params) {
        this.gameBoard = new GameBoard(params);
        this.currentPlayer = 0;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
    }

    //Accesseur
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    private boolean playChecker(Player j, int colonneIndex) {
        if (this.gameBoard.playChecker(j, colonneIndex)) {
            System.out.println(playerList.get(currentPlayer).getName() + " a gagné la partie");
            return true;
        } else if (this.gameBoard.isFull()) {
            System.out.println("Egalité");
            return true;
        }
        return false;
    }

    public boolean playChecker(int colonneIndex) {
        if (playChecker(playerList.get(currentPlayer), colonneIndex)) {
            return true;
        }
        currentPlayer = (currentPlayer + 1) % playerList.size();
        return false;
    }
}
