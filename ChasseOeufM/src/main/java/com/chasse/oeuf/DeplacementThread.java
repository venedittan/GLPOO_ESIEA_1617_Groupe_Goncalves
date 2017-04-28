package com.chasse.oeuf;
import java.io.IOException;
import java.util.ArrayList;

public class DeplacementThread implements Runnable{
	
	private ArrayList <Enfant> groupeEnfant;
	private Jardin j;
	
	public DeplacementThread(ArrayList <Enfant> groupeEnfant, Jardin j){
		this.j = j;
		this.groupeEnfant = groupeEnfant;
	}
	
	public void run(){
		
		int index = groupeEnfant.get(0).getCode().length();
		for(int i = 0; i < index; i++){
			System.out.println("\n\n Ligne : "+groupeEnfant.get(1).getLigne()+" Colonne : "+groupeEnfant.get(1).getColonne()+" Orientation : "+groupeEnfant.get(1).getOrientation()+" Code : "+groupeEnfant.get(1).getCode()+" Panier : "+groupeEnfant.get(1).getP().getNbChocolat()+"\n");
			j.afficheJardin();
			//j.deplacementEnfant(groupeEnfant);
			System.out.println("\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		System.out.println("\n\n Ligne : "+groupeEnfant.get(1).getLigne()+" Colonne : "+groupeEnfant.get(1).getColonne()+" Orientation : "+groupeEnfant.get(1).getOrientation()+" Code : "+groupeEnfant.get(1).getCode()+" Panier : "+groupeEnfant.get(1).getP().getNbChocolat()+"\n");
		j.afficheJardin();
		
	}
	
}
