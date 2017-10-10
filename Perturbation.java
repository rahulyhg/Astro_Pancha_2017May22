package PANCHA;

public class Perturbation {
	double EM_SUN, EM, EM2, EM3, EM4, EM5;
	double EM11, EM12, EM13;
	double EM21, EM22, EM23, EM24, EM25;
	double EM41, EM42, EM43, EM44, EM45, EM48;
	double EM51, EM52, EM53, EM54, EM55;
	double EM61, EM62, EM63, EM64, EM65;
	double EM71, EM72, EM73, EM74, EM75;
	double EM81, EM82, EM83, EM84, EM85;
	double PLN1 = 0., PMA1 = 0., PSEM = 0., PR = 0., PECC = 0.;
	double PLN2;
	double EPLN[];
	double T;

	double A, B, EC;

	double SIV, SIZ, COV, SI2Z, SI3Z, SI4Z, SI5Z, COZ, CO2Z, CO3Z, CO4Z, CO5Z;
	double SIQ, SI2Q, SI3Q, SI4Q, COQ, CO2Q, CO3Q, CO4Q;

	double SV, P, Q, S, V;
	double W, Z, Z2, Z3, Z4, Z5, QJ2, QJ3, QJ4, V2;

	double S1E10, S11END, E1E16, E17END, SM1END, PEC1;

	/* Variables for SATURN Graha_Num = 4 */

	double PSI, QS2, QS3, QS4, SI2V, CO2V, SIPS, SI2PS, SI3PS, SI4PS;
	double COPS, CO2PS, CO3PS, CO4PS, SIW, ASAT;

	double S1E16, S17END, E1E15, E16E30, E31END, BSAT, SPART1, SPART2;

	/* Variables for URANUS and NRPTUNE Graha_Num = 5 or 6 */
	double ETA, G, H, THETA, SIT, SI2T, SI3T, AUR, BUR;
	double COT, CO2T, CO3T, SIE, COE, SIG, COG, SIH, COH, SI2H, CO2H, SI1S, CO1S, SI2S, CO2S, SISE, COSE, CO2SE, SIS3T;
	double ANEP, BNEP;

	int Graha_Num;

	public Perturbation(double EMSUN, double ECPLNT, double[] Epln_Grahas, double TJD, int Planet_Num) {

		EM_SUN = EMSUN; // Mean Anomaly of Sun
		EPLN = Epln_Grahas; // Mean Anomaly of Grahas
		Graha_Num = Planet_Num;
		EC = ECPLNT;

		EM = EM_SUN;
		EM2 = 2 * EM;
		EM3 = 3 * EM;
		EM4 = 4 * EM;
		EM5 = 5 * EM;

		EM11 = EPLN[0];
		EM12 = 2 * EPLN[0];
		EM13 = 3 * EPLN[0];

		EM21 = EPLN[1];
		EM22 = 2 * EPLN[1];
		EM23 = 3 * EPLN[1];
		EM24 = 4 * EPLN[1];
		EM25 = 5 * EPLN[1];

		EM41 = EPLN[2];
		EM42 = 2. * EPLN[2];
		EM43 = 3. * EPLN[2];
		EM44 = 4. * EPLN[2];
		EM45 = 5. * EPLN[2];
		EM48 = 8. * EPLN[2];

		EM51 = EPLN[3];
		EM52 = 2. * EPLN[3];
		EM53 = 3. * EPLN[3];
		EM54 = 4. * EPLN[3];
		EM55 = 5. * EPLN[3];

		EM61 = EPLN[4];
		EM62 = 2. * EPLN[4];
		EM63 = 3. * EPLN[4];
		EM64 = 4. * EPLN[4];
		EM65 = 5. * EPLN[4];

		EM71 = EPLN[5];
		EM72 = 2. * EPLN[5];
		EM73 = 3. * EPLN[5];
		EM74 = 4. * EPLN[5];
		EM75 = 5. * EPLN[5];

		EM81 = EPLN[6];
		EM82 = 2. * EPLN[6];
		EM83 = 3. * EPLN[6];
		EM84 = 4. * EPLN[6];
		EM85 = 5. * EPLN[6];

		T = TJD;

	}

