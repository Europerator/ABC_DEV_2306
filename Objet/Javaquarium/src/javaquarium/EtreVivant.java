package javaquarium;

public class EtreVivant {
	protected int points_de_vie;
	protected int age;
	protected int age_initial;
	
	EtreVivant(int _age) {
		this.age = _age;
		this.age_initial = _age;
		this.points_de_vie = 10;
	}
	int getAge() {
		return this.age;
	}
	int getAgeInitial() {
		return this.age_initial;
	}
	int getPointsDeVie() {
		return this.points_de_vie;
	}
	public String toString() {
		String retour = "|init=" + this.age_initial + ",age=" + age + ",pv=" + this.points_de_vie;
		return retour;
	}
	
	boolean estVivant() {
		if (this.points_de_vie > 0) {
			return true;
		}	
		return false;
	}

	void vieillir() {
		this.age++;
	}
	void mordre() {
		this.points_de_vie -= 4;
	}
}
