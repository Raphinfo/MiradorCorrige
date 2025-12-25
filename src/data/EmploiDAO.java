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

import modele.Emploi;

public class EmploiDAO {

    private static final String URL_EMPLOIS =
        "https://jobicy.com/api/v2/remote-jobs?count=20&geo=usa&industry=marketing&tag=seo";

    public List<Emploi> listerEmplois() {

        String json = telechargerJson(URL_EMPLOIS);
        if (json == null || json.isBlank()) return new ArrayList<>();

        JsonElement element = new JsonParser().parse(json);

        if (!element.isJsonObject()) return new ArrayList<>();

        JsonObject racine = element.getAsJsonObject();

        JsonArray jobs = null;
        if (racine.has("jobs") && racine.get("jobs").isJsonArray()) {
            jobs = racine.getAsJsonArray("jobs");
        } else if (racine.has("data") && racine.get("data").isJsonArray()) {
            jobs = racine.getAsJsonArray("data");
        }

        if (jobs == null) return new ArrayList<>();

        List<Emploi> emplois = new ArrayList<>();

        for (JsonElement e : jobs) {
            if (!e.isJsonObject()) continue;
            JsonObject o = e.getAsJsonObject();

            String id = lireTexte(o, "id", "jobId", "uuid");
            String titre = lireTexte(o, "jobTitle", "title", "position");
            String entreprise = lireTexte(o, "companyName", "company", "employer");
            String url = lireTexte(o, "url", "jobUrl", "applyUrl");
            String logo = lireTexte(o, "companyLogo", "companyLogoUrl", "logo");


            if (id.isBlank()) id = "EMP-" + (emplois.size() + 1);

            emplois.add(new Emploi(id, titre, entreprise, url, logo));
        }

        return emplois;
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
