package IHM;

import java.io.IOException;
import java.util.ArrayList;

public class Oeuf {
	private int ligne;
	private int colonne;
	private int nbr;
	
public Oeuf(int colonne,int ligne,  int nbr) throws IOException{
		this.ligne=ligne;
		this.colonne=colonne;
		this.nbr=nbr;
		
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

public int getNbr() {
	return nbr;
}

public void setNbr(int nbr) {
	this.nbr = nbr;
}

public void unOeufPris(){
	if(this.nbr > 0)
		this.setNbr(this.nbr - 1);
}
}
