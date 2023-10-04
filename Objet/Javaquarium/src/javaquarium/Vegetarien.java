package javaquarium;

public class Vegetarien extends Poisson {
	Vegetarien(String _nom, int _age, int _sexuation) {
		super(_nom, _age, _sexuation);
	}
	Vegetarien(String _nom, int _age, int _sexuation, boolean _sexe) {
		super (_nom, _age, _sexuation, _sexe);
	}
	void manger(Algue proie) {
		super.manger(proie);
		this.points_de_vie += 3;
	}
}
