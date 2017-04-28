package com.chasse.oeuf;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class JardinGUI {
	
	private JTextField[][] je;
	private JTextField[][] jl;
	private JPanel[][] jp;
	
	private ArrayList <String> jardinGUIConfig;
	
	private int ligne;
	private String code;
	private int colonne;

	private Rocher r;
	private Chocolat c;
	private Potion p;
	private Enfant e;
	
	public JardinGUI(String nomFichier, Rocher r, Chocolat c, Enfant e, Potion p) throws IOException{
		
		this.jardinGUIConfig = new ArrayList <String>();
		this.code = "";
		
		copyFile(nomFichier);
		removeLine();
		initJardinGUI();
		
		this.r = r;
		this.c = c;
		this.e = e;
		this.p = p;
	}
	
	public void copyFile(String nomFichier) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(nomFichier));
		String line;
		while ((line = br.readLine()) != null) {
			jardinGUIConfig.add(line);
		}
		br.close();
		
	}
	
	public void removeLine(){
		
		String copyL;
		
		for(int i = 0; i < jardinGUIConfig.size(); i++){
			copyL = jardinGUIConfig.get(i);
			
			if( !copyL.equals("")){
				
			}else{
				jardinGUIConfig.remove(i);
			}
		}
		
		int i = 0;
		while( i < jardinGUIConfig.size()){
			copyL = jardinGUIConfig.get(i);
			
			char first = copyL.charAt(0);
			
			if(first != 'J' ){
				jardinGUIConfig.remove(i);i = 0;
			}
			else{
				i++;
			}
		}
		
	}
	
	public void tailleJardinGUI(){
		
		String copyL;
		
		for(int i = 0; i < jardinGUIConfig.size(); i++){
			copyL = jardinGUIConfig.get(i);
			String str[]=copyL.split(" ");
			char first = copyL.charAt(0);
			if(first == 'J' ){
				ligne = Integer.parseInt(str[2])-1;
				colonne = Integer.parseInt(str[1])-1;

				System.out.println(ligne + " " + colonne);
			}
		}
	}
	
	
	public void initJardinGUI(){
		
		tailleJardinGUI();
		je = new JTextField[ligne][colonne];
		jp = new JPanel[ligne][colonne]; 
		jl = new JTextField[ligne][colonne];
		
		for(int i = 0; i < ligne; i++){
			for( int j = 0; j < colonne; j++ ){
				je[i][j] = new JTextField("0",3);
				je[i][j].setEnabled(false);
				je[i][j].setHorizontalAlignment(JTextField.CENTER);
				
				jl[i][j] = new JTextField("0",3);
				jl[i][j].setEnabled(false);
				jl[i][j].setHorizontalAlignment(JTextField.CENTER);
				
				jp[i][j] = new JPanel(new FlowLayout());
				jp[i][j].add(je[i][j]);
				jp[i][j].add(jl[i][j]);
			}
		}
	}
	
	public boolean caseVideGUI(int ligne1, int colonne1){
		
		boolean valide = false;

		if(je[ligne1][colonne1].getText().equals("0")){
			valide = true;
		}
		
		return valide;
	}
	
	public boolean caseChocolatGUI(int ligne1, int colonne1){

		boolean valide = false;
		
		String copyL;
		
		for( int i = 0; i < c.getChocolatConfig().size(); i++){
			copyL = c.getChocolatConfig().get(i);
			
			String str[]=copyL.split(" ");
			
			String str2[] = str[1].split("-");
			
			int ligne2 = Integer.parseInt(str2[1])-1;
			int colonne2 = Integer.parseInt(str2[0])-1;
			
			if( ligne1 == ligne2 && colonne1 == colonne2){
				if((!je[ligne1][colonne1].getText().equals("0")) && je[ligne1][colonne1].getText().charAt(0) != 'B' && !je[ligne1][colonne1].getText().equals("P")){
					valide = true;
					break;
				}
			}
			
		}
		return valide;
	}
	
	public boolean casePotionGUI(int ligne1, int colonne1){

		boolean valide = false;
		
		String copyL;
		
		for( int i = 0; i < p.getPotionConfig().size(); i++){
			copyL = p.getPotionConfig().get(i);
			
			String str[]=copyL.split(" ");
			
			String str2[] = str[1].split("-");
			
			int ligne2 = Integer.parseInt(str2[1])-1;
			int colonne2 = Integer.parseInt(str2[0])-1;
			
			if( ligne1 == ligne2 && colonne1 == colonne2){
				if((je[ligne1][colonne1].getText().equals("P"))){
					valide = true;
					break;
				}
			}
			
		}
		return valide;
	}
	
	public boolean caseBombeGUI(int ligne1, int colonne1){
		
		boolean valide = false;
		char copyC = je[ligne1][colonne1].getText().charAt(0);
		if(copyC == 'B'){
			valide = true;
		}
		
		return valide;
	}
	
	public JPanel afficheJardinGUI(){
		JPanel panC = new JPanel(new GridLayout(ligne,colonne));
		for(int i = 0; i < ligne; i++){
			for( int j = 0; j < colonne; j++ ){
				if(caseVideGUI(i, j)){
					je[i][j].setBackground(Color.GREEN);
					je[i][j].setDisabledTextColor(Color.GREEN);
					jl[i][j].setBackground(Color.GREEN);
					jl[i][j].setDisabledTextColor(Color.GREEN);
					
					jp[i][j].setBackground(Color.GREEN);
				}else if(caseChocolatGUI(i, j)){
					je[i][j].setBackground(Color.PINK);
					je[i][j].setDisabledTextColor(Color.BLACK);
					jl[i][j].setBackground(Color.PINK);
					jl[i][j].setDisabledTextColor(Color.PINK);
					
					jp[i][j].setBackground(Color.PINK);
				}else if(casePotionGUI(i, j)){
					je[i][j].setBackground(Color.BLUE);
					je[i][j].setDisabledTextColor(Color.WHITE);
					jl[i][j].setBackground(Color.BLUE);
					jl[i][j].setDisabledTextColor(Color.BLUE);
					
					jp[i][j].setBackground(Color.BLUE);
				}else{
					je[i][j].setBackground(Color.BLACK);
					je[i][j].setDisabledTextColor(Color.BLACK);
					jl[i][j].setBackground(Color.BLACK);
					jl[i][j].setDisabledTextColor(Color.WHITE);
					
					jp[i][j].setBackground(Color.BLACK);
				}
				panC.add(jp[i][j]);
			}
		}
		return panC;
	}
	
	public boolean caseExisteGUI(int ligne1, int colonne1){
		
		boolean valide = false;
		
		if((ligne1 >= 0 && colonne1 >= 0) && (ligne1 < ligne && colonne1 < colonne)){
			valide = true;
		}
		
		return valide;
	}
	
	public int nbrChocolatGUI(int ligne1, int colonne1){

		int nbr = 0;
		
		nbr = Integer.parseInt(je[ligne1][colonne1].getText());

		return nbr;
	}
	
	public String directionGUI(Enfant e){
		
		String direction = "";
		
		if( e.getOrientation() == 'E'){
			direction="\u21D2";
		}else if(e.getOrientation() == 'O'){
			direction="\u21D0";
		}else if(e.getOrientation() == 'N'){
			direction="\u21D1";
		}else if(e.getOrientation() == 'S'){
			direction="\u21D3";
		}
		
		return direction;
	}
	
	public void updatePanNordSud(int i, JLabel ja, JLabel jf, ArrayList <Enfant> ge){
		//System.out.println(ja.getText());
		ja.setText(" Oeuf : "+ge.get(i).getP().getNbChocolat()+"\u2297");
		jf.setText(" Potion : "+ge.get(i).getP().getNbPotion()+"\u2297");
	}
	
	public void ajoutObjetCGUI( int ligne2, int colonne2, int objc){
		
		String stock = ""+objc+"";

		if(caseExisteGUI(ligne2, colonne2)){
			je[ligne2][colonne2].setText(stock);
		}
	}
	
	public void ajoutObjetPGUI( int ligne2, int colonne2, String objp){
		
		String stock = objp;

		if(caseExisteGUI(ligne2, colonne2)){
			je[ligne2][colonne2].setText(stock);
		}
	}
	
	public void ajoutObjetDGUI( int ligne2, int colonne2, char objd){
		
		String stock = ""+objd+"";
		
		if(caseExisteGUI(ligne2, colonne2)){
			je[ligne2][colonne2].setText(stock);
			
			je[ligne2][colonne2].setBackground(Color.WHITE);
			je[ligne2][colonne2].setDisabledTextColor(Color.BLACK);
			
			jp[ligne2][colonne2].setBackground(Color.WHITE);
		}

	}
	
	public void ajoutObjetEGUI( int ligne2, int colonne2, String objd, Enfant e){
		
		String stock = objd;
		String direction;
		
		if(caseExisteGUI(ligne2, colonne2)){

			je[ligne2][colonne2].setText(stock);
			je[ligne2][colonne2].setBackground(Color.WHITE);
			je[ligne2][colonne2].setDisabledTextColor(Color.BLACK);
			
			direction = directionGUI(e);
			jl[ligne2][colonne2].setText(direction);
			jl[ligne2][colonne2].setBackground(Color.WHITE);
			jl[ligne2][colonne2].setDisabledTextColor(Color.BLACK);
			
			jp[ligne2][colonne2].add(je[ligne2][colonne2]);
			jp[ligne2][colonne2].add(jl[ligne2][colonne2]);
			jp[ligne2][colonne2].setBackground(Color.WHITE);
			
		}

	}
	
	public void ajoutObjetBGUI( int ligne2, int colonne2, int nb){
		String stock = "B"+nb+"";
		
		if(caseExisteGUI(ligne2, colonne2)){

			je[ligne2][colonne2].setText(stock);
			je[ligne2][colonne2].setBackground(Color.GRAY);
			je[ligne2][colonne2].setDisabledTextColor(Color.BLACK);
			
			jl[ligne2][colonne2].setBackground(Color.GRAY);
			jl[ligne2][colonne2].setDisabledTextColor(Color.GRAY);
			
			jp[ligne2][colonne2].add(je[ligne2][colonne2]);
			jp[ligne2][colonne2].add(jl[ligne2][colonne2]);
			jp[ligne2][colonne2].setBackground(Color.GRAY);
			
		}
	}
	
	public void enleveObjetGUI( int ligne2, int colonne2, char obj){
		
		String s = ""+obj+"";
		
		if(je[ligne2][colonne2].getText().equals(s)){
			je[ligne2][colonne2].setText("0");
			
			je[ligne2][colonne2].setBackground(Color.GREEN);
			je[ligne2][colonne2].setDisabledTextColor(Color.GREEN);
			
			
			jp[ligne2][colonne2].setBackground(Color.GREEN);
		}
	}
	
	public void enleveObjetEGUI( int ligne2, int colonne2, String obj, Enfant e){
		
		String s = obj;
		
		if(je[ligne2][colonne2].getText().equals(s)){
			je[ligne2][colonne2].setText("0");
			
			je[ligne2][colonne2].setBackground(Color.GREEN);
			je[ligne2][colonne2].setDisabledTextColor(Color.GREEN);
			
			jl[ligne2][colonne2].setText("0");
			
			jl[ligne2][colonne2].setBackground(Color.GREEN);
			jl[ligne2][colonne2].setDisabledTextColor(Color.GREEN);
			
			jp[ligne2][colonne2].setBackground(Color.GREEN);
		}
	}
	
	public void enleveChocoGUI( int ligne2, int colonne2, int nbrChoco){
		
		nbrChoco--;
		String newNbrChoco = ""+nbrChoco+"";
		
		if(nbrChoco <= 0){
			je[ligne2][colonne2].setText("0");
			
			je[ligne2][colonne2].setBackground(Color.GREEN);
			jl[ligne2][colonne2].setBackground(Color.GREEN);
			jp[ligne2][colonne2].setBackground(Color.GREEN);
			je[ligne2][colonne2].setDisabledTextColor(Color.GREEN);
			jl[ligne2][colonne2].setDisabledTextColor(Color.GREEN);
		}else{
			je[ligne2][colonne2].setText(newNbrChoco);
		}
	}
	
	public void enlevePotionGUI( int ligne2, int colonne2, Enfant e){
		
		int copyP = e.getP().getNbPotion();
		copyP++;
		e.getP().setNbPotion(copyP);
		
		je[ligne2][colonne2].setText("0");
		
		je[ligne2][colonne2].setBackground(Color.GREEN);
		jl[ligne2][colonne2].setBackground(Color.GREEN);
		jp[ligne2][colonne2].setBackground(Color.GREEN);
		je[ligne2][colonne2].setDisabledTextColor(Color.GREEN);
		jl[ligne2][colonne2].setDisabledTextColor(Color.GREEN);

	}
	
	public void enleveBombeGUI(int ligne2, int colonne2, int numE, ArrayList <Enfant> e){
		
		int bombeN = Character.getNumericValue(je[ligne2][colonne2].getText().charAt(1));
		
		if( numE != bombeN){
				
			if(e.get(numE).getP().getNbChocolat() > 0 && e.get(numE).getP().getNbPotion() <= 0){

				e.get(numE).getP().setNbChocolat(e.get(numE).getP().getNbChocolat()-1);
				e.get(bombeN).getP().setNbChocolat(e.get(bombeN).getP().getNbChocolat()+1);
				
				je[ligne2][colonne2].setText("0");
				
				je[ligne2][colonne2].setBackground(Color.GREEN);
				jl[ligne2][colonne2].setBackground(Color.GREEN);
				jp[ligne2][colonne2].setBackground(Color.GREEN);
				je[ligne2][colonne2].setDisabledTextColor(Color.GREEN);
				jl[ligne2][colonne2].setDisabledTextColor(Color.GREEN);
				
			}else if(e.get(numE).getP().getNbPotion() > 0){
				e.get(numE).getP().setNbPotion(e.get(numE).getP().getNbPotion()-1);
				
				je[ligne2][colonne2].setText("0");
				
				je[ligne2][colonne2].setBackground(Color.GREEN);
				jl[ligne2][colonne2].setBackground(Color.GREEN);
				jp[ligne2][colonne2].setBackground(Color.GREEN);
				je[ligne2][colonne2].setDisabledTextColor(Color.GREEN);
				jl[ligne2][colonne2].setDisabledTextColor(Color.GREEN);
			}
			
		}
	}
	
	public void placerRocherGUI(){
		
		char stock;
		String copyL;
		
		for(int i = 0; i < r.getRocherConfig().size(); i++){
			copyL = r.getRocherConfig().get(i);
			
			String str[]=copyL.split(" ");
			
			String str2[] = str[1].split("-");
			
			int ligne1 = Integer.parseInt(str2[1])-1;
			int colonne1 = Integer.parseInt(str2[0])-1;
			r.setRoche('R');
			stock = r.getRoche();
			this.ajoutObjetDGUI(ligne1,colonne1,stock);
		}
	}
	
	public void placerChocolatGUI(){
		
		String copyL;
		int stock;
		
		for(int i = 0; i < c.getChocolatConfig().size(); i++){
			copyL = c.getChocolatConfig().get(i);
			
			String str[]=copyL.split(" ");
			
			String str2[] = str[1].split("-");
			
			int ligne1 = Integer.parseInt(str2[1])-1;
			int colonne1 = Integer.parseInt(str2[0])-1;
			c.setNbrChoco(Integer.parseInt(str[2]));
		
			stock = c.getNbrChoco();
			this.ajoutObjetCGUI(ligne1,colonne1,stock);
		}
	}
	
	public void placerPotionGUI(){
		
		String copyL;
		
		for(int i = 0; i < p.getPotionConfig().size(); i++){
			copyL = p.getPotionConfig().get(i);
			
			String str[]=copyL.split(" ");
			
			String str2[] = str[1].split("-");
			
			int ligne1 = Integer.parseInt(str2[1])-1;
			int colonne1 = Integer.parseInt(str2[0])-1;

			this.ajoutObjetPGUI(ligne1,colonne1,"P");
		}
	}
	
	public void placerEnfantGUI(){
		String copyL;
		
		for(int i = 0; i < e.getEnfantConfig().size(); i++){
			copyL = e.getEnfantConfig().get(i);
			
			String str[]=copyL.split(" ");
			
			char pseudo = str[4].charAt(0);
			int ligne1 = Character.getNumericValue(str[1].charAt(2))-1;
			int colonne1 = Character.getNumericValue(str[1].charAt(0))-1;

			this.ajoutObjetDGUI(ligne1,colonne1,pseudo);
		}
	
	}

	public void deplacementEnfantGUI( ArrayList <Enfant> e){
		Enfant copyE;
		char copyDeplace;
		int nbrChoco;
		
		for(int i = 0; i < e.size(); i++){
			
			copyE = e.get(i);
			copyDeplace = e.get(i).getCode().charAt(0);
			e.get(i).setCode(e.get(i).getCode().substring(1));
			
			switch(copyE.getOrientation())
			{
			  case 'E':
			    if( copyDeplace == 'A'){
			    	if(caseExisteGUI(copyE.getLigne(),copyE.getColonne()+1)){
			    		
			    		if(caseChocolatGUI(copyE.getLigne(),copyE.getColonne()+1)){
			    			
			    			//this.enleveObjetGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo());
			    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
			    			//this.ajoutObjetEGUI(copyE.getLigne(),copyE.getColonne()+1,copyE.getPseudo(),e.get(i));
			    			
			    			nbrChoco = this.nbrChocolatGUI(copyE.getLigne(),copyE.getColonne()+1);
			    			this.enleveChocoGUI(copyE.getLigne(),copyE.getColonne()+1,nbrChoco);
			    			
			    			e.get(i).getP().setNbChocolat(e.get(i).getP().getNbChocolat()+1);
			    			e.get(i).setColonne(e.get(i).getColonne()+1);
			    			//System.out.println(" i : "+e.get(i).getP().getNbChocolat());
			    		}else if(caseVideGUI(copyE.getLigne(),copyE.getColonne()+1)){
			    			//this.enleveObjetGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo());
			    			//this.ajoutObjetDGUI(copyE.getLigne(),copyE.getColonne()+1,copyE.getPseudo());
			    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
			    			this.ajoutObjetEGUI(copyE.getLigne(),copyE.getColonne()+1,copyE.getPseudo(),e.get(i));
			    			
			    			e.get(i).setColonne(e.get(i).getColonne()+1);
			    		}else if(caseBombeGUI(copyE.getLigne(),copyE.getColonne()+1)){
			    			this.enleveBombeGUI(copyE.getLigne(),copyE.getColonne()+1,e.get(i).getNumJ(),e);
			    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
			    			//this.ajoutObjetEGUI(copyE.getLigne()+1,copyE.getColonne(),copyE.getPseudo(),e.get(i));
			    			e.get(i).setColonne(e.get(i).getColonne()+1);
			    		}else if(casePotionGUI(copyE.getLigne(),copyE.getColonne()+1)){
			    			this.enlevePotionGUI(copyE.getLigne(),copyE.getColonne()+1,e.get(i));
			    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
			    			e.get(i).setLigne(copyE.getLigne()+1);
			    		}
			    		
			    	}
			    	
			    }else if(copyDeplace == 'G'){
			    	
			    	e.get(i).setOrientation('N');
			    	String direction = directionGUI(e.get(i));
					jl[e.get(i).getLigne()][e.get(i).getColonne()].setText(direction);
			    	
			    }else if(copyDeplace == 'D'){
			    	
			    	e.get(i).setOrientation('S');
			    	String direction = directionGUI(e.get(i));
					jl[e.get(i).getLigne()][e.get(i).getColonne()].setText(direction);
					
			    }else if(copyDeplace == 'B'){
			    	
			    	if(!caseChocolatGUI(copyE.getLigne()+1,copyE.getColonne())){
			    		this.ajoutObjetBGUI(e.get(i).getLigne(),e.get(i).getColonne(),e.get(i).getNumJ());
			    	}
			    }
			    break;
			  case 'O':
				  
				  if( copyDeplace == 'A'){
				    	if(caseExisteGUI(copyE.getLigne(),copyE.getColonne()-1)){
				    		
				    		if(caseChocolatGUI(copyE.getLigne(),copyE.getColonne()-1)){
				    			//this.enleveObjetGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo());
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			//this.ajoutObjetEGUI(copyE.getLigne(),copyE.getColonne()-1,copyE.getPseudo(),e.get(i));
				    			
				    			nbrChoco = this.nbrChocolatGUI(copyE.getLigne(),copyE.getColonne()-1);
				    			this.enleveChocoGUI(copyE.getLigne(),copyE.getColonne()-1,nbrChoco);

				    			e.get(i).getP().setNbChocolat(e.get(i).getP().getNbChocolat()+1);
				    			e.get(i).setColonne(copyE.getColonne()-1);
				    			//System.out.println(" i : "+e.get(i).getP().getNbChocolat());
				    			
				    		}else if(caseVideGUI(copyE.getLigne(),copyE.getColonne()-1)){
					    		//this.enleveObjetGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo());
					    		//this.ajoutObjetDGUI(copyE.getLigne(),copyE.getColonne()-1,copyE.getPseudo());
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			this.ajoutObjetEGUI(copyE.getLigne(),copyE.getColonne()-1,copyE.getPseudo(),e.get(i));
				    			
					    		e.get(i).setColonne(copyE.getColonne()-1);
				    		}else if(caseBombeGUI(copyE.getLigne(),copyE.getColonne()-1)){
				    			this.enleveBombeGUI(copyE.getLigne(),copyE.getColonne()-1,e.get(i).getNumJ(),e);
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			//this.ajoutObjetEGUI(copyE.getLigne()+1,copyE.getColonne(),copyE.getPseudo(),e.get(i));
				    			e.get(i).setColonne(copyE.getColonne()-1);
				    		}else if(casePotionGUI(copyE.getLigne(),copyE.getColonne()-1)){
				    			this.enlevePotionGUI(copyE.getLigne(),copyE.getColonne()-1,e.get(i));
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			e.get(i).setLigne(copyE.getLigne()-1);
				    		}
				    	}
				    	
				    }else if(copyDeplace == 'G'){
				    	
				    	e.get(i).setOrientation('S');
				    	String direction = directionGUI(e.get(i));
						jl[e.get(i).getLigne()][e.get(i).getColonne()].setText(direction);
				    	
				    }else if(copyDeplace == 'D'){
				    	
				    	e.get(i).setOrientation('N');
				    	String direction = directionGUI(e.get(i));
						jl[e.get(i).getLigne()][e.get(i).getColonne()].setText(direction);
						
				    }else if(copyDeplace == 'B'){
				    	
				    	if(!caseChocolatGUI(copyE.getLigne()+1,copyE.getColonne())){
				    		this.ajoutObjetBGUI(e.get(i).getLigne(),e.get(i).getColonne(),e.get(i).getNumJ());
				    	}
				    }
			    break;
			  case 'N':
				
				  if( copyDeplace == 'A'){
				    	if(caseExisteGUI(copyE.getLigne()-1,copyE.getColonne())){
				    		if(caseChocolatGUI(copyE.getLigne()-1,copyE.getColonne())){
				    			//this.enleveObjetGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo());
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			//this.ajoutObjetEGUI(copyE.getLigne()-1,copyE.getColonne(),copyE.getPseudo(),e.get(i));
				    			
				    			nbrChoco = nbrChocolatGUI(copyE.getLigne()-1,copyE.getColonne());
				    			this.enleveChocoGUI(copyE.getLigne()-1,copyE.getColonne(),nbrChoco);
				    			
				    			e.get(i).getP().setNbChocolat(e.get(i).getP().getNbChocolat()+1);
				    			e.get(i).setLigne(copyE.getLigne()-1);
				    			//System.out.println(" i : "+e.get(i).getP().getNbChocolat());
				    			
				    		}else if(caseVideGUI(copyE.getLigne()-1,copyE.getColonne())){
				    			//this.enleveObjetGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo());
				    			//this.ajoutObjetDGUI(copyE.getLigne()-1,copyE.getColonne(),copyE.getPseudo());
				    			
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			this.ajoutObjetEGUI(copyE.getLigne()-1,copyE.getColonne(),copyE.getPseudo(),e.get(i));
				    			
					    		e.get(i).setLigne(copyE.getLigne()-1);
					    		
				    		}else if(caseBombeGUI(copyE.getLigne()-1,copyE.getColonne())){
				    			this.enleveBombeGUI(copyE.getLigne()-1,copyE.getColonne(),e.get(i).getNumJ(),e);
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			//this.ajoutObjetEGUI(copyE.getLigne()-1,copyE.getColonne(),copyE.getPseudo(),e.get(i));
				    			e.get(i).setLigne(copyE.getLigne()-1);
				    		}else if(casePotionGUI(copyE.getLigne()-1,copyE.getColonne())){
				    			
				    			this.enlevePotionGUI(copyE.getLigne()-1,copyE.getColonne(),e.get(i));
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			e.get(i).setLigne(copyE.getLigne()-1);
				    		}
				    		
				    	}
				    	
				    }else if(copyDeplace == 'G'){
				    	
				    	e.get(i).setOrientation('O');
				    	String direction = directionGUI(e.get(i));
						jl[e.get(i).getLigne()][e.get(i).getColonne()].setText(direction);
				    	
				    }else if(copyDeplace == 'D'){
				    	
				    	e.get(i).setOrientation('E');

				    	String direction = directionGUI(e.get(i));
						jl[e.get(i).getLigne()][e.get(i).getColonne()].setText(direction);
				    }else if(copyDeplace == 'B'){
				    	
				    	if(!caseChocolatGUI(copyE.getLigne()+1,copyE.getColonne())){
				    		this.ajoutObjetBGUI(e.get(i).getLigne(),e.get(i).getColonne(),e.get(i).getNumJ());
				    	}
				    }
				  
			    break;
			  case 'S':
			    
				  if( copyDeplace == 'A'){
				    	if(caseExisteGUI(copyE.getLigne()+1,copyE.getColonne())){
				    		if(caseChocolatGUI(copyE.getLigne()+1,copyE.getColonne())){
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			
				    			nbrChoco = this.nbrChocolatGUI(copyE.getLigne()+1,copyE.getColonne());
				    			this.enleveChocoGUI(copyE.getLigne()+1,copyE.getColonne(),nbrChoco);
				    			
				    			e.get(i).getP().setNbChocolat(e.get(i).getP().getNbChocolat()+1);
				    			
				    			e.get(i).setLigne(copyE.getLigne()+1);
				    			//System.out.println(" i : "+e.get(i).getP().getNbChocolat());
				    			
				    		}else if(caseVideGUI(copyE.getLigne()+1,copyE.getColonne())){
				    			//this.enleveObjetGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo());
				    			//this.ajoutObjetDGUI(copyE.getLigne()+1,copyE.getColonne(),copyE.getPseudo());
				    		
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			this.ajoutObjetEGUI(copyE.getLigne()+1,copyE.getColonne(),copyE.getPseudo(),e.get(i));
				    			
				    			e.get(i).setLigne(copyE.getLigne()+1);
				    		}else if(caseBombeGUI(copyE.getLigne()+1,copyE.getColonne())){
				    			this.enleveBombeGUI(copyE.getLigne()+1,copyE.getColonne(),e.get(i).getNumJ(),e);
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			//this.ajoutObjetEGUI(copyE.getLigne()+1,copyE.getColonne(),copyE.getPseudo(),e.get(i));
				    			e.get(i).setLigne(copyE.getLigne()+1);
				    		}else if(casePotionGUI(copyE.getLigne()+1,copyE.getColonne())){
				    			this.enlevePotionGUI(copyE.getLigne()+1,copyE.getColonne(),e.get(i));
				    			this.enleveObjetEGUI(copyE.getLigne(),copyE.getColonne(), copyE.getPseudo(),e.get(i));
				    			e.get(i).setLigne(copyE.getLigne()+1);
				    		}
				    	}
				    	
				    }else if(copyDeplace == 'G'){
				    	
				    	e.get(i).setOrientation('E');
				    	
				    	String direction = directionGUI(e.get(i));
						jl[e.get(i).getLigne()][e.get(i).getColonne()].setText(direction);
				    	//this.ajoutObjetEGUI(e.get(i).getLigne(),e.get(i).getColonne(),e.get(i).getPseudo(),e.get(i));
				    	
				    }else if(copyDeplace == 'D'){
				    	
				    	e.get(i).setOrientation('O');
				    	
				    	String direction = directionGUI(e.get(i));
						jl[e.get(i).getLigne()][e.get(i).getColonne()].setText(direction);
				    	//this.ajoutObjetEGUI(e.get(i).getLigne(),e.get(i).getColonne(),e.get(i).getPseudo(),e.get(i));
				    }else if(copyDeplace == 'B'){
				    	
				    	if(!caseChocolatGUI(copyE.getLigne()+1,copyE.getColonne())){
				    		this.ajoutObjetBGUI(e.get(i).getLigne(),e.get(i).getColonne(),e.get(i).getNumJ());
				    	}
				    }
				  
			    break;
			  default:
			    
			}
		}
		
	}
	
	public int nbrEnfant(){
		return e.getEnfantConfig().size();
	}
	
	public Enfant getE() {
		return e;
	}

	public void setE(Enfant e) {
		this.e = e;
	}

}
