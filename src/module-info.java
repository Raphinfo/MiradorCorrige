/*package vue;

import java.util.logging.Logger;

import architecture.Vue;
import controleur.ControleurDragon;
import javafx.scene.control.Label;
import modele.Dragon;
import modele.Info;

public class VueDragon extends Vue {

    private static final Logger LOG = Logger.getLogger(VueDragon.class.getName());

    private static VueDragon instance;
    public static VueDragon getInstance() {
        if (instance == null) instance = new VueDragon();
        return instance;
    }

    private VueDragon() {
       
        super("dragon.fxml", VueDragon.class);
        LOG.info("new VueDragon()");
        super.controleur = new ControleurDragon();
    }

    public void afficherDragon(Dragon dragon) {
        // Titre de page
        ((Label) lookup("#dragonPageTitle")).setText("Fiche Dragon");

        // Champs principaux
        ((Label) lookup("#dragonIdValue")).setText(dragon.getId());
        ((Label) lookup("#dragonNomValue")).setText(dragon.getNom());
        ((Label) lookup("#dragonTitreValue")).setText(dragon.getTitre());
        ((Label) lookup("#dragonDescriptionValue")).setText(dragon.getDescription());

        
        Info info = dragon.getInfo();
        if (info != null) {
            ((Label) lookup("#dragonInfoElementValue")).setText(info.getElement());
            ((Label) lookup("#dragonInfoNiveauValue")).setText(String.valueOf(info.getNiveau()));
            ((Label) lookup("#dragonInfoRareteValue")).setText(info.getRarete());
        }
    }
}*/
