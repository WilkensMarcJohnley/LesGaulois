package personnages;


public class Gaulois {
	private String nom;
	private int force; 
	private int nb_trophees=0;
	private int effetPotion=1;
	private Equipement[] frappe = new Equipement[100];
	
	public void boirePotion(int forcepotion) {
		effetPotion+=forcepotion;
		parler(" Merci Druide, je sens que ma force est de " + forcepotion + " decuplee");
	}
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
  
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] frappe = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; frappe != null && i < frappe.length; i++,nb_trophees++) {
		this.frappe[nb_trophees] = frappe[i];
		}

	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//		+ romain.getNom());
//		romain.recevoirCoup((force / 3)*effetPotion);
//		}
//	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

	public void faireUneDonnation(Musee musee) {
		if (nb_trophees>0) {
			parler("« Je donne au musee tous mes trophees :\n");
			for(int i=nb_trophees;i>0;i--) {
				System.out.println("- "+ frappe[i]+"\n");
				musee.donnerTrophees(this,frappe[i]);
				
			}
		}
	}
	
//	private String prendreParole() {
//		return "Le Gaulois " + nom + " : ";
//	}
//	
	
//	
//	public String toString() { 
//		 return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion= " + effetPotion + "]"; 
//		 }
//	 
	public static void main(String[] args) {
		Druide panoramix;
		int potion;
		String parole;
		Romain obelix;
		Gaulois asterix;
		panoramix= new Druide("Panoramix",5,10);
		obelix= new Romain("Obelix",9);
		parole="je suis un Gaulois, le plus intrepide des tribus";
		asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.parler(parole);
		asterix.frapper(obelix);
		potion= panoramix.preparerPotion();
		asterix.boirePotion(potion);
		asterix.frapper(obelix);
	}

}
