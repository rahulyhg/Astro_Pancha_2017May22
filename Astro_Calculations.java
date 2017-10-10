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

public class Astro_Calculations {
	
	
	private static String Time_Entry, Longitude_Entry, Latitude_Entry;

	private String UTCYear, UTCMonth, UTCDay, UTCHour, UTCMinute, UTCSecond, UTCAMPM, HourZone, MinuteZone;
	private String Long_Deg, Long_Min, Long_Sec;
	private int Long_Deg_Num, Long_Min_Num, Long_Sec_Num;
	private String Lati_Deg, Lati_Min, Lati_Sec;
	private int Lati_Deg_Num, Lati_Min_Num, Lati_Sec_Num;

	String Hour_Dif_Local, Min_Dif_Local, E_W_Local;
	int num1 = 27, num2;
	String YEAR_INPUT, MONTH_INPUT, DAY_INPUT, HOUR_INPUT, MINUTE_INPUT, data1, data2;
	int YEAR_IN, MONTH_IN, DAY_IN, HOUR_IN, MINUTE_IN;
	int E_W_Index_Local, E_W_Index, N_S_Index_Local, N_S_Index;
	int Month_Num;
	String[] Month_Names = new String[] { "Select Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
			"Oct", "Nov", "Dec" };

	String[] Nakshatras = new String[] { "Aswi", "Bhar", "Krit", "Rohi", "Mrig", "Ardr", "Puna", "Push", "Asle", "Magh",
			"PPha", "UPha", "Hast", "Chit", "Swat", "Visa", "Anu", "Jye", "Mool", "PSha", "USha", "Srav", "Dhan",
			"Sata", "PBha", "UBha", "Reva" };
	
	String[] tithis = new String[] { "Pratipat", "Dwitiya", "Tritiya", "Chaturthi", "Panchami", "Shashti", 
			"Saptami", "Ashtami", "Navami", "Dasami", "Ekadasi", "Dwadasi", "Trayodasi", "Chaturdasi", "Pournima_or_Amavasya" };
	String tithi;
	
	String[] East_or_West = new String[] { "E", "W" };
	String[] North_or_South = new String[] { "N", "S" };
	String Mon_Selected;
	int Mon_Num;

	String[] AMPM_INPUT = new String[] { "AM or PM?", "AM", "PM" };
	String AMPM_Selected;
	int AM_PM_Num;

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
	
	int YGREEN, MGREEN, DGREEN, HGREEN, MIGREEN;
	

	public Astro_Calculations( int IYear, int Month, int Day, int IHour, int IMinute, int int_AMPM, String EW, String NS, 
			int IHDiff, int MinDiff, double longitude, double latitude ) {
		//To be done
		IYEAR = IYear;
		MONTH = Month;
		IDAY = Day;
		IHOUR = IHour;
		Minute = IMinute;
		IAMPM = int_AMPM;
		E_W = EW;
		N_S = NS;
		IHT = IHDiff;
		MINT = MinDiff;
		ELNGT = longitude;
		ELTD = latitude;
		
		AM_PM = "AM";
		if (IAMPM == 2 ) AM_PM = "PM";
		
		System.out.println( " Astro_Calculations: " +  IYEAR + "-" + MONTH + "-" + IDAY + "  " + IHOUR +":" + Minute + " IAMPM = " + IAMPM  );
		
		System.out.println( " E_W = " + E_W + " N_S = " + N_S + " IHDiff = " + IHDiff + " MinDiff = " + MinDiff );
		
		System.out.println( " Longitude (ELNGT) =" + ELNGT + " Latitude (ELTD) = " + ELTD );
		
	}
	

