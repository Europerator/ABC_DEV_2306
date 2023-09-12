package dominossanspizza;

public class Domino {
	private int[] faces;
	
	Domino() {
		this.faces = new int[] {0, 0};
	}
	Domino(int a, int b) {
		this.faces = new int[] {a, b};
	}
	int getFace(int face) {
		return this.faces[face-1];
	}
	void afficherPoints() {
		System.out.println("Domino de côtés " + this.faces[0] + " et " + this.faces[1]);
	}
	int valeur() {
		int somme = 0;
		for (int i = 0; i < faces.length; i++) {
			somme += faces[i];
		}
		return somme;
	}
	boolean voisinValide(Domino candidat) {
		boolean valide = false;
		for (int i = 0; i < this.faces.length && !valide; i++) {
			for (int j = 1; j <= this.faces.length && !valide; j++) {
				if (this.faces[i] == candidat.getFace(j) || this.faces[i] == 0 || candidat.getFace(j) == 0) {
					valide = true;
				}
			}
		}
		return valide;
	}
}
