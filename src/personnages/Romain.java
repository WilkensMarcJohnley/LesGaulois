package personnages;


public class Romain {
	private String nom;
	private int force;
	private int effetPotion=1;
	private Equipement[] equipements= new Equipement[2]; 
	private int nbEquipements=0;
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantSatisfied();
	}
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		 if (force > 0) {
		 parler("A�e");
		 } else {
		 equipementEjecte = ejecterEquipement();
		 parler("J'abandonne...");
		 }
		 
			// post condition la force � diminuer
			assert force < oldForce;
			return equipementEjecte;
			}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipements != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipements;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
				}
				
			}
			
			texte += resistanceEquipement + "!";
		}
		
		parler(texte);
		
		forceCoup -= resistanceEquipement;
		if (forceCoup>=0) {
		return forceCoup;
		}
		
		return -forceCoup;
		
		}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		System.out.println("L'�quipement de " + nom + " s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements; i++) {
			if (equipements[i] != null) {
					equipementEjecte[nbEquipementEjecte] =
					equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				}
			}
				return equipementEjecte;
		}

		

	
	
//	public void recevoirCoup(int forceCoup) {
//		int var_force=force;
//		assert isInvariantSatisfied();
//		force -= forceCoup;
//		assert force<var_force;
//		if (force>0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne");
//		}
//	}
	
	private boolean isInvariantSatisfied() {
		return force>0;
	}
	
	public void sEquiper(Equipement equipement) {
		String parole;
		switch(nbEquipements) {
		case 2: parole= "le soldat " + nom + " est deja bien protege";
				System.out.println(parole);
				break;
				
		case 1: if (equipements[0]==equipement) {
					parole= "le soldat " + nom + " possede deja " + equipement + " !";
					System.out.println(parole);
					break;
				}
				else {
					equipements[nbEquipements]=equipement;
					nbEquipements+=1;
					parole= "le soldat " + nom + " s'equipe avec un " + equipement;
					System.out.println(parole);
					break;
				}
		default : 	equipements[nbEquipements]=equipement;
					nbEquipements+=1;
					parole= "le soldat " + nom + " s'equipe avec un " + equipement;
					System.out.println(parole);
					break;
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
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		obelix.sEquiper(Equipement.CASQUE);
		obelix.sEquiper(Equipement.CASQUE);
		obelix.sEquiper(Equipement.BOUCLIER);
		obelix.sEquiper(Equipement.BOUCLIER);
	}
}
