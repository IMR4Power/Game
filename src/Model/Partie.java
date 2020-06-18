package Model;

import java.util.ArrayList;

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

    public Partie(ArrayList<Joueur> playerList){
        this.gameBoard = new Plateau();
        this.actualPlayer = 0;
        this.nbPlayer = playerList.size();
        this.playerList = playerList;
    }

    public Partie(ArrayList<Joueur> playerList, ParametersPlateau params){
        this.gameBoard = new Plateau(params);
        this.actualPlayer = 0;
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