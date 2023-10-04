package javaquarium;

public class Sole extends Vegetarien {
	Sole(String _nom, int _age) {
		super(_nom, _age, 3);
	}
	Sole(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 3, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=Sole|";
		return retour;
	}
}
