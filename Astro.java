package PANCHA;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.LocalTime;
import java.time.Clock;
import java.util.TimeZone;
import java.util.ArrayList;

public class Astro extends JPanel implements ActionListener {

	private static final String String = null;

	// private static final int[] Chaturthamsa = null;

	private JLabel YearLabel, MonthLabel, DayLabel, HourLabel, MinuteLabel;
	private JLabel HourLabel2, MinuteLabel2;
	private JTextField YearTextField, MonthTextField, DayTextField, HourTextField, MinuteTextField;

	private JTextField HourTextField2, MinuteTextField2;

	private static String Time_Entry, Longitude_Entry, Latitude_Entry;

	private String UTCYear, UTCMonth, UTCDay, UTCHour, UTCMinute, UTCSecond, UTCAMPM, HourZone, MinuteZone;

	private JLabel Longitude, Latitude; // Labels for longitude and latitude
	private JLabel Deg_Min_Sec;
	private JLabel Deg_Label, Min_Label, Sec_Label;
	private JLabel Deg_Lab_Lat, Min_Lab_Lat, Sec_Lab_Lat;
	private JTextField Deg_Lon, Min_Lon, Sec_Lon;
	private String Long_Deg, Long_Min, Long_Sec;
	private int Long_Deg_Num, Long_Min_Num, Long_Sec_Num;
	private JLabel Deg_Min_Sec_Lat;
	private JLabel Line_Sep;
	private JLabel bridgeSet;
	private JLabel Line_0, Line_1, Line_2;
	private JLabel E_W_1_Label;

	private JLabel Space_0, Space_1, Space_2;
	private JTextField Deg_Lat, Min_Lat, Sec_Lat;
	private String Lati_Deg, Lati_Min, Lati_Sec;
	private int Lati_Deg_Num, Lati_Min_Num, Lati_Sec_Num;

	String Hour_Dif_Local, Min_Dif_Local, E_W_Local;

	private JLabel num1_Label, num2_Label;
	private JTextField num1_Text, num2_Text;

	JButton entbtn;
	String Input_Str;
	String data;
	int num1 = 27, num2;
	String YEAR_INPUT, MONTH_INPUT, DAY_INPUT, HOUR_INPUT, MINUTE_INPUT, data1, data2;
	int YEAR_IN, MONTH_IN, DAY_IN, HOUR_IN, MINUTE_IN;
	int E_W_Index_Local, E_W_Index, N_S_Index_Local, N_S_Index;

	private JLabel Month_Select_Label;
	int Month_Num;
	String[] Month_Names = new String[] { "Select Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
			"Oct", "Nov", "Dec" };

	String[] Nakshatras = new String[] { "Aswi", "Bhar", "Krit", "Rohi", "Mrig", "Ardr", "Puna", "Push", "Asle", "Magh",
			"PPha", "UPha", "Hast", "Chit", "Swat", "Visa", "Anu", "Jye", "Mool", "PSha", "USha", "Srav", "Dhan",
			"Sata", "PBha", "UBha", "Reva" };
	String[] East_or_West = new String[] { "E", "W" };
	String[] North_or_South = new String[] { "N", "S" };
	String Thithi;

	JComboBox Mon_Lists;
	String Mon_Selected;
	int Mon_Num;

	private JLabel AMPM_Label;
	private JLabel TimeZone_Label;
	String[] AMPM_INPUT = new String[] { "AM or PM?", "AM", "PM" };
	JComboBox AM_or_PM;
	String AMPM_Selected;
	int AM_PM_Num;

	JComboBox East_West, North_South, East_West_1;

	double[] AJ = new double[4];
	double[] EIJ = new double[4];
	double[] EJ = new double[4];
	double[] PIJ = new double[4];
	double[] OIJ = new double[4];
	double[] EPLN = new double[8];
	double[] EMJ = new double[4];

	double[] AJSUN = { 279.69668, 36000.76892, 0.0003025 };

	String[] Graha_Name = { "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", " Neptune" };
	String[] Graha_Abr = { "Lagna", "SUN", "MOON", "RAHU", "KETU", "MER", "VEN", "MARS", "JUP", "SAT" };

