package PANCHA;

public class KEPLER {
	static double E, EM, BIGE, TRUANA;
	String Planet;
	double E0, BIGE0;
	int COUNT;
	
	public KEPLER ( double ECCENTRICITY, double Mean_Ana, String Plan )
    {
    	E = ECCENTRICITY;
    	EM = Mean_Ana;
    	Planet = Plan;
    	
    	System.out.println( " Eccentricity = " + E + "  Mean Anamoly = " + EM + " of " + Planet );
    }
	
	double TANE, ERROR, TANVB2;
	
	/* ____________   Calculate Eccentric anomaly BIGE and True Anomaly TRUANA      ___________
	 Input: E, eccentricity of planet's orbit and    EM,  mean anomaly of the planet
    Output: BIGE: Eccentric anomaly*                                              __________*/
	public void BigE_and_Truana()
	{
		/* ____________   First get an approximate value of BIGE      ______________________*/
		
		TANE = Trig.DegTAN  ( EM ) / ( Trig.DegCOS ( EM ) - E );
	    BIGE = Math.atan ( TANE ) * TRGVAR.R_to_D;
	    E0 = E * TRGVAR.R_to_D;
	    
	    BIGE = BIGE % 360;
	    BIGE0 = BIGE ;
	    
	    BIGE = BIGE0 + ( EM + E0 * Trig.DegSIN ( BIGE0 ) - BIGE0 ) / ( 1. - E * Trig.DegCOS ( BIGE0 ));
	    
	    /* ____________   Get more accurate value of BIGE by iteration      ______________________*/
	    
	    COUNT = 0;
	    ERROR = Math.abs (( BIGE - BIGE0 ) / BIGE0 );
	    BIGE0 = BIGE ;
	    
	    while ( ERROR > 0.000001 || COUNT < 20) {
	    	BIGE = BIGE0 + ( EM + E0 * Trig.DegSIN ( BIGE0 ) - BIGE0 ) / ( 1. - E * Trig.DegCOS ( BIGE0 ));
	    	ERROR = Math.abs (( BIGE - BIGE0 ) / BIGE0 );     //loop body
	    	BIGE0 = BIGE;
	    	COUNT++;
	    	}
	    
	    TANVB2 = Math.sqrt (( 1.+E ) / ( 1.-E )) * Trig.DegTAN ( BIGE / 2. );
	    
	    TRUANA = 2. * Math.atan ( TANVB2 ) * TRGVAR.R_to_D;
	    TRUANA = TRUANA % 360;
	    
	    System.out.println( " ERROR = " + ERROR + " COUNT = " + COUNT + "  BIGE = " + BIGE + "  TRUANA = " + TRUANA );
	    

	}
	
	public double get_TRUANA ()
    {
    	return TRUANA;
    }

}
