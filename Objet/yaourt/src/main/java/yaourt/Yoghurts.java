package yaourt;

import java.util.ArrayList;

public class Yoghurts {
	// pour utiliser Gson.fromJson() on utilise des attributs nommés et typés de façon identique aux champs du json reçu : poll (String) , votes (int) , results (String[]). 
	private String poll;
	private int votes;
	private String[] results;
	//introduction d'un tableau score pour refléter le score de chaque option
	private int[] score;
	
	/*
	 * Accesseur qui permet de lister les différentes options de results.
	 */
	public ArrayList<String> getOptions() {
		//On utilise ArrayList parce qu'on a la flemme de gérer un tableau avec une taille dynamique (on pourrait améliorer la méthode en retournant un vrai tableau cela dit)
		ArrayList<String> options = new ArrayList<String>();
		//Pour chaque entrée de results : si ce n'est pas contenu dans options, le rajouter.
		for (int i = 0; i < votes; i++) { if (!options.contains(results[i])) { options.add(results[i]); } }
		//Ici on pourrait juste créer un nouveau tableau et retourner ça au lieu de l'ArrayList<String>, probablement plus propre.
		return options;
	}
	private void compiler() {
		//Déclaration de deux tableaux parallèles : options et score. Le score d'options[n] est dans score[n].
		ArrayList<String> options = getOptions();
		score = new int[options.size()];
		//Initialisation du score à zéro pour chaque.
		for (int i = 0; i < score.length; i++) { score[i] = 0; }
		//Pour chaque option : parcourir results et incrémenter son score lorsqu'elle est rencontrée.
		for (int i = 0; i < options.size(); i++) { for (int j = 0; j < results.length; j++) { if (results[j].equals(options.get(i))) { score[i]++; } } }
	}
	/*
	 * Accesseur basique. Compile les scores à chaque appel.
	 */
	public int[] getScore() {
		compiler();
		return score;
	}
	public String getPoll() {
		return poll;
	}
}