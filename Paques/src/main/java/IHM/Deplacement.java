package IHM;

import java.io.IOException;
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
				Thread.sleep(500);
				j.deplacerEnfant(i);
				j.updateJardin();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			j.placerEnfant();
			j.updateJardin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Result(j);
		
		
	}

}
