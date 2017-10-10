package PANCHA;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.SwingConstants;

import java.awt.geom.Line2D;

import java.awt.geom.Line2D;

public class Transit extends JPanel implements ActionListener {

	// -----------------------------------------------------------------
	// Constructor: Sets up the main GUI components.
	// -----------------------------------------------------------------
	String DATE_Entry, TIME_Entry, Longitude_Entry, Latitude_Entry;
	JLabel Date, Time, Longitude_E, Latitude_E;
	JPanel mypanel_0;
	int x_0 = 30;
	int y_0 = 30;

	String[] type = { "Serif", "SansSerif", "Arial" };
	int[] styles = { Font.PLAIN, Font.ITALIC, Font.BOLD, Font.ITALIC + Font.BOLD };
	String[] stylenames = { "Plain", "Italic", "Bold", "Bold & Italic" };

	String YEAR_INPUT, MONTH_INPUT, DAY_INPUT, HOUR_INPUT, MINUTE_INPUT;
	String Long_Deg, Long_Min, Long_Sec, E_W;
	String Lat_Deg, Lat_Min, Lat_Sec, N_S;

	private JLabel Longitude, Latitude; // Labels for longitude and latitude
	private JLabel Deg_Min_Sec;
	private JLabel Deg_Label, Min_Label, Sec_Label;
	private JLabel Deg_Lab_Lat, Min_Lab_Lat, Sec_Lab_Lat;
	private JTextField Deg_Lon, Min_Lon, Sec_Lon;
	private JTextField Deg_Lat, Min_Lat, Sec_Lat;
	

	private JLabel YearLabel, MonthLabel, DayLabel, HourLabel, MinuteLabel, Month_Select_Label, AMPM_Label,
			TimeZone_Label, blankLabel;

	JComboBox Mon_Lists;
	int Month_Num;

	String[] Month_Names = new String[] { "Select Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
			"Oct", "Nov", "Dec" };

	private int Long_Deg_Num, Long_Min_Num, Long_Sec_Num;
	private JLabel Deg_Min_Sec_Lat;
	private JLabel Line_Sep;
	private JLabel bridgeSet;
	private JLabel Line_0, Line_1, Line_2;
	private JLabel E_W_1_Label;
	private JLabel Nat_Tran_Label;

	private JTextField YearTextField, MonthTextField, DayTextField, HourTextField, MinuteTextField;

	private JTextField HourTextField2, MinuteTextField2;
	String[] East_or_West = new String[] { "E", "W" };
	String[] North_or_South = new String[] { "N", "W" };
	int E_W_Index_Local, E_W_Index, N_S_Index_Local, N_S_Index;

	public static final int ROWS = 2;
	public static final int COLS = 3;
	private JPanel flowLayoutPanel;
	private JPanel gridLayoutPanel;

	private JPanel myPanel_1, myPanel_2, my_Panel_3, myPanel_4;

	private JTextField[][] flowFields;
	private JTextField[][] gridFields;

	JButton Nat_Btn, Transit_Btn;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private JLabel Space_0, Space_1, Space_2;
	private String Lati_Deg, Lati_Min, Lati_Sec;
	private int Lati_Deg_Num, Lati_Min_Num, Lati_Sec_Num;

	String[] AMPM_INPUT = new String[] { "AM or PM?", "AM", "PM" };
	JComboBox AM_or_PM;
	
	JComboBox East_West_0, North_South_0, East_West_1;

	
	
	String AMPM_Selected;
	int AM_PM_Num;

	int IAMPM;
	String AM_PM;
	int IHT, MINT; // Time Zone hours [IHT] Minutes [MINT]
	double ELNGT, ELTD;

	int x_Origin = 800;
	int y_Origin = 400;
	int Length = 200;
	int Width = 200;
	String S_0 = "INPUT";

	boolean show_Natal = false, show_Transit = false;

	// private DrawStuff drawPanel = new DrawStuff();
	
	
	
	String E_Transit[][], E_Natal[][];
	String[] Graha_Name = { "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", " Neptune" };
	String[] Graha_Abr = { "Lagna", "SUN", "MOON", "RAHU", "KETU", "MER", "VEN", "MARS", "JUP", "SAT" };

