package data;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Dragon;

public class DragonDAO {

    private static final String URL_DRAGONS =
        "https://dragon.leagueoflegends.com/cdn/14.3.1/data/en_US/champion.json";

    public List<Dragon> listerDragons() {

        String json = telechargerJson(URL_DRAGONS);
        if (json == null || json.isBlank()) return new ArrayList<>();

        JsonElement element = new JsonParser().parse(json);

        if (!element.isJsonObject()) return new ArrayList<>();

        JsonObject racine = element.getAsJsonObject();
        if (!racine.has("data") || !racine.get("data").isJsonObject()) return new ArrayList<>();

        JsonObject data = racine.getAsJsonObject("data");

        List<Dragon> dragons = new ArrayList<>();
        int niveau = 50;

        for (Entry<String, JsonElement> entry : data.entrySet()) {
            if (!entry.getValue().isJsonObject()) continue;

            JsonObject champ = entry.getValue().getAsJsonObject();

            String id = lireTexte(champ, "id");
            String nom = lireTexte(champ, "name");
            String titre = lireTexte(champ, "title");
            String description = lireTexte(champ, "blurb");

            
            String elementDragon = "Feu";
            String rarete = "Légendaire";

            dragons.add(new Dragon(id, nom, titre, description, elementDragon, niveau, rarete));

            if (dragons.size() >= 6) break; 
        }

        return dragons;
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
            System.out.println(" Données indisponibles (réseau/DNS) : " + urlTexte);
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
