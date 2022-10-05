package personnages;

public class Romain {
	private String nom;
	private int force;
	private int effetPotion=1;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force>0) {
			parler("Aie");
		} else {
			parler("J'abandonne");
		}
	}
	
	public String toString() { 
		 return "Romain [nom=" + nom + ", force=" + force + ", effetPotion= " + effetPotion + "]"; 
		 }
	
	public static void main(String[] args) {
		Romain obelix;
		String parole;
		int forcecoup=3;
		obelix= new Romain("Obelix",9);
		parole="Je suis un Romain, agenouillez-vous et je vous epargnerai d'une mort lente et douloureuse.";
		System.out.println(obelix.getNom());
		System.out.println(obelix);
		obelix.parler(parole);
		obelix.recevoirCoup(forcecoup);
	}
}
