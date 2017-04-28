package IHM;

import java.util.ArrayList;



public class Deplacement implements Runnable{

	private ArrayList <Enfant> enfants;
	private jardin j;
	
	public Deplacement(ArrayList <Enfant> enfants, jardin j){
		this.j = j;
		this.enfants = enfants;
	}
	
	public void run() {
		
		for(int i=0; i<enfants.get(0).getInstructions().size();i++)
		{
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			j.deplacerEnfant(i);
			j.updateJardin();
		}
		j.placerEnfant();
		j.updateJardin();
		new Result(j);
		
		
	}

}