	public void Ast_Graha_Cal( ) {
	
	

	for (int i = 0; i < 10; i++)
		for (int j = 0; j < 6; j++)
			OUT_DEG[j][i] = "--";

	// IHO amd IMO below are just two minutes past midnight of the day.
	// THis is just ot get the Calendar date and weekday
	int IHO, IMO;
	IHO = 0;
	IMO = 0;

	UT_0GREEN Greenwich = new UT_0GREEN(IYEAR, MONTH, IDAY, IHO, IMO, IAMPM);
	Greenwich.Julian();
	double CJD = Greenwich.get_CJD();
	System.out.println("CJD = " + CJD);

	double TJD = Greenwich.get_TJD();
	System.out.println("TJD = " + TJD);

	double TJD_Day_0H0M;

	double TJD_UT0 = Greenwich.get_TJD_UT0();
	System.out.println("TJD_UT0 = " + TJD_UT0);

	Greenwich.Calen();

	// Calculate Ayanamsa for the day of the Epoch

	// Get the day of the week

	WEEKDY = Greenwich.get_WEEKDAY();

	System.out.println("From Astro_Calculations The Time of Epoch: " + IYEAR + " - " + MONTH + " - " + IDAY + " - " + IHOUR + ":" + Minute
			+ "        " + WEEKDY);

	Greenwich.Green_Time(IHT, MINT, E_W);

	UT_0GREEN EpochTime = new UT_0GREEN(IYEAR, MONTH, IDAY, IHOUR, Minute, IAMPM);

	int epoch_Hour = EpochTime.get_HOUR();

	System.out.println("The Time of Epoch: " + IYEAR + " - " + MONTH + " - " + IDAY + " - " + epoch_Hour + ":"
			+ Minute + "        " + WEEKDY);
	System.out.println( " ELNGT = " + ELNGT + " ELTD = " + ELTD );
	
	Time_Zone EpochLoc = new Time_Zone(IHT, MINT, ELNGT, ELTD, E_W);
	EpochLoc.Green_Time(IYEAR, MONTH, IDAY, IHOUR, Minute, AM_PM, IHT, MINT, E_W);

	double FRUNIV;
	FRUNIV = EpochLoc.get_FRUNIV();
	int YGREEN, MGREEN, DGREEN, HGREEN, MIGREEN;
	YGREEN = EpochLoc.get_YEAR_GREEN();
	MGREEN = EpochLoc.get_MON_GREEN();
	DGREEN = EpochLoc.get_DAY_GREEN();
	HGREEN = EpochLoc.get_HOUR_GREEN();
	MIGREEN = EpochLoc.get_MIN_GREEN();

	System.out.println(" YGREEN       MGREEN      DGREEN       HGREEN        MIGREEN  IAMPM ");
	System.out.println(
			YGREEN + "     " + MGREEN + "     " + DGREEN + "     " + HGREEN + "     " + MIGREEN + "     " + IAMPM);
	// Deltat Time_Diff = new Deltat (IYEAR, MONTH, IDAY, IHOUR, Minute);
	Deltat Time_Diff = new Deltat(YGREEN, MGREEN, DGREEN, HGREEN, MIGREEN);
	Time_Diff.Diff();

	IMO = 0;
	int IAM_PM_Green = 1;
	IAMPM = IAM_PM_Green;

	UT_0GREEN Green_Epoch = new UT_0GREEN(YGREEN, MGREEN, DGREEN, HGREEN, MIGREEN, IAMPM);
	Green_Epoch.Julian();
	TJD_Day_0H0M = Green_Epoch.get_TJD_0Hour();
	System.out.println("Green_Epoch  CJD = " + Green_Epoch.get_CJD());

	double TJD_Epoch, TJD_Epoch_Plus;
	TJD_Epoch = Green_Epoch.get_TJD();
	TJD_Epoch_Plus = Green_Epoch.get_TJD_Plus();

	System.out
			.println("Green_Epoch  TJD = " + Green_Epoch.get_TJD() + " Green_Epoch_Plus  TJD = " + TJD_Epoch_Plus);

	System.out.println("TJD_UT0 = " + Green_Epoch.get_TJD_UT0());

	System.out.println("TJD_Day_0H0M = " + TJD_Day_0H0M);

	double TJD_2000 = 1. - TJD;
	System.out.println("TJD_UT0 = " + TJD_2000);

	// CALL SIDERT ( TJD_UT0,ELNGT,ELTD,FRD_GR,SIDE0,SIDE,SIDEL,ATQD,EMC )

	System.out.println(" FRUNIV =" + FRUNIV);

	// FRUNIV = FRUNIV + Time_Diff.get_DT() / 1440.;

	System.out.println(" FRUNIV =" + FRUNIV);

	System.out.println(" TJD_UT0 =" + TJD_UT0 + " TJD_Day_0H0M = " + TJD_Day_0H0M);

	JULCEN Lagna = new JULCEN(TJD_Day_0H0M, ELNGT, ELTD, FRUNIV, E_W);
	// JULCEN Lagna = new JULCEN(TJD_UT0, ELNGT, ELTD, FRUNIV, E_W);

	Lagna.ascend();

	ASCND = Lagna.get_Ascend();
	System.out.println(" ASCND = " + ASCND);
	NIRAYANA Convert_Nir = new NIRAYANA(TJD);
	Convert_Nir.NIRAYANA_Deg("Lagna", ASCND, RASIS);

	OUT_DEG[1][0] = Convert_Nir.get_Nirayana(); // GEt NIrayana Lagna degree
												// minutes and seconds

	Out_Rasi[0] = Convert_Nir.get_outGraha();

	/*
	 * OUT_DEG[0][0] = "   Lagna"; OUT_DEG[0][1] = "   Sun"; OUT_DEG[0][2] =
	 * "   Moon"; OUT_DEG[0][3] = "   Rahu"; OUT_DEG[0][4] = "   Ketu";
	 * OUT_DEG[0][5] = "   " + Graha_Name [0]; OUT_DEG[0][6] = "   " +
	 * Graha_Name [1]; OUT_DEG[0][7] = "   " + Graha_Name [2]; OUT_DEG[0][8]
	 * = "   " + Graha_Name [3]; OUT_DEG[0][9] = "   " + Graha_Name [4];
	 */

	for (int i = 0; i < 10; i++) {
		OUT_DEG[0][i] = Graha_Abr[i];
	}

	double EPLNT;
	double[][] EMEAN = new double[8][4];

	double[][] EMEAN_T = new double[][] {
			{ 102.27938, 212.60322, 319.51913, 225.32833, 175.46622, 72.64878, 37.73063 },
			{ 149472.51529, 58517.80387, 19139.85475, 3034.69202, 1221.55147, 428.37911, 218.46134 },
			{ 0.000007, 0.001286, 0.000181, -0.000722, -0.000502, 0.000079, 0.0007 },
			{ 0., 0., 0., 0., 0., 0., 0. } };

	// transpose EMEAN_T to get EMEAN because FORTRAN table is in
	// column-major order
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 7; j++)
			EMEAN[j][i] = EMEAN_T[i][j];

