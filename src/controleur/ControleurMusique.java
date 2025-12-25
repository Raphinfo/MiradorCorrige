package controleur;

import java.util.ArrayList;
import java.util.List;

import architecture.Controleur;
import modele.Musique;
import vue.VueMusique;

public class ControleurMusique extends Controleur {

    @Override
    public void initialiser() {
        List<Musique> musiques = new ArrayList<>();
        musiques.add(new Musique("M-001", "Starlight", "Synthwave", "Canada"));
        musiques.add(new Musique("M-002", "Nocturne", "Classique", "France"));
        musiques.add(new Musique("M-003", "Pulse", "EDM", "USA"));
        VueMusique.getInstance().afficherMusiques(musiques);
    }
}