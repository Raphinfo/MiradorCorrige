package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import data.NouvelleDAO;
import modele.Nouvelle;

public class ControleurNouvelle extends Controleur {
	public ControleurNouvelle()
	{
		Logger.logMsg(Logger.INFO, "new ControleurNouvelles()");
	}

    protected NouvelleDAO dao = new NouvelleDAO();

	
		public void initialiser()
		{
		Nouvelle nouvelle1 = new Nouvelle("Programeur", "Développeur", "Administrateur", "Technicien");
		Nouvelle nouvelle2 = new Nouvelle("Professeur", "Commercial");
		Nouvelle nouvelle3= new Nouvelle("Préposé", "service social");
		
	
		

   List<Nouvelle> nouvellesNouvelle = new ArrayList<>();

nouvellesNouvelle.add(nouvelle1);
nouvellesNouvelle.add(nouvelle2);
nouvellesNouvelle.add(nouvelle3);
		
	}
}

