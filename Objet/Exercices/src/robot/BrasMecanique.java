package robot;

enum Prise {
	NEUTRE,
	PINCE,
	COUPE,
	GLOBE
}

/**
 * Représente un bras mécanique monté sur une base mobile (grille cartésienne).
 * 
 * @author MLefevre
 */
public class BrasMecanique {
	/** Longueur du bras du centre de la base au centre de la paume de la main.
	 * 
	 */
	public final double TAILLE;
	/**Position de la base sur sa grille.
	 * 
	 * index 0 représence l'abscisse, index 1 l'ordonnée.
	 */
	private double position[];// = new double[2];
	/** Orientation relative à la base en degrés. Sens anti-horaire.
	 * 
	 * 0 est aligné avec l'axe des abscisses, dans la direction positive.
	 * 
	 * 90 pointe donc vers +y, 315 suit la droite y = -x.
	 */
	private double orientationBase;
	/** Inclinaison du bras relative à la base.
	 * 
	 * 0 représente la verticale. Maximum de 90 (horizontal).
	 */
	private double inclinaisonBase;
	/** Orientation relative de la main.
	 * 
	 * 0 a la paume tournée vers +x. Sens anti-horaire.
	 */
	private double orientationMain;
	/** position du poignet en coordonnées polaires.
	 * 
	 * index 0 représente l'axe polaire (0 à 100 où 0 s'aligne au bras)
	 * index 1 représente l'azimut (0 à 360 degrés, sens anti-horaire)
	 */
	private double radialMain[];// = new double[2];
	/** type de prise de la main
	 * 
	 * NEUTRE ne permet aucune prise, paume ouverte ou poing refermé.
	 * 
	 * PINCE étend le pouce et l'index pour une prise
	 * 
	 * COUPE est la prise qui permet de saisir un objet cylindrique
	 * 
	 * GLOBE est la prise destinée à saisir un objet sphérique
	 */
	private Prise prise;
	/**
	 * fermeture de la main, de 0 (ouverte) à 200 (fermée et force maximale).
	 * 
	 * 100 correspond à la fermeture complète sans force additionnelle exercée.
	 */
	private double fermeture;
	
