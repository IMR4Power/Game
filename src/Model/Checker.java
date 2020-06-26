/**
 * 
 */
package Model;

import javafx.scene.paint.Color;

/**
 * @author enora
 *
 */
public class Checker {
    private Color color;
    
    //Constructeur
    public Checker(){
        this.color = Color.BLUE;
    }
    public Checker(Color couleur){
        this.color = couleur;
    }
    public Checker(Joueur joueur){
        this.color = joueur.getColor();
    }

    //Assesseurs
    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
}
