package controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import architecture.Controleur;
import modele.Emploi;
import vue.VueEmploi;


public class ControleurEmploi extends Controleur {

    private static final Logger LOG = Logger.getLogger(ControleurEmploi.class.getName());

    public ControleurEmploi() {
        LOG.info("new ControleurEmplois()");
    }

    @Override
    public void initialiser() {

        Emploi e1 = new Emploi("EMP-001",
                "Développeur Java Junior",
                "Fil-Vert Technologies",
                "https://fil-vert.com/jobs/1",
                "filvert-logo.png");

        Emploi e2 = new Emploi("EMP-002",
                "Admin Systèmes Linux",
                "Mirador Cloud",
                "https://mirador.com/jobs/2",
                "mirador-logo.png");

        Emploi e3 = new Emploi("EMP-003",
                "Analyste Sécurité",
                "CyberSentinelle",
                "https://cybersentinelle.com/jobs/3",
                "cyber-logo.png");

        List<Emploi> emplois = new ArrayList<>();
        emplois.add(e1);
        emplois.add(e2);
        emplois.add(e3);

        VueEmploi.getInstance().afficherEmplois(emplois);
    }
}
