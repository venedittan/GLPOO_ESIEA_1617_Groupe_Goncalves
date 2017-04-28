package IHM;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;





public class jardin extends JFrame{
	
	private static ArrayList <String> jardinConfig; //Tableau contenant les informations du fichier Jardin
	private static ArrayList <String> enfantConfig; //Tableau contenant les informations du fichier Enfant
	private JPanel[][] jpanels;
	private ArrayList <Rocher> rochers;
	private ArrayList <Oeuf> oeufs;
	private ArrayList <Enfant> enfants;
	public ArrayList<Enfant> getEnfants() {
		return enfants;
	}

	private Oeuf o;
	private Enfant e;
	private int ligne;
	private int colonne;
	private Object[][] jardin;


	
	

	public jardin() throws IOException {
		super();
		initJardin();
	}
	
	public void initJardin() throws IOException{
		jardinConfig = new ArrayList <String>();
		enfantConfig = new ArrayList <String>();
		rochers = new ArrayList <Rocher>();
		oeufs = new ArrayList <Oeuf>();
		enfants = new ArrayList <Enfant>();
		getFile("src/jardin.txt", jardinConfig);
		getFile("src/enfant.txt", enfantConfig);
		trierJardin();
		trierEnfant();
		draw();
		placerEnfant();

		Thread t = new Thread(new Deplacement(enfants, this));
		t.start();
	}
	
private void draw() {
		
	setTitle("Chasse aux oeufs");
	setPreferredSize(new Dimension(colonne*100, ligne*100));
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	JPanel pan = new JPanel (new GridLayout (ligne,colonne));
	Border blackline = BorderFactory.createLineBorder(Color.GRAY,1); 
	System.out.println(colonne + "x" + ligne + " = " + ligne*colonne);
	for(int i = 0; i<ligne;i++){
		  for(int j =0; j<colonne;j++){
			  jardin[i][j]="J";
			  jpanels[i][j]=null;
		  }
	}
	for(int i = 0; i<ligne;i++){
	  for(int j =0; j<colonne;j++){
	JPanel ptest = new JPanel();
	//JLabel n = new JLabel(i + ", " + j);
	//ptest.add(n);
	jpanels[i][j]=ptest;
	ptest.setName("p"+i+""+j);
	   ptest.setBorder(blackline);
	   ptest.setBackground(Color.green);
	   for(int k =0;k<rochers.size();k++){
		   if(i==rochers.get(k).getColonne() && j==rochers.get(k).getLigne()){			  
			   jardin[i][j]=rochers.get(k);
			   ptest.setBackground(Color.black);
			   rochers.remove(k);
			   break;
		   } 
	   }
	   
	   for(int k =0;k<oeufs.size();k++){
		   if(i==oeufs.get(k).getColonne() && j==oeufs.get(k).getLigne()){
			  JLabel n = new JLabel(Integer.toString(oeufs.get(k).getNbr()));
			  jardin[i][j]=oeufs.get(k);
			  ptest.setBackground(Color.yellow);
			   ptest.add(n);
			   oeufs.remove(k);
			   break;
		   } 
		  
		   
	   }
	   /*JLabel n = new JLabel(i + ", " + j);
	   ptest.add(n);*/
	   
	   pan.add(ptest);
	   pan.setBorder(blackline);
	  }
	   
	   }
	this.add(pan);
	pack();
	}

public void placerEnfant(){
	for(int i=0; i<enfants.size(); i++){
		int colonne = enfants.get(i).getColonne();
		int ligne = enfants.get(i).getLigne();
		//System.out.println("enfant : " + colonne + " " + ligne);
		//System.out.println("jardin : " + jardin.length + " " + jardin[0].length);
		System.out.println(jardin[ligne][colonne].getClass() );
		System.out.println(Oeuf.class);
	if(jardin[ligne][colonne].getClass() != Rocher.class && jardin[ligne][colonne].getClass() != Oeuf.class)
	{
		System.out.println("Case Herbe");
		jpanels[ligne][colonne].setBackground(Color.blue);
	}
	else if(jardin[ligne][colonne].getClass() == Oeuf.class)
	{	
		System.out.println("Case Oeuf");
		Oeuf o = (Oeuf) jardin[ligne][colonne];
		jpanels[ligne][colonne].setBackground(Color.blue);
		
		if(o.getNbr()>0)
		{
			enfants.get(i).getPanier().ajouterUnOeuf();
			o.unOeufPris();
		}
	}
	}
}

public void updateJardin()
{
	for(int i = 0; i<ligne;i++){
		  for(int j =0; j<colonne;j++){
			  
			  if(jardin[i][j].getClass() == Rocher.class)
			  {
				  jpanels[i][j].setBackground(Color.BLACK);
			  }
			  else if(jardin[i][j].getClass() == Oeuf.class)
			  {
				  System.out.println(ligne + " " + colonne + " " + jardin.length + " " + jardin[0].length);
				  
				  Oeuf o = (Oeuf) jardin[i][j];
				  jpanels[i][j].setBackground(Color.yellow);
				  for (Component jc : jpanels[i][j].getComponents()) {
					    if ( jc instanceof JLabel ) {
					        ((JLabel) jc).setText(Integer.toString(o.getNbr()));
					    }
					}
			  }
			  else
				  jpanels[i][j].setBackground(Color.green);
		  }
	}
	placerEnfant();
	this.repaint();
}

public void deplacerEnfant(int j)
{
	for(int i=0; i<enfants.size(); i++)
	{
		
		Enfant enfant =enfants.get(i);
		System.out.println("Déplacer : " + enfant.getLigne()+ " " + enfant.getColonne() + " " + enfant.getOrientation());
		ArrayList<String> s = enfant.getInstructions();
		if(s.get(j).equals("D"))
		{
					enfant.tournerAdroite();
			
		}
		else if(s.get(j).equals("A"))
		{
			
			switch(enfant.getOrientation())
			{
			case 'N':if(enfant.getLigne() > 0 && jardin[enfant.getLigne()-1][enfant.getColonne()].getClass() != Rocher.class)
					{
						enfant.Avancer();
					}break;
			case 'E':if(enfant.getColonne() < this.colonne-1 && jardin[enfant.getLigne()][enfant.getColonne()+1].getClass() != Rocher.class)
					{
						enfant.Avancer();
					}break;
			case 'O':if(enfant.getColonne() > 0 && jardin[enfant.getLigne()][enfant.getColonne()-1].getClass() != Rocher.class)
					{
						enfant.Avancer();
					}break;
			case 'S':if(enfant.getLigne() < this.ligne-1 && jardin[enfant.getLigne()+1][enfant.getColonne()].getClass() != Rocher.class)
			{
				enfant.Avancer();
			}break;
			default:break;
			}
		}
		else if(s.get(j).equals("G"))
		{
			enfant.tournerAgauche();
		}
		else if(s.get(j).equals("B"))
		{
			
			switch(enfant.getOrientation())
			{ 
			case 'N':if(enfant.getLigne() < this.ligne-1 && jardin[enfant.getLigne()+1][enfant.getColonne()].getClass() != Rocher.class)
					{
						enfant.Reculer();
					}break;
			case 'E':if(enfant.getColonne() > 0 && jardin[enfant.getLigne()][enfant.getColonne()-1].getClass() != Rocher.class)
					{
						enfant.Reculer();
					}break;
			case 'O':if(enfant.getColonne() < this.colonne-1 && jardin[enfant.getLigne()][enfant.getColonne()+1].getClass() != Rocher.class)
					{
						enfant.Reculer();
					}break;
			case 'S':if(enfant.getLigne() > 0 && jardin[enfant.getLigne()-1][enfant.getColonne()].getClass() != Rocher.class)
			{
				enfant.Reculer();
			}break;
			default:break;
			}
		}
		s.remove(j);
	}
}


public static void getFile(String nomFichier, ArrayList <String> tab) throws IOException{ //Lit un fichier et ajoute son contenu dans un tableau
    	
    	BufferedReader br = new BufferedReader(new FileReader(nomFichier));
    	String line;
    	while ((line = br.readLine()) != null) {
    		tab.add(line);
    	}
    	br.close();
    	removeLine(tab);
    }
    
