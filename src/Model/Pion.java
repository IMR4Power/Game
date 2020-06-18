package Model;

import javafx.scene.paint.Color;

public class Pion {
    private Color color;
    
    //Constructeur
    public Pion(){
        this.color = Color.BLUE;
    }
    public Pion(Color couleur){
        this.color = couleur;
    }
    public Pion(Joueur joueur){
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