package javaquarium;

/**
 * Classe représentant un organisme végétal aquatique.
 */
public class Algue extends EtreVivant {
	
	/**
	 * Constructeur d'algue.
	 * @param _age (int) âge en tours d'exécution de l'algue à introduire. 
	 * @param _pvInitial (int) points de vie initiaux de l'algue à introduire.
	 */
	Algue(int _age, int _pvInitial) {
		super(_age);
		this.points_de_vie = _pvInitial;
	}
	public String toString() {
		String retour = super.toString() + ",type=Algue|";
		return retour;
	}
	
	/**
	 * Procédure vieillissant l'algue d'un tour d'exécution.
	 * En vieillissant, l'algue croît d'un point de vie.
	 */
	void vieillir() {
		super.vieillir();
		this.points_de_vie++;
	}
	/**
	 * Fonction de reproduction asexuée de l'algue.
	 * Si l'algue est capable de se reproduire, elle le fait et retourne le résultat. 
	 * @return (boolean) true si la reproduction se produit, false sinon.
	 */
	boolean sereproduire() {
		if (this.points_de_vie > 9) {
			this.points_de_vie = this.points_de_vie/2;
			return true;
		}
		return false;
	}
}
