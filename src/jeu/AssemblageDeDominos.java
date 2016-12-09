package jeu;

import java.util.Random;

public class AssemblageDeDominos {
	private static String milieu;
	private static Domino gauche;
	private static Domino droite;
	
	
	public AssemblageDeDominos() {
		this.milieu = "";
		this.gauche = null;
		this.droite = null;
	}
	
	public String affiche() {
        String temp = "";

        if(gauche == null && droite != null)
        {
            temp += droite.affiche();
        }

        if(droite == null && gauche != null)
        {
            temp = gauche.affiche() + milieu;
        }

        if(droite == null && gauche == null)
        {
            temp = milieu;
        }

        if(droite != null && gauche != null)
        {
            temp = gauche.affiche() + milieu + droite.affiche();
        }

        return temp;
    }

    public boolean ajouterDroite(Domino d) {
        if(droite != null)
        {
            if(d.getGauche() == droite.getDroite())
            {
                milieu += droite.affiche();
                droite = d;
                return true;
            }
        }
        else
        {
            if(gauche.getDroite() == d.getGauche())
            {
                droite = d;
                return true;
            }
        }

        return false;
    }
	
	public boolean ajouterGauche(Domino d) {
        if(gauche == null && droite == null)
        {
            gauche = d;
            return true;
        }

        if(d.getDroite() == gauche.getGauche())
        {
            if(droite == null)
            {
                droite = gauche;
                gauche = d;
                return true;
            }
            else
            {
                milieu = gauche.affiche() + milieu;
                gauche = d;
                return true;
            }
        }

        return false;
    }
	
	 public boolean ajouter(Domino d)
	    {
	        if(ajouterGauche(d) == true)
	        {
	            return true;
	        }
	        else
	        {
	            if(ajouterDroite(d) == true)
	            {
	                return true;
	            }
	            else
	            {
	                d.inverser();
	                if(ajouterGauche(d) == true)
	                {
	                    return true;
	                }
	                else
	                {
	                    if(ajouterDroite(d) == true)
	                    {
	                        return true;
	                    }
	                }
	            }
	        }
	        return false;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int compteur = 0;
		   boolean ajout = true;
           Random random = new Random();
           AssemblageDeDominos game = new AssemblageDeDominos();
           System.out.println("La partie commence :");
           while(ajout == true)
           {
               int a = random.nextInt(6);
               int b = random.nextInt(6);
               Domino d = new Domino(a, b);
               ajout = game.ajouter(d);
               if(ajout == true){
            	   System.out.println("L'ajout de " + d.affiche() + " est possible");
               }
               else {
            	   System.out.println("L'ajout de " + d.affiche() + " est impossible");
               }
               System.out.println(game.affiche());
               compteur++;
           }
           
           System.out.println("La partie a duré "+ compteur + " tours");
	}
	
}
