package Model;

import javafx.scene.paint.Color;

public class Pion {
    private Color couleur;
    
    //Constructeur
    public Pion(){
        this.couleur = Color.BLUE;
    }
    public Pion(Color couleur){
        this.couleur = couleur;
    }
    public Pion(Joueur joueur){
        this.couleur = joueur.getColor();
    }

    //Assesseurs
    /**
     * @return the color
     */
    public Color getCouleur() {
        return couleur;
    }

}