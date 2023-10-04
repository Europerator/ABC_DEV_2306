package javaquarium;

public class Poisson extends EtreVivant {
	protected String nom;
	protected boolean sexe; //false = mâle; true = femelle.
	protected int sexuation; //0: indéterminé; 1: monosexué; 2: hermaphrodite avec l'âge; 3: hermaphrodite opportuniste
	
	Poisson(String _nom, int _age, int _sexuation) {
		super(_age);
		this.nom = _nom;
		this.sexuation = _sexuation;
		if (sexuation == 2) { this.sexe = false; }
		else if (Math.random()*2 > 1) { this.sexe = true; }
		else { this.sexe = false; }
	}
	Poisson(String _nom, int _age, int _sexuation, boolean _sexe) {
		super(_age);
		this.nom = _nom;
		this.sexuation = _sexuation;
		if (this.sexuation != 2) { this.sexe = _sexe; }
		else if (this.age < 10) { this.sexe = false; }
		else { this.sexe = true; }
	}
	String getNom() {
		return this.nom;
	}
	boolean getSexe() {
		return this.sexe;
	}
	public String toString() {
		String retour = super.toString() + ",type=Poisson,nom=" + this.nom + ",sexe=";
		if (this.sexe) { retour = retour + "f"; }
		else { retour = retour + "m"; }
		return retour;
	}

	void vieillir() {
		super.vieillir();
		if (this.age > 9 && this.sexuation == 2) { this.sexe = true; } 
		this.points_de_vie--;
	}
	boolean aFaim() {
		if (this.points_de_vie < 6) {
			return true;
		}
		return false;
	}
	void manger(EtreVivant proie) {
		proie.mordre();
	}
	boolean saccoupler(Poisson partenaire) {
		if (!this.aFaim() || partenaire.getClass() != this.getClass()) { return false; }
		if (this.sexuation == 3) { this.sexe = !partenaire.getSexe(); return true; }
		else if (this.sexe == partenaire.getSexe()) { return true; }
		return false;
	}
}
