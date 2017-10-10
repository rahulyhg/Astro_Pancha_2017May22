package PANCHA;

class GRAHAS {
	static double AJ[], EIJ[], EJ[], PIJ[], OIJ[], EPLNT, ALPLNT, EPLN_GRAHAS[], NGRAHA;
	static double T, SUNLON, EMSUN, RSUN;
	static double Graha_long ;        //True longitude of Graha
	int GRAHA_Num;
	String Ast_Obj;
	
	

	public GRAHAS(double TJD, double[] AJ_Graha, double[] EIJ_Graha, double[] EJ_Graha, double[] PIJ_Graha,
			double[] OIJ_Graha, double[] EPLN_Graha, double AL_Graha, String Gr_Name, double Sun_Sayana, int NGRAHA, double EPLN_Sun,
			double Sun_Rad) {
		T = TJD;

		AJ = AJ_Graha;
		EIJ = EIJ_Graha;
		EJ = EJ_Graha;
		PIJ = PIJ_Graha;
		OIJ = OIJ_Graha;
		EPLN_GRAHAS = EPLN_Graha; // Planet's mean anomaly
		SUNLON = Sun_Sayana; // True Longitude of Sun
		EMSUN = EPLN_Sun; // Mean Anomaly of Sun
		ALPLNT = AL_Graha; // Semi-Major axis of the orbit
		RSUN = Sun_Rad; // Radius vector of SUN
		GRAHA_Num = NGRAHA;

		System.out.println(" AJ[0] = " + AJ[0] + " AJ[1] = " + AJ[1] + " AJ [ 2 ] = " + AJ[2] + " AJ [ 3 ] = " + AJ[3]);
		System.out.println(" EIJ[0] = " + EIJ[0] + " EIJ[1] = " + EIJ[1] + " EIJ [ 2 ] = " + EIJ[2] + " EIJ [ 3 ] = " + EIJ[3]);
		System.out.println(" EJ[0] = " + EJ[0] + " EJ[1] = " + EJ[1] + " EJ [ 2 ] = " + EJ[2] + " EJ [ 3 ] = " + EJ[3]);
		System.out.println(" PIJ[0] = " + PIJ[0] + " PIJ[1] = " + PIJ[1] + " PIJ [ 2 ] = " + PIJ[2] + " PIJ [ 3 ] = " + EIJ[3]);
		System.out.println(" OIJ[0] = " + OIJ[0] + " OIJ[1] = " + OIJ[1] + " OIJ [ 2 ] = " + OIJ[2] + " OIJ [ 3 ] = " + OIJ[3]);
		
		
		

		System.out.println(" EPLN_GRAHAS [ 0 ] = " + EPLN_GRAHAS[0] + System.lineSeparator() + " EPLN_GRAHAS [ 1 ] = "
				+ EPLN_GRAHAS[1] + System.lineSeparator() + " EPLN_GRAHAS [ 2 ] = " + EPLN_GRAHAS[2]
				+ System.lineSeparator() + " EPLN_GRAHAS [ 3 ] = " + EPLN_GRAHAS[3] + System.lineSeparator()
				+ " EPLN_GRAHAS [ 4 ] = " + EPLN_GRAHAS[4] + System.lineSeparator() + " EPLN_GRAHAS [ 5 ] = "
				+ EPLN_GRAHAS[5] + System.lineSeparator() + " EPLN_GRAHAS [ 6 ] = " + EPLN_GRAHAS[6]);

		System.out.println("EMSUN = " + EMSUN);

		System.out.println(" GRAHAS TJD = " + T + "   SUN Sayana = " + SUNLON);

		System.out.println(" GRAHA_NUM = " + GRAHA_Num );

		EPLNT = EPLN_GRAHAS[GRAHA_Num];
		Ast_Obj = Gr_Name;
		System.out.println(" EPLNT = " + EPLNT + " Planet:                              " +   Ast_Obj );
	}

