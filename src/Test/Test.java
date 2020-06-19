package Test;

import java.util.ArrayList;
import java.util.List;

import Model.*;
import javafx.scene.paint.Color;

public class Test {
    public static void main(String[] args) {
        Joueur j1 = new Joueur("Kevin", Color.RED);
        Joueur j2 = new Joueur("Dorian", Color.YELLOW);

        List<Joueur> listJoueurs = new ArrayList<Joueur>(2);
        listJoueurs.add(j1);
        listJoueurs.add(j2);

        Partie p1 = new Partie(listJoueurs); //partie victoire horizontale
        p1.JouerPion(1);
        p1.JouerPion(1);
        p1.JouerPion(2);
        p1.JouerPion(2);
        p1.JouerPion(3);
        p1.JouerPion(3);
        p1.JouerPion(4);

        Partie p2 = new Partie(listJoueurs); //partie victoire verticale
        p2.JouerPion(1);
        p2.JouerPion(2);
        p2.JouerPion(1);
        p2.JouerPion(2);
        p2.JouerPion(1);
        p2.JouerPion(2);
        p2.JouerPion(1);

        Partie p3 = new Partie(listJoueurs); //partie victoire diag /
        p3.JouerPion(1); //K
        p3.JouerPion(2); //D
        p3.JouerPion(2); //K
        p3.JouerPion(3); //D
        p3.JouerPion(3); //K
        p3.JouerPion(4); //D
        p3.JouerPion(3); //K
        p3.JouerPion(6); //D
        p3.JouerPion(4); //K
        p3.JouerPion(4); //D
        p3.JouerPion(4); //K


        Partie p4 = new Partie(listJoueurs); //partie victoire diag \
        p4.JouerPion(4); //K
        p4.JouerPion(3); //D
        p4.JouerPion(3); //K
        p4.JouerPion(2); //D
        p4.JouerPion(2); //K
        p4.JouerPion(1); //D
        p4.JouerPion(2); //K
        p4.JouerPion(6); //D
        p4.JouerPion(1); //K
        p4.JouerPion(1); //D
        p4.JouerPion(1); //K

    }
}