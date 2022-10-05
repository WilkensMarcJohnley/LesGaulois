package histoire;

import personnages.*;

public class Scenario {
	public static void main(String[] args) {
		int potion;
		Druide panoramix;
		Gaulois obelix, asterix;
		Romain minus;
		obelix= new Gaulois("Obelix",8);
		asterix= new Gaulois("Asterix",4);
		minus= new Romain("Minus",15);
		panoramix= new Druide("Panoramix",5,10);
		panoramix.parler("Je vais aller préparer une petite potion...");
		potion= panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		asterix.boirePotion(potion);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		
	}
}
