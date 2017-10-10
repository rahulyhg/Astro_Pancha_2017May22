package PANCHA;

public class Deltat {
	
	static double TJD_UT0, JD_UT0;
	static double CJD;
	static int YEAR;
	static int MON;
	static int DAY;
	static int HOUR;
	static int Min;
	int[] IYEARS = new int [] {1710, 1730, 1750, 1770,1800,1840, 1870, 1880, 1895, 1903, 1912, 1927, 1940, 1950, 1965, 1971, 1977, 1987 };
	double[] DELT = new double [] { -0.2, -0.1, -0., 0.1, 0.1, 0., 0.,-0.1, -0.1, 0., 0.2, 0.4, 0.4, 0.5, 0.6, 0.7, 0.8, 1.  };
	
	
	//.....................................................................
	//   Calculate the difference DT ( IN MINUTES ) between Ephemeris Time 
	//   and Universal time for a given century
	//.....................................................................
	public Deltat ( int Yr, int Mo, int Da, int Hr, int Mt)
    {
    	
    	YEAR = Yr;
    	MON = Mo;
    	DAY = Da;
    	HOUR = Hr;
    	Min = Mt;
    	
    	
    	
    	System.out.println("The Time of Epoch: [] " +
        		YEAR + " - " + MON + " - " + DAY + " - " + HOUR + ":" + Min  );
    	
    	
    	
    }
	
	double DT, T ;
	public void Diff ()
	{
		System.out.println ( IYEARS[8] + "  " + IYEARS[10] );
		int I = 0;
		while (I < 17) 
		{
			if ( YEAR >= IYEARS[ I ] && YEAR <= IYEARS[ I+1 ] ) DT = DELT [ I ] + ( DELT [ I+1 ] - DELT [ I] ) * 
					( YEAR - IYEARS [ I] ) / ( IYEARS [ I+1 ] - IYEARS [ I] );
			I++;			
		}
		
		if ( YEAR < IYEARS [ 0 ] || YEAR > IYEARS [ 17 ])
		{
			T = ( YEAR - 1900 ) / 100.;
			DT = 0.41 + T * ( 1.2053 + T * 0.4992 );
		}
		
		System.out.println( " DELTAT = " + DT );
		
	}
	
	public double get_DT ()
    {
    	return DT;
    }

}
