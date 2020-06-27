/**
 * 
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;	

/**
 * @author enora
 *
 */
public class Joueur {
    private StringProperty name;
    private Color color;

    //Constructeur
    public Joueur (String name ,Color color){
        this.name = new SimpleStringProperty(name);
        this.color = color;
    }
    
    public Joueur() {}
    
	//Accesseur
    public String getName(){
        return name.getValue();
    }

    public StringProperty getNameProperty(){
        return name;
    }

    public Color getColor(){
        return color;
    }

    //Modificateur
    public void setName(String newName){
        name.setValue(newName);
    }

    public void setColor(Color newColor){
        color = newColor;
    }

}