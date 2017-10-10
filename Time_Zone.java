package PANCHA;

	class Time_Zone {
		static String E_W;
		int HOUR_ZONE, MIN_ZONE;
		static double Longitude, Latitude;
		static double FRUNIV;
		
		
	
	 public Time_Zone( int Hr, int Min, double ELNGT, double ELTD, String EW )
	    {
	    	
	    	HOUR_ZONE = Hr;
	    	MIN_ZONE = Min;
	    	E_W = EW;
	    	Longitude = ELNGT;
	    	Latitude = ELTD;
	    	
	    }
	 
	    static int YEAR;
		static int MON;
		static int DAY;
		static int HOUR;
		static int MIN;
	    int  ILPY, IY_by_100, ILEAP, IL_100, IL_400, IY_by_400;
	    double YLPYN, Y_by_100, FY100, Y_by_400;
	    
	    boolean LEAP, L_100, L_400;
	    
	    
	    double HT_MT;
	    
	    int DAY_GREEN, HOUR_GREEN, MIN_GREEN, MON_GREEN, YEAR_GREEN, DAY_MAX;
	    
	    public void Green_Time ( int Yr, int Mon, int Day, int Hr, int Minute, String AM_PM, int HT, int MT, String E_W )
	    {
	    	int YEAR_Trial = 1948 ;
	    	//YEAR = YEAR_Trial;
	    	YEAR = Yr;
	    	MON = Mon;
	    	DAY = Day;
	    	HOUR = Hr;
	    	MIN = Minute;
	    	
	    	if ( AM_PM == "PM") HOUR = HOUR + 12;
	    	
	    	System.out.println();
	    	System.out.println( " HOUR " + HOUR + " Min " + MIN + " HT " + HT + " MT " + MT);
	    	
	    	// First determine if the year of the epoch is a leap year.
	    	
	    	System.out.println ( " FROM TIME_ZONE ________________" );
	    	
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
	      	System.out.println ( " L_400 = " + L_400 + " IL_400 = " + IL_400 );	

	      	// Convert the time of Epoch to Greenwich time
	      	
	      	
	      		HT_MT  = HT + MT / 60.;
	      		HOUR_GREEN = HOUR + HT;
	      		
	      		System.out.println();
		    	System.out.println( " HOUR_GREEN " + HOUR_GREEN + " Min " + MIN );
		    	
	      		MIN_GREEN = MIN + MT;
	      		if (MIN_GREEN >= 60 )
	      		{
	      			MIN_GREEN = MIN_GREEN - 60;
	      			HOUR_GREEN = HOUR_GREEN + 1;	      			
	      		}
	      		
	      		if (MIN_GREEN < 0 )
	      		{
	      			MIN_GREEN = MIN_GREEN + 60;
	      			HOUR_GREEN = HOUR_GREEN - 1;	      			
	      		}
	      		
	      		
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
	            
	            
	            
	            //Check the following - Between this 
	          /*  DAY_MAX = 30;
	            if ( MON_GREEN == 1 || MON_GREEN == 3 || MON_GREEN == 5 || 
	            		MON_GREEN == 7 || MON_GREEN == 8 || MON_GREEN == 10
	            		|| MON_GREEN == 12 ) DAY_MAX = 31;
	            
	            if ( MON_GREEN == 2 ) 
	            {
	            	DAY_GREEN = 28;
	                if ( LEAP ) DAY_GREEN = 29;                 
	            } */
	            
	            // and the line above
	            
	            
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
	            
	            
	            System.out.println("The Time Difference of Epoch at Greenwich : " +
	            		HT  + " Hours " + MT + " Minutes " ); 

	            System.out.println("The Time of Epoch at Greenwich : " +
	            		YEAR_GREEN + " - " + MON_GREEN + " - " + DAY_GREEN+ " _____ " 
	            		+ HOUR_GREEN + ":" + MIN_GREEN ); 
	            FRUNIV = HOUR_GREEN + MIN_GREEN / 60.;
	            FRUNIV = FRUNIV / 24.;
	            		
       	      System.out.println( " FROM Time-Zone FRUNIV " + FRUNIV);
	    } 
	 
	    public static double get_FRUNIV ()
	    {
	    	return FRUNIV;
	    }
	    public int get_YEAR_GREEN ()
	    {
	    	return YEAR_GREEN;
	    }
	    
	    public int get_MON_GREEN ()
	    {
	    	return MON_GREEN;
	    }
	    public int get_DAY_GREEN ()
	    {
	    	return DAY_GREEN;
	    }
	    public int get_HOUR_GREEN ()
	    {
	    	return HOUR_GREEN;
	    }
	    public int get_MIN_GREEN ()
	    {
	    	return MIN_GREEN;
	    }
	 
	}