    public static void removeLine(ArrayList <String> tab){
		
		String L;
		
		for(int i = 0; i < tab.size(); i++){
			L = tab.get(i);
			
			if(!L.startsWith("J") && !L.startsWith("R") && !L.startsWith("C")&&!L.startsWith("E")){
				
				tab.remove(i);
			}
		}
	
    }
    
    public void trierEnfant(){
    	for(int i=0; i<enfantConfig.size(); i++)
    	{
    		String[] s = enfantConfig.get(i).split(" ");
    		int colonne = Integer.parseInt(s[1].split("-")[1]);
    		int ligne = Integer.parseInt(s[1].split("-")[0]);
    		char orientation = s[2].charAt(0);
    		String nom = s[4];
    		ArrayList<String> instructions = new ArrayList<String>();
    		Collections.addAll(instructions,(s[3].split("")));
    		enfants.add(new Enfant(ligne, colonne, nom, orientation,instructions));
    	}
    }
    
    public void trierJardin() throws NumberFormatException, IOException{
    	for(int i=0; i<jardinConfig.size(); i++)
    	{
    		String s = jardinConfig.get(i);
    		if(s.startsWith("C"))
    		{
    			int colonne = Integer.parseInt(s.split(" ")[1].split("-")[0]);
    			int ligne = Integer.parseInt(s.split(" ")[1].split("-")[1]);
    			int nbr = Integer.parseInt(s.split(" ")[2]);
    			oeufs.add(new Oeuf(colonne, ligne, nbr ));
    		}
    		else if(s.startsWith("R"))
    		{
    			int colonne = Integer.parseInt(s.split(" ")[1].split("-")[0]);
    			int ligne = Integer.parseInt(s.split(" ")[1].split("-")[1]);
    			rochers.add(new Rocher(colonne, ligne));
    			System.out.println(rochers);
    		}
    		else if(s.startsWith("J"))
    		{
    			this.colonne = Integer.parseInt(s.split(" ")[1]);
    			this.ligne = Integer.parseInt(s.split(" ")[2]);
    		}
    	}
    	jardin = new Object[ligne][colonne];
    	jpanels = new JPanel[ligne][colonne];
    }
	
    
   

	

}
 