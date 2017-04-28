package IHM;

import java.util.ArrayList;

public class Enfant {
	
	private int ligne;
	private int colonne;
	private String nom;
	private Panier p;
	private String pseudo;
	private char orientation;
	private ArrayList<String> instructions;
	
public Enfant(int ligne, int colonne, String nom, char orientation,ArrayList<String> instructions){ 
		
		this.ligne = ligne;
		this.colonne = colonne;
		this.nom = nom;
		this.orientation = orientation;
		this.instructions = instructions;
		this.p = new Panier();
	}
	
	
public Panier getPanier() {
	return p;
}


public void setPanier(Panier p) {
	this.p = p;
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


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public char getOrientation() {
		return orientation;
	}


	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}


	public ArrayList<String> getInstructions() {
		return instructions;
	}


	public void setInstructions(ArrayList<String> instructions) {
		this.instructions = instructions;
	}
	
	public void tournerAdroite() 
	{
		switch(this.getOrientation())
		{
		case 'N':this.setOrientation('E');break;
		case 'E':this.setOrientation('S');break;
		case 'O':this.setOrientation('N');break;
		case 'S':this.setOrientation('O');break;
		}
	}
	
	public void tournerAgauche() 
	{
		switch(this.getOrientation())
		{
		case 'N':this.setOrientation('O');break;
		case 'E':this.setOrientation('N');break;
		case 'O':this.setOrientation('S');break;
		case 'S':this.setOrientation('E');break;
		}
	}
	
	public void Avancer() 
	{
		switch(this.getOrientation())
		{
		case 'N':if(this.ligne>0)this.ligne--;break;
		case 'E':this.colonne++;break;
		case 'O':if(this.colonne>0)this.colonne--;break;
		case 'S':this.ligne++;break;
		}
	}
	
	public void Reculer() 
	{
		switch(this.getOrientation())
		{
		case 'N':this.ligne++;break;
		case 'E':if(this.colonne>0)this.colonne--;break;
		case 'O':this.colonne++;break;
		case 'S':if(this.ligne>0)this.ligne--;break;
		}
	}



	
}
