package Model;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private Plateau gameBoard;
    private ArrayList<Joueur> playerList;
    private int actualPlayer, nbPlayer;

    //Constructeur
    public Partie(Plateau gameBoard, int actualPlayer, int nbPlayer){
        this.gameBoard = gameBoard;
        this.actualPlayer = actualPlayer;
        this.nbPlayer = nbPlayer;
        this.playerList = new ArrayList<Joueur>(nbPlayer);
    }

    public Partie(Plateau gameBoard, ArrayList<Joueur> playerList, int actualPlayer){
        this.gameBoard = gameBoard;
        this.actualPlayer = actualPlayer;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
    }

    //Accesseur
    public Plateau getGameBoard(){
        return gameBoard;
    }

    public int getActualPlayer(){
        return actualPlayer;
    }

    public int getNbPlayer(){
        return nbPlayer;
    }

    //Modificateur
    //Dégueu mais elle ne sera pas trop utilisée OU a changer
    private void setActualPlayer(int newActualPlayer){
        actualPlayer = newActualPlayer;
    }
}