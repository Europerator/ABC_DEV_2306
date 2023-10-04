package javaquarium;

public class Algue extends EtreVivant {
	
	Algue(int _age, int _pvInitial) {
		super(_age);
		this.points_de_vie = _pvInitial;
	}
	public String toString() {
		String retour = super.toString() + ",type=Algue|";
		return retour;
	}
	
	void vieillir() {
		super.vieillir();
		this.points_de_vie++;
	}
	boolean sereproduire() {
		if (this.points_de_vie > 9) {
			this.points_de_vie = this.points_de_vie/2;
			return true;
		}
		return false;
	}
}
