package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enora
 *
 */
public class Game {
    private GameBoard gameBoard;
    private List<Player> playerList;
    private int actualPlayer, nbPlayer;

    //Constructeur
    public Game(GameBoard gameBoard, int actualPlayer, int nbPlayer){
        this.gameBoard = gameBoard;
        this.actualPlayer = actualPlayer;
        this.nbPlayer = nbPlayer;
        this.playerList = new ArrayList<>(nbPlayer);
    }

    public Game(GameBoard gameBoard, List<Player> playerList, int actualPlayer) {
        this.gameBoard = gameBoard;
        this.actualPlayer = actualPlayer;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
    }

    public Game(List<Player> playerList) {
        this.gameBoard = new GameBoard();
        this.actualPlayer = 0;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
    }

    public Game(List<Player> playerList, BoardParameters params) {
        this.gameBoard = new GameBoard(params);
        this.actualPlayer = 0;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
    }

    //Accesseur
    public GameBoard getGameBoard(){
        return gameBoard;
    }

    public int getActualPlayer() {
        return actualPlayer;
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    private boolean playChecker(Player j, int colonneIndex) {
        if (this.gameBoard.playChecker(j, colonneIndex)) {
            System.out.println(playerList.get(actualPlayer).getName() + " a gagné la partie");
            return true;
        } else if (this.gameBoard.isFull()) {
            System.out.println("Egalité");
            return true;
        }
        return false;
    }

    public boolean playChecker(int colonneIndex) {
        if (playChecker(playerList.get(actualPlayer), colonneIndex)) {
            return true;
        }
        actualPlayer = (actualPlayer + 1) % playerList.size();
        return false;
    }
}
