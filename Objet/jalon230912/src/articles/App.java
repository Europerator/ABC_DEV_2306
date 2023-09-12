package articles;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Article velo = new Article("VTT01", "Vélo tout terrain", 250d);
		Article mystere = new Article();
		
		mystere.setReference("B1B3L0T");
		mystere.setDesignation("Antiquité");
		mystere.setPrixHT(60d);
		Article.setTauxTVA(50);
		
		velo.afficherArticle();
		System.out.println("Prix TTC attendu : 375.00 ; prix calculé : " + velo.calculerPrixTTC());
		mystere.afficherArticle();
		System.out.println("Prix TTC attendu : 90.00 ; prix calculé : " + mystere.calculerPrixTTC());
	}

}
