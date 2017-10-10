package PANCHA;

class SUNMON {
	static double EMSUN, ECEAR;
	static double ELSUN, TRULON, RSUN, TRUANA;
	double[] AJ = { 279.69668, 36000.76892, 0.0003025 };
	double[] BJ = { 358.47583, 35999.04975, -0.00015, -0.0000033 };
	double[] EJ = { 0.01675104, -0.0000418, -0.000000126 };
	double T;
	String Ast_Obj;
	/*
	 * __________________________________________________________________________________________________________
	 * Calculation of longitude, mean anomaly elongation of SUN, MOON, ascending
	 * node [RAHU] and descending node [KETU]
	 * _________________________________________________________________________________________________________
	 */

	public SUNMON(double TJD) {
		T = TJD;

		System.out.println(" SUNMON TJD = " + T);
	}

	/*
	 * __________________________________________________________________________________________________________
	 * First calculation is for SUN
	 * _________________________________________________________________________________________________________
	 */

	public void Sun_Longitude() {
		// T = 0.8796082021446464;

		Ast_Obj = "SUN";
		/*
		 * .... Sun's mean longitude referred to the mean equinox of the date
		 * ......
		 */

		ELSUN = AJ[0] + T * (AJ[1] + T * AJ[2]);

		// ELSUN = AJ [ 0 ] + T * AJ [ 1 ] + Math.pow( T, 2) * AJ [ 2 ];

		System.out.println(" ELSUN = " + ELSUN + "   " + ELSUN % 360);
		ELSUN = ELSUN % 360;
		/*
		 * .... Sun's mean anomaly referred to the mean equinox of the date
		 * ......
		 */

		EMSUN = BJ[0] + T * (BJ[1] + T * (BJ[2] + T * BJ[3]));
		System.out.println(" EMSUN = " + EMSUN + "   " + EMSUN % 360);
		EMSUN = EMSUN % 360;
		/* .... Eccentricity of Earth's orbit ...... */

		ECEAR = EJ[0] + T * (EJ[1] + T * EJ[2]);

		KEPLER Sun_Kepler = new KEPLER(ECEAR, EMSUN, Ast_Obj);
		Sun_Kepler.BigE_and_Truana();

		TRUANA = Sun_Kepler.get_TRUANA();

		TRULON = ELSUN + TRUANA - EMSUN;

		if (TRULON < 0)
			TRULON = TRULON + 360.;

		/*
		 * .....................................................................
		 * Calculate Sun's radius vector ( in Astronomical Units )
		 * .....................................................................
		 * ___
		 */

		RSUN = 1.0000002 * (1. - Math.pow(ECEAR, 2)) / (1. + ECEAR * Trig.DegCOS(TRUANA));

		TRULON = TRULON % 360;

		System.out.println(" ECEAR = " + ECEAR + " EMSUN = " + EMSUN + " TRUANA = " + TRUANA + " TRULON = " + TRULON);

	}

	

	/*
	 * __________________________________________________________________________________________________________
	 * Next Calculation of longitude, mean anomaly elongation,of MOON
	 * _________________________________________________________________________________________________________
	 */

	double[] ELPJ = { 270.434164, 481267.8831, -0.001133, 0.0000019 };
	double[] EMPJ = { 296.104608, 477198.8491, 0.009192, 0.0000144 };
	double[] DJ = { 350.737486, 445267.1142, -0.001436, 0.0000019 };
	double[] FJ = { 11.250889, 483202.0251, -0.003211, -0.0000003 };
	double[] RJ = { 259.183275, -1934.142, 0.002078, 0.0000022 };
	double ELPMON, EMPMON, EMMOON, ELMOON;

	double D, OMNODE, ELRAH, ELKET, F;
	double ARGAD1, ARGAD2, ARGAD3, ARGAD4;
	double EL11, EL12, EL13;
	double EM11, EM12, EM13;
	double EMP11, EMP12, EMP13;
	double D11, D12, D13;
	double F11, F12, F13;
	double ADD2;
	double E, ESQR;

