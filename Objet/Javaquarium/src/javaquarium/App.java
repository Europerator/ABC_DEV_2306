package javaquarium;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		Aquarium plouf = new Aquarium();
		plouf.peupler(40, 5,5,5,5,5,5);
		System.out.println(plouf.toString());
	}

}
