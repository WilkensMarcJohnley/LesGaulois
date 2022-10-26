package personnages;

public class Musee {
	private Equipement[] trophee= new Equipement[200];
	private int nbTrophee=0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophee[nbTrophee]=equipement;
		nbTrophee+=1;
	}
	
}
