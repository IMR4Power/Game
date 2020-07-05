package application.model;

import application.model.entities.BoardParameters;
import application.model.entities.Player;

import java.util.List;

/**
 * Class doing the interface between the rest of the model and the controllers
 */
public class Game {
    private final GameBoard gameBoard;
    private final List<Player> playerList;
    private final int nbPlayer;
    private int currentPlayer;
    private Player winner;

    /**
     * Creates a Game with according to BoardParameters
     *
     * @param params The game's parameters with columns number, rows number and player list
     * @see BoardParameters
     */
    public Game(BoardParameters params) {
        this.gameBoard = new GameBoard(params);
        this.currentPlayer = 0;
        this.playerList = params.getPlayers();
        this.nbPlayer = playerList.size();
        this.winner = null;
    }

    /**
     * Returns the underlying GameBoard
     *
     * @return The GameBoard instance used by this Game
     * @see GameBoard
     */
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * Get the current user who has to play
     *
     * @return The player who has to play
     */
    public Player getCurrentPlayer() {
        return playerList.get(currentPlayer);
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    /**
     * Returns the winner. If the game isn't finished or the players have done a draw, returns null
     *
     * @return The player who has won or null if not finished or if there is a draw
     */
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

    /**
     * Reset the current game in order to start another one with the same parameters
     */
    public void resetGame() {
        winner = null;
        gameBoard.resetGame();
    }

    /**
     * Play a checker and tells if the game has ended or not
     *
     * @param j            The player who has played
     * @param colonneIndex The column index where the player placed the checker
     * @return True if the game has ended, else false
     */
    private boolean playChecker(Player j, int colonneIndex) {
        if (this.gameBoard.playChecker(j, colonneIndex)) {
            this.winner = j;
            this.winner.wonAGame();
            return true;
        } else return isADraw();
    }

    /**
     * Play a checker and tells if the game has ended or not
     *
     * @param colonneIndex The index of the column in which the player played its checker
     *
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