	String[] Out_Rasi = new String[8];

	static String[][] OUT_DEG_Natal = new String[6][10];
	static int[] Graha_Rasi_Num_Natal = new int[12];
	static int[] Navamsa_Num_Natal = new int[12];
	static int[] Chatur_Num_Natal = new int[12];
	int[] Dasamsa_Num_Natal = new int[12];
	int[] Dwadasamsa_Num_Natal = new int[12];
	int[] Trimsamsa_Num_Natal = new int[12];
	String[] Planet_Name_Natal = { "Lagna", "SUN", "MOON", "RAHU", "KETU", "MER", "VEN", "MARS", "JUP", "SAT" };


	static String[][] OUT_DEG_Transit = new String[6][10];
	static int[] Graha_Rasi_Num_Transit = new int[12];
	static int[] Navamsa_Num_Transit = new int[12];
	static int[] Chatur_Num_Transit = new int[12];
	int[] Dasamsa_Num_Transit = new int[12];
	int[] Dwadasamsa_Num_Transit = new int[12];
	int[] Trimsamsa_Num_Transit = new int[12];

	

	public Transit(String Year_In, String Month_In, String Day_In, String Hour_In, String Minute_In, String AMPM,
			String Deg_Long, String Min_Long, String Sec_Long, String East_West, String Deg_Lati, String Min_Lati,
			String Sec_Lati, String North_South) {
		setLayout(new GridLayout(0, 6));
		// setBackground(new Color(0,0,0,0));

		setBackground(new Color(230, 230, 230));

		setBackground(Color.WHITE);
		// addMouseListener((MouseListener) this);
		// addMouseMotionListener((MouseMotionListener) this);
		// setLayout(new GridLayout(6,1));

		System.out.println(" Transit INPUT " + Year_In + "  " + Month_In + "   " + Day_In);
		Month_Num = Integer.parseInt(Month_In);

		YEAR_INPUT = Year_In;
		MONTH_INPUT = Month_In;
		DAY_INPUT = Day_In;
		HOUR_INPUT = Hour_In;
		MINUTE_INPUT = Minute_In;
		AM_PM = AMPM;

		Long_Deg = Deg_Long;
		Long_Min = Min_Long;
		Long_Sec = Sec_Long;
		E_W = East_West;

		Lat_Deg = Deg_Lati;
		Lat_Min = Min_Lati;
		Lat_Sec = Sec_Lati;
		N_S = North_South;

		DATE_Entry = "  " + YEAR_INPUT + "-" + Month_Num + "-" + DAY_INPUT;
		TIME_Entry = "  " + HOUR_INPUT + "-" + MINUTE_INPUT + "-" + AM_PM;
		Longitude_Entry = Long_Deg + "°" + E_W + " " + Long_Min + "' " + Long_Sec + '"';
		;
		Latitude_Entry = Lat_Deg + "°" + N_S + " " + Lat_Min + "' " + Lat_Sec + '"';
		;

		Date = new JLabel(DATE_Entry);

		Longitude_E = new JLabel(Longitude_Entry);
		Latitude_E = new JLabel(Latitude_Entry);

		YearLabel = new JLabel(" Time [Local]     YEAR                                     Month ");

		MonthLabel = new JLabel(" MO: ");
		DayLabel = new JLabel("    DAY: ");
		HourLabel = new JLabel(" HOUR:     ");
		MinuteLabel = new JLabel("      MINUTE:     ");
		Month_Select_Label = new JLabel("        Select Month:    ");
		AMPM_Label = new JLabel(" AM or PM ? [Select]:  ");
		TimeZone_Label = new JLabel("                      Local Time Zone ");

		Mon_Lists = new JComboBox(Month_Names); // Drop down ComboBox for Month
										// Selection

		Deg_Min_Sec = new JLabel("   Degree            Minute       Second       ");
		Deg_Label = new JLabel(" Deg. ");
		Min_Label = new JLabel(" Min. ");
		Sec_Label = new JLabel(" Sec. ");
		blankLabel = new JLabel("  ");

		JPanel myPanel_0 = new JPanel();
		myPanel_0.setLocation(20, 20);
		myPanel_0.setSize(40, 80);
		add(myPanel_0);
		JLabel lblWelcome = new JLabel("Transit Calculations");
		myPanel_0.add(lblWelcome);
		// myPanel_0.setBackground(new Color(0,0,0,65));
		myPanel_0.setBackground(new Color(230, 230, 230));

		YearTextField = new JTextField(YEAR_INPUT, 5);
		MonthTextField = new JTextField(MONTH_INPUT, 5);
		DayTextField = new JTextField(DAY_INPUT, 5);

		// Mon_Lists = new JComboBox(Month_Names); // Drop down ComboBox for
		// Month

		DayTextField = new JTextField(DAY_INPUT, 5);
		HourTextField = new JTextField(HOUR_INPUT, 3);
		MinuteTextField = new JTextField(MINUTE_INPUT, 3);

		// YEAR_INPUT = YearTextField.getText();

		// YearTextField.setBounds(300, 300, 200, 40);
		// MonthTextField = new JTextField ( UTCMonth, 5);
		// JPanel myPanel = new JPanel();
		// add(myPanel);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(1, 1, 1, 1);

		// gbc.gridy++;
		// gbc.fill = GridBagConstraints.HORIZONTAL;
		// myPanel.add(lblWelcome);

		JLabel Nat_Tran_Label = new JLabel("         Press one of the two below                        ");
		// myPanel_0.add(Nat_Tran_Label);

		JButton Nat_Btn = new JButton("Natal");
		JButton Transit_Btn = new JButton("Transit");
		// Nat_Btn.setActionCommand("First");
		// Transit_Btn.setActionCommand("Second");

		// Nat_Btn.addActionListener((ActionListener) this);
		// Transit_Btn.addActionListener((ActionListener) this);

		// DrawStuff drawPanel = new DrawStuff();

		// add(drawPanel);
		// drawPanel.add(Nat_Tran_Label);
		// drawPanel.add(Nat_Btn);
		// drawPanel.add(Transit_Btn);
		JPanel myPanel_1 = new JPanel();
		// add(myPanel_1);
		myPanel_1.setLocation(200, 80);
		myPanel_1.setSize(1200, 1200);

		Nat_Btn.addActionListener(this);
		Transit_Btn.addActionListener(this);
		myPanel_0.add(Nat_Tran_Label);

		Nat_Btn.setActionCommand("First");
		Transit_Btn.setActionCommand("Second");

		myPanel_0.add(Nat_Btn);
		myPanel_0.add(Transit_Btn);

		myPanel_0.add(YearLabel);
		// YearLabel.setLocation(27, 20);

		myPanel_0.add(blankLabel);

		myPanel_0.add(YearTextField);

		myPanel_0.add(Mon_Lists);
		Mon_Lists.setSelectedIndex(Month_Num);
		// myPanel_0.add(MonthTextField);

		// _________http://stackoverflow.com/questions/41475669/adding-multiple-sets-of-jlabel-and-jtextbox-to-the-same-line-in-java_

		JPanel myPanel_2 = new JPanel();
		// add(myPanel_2);

		myPanel_0.add(blankLabel);

		myPanel_0.add(blankLabel);
		JLabel HourLabel = new JLabel(
				"       Hour         Minutes                AM_PM                       " + System.lineSeparator());

		myPanel_0.add(HourLabel);

		JPanel myPanel_3 = new JPanel();
		// add(myPanel_3);

		myPanel_0.add(HourTextField);
		myPanel_0.add(MinuteTextField);

		AM_or_PM = new JComboBox(AMPM_INPUT); // Drop down ComboBox for Month

		IAMPM = 1;
		if (AM_PM == "PM")
			IAMPM = 2;

		myPanel_0.add(AM_or_PM);
		AM_or_PM.setSelectedIndex(IAMPM);
		
		Deg_Label = new JLabel(" Deg. ");
		Min_Label = new JLabel(" Min. ");
		Sec_Label = new JLabel(" Sec. ");

		Space_0 = new JLabel("<html>_____________________________________________________________<br/>"
				+ "                   _____________________________________________________________ ");
		Longitude = new JLabel(System.lineSeparator() + "                          Longitude:                                                 ");

		Latitude = new JLabel(System.lineSeparator() + "                             Latitude:                                                  ");


		Deg_Lon = new JTextField("78", 3);
		Min_Lon = new JTextField("52", 3);
		Sec_Lon = new JTextField("43", 3);

		Deg_Lat = new JTextField("42", 3);
		Min_Lat = new JTextField("53", 3);
		Sec_Lat = new JTextField("11", 3);
		Deg_Min_Sec_Lat = new JLabel(
				"                                                                                                  Deg.                          Min.   Sec.        ");
		Deg_Lab_Lat = new JLabel(" Deg. ");
		Min_Lab_Lat = new JLabel(" Min. ");
		Sec_Lab_Lat = new JLabel(" Sec. ");

		//add(myPanel_2);

		myPanel_0.add(Longitude);
		// gbc.gridx = 0;
		// gbc.gridy++;
		myPanel_0.add(Deg_Label);
		myPanel_0.add(Deg_Lon);

		Deg_Lon.setBounds(100, 100, 200, 40);
		East_West_0 = new JComboBox(East_or_West);

		myPanel_0.add(East_West_0);
		E_W_Index_Local = 1;
		East_West_0.setSelectedIndex(E_W_Index_Local); // Set the index "W" for
		myPanel_0.add(Min_Label);
		myPanel_0.add(Min_Lon);
		myPanel_0.add(Sec_Label);
		myPanel_0.add(Sec_Lon);
			
		myPanel_0.add(Latitude);
		myPanel_0.add(Deg_Lab_Lat);
		myPanel_0.add(Deg_Lat);
		North_South_0 = new JComboBox(North_or_South);
		N_S_Index_Local = 0;
		North_South_0.setSelectedIndex(0); 	// Set the index "N" for Buffalo
											// Buffalo
		
		myPanel_0.add(North_South_0);
		myPanel_0.add(Min_Lab_Lat);

		myPanel_0.add(Min_Lat);
		myPanel_0.add(Sec_Lab_Lat);
		myPanel_0.add(Sec_Lat);


		

	}

