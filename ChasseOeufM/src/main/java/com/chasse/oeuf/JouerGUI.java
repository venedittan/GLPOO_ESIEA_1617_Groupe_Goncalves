package com.chasse.oeuf;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class JouerGUI extends JFrame{
	
	private JardinGUI jardinGUI;
	private ArrayList <Enfant> ge;
	
	private JPanel panC;
	
	private JLabel o1;
	private JLabel o2;
	private JLabel o3;
	private JLabel o4;
	
	private JLabel p1;
	private JLabel p2;
	private JLabel p3;
	private JLabel p4;

	public JouerGUI(){
		
		this.setMinimumSize(new Dimension(1300,700));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initialise();
		this.setVisible(true);
	}
	
	private void initialise(){
		Container c = getContentPane();
		
		try {
			Chocolat ch = new Chocolat("I:/GLPOO_ferreol/ChasseOeufM/src/main/java/Oeuf.txt");
			Rocher r = new Rocher("I:/GLPOO_ferreol/ChasseOeufM/src/main/java/Oeuf.txt");
			Enfant e = new Enfant("I:/GLPOO_ferreol/ChasseOeufM/src/main/java/Enfant.txt");
			Potion p = new Potion("I:/GLPOO_ferreol/ChasseOeufM/src/main/java/Oeuf.txt");
			jardinGUI = new JardinGUI("I:/GLPOO_ferreol/ChasseOeufM/src/main/java/Oeuf.txt",r,ch,e,p);
			
			jardinGUI.initJardinGUI();
			jardinGUI.placerRocherGUI();
			jardinGUI.placerChocolatGUI();
			jardinGUI.placerPotionGUI();
			//jardinGUI.placerEnfantGUI();
			
			ge = new ArrayList <Enfant>();
			ge = e.groupeEnfant();
			
			Thread t = new Thread(new DeplacementThreadGUI(ge, jardinGUI,this));
			t.start();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		c.add(this.creerPanelNord(),BorderLayout.NORTH);
		c.add(this.creerPanelOuest(),BorderLayout.WEST);
		c.add(this.creerPanelCentre(),BorderLayout.CENTER);
		c.add(this.creerPanelSud(),BorderLayout.SOUTH);
		
	}
	
	private JPanel creerPanelOuest() {
		JPanel panN = new JPanel(new GridLayout(1,4));
		return panN;
	}

	private JPanel  creerPanelNord() {

		JPanel panN=new JPanel();
		
		if(jardinGUI.nbrEnfant() > 3){
			panN = new JPanel(new GridLayout(1,2));
			
			JPanel panN3 = new JPanel(new FlowLayout());
			JPanel panN1 = new JPanel(new GridLayout(3,1));
			JLabel a = new JLabel(" Nom : "+jardinGUI.getE().groupeEnfant().get(0).getNom());
			o1 = new JLabel(" Oeuf : "+jardinGUI.getE().groupeEnfant().get(0).getP().getNbChocolat()+"\u2297");
			p1 = new JLabel(" Potion : "+jardinGUI.getE().groupeEnfant().get(0).getP().getNbPotion()+"\u2297");
			panN1.add(a);
			panN1.add(o1);
			panN1.add(p1);
			panN3.setBorder(BorderFactory.createTitledBorder(jardinGUI.getE().groupeEnfant().get(0).getPseudo()));
			panN3.add(panN1);
			
			JPanel panN4 = new JPanel(new FlowLayout());
			JPanel panN2 = new JPanel(new GridLayout(3,1));
			JLabel b = new JLabel(" Nom : "+jardinGUI.getE().groupeEnfant().get(1).getNom());
			o2 = new JLabel(" Oeuf : "+jardinGUI.getE().groupeEnfant().get(1).getP().getNbChocolat()+"\u2297");
			p2 = new JLabel(" Potion : "+jardinGUI.getE().groupeEnfant().get(1).getP().getNbPotion()+"\u2297");
			panN2.add(b);
			panN2.add(o2);
			panN2.add(p2);
			panN4.setBorder(BorderFactory.createTitledBorder(jardinGUI.getE().groupeEnfant().get(1).getPseudo()));
			panN4.add(panN2);
			
			panN.add(panN3);
			panN.add(panN4);
		}else{
			panN = new JPanel(new FlowLayout());
			JPanel panN1 = new JPanel(new GridLayout(2,1));
			JLabel a = new JLabel(" Nom : "+jardinGUI.getE().groupeEnfant().get(0).getNom());
			o1 = new JLabel(" Oeuf : "+jardinGUI.getE().groupeEnfant().get(0).getP().getNbChocolat()+"\u2297");
			p1 = new JLabel(" Potion : "+jardinGUI.getE().groupeEnfant().get(0).getP().getNbPotion()+"\u2297");
			panN1.add(a);
			panN1.add(o1);
			panN1.add(p1);
			panN.setBorder(BorderFactory.createTitledBorder(jardinGUI.getE().groupeEnfant().get(0).getPseudo()));
			panN.add(panN1);
		}
		
		return panN;
	}

	private JPanel  creerPanelCentre() {

		panC = jardinGUI.afficheJardinGUI();
		
		return panC;
	}
	
	private JPanel  creerPanelSud() {
		JPanel panS = new JPanel();
		
		if(jardinGUI.nbrEnfant() > 3){
			panS = new JPanel(new GridLayout(1,2));
			
			JPanel panN = new JPanel(new FlowLayout());
			JPanel panS1 = new JPanel(new GridLayout(3,1));
			JLabel a = new JLabel(" Nom : "+jardinGUI.getE().groupeEnfant().get(2).getNom());
			o3 = new JLabel(" Oeuf : "+jardinGUI.getE().groupeEnfant().get(2).getP().getNbChocolat()+"\u2297");
			p3 = new JLabel(" Postion : "+jardinGUI.getE().groupeEnfant().get(2).getP().getNbPotion()+"\u2297");
			panS1.add(a);
			panS1.add(o3);
			panS1.add(p3);
			panN.setBorder(BorderFactory.createTitledBorder(jardinGUI.getE().groupeEnfant().get(2).getPseudo()));
			panN.add(panS1);
			
			JPanel panN1 = new JPanel(new FlowLayout());
			JPanel panS2 = new JPanel(new GridLayout(3,1));
			JLabel b = new JLabel(" Nom : "+jardinGUI.getE().groupeEnfant().get(3).getNom());
			o4 = new JLabel(" Oeuf : "+jardinGUI.getE().groupeEnfant().get(3).getP().getNbChocolat()+"\u2297");
			p4 = new JLabel(" Position : "+jardinGUI.getE().groupeEnfant().get(3).getP().getNbPotion()+"\u2297");
			panS2.add(b);
			panS2.add(o4);
			panS2.add(p4);
			panN1.setBorder(BorderFactory.createTitledBorder(jardinGUI.getE().groupeEnfant().get(3).getPseudo()));
			panN1.add(panS2);
			
			panS.add(panN);
			panS.add(panN1);
		}else if(jardinGUI.nbrEnfant() > 2){
			
			JPanel panN = new JPanel(new FlowLayout());
			panS = new JPanel(new GridLayout(1,2));
			JPanel panS1 = new JPanel(new GridLayout(2,1));
			JLabel a = new JLabel(" Nom : "+jardinGUI.getE().groupeEnfant().get(1).getNom());
			o2 = new JLabel(" Oeuf : "+jardinGUI.getE().groupeEnfant().get(1).getP().getNbChocolat()+"\u2297");
			p2 = new JLabel(" Potion : "+jardinGUI.getE().groupeEnfant().get(1).getP().getNbPotion()+"\u2297");
			panS1.add(a);
			panS1.add(o2);
			panS1.add(p2);
			panN.setBorder(BorderFactory.createTitledBorder(jardinGUI.getE().groupeEnfant().get(1).getPseudo()));
			panN.add(panS1);
			
			JPanel panN1 = new JPanel(new FlowLayout());
			JPanel panS2 = new JPanel(new GridLayout(2,1));
			JLabel b = new JLabel(" Nom : "+jardinGUI.getE().groupeEnfant().get(2).getNom());
			o3 = new JLabel(" Oeuf : "+jardinGUI.getE().groupeEnfant().get(2).getP().getNbChocolat()+"\u2297");
			p3 = new JLabel(" Potion : "+jardinGUI.getE().groupeEnfant().get(2).getP().getNbPotion()+"\u2297");
			panS2.add(b);
			panS2.add(o3);
			panS2.add(p3);
			panN1.setBorder(BorderFactory.createTitledBorder(jardinGUI.getE().groupeEnfant().get(2).getPseudo()));
			panN1.add(panS2);
			
			panS.add(panN);
			panS.add(panN1);
		}else{
			panS = new JPanel(new FlowLayout());
			JPanel panS2 = new JPanel(new GridLayout(2,1));
			JLabel a = new JLabel(" Nom : "+jardinGUI.getE().groupeEnfant().get(1).getNom());
			o2 = new JLabel(" Oeuf : "+jardinGUI.getE().groupeEnfant().get(1).getP().getNbChocolat()+"\u2297");
			p2 = new JLabel(" Potion : "+jardinGUI.getE().groupeEnfant().get(1).getP().getNbPotion()+"\u2297");
			panS2.add(a);
			panS2.add(o2);
			panS2.add(p2);
			panS.setBorder(BorderFactory.createTitledBorder(jardinGUI.getE().groupeEnfant().get(1).getPseudo()));
			panS.add(panS2);
		}
		
		
		return panS;
	}
	

	public static void main(String[] args) {
		
		new JouerGUI();
	}

	public JardinGUI getJardinGUI() {
		return jardinGUI;
	}

	public void setJardinGUI(JardinGUI jardinGUI) {
		this.jardinGUI = jardinGUI;
	}

	public ArrayList<Enfant> getGe() {
		return ge;
	}

	public void setGe(ArrayList<Enfant> ge) {
		this.ge = ge;
	}

	public JPanel getPanC() {
		return panC;
	}

	public void setPanC(JPanel panC) {
		this.panC = panC;
	}
	
	public JLabel getO1() {
		return o1;
	}

	public void setO1(JLabel o1) {
		this.o1 = o1;
	}
	
	public JLabel getO2() {
		return o2;
	}

	public void setO2(JLabel o2) {
		this.o2 = o2;
	}

	public JLabel getO3() {
		return o3;
	}

	public void setO3(JLabel o3) {
		this.o3 = o3;
	}

	public JLabel getO4() {
		return o4;
	}

	public void setO4(JLabel o4) {
		this.o4 = o4;
	}

	public JLabel getP1() {
		return p1;
	}

	public void setP1(JLabel p1) {
		this.p1 = p1;
	}

	public JLabel getP2() {
		return p2;
	}

	public void setP2(JLabel p2) {
		this.p2 = p2;
	}

	public JLabel getP3() {
		return p3;
	}

	public void setP3(JLabel p3) {
		this.p3 = p3;
	}

	public JLabel getP4() {
		return p4;
	}

	public void setP4(JLabel p4) {
		this.p4 = p4;
	}

}
