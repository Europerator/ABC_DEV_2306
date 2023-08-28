package rectangle;

public class Rectangle {
	double longueur;
	double largeur;
	Rectangle() {
		this.longueur = 0;
		this.largeur = 0;
	}
	Rectangle(double pLongueur, double pLargeur) {
		this.longueur = pLongueur;
		this.largeur = pLargeur;
	}
	double surface() {
		return this.largeur * this.longueur;
	}
	double perimetre() {
		return this.largeur * 2 + this.longueur * 2;
	}
	void afficher() {
		System.out.println("Un rectangle de " + this.longueur + " par " + this.largeur + " (surface : " + this.surface() + " ; périmètre : " + this.perimetre() + ")");
	}
}
