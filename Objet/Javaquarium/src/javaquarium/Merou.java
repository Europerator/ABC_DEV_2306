package javaquarium;

public class Merou extends Carnivore {
	Merou(String _nom, int _age) {
		super(_nom, _age, 2);
	}
	Merou(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 2, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=Merou|";
		return retour;
	}
}