	String[] Out_Rasi = new String[8];

	static String[][] OUT_DEG = new String[6][10];
	static int[] Graha_Rasi_Num = new int[12];
	static int[] Navamsa_Num = new int[12];
	static int[] Chatur_Num = new int[12];
	int[] Dasamsa_Num = new int[12];
	int[] Dwadasamsa_Num = new int[12];
	int[] Trimsamsa_Num = new int[12];
	String[] Planet_Name = { "Lagna", "SUN", "MOON", "RAHU", "KETU", "MER", "VEN", "MARS", "JUP", "SAT" };

	double ASCND;
	double Sun_Sayana, Sun_Nir, Sun_Rad;
	double Sun_Sayana_Plus;

	String[] RASIS = { "Ar", "Ta", "Ge", "Cn", "Le", "Vi", "Li", "Sc", "Sa", "Cp", "Aq", "Pi" };
	String E_W, N_S; // Time ZOne East [E] or West [W] of Greenwich. - N_S
						// Latitude north or south of equator
	String WEEKDY, WEEKD0;
	int IYEAR;
	int MONTH;
	int IDAY;
	int IHOUR;
	int Minute;
	int IAMPM;
	String AM_PM;
	int IHT, MINT; // Time Zone hours [IHT] Minutes [MINT]
	double ELNGT, ELTD;
	// System.out.println(ALL.PI);

