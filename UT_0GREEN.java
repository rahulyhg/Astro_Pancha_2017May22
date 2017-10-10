package PANCHA;

class UT_0GREEN {
	
	
	
	static double TJD_UT0, JD_UT0;        // JD_UT0 = Julian day; 
	static double CJD, CJD_0Hour;
	static int YEAR;
	static int MON;
	static int DAY;
	static int HOUR;
	static int Min;
	static int AM_PM;
	double Y;
	double EM;
	double TDAY, TDAY_0Hour;
	double PI, FRDAY, GORNOT,FIA,FIB, FRACT, TJD, TJD_0Hour;
	double FRDAY_Plus, TJD_Plus, TDAY_Plus, CJD_Plus;
	String WEEKDAY, WEEKD_0;
	
	//int JD1, JD2;
	double JD1, JD2;
	int IA, IB, IDAY_0;
	
    public UT_0GREEN( int Yr, int Mo, int Da, int Hr, int Mt, int AMPM)
    {
    	
    	YEAR = Yr;
    	MON = Mo;
    	DAY = Da;
    	HOUR = Hr;
    	Min = Mt;
    	AM_PM = AMPM;
    	
    	//if ( AM_PM == 2 ) HOUR = Hr + 12;
   
    	System.out.println("The Time of Epoch: [UT_0GREEN] " +
        		YEAR + " - " + MON + " - " + DAY + " - " + HOUR + ":" + Min + " AM_PM " + AM_PM );
    	
    }
    // Calculate Julian date for a given calendar date	
    
    
    public void Julian ()
    {
    	PI = ALL.PI;
    	System.out.println( " pi = " + PI);  	  	
    	
    	FRDAY = ( HOUR * 1. + Min / 60. ) / 24.;
    	
    	//.................................................................................................................
    	//    Calculate TJD for slightly advanced time to see if a planet is in retrogade
    	//.................................................................................................................
    	FRDAY_Plus = FRDAY * 1.01;
    	//.................................................................................................................
    	TDAY = DAY * 1. + FRDAY;
    	TDAY_Plus = DAY * 1. + FRDAY_Plus;
    	TDAY_0Hour = DAY * 1.;
    	FRACT = MON/100. + TDAY / 10000.;
    	GORNOT = YEAR + FRACT;
    	
    	System.out.println (" JULIAN - FRDAY = " + FRDAY + " TDAY = " + TDAY + " TDAY_Plus = " + TDAY_Plus  );
    	System.out.println ( "  FRACT = " + FRACT + "  GORNOT = " + GORNOT ) ;
    	
        if ( MON > 2 ) 
        {
        	Y = YEAR;
            EM = MON;
        }
     
        
        if ( MON <= 2 ) 
        {
            Y =  YEAR - 1;
            EM = MON + 12.;           	   
        }
        
        IB = 0;
        IA = 0;
        IDAY_0 = (int) TDAY ;
        FIB = 0.;
        
  
        if ( GORNOT > 1582.1015 ) 
        {
        	FIA = Y / 100.;
        	IA = (int) FIA ;
        	        
        	FIB = 2. - IA +  ( IA / 4 );
        	 IB = 2 - IA + (int)( IA / 4 );
        }

    
        
        //JD1 = (int) ( 365.25 * Y );
       // JD2 = (int) ( 30.6001 * (  EM + 1. ));
        
        
        
        JD1 =  ( 365.25 * Y );
        JD2 =  ( 30.6001 * (  EM + 1. ));
        
        
        
        CJD = (int) JD1 + (int) JD2 + TDAY + 1720994.5 + FIB;
        CJD_Plus = (int) JD1 + (int) JD2 + TDAY_Plus + 1720994.5 + FIB;
        
        
        JD_UT0 = JD1 + JD2 + IDAY_0 + 1720994.5 + IB;
        TJD = ( CJD-2415020. ) / 36525.;
        TJD_UT0 = ( JD_UT0-2415020. ) / 36525.;
        
        TJD_Plus =  ( CJD_Plus-2415020. ) / 36525.;
       
        CJD_0Hour = (int) JD1 + (int) JD2 + TDAY_0Hour + 1720994.5 + FIB;
        TJD_0Hour = ( CJD_0Hour-2415020. ) / 36525.;
        	         	
    	// check JD2 
        System.out.println ( " IA = " + IA + " IB = " + IB );
        System.out.println ( " FIA = " + FIA + " FIB = " + FIB );
        System.out.println ( " JD1 = " + JD1 + " JD2 = " +  JD2 );
        System.out.println ( " CJD = " + CJD + " JD_UT0 = " +  JD_UT0 + " CJD_Plus = " + CJD_Plus ) ;
        System.out.println ( " TJD = " + TJD + " TJD_UT0 = " + TJD_UT0 + " TJD_Plus = " + TJD_Plus ) ;
        
        System.out.println ( " TJD_0Hour = " + TJD_0Hour + " CJD_0Hour = " + CJD_0Hour ) ;
        
        
        
    }
      		
