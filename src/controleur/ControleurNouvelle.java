package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import data.NouvelleDAO;
import modele.Nouvelle;
import vue.VueNouvelle;

    public class ControleurNouvelle extends Controleur {

    public ControleurNouvelle() {
        Logger.logMsg(Logger.INFO, "new ControleurNouvelle()");
    }
    protected NouvelleDAO dao = new NouvelleDAO();
    
    public void initialiser() {

        Nouvelle nouvelle1 = new Nouvelle("Réseau", "Cisco", "VLAN", "HSRP");
        Nouvelle nouvelle2 = new Nouvelle("JavaFX", "FXML", "MVC", "DAO");
        Nouvelle nouvelle3 = new Nouvelle("Web", "API", "JSON", "Gson");
        Nouvelle nouvelle4 = new Nouvelle("Archives retrouvées", "A. Dorion", "EP-02", "2025-12-14");
        Nouvelle nouvelle5 = new Nouvelle("Éclipse sur Mirador", "", "EP-01", "2025-12-15");
        Nouvelle nouvelle6 = new Nouvelle("Signal dans la brume", "N. Sagan", "EP-03", "2025-12-13");
       

        List<Nouvelle> nouvelles = new ArrayList<>();
        nouvelles.add(nouvelle1);
        nouvelles.add(nouvelle2);
        nouvelles.add(nouvelle3);
        nouvelles.add(nouvelle4);
        nouvelles.add(nouvelle5);
        nouvelles.add(nouvelle6);

        VueNouvelle.getInstance().afficherNouvelles(nouvelles);
    }
}
