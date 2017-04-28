package IHM;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Result extends JFrame{
	private jardin j;
	private ArrayList <Enfant> enfants;
	private JLabel r1;
	private JLabel r2;
	private JLabel r3;
	private JLabel r4;
	
	public Result(jardin j){
		super();
		this.j = j;
		setTitle("Les résultats");
		setPreferredSize(new Dimension(400, 200));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		enfants=j.getEnfants();
		
			r1 = new JLabel(enfants.get(0).getNom() + " a ramassé " + enfants.get(0).getPanier().getNbOeuf() + " oeufs.");
			this.add(r1);
			r2 = new JLabel(enfants.get(1).getNom() + " a ramassé " + enfants.get(1).getPanier().getNbOeuf() + " oeufs.");
			this.add(r2);
			r3 = new JLabel(enfants.get(2).getNom() + " a ramassé " + enfants.get(2).getPanier().getNbOeuf() + " oeufs.");
			this.add(r3);
			r4 = new JLabel(enfants.get(3).getNom() + " a ramassé " + enfants.get(3).getPanier().getNbOeuf() + " oeufs.");
			this.add(r4);
			
			pack();
		

		
	}
}