	QBERT.Q1 = 1.;
	QBERT.Q2 = 2.;
	QBERT.Q4 = 4.;
	QBERT.Q8 = 8.;
	ALL.PI = QBERT.Q4 * Math.atan(QBERT.Q1);

	TRGVAR.Deg180 = 180.0;
	TRGVAR.R_to_D = TRGVAR.Deg180 / ALL.PI;
	TRGVAR.D_to_R = ALL.PI / TRGVAR.Deg180;

	double UT0_TJD, UT0_JD;

	double Trial_Deg = 60.0;
	double Trial_Junk = Trig.DegCOS(Trial_Deg);

	double EMSUN; // Mean Anomaly of SUN
	double EMSUN_Plus; // Mean Anomaly of SUN Slightly advanced time

	SUNMON Sun_Long = new SUNMON(TJD_Epoch);

	Sun_Long.Sun_Longitude();
	Sun_Long.Moon_Longitude();
	Sun_Sayana = Sun_Long.get_TRULON();
	EMSUN = Sun_Long.get_EMSUN();
	Sun_Rad = Sun_Long.get_RSUN();

	Convert_Nir.NIRAYANA_Deg("SUN", ASCND, RASIS);
	Convert_Nir.NIRAYANA_Deg("    SUN:   ", Sun_Sayana, RASIS);

	OUT_DEG[1][1] = Convert_Nir.get_Nirayana();

	SUNMON Sun_Long_Plus = new SUNMON(TJD_Epoch_Plus);
	Sun_Long_Plus.Sun_Longitude();
	Sun_Long_Plus.Moon_Longitude();
	EMSUN_Plus = Sun_Long_Plus.get_EMSUN();
	Sun_Sayana_Plus = Sun_Long_Plus.get_TRULON();

	Out_Rasi[1] = Convert_Nir.get_outGraha();

	SUNMON Moon_Rahu_Ketu_Long = new SUNMON(TJD_Epoch);
	Moon_Rahu_Ketu_Long.Moon_Longitude();

	/*
	 * .....................................................................
	 * Assign a number gor each planet
	 * .....................................................................
	 * NGRAHA = 0 MERCURY NGRAHA = 1 VENUS NGRAHA = 2 MARS NGRAHA = 3 GURU
	 * NGRAHA = 4 SATURN NGRAHA = 5 URANUS NGRAHA = 6 NEPTUNE
	 * .....................................................................
	 * ... Calculate Mean Anomaly of all planets
	 * .....................................................................
	 * ...
	 */
	double EMJ_MER[] = new double[4];
	double EMJ_VEN[] = new double[4];
	double EMJ_MARS[] = new double[4];
	double EMJ_JUP[] = new double[4];
	double EMJ_SAT[] = new double[4];
	double EMJ_URA[] = new double[4];
	double EMJ_NEP[] = new double[4];

	for (int j = 0; j < 7; j++) {
		for (int i = 0; i < 4; i++) {
			EMJ[i] = EMEAN[j][i];

			switch (j) {
			case 0:
				EMJ_MER[i] = EMJ[i];
				break;
			case 1:
				EMJ_VEN[i] = EMJ[i];
				break;
			case 2:
				EMJ_MARS[i] = EMJ[i];
				break;
			case 3:
				EMJ_JUP[i] = EMJ[i];
				break;
			case 4:
				EMJ_SAT[i] = EMJ[i];
				break;
			case 5:
				EMJ_URA[i] = EMJ[i];
				break;
			case 6:
				EMJ_URA[i] = EMJ[i];
				break;

			}

		}
		EPLNT = EMJ[0] + TJD_Epoch * (EMJ[1] + TJD_Epoch * (EMJ[2] + TJD_Epoch * EMJ[3]));

		EPLN[j] = EPLNT % 360;
		if (EPLN[j] < 0)
			EPLN[j] += 360;
		System.out.println(" EPLNT " + EPLNT + " EPLNT % 360 = " + EPLNT % 60 + " j = " + j + " EPLN [ " + j + " ] "
				+ EPLN[j]);
		System.out.println(" J = " + j + " EMJ[0] = " + EMJ[0] + " EMJ[1] = " + EMJ[1] + " EMJ [ 2 ] = " + EMJ[2]
				+ " EMJ [ 3 ] = " + EMJ[3]);
	}

	/*
	 * .....................................................................
	 * ... NGRAHA = 0 MERCURY - Define the parameters
	 * .....................................................................
	 * ..
	 */

	double AL_MER = 0.3870986; // Semi major axis of the orbit

