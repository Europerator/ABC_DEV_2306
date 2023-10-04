package javaquarium;

public class Thon extends Carnivore {
	Thon(String _nom, int _age) {
		super(_nom, _age, 1);
	}
	Thon(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 1, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=Thon|";
		return retour;
	}
}
