package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois= new Gaulois[nbVillageoisMaximum];
		
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]= gaulois;
		nbVillageois+=1;
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero]; 
	}
	
	
	
	public String getNom() {
		return nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public static void main(String[] args) {
		Chef abraracourix;
		Gaulois asterix;
		Village village;
		village= new Village("Vilage des Irreductibles",30);
		//Gaulois gaulois= village.trouverHabitant(30); il faut creer village dans chef et chef dans village en laissant vide le constructeur
		abraracourix= new Chef("Abraracourix",6,village);
		asterix= new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		Gaulois gaulois= village.trouverHabitant(0);
		System.out.println(gaulois); 
	}
	
}