	double[] AJ_MER = { 178.179078, 149474.07078, 0.0003011, 0. };
	double[] EJ_MER = { 0.20561421, 0.00002046, -0.00000003, 0. };
	double[] EIJ_MER = { 7.002881, 0.0018608, -0.0000183, 0. };
	double[] PIJ_MER = { 28.753753, 0.3702806, 0.0001208, 0. };
	double[] OIJ_MER = { 47.145944, 1.1852083, 0.0001739, 0. };
	// double[] EMJ_MER = { 102.27938,149472.51529,0.000007,0. };

	GRAHAS Mercury = new GRAHAS(TJD_Epoch, AJ_MER, EIJ_MER, EJ_MER, PIJ_MER, OIJ_MER, EPLN, AL_MER, Graha_Name[0],
			Sun_Sayana, 0, EMSUN, Sun_Rad);
	// System.out.println( AJ_MER );

	Mercury.Graha_Longitude();

	double Mercury_Sayana;
	Mercury_Sayana = Mercury.get_TruLong();

	GRAHAS Mercury_Plus = new GRAHAS(TJD_Epoch_Plus, AJ_MER, EIJ_MER, EJ_MER, PIJ_MER, OIJ_MER, EPLN, AL_MER,
			Graha_Name[0], Sun_Sayana_Plus, 0, EMSUN_Plus, Sun_Rad);
	// System.out.println( AJ_MER );

	Mercury_Plus.Graha_Longitude();

	double Mercury_Sayana_Plus;
	Mercury_Sayana_Plus = Mercury_Plus.get_TruLong();

	// if (Mercury_Sayana_Plus < Mercury_Sayana)
	// OUT_DEG[0][5] = "(" + Graha_Name[0] + ")";

	if (Mercury_Sayana_Plus < Mercury_Sayana)
		OUT_DEG[0][5] = "(" + Graha_Abr[5] + ")";

	System.out.println(" Mercury_Sayana = " + Mercury_Sayana + " Mercury_Sayana_Plus " + Mercury_Sayana_Plus + "  "
			+ OUT_DEG[0][5]);

	/*
	 * .....................................................................
	 * ... NGRAHA = 1 VENUS - Define the parameters
	 * .....................................................................
	 * ..
	 */

	double AL_VEN = 0.7233316; // Semi major axis of the orbit

	double[] AJ_VEN = { 342.767053, 58519.21191, 0.0003097, 0. };
	double[] EJ_VEN = { 0.00682069, -0.00004774, 0.000000091, 0. };
	double[] EIJ_VEN = { 3.393631, 0.0010058, -0.000001, 0. };
	double[] PIJ_VEN = { 75.779647, 0.89985, 0.00041, 0. };
	double[] OIJ_VEN = { 212.60322, 58517.80387, 0.001286, 0. };
	// double[] EMJ_MER = { 102.27938,149472.51529,0.000007,0. };

	GRAHAS Venus = new GRAHAS(TJD_Epoch, AJ_VEN, EIJ_VEN, EJ_VEN, PIJ_VEN, OIJ_VEN, EPLN, AL_VEN, Graha_Name[1],
			Sun_Sayana, 1, EMSUN, Sun_Rad);
	Venus.Graha_Longitude();
	double Venus_Sayana;
	Venus_Sayana = Venus.get_TruLong();

	GRAHAS Venus_Plus = new GRAHAS(TJD_Epoch_Plus, AJ_VEN, EIJ_VEN, EJ_VEN, PIJ_VEN, OIJ_VEN, EPLN, AL_VEN,
			Graha_Name[1], Sun_Sayana_Plus, 1, EMSUN_Plus, Sun_Rad);
	Venus_Plus.Graha_Longitude();
	double Venus_Sayana_Plus;
	Venus_Sayana_Plus = Venus.get_TruLong();
	if (Venus_Sayana_Plus < Venus_Sayana)
		OUT_DEG[0][6] = "(" + Graha_Abr[6] + ")";

	System.out.println(
			" Venus_Sayana = " + Venus_Sayana + " Venus_Sayana_Plus " + Venus_Sayana_Plus + "  " + OUT_DEG[0][6]);

	/*
	 * .....................................................................
	 * ... NGRAHA = 2 MARS - Define the parameters
	 * .....................................................................
	 * ..
	 */

	double AL_MARS = 1.5236883; // Semi major axis of the orbit

	double[] AJ_MARS = { 293.737334, 19141.69551, 0.0003107, 0. };
	double[] EJ_MARS = { 0.0933129, 0.000092064, -0.000000077, 0. };
	double[] EIJ_MARS = { 1.850333, -0.000675, 0.0000126, 0. };
	double[] PIJ_MARS = { 285.431761, 1.0697667, 0.0001313, 0.00000414 };
	double[] OIJ_MARS = { 48.786442, 0.7709917, -0.0000014, -0.00000533 };
	// double[] EMJ_MARS = { 319.51913, 19139.85475, 0.000181, 0. };

	GRAHAS Mars = new GRAHAS(TJD_Epoch, AJ_MARS, EIJ_MARS, EJ_MARS, PIJ_MARS, OIJ_MARS, EPLN, AL_MARS,
			Graha_Name[2], Sun_Sayana, 2, EMSUN, Sun_Rad);
	Mars.Graha_Longitude();
	double Mars_Sayana;
	Mars_Sayana = Mars.get_TruLong();

