package IHM;

public class Panier {
	private int nbOeuf;
	
	public Panier(){
		this.nbOeuf = 0;
	}

	public int getNbOeuf() {
		return nbOeuf;
	}

	public void setNbOeuf(int nbOeuf){
		this.nbOeuf = nbOeuf;
	}

	public void ajouterUnOeuf()
	{
		this.setNbOeuf(this.nbOeuf + 1);
	}
}
