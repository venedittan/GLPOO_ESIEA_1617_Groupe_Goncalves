package com.chasse.oeuf;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class EnfantSudPaintGUI extends JComponent {
	
	private static final long serialVersionUID = 1L;
	
	public EnfantSudPaintGUI() {
        this.setPreferredSize(new Dimension(40, 40));
        this.setVisible (true);
    }
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.fillPolygon(new int[] {10, 20, 30}, new int[] {20, 40, 20}, 3);
	}
}
