package com.chasse.oeuf;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Rocher {


	private ArrayList <String> rocherConfig;
	
	private int ligne;
	private String code;
	private int colonne;
	private char roche;
	
	public Rocher(String nomFichier) throws IOException{
		
		this.rocherConfig = new ArrayList <String>();
		this.code = "";

		copyFile(nomFichier);
		removeLine();
		
	}
	
	public void copyFile(String nomFichier) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(nomFichier));
		String line;
		while ((line = br.readLine()) != null) {
			rocherConfig.add(line);
		}
		br.close();
		
	}
	
	public void removeLine(){
		
		String copyL;
		
		for(int i = 0; i < rocherConfig.size(); i++){
			copyL = rocherConfig.get(i);
			
			if( !copyL.equals("")){
				
			}else{
				rocherConfig.remove(i);
			}
		}
		
		int i = 0;
		while( i < rocherConfig.size()){
			copyL = rocherConfig.get(i);
			
			char first = copyL.charAt(0);
			
			if(first != 'R' ){
				rocherConfig.remove(i);i = 0;
			}
			else{
				i++;
			}
		}
	}


	public ArrayList<String> getRocherConfig() {
		return rocherConfig;
	}

	public void setRocherConfig(ArrayList<String> rocherConfig) {
		this.rocherConfig = rocherConfig;
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

	public char getRoche() {
		return roche;
	}

	public void setRoche(char roche) {
		this.roche = roche;
	}
}
