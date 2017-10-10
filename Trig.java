package PANCHA;

class Trig {
	static double DegCOS(double x) {
		double x_rad = x * ALL.PI / 180.; 
		//System.out.println( " x =  " + x + " x in Radians = " + x_rad);
		return Math.cos(DegreeToRadian(x));
		
}
	static double RadianToDegree(double Radian)  {
		//return Radian * TRGVAR.R_to_D;
		return Radian * 180. / ALL.PI;
	}

	static double DegreeToRadian(double Degree) {
		//return Degree * TRGVAR.D_to_R;
		return Degree * ALL.PI / 180.;
	}

	static double DegSIN(double x) {
		double x_rad = x * ALL.PI / 180.; 
		//System.out.println( " x =  " + x + " x in Radians = " + x_rad);
		
		return Math.sin(DegreeToRadian(x));
		//return Math.sin(x_rad);
	}
	
	
	static double DegTAN(double x) {
		double x_rad = x * ALL.PI / 180.; 
		System.out.println( " x =  " + x + " x in Radians = " + x_rad);
		
		return Math.tan(DegreeToRadian(x));
		//return Math.tan(x_rad);
	}
	
	static double ATND,  ATQD;
	static double INTAN ( double numer, double den)
	{
		if ( den == 0. ) 
		{
			if ( numer  > 0. ) ATND = 90.;
			if ( numer < 0. ) ATND = 270.;				     
		}
		
		//if ( Math.abs ( den ) > 0. ) ATND = Math.atan ( numer / den ) * TRGVAR.R_to_D;
		if ( Math.abs ( den ) > 0. ) ATND = Math.atan ( numer / den ) * 180. / ALL.PI;
		ATQD = ATND; 
		System.out.println("  Trig Class ATND = " + ATND + " ATQD = " + ATQD );
			if ( Math.abs ( den ) > 0. ) 
			{
				if ( ATND > 0. ) 
				{
					if ( numer < 0. ) ATQD = ATND + 180.;
				}
		  	 
				if ( ATND < 0. ) 
				{
					if ( numer < 0. ) ATQD = 360. + ATND;
					if ( numer > 0. ) ATQD = 180. + ATND ;
				}	    
			    
			    if ( ATND == 0. ) 
			    {
			    	if ( den > 0. ) ATQD = 0.;
				    if ( den < 0. ) ATQD = 180.;
			    }
	      		

			}
  	        
			if ( ATND < 0. ) ATND = ATND + 360.;
			
		    return ATND;
		
	}

	
	static double INTAN1 ( double numer, double den)
	{
		if ( den == 0. ) 
		{
			if ( numer  > 0. ) ATND = 90.;
			if ( numer < 0. ) ATND = 270.;				     
		}
		
		//if ( Math.abs ( den ) > 0. ) ATND = Math.atan ( numer / den ) * TRGVAR.R_to_D;
		if ( Math.abs ( den ) > 0. ) ATND = Math.atan ( numer / den ) * 180. / ALL.PI;
		ATQD = ATND; 
			if ( Math.abs ( den ) > 0. ) 
			{
				if ( ATND > 0. ) 
				{
					if ( numer < 0. ) ATQD = ATND + 180.;
				}
		  	 
				if ( ATND < 0. ) 
				{
					if ( numer < 0. ) ATQD = 360. + ATND;
					if ( numer > 0. ) ATQD = 180. + ATND ;
				}
				
				
			    if ( ATND == 0. ) 
			    {
			    	if ( den > 0. ) ATQD = 0.;
				    if ( den < 0. ) ATQD = 180.;
			    }
	      		
	      		
			}
  	        
			if ( ATND < 0. ) ATND = ATND + 360.;
			
		    return ATQD;
		
	}
	
	
	

}