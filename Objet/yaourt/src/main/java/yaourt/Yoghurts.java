package yaourt;

import java.util.ArrayList;

public class Yoghurts {
	private String poll;
	private int votes;
	private String[] results;
	private int[] score;
	
	public ArrayList<String> getOptions() {
		ArrayList<String> options = new ArrayList<String>();
		for (int i = 0; i < votes; i++) { if (!options.contains(results[i])) { options.add(results[i]); } }
		return options;
	}
	private void compiler() {
		ArrayList<String> options = getOptions();
		score = new int[options.size()];
		for (int i = 0; i < score.length; i++) { score[i] = 0; }
		for (int i = 0; i < options.size(); i++) { for (int j = 0; j < results.length; j++) { if (results[j].equals(options.get(i))) { score[i]++; } } }
	}
	public int[] getScore() {
		compiler();
		return score;
	}
	public String getPoll() {
		return poll;
	}
}
