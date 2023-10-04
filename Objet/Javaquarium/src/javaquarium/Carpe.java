package javaquarium;

public class Carpe extends Vegetarien {
	Carpe(String _nom, int _age) {
		super(_nom, _age, 1);
	}
	Carpe(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 1, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=Carpe|";
		return retour;
	}
}
