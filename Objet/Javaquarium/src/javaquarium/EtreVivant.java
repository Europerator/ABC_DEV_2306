package javaquarium;

/**
 * Classe parente de tous ce qui vit et meurt dans l'environnement.
 */
public class EtreVivant {
	/**
	 * Représente la vitalité de l'être vivant.
	 * À pv<1 ou pv>19, l'organisme est considéré comme mort.
	 */
	protected int points_de_vie;
	/**
	 * Représente l'âge de l'organisme en tours d'exécution.
	 */
	protected int age;
	/**
	 * Stocke l'âge d'introduction de l'organisme dans l'environnement.
	 */
	protected int age_initial;
	
	/**
	 * Constructeur d'être vivant.
	 * @param _age (int) âge en tours d'exécution de l'être vivant à introduire. 
	 */
	EtreVivant(int _age) {
		this.age = _age;
		this.age_initial = _age;
		this.points_de_vie = 10;
	}
	/**
	 * Accesseur de l'âge courant.
	 * @return (int) âge en tours d'exécution de l'être vivant.
	 */
	int getAge() {
		return this.age;
	}
	/**
	 * Accesseur de l'âge initial.
	 * @return (int) âge initial en tours d'exécution de l'être vivant.
	 */
	int getAgeInitial() {
		return this.age_initial;
	}
	/**
	 * Accesseur des points de vie.
	 * @return (int) nombre de points de vie de l'être vivant.
	 */
	int getPointsDeVie() {
		return this.points_de_vie;
	}
	public String toString() {
		String retour = "|init=" + this.age_initial + ",age=" + age + ",pv=" + this.points_de_vie;
		return retour;
	}
	
	/**
	 * Vérifie si l'organisme est encore vivant.
	 * @return (boolean) true si vivant, false si mort.
	 */
	boolean estVivant() {
		if (this.points_de_vie > 0 && this.age < 20) { return true; }	
		return false;
	}

	/**
	 * Procédure vieillissant l'organisme d'un tour d'exécution s'il est vivant.
	 */
	void vieillir() { if (this.estVivant()){ this.age++; } }
	
	/**
	 * Procédure représentant ce qui arrive à l'organisme lorsqu'il se fait mordre,
	 * s'il est vivant.
	 */
	void mordre() {	if (this.estVivant()) { this.points_de_vie -= 4; } }
}
