package javaquarium;

/**
 * Représente un poisson végétarien de la famille des moronidés (Dicentrarchus labrax).
 */
public class Bar extends Vegetarien {
	/**
	 * Constructeur de Bar sans sexe précisé.
	 * @param _nom (String) Nom du bar introduit.
	 * @param _age (int) âge en tours d'exécution du bar introduit.
	 */
	Bar(String _nom, int _age) {
		super(_nom, _age, 2);
	}
	/**
	 * Constructeur de Bar avec sexe précisé.
	 * @param _nom (String) Nom du bar introduit.
	 * @param _age (int) âge en tours d'exécution du bar introduit.
	 * @param _sexe (boolean) true=femelle, false=mâle (sera ignoré à cause du type de sexuation du bar)
	 */
	Bar(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 2, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=Bar|";
		return retour;
	}
}
