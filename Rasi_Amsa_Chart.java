package PANCHA;



import java.awt.BasicStroke;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Rasi_Amsa_Chart  extends JPanel {

	int Length = 70;
	int Width = 70;
	int x_O = 5;
	int y_O = 5;
	int x_Origin, y_Origin;
	int x0, y0;
	int x_Title, y_Title;

	String s = "box 1";
	String s0 = "message 0";
	String s1 = "message 1";
	String s2 = "message 2";
	String msg;

	int x = 10;
	int y = 20;

	int[] Graha_House_Num;
	int[] Navamsa_House_Num;
	int[] Chaturthamsa_House_Num;
	int[] Dasamsa_House_Num;
	int[] Dwadasamsa_House_Num;
	int[] Trimsamsa_House_Num;
	int HouseNum;
	int Max_Chart_Num;
	// String [] Graha_Name = {"Lagna", "SUN", "MOON", "RAHU", "KETU", "MER",
	// "VEN", "MARS", "JUP", "SAT"};
	String[] Graha_Name = new String[10];

	String[] type = { "Serif", "SansSerif", "Arial" };
	int[] styles = { Font.PLAIN, Font.ITALIC, Font.BOLD, Font.ITALIC + Font.BOLD };
	String[] stylenames = { "Plain", "Italic", "Bold", "Bold & Italic" };
	String[] Amsa_Name = { "RASI", "NAVAMSA", "CHATURTHAMSA", "DASAMSA", "DWADASAMSA", "TRIMSAMSA" };

	// Constructor

	public Rasi_Amsa_Chart (String[] Graha_Abr, int[] Rasi_Nums, int[] Navamsa_Nums) {

		Graha_Name = Graha_Abr;
		setBackground(Color.green);
		setPreferredSize(new Dimension(1200, 900));
		Graha_House_Num = Rasi_Nums;
		Navamsa_House_Num = Navamsa_Nums;
		Max_Chart_Num = 2;
	}

	public Rasi_Amsa_Chart (String[] Graha_Abr, int[] Rasi_Nums, int[] Navamsa_Nums, int[] Chaturthamsa_Nums) {

		Graha_Name = Graha_Abr;

		setBackground(Color.green);
		setPreferredSize(new Dimension(900, 900));
		Graha_House_Num = Rasi_Nums;
		Navamsa_House_Num = Navamsa_Nums;
		Chaturthamsa_House_Num = Chaturthamsa_Nums;
		Max_Chart_Num = 3;
	}

	public Rasi_Amsa_Chart (String[] Graha_Abr, int[] Rasi_Nums, int[] Navamsa_Nums, int[] Chaturthamsa_Nums,
			int[] Dasamsa_Nums, int[] Dwadasamsa_Nums, int[]Trimsamsa_Nums) {

		Graha_Name = Graha_Abr;

		//setBackground(Color.getHSBColor(200, 40, 200));
		
		//setBackground(new Color(230, 230, 230));
		setBackground(new Color(0,0,0,0));
		
		
		setPreferredSize(new Dimension(1500, 900));
		Graha_House_Num = Rasi_Nums;
		Navamsa_House_Num = Navamsa_Nums;
		Chaturthamsa_House_Num = Chaturthamsa_Nums;
		Dasamsa_House_Num = Dasamsa_Nums;
		Dwadasamsa_House_Num = Dwadasamsa_Nums;
		Trimsamsa_House_Num = Trimsamsa_Nums;
		
		Max_Chart_Num = 6;
	}

	double thickness = 2;

	public void paintComponent(Graphics page) {
		super.paintComponent(page);

		for (int Chart_Num = 0; Chart_Num < Max_Chart_Num; Chart_Num++) {

			x_Title = 10 + 4 * (Width + 6) * (int) (Chart_Num % 3) + Width;
			y_Title = 80 + 4 * Length * (int) (Chart_Num / 3) + Length;
			
			if (Chart_Num == 2) x_Title = 10 + 4 * (Width + 3) * (int) (Chart_Num % 3) + Width;
			
			Font font = new Font(type[1], styles[2], 12);
			page.setFont(font);
			page.setColor(Color.BLACK);

			System.out.println(" x_Title = " + x_Title + " y_Title = " + y_Title + " Chart_Num = " + Chart_Num);

			msg = Amsa_Name[Chart_Num];
			page.drawString(msg, x_Title, y_Title);

			x_Origin = x_O + 4 * (Width + 3) * (int) (Chart_Num % 3);
			y_Origin = y_O + 4 * (Length + 3) * (int) (Chart_Num / 3);

			for (int i = 0; i < 12; i++) {

				if (i <= 3 || i == 11)
					y0 = y_Origin;
				if (i == 10 || i == 3)
					y0 = y_Origin + Length;
				if (i == 9 || i == 4)
					y0 = y_Origin + Length * 2;
				if (i >= 5 && i <= 8)
					y0 = y_Origin + Length * 3;

				if (i >= 8 && i <= 11)
					x0 = x_Origin;
				if (i == 0 || i == 7)
					x0 = x_Origin + Width;
				if (i == 1 || i == 6)
					x0 = x_Origin + Width * 2;
				if (i >= 2 && i <= 5)
					x0 = x_Origin + Width * 3;

				Graphics2D g2 = (Graphics2D) page;
				g2.setStroke(new BasicStroke(2));
				// g2.draw(new Line2D.Float(30, 20, 80, 90));

				page.setColor(Color.RED);
				page.drawRect(x0, y0, Length, Width);

				x = x0 + 10;
				y = y0 + 10;
				int no_plns = 0;

				for (int j = 0; j < 10; j++) {
					if (Chart_Num == 0) {
						HouseNum = Graha_House_Num[j];
					}
					if (Chart_Num == 1) {
						HouseNum = Navamsa_House_Num[j];
					}
					if (Chart_Num == 2) {
						HouseNum = Chaturthamsa_House_Num[j];
					}
					if (Chart_Num == 3) {
						HouseNum = Dasamsa_House_Num[j];
					}
					if (Chart_Num == 4) {
						HouseNum = Dwadasamsa_House_Num[j];
					}
					
					if (Chart_Num == 5) {
						HouseNum = Trimsamsa_House_Num[j];
					}

					if (HouseNum == i) {
						s0 = Graha_Name[j];
						// y = y + no_plns * 10;
						y += 10;
						Font font1 = new Font(type[1], styles[0], 12);
						page.setFont(font1);
						page.setColor(Color.BLACK);
						page.drawString(s0, x, y);
						no_plns += 1;

					} // if ( Graha_House_Num[j] == i )

				} // for ( int j = 0; j < 10; j++ )

			} // for ( int i = 0; i < 12; i++ ) {
			page.setColor(Color.red);
			page.drawRect(x_Origin - 3, y_Origin - 3, Length * 4 + 6, Width * 4 + 6);

		} // for ( int Chart_Num = 0; Chart_Num < 2; Chart_Num++) {

	} // public void paintComponent(Graphics page)
	
	

	

}