	GRAHAS Mars_Plus = new GRAHAS(TJD_Epoch_Plus, AJ_MARS, EIJ_MARS, EJ_MARS, PIJ_MARS, OIJ_MARS, EPLN, AL_MARS,
			Graha_Name[2], Sun_Sayana_Plus, 2, EMSUN_Plus, Sun_Rad);
	Mars_Plus.Graha_Longitude();
	double Mars_Sayana_Plus;
	Mars_Sayana_Plus = Mars_Plus.get_TruLong();

	if (Mars_Sayana_Plus < Mars_Sayana)
		OUT_DEG[0][7] = "(" + Graha_Abr[7] + ")";
	System.out.println(
			" MArs_Sayana = " + Mars_Sayana + " Mars_Sayana_Plus " + Mars_Sayana_Plus + "  " + OUT_DEG[0][7]);

	/*
	 * .....................................................................
	 * ... NGRAHA = 3 GURU (Jupiter) - Define the parameters
	 * .....................................................................
	 * ..
	 */

	double AL_JUP = 5.202561; // Semi major axis of the orbit

	double[] AJ_JUP = { 238.049257, 3036.301986, 0.0003347, -0.00000165 };
	double[] EJ_JUP = { 0.04833475, 0.00016418, -0.0000004676, -0.0000000017 };
	double[] EIJ_JUP = { 1.308736, -0.0056961, 0.0000039, 0. };
	double[] PIJ_JUP = { 273.277558, 0.5994317, 0.00070405, 0.00000508 };
	double[] OIJ_JUP = { 99.443414, 1.01053, 0.00035222, -0.00000851 };
	// double[] EMJ_JUP = {225.32833, 3034.69202, -0.000722, 0. };

	GRAHAS Jupiter = new GRAHAS(TJD_Epoch, AJ_JUP, EIJ_JUP, EJ_JUP, PIJ_JUP, OIJ_JUP, EPLN, AL_JUP, Graha_Name[3],
			Sun_Sayana, 3, EMSUN, Sun_Rad);
	Jupiter.Graha_Longitude();
	double Jup_Sayana;
	Jup_Sayana = Jupiter.get_TruLong();

	GRAHAS Jupiter_Plus = new GRAHAS(TJD_Epoch_Plus, AJ_JUP, EIJ_JUP, EJ_JUP, PIJ_JUP, OIJ_JUP, EPLN, AL_JUP,
			Graha_Name[3], Sun_Sayana_Plus, 3, EMSUN_Plus, Sun_Rad);
	Jupiter_Plus.Graha_Longitude();
	double Jup_Sayana_Plus;
	Jup_Sayana_Plus = Jupiter_Plus.get_TruLong();

	if (Jup_Sayana_Plus < Jup_Sayana)
		OUT_DEG[0][8] = "(" + Graha_Abr[8] + ")";
	System.out
			.println(" Jup_Sayana = " + Jup_Sayana + " Jup_Sayana_Plus " + Jup_Sayana_Plus + "  " + OUT_DEG[0][8]);

	/*
	 * .....................................................................
	 * ... NGRAHA = 4 SATURN - Define the parameters
	 * .....................................................................
	 * ..
	 */

	double AL_SAT = 9.554747; // Semi major axis of the orbit

	double[] AJ_SAT = { 266.564377, 1223.509884, 0.0003245, -0.0000058 };
	double[] EJ_SAT = { 0.05589232, -0.0003455, -0.000000728, 0.00000000074 };
	double[] EIJ_SAT = { 2.492519, -0.0039189, -0.00001549, 0.0000004 };
	double[] PIJ_SAT = { 338.3078, 1.0852207, 0.00097854, 0.00000992 };
	double[] OIJ_SAT = { 112.790414, 0.8731951, -0.00015218, -0.0000531 };
	// double[] EMJ_SAT = {175.46622, 1221.55147, -0.000502, 0 };

	GRAHAS Saturn = new GRAHAS(TJD_Epoch, AJ_SAT, EIJ_SAT, EJ_SAT, PIJ_SAT, OIJ_SAT, EPLN, AL_SAT, Graha_Name[4],
			Sun_Sayana, 4, EMSUN, Sun_Rad);
	Saturn.Graha_Longitude();
	double Sat_Sayana;
	Sat_Sayana = Saturn.get_TruLong();

	GRAHAS Saturn_Plus = new GRAHAS(TJD_Epoch_Plus, AJ_SAT, EIJ_SAT, EJ_SAT, PIJ_SAT, OIJ_SAT, EPLN, AL_SAT,
			Graha_Name[4], Sun_Sayana_Plus, 4, EMSUN_Plus, Sun_Rad);
	Saturn_Plus.Graha_Longitude();
	double Sat_Sayana_Plus;
	Sat_Sayana_Plus = Saturn_Plus.get_TruLong();

	if (Sat_Sayana_Plus < Sat_Sayana)
		OUT_DEG[0][9] = "(" + Graha_Abr[9] + ")";

	System.out
			.println(" Sat_Sayana = " + Sat_Sayana + " Sat_Sayana_Plus " + Sat_Sayana_Plus + "  " + OUT_DEG[0][9]);

