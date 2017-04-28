package com.chasse.oeuf;
import java.awt.*;
import java.util.*;
import javax.swing.*;


public class EnfantNordPaintGUI extends JComponent {
	
	private static final long serialVersionUID = 1L;
	
	public EnfantNordPaintGUI() {
        this.setPreferredSize(new Dimension(40, 40));
        this.setVisible (true);
    }
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		/*if(e.getNumJ() == 0){
			g.setColor(Color.BLUE);
		}else if(e.getNumJ() == 1){
			g.setColor(Color.BLACK);
		}else if(e.getNumJ() == 2){
			g.setColor(Color.RED);
		}else if(e.getNumJ() == 3){
			g.setColor(Color.GRAY);
		}
		
		if( e.getOrientation() == 'E'){
			g.fillPolygon(new int[] {20, 40, 20}, new int[] {20, 30, 40}, 3);
		}else if(e.getOrientation() == 'O'){
			g.fillPolygon(new int[] {40, 20, 40}, new int[] {20, 30, 40}, 3);
		}else if(e.getOrientation() == 'N'){
			g.fillPolygon(new int[] {10, 20, 30}, new int[] {20, 40, 20}, 3);
		}else if(e.getOrientation() == 'S'){
			g.fillPolygon(new int[] {10, 20, 30}, new int[] {40, 20, 40}, 3);
		}*/
		g.fillPolygon(new int[] {10, 20, 30}, new int[] {40, 20, 40}, 3);

	}
	

}
