package com.chasse.oeuf;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Potion {

	private ArrayList <String> potionConfig;
	private int ligne;
	private String code;
	private int colonne;
	private int nbrPotion;
	

	public Potion(String nomFichier) throws IOException{
		
		this.potionConfig = new ArrayList <String>();
		this.code = "";

		copyFile(nomFichier);
		removeLine();
		
	}
	
	public void copyFile(String nomFichier) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(nomFichier));
		String line;
		while ((line = br.readLine()) != null) {
			potionConfig.add(line);
		}
		br.close();
		
	}
	
	public void removeLine(){
		
		String copyL;
		
		for(int i = 0; i < potionConfig.size(); i++){
			copyL = potionConfig.get(i);
			
			if( !copyL.equals("")){
				
			}else{
				potionConfig.remove(i);
			}
		}
		
		int i = 0;
		while( i < potionConfig.size()){
			copyL = potionConfig.get(i);
			
			char first = copyL.charAt(0);
			
			if(first != 'P' ){
				potionConfig.remove(i);i = 0;
			}
			else{
				i++;
			}
		}
	}

	public ArrayList<String> getPotionConfig() {
		return potionConfig;
	}

	public void setPotionConfig(ArrayList<String> potionConfig) {
		this.potionConfig = potionConfig;
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

	public int getNbrPotion() {
		return nbrPotion;
	}

	public void setNbrPotion(int nbrPotion) {
		this.nbrPotion = nbrPotion;
	}
}