	/*
	 * __________________________________________________________________________________________________________
	 * Calculation of parameters of planetary orbits.
	 * _________________________________________________________________________________________________________
	 */

	double ELPLNT, ECPLNT, EINCL, PERARG, ELNODE, TRUANA, RPLNT, U;
	double PNUM, PDEN, ATND, ATQD, ELTHET;
	double ELPLNH;
	double Graha_Long_Plus;
	int i_T_Epoch = 0;

	double PMA1, PECC, PSEM, PLN1, PLN2, BL, PR;
	double T_Plus;
	
	

	public void Graha_Longitude() {
		
		
		//T = 0.49393205;       //  Junk this 
		
		
		
		

		/*
		 * __________________________________________________________________________________________________________
		 * Planet's mean longitude referred to the mean equinox of the date
		 * _________________________________________________________________________________________________________
		 */

		ELPLNT = AJ[0] + T * (AJ[1] + T * (AJ[2] + T * AJ[3]));
		System.out.println(" ELPLNT = " + ELPLNT + "   " + ELPLNT % 360);
		ELPLNT = ELPLNT % 360;
		if (ELPLNT < 0)
			ELPLNT = ELPLNT + 360;

		/*
		 * __________________________________________________________________________________________________________
		 * Eccentricity of Planet' s orbit
		 * _________________________________________________________________________________________________________
		 */

		ECPLNT = EJ[0] + T * (EJ[1] + T * (EJ[2] + T * EJ[3]));

		/*
		 * __________________________________________________________________________________________________________
		 * Inclination on the plane of the Ecliptic
		 * _________________________________________________________________________________________________________
		 */

		EINCL = EIJ[0] + T * (EIJ[1] + T * (EIJ[2] + T * EIJ[3]));

		System.out.println(" EINCL = " + EINCL + "   " + EINCL % 360);
		EINCL = EINCL % 360;
		if (EINCL < 0)
			EINCL = EINCL + 360;

		/*
		 * __________________________________________________________________________________________________________
		 * Argument of the perihelion
		 * _________________________________________________________________________________________________________
		 */

		PERARG = PIJ[0] + T * (PIJ[1] + T * (PIJ[2] + T * PIJ[3]));

		System.out.println(" PERARG = " + PERARG + "   " + PERARG % 360);
		PERARG = PERARG % 360;
		if (PERARG < 0)
			PERARG = PERARG + 360;

		/*
		 * __________________________________________________________________________________________________________
		 * Longitude of the ascending Node
		 * _________________________________________________________________________________________________________
		 */

		ELNODE = OIJ[0] + T * (OIJ[1] + T * (OIJ[2] + T * OIJ[3]));

		System.out.println(" ELNODE = " + ELNODE + "   " + ELNODE % 360);
		ELNODE = ELNODE % 360;
		if (ELNODE < 0)
			ELNODE = ELNODE + 360;

		/*
		 * __________________________________________________________________________________________________________
		 * Calculate the perturbation terms
		 * _________________________________________________________________________________________________________
		 */

		//if (GRAHA_Num == 0) {
			//String GR_0 = "MER";
			Perturbation GRAHA_0 = new Perturbation(EMSUN, ECPLNT, EPLN_GRAHAS, T, GRAHA_Num);
			
			
			
			//Perturbation GRAHA_0 = new Perturbation(EMSUN, EPLN_GRAHAS, T, GRAHA_Num);
			GRAHA_0.Pertur_Terms();
			PMA1 = GRAHA_0.get_PMA1();
			PECC = GRAHA_0.get_PECC();
			PLN1 = GRAHA_0.get_PLN1();
			PLN2 = GRAHA_0.get_PLN2();
			PSEM = GRAHA_0.get_PSEM();
			PR = GRAHA_0.get_PR();
			

		//}

		EPLNT = EPLNT + PMA1;
		ECPLNT = ECPLNT + PECC;
		ELPLNT = ELPLNT + PLN1;
		ALPLNT = ALPLNT + PSEM;
		

		/*
		 * __________________________________________________________________________________________________________
		 * Obtain Planet's True anomaly by solving Kepler's Equation
		 * _________________________________________________________________________________________________________
		 */
		
		System.out.println( " Before calling KEPLER               ECPLNT = " + ECPLNT + "      EPLNT = "      + EPLNT +   " Ast_Obj:               " + Ast_Obj );

		KEPLER Gr_Kepler = new KEPLER(ECPLNT, EPLNT, Ast_Obj);
		Gr_Kepler.BigE_and_Truana();
		TRUANA = Gr_Kepler.get_TRUANA();

		/*
		 * __________________________________________________________________________________________________________
		 * Calculate Planet's radius vector ( in Astronomical Units )
		 * _________________________________________________________________________________________________________
		 */

		RPLNT = ALPLNT * 1.0000002 * (1. - Math.pow(ECPLNT, 2)) / (1. + ECPLNT * Trig.DegCOS(TRUANA));
		RPLNT = RPLNT + PR;

		/*
		 * __________________________________________________________________________________________________________
		 * planet's Argument of latitude
		 * _________________________________________________________________________________________________________
		 */
		U = ELPLNT + TRUANA - EPLNT - ELNODE;
		/*
		 * __________________________________________________________________________________________________________
		 * planet's ecliptical longitude
		 * _________________________________________________________________________________________________________
		 */
		PNUM = Trig.DegCOS(EINCL) * Trig.DegSIN(U);
		PDEN = Trig.DegCOS(U);
		ATND = Trig.INTAN(PNUM, PDEN);
		System.out.println(" ATND = " + ATND);

		ATQD = Trig.INTAN1(PNUM, PDEN);

		System.out.println(" From GRAHAS " + System.lineSeparator() + " PNUM = " + PNUM + " PDEN = " + PDEN + " ATND = " + ATND + " ATQD = " + ATQD);

		ELPLNH = ATQD + ELNODE;

		System.out.println(" Heliocentric longitude before correction  " + ELPLNH + "   " + ELPLNH % 360);

		ELPLNH = ELPLNH % 360;
		if (ELPLNH <= 0)
			ELPLNH = ELPLNH + 360;

		ELPLNH = ELPLNH + PLN2;
		System.out.println(" Heliocentric longitude after correction  " + ELPLNH + "   " + ELPLNH % 360);

		/*
		 * __________________________________________________________________________________________________________
		 * planet's ecliptical latitude
		 * _________________________________________________________________________________________________________
		 */

		BL = Trig.RadianToDegree(Math.asin(Trig.DegSIN(U) * Trig.DegSIN(EINCL)));

		ELTHET = ELPLNH - SUNLON;

		/*
		 * __________________________________________________________________________________________________________
		 * planet's geocentric latitude
		 * _________________________________________________________________________________________________________
		 */

		PNUM = RPLNT * Trig.DegCOS(BL) * Trig.DegSIN(ELTHET);
		PDEN = RPLNT * Trig.DegCOS(BL) * Trig.DegCOS(ELTHET) + RSUN;
		ATND = Math.atan(PNUM / PDEN) * 180. / ALL.PI;
		
		ATQD = ATND;
		
		ATQD = Trig.INTAN1(PNUM, PDEN);
		
		Graha_long = ATQD + SUNLON;
		
		
		
		System.out.println( " Graha_Long = " + Graha_long + "   " + Graha_long % 360 );
		Graha_long = Graha_long % 360;
		if ( Graha_long < 0)
			Graha_long += 360;
		
		//................................................................................................
		//  Find longitudes for slightly advanced time - This is to find if a Graha is in retrogade
		//................................................................................................
		
		
		
		
		
		
		
		
		
	}
	
	public double get_TruLong() {
		return Graha_long;					// Return True longitude of Sun
	}

}