	public Astro() {

		// getting current date and time using Date class

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));

		Calendar now = Calendar.getInstance();

		System.out.println("Current YEAR is : " + now.get(Calendar.YEAR));
		System.out.println("Current MONTH is : " + now.get(Calendar.MONTH));
		System.out.println("Current DAY is : " + now.get(Calendar.DATE));
		System.out.println("Current Hour in 12 hour format is : " + now.get(Calendar.HOUR));
		System.out.println("Current Hour in 24 hour format is : " + now.get(Calendar.HOUR_OF_DAY));
		System.out.println("Current Minute is : " + now.get(Calendar.MINUTE));
		System.out.println(
				"Current Second is : " + now.get(Calendar.SECOND) + " " + AMPM_INPUT[now.get(Calendar.AM_PM) + 1]);

		String Junk = Integer.toString(5);

		LocalTime nowInUtc = LocalTime.now(Clock.systemUTC());
		SimpleDateFormat ftg = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		// System.out.println("Current Date: " + ftg.format(nowInUtc));
		System.out.println(nowInUtc); // 06:08:18.125

		final Date currentTime = new Date();
		final SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		System.out.println("UTC time: " + sdf.format(currentTime));
		String UTCDate = "UTC time: " + sdf.format(currentTime);
		final SimpleDateFormat sdyear = new SimpleDateFormat("yyyy");
		sdyear.setTimeZone(TimeZone.getTimeZone("UTC"));
		UTCYear = sdyear.format(currentTime);
		System.out.println("UTC YEAR: " + UTCYear);

		final SimpleDateFormat sdmonth = new SimpleDateFormat("MMM");
		sdmonth.setTimeZone(TimeZone.getTimeZone("UTC"));
		UTCMonth = sdmonth.format(currentTime);
		System.out.println(" UTC MONTH " + UTCMonth);

        

		
		
		switch (UTCMonth) {
		case "Select Month":
			Month_Num = 0;
			break;
		case "Jan":
			Month_Num = 1;
			break;
		case "Feb":
			Month_Num = 2;
			break;
		case "Mar":
			Month_Num = 3;
			break;
		case "Apr":
			Month_Num = 4;
			break;
		case "May":
			Month_Num = 5;
			break;
		case "Jun":
			Month_Num = 6;
			break;
		case "Jul":
			Month_Num = 7;
			break;
		case "Aug":
			Month_Num = 8;
			break;
		case "Sep":
			Month_Num = 9;
			break;
		case "Oct":
			Month_Num = 10;
			break;
		case "Nov":
			Month_Num = 11;
			break;
		case "Dec":
			Month_Num = 12;
		}  

		System.out.println(" UTC MONTH " + UTCMonth + " Month_Num = " + Month_Num);

		
		for(int i=0; i < Month_Names.length; i++ ) {		
	         if( Month_Names[i] == UTCMonth ) Month_Num = i;
		}
		
		UTCMonth = Month_Names[Month_Num];
		
		
		
		
		
		System.out.println(" UTC MONTH " + UTCMonth + " Month_Num = " + Month_Num);

		final SimpleDateFormat sdday = new SimpleDateFormat("dd");
		sdday.setTimeZone(TimeZone.getTimeZone("UTC"));
		UTCDay = sdday.format(currentTime);
		System.out.println("UTC DAY: " + UTCDay);

		final SimpleDateFormat sdhour = new SimpleDateFormat("hh");
		sdhour.setTimeZone(TimeZone.getTimeZone("UTC"));
		UTCHour = sdhour.format(currentTime);
		System.out.println("UTC HOUR: " + UTCHour);

		final SimpleDateFormat sdminute = new SimpleDateFormat("mm");
		sdminute.setTimeZone(TimeZone.getTimeZone("UTC"));
		UTCMinute = sdminute.format(currentTime);
		System.out.println("UTC MINUTE: " + UTCMinute);

		final SimpleDateFormat sdsecond = new SimpleDateFormat("ss");
		sdsecond.setTimeZone(TimeZone.getTimeZone("UTC"));
		UTCSecond = sdsecond.format(currentTime);
		System.out.println("UTC SECOND: " + UTCSecond);

		final SimpleDateFormat sdAMPM = new SimpleDateFormat("a");
		sdAMPM.setTimeZone(TimeZone.getTimeZone("UTC"));
		UTCAMPM = sdAMPM.format(currentTime);
		System.out.println("UTC AM or PM: = " + UTCAMPM);

		AM_PM = UTCAMPM;

		int AMPM_Index = 1;
		int AMPM_Index_Local = 1;

		if (AM_PM == "PM")
			AMPM_Index = 2;
		if (AMPM_INPUT[now.get(Calendar.AM_PM) + 1] == "PM")
			AMPM_Index_Local = 2;

		System.out.println("UTC AM or PM: = " + UTCAMPM + " AM_PM = " + AM_PM + " AMPM_Index = " + AMPM_Index);

		// int Month_Num = Month_Names.indexOf(sdmonth.format(currentTime));;

		// int Month_Num = Month_Names.indexOf("May");

		// Month_Num = now.get(Calendar.MONTH);

		JPanel myPanel_0 = new JPanel();
		add(myPanel_0);
		JLabel lblWelcome = new JLabel("Welcome to Astro");

		myPanel_0.add(lblWelcome);

		JPanel myPanel = new JPanel();
		// myPanel.setPreferredSize(new Dimension(640, 240));

		// myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.X_AXIS));

		/*
		 * http://stackoverflow.com/questions/29619641/insert-a-new-line-for-
		 * each-field-in-java-gui
		 * http://stackoverflow.com/questions/24842068/set-position-of-text-
		 * field-in-java
		 */

		// myPanel.setLayout(new FlowLayout());
		// myPanel.setLayout(new GridBagLayout());
		// myPanel.setLayout(null);

		add(myPanel);

		JButton entbtn = new JButton("Enter");
		myPanel.setLayout(new GridLayout(8, 4));
		// myPanel.setLayout(new FlowLayout ());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		YearLabel = new JLabel(" Time [Local] YEAR: ", SwingConstants.CENTER);

		MonthLabel = new JLabel(" MONTH: ");
		DayLabel = new JLabel("    DAY: ");
		HourLabel = new JLabel(" HOUR:     ");
		MinuteLabel = new JLabel("      MINUTE:     ");
		Month_Select_Label = new JLabel("        Select Month:    ");
		AMPM_Label = new JLabel(" AM or PM ? [Select]:  ");
		TimeZone_Label = new JLabel("                      Local Time Zone ");

		Mon_Lists = new JComboBox(Month_Names); // Drop down ComboBox for Month
												// Selection

		Deg_Min_Sec = new JLabel(
				"                                                                                    Degree            Minute   Second       ");
		Deg_Label = new JLabel(" Deg. ");
		Min_Label = new JLabel(" Min. ");
		Sec_Label = new JLabel(" Sec. ");

		Space_0 = new JLabel("<html>_____________________________________________________________<br/>"
				+ "                   _____________________________________________________________ ");
		Longitude = new JLabel(" Longitude: ");

		Latitude = new JLabel("  Latitude ");

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

		// YearTextField = new JTextField (5);
		// YearTextField = new JTextField (UTCYear, 2);
		YearTextField = new JTextField(Integer.toString(now.get(Calendar.YEAR)), 2);

		YearTextField.setBounds(300, 300, 200, 40);
		// MonthTextField = new JTextField ( UTCMonth, 5);
		MonthTextField = new JTextField(Integer.toString(now.get(Calendar.MONTH)), 5);
		// DayTextField = new JTextField ( UTCDay, 5);
		// HourTextField = new JTextField ( UTCHour, 5);
		// MinuteTextField = new JTextField ( UTCMinute, 5);

		DayTextField = new JTextField(Integer.toString(now.get(Calendar.DATE)), 5);
		HourTextField = new JTextField(Integer.toString(now.get(Calendar.HOUR)), 5);
		MinuteTextField = new JTextField(Integer.toString(now.get(Calendar.MINUTE)), 5);

		myPanel.add(YearLabel, gbc);
		// YearLabel.setLocation(27, 20);

		myPanel.add(YearTextField);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 22;
		gbc.weightx = 0.5;
		gbc.ipady = 40;
		// add (MonthLabel);
		// add(MonthTextField);

		myPanel.add(Month_Select_Label); // Label for month selection
		// add to the parent container (e.g. a JFrame):
		myPanel.add(Mon_Lists);
		Mon_Lists.setSelectedIndex(Month_Num);

		myPanel.add(DayLabel);
		myPanel.add(DayTextField);

		myPanel.add(DayLabel, gbc);
		myPanel.add(DayTextField);
		gbc.gridx = 0;
		gbc.gridy++;

		JPanel myPanel_1 = new JPanel();
		add(myPanel_1);

		myPanel_1.add(HourLabel);
		// gbc.gridx = 0;
		// gbc.gridy = 200;
		myPanel_1.add(HourTextField);

		myPanel_1.add(MinuteLabel);
		myPanel_1.add(MinuteTextField);

		myPanel_1.add(AMPM_Label); // Label for selecting AM or PM.
		AM_or_PM = new JComboBox(AMPM_INPUT); // Drop down ComboBox for
												// selecting AM or PM.
		// AM_or_PM.setSelectedIndex(AMPM_Index);
		AM_or_PM.setSelectedIndex(AMPM_Index_Local);

		// AMPM_Index
		// String AM_or_PM = int.toString(5);

		// now.get(Calendar.AM_PM).toString
		// AMPM_Selected = (String)AM_or_PM.getSelectedItem().toString();

		myPanel_1.add(AM_or_PM);

		// add (Deg_Min_Sec);

		// myPanel.add(Space_0);
		// myPanel.add(Line_1 = new JLabel(" "), "wrap");

		JPanel myPanel_2 = new JPanel();
		add(myPanel_2);

		myPanel_2.add(Longitude);
		// gbc.gridx = 0;
		// gbc.gridy++;
		myPanel_2.add(Deg_Label);
		myPanel_2.add(Deg_Lon);
		Deg_Lon.setBounds(100, 100, 200, 40);
		East_West = new JComboBox(East_or_West);

		myPanel_2.add(East_West);
		E_W_Index_Local = 1;
		East_West.setSelectedIndex(E_W_Index_Local); // Set the index "W" for
														// Buffalo
		myPanel_2.add(Min_Label);
		myPanel_2.add(Min_Lon);
		myPanel_2.add(Sec_Label);
		myPanel_2.add(Sec_Lon);

		// add (Deg_Min_Sec_Lat);
		// Line_Sep = new JLabel ( System.lineSeparator());
		JPanel myPanel_3 = new JPanel();
		add(myPanel_3);

		// myPanel.add(bridgeSet = new JLabel(" "), "wrap");

		// add ( Line_Sep );
		myPanel_3.add(Latitude);
		myPanel_3.add(Deg_Lab_Lat);
		myPanel_3.add(Deg_Lat);
		North_South = new JComboBox(North_or_South);
		N_S_Index_Local = 0;
		North_South.setSelectedIndex(0); // Set the index "N" for Buffalo

		myPanel_3.add(North_South);
		myPanel_3.add(Min_Lab_Lat);

		myPanel_3.add(Min_Lat);
		myPanel_3.add(Sec_Lab_Lat);
		myPanel_3.add(Sec_Lat);

		JPanel myPanel_4 = new JPanel();
		add(myPanel_4);

		myPanel_4.add(TimeZone_Label);

		HourZone = "4";
		MinuteZone = "00";
		HourTextField2 = new JTextField(HourZone, 3);
		MinuteTextField2 = new JTextField(MinuteZone, 3);

		HourLabel2 = new JLabel(" HOUR: ");
		MinuteLabel2 = new JLabel(" MINUTE: ");
		E_W_1_Label = new JLabel(" East or West of GMT ");
		// myPanel.add(entbtn);

		myPanel_4.add(HourLabel2);
		myPanel_4.add(HourTextField2);

		myPanel_4.add(MinuteLabel2);
		myPanel_4.add(MinuteTextField2);

		East_West_1 = new JComboBox(East_or_West);
		E_W_Index_Local = 1;

		East_West_1.setSelectedIndex(1); // Set the index "W" for Buffalo

		myPanel_4.add(E_W_1_Label);
		myPanel_4.add(East_West_1);

		JPanel myPanel_5 = new JPanel();
		add(myPanel_5);

		myPanel_5.add(entbtn);
		entbtn.addActionListener(this);
		// txtdata = new JTextField(5);

		setPreferredSize(new Dimension(600, 400));

	} // public Astro(){

	// ......................................................................................................
	// Action Performer - Data INPUT and Calculations start
	// ......................................................................................................

	public void actionPerformed(ActionEvent e) {

		int Month_Index = Month_Num; // This need to be changed for the current
										// time
		String Mon_Combo = "May";
		String AMPM_Combo = "AM";
		int AMPM_Index = 0;
		String EastWest_Lon, NorthSouth_Lat;
		String TIME_LABEL;

		EastWest_Lon = "W";
		NorthSouth_Lat = "N";

		// Time Zone ( Hours Minutes E for East W fpr West - leave space

		/*
		 * IHT = 5; MINT = 30;
		 */

		// IHT = 5;

		// .............................................................................................................................................
		// Start Reading from the input frame
		// .............................................................................................................................................

		// if (e.getSource() == entbtn) {
		YEAR_INPUT = YearTextField.getText(); // perform your operation
		// MONTH_INPUT = MonthTextField.getText(); //perform your operation
		DAY_INPUT = DayTextField.getText(); // perform your operation
		YEAR_IN = Integer.parseInt(YEAR_INPUT);
		// MONTH_IN = Integer.parseInt (MONTH_INPUT);

		Mon_Selected = (String) Mon_Lists.getSelectedItem().toString();

		Mon_Combo = Mon_Lists.getSelectedItem().toString();
		
		for(int i=0; i < Month_Names.length; i++ ) {		
	         if( Month_Names[i] == Mon_Combo ) Month_Index = i;
		}
		
		Mon_Combo = Month_Names[Month_Index];
		
		System.out.println( " Month_Index Short Program = " + Month_Index + " Mon_Combo = " + Mon_Combo);

		DAY_IN = Integer.parseInt(DAY_INPUT);
		// MONTH_IN = Integer.parseInt (MONTH_INPUT);
		DAY_IN = Integer.parseInt(DAY_INPUT);

		HOUR_INPUT = HourTextField.getText(); // Get the hour
		HOUR_IN = Integer.parseInt(HOUR_INPUT); // Convert to integer

		MINUTE_INPUT = MinuteTextField.getText(); // Get the hour
		MINUTE_IN = Integer.parseInt(MINUTE_INPUT); // Convert to integer

		AMPM_Selected = (String) AM_or_PM.getSelectedItem().toString();
		AMPM_Combo = AM_or_PM.getSelectedItem().toString();

		switch (AMPM_Selected) {
		case "AM or PM?":
			AMPM_Index = 1;

			break;
		case "AM":
			AMPM_Index = 1;
			break;
		case "PM":
			AMPM_Index = 2;
		}



		TIME_LABEL = YEAR_INPUT + " - " + Month_Names[Month_Index] + " - " + DAY_INPUT + "  -  " + HOUR_INPUT + ":"
				+ MINUTE_INPUT + " " + AMPM_Selected + " [Local Time]";

		System.out.println(
				"  INPUT The Time of Epoch: " + System.lineSeparator() + YEAR_IN + " - " + Month_Index + " - " + DAY_IN
						+ " - " + HOUR_IN + ":" + MINUTE_IN + " " + AMPM_Selected + " AMPM_Index = " + AMPM_Index);

		Long_Deg = Deg_Lon.getText(); // Get Longitude Degrees
		Long_Deg_Num = Integer.parseInt(Long_Deg); // Longitude Degrees

		Long_Min = Min_Lon.getText(); // Get Longitude Minutes
		Long_Min_Num = Integer.parseInt(Long_Min);

		Long_Sec = Sec_Lon.getText(); // Get Longitude Minutes
		Long_Sec_Num = Integer.parseInt(Long_Sec);

		EastWest_Lon = (String) East_West.getSelectedItem().toString();
		EastWest_Lon = East_West.getSelectedItem().toString();

		System.out.println(" Longitude = " + Long_Deg_Num + " Deg " + EastWest_Lon + " " + Long_Min_Num + " Min "
				+ Long_Sec_Num + " Sec ");

		Lati_Deg = Deg_Lat.getText(); // Get Longitude Degrees
		Lati_Deg_Num = Integer.parseInt(Lati_Deg); // Longitude Degrees

		Lati_Min = Min_Lat.getText(); // Get Longitude Minutes
		Lati_Min_Num = Integer.parseInt(Lati_Min);

		Lati_Sec = Sec_Lat.getText(); // Get Longitude Minutes
		Lati_Sec_Num = Integer.parseInt(Lati_Sec);

		NorthSouth_Lat = (String) North_South.getSelectedItem().toString();
		NorthSouth_Lat = North_South.getSelectedItem().toString();

		System.out.println(" Latitude = " + Lati_Deg_Num + " Deg " + NorthSouth_Lat + " " + Lati_Min_Num + " Min "
				+ Lati_Sec_Num + " Sec ");

		// .............................................................................................................................................
		// Finish Reading from the input frame
		// .............................................................................................................................................

		
		IYEAR = YEAR_IN;
		// MONTH = MONTH_IN;
		MONTH = Month_Index;

		IDAY = DAY_IN;
		IHOUR = HOUR_IN;
		Minute = MINUTE_IN;

		
		IHT = 0;
		MINT = 0;

		// HourTextField2 YEAR_INPUT = YearTextField.getText(); YEAR_IN =
		// Integer.parseInt (YEAR_INPUT);
		IHT = Integer.parseInt(HourTextField2.getText());
		MINT = Integer.parseInt(MinuteTextField2.getText());

		// E_W = "E";
		E_W = EastWest_Lon;
		if (E_W == "E") {
			IHT = -IHT;
			MINT = -MINT;
		}

		ELNGT = Long_Deg_Num + Long_Min_Num / 60. + Long_Sec_Num / 3600.;

		N_S = NorthSouth_Lat;
		ELTD = Lati_Deg_Num + Lati_Min_Num / 60. + Lati_Sec_Num / 3600.;

		if (N_S == "S")
			ELTD = -ELTD;

		IAMPM = 2;
		// AM_PM = "PM";
		AM_PM = AMPM_Selected;

		IAMPM = 1;
		if (AM_PM == "PM")
			IAMPM = 2;
		System.out.println("The Time of Epoch: " + IYEAR + " - " + MONTH + " - " + IDAY + " - " + IHOUR + ":" + Minute);

		
		
		
	// ___________ Following goes to Astro_Calcuations Class________________________________	
		
		
	//	 Astro_Calculations( int IYear, int Month, int Day, int IHour, int IMinute, int int_AMPM, int String EW, String NS )
		 
		 
		Astro_Calculations AstroCal = new Astro_Calculations ( IYEAR, MONTH, IDAY, IHOUR, Minute, IAMPM, E_W, N_S, IHT, MINT, ELNGT, ELTD );
		 
		
		
		AstroCal.Ast_Graha_Cal();
		
		
		OUT_DEG = AstroCal.get_OUT_DEG();
		
		Graha_Rasi_Num = AstroCal.get_Graha_Rasi_Num();
		Navamsa_Num = AstroCal.get_Navamsa_Num();
		Dasamsa_Num = AstroCal.get_Dasamsa_Num();
		Dwadasamsa_Num = AstroCal.get_Dwadasamsa_Num();
		Chatur_Num = AstroCal.get_Chatur_Num();
		Trimsamsa_Num = AstroCal.get_Trimsamsa_Num();
		Graha_Abr = AstroCal.get_Graha_Abr();
		WEEKDY = AstroCal.get_WeekDay();
			


		JFrame frame_out = new JFrame("                          ASTRO PROGRAM                    ");
		frame_out.setSize(4200, 1200);
		
		frame_out.setBackground(new Color(230, 230, 230));
		   

		// frame_out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane tp = new JTabbedPane();
		tp.setPreferredSize(new Dimension(2400, 900));
		tp.setVisible(true);

		frame_out.getContentPane().add(tp);
		frame_out.pack();
		frame_out.setVisible(true);

		Longitude_Entry = "Longitude:         " + Long_Deg + "°" + E_W + " " + Long_Min + "' " + Long_Sec + '"';
		System.out.println(" Longitude_Entry = " + Longitude_Entry);

		Latitude_Entry = "Latitude:            " + Lati_Deg + "° " + N_S + " " + Lati_Min + "' " + Lati_Sec + '"';
		System.out.println(" Latitude_Entry = " + Latitude_Entry);

		Time_Entry = TIME_LABEL;
		System.out.println(" Time_Entry = " + Time_Entry);
		
		Thithi = AstroCal.get_Tithi();

		Input_Panel inputpanel = new Input_Panel(Time_Entry, Longitude_Entry, Latitude_Entry, WEEKDY, Thithi );

		tp.addTab("INPUT", inputpanel);

		String Strin_Out = Out_Rasi[0] + "\n" + Out_Rasi[1];
		Rasi_Panel Rasipanel = new Rasi_Panel(OUT_DEG, TIME_LABEL);
		// Rasipanel.input_info();
		// Rasipanel.Head_Fill();
		// Rasipanel.Grid_Fill();

		frame_out.getContentPane().add(Rasipanel);
		frame_out.pack();
		frame_out.setVisible(true);
		// Rasipanel.Grid_Fill();

		tp.addTab("Basics", Rasipanel);

		/*
		 * 
		 * 
		 * //________________Use the following to get RASI
		 * CHART______________________
		 * 
		 * 
		 * JFrame window1 = new JFrame("RASI CHART");
		 * //window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Rasi_Chart
		 * RasiChart = new Rasi_Chart( Graha_Rasi_Num ); window1.setBounds(30,
		 * 30, 500, 500); window1.getContentPane().add(RasiChart);
		 * window1.pack(); window1.setVisible(true);
		 */

		/*
		 * JFrame window2 = new JFrame("RASI & NAVAMSA CHART");
		 * //window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * Rasi_Nav_Chart RasiNavChart = new Rasi_Nav_Chart( Graha_Rasi_Num,
		 * Navamsa_Num ); window2.setBounds(30, 30, 500, 500);
		 * window2.getContentPane().add(RasiNavChart); window2.pack();
		 * window2.setVisible(true);
		 */

		/*
		 * JFrame window3 = new JFrame("RASI & AMSA CHART");
		 * 
		 * //window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Rasi_Amsa
		 * RasiAmsaChart = new Rasi_Amsa ( Graha_Abr, Graha_Rasi_Num,
		 * Navamsa_Num, Chatur_Num ); window3.setBounds(30, 30, 700, 900);
		 * window3.getContentPane().add(RasiAmsaChart); window3.pack();
		 * window3.setVisible(true);
		 */

		// JFrame window4 = new JFrame("RASI & AMSA CHART");
		// window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Rasi_Amsa_Chart RasiAmsaChart = new Rasi_Amsa_Chart(Graha_Abr, Graha_Rasi_Num, Navamsa_Num, Chatur_Num,
				Dasamsa_Num, Dwadasamsa_Num, Trimsamsa_Num);
		frame_out.getContentPane().add(RasiAmsaChart);
		frame_out.pack();
		frame_out.setVisible(true);

		tp.addTab("RASI_AMSA", RasiAmsaChart);

		System.out.println(" UTCYEAR = " + UTCYear + " UTCMonth = " + UTCMonth + " UTCDay = " + UTCDay);
		System.out.println(" UTCHour = " + UTCHour + " UTCMinute = " + UTCMinute + " UTCSecond = " + UTCSecond);
		System.out.println(" UTCAMPM = " + UTCAMPM);
		System.out.println(" Month_Num = " + Month_Num);
		System.out.println(" E_W_Index_Local = " + E_W_Index_Local);
		System.out.println(" N_S_Index_Local = " + N_S_Index_Local);

		System.out.println(" YEAR_INPUT = " + YEAR_INPUT + " Mon_Selected = " + Mon_Selected + " Mon_Combo = "
				+ Mon_Combo + " Month_Index = " + Month_Index + " DAY_INPUT = " + DAY_INPUT);
		System.out.println(" HOUR_INPUT = " + HOUR_INPUT + " MINUTE_INPUT = " + MINUTE_INPUT);

		Longitude_Entry = " Longitude: " + Long_Deg + "°" + E_W + " " + Long_Min + "' " + Long_Sec + '"';
		System.out.println(" Longitude_Entry = " + Longitude_Entry);

		// Transit GoChara = new Transit ( YEAR_INPUT, Mon_Selected, DAY_INPUT,
		// HOUR_INPUT, MINUTE_INPUT,
		// Long_Deg, Long_Min, Long_Sec, E_W, Lati_Deg, Lati_Min, Lati_Sec, N_S
		// );

		// Transit GoChara = new Transit ( UTCYear, UTCMonth, UTCDay, UTCHour,
		// UTCMinute,
		// Long_Deg, Long_Min, Long_Sec, E_W, Lati_Deg, Lati_Min, Lati_Sec, N_S
		// );

		Calendar now = Calendar.getInstance();
		
		System.out.println( " For GoChara now.get(Calendar.MONTH " + now.get(Calendar.MONTH)+1);


		Transit GoChara = new Transit( Integer.toString(now.get(Calendar.YEAR)), Integer.toString(now.get(Calendar.MONTH)+1), Integer.toString(now.get(Calendar.DATE)), 
				Integer.toString(now.get(Calendar.HOUR)), Integer.toString(now.get(Calendar.MINUTE)), AMPM_INPUT[now.get(Calendar.AM_PM) + 1],
				Long_Deg, Long_Min, Long_Sec, E_W,
				Lati_Deg, Lati_Min, Lati_Sec, N_S);

		tp.addTab("Transits", GoChara);
		GoChara.setBackground(new Color(230, 230, 230));
		   
		//GoChara.print_info();

		// window4.getContentPane().add(RasiAmsaChart);
		// window4.pack();
		// window4.setVisible(true);

		// tp.setTabComponentAt(10, frame_out);

	} // public void actionPerformed(ActionEvent e)

	public static void main(String args[]) {

		JFrame Input_Frame = new JFrame("Enter Time Data");
		Input_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// JTabbedPane tp = new JTabbedPane();
		// tp.setPreferredSize(new Dimension(900, 900));
		// tp.setTabComponentAt(900, Input_Frame);
		Astro Astro_Cal = new Astro();

		Input_Frame.getContentPane().add(Astro_Cal);
		Input_Frame.pack();
		Input_Frame.setVisible(true);
		Astro_Cal.setLocation(10, 10);
		Astro_Cal.setSize(500, 500);
		Astro_Cal.setVisible(true);

		Input_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// YEAR_INPUT = III.get_YEAR_INPUT();
		// System.out.println( " INPUT YEAR = " + YEAR_INPUT);

		// more to do …
	}

}
