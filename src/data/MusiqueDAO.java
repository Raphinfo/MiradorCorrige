package data;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Musique;

public class MusiqueDAO {

    private static final String URL_MUSIQUES =
        "https://musicbrainz.org/ws/2/artist/5b11f4ce-a62d-471e-81fc-a69a8278c7da?fmt=json";

    public List<Musique> listerMusiques() {

        String json = telechargerJson(URL_MUSIQUES);
        if (json == null || json.isBlank()) return new ArrayList<>();

        JsonElement element = new JsonParser().parse(json);
        if (!element.isJsonObject()) return new ArrayList<>();

        JsonObject racine = element.getAsJsonObject();

        String id = lireTexte(racine, "id");
        String name = lireTexte(racine, "name");
        String type = lireTexte(racine, "type");
        String country = lireTexte(racine, "country");

        if (id.isBlank()) id = "MUS-1";
        if (name.isBlank()) name = "Inconnu";

        List<Musique> musiques = new ArrayList<>();

        musiques.add(new Musique(id, name, type, country));


        if (racine.has("aliases") && racine.get("aliases").isJsonArray()) {
            JsonArray aliases = racine.getAsJsonArray("aliases");

            for (JsonElement a : aliases) {
                if (!a.isJsonObject()) continue;
                JsonObject aliasObj = a.getAsJsonObject();

                String aliasName = lireTexte(aliasObj, "name");
                if (aliasName.isBlank()) continue;

                if (musiques.size() >= 3) break;

                String aliasId = id + "-A" + (musiques.size() + 1);
                musiques.add(new Musique(aliasId, aliasName, type, country));
            }
        }

       
        while (musiques.size() < 3) {
            String autoId = id + "-X" + (musiques.size() + 1);
            String autoName = name + " (" + musiques.size() + ")";
            musiques.add(new Musique(autoId, autoName, type, country));
        }

        return musiques;
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
