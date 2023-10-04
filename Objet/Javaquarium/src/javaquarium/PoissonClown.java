package javaquarium;

public class PoissonClown extends Carnivore {
	PoissonClown(String _nom, int _age) {
		super(_nom, _age, 3);
	}
	PoissonClown(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 3, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=PoissonClown|";
		return retour;
	}
}