	public void Moon_Longitude() {

		/*
		 * .....................................................................
		 * Moon's Mean longitude referred to the mean equinox of the date
		 * ....................................................................
		 */

		ELPMON = ELPJ[0] + T * (ELPJ[1] + T * (ELPJ[2] + T * ELPJ[3]));
		System.out.println(" ELPMON = " + ELPMON + "   " + ELPMON % 360);
		ELPMON = ELPMON % 360;
		if (ELPMON < 0)
			ELPMON += 360;

		/*
		 * .....................................................................
		 * Moon's Mean anomaly referred to the mean equinox of the date
		 * .....................................................................
		 */

		EMPMON = EMPJ[0] + T * (EMPJ[1] + T * (EMPJ[2] + T * EMPJ[3]));

		System.out.println(" EMPMON = " + EMPMON + "   " + EMPMON % 360);
		EMPMON = EMPMON % 360;
		if (EMPMON < 0)
			EMPMON += 360;

		/*
		 * .....................................................................
		 * Moon's Mean Elongation referred to the mean equinox of the date
		 * ....................................................................
		 */

		D = DJ[0] + T * (DJ[1] + T * (DJ[2] + T * DJ[3]));
		System.out.println(" Mean Elongation [MOON] = " + D + "   " + D % 360);
		D = D % 360;
		if (D < 0)
			D += 360;

		/*
		 * .....................................................................
		 * Longitude of Moon's ascending node [RAHU]
		 * ....................................................................
		 */

		OMNODE = RJ[0] + T * (RJ[1] + T * (RJ[2] + T * RJ[3]));
		System.out.println(" Longitude [RAHU] = " + OMNODE + "   " + OMNODE % 360);

		OMNODE = OMNODE % 360;
		if (OMNODE <= 0)
			OMNODE = OMNODE + 360;

		ELRAH = OMNODE;
		ELKET = OMNODE + 180;
		if (ELKET >= 360.)
			ELKET = ELKET - 360;

		System.out.println(" ELRAH = " + ELRAH + " ELKET = " + ELKET);

		/*
		 * .....................................................................
		 * Moon's Mean distance from its ascending node
		 * ....................................................................
		 */

		F = FJ[0] + T * (FJ[1] + T * (FJ[2] + T * FJ[3]));

		System.out.println(" Moon's Mean distance from its ascending node  = " + F + "   " + F % 360);
		F = F % 360;
		if (F < 0)
			F += 360;

		/*
		 * .....................................................................
		 * Additive terms Additive to Moon's mean longitude ELPMON
		 * .....................................................................
		 */

		ARGAD1 = 51.2 + 20.2 * T;
		EL11 = 0.000233 * Trig.DegSIN(ARGAD1);
		/*
		 * .....................................................................
		 * Additive to Sun's mean anomaly, EMSUN
		 * .....................................................................
		 */
		EM11 = -0.001778 * Trig.DegSIN(ARGAD1);

		/*
		 * .....................................................................
		 * .. Additive to Moon's mean anomaly, EMPMON
		 * .....................................................................
		 * ..
		 */
		EMP11 = 0.000817 * Trig.DegSIN(ARGAD1);

		/*
		 * .....................................................................
		 * .. Additive to Moon's mean elongation, D
		 * .....................................................................
		 * ..
		 */
		D11 = 0.002011 * Trig.DegSIN(ARGAD1);

		/*
		 * .....................................................................
		 * .. Additive to All quantities of Moon - Second addition
		 * .....................................................................
		 * ..
		 */

		ARGAD2 = 346.56 + T * (132.87 - T * 0.0091731);
		ADD2 = 0.003964 * Trig.DegSIN(ARGAD2);
		EL12 = ADD2;
		EM12 = 0.;
		EMP12 = ADD2;
		D12 = ADD2;
		F11 = ADD2;

		/*
		 * .....................................................................
		 * .. Additive to All quantities of Moon - Third addition
		 * .....................................................................
		 * ..
		 */

		ARGAD3 = OMNODE;
		EL13 = 0.001964 * Trig.DegSIN(ARGAD3);
		EMP13 = 0.002541 * Trig.DegSIN(ARGAD3);
		D13 = 0.001964 * Trig.DegSIN(ARGAD3);
		F12 = -0.024691 * Trig.DegSIN(ARGAD3);
		EM13 = 0.;

		/*
		 * .....................................................................
		 * .. Additive to Moon's Mean distance from its ascending node
		 * .....................................................................
		 * ..
		 */

		ARGAD4 = OMNODE + 275.05 - 2.3 * T;
		F13 = -0.004328 * Trig.DegSIN(ARGAD4);

		/*
		 * .....................................................................
		 * .. Calculate all quantities with additive terms
		 * .....................................................................
		 * ..
		 */

		ELPMON = ELPMON + EL11 + EL12 + EL13;
		EMSUN = EMSUN + EM11 + EM12 + EM13;
		EMPMON = EMPMON + EMP11 + EMP12 + EMP13;
		D = D + D11 + D12 + D13;
		F = F + F11 + F12 + F13;

		/*
		 * .....................................................................
		 * .. Eccentricity of Moon's orbit - E
		 * .....................................................................
		 * ..
		 */

		E = 1. - T * (0.002495 + T * 0.00000752);
		ESQR = E * E;
		// write ( *,10004 ) elpmon,emsun,empmon,d,f,omnode,e
		System.out.println(
				" ELPMON           EMSUN          EMPMON          D       F       OMNODE         E           ");
		System.out.println("       " + ELPMON + "       " + EMSUN + "        " + "       " + EMPMON + "        " + D
				+ "          " + F + "      " + OMNODE + "          " + E);

		/*
		 * .....................................................................
		 * .. Add terms corresponding to perturbations in Moon;s Longitude
		 * .....................................................................
		 * ..
		 */
		double EMP, EMP2, EMP3, EMP4, EM, EM2, D2, D3, D4, F2, F3, F4;
		double S1E10, S11E20, S21E30, S31E40, S41E50;
		EMP = EMPMON;
		EMP2 = 2. * EMP;
		EMP3 = 3. * EMP;
		EMP4 = 4. * EMP;
		EM = EMSUN;
		EM2 = 2. * EMSUN;
		D2 = 2. * D;
		D3 = 3. * D;
		D4 = 4. * D;
		F2 = 2. * F;
		F3 = 3. * F;
		F4 = 4. * F;

		S1E10 = 6.288750 * Trig.DegSIN(EMP) + 1.274018 * Trig.DegSIN(D2 - EMP) + 0.658309 * Trig.DegSIN(D2)
				+ 0.213616 * Trig.DegSIN(EMP2) - E * 0.185596 * Trig.DegSIN(EM) - 0.114336 * Trig.DegSIN(F2)
				+ 0.058793 * Trig.DegSIN(D2 - EMP2) + E * 0.057212 * Trig.DegSIN(D2 - EM - EMP)
				+ 0.05332 * Trig.DegSIN(D2 + EMP) + E * 0.045874 * Trig.DegSIN(D2 - EM);

		S11E20 = E * 0.041024 * Trig.DegSIN(EMP - EM) - 0.034718 * Trig.DegSIN(D) - E * 0.030465 * Trig.DegSIN(EMP + EM)
				+ 0.015326 * Trig.DegSIN(D2 - F2) - 0.012528 * Trig.DegSIN(F2 + EMP) - 0.01098 * Trig.DegSIN(F2 - EMP)
				+ 0.010674 * Trig.DegSIN(D4 - EMP) + 0.010034 * Trig.DegSIN(EMP3) + 0.008548 * Trig.DegSIN(D4 - EMP2)
				- E * 0.00791 * Trig.DegSIN(EM - EMP + D2);

		S21E30 = -E * 0.006783 * Trig.DegSIN(D2 + EM) + 0.005162 * Trig.DegSIN(EMP - D)
				+ E * (0.005 * Trig.DegSIN(EM + D) + 0.004049 * Trig.DegSIN(EMP - EM + D2))
				+ 0.003996 * Trig.DegSIN(EMP2 + D2) + 0.003862 * Trig.DegSIN(D4) + 0.003665 * Trig.DegSIN(D2 - EMP3)
				+ E * 0.002695 * Trig.DegSIN(EMP2 - EM) + 0.002602 * Trig.DegSIN(EMP - F2 - D2)
				+ E * 0.002396 * Trig.DegSIN(D2 - EM - EMP2);

		S31E40 = -0.002349 * Trig.DegSIN(EMP + D) + ESQR * 0.002249 * Trig.DegSIN(D2 - EM2)
				- E * 0.002125 * Trig.DegSIN(EMP2 + EM)
				- ESQR * (0.002079 * Trig.DegSIN(EM2) - 0.002059 * Trig.DegSIN(D2 - EMP - EM2))
				- 0.001773 * Trig.DegSIN(EMP + D2 - F2) - 0.001595 * Trig.DegSIN(F2 + D2)
				+ E * 0.00122 * Trig.DegSIN(D4 - EM - EMP) - 0.00111 * Trig.DegSIN(EMP2 + F2)
				+ 0.000892 * Trig.DegSIN(EMP - D3);

		S41E50 = -E * (0.000811 * Trig.DegSIN(EM + EMP + D2) - 0.000761 * Trig.DegSIN(D4 - EM - EMP2))
				+ ESQR * (0.000717 * Trig.DegSIN(EMP - EM2) + 0.000704 * Trig.DegSIN(EMP - EM2 - D2))
				+ E * (0.000693 * Trig.DegSIN(EM - EMP2 + D2) + 0.000598 * Trig.DegSIN(D2 - EM - F2))
				+ 0.00055 * Trig.DegSIN(EMP + D4) + 0.000538 * Trig.DegSIN(EMP4) + E * 0.000521 * Trig.DegSIN(D4 - EM)
				+ 0.000486 * Trig.DegSIN(EMP2 - D);

		ELMOON = ELPMON + S1E10 + S11E20 + S21E30 + S31E40 + S41E50;

		System.out.println("   True Longitude of Moon:  " + ELMOON);

	}
	
	public double get_TRULON() {
		return TRULON;					// Return True longitude of Sun
	}
	
	public double get_EMSUN() {
		return EMSUN;					// Return Mean Anomaly of SUN
	}
	
	public double get_RSUN() {
		return RSUN;					// Return Radius vector of SUN
	}
	
	

	public double get_ELMOON() {
		return ELMOON;
	}

	public double get_ELRAH() {
		return ELRAH;
	}

	public double get_ELKET() {
		return ELKET;
	}

}
