package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;	

/**
 * @author enora
 *
 */
public class Joueur {
    private StringProperty name;
    private ObjectProperty<Color> color;

    //Constructeur
    public Joueur(String name, Color color) {
        this.name = new SimpleStringProperty(name);
        this.color = new SimpleObjectProperty<>(color);
    }
    
    public Joueur() {}
    
	//Accesseur
    public String getName(){
        return name.getValue();
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public ObjectProperty<Color> getColorProperty() {
        return color;
    }

    public Color getColor() {
        return color.getValue();
    }

    //Modificateur
    public void setName(String newName) {
        name.setValue(newName);
    }

    public void setColor(Color newColor) {
        color.setValue(newColor);
    }

}