package dice;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONArray;
import org.json.JSONObject;

public class App {

	public static void main(String[] args) throws Exception {
		
		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(new URI("https://api.devoldere.net/polls/dice/"))
				.build();
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
		
		JSONObject jeu = new JSONObject(getResponse.body());
		JSONArray results = jeu.getJSONArray("results");
		int[] joueurs = new int[] {0, 0, 0};
		boolean valide = true;
		int score;
		for (int i = 0; i < results.length() && valide; i++) {
			//Test de validité du tour :
			if (results.getString(i).length() != 5 //la chaîne doit faire exactement cinq caractères. 
					|| Character.getNumericValue(results.getString(i).charAt(0)) != i%3+1 //les joueurs se succèdent dans l'ordre
					|| Character.getNumericValue(results.getString(i).charAt(2)) > 6 //le premier dé est bien inférieur à 7
					|| Character.getNumericValue(results.getString(i).charAt(2)) < 1 //le premier dé est bien supérieur à 0
					|| Character.getNumericValue(results.getString(i).charAt(4)) > 6 //le second dé est bien inférieur à 7
					|| Character.getNumericValue(results.getString(i).charAt(4)) < 1) //le second dé est bien supérieur à 0
				{	valide = false;	}
			score = Character.getNumericValue(results.getString(i).charAt(2)) + Character.getNumericValue(results.getString(i).charAt(4));
			if (results.getString(i).charAt(2) == results.getString(i).charAt(4)) { joueurs[i%3] += -2; }
			else if (score > 10) { joueurs[i%3] += 3; }
			else if (score > 6) { joueurs[i%3] += 1; }
			else { joueurs[i%3] += 0; }
		}
		if (!valide) {
			System.out.println("to investigate");
		}
		else {
			System.out.println(joueurs[0] + "/" + joueurs[1] + "/" + joueurs[2]);
		}
	}
}
