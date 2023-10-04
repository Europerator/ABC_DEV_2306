package justedestests;

public class maClasseB extends maClasseA{
	//maClasseB() { System.out.println("Constructeur B par défaut (bouuh)");	}
	maClasseB(String _qqch, int a) { System.out.println("Constructeur classe B " + a); }
	void faire() {
		super.faire();
		System.out.println("Faire de la classe B");
	}
}
