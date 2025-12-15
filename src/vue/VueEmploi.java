package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurEmploi;
import javafx.scene.control.TextField;
import modele.Emploi;

public class VueEmploi extends Vue {

    protected ControleurEmploi controleur;
    protected static VueEmploi instance = null;

    public static VueEmploi getInstance() {
        if (instance == null) instance = new VueEmploi();
        return instance;
    }

    private VueEmploi() {
        super("emploi.fxml", VueEmploi.class); 
        super.controleur = this.controleur = new ControleurEmploi();
        Logger.logMsg(Logger.INFO, "new VueEmploi()");
    }

    public void activerControles() {
        super.activerControles();
    }

    public void afficherEmplois(List<Emploi> emplois) {

        int index = 1;

        for (Emploi emploi : emplois) {

            if (index > 3) break;

            
            TextField champTitre = (TextField) lookup("#emploiTitreValue" + index);
            TextField champEntreprise = (TextField) lookup("#emploiEntrepriseValue" + index);

            if (champTitre == null || champEntreprise == null) {
                index++;
                continue;
            }

           
            String titre = emploi.getTitre();
            String entreprise = emploi.getEntreprise();

            
            champTitre.setText(titre);
            champEntreprise.setText(entreprise);

            index++;
        }
    }
}
