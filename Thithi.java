package PANCHA;

import java.text.DecimalFormat;

public class Thithi {
	
	
	double Sun_Long, Moon_Long;
	double Moon_Sun;
	int tithi_Num;
	String Tithi, Paksha;
	String[] tithis = new String[] { "Pratipat", "Dwitiya", "Tritiya", "Chaturthi", "Panchami", "Shashti", 
			"Saptami", "Ashtami", "Navami", "Dasami", "Ekadasi", "Dwadasi", "Trayodasi", "Chaturdasi", "Pournima_or_Amavasya" };
	public Thithi (double Long_Sun, double Long_Moon )
	{
		Sun_Long = Long_Sun;
		Moon_Long = Long_Moon;
	}
	
	public String Get_Tithi() {
		Moon_Sun = Moon_Long - Sun_Long;
		System.out.println( " Moon Longitude - Sun Longitude = " + Moon_Sun );
		if ( Moon_Sun <= 0 ) Moon_Sun += 360;
		System.out.println( " Moon Longitude - Sun Longitude = " + Moon_Sun );
		Paksha = "Sukla";
		if (  Moon_Sun >= 180 ) 
			{
			Moon_Sun -= 180;
			Paksha = "Krishna";
			}
		System.out.println( " Moon Longitude - Sun Longitude = " + Moon_Sun );
		tithi_Num = (int) Moon_Sun / 12 ;
		
		
		Tithi = "Tithi:         "  + Paksha + "  " + tithis [ tithi_Num ] + "   " + new DecimalFormat("#.##").format( ( Moon_Sun - 12 * tithi_Num ) * 25. / 3.) + " % Complete " ;
		
		System.out.println( " Thithi: " + Tithi );
		return Tithi;
		
		
	}
	

}
