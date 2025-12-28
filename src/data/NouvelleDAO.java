package data;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import modele.Nouvelle;

public class NouvelleDAO {

    
    private static final String URL_NOUVELLES =
            "https://cdn.animenewsnetwork.com/encyclopedia/api.xml?title=4658";

    public List<Nouvelle> listerNouvelles() {

        List<Nouvelle> nouvelles = new ArrayList<>();

        try {
            String xml = telechargerXML(URL_NOUVELLES);
            if (xml.isBlank()) return nouvelles;

            Document doc = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new java.io.ByteArrayInputStream(xml.getBytes()));

            doc.getDocumentElement().normalize();

           
            NodeList liste = doc.getElementsByTagName("nouvelle");

            for (int i = 0; i < liste.getLength() && i < 6; i++) {

                Element n = (Element) liste.item(i);

                String titre = lireTag(n, "titre");
                String auteur = lireTag(n, "auteur");
                String episode = lireTag(n, "episode");
                String date = lireTag(n, "date");

                nouvelles.add(new Nouvelle(titre, auteur, episode, date));
            }

        } catch (Exception e) {
            System.out.println("Erreur DAO Nouvelle : " + e.getMessage());
        }

        return nouvelles;
    }


    private String telechargerXML(String urlTexte) {
        try {
            URL url = new URL(urlTexte);
            var connexion = url.openConnection();
            connexion.setRequestProperty("User-Agent", "Mozilla/5.0");
            connexion.setConnectTimeout(2000);
            connexion.setReadTimeout(2000);    

            try (InputStream flux = connexion.getInputStream();
                 Scanner lecteur = new Scanner(flux)) {
                lecteur.useDelimiter("\\A");
                return lecteur.hasNext() ? lecteur.next() : "";
            }

        } catch (Exception e) {
            //System.out.println("Données indisponibles : " + urlTexte);
            return "";
        }
    }


    private String lireTag(Element parent, String nomTag) {
        NodeList nl = parent.getElementsByTagName(nomTag);
        if (nl.getLength() == 0) return "";
        return nl.item(0).getTextContent().trim();
    }
}
