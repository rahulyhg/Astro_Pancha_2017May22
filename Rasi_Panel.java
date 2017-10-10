package PANCHA;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class Rasi_Panel extends JPanel {
	
	private JLabel InputLabel, Line_Sep_Label, RasiLabel;
	private JLabel RasiLabel2;
	private JLabel Entry_Label[];
	private JTextField RasiText;
	String TIME_LABEL;
	
	int Length = 70;
	int Width = 70;
	
	String Entry[][];
	
	int x_0 = 10;
	   int y_0 = 80;
	   int x_L, y_L, x;
	   
	   String[] type = { "Serif", "SansSerif", "Arial" };
		int[] styles = { Font.PLAIN, Font.ITALIC, Font.BOLD, Font.ITALIC + Font.BOLD };
		String[] stylenames = { "Plain", "Italic", "Bold", "Bold & Italic" };
		
		String Rasi_Data;
		String header = "  Body                 Longitude               Nakshatra                    Pada                    Rasi                 Navamsa  ";
	   
	//-----------------------------------------------------------------------
	// Constructor: Sets up the main GUI components. 
	//-----------------------------------------------------------------------
	
	public Rasi_Panel( String OUT_DEG [][], String Time_Entered )  { 
		setLayout(new GridLayout(0,6));
		//setLayout(new GridLayout(6,1));
		
		Entry = OUT_DEG;
		TIME_LABEL = Time_Entered;
		
		setBackground(Color.getHSBColor(212,204,204));
		//setBackground(Color.lightGray);
	    
	}
	
	public void input_info(){
		
		add (new JLabel( " TIME "));
		add (new JLabel ( "      "));
		add (new JLabel( TIME_LABEL ));   
		add (new JLabel ( "      "));
		add (new JLabel ( "      "));
		add (new JLabel ( "      "));
		


	}
	
	public void Head_Fill() {
		setBackground(Color.gray);
		
		
		Line_Sep_Label = new JLabel(System.lineSeparator());
		add(Line_Sep_Label);
		//setLayout(new GridLayout(0,3));
		
		JButton b1 = new JButton("Body");
		JButton b2 = new JButton("Longitude");
		JButton b3 = new JButton("Nakshatra");
		JButton b4 = new JButton("Pada");
		JButton b5 = new JButton("Rasi");
		JButton b6 = new JButton("Navamsa");
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
	}
	  public void Grid_Fill(){
		
		
		//InputLabel = new JLabel("       Body           Longitude  " +  "\n" + System.lineSeparator() );
		
		
		int Width = 100;

		String [] Headings = {"Body",  "Longitude", "Nakshatra", "Pada", "Rasi", "Navamsa"};
		int x0 = 5;
	
		//add(Line_Sep_Label);
		RasiText = new JTextField(6);
		
		//add(InputLabel);
		//add(RasiText);
		//add(Line_Sep_Label);
		//RasiLabel = new JLabel( System.lineSeparator()  );
		//add(RasiLabel);
		//RasiLabel2 = new JLabel(  "\n" + Out_Label  );
		//add(RasiLabel2);
		

		
		
		for (int i = 0; i < 10; i++)
			//for (int j = 0; j < 3; j++)	
			for (int j = 0; j < 6; j++)							
				add (new JLabel( Entry[j][i]));
				
		
		
		//add (new JLabel("Lagna"));
		//add (new JLabel("24  Le  11  Min    23 Sec"));
		setPreferredSize(new Dimension(800, 450));
		setBackground(Color.yellow);
		
		
		
	}    //   public void Grid_Fill()
	  
	  public void paintComponent(Graphics page) {
			super.paintComponent(page);
			
			
			Font font = new Font(type[2], styles[2], 14);
			page.setFont(font);
			page.setColor(Color.BLACK);
			page.drawString(header, 10, 10);
			
			for (int i = 0; i < 10; i++){
				Rasi_Data = "";
				y_L = y_0 + i * 50;
				
				for (int j = 0; j < 6; j++)	{
					Rasi_Data += Entry[j][i] + "\t\t\t\t\t\t";	
					
					
					
					x = x_L + j * 130;
					
					Font font1 = new Font(type[2], styles[2], 12);
					page.setFont(font1);
					page.setColor(Color.BLACK);
					page.drawString(Entry[j][i], x, y_L);
					
				}                                                 //for (int j = 0; j < 6; j++
				y_L = y_0 + i * 50;
				
				Font font1 = new Font(type[2], styles[2], 12);
				page.setFont(font1);
				page.setColor(Color.BLACK);
				//page.drawString(Rasi_Data, x_L, y_L);
			}                                                        //for (int i = 0; i < 10; i++){
						
			
	  }     // public void paintComponent(Graphics page) 
	  	
		
	}
		
		
	
	
	


