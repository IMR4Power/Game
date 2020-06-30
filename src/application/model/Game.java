package application.model;

import application.model.entities.BoardParameters;
import application.model.entities.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enora
 */
public class Game {
    private GameBoard gameBoard;
    private List<Player> playerList;
    private int currentPlayer, nbPlayer;
    private Player winner;

    //Constructeur
    public Game(GameBoard gameBoard, int currentPlayer, int nbPlayer) {
        this.gameBoard = gameBoard;
        this.currentPlayer = currentPlayer;
        this.nbPlayer = nbPlayer;
        this.playerList = new ArrayList<>(nbPlayer);
        this.winner = null;
    }

    public Game(GameBoard gameBoard, List<Player> playerList, int currentPlayer) {
        this.gameBoard = gameBoard;
        this.currentPlayer = currentPlayer;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
        this.winner = null;
    }

    public Game(List<Player> playerList) {
        this.gameBoard = new GameBoard();
        this.currentPlayer = 0;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
        this.winner = null;
    }

    public Game(List<Player> playerList, BoardParameters params) {
        this.gameBoard = new GameBoard(params);
        this.currentPlayer = 0;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
        this.winner = null;
    }

    //Accesseur
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Player getCurrentPlayer() {
        return playerList.get(currentPlayer);
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public Player getWinner() {
        return this.winner;
    }

    /**
     * Tells if there is a draw between the players
     *
     * @return True if there is a draw, else false
     */
    public boolean isADraw() {
        return this.gameBoard.isFull();
    }

    public void resetGame() {
        gameBoard.resetGame();
    }

    private boolean playChecker(Player j, int colonneIndex) {
        if (this.gameBoard.playChecker(j, colonneIndex)) {
            this.winner = playerList.get(currentPlayer);
            return true;
        } else return isADraw();
    }

    /**
     * Play a checker and tells if the game has ended or not
     *
     * @param colonneIndex The index of the column in which the player played its checker
     * @return True if the game has ended, else false
     */
    public boolean playChecker(int colonneIndex) {
        if (playChecker(playerList.get(currentPlayer), colonneIndex)) {
            return true;
        }
        currentPlayer = (currentPlayer + 1) % playerList.size();
        return false;
    }
}
