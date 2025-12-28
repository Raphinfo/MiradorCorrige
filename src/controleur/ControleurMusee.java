package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.Musee;
import vue.VueMusee;

public class ControleurMusee extends Controleur {

    public ControleurMusee() {
        Logger.logMsg(Logger.INFO, "new ControleurMusee()");
    }

    @Override
    public void initialiser() {

        Musee musee1 = new Musee("Musée du Canada", "Créé en 1856", "Musée canadien des beaux-arts");
        Musee musee2 = new Musee("Musée des États-Unis", "Créé en 1846", "Smithsonian Institution");
        Musee musee3 = new Musee("Musée du Mexique", "Créé en 1825", "Museo Nacional de Antropología");

        List<Musee> musees = new ArrayList<>();
        musees.add(musee1);
        musees.add(musee2);
        musees.add(musee3);

        VueMusee.getInstance().afficherMusees(musees);
    }
}
