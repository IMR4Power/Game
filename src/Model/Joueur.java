package Model;

import javafx.scene.paint.Color;

public class Joueur {
    private String name;
    private Color color;

    //Constructeur
    public Joueur (String name ,Color color){
        this.name = name;
        this.color = color;
    }

    //Accesseur
    public String getName(){
        return name;
    }

    public Color getColor(){
        return color;
    }

    //Modificateur
    public void setName(String newName){
        name = newName;
    }

    public void setColor(Color newColor){
        color = newColor;
    }

}