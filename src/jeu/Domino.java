package jeu;

public class Domino {
	private int gauche;
	private int droite;
	
	
	public Domino(int a, int b) {
		if(a < 0) {
			a = 0;
		}
		if(b < 0){
			b = 0;
		}
		if(a > 6) {
			a = 6;
		}
		if(b > 6){
			b = 6;
		}
		if(a > b){
			gauche = b;	
			droite = a;
		}
		else if(b > a){
			gauche = a;
			droite = b;
		}
		else{
			gauche = a;
			droite = b;
		}
		
	}


	public int getGauche() {
		return gauche;
	}


	public int getDroite() {
		return droite;
	}
	
	public String affiche() {
		
		return "["+getGauche()+"|"+getDroite()+"]";
	}
	
	public void inverser() {
		int temp;
		temp = gauche;
		gauche = droite;
		droite = temp;
	}
	
}
