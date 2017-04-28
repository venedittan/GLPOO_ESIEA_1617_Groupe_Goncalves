package IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		setResizable(false);
		setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		enfants=j.getEnfants();
		
			/*r1 = new JLabel(enfants.get(0).getNom() + " a ramassé " + enfants.get(0).getPanier().getNbOeuf() + " oeufs.");
			this.add(r1);
			r2 = new JLabel(enfants.get(1).getNom() + " a ramassé " + enfants.get(1).getPanier().getNbOeuf() + " oeufs.");
			this.add(r2);
			r3 = new JLabel(enfants.get(2).getNom() + " a ramassé " + enfants.get(2).getPanier().getNbOeuf() + " oeufs.");
			this.add(r3);
			r4 = new JLabel(enfants.get(3).getNom() + " a ramassé " + enfants.get(3).getPanier().getNbOeuf() + " oeufs.");
			this.add(r4);*/
			
		final Object[][] donnees = { 
	            { enfants.get(0).getNom(), enfants.get(0).getPanier().getNbOeuf()}, 
	            {enfants.get(1).getNom(), enfants.get(1).getPanier().getNbOeuf()}, 
	            {enfants.get(2).getNom(), enfants.get(2).getPanier().getNbOeuf()}, 
	            {enfants.get(3).getNom(), enfants.get(3).getPanier().getNbOeuf()}
	        };

	        final String[] entetes = { "Nom", "Oeufs"};

	        final JTable tableau = new JTable(donnees, entetes);
	        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
	        getContentPane().add(tableau, BorderLayout.CENTER);
	        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

			pack();
		

		
	}
}