    public double get_CJD ()
    {
    	return CJD;
    }
    public double get_TJD ()
    {
    	return TJD;
    }
    public double get_TJD_UT0 ()
    {
    	return TJD_UT0;
    }
    
    public double get_TJD_0Hour ()
    {
    	return TJD_0Hour;
    }
    
    public double get_CJD_Plus ()
    {
    	return CJD_Plus;
    }
    public double get_TJD_Plus ()
    {
    	return TJD_Plus;
    }
    
    
    
    //.....................................................................
    //   Calculate the Calendar Date including day of the week for a given Julian Date
    //.....................................................................
    
    //double CJD_Input 

    double Z, F, A, B, EDAY, FR, EIH, FIH, EMIN,WEEK;
    int JZ,JALPHA, JC, JAD, JE, ID, IH, MO, IY, IWEEK;
  
    
    public void Calen ( )
    {	
        Z = CJD + 0.5; 
        JZ = (int) ( Z ); 
        F = Z - JZ;
        A = Z;
        if ( JZ >= 2299161 ) 
        {
        	JALPHA = (int) (( JZ-1867216.25 ) / 36524.25 );
        	A = JZ + 1 + JALPHA - (int) ( JALPHA / 4. );
        }
        
 
        
        B = A + 1524; 
        JC = (int) (( B-122.1 ) / 365.25 );
        JAD = (int) ( 365.25 * JC );
        JE = (int) (( B-JAD ) / 30.6001 );
        EDAY = B - JAD - (int) ( 30.6001 * JE ) + F ;
        ID = (int) ( EDAY );
        FR = EDAY - ID;
        EIH = FR * 24.;
        IH = (int) ( EIH );
        FIH = EIH - IH ;
        EMIN = FIH * 60.;
               
        if ( JE < 13.5 ) MO = JE-1;
        if ( JE > 13.5 ) MO = JE-13;
        if ( JC > 2.5 ) IY = JC - 4716;
        if ( JC < 2.5 ) IY = JC - 4715;
        WEEK = ( CJD + 1.5 ) / 7.;
        IWEEK = (int) ( WEEK );
        IWEEK = (int) (( WEEK - IWEEK ) * 7.);
      
        System.out.println ( "IY = " + IY + " MO " + MO + " ID " + ID + " IH " + ID + " EMIN "
        		+ EMIN + " WEEK " + WEEK + " IWEEK " + IWEEK );  
        
        if ( IWEEK == 0 ) WEEKDAY = "SUNDAY";
        if ( IWEEK == 1 ) WEEKDAY = "MONDAY";
        if ( IWEEK == 2 ) WEEKDAY = "TUESDAY";
        if ( IWEEK == 3 ) WEEKDAY = "WEDNESDAY";
        if ( IWEEK == 4 ) WEEKDAY = "THURSDAY";
        if ( IWEEK == 5 ) WEEKDAY = "FRIDAY";
        if ( IWEEK == 6 ) WEEKDAY = "SATURDAY";
        
        System.out.println ( WEEKDAY );
 
    }
    
    public int get_YEAR ()
    {
    	return YEAR;
    }
    
    public int get_MONTH ()
    {
    	return MON;
    }
    
    public int get_DAY ()
    {
    	return DAY;
    }
    
    public int get_HOUR ()
    {
    	return HOUR;
    }
    
    public int get_MINUTE ()
    {
    	return Min;
    }
    
    
    public String get_WEEKDAY ()
    {
    	return WEEKDAY;
    }
    
    int  ILPY, IY_by_100, ILEAP, IL_100, IL_400, IY_by_400;
    double YLPYN, Y_by_100, FY100, Y_by_400;
    
    boolean LEAP, L_100, L_400;
    
    
    double HT_MT;
    
    int DAY_GREEN, HOUR_GREEN, MON_GREEN, YEAR_GREEN, DAY_MAX;
    
