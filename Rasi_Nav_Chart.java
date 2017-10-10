package PANCHA;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.*;

import javax.swing.JComponent;

public class Rasi_Nav_Chart extends JPanel {
	
	
	int Length = 70;
	int Width = 70;
	int x_Origin = 5;
	int y_Origin = 5;
	
	int x0, y0;
	
	
	
	
	
	String s = "box 1";
	   String s0 = "message 0";
	   String s1 = "message 1";
	   String s2 = "message 2";
	   String msg;
	   
	   int x = 10;
	   int y = 20;
	   
	   int [] Graha_House_Num;
	   int [] Navamsa_House_Num;
	   int HouseNum;
	   String [] Graha_Name = {"Lagna", "SUN", "MOON", "RAHU", "KETU", "MER", "VEN", "MARS", "JUP", "SAT"};
	   
	   String[] type = { "Serif","SansSerif"}; 
	   int[] styles = { Font.PLAIN, Font.ITALIC, Font.BOLD, Font.ITALIC + Font.BOLD };
	   String[] stylenames = { "Plain", "Italic", "Bold", "Bold & Italic" };
	   


	
	// Constructor
	
	public Rasi_Nav_Chart ( int [] Rasi_Nums, int [] Navamsa_Nums ){
		
		setBackground(Color.green);
		setPreferredSize(new Dimension ( 700,700 ));
		Graha_House_Num = Rasi_Nums;
		Navamsa_House_Num = Navamsa_Nums;
		
	}
	
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		for ( int Chart_Num = 0; Chart_Num < 2; Chart_Num++) {
			if ( Chart_Num == 1) {
				x_Origin += 10 + 4 * Width;
			}
		
			System.out.println( " Chart Num = " + Chart_Num + " x_Origin = " + x_Origin );
			
			if ( Chart_Num == 0 ) {
				msg = "RASI";
				Font font = new Font(type[1], styles[2], 18);
		        page.setFont(font); 
		        page.drawString( "RASI", x_Origin * 14 + Width , y_Origin * 15 + Length);
		        page.drawString( "NAVAMSA", x_Origin * 9 + Width * 5 , y_Origin * 15 + Length);
		        
			}
			if ( Chart_Num == 1 ) {
				msg = "NAVAMSA";
				Font font = new Font(type[1], styles[2], 18);
		        page.setFont(font); 
		        
		        page.drawString( "NAVAMSA", x_Origin * 12 + Width , y_Origin * 12 + Length);
			}
			
	        
	        
		for ( int i = 0; i < 12; i++ ) {
			
			if ( i <= 3 || i == 11 ) y0 = y_Origin;
			if ( i == 10 || i == 3 ) y0 = y_Origin + Length;
			if ( i == 9 || i == 4 ) y0 = y_Origin + Length * 2;
			if ( i >= 5 && i <= 8 ) y0 = y_Origin + Length * 3;
			
			
			
			if ( i >= 8 && i <= 11 ) x0 = x_Origin;
			if ( i == 0 || i == 7 ) x0 = x_Origin + Width;
			if ( i == 1 || i == 6 ) x0 = x_Origin + Width * 2;
			if ( i >= 2 && i <= 5 ) x0 = x_Origin + Width * 3;
			
			page.drawRect ( x0, y0, Length,Width );
			
			
			     
			x = x0 + 10;
			y = y0 + 10;
			int no_plns = 0;
			
				for ( int j = 0; j < 10; j++ ){
					if ( Chart_Num == 0 ) {
						 HouseNum = Graha_House_Num[j];
					}
					if ( Chart_Num == 1 ) {
						 HouseNum = Navamsa_House_Num[j];
					}
					
					if (  HouseNum == i ){
						s0 = Graha_Name [j];
						//y = y + no_plns * 10;
						y +=10;
						Font font1 = new Font(type[1], styles[0], 10);
				        page.setFont(font1); 
						page.drawString(s0, x, y);
						no_plns += 1;
						
					}  //if (  Graha_House_Num[j] == i )
					
				} // for ( int j = 0; j < 10; j++ )
				
			}  //   for ( int i = 0; i < 12; i++ ) {
		
		/*System.out.println( " Chart Num = " + Chart_Num + " x_Origin = " + x_Origin );
		if ( Chart_Num == 0 ) msg = "RASI";
		if ( Chart_Num == 1 )  msg = "NAVAMSA";
		Font font = new Font(type[1], styles[2], 18);
        page.setFont(font); 
        if ( Chart_Num == 0 ) page.drawString( "RASI", x_Origin * 12 + Width , y_Origin * 12 + Length);
        else if ( Chart_Num == 1 ) page.drawString( "NAVAMSA", x_Origin * 12 + Width , y_Origin * 12 + Length);  */
		
		}  //for ( int Chart_Num = 0; Chart_Num < 2; Chart_Num++) {
			
			
		}  //  public void paintComponent(Graphics page)
		
	
	
	

}
