/**
 * 
 */
package Model;

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
    public Joueur (String name ,String color){
        this.name = new SimpleStringProperty(name);
        this.color = Color.AQUA;
    }
    
    public Joueur() {}
    
	//Accesseur
    public StringProperty getName(){
        return name;
    }

    public Color getColor(){
        return color;
    }

    //Modificateur
    public void setName(StringProperty newName){
        name = newName;
    }

    public void setColor(Color newColor){
        color = newColor;
    }

}