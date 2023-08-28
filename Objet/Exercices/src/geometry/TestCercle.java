package geometry;

public class TestCercle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point origine = new Point();
		Point a = new Point (3d, 4d);
		Point b = new Point (1d, 1d);
		Point c = new Point (8d, 9d);
		Cercle rond = new Cercle(origine, 5d);
		rond.afficher();
		rond.testAppartenance(a);
		rond.testAppartenance(b);
		rond.testAppartenance(c);
	}

}
