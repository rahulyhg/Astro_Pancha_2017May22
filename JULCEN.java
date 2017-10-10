package PANCHA;

public class JULCEN {
	static double TJD;
	static double TJD0, ELNGT, ELTD, FRUNIV, SIDE0, SIDE, SIDEL, ASCEND, EMC, T;
	String EW;
	double EO_1950, EO_2000 ;
	double SIDE0D, SIDED ;
	double ELONG;
	double SIDELD;
	double EOBLIQ;
	double PNUM, PDEN;
	double ATND, ATQD, ASCND;
	
	// TJD_UT0,ELNGT,ELTD,FRD_GR,SIDE0,SIDE,SIDEL,ATQD,EMC
	
	public JULCEN ( double TJD_UT0, double longitude, double latitude, double FR_univ, String E_W )
    {    	
    	TJD0 = TJD_UT0;
    	ELNGT = longitude;
    	ELTD = latitude;
    	FRUNIV = FR_univ;
    	EW = E_W;
    	System.out.println( " TJD0 = " + TJD0 + " Longitude " + ELNGT + " Latitude = " + ELTD );
    }
 
	//.......................................................................
	//..........SIDEREAL TIME CALCULATION...................
	//.......................................................................
    
	public void ascend()
	{
		
		EO_1950 = 23.4457889 ;
		EO_2000 = 23.4392911 ;
		
		
		//  FRUNIV = 0.36839583;           // Junk this
		
		
		T = TJD0 ;
		 // T = 0.8796030116358659;                     // Junk this
		SIDE0 = 0.276919398 + T * ( 100.0021359 + T * 0.000001075 ) ;
	    System.out.println ( "TJD0 = " + TJD0 + "    SIDE0 = " +  SIDE0 ) ;
	    int ISIDE0 = (int) SIDE0 ;
		SIDE0 = ( SIDE0 - ( int ) SIDE0 ) * 24.0 ;
		
		SIDE0D = SIDE0 * 15.;
		System.out.println( " SIDE0D = " + SIDE0D + " SIDE0 = " + SIDE0 );
		
		SIDE = SIDE0 + FRUNIV * 1.002737908 * 24 ;
	    SIDED = SIDE * 15.;
		

	    ELONG = ELNGT;
	    if ( EW == "E" ) ELONG = - ELNGT;
	    
	    //SIDEL = SIDE - ELNGT / 15.;
	    SIDEL = SIDE - ELNGT / 15.;
	    SIDELD = SIDED - ELONG ;
	    
	    if ( SIDELD > 360. ) SIDELD = SIDELD - 360.;
	    if ( SIDELD < 0. ) SIDELD = SIDELD + 360.;
	    if ( SIDEL > 24. ) SIDEL = SIDEL - 24.;
	    if ( SIDEL <  0. ) SIDEL = SIDEL + 24. ;
	    
	    System.out.println( " SIDELD = " + SIDELD + " SIDEL = " + SIDEL );
	    
	    //EOBLIQ = 23.452294 - T * ( 0.0130125 + T * ( 0.00000164 - 0.000000503 * T ));
	    
	    EOBLIQ = 23.0 + 26.0/60.0 + 21.448/3600.0 - (46.8150*T + 0.00059*T*T - 0.001813*T*T*T)/3600;
	    
	    PNUM = - Trig.DegCOS ( SIDELD );
	    PDEN = Trig.DegSIN ( EOBLIQ ) * Trig.DegTAN ( ELTD ) + Trig.DegCOS ( EOBLIQ ) * Trig.DegSIN ( SIDELD );
	    System.out.println( " ELNGT = " + ELNGT + " ELONG = " + ELONG + " EOBLIQ  = " + EOBLIQ + " ELTD =" + ELTD + " SIDELD " + SIDELD );
	    System.out.println ( " PNUM = " + PNUM + "  PDEN = " + PDEN );
   
	    ATND = Trig.INTAN(PNUM, PDEN); 
	    System.out.println(" ATND = " + ATND );
	    
	    	      
	    ATQD = Trig.INTAN1(PNUM, PDEN); 
	      

	    ATQD = ATQD + 180.;
	    if ( ATQD >= 360. ) ATQD = ATQD - 360.;
	    ASCND = ATQD;
	    	      
	    	     
	   /*   System.out.println(" ATND = " + ATND + " ATQD = " + ATQD);
	    
	    ASCND = ATND;
	    if ( ATND < 180 ) 
	    	{
	    		ASCND = ATND + 180;
	    	}
	    else
	    {
	    	ASCND = ATND - 180;
	    }                    */
	    
	    System.out.println( " ASCND ( Ascendant )= " + ASCND );
	    		
			
	}
	
	 public double get_Ascend ()
	    {
	    	return ASCND;
	    }
	
	 
}
