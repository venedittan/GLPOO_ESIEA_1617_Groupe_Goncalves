package com.chasse.oeuf;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Chocolat {

	private ArrayList <String> chocolatConfig;
	private int ligne;
	private String code;
	private int colonne;
	private int nbrChoco;
	

	public Chocolat(String nomFichier) throws IOException{
		
		this.chocolatConfig = new ArrayList <String>();
		this.code = "";

		copyFile(nomFichier);
		removeLine();
		
	}
	
	public void copyFile(String nomFichier) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(nomFichier));
		String line;
		while ((line = br.readLine()) != null) {
			chocolatConfig.add(line);
		}
		br.close();
		
	}
	
	public void removeLine(){
		
		String copyL;
		
		for(int i = 0; i < chocolatConfig.size(); i++){
			copyL = chocolatConfig.get(i);
			
			if( !copyL.equals("")){
				
			}else{
				chocolatConfig.remove(i);
			}
		}
		
		int i = 0;
		while( i < chocolatConfig.size()){
			copyL = chocolatConfig.get(i);
			
			char first = copyL.charAt(0);
			
			if(first != 'C' ){
				chocolatConfig.remove(i);i = 0;
			}
			else{
				i++;
			}
		}
	}


	public ArrayList<String> getChocolatConfig() {
		return chocolatConfig;
	}

	public void setChocolatConfig(ArrayList<String> chocolatConfig) {
		this.chocolatConfig = chocolatConfig;
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
	public int getNbrChoco() {
		return nbrChoco;
	}

	public void setNbrChoco(int nbrChoco) {
		this.nbrChoco = nbrChoco;
	}
}