	/*
	 * .....................................................................
	 * ... NGRAHA = 5 URANUS - Define the parameters
	 * .....................................................................
	 * ..
	 */

	double AL_URA = 19.21814; // Semi major axis of the orbit

	double[] AJ_URA = { 244.19747, 429.863546, 0.000316, -0.0000006 };
	double[] EJ_URA = { 0.0463444, -0.00002658, 0.000000077, 0. };
	double[] EIJ_URA = { 0.772464, 0.0006253, 0.0000395, 0. };
	double[] PIJ_URA = { 98.071581, 0.985765, -0.0010745, -0.00000061 };
	double[] OIJ_URA = { 73.477111, 0.4986678, 0.0013117, 0. };
	// double[] EMJ_URA = {72.64878, 428.37911, 0.000079, 0. };

	GRAHAS Uranus = new GRAHAS(TJD_Epoch, AJ_URA, EIJ_URA, EJ_URA, PIJ_URA, OIJ_URA, EPLN, AL_URA, Graha_Name[5],
			Sun_Sayana, 5, EMSUN, Sun_Rad);
	Uranus.Graha_Longitude();
	double Ura_Sayana;
	Ura_Sayana = Uranus.get_TruLong();

	/*
	 * .....................................................................
	 * ... NGRAHA = 6 NEPTUNE - Define the parameters
	 * .....................................................................
	 * ..
	 */

	double AL_NEP = 30.10957; // Semi major axis of the orbit

	double[] AJ_NEP = { 84.457994, 219.885914, 0.0003205, -0.0000006 };
	double[] EJ_NEP = { 0.00899704, 0.00000633, -0.000000002, 0. };
	double[] EIJ_NEP = { 1.779242, -0.0095436, -0.0000091, 0. };
	double[] PIJ_NEP = { 276.045975, 0.3256394, 0.00014095, 0.000004113 };
	double[] OIJ_NEP = { 130.681389, 1.098935, 0.00024987, -0.000004718 };
	// double[] EMJ_NEP = { 37.73063, 218.46134, -0.00007, 0. };

	GRAHAS Neptune = new GRAHAS(TJD_Epoch, AJ_NEP, EIJ_NEP, EJ_NEP, PIJ_NEP, OIJ_NEP, EPLN, AL_NEP, Graha_Name[6],
			Sun_Sayana, 6, EMSUN, Sun_Rad);
	Neptune.Graha_Longitude();
	double Nep_Sayana;
	Nep_Sayana = Neptune.get_TruLong();

	System.out.println(System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
			+ System.lineSeparator() + System.lineSeparator() + System.lineSeparator());

	Convert_Nir.NIRAYANA_Deg(" Lagna:     ", ASCND, RASIS);
	Graha_Rasi_Num[0] = Convert_Nir.get_Int_Rasi();
	Navamsa_Num[0] = Convert_Nir.get_Int_Navamsa();
	Chatur_Num[0] = Convert_Nir.get_Int_Chaturthamsa();
	Dasamsa_Num[0] = Convert_Nir.get_Int_Dasamsa();
	Dwadasamsa_Num[0] = Convert_Nir.get_Int_Dwadasamsa();
	Trimsamsa_Num[0] = Convert_Nir.get_Int_Trimsamsa();
	System.out.println(" Trimsamsa_Num[0] = " + Trimsamsa_Num[0]);
	OUT_DEG[2][0] = Nakshatras[Convert_Nir.get_Int_Nakshatra()];
	OUT_DEG[3][0] = java.lang.String.valueOf(Convert_Nir.get_Int_Pada());

	// Rasi # for Lagna
	Convert_Nir.NIRAYANA_Deg(" SUN:       ", Sun_Sayana, RASIS);
	Graha_Rasi_Num[1] = Convert_Nir.get_Int_Rasi(); // Rasi # for SUN
	Navamsa_Num[1] = Convert_Nir.get_Int_Navamsa();
	Chatur_Num[1] = Convert_Nir.get_Int_Chaturthamsa();
	Dasamsa_Num[1] = Convert_Nir.get_Int_Dasamsa();
	Dwadasamsa_Num[1] = Convert_Nir.get_Int_Dwadasamsa();
	Trimsamsa_Num[1] = Convert_Nir.get_Int_Trimsamsa();
	System.out.println(" Trimsamsa_Num[1] = " + Trimsamsa_Num[1]);
	OUT_DEG[2][1] = Nakshatras[Convert_Nir.get_Int_Nakshatra()];
	OUT_DEG[3][1] = java.lang.String.valueOf(Convert_Nir.get_Int_Pada());

	Convert_Nir.NIRAYANA_Deg(" MOON:      ", Moon_Rahu_Ketu_Long.get_ELMOON(), RASIS);
	Graha_Rasi_Num[2] = Convert_Nir.get_Int_Rasi(); // Rasi # for MOON
	Navamsa_Num[2] = Convert_Nir.get_Int_Navamsa();
	Chatur_Num[2] = Convert_Nir.get_Int_Chaturthamsa();
	OUT_DEG[1][2] = Convert_Nir.get_Nirayana();
	Dasamsa_Num[2] = Convert_Nir.get_Int_Dasamsa();
	Dwadasamsa_Num[2] = Convert_Nir.get_Int_Dwadasamsa();
	Trimsamsa_Num[2] = Convert_Nir.get_Int_Trimsamsa();
	System.out.println(" Trimsamsa_Num[2] = " + Trimsamsa_Num[2]);
	OUT_DEG[2][2] = Nakshatras[Convert_Nir.get_Int_Nakshatra()];
	OUT_DEG[3][2] = java.lang.String.valueOf(Convert_Nir.get_Int_Pada());
	
