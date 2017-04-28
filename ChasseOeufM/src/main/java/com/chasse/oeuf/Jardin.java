package com.chasse.oeuf;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jardin {

	private String[][] jardin;
	private ArrayList <String> jardinConfig;
	private int ligne;
	private String code;
	private int colonne;

	private Rocher r;
	private Chocolat c;
	private Enfant e;
	
	public Jardin(String nomFichier, Rocher r, Chocolat c,Enfant e) throws IOException{
		
		this.jardinConfig = new ArrayList <String>();
		this.code = "";
		
		copyFile(nomFichier);
		removeLine();
		initJardin();
		
		this.r = r;
		this.c = c;
		this.e = e;
	}
	
	public void copyFile(String nomFichier) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(nomFichier));
		String line;
		while ((line = br.readLine()) != null) {
			jardinConfig.add(line);
		}
		br.close();
		
	}
	
	public void removeLine(){
		
		String copyL;
		
		for(int i = 0; i < jardinConfig.size(); i++){
			copyL = jardinConfig.get(i);
			
			if( !copyL.equals("")){
				
			}else{
				jardinConfig.remove(i);
			}
		}
		
		int i = 0;
		while( i < jardinConfig.size()){
			copyL = jardinConfig.get(i);
			
			char first = copyL.charAt(0);
			
			if(first != 'J' ){
				jardinConfig.remove(i);i = 0;
			}
			else{
				i++;
			}
		}
		
	}
	
	public void tailleJardin(){
		
		String copyL;
		
		for(int i = 0; i < jardinConfig.size(); i++){
			copyL = jardinConfig.get(i);
			
			char first = copyL.charAt(0);
			if(first == 'J' ){
				ligne = Character.getNumericValue(copyL.charAt(4));
				colonne = Character.getNumericValue(copyL.charAt(2));
				
			}
		}
	}
	
	public void initJardin(){
		tailleJardin();
		jardin = new String[ligne][colonne];
		
		for(int i = 0; i < ligne; i++){
			for( int j = 0; j < colonne; j++ ){
				jardin[i][j] = "   0   ";
			}
		}
	}
	
	public void afficheJardin(){
		
		for(int i = 0; i < ligne; i++){
			System.out.print("\n");
			for( int j = 0; j < colonne; j++ ){
				System.out.print(jardin[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public boolean caseExiste(int ligne1, int colonne1){
		
		boolean valide = false;
		
		//System.out.println(" - ligne1 : "+ligne1+" - colonne1 : "+colonne1+" ligne : "+ligne+" - colonne : "+colonne);
		if((ligne1 >= 0 && colonne1 >= 0) && (ligne1 < ligne && colonne1 < colonne)){
			valide = true;
		}
		
		return valide;
	}
	
	public boolean caseVide(int ligne1, int colonne1){
		
		boolean valide = false;

		if(jardin[ligne1][colonne1] == "   0   "){
			valide = true;
		}
		
		return valide;
	}
	
	public boolean caseChocolat(int ligne1, int colonne1){

		boolean valide = false;
		
		String copyL;
		
		for( int i = 0; i < c.getChocolatConfig().size(); i++){
			copyL = c.getChocolatConfig().get(i);
			
			int ligne2 = Character.getNumericValue(copyL.charAt(4))-1;
			int colonne2 = Character.getNumericValue(copyL.charAt(2))-1;
			
			if( ligne1 == ligne2 && colonne1 == colonne2){
				valide = true;
				break;
			}
			
		}
		return valide;
	}
	
	public int nbrChocolat(int ligne1, int colonne1){

		int nbr = 0;
		
		nbr = Character.getNumericValue(jardin[ligne1][colonne1].charAt(3));

		return nbr;
	}

	public void ajoutObjetC( int ligne2, int colonne2, int objc){
		
		String stock = "   "+objc+"   ";

		if( caseExiste(ligne2, colonne2)){
			jardin[ligne2][colonne2] = stock;
		}
	}
	
	public void ajoutObjetD( int ligne2, int colonne2, char objd){
		
		String stock = "   "+objd+"   ";
		
		if( caseExiste(ligne2, colonne2)){
			jardin[ligne2][colonne2] = stock;
		}

	}

	public void enleveObjet( int ligne2, int colonne2, char obj){
		
		String s = "   "+obj+"   ";
		if(jardin[colonne2][ligne2].equals(s)){
			jardin[colonne2][ligne2] = "   0   ";
		}
	}
	
	public void enleveChoco( int ligne2, int colonne2, int nbrChoco){
		
		nbrChoco--;
		String newNbrChoco = "   "+nbrChoco+"   ";
		
		jardin[colonne2][ligne2] = newNbrChoco;
		
	}
	
	public void placerRocher(){
		
		char stock;
		String copyL;
		
		for(int i = 0; i < r.getRocherConfig().size(); i++){
			copyL = r.getRocherConfig().get(i);
			
			int ligne1 = Character.getNumericValue(copyL.charAt(4))-1;
			int colonne1 = Character.getNumericValue(copyL.charAt(2))-1;
			r.setRoche('R');
			stock = r.getRoche();
			this.ajoutObjetD(ligne1,colonne1,stock);
		}
	}
	
	public void placerChocolat(){
		
		String copyL;
		int stock;
		
		for(int i = 0; i < c.getChocolatConfig().size(); i++){
			copyL = c.getChocolatConfig().get(i);
			
			int ligne1 = Character.getNumericValue(copyL.charAt(4))-1;
			int colonne1 = Character.getNumericValue(copyL.charAt(2))-1;
			c.setNbrChoco(Character.getNumericValue(copyL.charAt(6)));
		
			stock = c.getNbrChoco();
			this.ajoutObjetC(ligne1,colonne1,stock);
		}
	}
	
	/***** POUR PLACER L'ENFANT AU PREMIERE AFFICHAGE ******/
	/*public void placerEnfant(){
		String copyL;
		
		//System.out.println(e.getEnfantConfig());
		for(int i = 0; i < e.getEnfantConfig().size(); i++){
			copyL = e.getEnfantConfig().get(i);
			
			String str[]=copyL.split(" ");
			
			char pseudo = str[4].charAt(0);
			int ligne1 = Character.getNumericValue(str[1].charAt(0))-1;
			int colonne1 = Character.getNumericValue(str[1].charAt(2))-1;

			this.ajoutObjetD(colonne1,ligne1,pseudo);
		}
	
	}*/
	
	public int nbrEnfant(){
		return e.getEnfantConfig().size();
	}
	
	public Rocher getR() {
		return r;
	}

	public void setR(Rocher r) {
		this.r = r;
	}

	public Chocolat getC() {
		return c;
	}

	public void setC(Chocolat c) {
		this.c = c;
	}

	public Enfant getE() {
		return e;
	}

	public void setE(Enfant e) {
		this.e = e;
	}

	public String[][] getJardin() {
		return jardin;
	}

	public void setJardin(String[][] jardin) {
		this.jardin = jardin;
	}
	
	public ArrayList<String> getJardinConfig() {
		return jardinConfig;
	}

	public void setJardinConfig(ArrayList<String> jardinConfig) {
		this.jardinConfig = jardinConfig;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
}
