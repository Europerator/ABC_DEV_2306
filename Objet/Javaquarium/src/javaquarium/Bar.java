package javaquarium;

public class Bar extends Vegetarien {
	Bar(String _nom, int _age) {
		super(_nom, _age, 2);
	}
	Bar(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 2, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=Bar|";
		return retour;
	}
}