	Thithi thithi = new Thithi ( Sun_Sayana, Moon_Rahu_Ketu_Long.get_ELMOON());
	tithi = thithi.Get_Tithi();

	Convert_Nir.NIRAYANA_Deg(" RAHU:      ", Moon_Rahu_Ketu_Long.get_ELRAH(), RASIS);
	OUT_DEG[1][3] = Convert_Nir.get_Nirayana();
	Graha_Rasi_Num[3] = Convert_Nir.get_Int_Rasi(); // Rasi # for RAHU
	Navamsa_Num[3] = Convert_Nir.get_Int_Navamsa();
	Chatur_Num[3] = Convert_Nir.get_Int_Chaturthamsa();
	Dasamsa_Num[3] = Convert_Nir.get_Int_Dasamsa();
	Dwadasamsa_Num[3] = Convert_Nir.get_Int_Dwadasamsa();
	Trimsamsa_Num[3] = Convert_Nir.get_Int_Trimsamsa();
	System.out.println(" Trimsamsa_Num[3] = " + Trimsamsa_Num[3]);
	OUT_DEG[2][3] = Nakshatras[Convert_Nir.get_Int_Nakshatra()];
	OUT_DEG[3][3] = java.lang.String.valueOf(Convert_Nir.get_Int_Pada());

	Convert_Nir.NIRAYANA_Deg(" KETU:      ", Moon_Rahu_Ketu_Long.get_ELKET(), RASIS);
	OUT_DEG[1][4] = Convert_Nir.get_Nirayana();
	Navamsa_Num[4] = Convert_Nir.get_Int_Navamsa();
	Graha_Rasi_Num[4] = Convert_Nir.get_Int_Rasi(); // Rasi # for KETU
	Chatur_Num[4] = Convert_Nir.get_Int_Chaturthamsa();
	Dasamsa_Num[4] = Convert_Nir.get_Int_Dasamsa();
	Dwadasamsa_Num[4] = Convert_Nir.get_Int_Dwadasamsa();
	Trimsamsa_Num[4] = Convert_Nir.get_Int_Trimsamsa();
	System.out.println(" Trimsamsa_Num[4] = " + Trimsamsa_Num[4]);
	OUT_DEG[2][4] = Nakshatras[Convert_Nir.get_Int_Nakshatra()];
	OUT_DEG[3][4] = java.lang.String.valueOf(Convert_Nir.get_Int_Pada());

	Convert_Nir.NIRAYANA_Deg(" MERCURY:   ", Mercury_Sayana, RASIS);
	Graha_Rasi_Num[5] = Convert_Nir.get_Int_Rasi(); // Rasi # for MERCURY
	Navamsa_Num[5] = Convert_Nir.get_Int_Navamsa();
	Chatur_Num[5] = Convert_Nir.get_Int_Chaturthamsa();
	OUT_DEG[1][5] = Convert_Nir.get_Nirayana();
	Dasamsa_Num[5] = Convert_Nir.get_Int_Dasamsa();
	Dwadasamsa_Num[5] = Convert_Nir.get_Int_Dwadasamsa();
	Trimsamsa_Num[5] = Convert_Nir.get_Int_Trimsamsa();
	System.out.println(" Trimsamsa_Num[5] = " + Trimsamsa_Num[5]);
	OUT_DEG[2][5] = Nakshatras[Convert_Nir.get_Int_Nakshatra()];
	OUT_DEG[3][5] = java.lang.String.valueOf(Convert_Nir.get_Int_Pada());

	Convert_Nir.NIRAYANA_Deg(" VENUS:     ", Venus_Sayana, RASIS);
	OUT_DEG[1][6] = Convert_Nir.get_Nirayana();
	Navamsa_Num[6] = Convert_Nir.get_Int_Navamsa();
	Chatur_Num[6] = Convert_Nir.get_Int_Chaturthamsa();
	Graha_Rasi_Num[6] = Convert_Nir.get_Int_Rasi(); // Rasi # for VENUS
	Dasamsa_Num[6] = Convert_Nir.get_Int_Dasamsa();
	Dwadasamsa_Num[6] = Convert_Nir.get_Int_Dwadasamsa();
	Trimsamsa_Num[6] = Convert_Nir.get_Int_Trimsamsa();
	System.out.println(" Trimsamsa_Num[6] = " + Trimsamsa_Num[6]);
	OUT_DEG[2][6] = Nakshatras[Convert_Nir.get_Int_Nakshatra()];
	OUT_DEG[3][6] = java.lang.String.valueOf(Convert_Nir.get_Int_Pada());

