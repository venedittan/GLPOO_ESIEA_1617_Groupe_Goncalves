package IHM;

import static java.awt.BorderLayout.CENTER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

public class jardin extends JFrame{
	
	private JTable tableau;
	private int tableRow = 5;
	private int tableCollumn = 5;
	Random randomGen = new Random();
	ArrayList<String> c = new ArrayList<String>() {{
	    add("j");	//1
	    add("r");	//2
	    add("o");	//
	    add("2");	//3
	    add("j");	//4
	    add("j");	//5
	    add("j");	//6
	    add("j");	//7
	    add("j");	//8
	    add("o");	//
	    add("1");	//9
	    add("r");	//10
	    add("j");	//11
	    add("j");	//12
	    add("j");	//13
	    add("j");	//14
	    add("j");	//15
	    add("j");	//16
	    add("j");	//17
	    add("j");	//18
	    add("j");	//19
	    add("j");	//20
	    add("j");	//21
	    add("r");	//22
	    add("j");	//23
	    add("j");	//24
	    add("o");
	    add("5");	//25
	}};
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public jardin() {
		
		super();
		setTitle("Chasse aux oeufs");
		setPreferredSize(new Dimension(tableRow*100, tableCollumn*100));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JPanel pan = new JPanel (new GridLayout (tableRow,tableCollumn));
		Border blackline = BorderFactory.createLineBorder(Color.GRAY,1); 
		System.out.println(c.size());
		for(int i = 0; i<c.size();i++){
			JPanel ptest = new JPanel();
		   ptest.setBorder(blackline);
		   if(c.get(i).equals("r")){
			   ptest.setBackground(Color.black);
		   }
		   else if(c.get(i).equals("o"))
		   {
			   ptest.setBackground(Color.yellow);
			   JLabel n = new JLabel(c.get(i+1));
			   ptest.add(n);
			   i++;
		   }
		   
		   else if(c.get(i).equals("j")){
			   ptest.setBackground(Color.green);
		   }
		   pan.add(ptest);
		}
		pan.setBorder(blackline);
		this.add(pan);
		pack();
		System.out.println(c);
	}

}
 