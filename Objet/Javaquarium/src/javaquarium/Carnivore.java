package javaquarium;

public class Carnivore extends Poisson {
	Carnivore(String _nom, int _age, int _sexuation) {
		super(_nom, _age, _sexuation);
	}
	Carnivore(String _nom, int _age, int _sexuation, boolean _sexe) {
		super(_nom, _age, _sexuation, _sexe);
	}
	
	void manger(Poisson proie) {
		if (proie.getClass() != this.getClass()) {
			super.manger(proie);
			this.points_de_vie += 5;
		}
	}
}
