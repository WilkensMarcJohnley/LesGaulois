package personnages;

public class Musee {
	private Trophee[] trophee= new Trophee[200];
	private int nbTrophee=0;
	
	public void donnerTrophees(Gaulois gaulois, Trophee equipement) {
		trophee[nbTrophee]=equipement;
		nbTrophee+=1;
	}
	
	public String extraireInstructionsCaml() {
		String chaine="";
		for (int i=0;i<nbTrophee-1;i++) {
			chaine=trophee[i].donnerNom() + ", " + trophee[i] + "; ";
		}
		return "let musee = [ " + chaine + trophee[nbTrophee-1].donnerNom() + ", " + trophee[nbTrophee-1] + "]"; 
		
	}
	
}