    public void Green_Time ( int HT, int MT, String E_W )
    {
    	int YEAR_Trial = 1948 ;
    	YEAR = YEAR_Trial;
    	
    	// First determine if the year of the epoch is a leap year.
    	
        LEAP = true ;
        L_100 = true ;
        YLPYN = YEAR / 4.;
        ILPY = (int)  YLPYN  ; 
        ILPY = ILPY * 4;
        
        ILEAP = YEAR - ILPY ;
        if ( ILEAP > 0 ) LEAP = false;
        if  ( !LEAP ) L_100 = false;
        
        
        	Y_by_100 = YEAR / 100.;
          	IY_by_100 = (int) Y_by_100 ;
          	System.out.println ( " IY_by_100 = " + IY_by_100 );
          	IY_by_100 = IY_by_100 * 100;
          	System.out.println ( " IY_by_100 = " + IY_by_100 );
          	IL_100 = YEAR - IY_by_100;
          	System.out.println ( " IL_100 = " + IL_100 );
          	if ( IL_100 > 0 ) L_100 = false;
          	System.out.println ( " LEAP = " + LEAP + " ILEAP = " + ILEAP );
           	System.out.println ( " L_100 = " + L_100 + " IL_100 " + IL_100 );
           	
           	Y_by_400 = YEAR / 400.;
          	IY_by_400 = (int) Y_by_400 ;
          	System.out.println ( " IY_by_400 = " + IY_by_400 );
          	IY_by_400 = IY_by_400 * 400;
          	System.out.println ( " IY_by_400 = " + IY_by_400 );
          	IL_400 = YEAR - IY_by_400;
          	System.out.println ( " IL_400 = " + IL_400 );
           	
          	if ( LEAP )
          		if ( L_100)
          		{
          			
                  	if ( IL_400 > 0 ) L_400 = false;
                  	if ( IL_400 == 0 ) L_400 = true;
                  	if ( IL_400 > 0 ) LEAP = false;
                  	
          		}
  
        System.out.println ( " LEAP = " + LEAP + " ILEAP = " + ILEAP );
      	System.out.println ( " L_400 = " + L_400 + " IL_400 " + IL_400 );	

      	// Convert the time of Epoch to Greenwich time
      	
      	
      		HT_MT  = HT + MT / 60.;
      		HOUR_GREEN = HOUR + HT;
      		DAY_GREEN = DAY;
        	if ( HOUR_GREEN >= 24 ) 
        	{
        		DAY_GREEN = DAY + 1;
              	HOUR_GREEN = HOUR_GREEN - 24;
        	}
        	
        	if ( HOUR_GREEN < 0 ) 
        	{
        		DAY_GREEN = DAY - 1;
              	HOUR_GREEN = HOUR_GREEN + 24;
        	}
        	
        	// THe following variable is not used anywhere. Remove it after verifying.
        	double H_GREEN = HOUR + HT_MT;
        	
        	YEAR_GREEN = YEAR;
            MON_GREEN = MON;
            
            if ( DAY_GREEN == 0 ) MON_GREEN = MON - 1 ;
            if ( MON_GREEN == 0 )
            	{
            	YEAR_GREEN = YEAR - 1 ;
            	MON_GREEN = 12;
            	}
            
            DAY_GREEN = 30;
            if ( MON_GREEN == 1 || MON_GREEN == 3 || MON_GREEN == 5 || 
            		MON_GREEN == 7 || MON_GREEN == 8 || MON_GREEN == 10
            		|| MON_GREEN == 12 ) DAY_GREEN = 31;
            
            if ( MON_GREEN == 2 ) 
            {
            	DAY_GREEN = 28;
                if ( LEAP ) DAY_GREEN = 29;                 
            }
            
            DAY_MAX = 30;
            if ( MON_GREEN == 1 || MON_GREEN == 3 || MON_GREEN == 5 || 
            		MON_GREEN == 7 || MON_GREEN == 8 || MON_GREEN == 10
            		|| MON_GREEN == 12 ) DAY_MAX = 31;
            
            if ( MON_GREEN == 2 ) 
            {
            	DAY_MAX = 28;
                if ( LEAP ) DAY_MAX = 29;                 
            }
            
            if ( DAY_GREEN > DAY_MAX )
            {
            	DAY_GREEN = 1;
                MON_GREEN = MON + 1;
                        if ( MON_GREEN > 12 )
                        {
                        	MON_GREEN = 1;
                            YEAR_GREEN = YEAR + 1;
                        }
            }
            

        
        	      
    }
    
    
}

