package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.Musee;
import vue.VueMusee;

public class ControleurMusee extends Controleur {

	public ControleurMusee()
	{
		Logger.logMsg(Logger.INFO, "new ControleurNouvelles()");
	}
	   public void initialiser() {
	        List<Musee> musees = chargerMusees();
	        
	        VueMusee.getInstance().afficherMusees(musees);
	    }
	    private List<Musee> chargerMusees() {
	        List<Musee> musees = new ArrayList<>();

	        musees.add(new Musee("Musée canadien des beaux-arts"));
	        musees.add(new Musee("Smithsonian Institution"));
	        musees.add(new Musee("Museo Nacional de Antropología"));

	        return musees;
	    }
	}
