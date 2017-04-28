package com.chasse.oeuf;
import java.util.ArrayList;

public class DeplacementThreadGUI implements Runnable{

	private ArrayList <Enfant> groupeEnfant;
	private JardinGUI j;
	private JouerGUI jg;
	
	public DeplacementThreadGUI(ArrayList <Enfant> groupeEnfant, JardinGUI j, JouerGUI jg){
		this.j = j;
		this.jg = jg;
		this.groupeEnfant = groupeEnfant;
	}
	
	public void run(){
		
		int index = groupeEnfant.get(0).getCode().length();
		
		for(int i = 0; i < index; i++){
			//System.out.println(groupeEnfant.get(0).getP().getNbPotion());
			j.deplacementEnfantGUI(groupeEnfant);
			if(groupeEnfant.size() >= 2){
				switch(groupeEnfant.size()){
					case 1:
						j.updatePanNordSud(0, jg.getO1(), jg.getP1(), groupeEnfant);
						break;
					case 2:
						j.updatePanNordSud(0, jg.getO1(), jg.getP1(), groupeEnfant);
						j.updatePanNordSud(1, jg.getO2(), jg.getP2(), groupeEnfant);
						break;
					case 3:
						j.updatePanNordSud(0, jg.getO1(), jg.getP1(), groupeEnfant);
						j.updatePanNordSud(1, jg.getO2(), jg.getP2(), groupeEnfant);
						j.updatePanNordSud(2, jg.getO3(), jg.getP3(), groupeEnfant);
						break;
					case 4:
						j.updatePanNordSud(0, jg.getO1(), jg.getP1(), groupeEnfant);
						j.updatePanNordSud(1, jg.getO2(), jg.getP2(), groupeEnfant);
						j.updatePanNordSud(2, jg.getO3(), jg.getP3(), groupeEnfant);
						j.updatePanNordSud(3, jg.getO4(), jg.getP4(), groupeEnfant);
						break;
					default:
						break;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
