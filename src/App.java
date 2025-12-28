
//import java.util.List;

import architecture.Controleur;
import data.DragonDAO;
import data.EmploiDAO;
import data.MuseeDAO;
import data.NouvelleDAO;
import architecture.Fenetre;
import vue.VueEmploi;
import vue.VueMusee;
import vue.VueMusique;
import vue.VueNouvelle;
import vue.VueDragon;



public class App {

	public static void main(String[] parametres) {
		
		
		
		DragonDAO dragondao = new DragonDAO();
		dragondao.listerDragons();
		EmploiDAO emploidao = new EmploiDAO();
		emploidao.listerEmplois();
		NouvelleDAO nouvelledao = new NouvelleDAO();
		nouvelledao.listerNouvelles();
		MuseeDAO museedao = new MuseeDAO();
		museedao.listerMusees();
		
		
		
		
	 
	    //Controleur.choisirVuePrincipale(VueEmploi.class);
		//Controleur.choisirVuePrincipale(VueDragon.class);
		//Controleur.choisirVuePrincipale(VueMusique.class);
		Controleur.choisirVuePrincipale(VueMusee.class);
		//Controleur.choisirVuePrincipale(VueNouvelle.class);
		Fenetre.launch(Fenetre.class, parametres);	
	}
}


