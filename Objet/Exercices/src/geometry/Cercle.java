package geometry;

public class Cercle {
	Point centre;
	double rayon;
	double perimetre() {
		return 2 * rayon * Math.PI;
	}
	double surface() {
		return rayon * rayon * Math.PI;
	}
	void testAppartenance(Point unPoint) {
		double dAbscisse = Math.abs(centre.abscisse - unPoint.abscisse);
		double dOrdonnee = Math.abs(centre.ordonnee - unPoint.ordonnee);
		double distance = Math.sqrt(Math.pow(dAbscisse, 2) + Math.pow(dOrdonnee, 2));
		if (distance == rayon) {
			System.out.println("Le point fait partie du cercle.");
		}
		else if (distance < rayon) {
			System.out.println("Le point est à l'intérieur du cercle");
		}
		else {
			System.out.println("Le point est à l'extérieur du cercle");
		}
	}
	void afficher() {
		System.out.println("Un cercle de rayon " + rayon + " ayant pour centre le point de coordonnées (" + centre.abscisse + ", " + centre.ordonnee + ")");
		
	}
	Cercle() {
		this.centre = new Point(-1d, -1d);
		this.rayon = 1d;
	}
	Cercle(Point pCentre, double pRayon) {
		this.centre = pCentre;
		this.rayon = pRayon;
	}
}
