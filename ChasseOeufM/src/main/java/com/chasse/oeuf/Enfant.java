package com.chasse.oeuf;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Enfant{
	
	private ArrayList <String> enfantConfig;
	
	private int ligne;
	private int colonne;
	
	private String code;
	private String nom;
	private char orientation;
	private String pseudo;
	private int numJ;

	private Panier p;

	public Enfant(String nomFichier) throws IOException{
		
		
		this.enfantConfig = new ArrayList <String>();
		this.code = "";
		
		copyFile(nomFichier);
		removeLine();

	}
	
	public Enfant(int ligne, int colonne, String code, String nom, char orientation, String pseudo, int numJ){ 
		
		this.ligne = ligne;
		this.colonne = colonne;
		this.code = code;
		this.nom = nom;
		this.orientation = orientation;
		this.pseudo = pseudo;
		this.p = new Panier();
		this.numJ = numJ;
	}
	
	public void copyFile(String nomFichier) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(nomFichier));
		String line;
		while ((line = br.readLine()) != null) {
			enfantConfig.add(line);
		}
		br.close();
		
	}
	
	public void removeLine(){
		
		String copyL;
		
		for(int i = 0; i < enfantConfig.size(); i++){
			copyL = enfantConfig.get(i);
			
			if( !copyL.equals("")){
				
			}else{
				enfantConfig.remove(i);
			}
		}
		
		int i = 0;
		while( i < enfantConfig.size()){
			copyL = enfantConfig.get(i);
			
			char first = copyL.charAt(0);
			
			if(first != 'E' ){
				enfantConfig.remove(i);i = 0;
			}
			else{
				i++;
			}
		}
	}
	
	public ArrayList <Enfant> groupeEnfant(){
		
		ArrayList <Enfant> tabEnfant = new ArrayList <Enfant>();
		
		String copyL;
		
		for(int i = 0; i < enfantConfig.size(); i++){
			
			copyL = enfantConfig.get(i);
			String str[]=copyL.split(" ");
			
			numJ = i;
			pseudo = "J"+numJ;
			ligne = Character.getNumericValue(str[1].charAt(2))-1;
			colonne = Character.getNumericValue(str[1].charAt(0))-1;
			orientation = str[2].charAt(0);
			nom = str[4];
			code = str[3];

			Enfant e = new Enfant(ligne,colonne,code,nom,orientation,pseudo,numJ);
			
			tabEnfant.add(e);
		}
		
		return tabEnfant;
	}

	public char getOrientation() {
		return orientation;
	}

	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}
	
	public int getNumJ() {
		return numJ;
	}

	public void setNumJ(int numJ) {
		this.numJ = numJ;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public ArrayList<String> getEnfantConfig() {
		return enfantConfig;
	}

	public void setEnfantConfig(ArrayList<String> enfantConfig) {
		this.enfantConfig = enfantConfig;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Panier getP() {
		return p;
	}

	public void setP(Panier p) {
		this.p = p;
	}
	
	
	

}
