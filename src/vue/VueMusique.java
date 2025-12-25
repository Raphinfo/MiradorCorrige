package vue;

import java.util.List;

import architecture.Vue;
import controleur.ControleurMusique;
import javafx.scene.control.TextField;
import modele.Musique;

public class VueMusique extends Vue {

    protected ControleurMusique controleur;
    protected static VueMusique instance = null;

    public static VueMusique getInstance() {
        if (instance == null) instance = new VueMusique();
        return instance;
    }

    private VueMusique() {
        super("musique.fxml", VueMusique.class);
        super.controleur = this.controleur = new ControleurMusique();
    }

    @Override
    public void activerControles() {
        super.activerControles();
    }

    public void afficherMusiques(List<Musique> musiques) {
        int index = 1;

        for (Musique m : musiques) {
            if (index > 3) break;

            TextField champName    = (TextField) lookup("#musiqueNameValue" + index);
            TextField champType    = (TextField) lookup("#musiqueTypeValue" + index);
            TextField champCountry = (TextField) lookup("#musiqueCountryValue" + index);

            if (champName != null)    champName.setText(m.getName());
            if (champType != null)    champType.setText(m.getType());
            if (champCountry != null) champCountry.setText(m.getCountry());

            index++;
        }
    }
}