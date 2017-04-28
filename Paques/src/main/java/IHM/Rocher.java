package IHM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Rocher {

	private int colonne;
	private int ligne;
	
public Rocher( int colonne, int ligne) throws IOException{
		
		this.colonne = colonne;
		this.ligne = ligne;
		
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

}