	Convert_Nir.NIRAYANA_Deg(" MARS:      ", Mars_Sayana, RASIS);
	OUT_DEG[1][7] = Convert_Nir.get_Nirayana();
	Navamsa_Num[7] = Convert_Nir.get_Int_Navamsa();
	Graha_Rasi_Num[7] = Convert_Nir.get_Int_Rasi(); // Rasi # for MARS
	Chatur_Num[7] = Convert_Nir.get_Int_Chaturthamsa();
	Dasamsa_Num[7] = Convert_Nir.get_Int_Dasamsa();
	Dwadasamsa_Num[7] = Convert_Nir.get_Int_Dwadasamsa();
	Trimsamsa_Num[7] = Convert_Nir.get_Int_Trimsamsa();
	System.out.println(" Trimsamsa_Num[7] = " + Trimsamsa_Num[7]);
	OUT_DEG[2][7] = Nakshatras[Convert_Nir.get_Int_Nakshatra()];
	OUT_DEG[3][7] = java.lang.String.valueOf(Convert_Nir.get_Int_Pada());

	Convert_Nir.NIRAYANA_Deg(" JUPITER:   ", Jup_Sayana, RASIS);
	OUT_DEG[1][8] = Convert_Nir.get_Nirayana();
	Navamsa_Num[8] = Convert_Nir.get_Int_Navamsa();
	Graha_Rasi_Num[8] = Convert_Nir.get_Int_Rasi(); // Rasi # for JUPITER
	Chatur_Num[8] = Convert_Nir.get_Int_Chaturthamsa();
	Dasamsa_Num[8] = Convert_Nir.get_Int_Dasamsa();
	Dwadasamsa_Num[8] = Convert_Nir.get_Int_Dwadasamsa();
	Trimsamsa_Num[8] = Convert_Nir.get_Int_Trimsamsa();
	System.out.println(" Trimsamsa_Num[8] = " + Trimsamsa_Num[8]);
	OUT_DEG[2][8] = Nakshatras[Convert_Nir.get_Int_Nakshatra()];
	OUT_DEG[3][8] = java.lang.String.valueOf(Convert_Nir.get_Int_Pada());

	Convert_Nir.NIRAYANA_Deg(" SATURN:    ", Sat_Sayana, RASIS);
	OUT_DEG[1][9] = Convert_Nir.get_Nirayana();
	Graha_Rasi_Num[9] = Convert_Nir.get_Int_Rasi(); // Rasi # for SATURN
	Navamsa_Num[9] = Convert_Nir.get_Int_Navamsa();
	Chatur_Num[9] = Convert_Nir.get_Int_Chaturthamsa();
	Dasamsa_Num[9] = Convert_Nir.get_Int_Dasamsa();
	Dwadasamsa_Num[9] = Convert_Nir.get_Int_Dwadasamsa();
	Trimsamsa_Num[9] = Convert_Nir.get_Int_Trimsamsa();
	System.out.println(" Trimsamsa_Num[9] = " + Trimsamsa_Num[9]);
	OUT_DEG[2][9] = Nakshatras[Convert_Nir.get_Int_Nakshatra()];
	OUT_DEG[3][9] = java.lang.String.valueOf(Convert_Nir.get_Int_Pada());

	Convert_Nir.NIRAYANA_Deg(" URANUS:    ", Ura_Sayana, RASIS);
	Convert_Nir.NIRAYANA_Deg(" NEPTUNE:   ", Nep_Sayana, RASIS);

	for (int i = 0; i < 10; i++) {
		OUT_DEG[4][i] = "         " + RASIS[Graha_Rasi_Num[i]];
		OUT_DEG[5][i] = "     " + RASIS[Navamsa_Num[i]];

	}

	for (int i = 0; i < 10; i++) {
		Graha_Abr[i] = OUT_DEG[0][i];
	}
	
	
	}
	
	
	/*
	
	static String[][] OUT_DEG = new String[6][10];
	static int[] Graha_Rasi_Num = new int[12];
	static int[] Navamsa_Num = new int[12];
	static int[] Chatur_Num = new int[12];
	int[] Dasamsa_Num = new int[12];
	int[] Dwadasamsa_Num = new int[12];
	int[] Trimsamsa_Num = new int[12];
	
	
	*/
	
	public String[][] get_OUT_DEG ()
    {
    	return OUT_DEG;
    }
	
	public int[] get_Graha_Rasi_Num ()
    {
    	return Graha_Rasi_Num;
    }
	
	public int[] get_Navamsa_Num ()
    {
    	return Navamsa_Num;
    }
	
	public int[] get_Dasamsa_Num ()
    {
    	return Dasamsa_Num;
    }
	
	public int[] get_Dwadasamsa_Num ()
    {
    	return Dwadasamsa_Num;
    }
	
	public int[] get_Trimsamsa_Num ()
    {
    	return Trimsamsa_Num;
    }
	
	public int[] get_Chatur_Num ()
    {
    	return Chatur_Num;
    }
	
	public String[] get_Graha_Abr ()
    {
    	return Graha_Abr;
    }
	
	public String get_WeekDay ()
    {
    	return WEEKDY;
    }
	
	public String get_Tithi ()
    {
    	return tithi;
    }
	
	
	
	
	
	

}
