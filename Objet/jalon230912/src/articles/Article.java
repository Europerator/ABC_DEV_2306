package articles;

public class Article {
	private String reference;
	private String designation;
	private double prixHT;
	private static double tauxTVA = 5;
	
	Article() {
		this.reference = "00000";
		this.designation = "inconnue";
		this.prixHT = 0d;
	}
	Article(String ref, String des, double prix) {
		this.reference = ref;
		this.designation = des;
		this.prixHT = prix;
	}
	String getReference() {
		return this.reference;
	}
	String getDesignation() {
		return this.designation;
	}
	double getPrixHT() {
		return this.prixHT;
	}
	void setReference(String ref) {
		this.reference = ref;
	}
	void setDesignation(String des) {
		this.designation = des;
	}
	void setPrixHT(double prix) {
		this.prixHT = prix;
	}
	static double getTauxTVA() {
		return tauxTVA;
	}
	static void setTauxTVA(double taux) {
		tauxTVA = taux;
	}
	double calculerPrixTTC() {
		return this.prixHT * (1d + tauxTVA/100);
	}
	void afficherArticle() {
		System.out.println("Affichage article : ");
		System.out.println("Référence : " + this.reference);
		System.out.println("Désignation : " + this.designation);
		System.out.println("Prix hors taxes : " + this.prixHT);
	}
}