	/** Constructeur par défaut. Présume que le bras a été réinitialisé.
	 * 
	 * @param taille longueur du bras du centre de la base au centre de la paume.
	 */
	public BrasMecanique(double taille) {
		this.TAILLE = taille;
		//this.position[0] = 0d;
		//this.position[1] = 0d;
		this.position = new double[] {0d, 0d};
		this.orientationBase = 0d;
		this.inclinaisonBase = 0d;
		this.orientationMain = 0d;
		//this.radialMain[0] = 0d;
		//this.radialMain[1] = 0d;
		this.radialMain = new double[] {0d, 0d};
		this.prise = Prise.NEUTRE;
		this.fermeture = 0d;
	}
	/** Constructeur personnalisé si le bras n'a pas été réinitialisé.
	 * 
	 * @param taille la longueur du bras du centre de la base au centre de la pauume.
	 * @param x l'abscisse de la base
	 * @param y l'ordonnée de la base
	 * @param p_orientationBase orientation du bras par rapport à la base
	 * @param p_inclinaisonBase inclinaison du bras par rapport à la verticale
	 * @param p_orientationMain orientation de la main par rapport au bras
	 * @param axePolaire distance de la main du centre d'articulation
	 * @param azimut angle de la main par rapport au centre d'articulation
	 * @param p_prise type de prise de la main
	 * @param p_fermeture fermeture appliquée à la main (0-100)
	 */
	public BrasMecanique(double taille, double x, double y, double p_orientationBase, double p_inclinaisonBase, double p_orientationMain, double axePolaire, double azimut, Prise p_prise, double p_fermeture) {
		this.TAILLE = taille;
		//this.position[0] = x;
		//this.position[1] = y;
		this.position = new double[] {x, y};
		this.orientationBase = p_orientationBase;
		this.inclinaisonBase = p_inclinaisonBase;
		this.orientationMain = p_orientationMain;
		//this.radialMain[0] = axePolaire;
		//this.radialMain[1] = azimut;
		this.radialMain = new double[] {axePolaire, azimut};
		this.prise = p_prise;
		this.fermeture = p_fermeture;
	}
	/** Accesseur de la position de la base.
	 * 
	 * @return tableau des coordonnées, index 0 = abscisse, index 1 = ordonnée 
	 */
	public double[] getPosition() {
		//return new double[]{this.position[0], this.position[1]};
		return this.position.clone();
	}
	/** Accesseur de l'orientation relative à la base
	 * 
	 * @return orientation en degrés (0-360)
	 */
	public double getOrientationBase() {
		return this.orientationBase;
	}
	/** Accesseur de l'inclinaison relative à la verticale
	 * 
	 * @return inclinaison en degrés (0-90)
	 */
	public double getInclinaisonBase() {
		return this.inclinaisonBase;
	}
	/** Accesseur de l'orientation de la main relative au bras
	 * 
	 * @return orientation en degrés (0-360)
	 */
	public double getOrientationMain() {
		return this.orientationMain;
	}
	/** Accesseur des coordonnées polaires de l'inclinaison de la main
	 * 
	 * @return tableau des coordonnées, index 0 = axe polaire, index 1 = azimut
	 */
	public double[] getRadialMain() {
		//return new double[] {this.radialMain[0], this.radialMain[1]};
		return this.radialMain.clone();
	}
	/** Accesseur du type de prise de la main
	 * 
	 * @return prise de type (enum) Prise
	 */
	public Prise getPrise() {
		return this.prise;
	}
	/** Accesseur du degré de fermeture
	 * 
	 * @return intensité de la prise (0-200)
	 */
	public double getFermeture() {
		return this.fermeture;
	}
	/** Déplace la base du bras sur l'axe des abscisses
	 * 
	 * @param x abscisse visée
	 */
	public void xTranslation(double x) {
		this.position[0] = x;
	}
	/** Déplace la base du bras sur l'axe des ordonnées
	 * 
	 * @param y ordonnée visée
	 */
	public void yTranslation(double y) {
		this.position[1] = y;
	}
	/** Tourne le bras relativement à la base
	 * 
	 * @param angle angle de rotation (positif = sens anti-horaire)
	 */
	public void tournerBase(double angle) {
		//calcul de l'angle final. +360 % 360 vise à obtenir un angle positif si le résultat devait être négatif.
		this.orientationBase = ((this.orientationBase + angle) % 360 + 360) % 360;
	}
	/** Incline le bras relativement à la verticale de la base
	 * 
	 * @param angle angle d'inclinaison à effectuer (positif incline, négatif redresse)
	 */
	public void inclinerBase(double angle) {
		if (this.inclinaisonBase + angle > 90) {
			this.inclinaisonBase = 90;
		}
		else if (this.inclinaisonBase + angle < 0) {
			this.inclinaisonBase = 0;
		}
		else {
			this.inclinaisonBase += angle;
		}
	}
	/** Tourne la main relativement au bras
	 * 
	 * @param angle angle de rotation (positif = sens anti-horaire)
	 */
	public void tournerMain(double angle) {
		//cf. orientationBase
		this.orientationMain = ((this.orientationMain + angle) % 360 + 360) % 360;
	}
	/** incline la main relativement au bras
	 * @param axePolaire distance de la main du centre d'articulation
	 * @param azimut angle de la main par rapport au centre d'articulation
	 */
	public void inclinerMain(double axePolaire, double azimut) {
		if (this.radialMain[0] + axePolaire < 0) {
			this.radialMain[1] = (this.radialMain[1] + 180) % 360;
			this.radialMain[0] = Math.abs(this.radialMain[0] + axePolaire);
		}
		else if (this.radialMain[1] + axePolaire > 100) {
			this.radialMain[0] = 100;
		}
		else {
			this.radialMain[0] += axePolaire;
		}
		this.radialMain[1] = ((this.radialMain[1] + azimut) % 360 + 360) % 360;
	}
	/** Change le type de prise (fermeture nulle)
	 * 
	 * @param p_prise nouveau type de prise
	 */
	public void changerPrise(Prise p_prise) {
		this.saisir(0-this.fermeture);
		this.prise = p_prise;
	}
	/** change l'intensité de la saisie
	 * 
	 * @param intensite négatif = ouvrir la main, positif = fermer/serrer la main
	 */
	public void saisir(double intensite) {
		if (this.fermeture + intensite > 200) {
			this.fermeture = 200;
		}
		else if (this.fermeture + intensite < 0) {
			this.fermeture = 0;
		}
		else {
			this.fermeture += intensite;
		}
	}
	/** Réinitialise la position du bras
	 * 
	 */
	public void reset() {
		this.changerPrise(Prise.NEUTRE);
		if (this.radialMain[1] > 180) {
			this.inclinerMain(0-this.radialMain[0], 360-this.radialMain[1]);
		}
		else {
			this.inclinerMain(0-this.radialMain[0],  0-this.radialMain[1]);
		}
		if (this.orientationMain > 180) {
			this.tournerMain(360-this.orientationBase);
		}
		else {
			this.tournerMain(0-this.orientationMain);
		}
		this.inclinerBase(0-this.inclinaisonBase);
		if (this.orientationBase > 180) {
			this.tournerBase(360-this.orientationBase);
		}
		else {
			this.tournerBase(0-this.orientationBase);
		}
		this.xTranslation(0);
		this.yTranslation(0);
	}
	/** Finaliseur du bras mécanique. Effectue une réinitialisation avant destruction.
	 * 
	 */
	public void finalize() {
		this.reset();
	}
}
