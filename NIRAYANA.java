package PANCHA;

public class NIRAYANA {

	
	static double AYANAMSA;
	static double TJD, Deg_Nirayana;
	String RASI;
	double Degree, Minute, Second;
	String out_Graha;
	String Str_Nirayana;
	int Int_Rasi;
	int Int_Navamsa;
	int Int_Chaturthamsa, Int_Dasamsa, Int_Trimsamsa, Int_Dwadasamsa;
	int Int_Nakshatra, Int_Pada;
	
	
	public NIRAYANA (double T)
	{
		TJD = T;      // T  is calculated for the day of the Epoch in the UT0_GREEN class 
		AYANAMSA = ( 50.2564 * TJD * 100. + TJD * TJD * 10000. * 0.000222 ) /3600. + 22.4694870833333;
		//System.out.println( " AYANAMSA = " + AYANAMSA );

	}
	
	public void NIRAYANA_Deg( String Graha, double Deg_Sayana, String[] RASIS )
	{
		Deg_Nirayana= Deg_Sayana - AYANAMSA;
		if ( Deg_Nirayana < 0 ) Deg_Nirayana = Deg_Nirayana + 360. ;
		
		//System.out.println( " Sayana Degrees" + Deg_Sayana + " Nirayana Degrees " + Deg_Nirayana );
		
		Int_Rasi = (int) ( Deg_Nirayana / 30 );
		
		
		// Calculate the Navamsa (D-9) position - Navamsa house numbers-----
		
		Int_Navamsa = (int) ((Deg_Nirayana * 0.3) % 12);
		RASI = RASIS [ (int) ( Deg_Nirayana / 30 ) ];
		
		Degree = Deg_Nirayana - 30.* (int) ( Deg_Nirayana / 30 );
		Minute = ( Degree - (int) Degree ) * 60 ;
		Second = ( Minute - (int) Minute ) * 60 ;
		
		
		// Calculate the Chaturtamsa (D-4) position - Chaturtamsa house numbers-----
		
		Int_Chaturthamsa = ( Int_Rasi + (int) ( Degree / 7.5 ) * 3 ) % 12;
		
		// Calculate the Dasamsa (D-10) position - Dasamsa house numbers-----
		
		Int_Dasamsa = ( Int_Rasi + (int) ( Degree / 3 )) % 12;
		if ( Int_Rasi % 2 != 0 ) Int_Dasamsa = ( Int_Dasamsa + 8 ) % 12;
				
		// Calculate the Dwadasamsa (D-12) position - Dwadasamsa house numbers-----
		
				Int_Dwadasamsa = ( Int_Rasi + (int) ( Degree * 60 / 150 )) % 12;
						
				
				// Calculate the Trimamsa (D-30) position - Trimsamsa house numbers-----
		
		if ( Int_Rasi % 2 == 0 ) {
			if ( Degree >= 0 && Degree < 5. ) Int_Trimsamsa = 0;
			if ( Degree >= 5 && Degree < 10. ) Int_Trimsamsa = 10;
			if ( Degree >= 10 && Degree < 18. ) Int_Trimsamsa = 8;
			if ( Degree >= 18 && Degree < 25. ) Int_Trimsamsa = 2;
			if ( Degree >= 25 && Degree < 30. ) Int_Trimsamsa = 6;
			
		}
		
		if ( Int_Rasi % 2 != 0 ) {
			if ( Degree >= 0 && Degree < 5. ) Int_Trimsamsa = 1;
			if ( Degree >= 5 && Degree < 12. ) Int_Trimsamsa = 5;
			if ( Degree >= 12 && Degree < 20. ) Int_Trimsamsa = 11;
			if ( Degree >= 20 && Degree < 25. ) Int_Trimsamsa = 9;
			if ( Degree >= 25 && Degree < 30. ) Int_Trimsamsa = 7;
			
		}
		
		// Calculate the Nakshatra - Nakshatra numbers-----
		
		Int_Nakshatra = (int) ( Deg_Nirayana * 3 / 40 );
		Int_Pada = (int) (( Deg_Nirayana * 60 - Int_Nakshatra * 800 ) / 200 ) + 1;
		
		
		String twoDigit_Deg = String.format("%2d", (int) Degree);
		String twoDigit_Min = String.format("%2d", (int) Minute);
		String twoDigit_Sec = String.format("%2d", (int) Second);
		
		 out_Graha = Graha + "                      " +   twoDigit_Deg + "  " +
		 RASI + "  " + twoDigit_Min + "  Min    "  + twoDigit_Sec + " Sec" + "    " + Int_Rasi + "    " + Int_Navamsa +
		 "    " + Int_Chaturthamsa + "    " + Int_Dasamsa + "    " + Int_Dwadasamsa + "    " + Int_Trimsamsa + "   " + 
		 Int_Nakshatra + "    " + Int_Pada;
		
		 //Str_Nirayana =   twoDigit_Deg + " " +  RASI + "  " + twoDigit_Min + "' "  + twoDigit_Sec + '"' + "    " + Int_Rasi + "    " + Int_Navamsa; 
		 Str_Nirayana =     twoDigit_Deg + " " +  RASI + "  " + twoDigit_Min + "' "  + twoDigit_Sec + '"' + "\t" ; 
			
		 
		 //System.out.println( Graha + "          " +   twoDigit_Deg + "  " + RASI + "  " + twoDigit_Min + "  Min    "  + twoDigit_Sec + " Sec"  );
		System.out.println( out_Graha );
		
		
		//System.out.println( " Rasi  " + RASI  );
	}
	
	
	
	public String get_outGraha()
    {
    	return out_Graha;
    }
	public String get_Nirayana()
    {
    	return Str_Nirayana;
    }
	public int get_Int_Rasi()
    {
    	return Int_Rasi;
    }
	
	public int get_Int_Navamsa()
    {
    	return Int_Navamsa;
    }
	
	public int get_Int_Chaturthamsa()
    {
    	return Int_Chaturthamsa;
    }
	public int get_Int_Dasamsa()
    {
    	return Int_Dasamsa;
    }
	public int get_Int_Dwadasamsa()
    {
    	return Int_Dwadasamsa;
    }
	public int get_Int_Trimsamsa()
    {
    	return Int_Trimsamsa;
    }
	public int get_Int_Nakshatra()
    {
    	return Int_Nakshatra;
    }
	public int get_Int_Pada()
    {
    	return Int_Pada;
    }

}

