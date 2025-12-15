package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurDragon;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modele.Dragon;

public class VueDragon extends Vue {

    protected ControleurDragon controleur;
    protected static VueDragon instance = null;

    public static VueDragon getInstance() {
        if (instance == null) instance = new VueDragon();
        return VueDragon.instance;
    }

    private VueDragon() {
        super("dragon.fxml", VueDragon.class);
        super.controleur = this.controleur = new ControleurDragon();
        Logger.logMsg(Logger.INFO, "new VueDragon()");
    }

    public void activerControles() {
        super.activerControles();
    }

    public void afficherDragons(List<Dragon> dragons) {

        int index = 1;

        for (Dragon dragon : dragons) {

            if (index > 6) break;

            TextField champNom =
                (TextField) lookup("#dragonNomValue" + index);
            TextField champTitre =
                (TextField) lookup("#dragonTitreValue" + index);

           
            if (champNom == null || champTitre == null) {
                index++;
                continue;
            }

            String nom = dragon.getNom();
            String titre = dragon.getTitre();

            champNom.setText(nom);
            champTitre.setText(titre);

            index++;
        }
    }



	public void afficherDragon(Dragon d) {
		// TODO Auto-generated method stub
		
	}
}
