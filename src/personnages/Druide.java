package personnages;

import java.util.*;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion=1;
	
	public int preparerPotion() {
		int nb_retourne;
		Random random;
		random= new Random();
		nb_retourne= random.nextInt(effetPotionMin);
		nb_retourne+=5;
		if (nb_retourne>7) {
			parler("J'ai préparé une super potion de force " + nb_retourne + " . ");
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + nb_retourne + " . ");
		}
		return nb_retourne;
	}
	
	public void booster(Gaulois gaulois) {
		int potion2;
		potion2=preparerPotion();
		if (gaulois.getNom()=="Obelix") {
			parler(" Non, Obélix !... Tu n’auras pas de potion magique !");
		} else {
			gaulois.boirePotion(potion2);
		}
	}
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " a " + effetPotionMax + " . ");
	}
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public static void main(String[] args) {
		int potion;
		Druide panoramix;
		panoramix= new Druide("Panoramix",5,10);
		potion= panoramix.preparerPotion();
	}
	
}
