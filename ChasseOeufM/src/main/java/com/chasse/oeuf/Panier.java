package com.chasse.oeuf;

public class Panier {
	
	private int nbChocolat;
	private int nbBombe;
	private int nbPotion;
	
	public Panier(){
		this.nbChocolat = 0;
		this.nbBombe = 5;
		this.nbPotion = 3;
	}

	public int getNbChocolat() {
		return nbChocolat;
	}

	public void setNbChocolat(int nbChocolat){
		this.nbChocolat = nbChocolat;
	}

	public int getNbBombe() {
		return nbBombe;
	}

	public void setNbBombe(int nbBombe) {
		this.nbBombe = nbBombe;
	}

	public int getNbPotion() {
		return nbPotion;
	}

	public void setNbPotion(int nbPotion) {
		this.nbPotion = nbPotion;
	}

}
