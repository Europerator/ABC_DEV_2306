package yaourt;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

import com.google.gson.Gson;

public class App {

	public static void main(String[] args) throws Exception { //throws Exception
		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(new URI("https://api.devoldere.net/polls/yoghurts/"))
				.build();
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
		Gson gson = new Gson();
		Yoghurts yoghurt = gson.fromJson(getResponse.body(), Yoghurts.class);
		System.out.println("Resultats du sondage :");
		ArrayList<String> options = yoghurt.getOptions();
		int[] resultat = yoghurt.getScore();
		String[] vainqueurs = new String[] {"none", "none"};
		int max[] = new int[] {0, 0};
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i) + " : " + resultat[i]);
			if (resultat[i] > max[0]) {
				vainqueurs[1] = vainqueurs[0];
				max[1] = max[0];
				vainqueurs[0] = options.get(i);
				max[0] = resultat[i];
			}
			else if (resultat[i] > max[1]) {
				max[1] = resultat[i];
				vainqueurs[1] = options.get(i);
			}
		}
		System.out.println("Les deux couleurs les plus plebiscitees sont : " + vainqueurs[0] + " avec " + max[0] + " votes et " + vainqueurs[1] + " avec " + max[1] + " votes.");
	}

}
