package com.chasse.oeuf;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Jouer {

	public static void main(String[] args) {
		
			try {
				Chocolat c = new Chocolat("I:/GLPOO_ESIEA_1617_Groupe_ROUVIER-master/ChasseOeufM/src/main/java/Oeuf.txt");
				Rocher r = new Rocher("I:/GLPOO_ESIEA_1617_Groupe_ROUVIER-master/ChasseOeufM/src/main/java/Oeuf.txt");
				Enfant e = new Enfant("I:/GLPOO_ESIEA_1617_Groupe_ROUVIER-master/ChasseOeufM/src/main/java/Enfant.txt");
				Jardin j = new Jardin("I:/GLPOO_ESIEA_1617_Groupe_ROUVIER-master/ChasseOeufM/src/main/java/Oeuf.txt",r,c,e);
				
				j.placerRocher();
				j.placerChocolat();
				//j.afficheJardin();
				ArrayList <Enfant> ge = new ArrayList <Enfant>();
				ge = e.groupeEnfant();
				
				Thread t = new Thread(new DeplacementThread(ge, j));
				t.start();
				
				//System.out.println(j.getColonne()+"  "+j.getLigne());
				//System.out.println(j.caseExiste(4, 5));
				//System.out.println(j.caseVide(4, 5));
				//System.out.println(j.caseChocolat(1, 3));
				/*System.out.println(j.caseChocolat(0, 0));
				System.out.println(j.caseChocolat(0, 3));*/
				
				/*System.out.println(j.caseExiste(-1, -1));
				System.out.println(j.caseExiste(0, 0));
				System.out.println(j.caseExiste(5, 4));*/
				
				//System.out.println(j.caseExiste(6, 4));
				//j.afficheJardin();
				/*System.out.println(j.caseExiste(-1, -1));
				System.out.println(j.caseExiste(0, 0));
				System.out.println(j.caseExiste(4, 5));*/
				/*
				//System.out.println(e.getEnfantConfig());
				r.placerRocher();
				c.placerChocolat();
				e.placerEnfant();
				ge = e.groupeEnfant();

				e.deplacementEnfant(ge);
				j.afficheJardin();
				System.out.println("/n/n Ligne : "+ge.get(0).getLigne()+" Colonne : "+ge.get(0).getColonne()+" Orientation : "+ge.get(0).getOrientation()+" Code : "+ge.get(0).getCode()+"/n");
				e.deplacementEnfant(ge);
				j.afficheJardin();
				System.out.println("/n/n Ligne : "+ge.get(0).getLigne()+" Colonne : "+ge.get(0).getColonne()+" Orientation : "+ge.get(0).getOrientation()+" Code : "+ge.get(0).getCode()+"/n");
				e.deplacementEnfant(ge);
				j.afficheJardin();
				System.out.println("/n/n Ligne : "+ge.get(0).getLigne()+" Colonne : "+ge.get(0).getColonne()+" Orientation : "+ge.get(0).getOrientation()+" Code : "+ge.get(0).getCode());
				e.deplacementEnfant(ge);
				j.afficheJardin();
				System.out.println("/n/n Ligne : "+ge.get(0).getLigne()+" Colonne : "+ge.get(0).getColonne()+" Orientation : "+ge.get(0).getOrientation()+" Code : "+ge.get(0).getCode());
				e.deplacementEnfant(ge);
				j.afficheJardin();
				System.out.println("/n/n Ligne : "+ge.get(0).getLigne()+" Colonne : "+ge.get(0).getColonne()+" Orientation : "+ge.get(0).getOrientation()+" Code : "+ge.get(0).getCode());
				e.deplacementEnfant(ge);
				j.afficheJardin();
				System.out.println("/n/n Ligne : "+ge.get(0).getLigne()+" Colonne : "+ge.get(0).getColonne()+" Orientation : "+ge.get(0).getOrientation()+" Code : "+ge.get(0).getCode());
				e.deplacementEnfant(ge);
				j.afficheJardin();
				System.out.println("/n/n Ligne : "+ge.get(0).getLigne()+" Colonne : "+ge.get(0).getColonne()+" Orientation : "+ge.get(0).getOrientation()+" Code : "+ge.get(0).getCode());
				e.deplacementEnfant(ge);
				j.afficheJardin();
				System.out.println("/n/n Ligne : "+ge.get(0).getLigne()+" Colonne : "+ge.get(0).getColonne()+" Orientation : "+ge.get(0).getOrientation()+" Code : "+ge.get(0).getCode());
				 */
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			
			//String s="27 03 2008";
			//String str[]=s.split(" ");
			//le tableau str crée est:
			//str={"27","03","2008"};
			//for( int i = 0; i<str.length; ++i){System.out.println(str[i]);}

	}

}
