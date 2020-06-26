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

    public void JouerPion(int colonneIndex){
        this.gameBoard.JouerPion(playerList.get(actualPlayer), colonneIndex);
        actualPlayer = actualPlayer++ % playerList.size();
    }

    //Modificateur
    //Dégueu mais elle ne sera pas trop utilisée OU a changer
    public void setActualPlayer(int newActualPlayer){
        actualPlayer = newActualPlayer;
    }
}