	// @Override

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object source = e.getSource();
		String choice = e.getActionCommand();
		show_Natal = false;
		show_Transit = false;

		// if (e.getSource() == Nat_Btn) {
		if (choice == "First") {
			show_Natal = true;

			// } else if (e.getSource() == Transit_Btn) {
		} else if (choice == "Second") {
			show_Transit = true;

		}

		revalidate();
		repaint();
		System.out.println(" From ActionListener S_0 = " + S_0 + " show_Natal = " + show_Natal + " show_Transit = "
				+ show_Transit);
		System.out.println(" SOURCE = " + choice);

	}

	protected void paintComponent(Graphics g2) {
		// super.paintComponent(page);

		// setLayout(null);

		// JPanel myPanel = new JPanel();
		// add(myPanel);
		// myPanel.setBackground(new Color(0,0,0,5));

		// Graphics2D g2 = (Graphics2D) page;
		// g2.setStroke(new BasicStroke(2));

		int x_0 = x_Origin - 100;
		int y_0 = 10;

		// g2.drawRect(x_0, y_0, Length, Width);

		// g2.drawRect(x_0, y_0, getSize().width,getSize().height);

		g2.setColor(Color.RED);

		int x = x_0 + 20;
		int y = y_0 + 20;

		// g2.drawRect(x_Origin - 3, y_Origin - 3, Length, Width);
		// g2.setColor(Color.RED);

		// g2.fillRect(0,0,getSize().width,getSize().height);

		if (show_Natal) {
			S_0 = "NATAL";
			// g2.drawRect(x_Origin - 3, y_Origin - 3, Length, Width);
			g2.setColor(Color.RED);

		}
		if (show_Transit) {
			S_0 = "TRANSIT";

		}

		System.out.println(" S_0 = " + S_0 + " show_Natal = " + show_Natal + " show_Transit = " + show_Transit);

		Graphics2D g1 = (Graphics2D) g2;
		g1.drawRect(x_0, y_0, Length, Width);

		g2.drawString(S_0, x, y);

		System.out.println(" From Transit " + DATE_Entry);
		System.out.println(" From Transit " + TIME_Entry);
		System.out.println(" From Transit " + Longitude_Entry);
		System.out.println(" From Transit " + Latitude_Entry);

	}

}