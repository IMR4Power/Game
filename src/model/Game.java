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
public class Game {
    private GameBoard gameBoard;
    private List<Joueur> playerList;
    private int actualPlayer, nbPlayer;

    //Constructeur
    public Game(GameBoard gameBoard, int actualPlayer, int nbPlayer){
        this.gameBoard = gameBoard;
        this.actualPlayer = actualPlayer;
        this.nbPlayer = nbPlayer;
        this.playerList = new ArrayList<Joueur>(nbPlayer);
    }

    public Game(GameBoard gameBoard, List<Joueur> playerList, int actualPlayer){
        this.gameBoard = gameBoard;
        this.actualPlayer = actualPlayer;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
    }

    public Game(List<Joueur> playerList){
        this.gameBoard = new GameBoard();
        this.actualPlayer = 0;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
    }

    public Game(List<Joueur> playerList, BoardParameters params){
        this.gameBoard = new GameBoard(params);
        this.actualPlayer = 0;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
    }

    //Accesseur
    public GameBoard getGameBoard(){
        return gameBoard;
    }

    public int getActualPlayer(){
        return actualPlayer;
    }

    public int getNbPlayer(){
        return nbPlayer;
    }

    private boolean jouerPion(Joueur j, int colonneIndex) {
        if (this.gameBoard.JouerPion(j, colonneIndex)) {
            System.out.println(playerList.get(actualPlayer).getName() + " a gagné la partie");
            return true;
        } else if (this.gameBoard.IsFull()) {
            System.out.println("Egalité");
            return true;
        }
        return false;
    }

    public boolean JouerPion(int colonneIndex) {
        if(this.gameBoard.getColumns().get(colonneIndex).IsFull());
        if (jouerPion(playerList.get(actualPlayer), colonneIndex)) {
            return true;
        }
        actualPlayer = (actualPlayer + 1) % playerList.size();
        return false;
    }
}
