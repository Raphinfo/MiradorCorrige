package controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import architecture.Controleur;
import modele.Dragon;
import vue.VueDragon;

public class ControleurDragon extends Controleur {

    private static final Logger LOG = Logger.getLogger(ControleurDragon.class.getName());

    public ControleurDragon() {
        LOG.info("new ControleurDragon()");
    }

    @Override
    public void initialiser() {

        
        List<Dragon> dragons = new ArrayList<Dragon>();

        Dragon d1 = new Dragon("DRG-001", "Azhdaha", "Seigneur des Cieux", "Dragon ancestral...");
        Dragon d2 = new Dragon("DRG-002", "Fafnir", "Malédiction d'Or", "Dragon cupide...");
        Dragon d3 = new Dragon("DRG-003", "Smaug", "Terreur d'Erebor", "Gardien du trésor...");
        Dragon d4 = new Dragon("DRG-004", "Saphira", "Compagne", "Dragon lié au cavalier...");
        Dragon d5 = new Dragon("DRG-005", "Shenlong", "Vœu Céleste", "Dragon divin...");
        Dragon d6 = new Dragon("DRG-006", "Toothless", "Furie Nocturne", "Rapide et rare...");

        dragons.add(d1);
        dragons.add(d2);
        dragons.add(d3);
        dragons.add(d4);
        dragons.add(d5);
        dragons.add(d6);

        
        //for (Dragon dragon : dragons) {
            //LOG.info("Dragon : " + dragon.getNom());
            //LOG.info("Dragon : " + dragon.getTitre());
        //}

       
        VueDragon.getInstance().afficherDragons(dragons);
    }
}
