package PANCHA;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.awt.Font;

//********************************************************************
//  Input_Panel.java  adopted from      Author: Lewis/Loftus
//
//Demonstrates the use of text fields.
//********************************************************************

public class Input_Panel extends JPanel {

	// -----------------------------------------------------------------
	// Constructor: Sets up the main GUI components.
	// -----------------------------------------------------------------
	String TIME_Entry, Longitude_Entry, Latitude_Entry;
	JLabel Time, Longitude_E, Latitude_E;
	JPanel mypanel_0;
	int x_0 = 30;
	int y_0 = 30;
	String Week_Day, Tithi;

	String[] type = { "Serif", "SansSerif", "Arial" };
	int[] styles = { Font.PLAIN, Font.ITALIC, Font.BOLD, Font.ITALIC + Font.BOLD };
	String[] stylenames = { "Plain", "Italic", "Bold", "Bold & Italic" };

	public Input_Panel(String Time_Entered, String Longitude, String Latitude, String WeekDay, String Thithi) {
		setLayout(new GridLayout(0, 6));
		// setLayout(new GridLayout(6,1));

		TIME_Entry = Time_Entered;
		Longitude_Entry = Longitude;
		Latitude_Entry = Latitude;

		Time = new JLabel(TIME_Entry);

		Longitude_E = new JLabel(Longitude_Entry);
		Latitude_E = new JLabel(Latitude_Entry);
		Week_Day = " Week Day:          " + WeekDay;
		
		Tithi = Thithi;

	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		Font font = new Font(type[2], styles[2], 14);
		int Line_Space = 20;
		page.setFont(font);
		page.setColor(Color.BLACK);
		page.drawString(TIME_Entry, x_0, y_0);
		page.drawString(Week_Day, x_0, y_0 + Line_Space );
		page.drawString(Longitude_Entry, x_0, y_0 + Line_Space * 2 );
		page.drawString(Latitude_Entry, x_0, y_0 + Line_Space * 3 );
		page.drawString(Tithi, x_0, y_0 + Line_Space * 4 );


	}

}

	      
	
	
	
	
	