	/*
	 * __________________________________________________________________________________________________________
	 * Calculate the perturbation terms
	 * _________________________________________________________________________________________________________
	 */

	public void Pertur_Terms() {

		/*
		 * .....................................................................
		 * ... Graha_Num = 0 MERCURY - Perturbations
		 * .....................................................................
		 * ..
		 */

		if (Graha_Num == 0) {
			PLN1 = 0.;
			PMA1 = 0.;

			PLN2 = 0.00204 * Trig.DegCOS(EM25 - EM12 + 12.22) + 0.00103 * Trig.DegCOS(EM22 - EM11 - 160.692)
					+ 0.00091 * Trig.DegCOS(EM52 - EM11 - 37.003) + 0.00078 * Trig.DegCOS(EM25 - EM13 + 10.137);
			PR = 0.000007525 * Trig.DegCOS(EM52 - EM11 + 53.013) + 0.000006802 * Trig.DegCOS(EM25 - EM13 - 259.918)
					+ 0.000005457 * Trig.DegCOS(EM22 - EM12 - 71.188) + 0.000003569 * Trig.DegCOS(EM25 - EM11 - 77.75);

		}

		/*
		 * .....................................................................
		 * ... Graha_Num = 1 VENUS - Perturbations
		 * .....................................................................
		 * ..
		 */

		if (Graha_Num == 1) {

			PLN1 = 0.;
			PLN1 = 0.00077 * Trig.DegSIN(237.24 + 150.27 * T);
			PMA1 = 0.;

			PLN2 = 0.00313 * Trig.DegCOS(EM2 - EM22 - 148.225) + 0.00198 * Trig.DegCOS(EM3 - EM23 + 2.565)
					+ 0.00136 * Trig.DegCOS(EM - EM21 - 119.107) + 0.00096 * Trig.DegCOS(EM3 - EM22 - 135.912)
					+ 0.00082 * Trig.DegCOS(EM51 - EM21 - 208.087);

			PR = 0.000022501 * Trig.DegCOS(EM2 - EM22 - 58.208) + 0.000019045 * Trig.DegCOS(EM3 - EM23 + 92.577)
					+ 0.000006887 * Trig.DegCOS(EM51 - EM21 - 118.09) + 0.000005172 * Trig.DegCOS(EM - EM21 - 29.11)
					+ Trig.DegCOS(EM5 - EM24 - 104.208) * 0.00000362 + 0.000003283 * Trig.DegCOS(EM4 - EM24 + 63.513)
					+ 0.000003074 * Trig.DegCOS(EM52 - EM22 - 55.167);
		}

		/*
		 * .....................................................................
		 * ... Graha_Num = 2 MARS - Perturbations
		 * .....................................................................
		 * ..
		 */
		if (Graha_Num == 2) {

			PLN1 = -0.01133 * Trig.DegSIN(EM53 - EM48 + EM4) - 0.00933 * Trig.DegCOS(EM53 - EM48 + EM4);
			PMA1 = PLN1;

			PLN1 = -0.01133 * Trig.DegSIN(EM53 - EM48 + EM4) - 0.00933 * Trig.DegCOS(EM53 - EM48 + EM4);

			PMA1 = PLN1;

			PLN2 = 0.00705 * Trig.DegCOS(EM51 - EM41 - 48.958) + 0.00607 * Trig.DegCOS(EM52 - EM41 - 188.35)
					+ 0.00445 * Trig.DegCOS(EM52 - EM42 - 191.897) + 0.00388 * Trig.DegCOS(EM - EM42 + 20.495)
					+ 0.00238 * Trig.DegCOS(EM - EM41 + 35.097) + 0.00204 * Trig.DegCOS(EM2 - EM43 + 158.638)
					+ 0.00177 * Trig.DegCOS(EM43 - EM21 - 57.602) + 0.00136 * Trig.DegCOS(EM2 - EM44 + 154.093)
					+ 0.00104 * Trig.DegCOS(EM51 + 17.618);

			PR = 0.000053227 * Trig.DegCOS(EM51 - EM41 + 41.1306) + 0.000050989 * Trig.DegCOS(EM52 - EM42 - 101.9847)
					+ 0.000038278 * Trig.DegCOS(EM52 - EM41 - 98.3292) + 0.000015996 * Trig.DegCOS(EM - EM41 - 55.555)
					+ 0.000014764 * Trig.DegCOS(EM2 - EM43 + 68.622) + 0.000008966 * Trig.DegCOS(EM51 - EM42 + 43.615)
					+ 0.000007914 * Trig.DegCOS(EM53 - EM42 - 139.737)
					+ 0.000007004 * Trig.DegCOS(EM52 - EM43 - 102.888) + 0.00000662 * Trig.DegCOS(EM - EM42 + 113.202)
					+ 0.00000493 * Trig.DegCOS(EM53 - EM43 - 76.243) + 0.000004693 * Trig.DegCOS(EM3 - EM45 + 190.603)
					+ 0.000004571 * Trig.DegCOS(EM2 - EM44 + 244.702)
					+ 0.000004409 * Trig.DegCOS(EM53 - EM41 - 115.828);

		}

		/*
		 * .....................................................................
		 * ... Graha_Num = 3 JUPITER - Perturbations
		 * .....................................................................
		 * ..
		 */

		if (Graha_Num == 3) {

			SV = T / 5. + 0.1;
			P = 237.47555 + 3034.9061 * T;
			Q = 265.91650 + 1222.1139 * T;
			S = 243.51721 + 428.4677 * T;
			V = 5 * Q - 2 * P;

			W = 2 * P - 6 * Q + 3 * S;
			Z = Q - P;
			Z2 = Z * 2;
			Z3 = Z * 3;
			Z4 = Z * 4;
			Z5 = Z * 5;
			QJ2 = Q * 2;
			QJ3 = Q * 3;
			QJ4 = Q * 4;
			V2 = V * 2;

			PLN1 = 0.;
			/*
			 * _______________________________________________________________________________________________
			 * Perturbations in mean longitude
			 * _________________________________________________________________________________________
			 */

			S1E10 = (0.331364 - SV * (0.010281 + SV * 0.004692)) * Trig.DegSIN(V)
					+ (0.003228 - SV * (0.064436 - SV * 0.002075)) * Trig.DegCOS(V)
					- (0.003083 + SV * (0.000275 - SV * 0.000489)) * Trig.DegSIN(V2) + 0.002472 * Trig.DegSIN(W)
					+ 0.013619 * Trig.DegSIN(Z) + 0.018472 * Trig.DegSIN(Z2) + 0.006717 * Trig.DegSIN(Z3)
					+ 0.002775 * Trig.DegSIN(Z4) + 0.006417 * Trig.DegSIN(Z2) * Trig.DegSIN(Q)
					+ (0.007275 - SV * 0.001253) * Trig.DegSIN(Z) * Trig.DegSIN(Q);

			S11END = 0.002439 * Trig.DegSIN(Z3) * Trig.DegSIN(Q)
					- (0.033839 + SV * 0.001125) * Trig.DegCOS(Z) * Trig.DegSIN(Q)
					- 0.003767 * Trig.DegCOS(Z2) * Trig.DegSIN(Q)
					- (0.035681 + 0.001208 * SV) * Trig.DegSIN(Z) * Trig.DegCOS(Q)
					- 0.004261 * Trig.DegSIN(Z2) * Trig.DegCOS(Q) + 0.002178 * Trig.DegCOS(Q)
					+ (-0.006333 + SV * 0.001161) * Trig.DegCOS(Z) * Trig.DegCOS(Q)
					- 0.006675 * Trig.DegCOS(Z2) * Trig.DegCOS(Q) - 0.002664 * Trig.DegCOS(Z3) * Trig.DegCOS(Q)
					- 0.002572 * Trig.DegSIN(Z) * Trig.DegSIN(QJ2) - 0.003567 * Trig.DegSIN(Z2) * Trig.DegSIN(QJ2)
					+ 0.002094 * Trig.DegCOS(Z) * Trig.DegCOS(QJ2) + 0.003342 * Trig.DegCOS(Z2) * Trig.DegCOS(QJ2);

			PLN1 = S1E10 + S11END;
			A = PLN1;

			SIV = Trig.DegSIN(V);
			COV = Trig.DegCOS(V);
			SIZ = Trig.DegSIN(Z);
			SI2Z = Trig.DegSIN(Z2);
			SI3Z = Trig.DegSIN(Z3);
			SI4Z = Trig.DegSIN(Z4);
			COZ = Trig.DegCOS(Z);
			CO2Z = Trig.DegCOS(Z2);
			CO3Z = Trig.DegCOS(Z3);
			CO4Z = Trig.DegCOS(Z4);
			CO5Z = Trig.DegCOS(Z5);

			SIQ = Trig.DegSIN(Q);
			SI2Q = Trig.DegSIN(QJ2);
			SI3Q = Trig.DegSIN(QJ3);
			SI4Q = Trig.DegSIN(QJ4);
			COQ = Trig.DegCOS(Q);
			CO2Q = Trig.DegCOS(QJ2);
			CO3Q = Trig.DegCOS(QJ3);
			CO4Q = Trig.DegCOS(QJ4);

			/*
			 * _______________________________________________________________________________________________
			 * Perturbations in eccentricity
			 * _________________________________________________________________________________________
			 */

			E1E16 = (0.3606 + SV * (0.130 - SV * 0.43)) * SIV + COV * (0.1289 - SV * 0.58) - 0.6764 * SIZ * SIQ
					- 0.111 * SI2Z * SIQ - 0.224 * SI3Z * SIQ - 0.204 * SIQ + (0.1284 + 0.116 * SV) * COZ * SIQ
					+ 0.188 * CO2Z * SIQ + (0.146 + 0.13 * SV) * SIZ * COQ + 0.224 * SI2Z * COQ - 0.817 * COQ
					+ 0.6074 * COZ * COQ + 0.992 * CO2Z * COQ + 0.508 * CO3Z * COQ + 0.23 * CO4Z * COQ
					+ 0.108 * CO5Z * COQ;

			E17END = -(0.956 + SV * 0.73) * SIZ * SI2Q + 0.448 * SI2Z * SI2Q + 0.137 * SI3Z * SI2Q
					+ (-0.997 + 0.108 * SV) * COZ * SI2Q + 0.48 * CO2Z * SI2Q + 0.148 * CO3Z * SI2Q
					+ (-0.956 + SV * 0.99) * SIZ * CO2Q + 0.49 * SI2Z * CO2Q + 0.158 * SI3Q * CO2Q + 0.179 * CO2Q
					+ (0.1024 + 0.75 * SV) * COZ * CO2Q - 0.437 * CO2Z * CO2Q - 0.132 * CO3Z * CO2Q;

			PEC1 = (E1E16 + E17END) * 1.E-06;
			PECC = PEC1;

			SM1END = (0.007192 - SV * 0.003147) * SIV - (0.020428 + SV * (0.000675 - SV * 0.000197)) * COV
					+ (0.007269 + SV * 0.000672) * SIZ * SIQ - 0.004344 * SIQ + 0.034036 * COZ * SIQ
					+ 0.005614 * CO2Z * SIQ + 0.002964 * CO3Z * SIQ + 0.037761 * SIZ * COQ + 0.006158 * SI2Z * COQ
					- 0.006603 * COZ * COQ - 0.005356 * SIZ * SI2Q + 0.002722 * SI2Z * SI2Q + 0.004483 * COZ * SI2Q
					- 0.002642 * CO2Z * SI2Q + 0.004403 * SIZ * CO2Q - 0.002536 * SI2Z * CO2Q + 0.005547 * COZ * CO2Q
					- 0.002689 * CO2Z * CO2Q;

			B = SM1END;
			PMA1 = A - B / EC;

			PSEM = -0.263 * COV + 0.205 * COZ + 0.693 * CO2Z + 0.312 * CO3Z + 0.147 * CO4Z + 0.299 * SIZ * SIQ
					+ 0.181 * CO2Z * SIQ + 0.204 * SI2Z * COQ + 0.111 * SI3Z * COQ - 0.337 * COZ * COQ
					- 0.111 * CO2Z * COQ;

			PSEM = PSEM * 1.E-05;

		}

		/*
		 * .....................................................................
		 * ... Graha_Num = 4 SATURN - Perturbations
		 * .....................................................................
		 * ..
		 */

		if (Graha_Num == 4) {
			PLN1 = 0.;

			SV = T / 5. + 0.1;
			P = 237.47555 + 3034.9061 * T;
			Q = 265.91650 + 1222.1139 * T;
			S = 243.51721 + 428.4677 * T;
			V = 5. * Q - 2. * P;
			W = 2. * P - 6. * Q + 3. * S;
			Z = Q - P;
			PSI = S - Q;

			Z2 = Z * 2;
			Z3 = Z * 3;
			Z4 = Z * 4;
			Z5 = Z * 5;
			QS2 = Q * 2;
			QS3 = Q * 3;
			QS4 = Q * 4;
			V2 = V * 2;

			SIW = Trig.DegSIN(W);

			SIV = Trig.DegSIN(V);
			COV = Trig.DegCOS(V);
			SI2V = Trig.DegSIN(V2);
			CO2V = Trig.DegCOS(V2);
			SIZ = Trig.DegSIN(Z);
			SI2Z = Trig.DegSIN(Z2);
			SI3Z = Trig.DegSIN(Z3);
			SI4Z = Trig.DegSIN(Z4);
			SI5Z = Trig.DegSIN(Z5);
			COZ = Trig.DegCOS(Z);
			CO2Z = Trig.DegCOS(Z2);
			CO3Z = Trig.DegCOS(Z3);
			CO4Z = Trig.DegCOS(Z4);
			CO5Z = Trig.DegCOS(Z5);

			SIQ = Trig.DegSIN(Q);
			SI2Q = Trig.DegSIN(QS2);
			SI3Q = Trig.DegSIN(QS3);
			SI4Q = Trig.DegSIN(QS4);
			COQ = Trig.DegCOS(Q);
			CO2Q = Trig.DegCOS(QS2);
			CO3Q = Trig.DegCOS(QS3);
			CO4Q = Trig.DegCOS(QS4);

			SIPS = Trig.DegSIN(PSI);
			SI2PS = Trig.DegSIN(PSI * 2.);
			SI3PS = Trig.DegSIN(PSI * 3.);
			SI4PS = Trig.DegSIN(PSI * 4.);

			COPS = Trig.DegCOS(PSI);
			CO2PS = Trig.DegCOS(2. * PSI);
			CO3PS = Trig.DegCOS(3. * PSI);
			CO4PS = Trig.DegCOS(4. * PSI);

			S1E16 = (-0.814181 + SV * (0.01815 + SV * 0.016714)) * SIV
					+ (-0.010497 + SV * (0.160906 - SV * 0.0041)) * COV + 0.007581 * SI2V - 0.007986 * SIW
					- 0.148811 * SIZ - 0.040786 * SI2Z - SI3Z * 0.015208 - 0.006339 * SI4Z - 0.006244 * SIQ
					+ (0.008931 + SV * 0.002728) * SIZ * SIQ - 0.0165 * SI2Z * SIQ - 0.005775 * SI3Z * SIQ
					+ (0.081344 + SV * 0.003206) * COZ * SIQ + 0.015019 * CO2Z * SIQ
					+ (0.085581 + SV * 0.002494) * SIZ * COQ + (0.025328 - SV * 0.003117) * COZ * COQ;

			S17END = 0.014394 * CO2Z * COQ + 0.006319 * CO3Z * COQ + 0.006369 * SIZ * SI2Q + 0.009156 * SI2Z * SI2Q
					+ 0.007525 * SI3PS * SI2Q - 0.005236 * COZ * CO2Q - 0.007736 * CO2Z * CO2Q - 0.007528 * CO3PS * CO2Q;

			PLN1 = S1E16 + S17END;
			ASAT = PLN1;
			E1E15 = (-0.7927 + SV * (0.2548 + SV * 0.91)) * SIV + (0.13381 + SV * (0.1226 - SV * 0.253)) * COV
					+ (0.248 - SV * 0.121) * SI2V - (0.305 + SV * 0.91) * CO2V + 0.412 * SI2Z + 0.12415 * SIQ
					+ (0.39 - SV * 0.617) * SIZ * SIQ + (0.165 - SV * 0.204) * SI2Z * SIQ + 0.26599 * COZ * SIQ
					- 0.4687 * CO2Z * SIQ - 0.187 * CO3Z * SIQ - 0.821 * CO4Z * SIQ - 0.377 * CO5Z * SIQ
					+ 0.497 * CO2PS * SIQ + (0.163 - SV * 0.611) * COQ;

			E16E30 = -0.12696 * SIZ * COQ - 0.42 * SI2Z * COQ - 0.1503 * SI3Z * COQ - 0.619 * SI4Z * COQ
					- 0.268 * SI5Z * COQ - (0.282 + SV * 0.1306) * COZ * COQ - (0.86 - SV * 0.23) * CO2Z * COQ
					+ 0.461 * SI2PS * COQ - 0.35 * SI2Q + (0.2211 - 0.286 * SV) * SIZ * SI2Q - 0.2208 * SI2Z * SI2Q
					- 0.568 * SI3Z * SI2Q - 0.346 * SI4Z * SI2Q - (0.278 + 0.222 * SV) * COZ * SI2Q
					+ (0.2022 + SV * 0.263) * CO2Z * SI2Q;

			E31END = 0.248 * CO3Z * SI2Q + 0.242 * SI3PS * SI2Q + 0.467 * SI2Q * CO3PS - 0.49 * CO2Q
					- (0.2842 + SV * 0.279) * SIZ * CO2Q + (0.128 + SV * 0.226) * SI2Z * CO2Q + 0.224 * SI3Z * CO2Q
					- COZ * CO2Q * (0.1594 - SV * 0.282) + (0.2162 - SV * 0.207) * CO2Z * CO2Q + 0.561 * CO3Z * CO2Q
					+ 0.343 * CO4Z * CO2Q + 0.469 * SI3PS * CO2Q - 0.242 * CO3PS * CO2Q - 0.205 * SIZ * SI3Q
					+ 0.262 * SI3Z * SI3Q + 0.208 * COZ * CO3Q - 0.271 * CO3Z * CO3Q - 0.382 * CO3Z * SI4Q
					- 0.376 * SI3Z * CO4Q;

			PEC1 = (E1E15 + E16E30 + E31END) * 1.E-06;

			BSAT = (0.077108 + SV * (0.07186 - SV * 0.001533)) * SIV
					+ COV * (0.045803 - SV * (0.014766 + SV * 0.000536)) - 0.007075 * SIZ - 0.075825 * SIZ * SIQ
					- 0.024839 * SI2Z * SIQ - 0.008631 * SI3Z * SIQ - 0.072586 * COQ - 0.150383 * COZ * COQ
					+ 0.026897 * CO2Z * COQ + 0.010053 * CO3Z * COQ - (0.013597 + SV * 0.001719) * SIZ * SI2Q
					- (0.007742 - SV * 0.001517) * COZ * SI2Q + CO2Z * SI2Q * (0.013586 - SV * 0.001375)
					- (0.013667 - SV * 0.001239) * SIZ * CO2Q + 0.011981 * SI2Z * CO2Q
					+ COZ * CO2Q * (0.014861 + SV * 0.001136) - (0.013064 + 0.001628 * SV) * CO2Z * CO2Q;

			PMA1 = ASAT - BSAT / EC;

			SPART1 = 0.572 * SV * SIV + 0.2933 * COV + 0.33629 * COZ - 0.3081 * CO2Z - 0.1423 * CO3Z - 0.671 * CO4Z
					- 0.32 * CO5Z + 0.1098 * SIQ - 0.2812 * SIZ * SIQ + 0.688 * SI2Z * SIQ - 0.393 * SI3Z * SIQ
					- 0.228 * SI4Z * SIQ + 0.2138 * COZ * SIQ - 0.999 * CO2Z * SIQ - 0.642 * CO3Z * SIQ
					- 0.325 * CO4Z * SIQ - 0.89 * COQ + 0.2206 * SIZ * COQ;

			SPART2 = -0.159 * SI2Z * COQ - 0.647 * SI3Z * COQ - 0.344 * SI4Z * COQ + 0.2885 * COZ * COQ
					+ (0.2172 + SV * 0.102) * CO2Z * COQ + 0.296 * CO3Z * COQ - 0.267 * SI2Z * SI2Q - 0.778 * COZ * SI2Q
					+ 0.495 * CO2Z * SI2Q + 0.25 * CO3Z * SI2Q - 0.856 * SIZ * CO2Q + 0.441 * SI2Z * CO2Q
					+ 0.296 * CO2Z * CO2Q + 0.211 * CO3Z * CO2Q - 0.427 * SIZ * SI3Q + 0.398 * SI3Z * SI3Q
					+ 0.344 * COZ * CO3Q - 0.427 * CO3Z * CO3Q;
			PSEM = (SPART1 + SPART2) * 1.E-05;

		}

		/*
		 * .....................................................................
		 * ... Graha_Num = 5 (URANUS) and 6 (NEPTUNE) - Perturbations
		 * .....................................................................
		 * ..
		 */

		if (Graha_Num == 5 || Graha_Num == 6) {

			PLN1 = 0.;

			SV = T / 5. + 0.1;
			P = 237.47555 + 3034.9061 * T;
			Q = 265.91650 + 1222.1139 * T;
			S = 243.51721 + 428.4677 * T;
			V = 5. * Q - 2. * P;
			W = 2. * P - 6. * Q + 3. * S;
			Z = S - P;
			ETA = S - Q;
			G = 83.76922 + 218.4901 * T;
			H = 2 * G - S;
			THETA = G - S;

			SIW = Trig.DegSIN(W);

			SIT = Trig.DegSIN(THETA);
			SI2T = Trig.DegSIN(2. * THETA);
			SI3T = Trig.DegSIN(3. * THETA);

			SIZ = Trig.DegSIN(Z);
			COZ = Trig.DegCOS(Z);

			COT = Trig.DegCOS(THETA);
			CO2T = Trig.DegCOS(2. * THETA);
			CO3T = Trig.DegCOS(3. * THETA);

			SIE = Trig.DegSIN(ETA);
			COE = Trig.DegCOS(ETA);

			SIG = Trig.DegSIN(G);
			COG = Trig.DegCOS(G);

			SIH = Trig.DegSIN(H);
			COH = Trig.DegCOS(H);
			SI2H = Trig.DegSIN(2. * H);
			CO2H = Trig.DegCOS(2. * H);

			SI1S = Trig.DegSIN(S);
			CO1S = Trig.DegCOS(S);
			SI2S = Trig.DegSIN(2. * S);
			CO2S = Trig.DegCOS(2. * S);

			SISE = Trig.DegSIN(S + ETA);
			COSE = Trig.DegCOS(S + ETA);

			CO2SE = Trig.DegCOS(2. * S + ETA);
			SIS3T = Trig.DegSIN(S + 3. * THETA);

		}

		if (Graha_Num == 5) {

			PLN1 = (0.864319 - 0.001583 * SV) * SIH + COH * (0.082222 - SV * 0.006833) + SI2H * 0.036017
					- 0.003019 * CO2H + 0.008122 * SIW;

			AUR = PLN1;

			BUR = 0.120303 * SIH + (0.019472 - 0.000947 * SV) * COH + 0.006197 * SI2H;

			PMA1 = AUR - BUR / EC;

			PECC = -(0.3349 - 0.163 * SV) * SIH + 0.20981 * COH + 0.1311 * CO2H;

			PECC = PECC * 1.E-05;

			PSEM = -0.003825 * COH;

			PLN2 = (0.010122 - SV * 0.000988) * SISE - (0.038581 - SV * (0.002031 + SV * 0.00191)) * COSE
					+ (0.034964 - SV * (0.001038 - SV * 0.000868)) * CO2SE + 0.005594 * SIS3T - SIZ * 0.014808
					- 0.005794 * SIE + 0.002347 * COE + 0.009872 * SIT + 0.008803 * SI2T - 0.004308 * SI3T;

			PR = -0.25948 + (0.5795 * CO1S - 0.1165 * SI1S + 0.1388 * CO2S) * SIE + 0.4985 * COZ
					+ (0.1351 * CO1S + 0.5702 * SI1S + 0.1388 * SI2S) * COE - 0.123 * CO1S + 0.904 * CO2T + 0.3354 * COE
					+ 0.894 * (COT - CO3T);

			PR = PR * 1.E-05;

		}

		if (Graha_Num == 6) {

			Z = G - P;
			ETA = G - Q;

			Z = G - P;
			ETA = G - Q;

			SIZ = Trig.DegSIN(Z);
			COZ = Trig.DegCOS(Z);

			SIE = Trig.DegSIN(ETA);
			COE = Trig.DegCOS(ETA);

			PLN1 = (-0.589833 + 0.001089 * SV) * SIH - COH * (0.056094 - SV * 0.004658) - SI2H * 0.024286;

			ANEP = PLN1;

			BNEP = 0.024039 * SIH - 0.025303 * COH + 0.006206 * SI2H - 0.005992 * CO2H;

			PMA1 = ANEP - BNEP / EC;

			PECC = 0.4389 * SIH + 0.4262 * COH + 0.1129 * SI2H + 0.1089 * CO2H;

			PECC = PECC * 1.E-05;

			PSEM = -0.817 * SIH + 0.8189 * COH + 0.781 * CO2H;
			PSEM = PSEM * 1.E-05;

			PLN2 = -0.009556 * SIZ - 0.005178 * SIE + 0.002572 * SI2T - 0.002972 * CO2T * SIG - 0.002833 * SI2T * COG;

			PR = -0.40596 + 0.4992 * COZ + 0.2744 * COE + 0.2044 * COT + 0.1051 * CO2T;

			PR = PR * 1.E-05;

		}

	}

	public double get_PECC() {
		return PECC;
	}

	public double get_PLN1() {
		return PLN1;
	}

	public double get_PLN2() {
		return PLN2;
	}

	public double get_PSEM() {
		return PSEM;
	}

	public double get_PMA1() {
		return PMA1;
	}

	public double get_PR() {
		return PR;
	}

}
