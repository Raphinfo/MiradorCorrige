package data;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Musee;

public class MuseeDAO {

    
    private static final String URL_MUSEE_100 =
        "https://collectionapi.metmuseum.org/public/collection/v1/objects/100";

    public List<Musee> listerMusees() {

        List<Musee> musees = new ArrayList<>();

        String json = telechargerJson(URL_MUSEE_100);
        if (json == null || json.isBlank()) return musees;

        JsonElement element = new JsonParser().parse(json);
        if (!element.isJsonObject()) return musees;

        JsonObject o = element.getAsJsonObject();

        
        String titre  = lireTexte(o, "title");
        String annee  = lireTexte(o, "objectDate");               
        String pays   = lireTexte(o, "country");                
        String nom    = lireTexte(o, "artistDisplayName");         
        String medium = lireTexte(o, "medium");                   
        String dept   = lireTexte(o, "department");               

        
        String objets = "";
        if (!medium.isBlank() && !dept.isBlank()) objets = medium + " • " + dept;
        else if (!medium.isBlank()) objets = medium;
        else if (!dept.isBlank()) objets = dept;

     
        if (titre.isBlank()) titre = "Objet du MET";
        if (annee.isBlank()) annee = "Date inconnue";
        if (pays.isBlank())  pays  = "Pays inconnu";
        if (nom.isBlank())   nom   = "Artiste inconnu";

       
        musees.add(new Musee(titre, objets, annee, nom, pays));

        return musees;
    }

    private String telechargerJson(String urlTexte) {
        try {
            URL url = new URL(urlTexte);
            URLConnection connexion = url.openConnection();

            connexion.setRequestProperty("User-Agent", "Mozilla/5.0");
            connexion.setConnectTimeout(8000);
            connexion.setReadTimeout(8000);

            try (InputStream flux = connexion.getInputStream()) {
                return new String(flux.readAllBytes(), StandardCharsets.UTF_8);
            }

        } catch (Exception e) {
            System.out.println("Données indisponibles (réseau/DNS) : " + urlTexte);
            return "";
        }
    }

    private String lireTexte(JsonObject o, String... cles) {
        for (String cle : cles) {
            if (o.has(cle) && !o.get(cle).isJsonNull()) {
                try {
                    return o.get(cle).getAsString();
                } catch (Exception ignore) {}
            }
        }
        return "";
    }
}
