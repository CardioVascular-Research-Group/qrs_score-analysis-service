package edu.jhu.cvrg.services.qrs_scoreAnalysisService.wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QRS_Score {
	public boolean verbose = false;
	
 	public String Name = ""; //123442810;  //  	
 	public String ID  = ""; //= 123442810;  //
 	public String Date_Time =""; // "01/15/2010_11:41";  //
 	public String FilePath = ""; // C:\\magellan\\data\\RestECG\\TestECGs to GRID\\DeIdentified ECGs\\2.ECG  
 	public float Age = 53;  //
 	/** Sex Male = 0; Female = 1 **/
 	public float Sex = 0;  //
 	public float vrate = 0;  //
 	public float arate = 0;  //
 	public float pr = 0;  // 
 	/** QRS_Wave_Duration **/
 	public float qrsd = 0;  //
 	public float qt = 0;  //
 	public float qtc = 0;  //  	
 	public float pax = 0;  //
 	/** QRS_Wave_Complex_Axis **/
 	public float qrsax = 0;  //
 	public float tax = 0;  //
 	public float pdur = 0;  //  	
 	
 	public float qrstangle = 0;  //
 	
 	public float pa_aVF = 0;  //
 	public float pa_V1 = 0;  //
 	
	public float qa_I = 0;  //
	public float qa_II = 0;  //
	public float qa_aVL = 0;  //
	public float qa_aVF = 0;  //
	public float qa_V1 = 0; //
	public float qa_V2 = 0;  // 
	public float qa_V3 = 0;  //
	public float qa_V4 = 0;  //
	public float qa_V5 = 0;  //  	
	public float qa_V6 = 0;  //
	
	public float qd_I = 0;  //  	
	public float qd_II = 0;  //
	public float qd_aVL = 0;  // 
	public float qd_aVF = 0;  //
	public float qd_V1 = 0;  //
	public float qd_V2 = 0;  //
	public float qd_V3 = 0;  //
	public float qd_V4 = 0;  //
	public float qd_V5 = 0;  //
	public float qd_V6 = 0;  //

	//									
	public float ra_I = 0;  //  	
	public float ra_II = 0;  //  	
	public float ra_aVL = 0;  //  	
	public float ra_aVF = 0;  //
	public float ra_V1 = 0;  //  	
	public float ra_V2 = 0;  //  	
	public float ra_V3 = 0;  //  	
	public float ra_V4 = 0;  //
	public float ra_V5 = 0;  //  	
	public float ra_V6 = 0;  //

	public float rd_V1 = 0;  //
	public float rd_V2 = 0;  //
	public float rd_V3 = 0;  //

	
	public float sa_I = 0;  //  	
	public float sa_II = 0;  //
	public float sa_aVL = 0;  //
	public float sa_aVF = 0;  //
	public float sa_V1 = 0;  //
	public float sa_V2 = 0;  //
	public float sa_V3 = 0;  //
	public float sa_V4 = 0;  //
	public float sa_V5 = 0;  //
	public float sa_V6 = 0;  //  	
	
	public float rpa_I = 0;  //
	public float rpa_II = 0;  //
	public float rpa_aVL = 0;  //  	
	public float rpa_aVF = 0;  //  	
	public float rpa_V1 = 0;  //
	public float rpa_V2 = 0;  //  	
	public float rpa_V3 = 0;  //  	
	public float rpa_V4 = 0;  //  	
	public float rpa_V5 = 0 ;  //
	public float rpa_V6 = 0;  //  	

	public float spa_I = 0;  //
	public float spa_II = 0;  //
	public float spa_aVL = 0;  //
	public float spa_aVF = 0;  //
	public float spa_V1 = 0;  //
	public float spa_V2 = 0;  //
	public float spa_V3 = 0;  //
	public float spa_V4 = 0;  //
	public float spa_V5 = 0;  //
	public float spa_V6 = 0;  //  	
	
	
	public int No_scode = 2;  //
	public ArrayList<Integer> scode = new ArrayList<Integer>();

	public int positiveError = 0;
	public int negativeError = 0;
	public int badQParameterCount = 0, badRParameterCount = 0, badSParameterCount = 0, badOtherParameterCount=0;
	/** Slash separated list of parameters with a value of zero(invalid) **/
	public String missingQParamList = "",  missingRParamList = "",  missingSParamList = "", missingOtherParameterList = "";	
	//Thresholds:
	private Map<String, Double> mapThreshold = new HashMap<String, Double>();
	
	public Map<String, Double>  getMapThreshold() {
		return mapThreshold;
	}
	public void setMapThreshold(Map<String, Double>  mapThreshold) {
		this.mapThreshold = mapThreshold;
	}
	public String getMapThresholdVerbose() {
		StringBuffer sb = new StringBuffer();
		sb.append("Thresholds used (all 32 bit floating point):\n");
		
		int i=0;
		for (Map.Entry<String, Double> e : mapThreshold.entrySet()){
			sb.append(e.getKey());
			sb.append("  ");
			sb.append(e.getValue());
			sb.append("\r\n");
		}
		return sb.toString();
	}
	
	// outputs
	private float RQra_I;  //  
	private float RSra_I; // only used in LBBB
	private float RQra_II; // only used in LBBB
	private float RSra_II; // only used in LBBB
	private float RQra_aVL;  //  
	private float RQra_aVF;  //  
	private float RSra_aVF;
	private float RQra_V4;  //  
	private float RQra_V5;  //  
	private float RQra_V6;  //  
	private float RSra_V1;  //  
	private float Rsra_V2;  //  
	private float RSra_V4;  //  
	private float RSra_V5;  //  
	private float RSra_V6;  //  
	private int Qpts_I;  //  
	private int RATpts_I;  //  
	private int points_I;  //  
	private int RATpts_II;
	private int Qpts_II;  //  
	private int points_II;  //  
	private int Qpts_aVL;  //  
	private int RATpts_aVL;  //  
	private int points_aVL;  //  
	private int Qpts_aVF;  //  
	private int RATpts_aVF;  //  
	private int points_aVF;  //  
	private int Qpts_V1;  //  
	private int points_V1ant;  //  
	private int RATpts_V1;  //  
	private int Rpts_V1;  //  
	private int QSpts_V1;  //  
	private int points_V1post;  //  
	private int QorRpts_V2;  //  
	private int points_V2ant;  //  
	private int RATpts_V2;  //  
	private int Rpts_V2;  //  
	private int QSpts_V2;  //  
	private int points_V2post;  //  
	private int QorRpts_V3;  //  
	private int points_V3;  //  
	private int Qpts_V4;  //  
	private int Rpts_V4;  //  
	private int points_V4;  //  
	private int Qpts_V5;  //  
	private int Rpts_V5;  //  
	private int points_V5;  //  
	private int Qpts_V6;  //  
	private int Rpts_V6;  //  
	private int points_V6;  //  
	public  int QRS_Score; 

	private Map<Integer, String> mapConductionType = new HashMap<Integer, String>();
	public int conductionType = -1;
	public 	int reclassified=0;
	/** True to calculate using the formula as found in David Strauss's Excel spreadsheets. Excluding age and sex adjustments and including the formula errors. **/
	public boolean spreadsheetCompatible=false;

	public QRS_Score(){
		mapConductionType.put(1, "Excluded           ");
		mapConductionType.put(2, "LBBB               "); // Left Bundle Branch Block
		mapConductionType.put(3, "RBBB + LAFB        "); // Right Bundle Branch Block + Left Anterior Fascicular Block
		mapConductionType.put(4, "RBBB (without LAFB)"); // Right Bundle Branch Block 
		mapConductionType.put(5, "LAFB               "); // Left Anterior Fascicular Block
		mapConductionType.put(6, "LVH                "); // Left Ventricular Hypertrophy
		mapConductionType.put(7, "No confounders     ");
	}
	
	/** Determines which conduction type (confounder) applies to the ECG data.
	 * Needs qrsd, qrsax, and vrate <BR>
	 * Also looks for scodes 290, 291,292,293 (pacemakers) , 440 and 460 <BR>
	 * To wit:<BR>
	 * Marquette 12SL ECG analysis program statement code for RBBB (# 440) <BR>
	 * Marquette 12SL ECG analysis program statement code for LBBB (# 460) 
	 * 
	 * @return
	 */
	public String classifyConductionType(){

		conductionType = -1; //reset each time.
		if(scode.contains(290) // a.	Any of Scode 290, 291, 292, 293 (these are patients with pacemakers)
				|| scode.contains(291) 
				|| scode.contains(292) 
				|| scode.contains(293) 
				|| (vrate>=150) // b.	OR Vrate >=150
		){
			conductionType = 1; // Excluded: (scodes for pacemakers)
			debugPrint("Excluded:" + FilePath + " scodes:" );
			for (int code:scode){
				debugPrint(code + ", ");
			}
			debugPrintln("");
		}else{
			
			if(scode.contains(460)                 // a.	Include Scode 460
					&& 	(( (qrsd>=140) && (Sex==0) )    // b.	AND QRS duration >=140 ms for males; 
							||( (qrsd>=130) && (Sex==1) ))  //         QRS duration >= 130 ms for females
			){
				if(conductionType != -1) reclassified++;
				conductionType = 2; //LBBB
			}else{		
				if(scode.contains(440)                                // a.	Include Scode 440
						&& (qrsd>=120)                                    // b.	AND QRS duration >=120 ms 
						&&  (( (-90 <= qrsax) && (qrsax <= -45) )         // c.	AND (QRS axis -90 to -45,
								||( (181 <= qrsax) && (qrsax <= 270) ))   //      OR QRS axis 181 to 270)
				){
					if(conductionType != -1) reclassified++;
					conductionType = 3; //RBBB + LAFB
				}else{
					if(scode.contains(440)                       // a.	Include Scode 440 
							&& (qrsd>=120)                           // b.	AND QRS duration >=120 ms
							&&( (qrsax >= -44) && (qrsax <= 180) )   // c.	AND (QRS axis -44 to 180)
					){
						if(conductionType != -1) reclassified++;
						conductionType = 4; // RBBB (without LAFB)
					}else{			
						if((!scode.contains(440) && !scode.contains(460)) // a.	Exclude Scode 460 OR 440
								&& (qrsd>100)                                 // b.	AND QRS duration >= 100 ms
								&& (( (-90 <= qrsax) && (qrsax <= -45) )      // c.	AND (QRS axis -90 to -45, 
										||( (181 <= qrsax) && (qrsax <= 270) ))   //         OR QRS axis 181 to 270)
						){
							if(conductionType != -1) reclassified++;
							conductionType = 5; // LAFB (without RBBB)
						}else{		
							if((conductionType == -1)                       // a.	Exclude patients that meet any of the prior criteria
									&& (isLVH_SokolowLyon() || isLVH_Cornell()) // b.	Include patients that meet either the Sokolow-Lyon or Cornell LVH criteria  
							){
								conductionType = 6; //LVH (Left Ventricular Hypertrophy)
							}else{		
								if(conductionType == -1){ // Not meeting any of the previous criteria
									conductionType = 7; //No confounders
								}
							}
						}
					}
				}
			}
		}


		return mapConductionType.get(conductionType);
	}

	public String getConductionTypeName(){
		return mapConductionType.get(conductionType);
	}
	public boolean isLVH_SokolowLyon(){
		boolean sub1 = ( (Math.max(qa_V1, sa_V1) + Math.max(ra_V5, ra_V6)) >= 3500);
		boolean sub2 = (Math.max(ra_V5, ra_V6) >= 2600);
		
		return sub1 || sub2;
	}
	
	public boolean isLVH_Cornell(){
		boolean ret=false;
		double criteria;
		
		if(Sex==0) 
			criteria = 2800.0; //male
		else 
			criteria = 2000.0; // female
		
		ret = ((ra_aVL + sa_V3) > criteria);
		
		return ret;
	}

	/** Gets the QRS score plus the results of the sub-calculations in an integer array.
	 * to wit:
	 * points_I, points_II, points_aVL, points_aVF, points_V1ant, points_V1post, points_V2ant, points_V2post, points_V3, points_V4, points_V5, points_V6, QRS_Score
	 * @return - sub-totals and final score.
	 */

	
	public int[] getFullResults(){
		int[] ret = new int[13];
		ret[0] = points_I;
		ret[1] = points_II;
		ret[2] = points_aVL;
		ret[3] = points_aVF;
		ret[4] = points_V1ant;
		ret[5] = points_V1post;
		ret[6] = points_V2ant;
		ret[7] = points_V2post;
		ret[8] = points_V3;
		ret[9] = points_V4;
		ret[10] = points_V5;
		ret[11] = points_V6; 
		ret[12] = QRS_Score;
		
		return ret;		
	}
	
	/** Calculates the percentage Left Ventricle Scar in the 12 LV segments as per the chart and instructions in Appendix A.
	 *  (Maximum sum of all 12 is really 96%, not 100% due to integer math in the original paper.)
	 *  Based on the sub-sub-calculations values:
	 * Qpts_I     
	 * RATpts_I     
	 * Qpts_II     
	 * Qpts_aVL     
	 * RATpts_aVL     
	 * Qpts_aVF     
	 * RATpts_aVF     
	 * Qpts_V1     
	 * RATpts_V1     
	 * Rpts_V1     
	 * QSpts_V1     
	 * QorRpts_V2     
	 * RATpts_V2     
	 * Rpts_V2     
	 * QSpts_V2     
	 * QorRpts_V3     
	 * Qpts_V4     
	 * Rpts_V4     
	 * Qpts_V5     
	 * Rpts_V5     
	 * Qpts_V6     
	 * Rpts_V6     
	 * 
	 * @return - zero based integer array, therefore element[0] = segment 1 ... element[11] = segment 12.
	 */
	public int[] getPercentLVScarBySegment(){
		int r; // temporary result accumulator

		int[] ret = new int[12];
		//--------------- Anteroseptal ------------------------
		// Segment 1
		r=0;
		// ------------------------- V1 Ant
		if(Qpts_V1   ==2) r+= 2;
		if(Qpts_V1   ==1) r+= 0;
		// ------------------------- V2 Ant
		if(QorRpts_V2==1) r+= 2;
		if(QorRpts_V2==1) r+= 0;
		// ------------------------- V3
		if(QorRpts_V3==2) r+= 2;
		if(QorRpts_V3==1) r+= 1;
		// ------------------------- V4
		if(Qpts_V4   ==1) r+= 1;
		if(Rpts_V4   ==2) r+= 2;
		if(Rpts_V4   ==1) r+= 1;
		// ------------------------- V5
		if(Qpts_V5   ==1) r+= 1;		
		if(Rpts_V5   ==2) r+= 2;		
		if(Rpts_V5   ==1) r+= 1;		
		ret[0] = r; 
		
		// Segment 2
		r=0;
		// ------------------------- V1 Ant
		if(Qpts_V1   ==2) r+= 2;
		if(Qpts_V1   ==1) r+= 1;
		// ------------------------- V2 Ant
		if(QorRpts_V2==1) r+= 2;
		if(QorRpts_V2==1) r+= 1;
		// ------------------------- V3
		if(QorRpts_V3==2) r+= 2;
		if(QorRpts_V3==1) r+= 1;
		// ------------------------- V4
		if(Qpts_V4   ==1) r+= 1;
		if(Rpts_V4   ==2) r+= 1;
		if(Rpts_V4   ==1) r+= 1;
		// ------------------------- V5
		if(Qpts_V5   ==1) r+= 1;		
		if(Rpts_V5   ==2) r+= 1;		
		if(Rpts_V5   ==1) r+= 0;		
		ret[1] = r; 

		// Segment 3
		r=0;
		// ------------------------- V1 Ant
		if(Qpts_V1   ==2) r+= 2;
		if(Qpts_V1   ==1) r+= 2;
		// ------------------------- V2 Ant
		if(QorRpts_V2==1) r+= 2;
		if(QorRpts_V2==1) r+= 2;
		// ------------------------- V3
		if(QorRpts_V3==2) r+= 1;
		if(QorRpts_V3==1) r+= 0;
		ret[2] = r; 

		//---------------- Anterosuperior -----------------------
		// Segment 4
		r=0;
		// ------------------------- I
		if(Qpts_I    ==2) r+= 1;
		if(Qpts_I    ==1) r+= 1;
		// ------------------------- V4
		if(Qpts_V4   ==1) r+= 1;
		if(Rpts_V4   ==2) r+= 1;
		if(Rpts_V4   ==1) r+= 1;
		// ------------------------- V5
		if(Qpts_V5   ==1) r+= 1;		
		if(Rpts_V5   ==2) r+= 1;		
		if(Rpts_V5   ==1) r+= 1;		
		// ------------------------- V6
		if(Qpts_V6   ==1) r+= 1;		
		if(Rpts_V6   ==2) r+= 1;
		if(Rpts_V6   ==1) r+= 0;
		ret[3] = r; 
		
		// Segment 5
		r=0;
		// ------------------------- I
		if(Qpts_I    ==2) r+= 1;
		if(Qpts_I    ==1) r+= 1;
		// ------------------------- aVL		
		if(Qpts_aVL  ==1) r+= 2;
		if(RATpts_aVL==1) r+= 1;
		// ------------------------- V3
		if(QorRpts_V3==2) r+= 1;
		if(QorRpts_V3==1) r+= 1;
		// ------------------------- V4
		if(Qpts_V4   ==1) r+= 0;
		if(Rpts_V4   ==2) r+= 1;
		if(Rpts_V4   ==1) r+= 0;
		// ------------------------- V5
		if(Qpts_V5   ==1) r+= 0;		
		if(Rpts_V5   ==2) r+= 1;		
		if(Rpts_V5   ==1) r+= 1;		
		ret[4] = r; 

		// Segment 6
		r=0;
		// ------------------------- I
		if(Qpts_I    ==2) r+= 0;
		if(Qpts_I    ==1) r+= 1;
		// ------------------------- aVL		
		if(Qpts_aVL  ==1) r+= 1;
		if(RATpts_aVL==1) r+= 2;
		// ------------------------- V1 Post
		if(RATpts_V1 ==1) r+= 0;
		if(Rpts_V1   ==2) r+= 1;
		if(Rpts_V1   ==1) r+= 0;
		if(Qpts_V1   ==1) r+= 0;
		ret[5] = r; 
		//---------------- Inferior -----------------------
		// Segment 7
		r=0;
		// ------------------------- II		
		if(Qpts_II   ==2) r+= 2;
		if(Qpts_II   ==1) r+= 0;
		// ------------------------- aVF
		if(Qpts_aVF  ==3) r+= 3;
		if(Qpts_aVF  ==2) r+= 2;
		if(Qpts_aVF  ==1) r+= 0;
		if(RATpts_aVF==2) r+= 0;
		if(RATpts_aVF==1) r+= 0;
		// ------------------------- V1 Post
		if(RATpts_V1 ==1) r+= 0;
		if(Rpts_V1   ==2) r+= 1;
		if(Rpts_V1   ==1) r+= 1;
		if(Qpts_V1   ==1) r+= 0;
		// ------------------------- V2 Post
		if(RATpts_V2 ==1) r+= 0;
		if(Rpts_V2   ==2) r+= 1;
		if(Rpts_V2   ==1) r+= 0;
		if(QSpts_V2  ==1) r+= 0;
		// ------------------------- V4
		if(Qpts_V4   ==1) r+= 0;
		if(Rpts_V4   ==2) r+= 1;
		if(Rpts_V4   ==1) r+= 0;
		// ------------------------- V5
		if(Qpts_V5   ==1) r+= 0;		
		if(Rpts_V5   ==2) r+= 1;		
		if(Rpts_V5   ==1) r+= 0;		
		// ------------------------- V6
		if(Qpts_V6   ==1) r+= 1;		
		if(Rpts_V6   ==2) r+= 1;
		if(Rpts_V6   ==1) r+= 1;
		ret[6] = r;

		// Segment 8
		r=0;
		// ------------------------- II		
		if(Qpts_II   ==2) r+= 2;
		if(Qpts_II   ==1) r+= 2;
		// ------------------------- aVF
		if(Qpts_aVF  ==3) r+= 2;
		if(Qpts_aVF  ==2) r+= 2;
		if(Qpts_aVF  ==1) r+= 2;
		if(RATpts_aVF==2) r+= 1;
		if(RATpts_aVF==1) r+= 1;
		// ------------------------- V1 Post
		if(RATpts_V1 ==1) r+= 0;
		if(Rpts_V1   ==2) r+= 1;
		if(Rpts_V1   ==1) r+= 0;
		if(Qpts_V1   ==1) r+= 0;
		// ------------------------- V2 Post
		if(RATpts_V2 ==1) r+= 0;
		if(Rpts_V2   ==2) r+= 1;
		if(Rpts_V2   ==1) r+= 1;
		if(QSpts_V2  ==1) r+= 1;
		ret[7] = r; 
		
		// Segment 9
		r=0;
		// ------------------------- II		
		if(Qpts_II   ==2) r+= 2;
		if(Qpts_II   ==1) r+= 1;
		// ------------------------- aVF
		if(Qpts_aVF  ==3) r+= 2;
		if(Qpts_aVF  ==2) r+= 2;
		if(Qpts_aVF  ==1) r+= 1;
		if(RATpts_aVF==2) r+= 3;
		if(RATpts_aVF==1) r+= 2;
		// ------------------------- V1 Post
		if(RATpts_V1 ==1) r+= 0;
		if(Rpts_V1   ==2) r+= 1;
		if(Rpts_V1   ==1) r+= 0;
		if(Qpts_V1   ==1) r+= 1;
		// ------------------------- V2 Post
		if(RATpts_V2 ==1) r+= 1;
		if(Rpts_V2   ==2) r+= 0;
		if(Rpts_V2   ==1) r+= 0;
		if(QSpts_V2  ==1) r+= 0;
		ret[8] = r; 

		//---------------- Posterolateral -----------------------
		// Segment 10 
		r=0;
		// ------------------------- I
		if(Qpts_I    ==2) r+= 1;
		if(Qpts_I    ==1) r+= 0;
		// ------------------------- V1 Post
		if(RATpts_V1 ==1) r+= 1;
		if(Rpts_V1   ==2) r+= 1;
		if(Rpts_V1   ==1) r+= 1;
		if(Qpts_V1   ==1) r+= 0;
		// ------------------------- V2 Post
		if(RATpts_V2 ==1) r+= 0;
		if(Rpts_V2   ==2) r+= 1;
		if(Rpts_V2   ==1) r+= 1;
		if(QSpts_V2  ==1) r+= 0;
		// ------------------------- V6
		if(Qpts_V6   ==1) r+= 2;		
		if(Rpts_V6   ==2) r+= 2;
		if(Rpts_V6   ==1) r+= 1;
		ret[9] = r; 

		// Segment 11
		r=0;
		// ------------------------- V1 Post
		if(RATpts_V1 ==1) r+= 1;
		if(Rpts_V1   ==2) r+= 1;
		if(Rpts_V1   ==1) r+= 1;
		if(Qpts_V1   ==1) r+= 1;
		// ------------------------- V2 Post
		if(RATpts_V2 ==1) r+= 1;
		if(Rpts_V2   ==2) r+= 2;
		if(Rpts_V2   ==1) r+= 1;
		if(QSpts_V2  ==1) r+= 1;
		// ------------------------- V6
		if(Qpts_V6   ==1) r+= 0;		
		if(Rpts_V6   ==2) r+= 2;
		if(Rpts_V6   ==1) r+= 1;
		ret[10] = r; 
		
		// Segment 12
		r=0;
		// ------------------------- V1 Post
		if(RATpts_V1 ==1) r+= 1;
		if(Rpts_V1   ==2) r+= 1;
		if(Rpts_V1   ==1) r+= 0;
		if(Qpts_V1   ==1) r+= 1;
		// ------------------------- V2 Post
		if(RATpts_V2 ==1) r+= 1;
		if(Rpts_V2   ==2) r+= 1;
		if(Rpts_V2   ==1) r+= 0;
		if(QSpts_V2  ==1) r+= 1;
		ret[11] = r;  

		return ret;		
	}

	/** Calculate the QRS score after determining the conduction type.
	 *  Gets the QRS score plus the results of the sub-calculations in an integer array.
	 *  
	 * @param spreadsheetCompatible -True to calculate using the formula as found in David Strauss's Excel spreadsheets. Excluding age and sex adjustments and including the formula errors. 
	 * @return - sub-totals and final score.
	 */
	public int[] calculateQRS_score_Full(boolean spreadsheetCompatible){
		this.spreadsheetCompatible = spreadsheetCompatible;
		classifyConductionType();
		calculateQRS_score();

		return getFullResults();
	}
	
	/** Calculate the QRS score after determining the conduction type.<BR>
	 *  Gets the QRS score plus the results of the 12 sub-calculations in an integer array.<BR>
 	 * To wit:<BR>
	 * points_I, points_II, points_aVL, points_aVF, points_V1ant, points_V1post, points_V2ant, points_V2post, points_V3, points_V4, points_V5, points_V6, QRS_Score
	 * @return - sub-totals and final score.
	 */
	public int[] calculateQRS_score_Full(){
		classifyConductionType();
		calculateQRS_score();

		return getFullResults();
	}

	/** Calculate the QRS score for the specified conduction type.<BR>
	 *  Gets the QRS score plus the results of the 12 sub-calculations in an integer array.<BR>
 	 * To wit:<BR>
	 * points_I, points_II, points_aVL, points_aVF, points_V1ant, points_V1post, points_V2ant, points_V2post, points_V3, points_V4, points_V5, points_V6, QRS_Score
	 * @return - sub-totals and final score.
	 */
	public int[] calculateQRS_score_Full(int conduction){
		conductionType = conduction;
		calculateQRS_score();

		return getFullResults();
	}


	/** Calculate the QRS score after determining the conduction type.
	 * 
	 * @param spreadsheetCompatible -True to calculate using the formula as found in David Strauss's Excel spreadsheets. Excluding age and sex adjustments and including the formula errors. 
	 * @return - single integer QRS_score.
	 */
	public int calculateQRS_score(boolean spreadsheetCompatible){
		this.spreadsheetCompatible = spreadsheetCompatible;
		classifyConductionType();
		return calculateQRS_score();		
	}
	
	/** Calculate the QRS score after determining the conduction type.
	 * 
	 * @return - single integer QRS_score.
	 */
	public int calculateQRS_score(){
		switch(conductionType) {
			case 1: // Excluded 
				points_I = -1;
				points_II = -1;
				points_aVL = -1;
				points_aVF = -1;
				points_V1ant = -1;
				points_V1post = -1;
				points_V2ant = -1;
				points_V2post = -1;
				points_V3 = -1;
				points_V4 = -1;
				points_V5 = -1;
				points_V6 = -1; 
				QRS_Score = -1;
				break;
			case 2: // LBBB 
				calculateQRS_score1_LBBB();
				break;
			case 3: // RBBB + LAFB 
				calculateQRS_score1_LAFB_RBBB();
				break;
			case 4: // RBBB (without LAFB) 
				calculateQRS_score1_RBBB();
				break;
			case 5: // LAFB 
				calculateQRS_score1_LAFB();
				break;
			case 6: // LVH 
				calculateQRS_score1_LVH_Kors();
				break;
			case 7: // No confounders 
				calculateQRS_score1_No_Confounder();
				break;
			default:
				QRS_Score = -1;
		}
		int badParameterCount = CountMissingParameters();
		positiveError = CalculatePositiveErrorPoints();
		negativeError = CalculateNegativeErrorPoints();
		return QRS_Score;
	}
	
	public int[] calculateQRS_score1_No_ConfounderFull(){
		calculateQRS_score1_No_Confounder();

		return getFullResults();
	}

	public int calculateQRS_score1_No_Confounder(){
		setThresholds_No_Confounder();
		adjustCriteriaForAgeAndSex();

		return calculateQRS_score_No_Confounder();
	}


	public int calculateQRS_score1_LVH_Kors(){
		setThresholds_No_Confounder();
		adjustThresholds_LVH_Kors();
		adjustCriteriaForAgeAndSex();
		return calculateQRS_score_LVH_Kors();
	}

	public int calculateQRS_score1_LAFB_RBBB(){
		setThresholds_No_Confounder();
		adjustThresholds_LAFB_RBBB();
		adjustCriteriaForAgeAndSex();
		return calculateQRS_score_LAFB_RBBB();
	}

	public int calculateQRS_score1_LAFB(){
		setThresholds_No_Confounder();
		adjustThresholds_LAFB();
		adjustCriteriaForAgeAndSex();
		return calculateQRS_score_LAFB();
	}

	public int calculateQRS_score1_RBBB(){
		setThresholds_No_Confounder();
		adjustThresholds_RBBB();
		adjustCriteriaForAgeAndSex();
		return calculateQRS_score_RBBB();
	}

	public int calculateQRS_score1_LBBB(){
		setThresholds_No_Confounder();
		adjustThresholds_LBBB();
		adjustCriteriaForAgeAndSex();
		return calculateQRS_score_LBBB();
	}
	
	/** Sets the default thresholds for the No Confounder conduction type
	 * Other conduction types will modify the thresholds which are different for them.
	 */
	private void setThresholds_No_Confounder(){
		//---------------------------------
		// qd_I, RQra_I, ra_I, 
		// 30,   1,      200,  
		mapThreshold.put("qd_I", 30.0);  
		mapThreshold.put("RQra_I upper", 1.0); // only used with calcLead_I_LBBB 
		mapThreshold.put("RQra_I", 1.0);  
		mapThreshold.put("RSra_I upper", 1.5); // only used with calcLead_I_LBBB 
		mapThreshold.put("RSra_I lower", 1.0); // only used with calcLead_I_LBBB 
		mapThreshold.put("ra_I", 200.0);  
		//---------------------------------
		//qd_II upper, qd_II lower, 
		//40,          30,          
		mapThreshold.put("qd_II upper", 40.0);  
		mapThreshold.put("qd_II lower", 30.0);  
		//---------------------------------		
		//qd_aVL, RQra_aVL, 
		//30,     1,        
		mapThreshold.put("qd_aVL", 30.0);  
		mapThreshold.put("RQra_aVL", 1.0);  
		//---------------------------------
		//qd_aVF upper, qd_aVF middle, qd_aVF lower, RQra_aVF lower, RQra_aVF upper, 
		//50,           40,            30,           1,              2,              
		mapThreshold.put("qd_aVF upper", 50.0);  
		mapThreshold.put("qd_aVF middle", 40.0);  
		mapThreshold.put("qd_aVF lower", 30.0);  
		mapThreshold.put("RQra_aVF lower", 1.0);  
		mapThreshold.put("RQra_aVF upper", 2.0);  
		//---------------------------------
		//qd_V1ant, RSra_V1, rd_V1 upper, rd_V1 lower, ra_V1 upper, ra_V1 lower, qa_V1, sa_V1, 
		//0,     1,       50,          40,          1000,        700,         200,   200,   
		mapThreshold.put("qd_V1ant", 0.0);  
		mapThreshold.put("rd_V1ant", 0.0); // new criteria not used in non-confounder
		mapThreshold.put("RSra_V1", 1.0);  
		mapThreshold.put("rd_V1 upper", 50.0);  
		mapThreshold.put("rd_V1 lower", 40.0); 
		mapThreshold.put("ra_V1 upper", 1000.0); 
		mapThreshold.put("ra_V1 lower", 700.0);   
		mapThreshold.put("qa_V1", 200.0);  
		mapThreshold.put("sa_V1", 200.0);  
		//---------------------------------
		//qd_V2, rd_V2 lower, rd_V2 middle, rd_V2 upper, ra_V2 lower, ra_V2 middle, ra_V2 upper, Rsra_V2,  qa_V2, sa_V2, 
		//0,     10,          50,           60,          100,         1500,         2000,        1.5,      300,   300,   
		mapThreshold.put("qd_V2ant upper", 0.0);    // used in V2ant
		mapThreshold.put("qd_V2ant lower", 0.0);    // used in V2ant
//		mapThreshold.put("rd_V2ant lower", 0.0);   // not used
		mapThreshold.put("rd_V2 lower", 10.0);  // used in V2ant
		mapThreshold.put("rd_V2 middle", 50.0);  
		mapThreshold.put("rd_V2 upper", 60.0);  
		mapThreshold.put("ra_V2 lower", 100.0);    // used in V2ant
		mapThreshold.put("ra_V2 middle", 1500.0);
		mapThreshold.put("ra_V2 upper", 2000.0);  
		mapThreshold.put("Rsra_V2", 1.5);  
		mapThreshold.put("qa_V2", 300.0);  
		mapThreshold.put("sa_V2", 300.0);  
		//---------------------------------
		//qd_V3 upper, qd_V3 lower, rd_V3 lower, rd_V3 upper, 
		//30,          20,          10,          20,          
		mapThreshold.put("qd_V3 upper", 30.0);  
		mapThreshold.put("qd_V3 lower", 20.0);  
		mapThreshold.put("rd_V3 lower", 10.0);  
		mapThreshold.put("rd_V3 upper", 20.0);  
		//---------------------------------
		//qd_V4, RQra_V4 lower, RQra_V4 upper, RSra_V4 lower, RSra_V4 upper, ra_V4, 
		//20,    0.5,           1.0,           0.5,           1.0,           500,   
		mapThreshold.put("qd_V4", 20.0);  
		mapThreshold.put("RQra_V4 lower", 0.5);  
		mapThreshold.put("RQra_V4 upper", 1.0);  
		mapThreshold.put("RSra_V4 lower", 0.5);  
		mapThreshold.put("RSra_V4 upper", 1.0);  
		mapThreshold.put("ra_V4", 500.0);  
		//---------------------------------
		//qd_V5, RQra_V5 lower, RQra_V5 upper, RSra_V5 lower, RSra_V5 upper, ra_V5, 
		//30,    1,             2,             1,             2,             600,   
		mapThreshold.put("qd_V5", 30.0);  
		mapThreshold.put("RQra_V5 lower", 1.0);  
		mapThreshold.put("RQra_V5 upper", 2.0);  
		mapThreshold.put("RSra_V5 lower", 1.0);  
		mapThreshold.put("RSra_V5 upper", 2.0);  
		mapThreshold.put("ra_V5", 600.0);  
		//---------------------------------
		//qd_V6, RQra_V6 lower, RQra_V6 upper, RSra_V6 lower, RSra_V6 upper, ra_V6
		//30,    1,             3,             1,             3,             600
		mapThreshold.put("qd_V6", 30.0);  
		mapThreshold.put("RQra_V6 lower", 1.0);  
		mapThreshold.put("RQra_V6 upper", 3.0);  
		mapThreshold.put("RSra_V6 lower", 1.0);  
		mapThreshold.put("RSra_V6 upper", 3.0);  
		mapThreshold.put("ra_V6", 600.0);
	}
	
	private void adjustThresholds_LVH_Kors(){
		//---------------------------------
		// qd_I, RQra_I, ra_I, 
		// 30,   1,      200,  
		//---------------------------------
		//qd_II upper, qd_II lower, 
		//40,          30,          
		//---------------------------------		
		//qd_aVL, RQra_aVL, 
		//30,     1,        
		mapThreshold.put("qd_aVL", 40.0);  
		//---------------------------------
		//qd_aVF upper, qd_aVF middle, qd_aVF lower, RQra_aVF lower, RQra_aVF upper, 
		//50,           40,            30,           1,              2,              
		mapThreshold.put("qd_aVF upper", 60.0);  
		mapThreshold.put("qd_aVF middle", 50.0);  
		mapThreshold.put("qd_aVF lower", 40.0);  
		//---------------------------------
		//qd_V1ant, RSra_V1, rd_V1 upper, rd_V1 lower, ra_V1 upper, ra_V1 lower, qa_V1, sa_V1, 
		//0,     1,       50,          40,          1000,        700,         200,   200,   
		mapThreshold.put("rd_V1ant", 0.0); // new criteria not used in non-confounder
		//---------------------------------
		//qd_V2, rd_V2 lower, rd_V2 middle, rd_V2 upper, ra_V2 lower, ra_V2 middle, ra_V2 upper, Rsra_V2,  qa_V2, sa_V2, 
		//0,     10,          50,           60,          100,         1500,         2000,        1.5,      300,   300,   
		//---------------------------------
		//qd_V3 upper, qd_V3 lower, rd_V3 lower, rd_V3 upper, 
		//30,          20,          10,          20,          
		mapThreshold.put("qd_V3 upper", 30.0);  
		mapThreshold.put("qd_V3 lower", 20.0);  
		mapThreshold.put("rd_V3 lower", 10.0);  
		mapThreshold.put("rd_V3 upper", 20.0);  
		//---------------------------------
		//qd_V4, RQra_V4 lower, RQra_V4 upper, RSra_V4 lower, RSra_V4 upper, ra_V4, 
		//20,    0.5,           1.0,           0.5,           1.0,           500,   
		//---------------------------------
		//qd_V5, RQra_V5 lower, RQra_V5 upper, RSra_V5 lower, RSra_V5 upper, ra_V5, 
		//30,    1,             2,             1,             2,             600,   
		//---------------------------------
		//qd_V6, RQra_V6 lower, RQra_V6 upper, RSra_V6 lower, RSra_V6 upper, ra_V6
		//30,    1,             3,             1,             3,             600
	}
	
	
	private void adjustThresholds_LAFB_RBBB(){
		//---------------------------------
		// qd_I, RQra_I, ra_I, 
		// 30,   1,      200,  
		//---------------------------------
		//qd_II upper, qd_II lower, 
		//40,          30,          
		//---------------------------------		
		//qd_aVL, RQra_aVL, 
		//30,     1,        
		mapThreshold.put("qd_aVL", 40.0);  
		//---------------------------------
		//qd_aVF upper, qd_aVF middle, qd_aVF lower, RQra_aVF lower, RQra_aVF upper, 
		//50,           40,            30,           1,              2,              
		//---------------------------------
		//qd_V1ant, RSra_V1, rd_V1 upper, rd_V1 lower, ra_V1 upper, ra_V1 lower, qa_V1, sa_V1, 
		//0,     1,       50,          40,          1000,        700,         200,   200,   
		mapThreshold.put("qd_V1ant", 50.0);
		mapThreshold.put("RSra_V1", -1.0);  
		mapThreshold.put("rd_V1 upper", 60.0);  
		mapThreshold.put("rd_V1 lower", 50.0); 
		mapThreshold.put("ra_V1 upper", 1500.0); 
		mapThreshold.put("ra_V1 lower", 1000.0);   
		mapThreshold.put("qa_V1", 0.0);  
		mapThreshold.put("sa_V1", 0.0);  
		//---------------------------------
		//qd_V2, rd_V2 lower, rd_V2 middle, rd_V2 upper, ra_V2 lower, ra_V2 middle, ra_V2 upper, Rsra_V2,  qa_V2, sa_V2, 
		//0,     10,          50,           60,          100,         1500,         2000,        1.5,      300,   300,   
		mapThreshold.put("qd_V2ant upper", 50.0);   
		mapThreshold.put("qd_V2ant lower", 0.0);   
		mapThreshold.put("rd_V2 upper", 70.0);  
		mapThreshold.put("ra_V2 middle", 2000.0);
		mapThreshold.put("ra_V2 upper", 2500.0);  
		mapThreshold.put("Rsra_V2", -1.0);  
		//---------------------------------
		//qd_V3 upper, qd_V3 lower, rd_V3 lower, rd_V3 upper, 
		//30,          20,          10,          20,          
//		mapThreshold.put("qd_V3 upper", 30.0);  
//		mapThreshold.put("qd_V3 lower", 20.0);  
//		mapThreshold.put("rd_V3 lower", 10.0);  
//		mapThreshold.put("rd_V3 upper", 20.0);  
		//---------------------------------
		//qd_V4, RQra_V4 lower, RQra_V4 upper, RSra_V4 lower, RSra_V4 upper, ra_V4, 
		//20,    0.5,           1.0,           0.5,           1.0,           500,   
		//---------------------------------
		//qd_V5, RQra_V5 lower, RQra_V5 upper, RSra_V5 lower, RSra_V5 upper, ra_V5, 
		//30,    1,             2,             1,             2,             600,   
		mapThreshold.put("RSra_V4 upper", 1.5);  
		//---------------------------------
		//qd_V6, RQra_V6 lower, RQra_V6 upper, RSra_V6 lower, RSra_V6 upper, ra_V6
		//30,    1,             3,             1,             3,             600
		mapThreshold.put("RSra_V6 upper", 2.0);  
	}

	private void adjustThresholds_LAFB(){
		//---------------------------------
		// qd_I, RQra_I, ra_I, 
		// 30,   1,      200,  
		//---------------------------------
		//qd_II upper, qd_II lower, 
		//40,          30,          
		//---------------------------------		
		//qd_aVL, RQra_aVL, 
		//30,     1,        
		mapThreshold.put("qd_aVL", 40.0);  
		//---------------------------------
		//qd_aVF upper, qd_aVF middle, qd_aVF lower, RQra_aVF lower, RQra_aVF upper, 
		//50,           40,            30,           1,              2,              
		//---------------------------------
		//qd_V1ant, RSra_V1, rd_V1 upper, rd_V1 lower, ra_V1 upper, ra_V1 lower, qa_V1, sa_V1, 
		//0,     1,       50,          40,          1000,        700,         200,   200,   
		//---------------------------------
		//qd_V2ant lower, rd_V2ant lower, rd_V2 lower, rd_V2 middle, rd_V2 upper, ra_V2 lower, ra_V2 middle, ra_V2 upper, Rsra_V2,  qa_V2, sa_V2, 
		//0,              0,              10,          50,           60,          100,         1500,         2000,        1.5,      300,   300,   
		//---------------------------------
		//qd_V3 upper, qd_V3 lower, rd_V3 lower, rd_V3 upper, 
		//30,          20,          10,          20,          
		//---------------------------------
		//qd_V4, RQra_V4 lower, RQra_V4 upper, RSra_V4 lower, RSra_V4 upper, ra_V4, 
		//20,    0.5,           1.0,           0.5,           1.0,           500,   
		//---------------------------------
		//qd_V5, RQra_V5 lower, RQra_V5 upper, RSra_V5 lower, RSra_V5 upper, ra_V5, 
		//30,    1,             2,             1,             2,             600,   
		mapThreshold.put("RSra_V5 upper", 1.5);  
		//---------------------------------
		//qd_V6, RQra_V6 lower, RQra_V6 upper, RSra_V6 lower, RSra_V6 upper, ra_V6
		//30,    1,             3,             1,             3,             600
		mapThreshold.put("RSra_V6 upper", 2.0);  
	}

	private void adjustThresholds_RBBB(){
		//---------------------------------
		// qd_I, RQra_I, ra_I, 
		// 30,   1,      200,  
		//---------------------------------
		//qd_II upper, qd_II lower, 
		//40,          30,          
		//---------------------------------		
		//qd_aVL, RQra_aVL, 
		//30,     1,        
		//---------------------------------
		//qd_aVF upper, qd_aVF middle, qd_aVF lower, RQra_aVF lower, RQra_aVF upper, 
		//50,           40,            30,           1,              2,              
		//---------------------------------
		//qd_V1ant, RSra_V1, rd_V1 upper, rd_V1 lower, ra_V1 upper, ra_V1 lower, qa_V1, sa_V1, 
		//0,     1,       50,          40,          1000,        700,         200,   200,   
		mapThreshold.put("qd_V1ant", 50.0);
		mapThreshold.put("rd_V1ant", 20.0);
		mapThreshold.put("RSra_V1", -1.0);  
		mapThreshold.put("rd_V1 upper", 60.0);  
		mapThreshold.put("rd_V1 lower", 50.0); 
		mapThreshold.put("ra_V1 upper", 1500.0); 
		mapThreshold.put("ra_V1 lower", 1000.0);   
		mapThreshold.put("qa_V1", 0.0);  
		mapThreshold.put("sa_V1", 0.0);  
		//---------------------------------
		//qd_V2, rd_V2 lower, rd_V2 middle, rd_V2 upper, ra_V2 lower, ra_V2 middle, ra_V2 upper, Rsra_V2,  qa_V2, sa_V2, 
		//0,     10,          50,           60,          100,         1500,         2000,        1.5,      300,   300,   
		mapThreshold.put("qd_V2ant upper", 50.0);   
		mapThreshold.put("qd_V2ant lower", 0.0);   
		mapThreshold.put("rd_V2 upper", 70.0);  
		mapThreshold.put("ra_V2 middle", 2000.0);
		mapThreshold.put("ra_V2 upper", 2500.0);  
		mapThreshold.put("Rsra_V2", -1.0);  
		//---------------------------------
		//qd_V3 upper, qd_V3 lower, rd_V3 lower, rd_V3 upper, 
		//30,          20,          10,          20,          
//		mapThreshold.put("qd_V3 upper", 30.0);  
//		mapThreshold.put("qd_V3 lower", 20.0);  
//		mapThreshold.put("rd_V3 lower", 10.0);  
//		mapThreshold.put("rd_V3 upper", 20.0);  
		//---------------------------------
		//qd_V4, RQra_V4 lower, RQra_V4 upper, RSra_V4 lower, RSra_V4 upper, ra_V4, 
		//20,    0.5,           1.0,           0.5,           1.0,           500,   
		//---------------------------------
		//qd_V5, RQra_V5 lower, RQra_V5 upper, RSra_V5 lower, RSra_V5 upper, ra_V5, 
		//30,    1,             2,             1,             2,             600,   
		//---------------------------------
		//qd_V6, RQra_V6 lower, RQra_V6 upper, RSra_V6 lower, RSra_V6 upper, ra_V6
		//30,    1,             3,             1,             3,             600
	}

	private void adjustThresholds_LBBB(){
		//---------------------------------
		// qd_I, RQra_I, ra_I, 
		// 30,   1,      200,  
		mapThreshold.put("qd_I", 0.0);  
		mapThreshold.put("RQra_I upper", 1.0); // only used with calcLead_I_LBBB 
		mapThreshold.put("RSra_I upper", 1.5); // only used with calcLead_I_LBBB 
		mapThreshold.put("RSra_I lower", 1.0); // only used with calcLead_I_LBBB 
		//---------------------------------
		//qd_II upper, qd_II lower, 
		//40,          30,          
		mapThreshold.put("RSra_II", 0.5); // only used with calcLead_I_LBBB 
		mapThreshold.put("RQra_II", 0.5); // only used with calcLead_I_LBBB 
		
		//---------------------------------		
		//qd_aVL, RQra_aVL, 
		//30,     1,        
		//---------------------------------
		//qd_aVF upper, qd_aVF middle, qd_aVF lower, RQra_aVF lower, RQra_aVF upper, 
		//50,           40,            30,           1,              2,     
		mapThreshold.put("RQra_aVF upper", 0.5); // only used with calcLead_I_LBBB 
		mapThreshold.put("RSra_aVF upper", 0.5); // only used with calcLead_I_LBBB 
		
		//---------------------------------
		//qd_V1ant, RSra_V1, rd_V1 upper, rd_V1 lower, ra_V1 upper, ra_V1 lower, qa_V1, sa_V1, 
		//0,     1,       50,          40,          1000,        700,         200,   200,
		mapThreshold.put("rd_V1 lower", 20.0); 
		mapThreshold.put("ra_V1 lower", 200.0); 
		mapThreshold.put("rd_V1 upper", 30.0); 
		mapThreshold.put("ra_V1 upper", 300.0); 
		//---------------------------------
		//qd_V2, rd_V2 lower, rd_V2 middle, rd_V2 upper, ra_V2 lower, ra_V2 middle, ra_V2 upper, Rsra_V2,  qa_V2, sa_V2, 
		//0,     10,          50,           60,          100,         1500,         2000,        1.5,      300,   300,   
		mapThreshold.put("rd_V2 lower", 20.0); 
		mapThreshold.put("ra_V2 lower", 300.0); 
		mapThreshold.put("rd_V2 upper", 30.0); 
		mapThreshold.put("ra_V2 upper", 400.0); 
		//---------------------------------
		//qd_V3 upper, qd_V3 lower, rd_V3 lower, rd_V3 upper, 
		//30,          20,          10,          20,          
		//---------------------------------
		//qd_V4, RQra_V4 lower, RQra_V4 upper, RSra_V4 lower, RSra_V4 upper, ra_V4, 
		//20,    0.5,           1.0,           0.5,           1.0,           500,   
		//---------------------------------
		//qd_V5, RQra_V5 lower, RQra_V5 upper, RSra_V5 lower, RSra_V5 upper, ra_V5, 
		//30,    1,             2,             1,             2,             600,   
		mapThreshold.put("qd_V5", 0.0);
		mapThreshold.put("RSra_V5 lower", 2.0);  
		mapThreshold.put("ra_V5", 500.0);  
		//---------------------------------
		//qd_V6, RQra_V6 lower, RQra_V6 upper, RSra_V6 lower, RSra_V6 upper, ra_V6
		//30,    1,             3,             1,             3,             600
		mapThreshold.put("qd_V6", 20.0);
		mapThreshold.put("RSra_V6 lower", 2.0);  
		mapThreshold.put("ra_V6", 600.0);
	}



	/** Adjusts the criteria based on the age and gender of the subject:
 	* as found in the �Strauss-Selvester � QRS Scores � JECG 2009.pdf� paper: 
 	* �QRS Score Instructions� in Appendix A, page 93.
	* To wit:
	* 2. Age normalize all amplitude criteria to age 55
	*    By increasing them 1%/yr 20-54 and
	*    Decreasing them 1%/yr for > 55 yrs.
	* 3. For females further decrease by 10% all
	*    QRSdur and QRSamp criteria.
	*    (clarification: this is 10% of the original value, 
	*     not 10% of the value after the adjustment in #2.)
	*/
	public void adjustCriteriaForAgeAndSex(){
		if(!spreadsheetCompatible){
			double ageFactor = (55 - Age)/100;		
			double XXFactor = Sex*0.1;
		
			//---------------------------------
			// qd_I, RQra_I, ra_I, 
			adjustDurCriteria("qd_I", XXFactor);  
			adjustAmpCriteria("ra_I", ageFactor, XXFactor);  
			//---------------------------------
			//qd_II upper, qd_II lower, 
			adjustDurCriteria("qd_II upper", XXFactor);  
			adjustDurCriteria("qd_II lower", XXFactor);  
			//---------------------------------		
			//qd_aVL, RQra_aVL, 
			adjustDurCriteria("qd_aVL", XXFactor);  
			//---------------------------------
			//qd_aVF upper, qd_aVF middle, qd_aVF lower, RQra_aVF lower, RQra_aVF upper, 
			adjustDurCriteria("qd_aVF upper", XXFactor);  
			adjustDurCriteria("qd_aVF middle", XXFactor);  
			adjustDurCriteria("qd_aVF lower", XXFactor);  
			//---------------------------------
			//qd_V1ant, RSra_V1, rd_V1 upper, rd_V1 lower, ra_V1 upper, ra_V1 lower, qa_V1, sa_V1, 
			adjustDurCriteria("qd_V1ant", XXFactor);  
			adjustDurCriteria("rd_V1ant", XXFactor);  
			adjustDurCriteria("rd_V1 upper", XXFactor);  
			adjustDurCriteria("rd_V1 lower", XXFactor); 
			adjustAmpCriteria("ra_V1 upper", ageFactor, XXFactor); 
			adjustAmpCriteria("ra_V1 lower", ageFactor, XXFactor);   
			adjustAmpCriteria("qa_V1", ageFactor, XXFactor);  
			adjustAmpCriteria("sa_V1", ageFactor, XXFactor);  
			//---------------------------------
			//qd_V2, rd_V2 lower, rd_V2 middle, rd_V2 upper, ra_V2 lower, ra_V2 middle, ra_V2 upper, Rsra_V2,  qa_V2, sa_V2, 
			adjustDurCriteria("qd_V2ant upper", XXFactor);  
			adjustDurCriteria("qd_V2ant lower", XXFactor);  
	
			adjustDurCriteria("rd_V2 lower", XXFactor);  
			adjustDurCriteria("rd_V2 middle", XXFactor);  
			adjustDurCriteria("rd_V2 upper", XXFactor);  
			adjustAmpCriteria("ra_V2 lower", ageFactor, XXFactor);  
			adjustAmpCriteria("ra_V2 middle", ageFactor, XXFactor);
			adjustAmpCriteria("ra_V2 upper", ageFactor, XXFactor);  
			adjustAmpCriteria("qa_V2", ageFactor, XXFactor);  
			adjustAmpCriteria("sa_V2", ageFactor, XXFactor);  
			//---------------------------------
			//qd_V3 upper, qd_V3 lower, rd_V3 lower, rd_V3 upper, 
			adjustDurCriteria("qd_V3 upper", XXFactor);  
			adjustDurCriteria("qd_V3 lower", XXFactor);  
			adjustDurCriteria("rd_V3 lower", XXFactor);  
			adjustDurCriteria("rd_V3 upper", XXFactor);  
			//---------------------------------
			//qd_V4, RQra_V4 lower, RQra_V4 upper, RSra_V4 lower, RSra_V4 upper, ra_V4, 
			adjustDurCriteria("qd_V4", XXFactor);  
			adjustAmpCriteria("ra_V4", ageFactor, XXFactor);  
			//---------------------------------
			//qd_V5, RQra_V5 lower, RQra_V5 upper, RSra_V5 lower, RSra_V5 upper, ra_V5, 
			adjustDurCriteria("qd_V5", XXFactor);  
			adjustAmpCriteria("ra_V5", ageFactor, XXFactor);  
			//---------------------------------
			//qd_V6, RQra_V6 lower, RQra_V6 upper, RSra_V6 lower, RSra_V6 upper, ra_V6
			adjustDurCriteria("qd_V6", XXFactor);  
			adjustAmpCriteria("ra_V6", ageFactor, XXFactor);
		}
	}	

	/** Adjusts the criteria based on the age and sex factors
	* 2. Age normalize all amplitude criteria to age 55
	*    By increasing them 1%/yr 20-54 and
	*    Decreasing them 1%/yr for > 55 yrs.
	*   @param key - the key string of the criteria in the Map mapThreshold()
	*   @param ageFactor - factor by which to increase the criteria value e.g. +0.1 = 10% increase (adjusts for age)
	*   @param XXFactor -  factor by which to increase the criteria value e.g. +0.1 = 10% increase (adjusts for being female)
	*/
	private void adjustAmpCriteria(String key, double ageFactor, double XXFactor){
		double value = mapThreshold.get(key);
		
		mapThreshold.put(key, (value + (ageFactor * value) - (XXFactor * value)) ); 
	}
	
	/** Adjusts the criteria based on the sex factor:
	*  3. For females further decrease by 10% all
	*    QRSdur and QRSamp criteria.
	*    (clarification: this is 10% of the original value, 
	*     not 10% of the value after the adjustment in #2.)
	*   @param key - the key string of the criteria in the Map mapThreshold()
	*   @param XXFactor -  factor by which to increase the criteria value e.g. +0.1 = 10% increase (adjusts for being female)
	*/
	private void adjustDurCriteria(String key, double XXFactor){
		double value = mapThreshold.get(key);
		
		mapThreshold.put(key, (value - (XXFactor * value)) ); 
	}
	
	/** Run all the calculations without notches No_Confounder.
	 * set all the public sub-totals, and final result. 
	 * @return QRS_score;
	 */
	public int calculateQRS_score_No_Confounder(){
		CalculateRatios();
		points_I = calcLead_I();
		points_II=calcLead_II();
		points_aVL=calcLead_aVL();
		points_aVF=calcLead_aVF();
		points_V1ant=calcLead_V1ant();
		points_V1post=calcLead_V1post();
		points_V2ant=calcLead_V2ant();
		points_V2post=calcLead_V2post();
		points_V3=calcLead_V3();
		points_V4=calcLead_V4();
		points_V5=calcLead_V5();
		points_V6=calcLead_V6();
		//--------------------
		QRS_Score=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6;  //=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6

		debugPrintValues();
		return QRS_Score;
	}

	/** Run all the calculations WITH notches.
	 * set all the public sub-totals, and final result. 
	 * @return QRS_score;
	 */
	public int calculateQRS_score_LVH_Kors(){
		CalculateRatios();
		points_I = calcLead_I();
		points_II=calcLead_II();
		points_aVL=calcLead_aVL();
		points_aVF=calcLead_aVF();
		points_V1ant=calcLead_V1ant_notch();
		points_V1post=calcLead_V1post();
		points_V2ant=calcLead_V2ant_notch();
		points_V2post=calcLead_V2post();
		points_V3=calcLead_V3_notch();
		points_V4=calcLead_V4();
		points_V5=calcLead_V5();
		points_V6=calcLead_V6();
		//--------------------
		QRS_Score=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6;  //=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6

		debugPrintValues();
		return QRS_Score;
	}

	/** Run all the calculations for RBBB + LAFB.
	 * set all the public sub-totals, and final result. 
	 * @return QRS_score;
	 */
	public int calculateQRS_score_LAFB_RBBB(){
		CalculateRatios();
		points_I = calcLead_I();
		points_II=calcLead_II();
		points_aVL=calcLead_aVL();
		points_aVF=calcLead_aVF();
		points_V1ant=calcLead_V1ant_RBBB_LAFB();
		points_V1post=calcLead_V1post_RBBB();
		points_V2ant=calcLead_V2ant_RBBB();
		points_V2post=calcLead_V2post_RBBB();
		points_V3=calcLead_V3();
		points_V4=calcLead_V4();
		points_V5=calcLead_V5();
		points_V6=calcLead_V6();
		//--------------------
		QRS_Score=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6;  //=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6

		debugPrintValues();
		return QRS_Score;
	}

	/** Run all the calculations LAFB.
	 * set all the public sub-totals, and final result. 
	 * @return QRS_score;
	 */
	public int calculateQRS_score_LAFB(){
		CalculateRatios();
		points_I = calcLead_I();
		points_II=calcLead_II();
		points_aVL=calcLead_aVL();
		points_aVF=calcLead_aVF();
		
		points_V1ant=calcLead_V1ant_LAFB();
		points_V1post=calcLead_V1post();
		points_V2ant=calcLead_V2ant_LAFB();
		points_V2post=calcLead_V2post();
		points_V3=calcLead_V3();
		points_V4=calcLead_V4();
		points_V5=calcLead_V5();
		points_V6=calcLead_V6();
		//--------------------
		QRS_Score=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6;  //=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6

		debugPrintValues();
		return QRS_Score;
	}

	/** Run all the calculations for LBBB.
	 * set all the public sub-totals, and final result. 
	 * @return QRS_score;
	 */
	public int calculateQRS_score_LBBB(){
		CalculateRatios();
		points_I = calcLead_I_LBBB();
		points_II= calcLead_II_LBBB();
//		points_I = calcLead_I();
//		points_II= calcLead_II();
		points_aVL=calcLead_aVL_LBBB();
		points_aVF=calcLead_aVF_LBBB();
		points_V1ant=calcLead_V1ant_LBBB();
		points_V1post= 0;
		points_V2ant=calcLead_V2ant_LBBB();
		points_V2post=0;
		points_V3=0;
		points_V4=0;
		points_V5=calcLead_V5_LBBB();
		points_V6=calcLead_V6_LBBB();

		//--------------------
		QRS_Score=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6;  //=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6

		debugPrintValues();
		return QRS_Score;
	}


	/** Run all the calculations for RBBB.
	 * set all the public sub-totals, and final result. 
	 * @return QRS_score;
	 */
	public int calculateQRS_score_RBBB(){
		CalculateRatios();
		points_I = calcLead_I();
		points_II=calcLead_II();
		points_aVL=calcLead_aVL();
		points_aVF=calcLead_aVF();
		points_V1ant=calcLead_V1ant_RBBB();
		points_V1post=calcLead_V1post_RBBB();
		points_V2ant=calcLead_V2ant_RBBB();
		points_V2post=calcLead_V2post_RBBB();
		points_V3=calcLead_V3();
		points_V4=calcLead_V4();
		points_V5=calcLead_V5();
		points_V6=calcLead_V6();
		//--------------------
		QRS_Score=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6;  //=points_I+points_II+points_aVL+points_aVF+points_V1ant+points_V1post+points_V2ant+points_V2post+points_V3+points_V4+points_V5+points_V6

		debugPrintValues();
		return QRS_Score;
	}

	private int calcLead_I(){
		// CS -------------------- CT
		Qpts_I = (qd_I >= mapThreshold.get("qd_I")) ? 1: 0;  //  =IF(qd_I>=30,1,0)
		
		RATpts_I = ((RQra_I <= mapThreshold.get("RQra_I")) || (ra_I <= mapThreshold.get("ra_I"))) ? 1: 0;  //  =IF(OR(RQra_I<=1,ra_I<=200),1,0)
		points_I=Qpts_I+RATpts_I;  //  =Qpts_I+RATpts_I
		
		return points_I;
	}

	private int calcLead_I_LBBB(){
		Qpts_I = (qd_I > mapThreshold.get("qd_I")  || (ra_I <= mapThreshold.get("ra_I"))) ? 1: 0;  //  =IF(qd_I>0,1,0)

		// =IF(OR(RSra_I<=1,RQra_I<=1),2,IF(OR(RSra_I<=1.5,RQra_I<=1.5),1,0))
		if((RSra_I <= mapThreshold.get("RSra_I lower")) || (RQra_I <= mapThreshold.get("RQra_I"))){ // OR(RSra_I<=1,RQra_I<=1),2 // re-using "RQra_I" for "RQra_I lower"
			RATpts_I = 2;
		}else{
			// IF(OR(RSra_I<=1.5,RQra_I<=1.5),1,0)
			RATpts_I = ((RSra_I <= mapThreshold.get("RSra_I upper")) || (RQra_I  <= mapThreshold.get("RQra_I upper")))? 1: 0; 
		}
		
		points_I=Qpts_I+RATpts_I;  //  =Qpts_I+RATpts_I		.
		
		return points_I;
	}
	

	private int calcLead_II(){
		RATpts_II=0;

		// CV -------------------- CW
		//Qpts_II;  //  =IF(qd_II>=40,2,IF(qd_II>=30,1,0))
		if(qd_II >= mapThreshold.get("qd_II upper")){
			Qpts_II = 2;
		}else{
			Qpts_II = (qd_II >= mapThreshold.get("qd_II lower"))? 1: 0;
		}
		points_II=Qpts_II;  //  =Qpts_II
		return points_II;
	}

	
	private int calcLead_II_LBBB(){
		// CV -------------------- CW
		//Qpts_II;  //  =IF(qd_II>=40,2,IF(qd_II>=30,1,0))
		Qpts_II = calcLead_II();
		
		if((RSra_II <= mapThreshold.get("RSra_II")) || (RQra_II <= mapThreshold.get("RQra_II"))){ // R/Q <= 0.5  OR R/S <= 0.5
			RATpts_II = 1;
		}		
		
		points_II=Qpts_II + RATpts_II;  //  =Qpts_II
		return points_II;
	}
	
	private int calcLead_aVL(){
		//-------------------- CY
		Qpts_aVL = (qd_aVL >= mapThreshold.get("qd_aVL")) ? 1: 0;  //  =IF(qd_aVL>=30,1,0)
		RATpts_aVL = (RQra_aVL <= mapThreshold.get("RQra_aVL")) ? 1: 0;  //  =IF(RQra_aVL<=1,1,0)
		points_aVL=Qpts_aVL+RATpts_aVL;  //  =Qpts_aVL+RATpts_aVL		
		return points_aVL;
	}

	private int calcLead_aVL_LBBB(){
		//-------------------- CY
		Qpts_aVL = (qd_aVL >= 40) ? 1: 0; 
		Qpts_aVL +=(qd_aVL >= 50) ? 1: 0;  
		
		RATpts_aVL = ( (RQra_aVL <= 0.5) ||  (RQra_aVL <= 0.5) ) ? 1: 0;  //  
		RATpts_aVL +=( (RQra_aVL <= 1.0) ||  (RQra_aVL <= 1.0) ) ? 1: 0;  //  
		
		points_aVL=Qpts_aVL+RATpts_aVL;  //  =Qpts_aVL+RATpts_aVL		
		return points_aVL;
	}


	private int calcLead_aVF(){
		//-------------------- DB
		if(qd_aVF >= mapThreshold.get("qd_aVF upper")){
			Qpts_aVF= 3;
		}else{
			if(qd_aVF >= mapThreshold.get("qd_aVF middle")){
				Qpts_aVF= 2;
			}else{
				Qpts_aVF = (qd_aVF >= mapThreshold.get("qd_aVF lower"))? 1: 0;
			}
		}
		// RATpts_aVF;  //  =IF(RQra_aVF<=1,2,IF(RQra_aVF<=2,1,0))
		if(RQra_aVF <= mapThreshold.get("RQra_aVF lower")){
			RATpts_aVF= 2;
		}else{
//			RATpts_aVF = (RQra_aVF <= threshold[11])? 1: 0;
			RATpts_aVF = (RQra_aVF <= mapThreshold.get("RQra_aVF upper"))? 1: 0;
		}
		points_aVF =Qpts_aVF+RATpts_aVF;  //  =Qpts_aVF+RATpts_aVF
		return points_aVF;
	}

	private int calcLead_aVF_LBBB(){
		//-------------------- DB
		//Qpts_aVF;   // =IF(qd_aVF>=50,2,IF(qd_aVF>=40,1,0))
		if(qd_aVF >= mapThreshold.get("qd_aVF upper")){
			Qpts_aVF= 2;
		}else{
			Qpts_aVF = (qd_aVF >= mapThreshold.get("qd_aVF middle"))? 1: 0;
		}
				
		RATpts_aVF = ( (RQra_aVF <= mapThreshold.get("RQra_aVF upper")) || (RSra_aVF <= mapThreshold.get("RSra_aVF upper")) )? 1: 0;
		
		points_aVF =Qpts_aVF+RATpts_aVF;  //  =Qpts_aVF+RATpts_aVF
		return points_aVF;
	}


	private int calcLead_V1ant(){
		//-------------------- DE
		Qpts_V1 = (qd_V1 > mapThreshold.get("qd_V1ant")) ? 1: 0;  //  =IF(qd_V1>0,1,0)
		points_V1ant=Qpts_V1;  //  =Qpts_V1
		return points_V1ant;
	}

	/** Used for VLH conduction type only. */
	private int calcLead_V1ant_notch(){
		//TODO: implement .04R notch = notch in initial 40 ms (of R), no math currently available to evaluate this.
		//TODO: implement Additional rule * (for LVH) if >= anterior/apical QRS points present (other then QS), then count QS in V1-V3.
		//-------------------- 
		Qpts_V1 = ((qd_V1 > mapThreshold.get("qd_V1ant")) && (rd_V1 > mapThreshold.get("rd_V1ant"))) ? 1: 0; // =IF(AND(qd_V1>0,rd_V1>0),1,0)
		points_V1ant=Qpts_V1;  //  =Qpts_V1
		return points_V1ant;
	}
	

	/** Used for "RBBB + LAFB" conduction type only. */
	private int calcLead_V1ant_RBBB_LAFB(){
		//-------------------- DJ
//		Qpts_V1 = //  =IF(qd_V1>=50,2,IF(qd_V1>0,1,0))
		if(qd_V1 >= mapThreshold.get("qd_V1ant")){
			Qpts_V1 = 2;
		}else{
			Qpts_V1 = (qd_V1 > mapThreshold.get("qd_V1ant")) ? 1: 0;  //  =IF(qd_V1>0,1,0)			
		}
		points_V1ant=Qpts_V1;  //  =Qpts_V1
		return points_V1ant;
	}

	/** Used for "LAFB" conduction type only. */
	private int calcLead_V1ant_LAFB(){
		Qpts_V1 = ((qd_V1 > mapThreshold.get("qd_V1ant")) && (rd_V1 > mapThreshold.get("rd_V1ant"))) ? 1: 0; // =IF(AND(qd_V1>0,rd_V1>0),1,0)
		points_V1ant=Qpts_V1;  //  =Qpts_V1
		return points_V1ant;
	}
	
	
	/** Used for "RBBB" conduction type only. */
	private int calcLead_V1ant_RBBB(){
		//Qpts_V1 = //was:   =IF(qd_V1>=50,2,IF(qd_V2>0,1,0))
		// should have been: =IF(qd_V1>=50,2,IF((AND (qd_V1>0,rd_V1<=20)),1,0))

		if(qd_V1 >= mapThreshold.get("qd_V1ant")){
			Qpts_V1 = 2;
		}else{
			Qpts_V1 = ((qd_V1 > mapThreshold.get("qd_V1ant")) && (rd_V1 <= mapThreshold.get("rd_V1ant"))) ? 1: 0;  // IF((AND (qd_V1>0,rd_V1<=20)),1,0)
		}
		points_V1ant=Qpts_V1;  //  =Qpts_V1
		return points_V1ant;
	}
	
	/** Used for "LBBB" conduction type only. */
	private int calcLead_V1ant_LBBB(){
		//TODO: implement Additional Rule ** Exclude anterosuperior points if right axis deviation is present )mean QRS axis >=90 degrees
		Qpts_V1 = 0;
		
		if( (rd_V1 <= mapThreshold.get("rd_V1 lower")) || (ra_V1 <= mapThreshold.get("ra_V1 lower")) ){
			Qpts_V1 += 1;
		}
		if( (rd_V1 <= mapThreshold.get("rd_V1 upper")) || (ra_V1 <= mapThreshold.get("ra_V1 upper")) ){
			Qpts_V1 += 1;
		}

		
		points_V1ant=Qpts_V1;  //  =Qpts_V1
		return points_V1ant;
	}
	

	private int calcLead_V1post(){
		//-------------------- DG
		//TODO: implement Additional rule ** (for all): (for posterolateral critera) exclude if right atrial overload present (suggesting RVH) if P positive amplitude in V1 or V2 P>=0.1 mV or aVF P>=0.175 mV.
		RATpts_V1 = (RSra_V1 >= mapThreshold.get("RSra_V1")) ? 1: 0;  //  =IF(RSra_V1>=1,1,0)
		//Rpts_V1;  //  =IF(OR(rd_V1>=50,ra_V1>=1000),2,IF(OR(rd_V1>=40,ra_V1>=700),1,0))
		if((rd_V1 >= mapThreshold.get("rd_V1 upper")) || (ra_V1 >= mapThreshold.get("ra_V1 upper"))){
			Rpts_V1= 2;
		}else{
			Rpts_V1 = ((rd_V1 >= mapThreshold.get("rd_V1 lower")) || (ra_V1 >= mapThreshold.get("ra_V1 lower")))? 1: 0;
		}
		QSpts_V1 = ((qa_V1 <= mapThreshold.get("qa_V1")) && (sa_V1 <= mapThreshold.get("sa_V1"))) ? 1: 0;  //  =IF(AND(qa_V1<=200,sa_V1<=200),1,0)
		points_V1post = RATpts_V1+Rpts_V1+QSpts_V1;  //  =RATpts_V1+Rpts_V1+QSpts_V1
		return points_V1post;
	}
	
	/** Used for "RBBB" and "RBBB + LAFB" conduction types only. */
	private int calcLead_V1post_RBBB(){
//		//-------------------- DG
//		//TODO: implement Additional rule ** (for all): (for posterolateral critera) exclude if right atrial overload present (suggesting RVH) if P positive amplitude in V1 or V2 P>=0.1 mV or aVF P>=0.175 mV.
		
		Rpts_V1 = 0;// Per David Strauss Aug 19, 2010: "In the presence of RBBB or RBBB+LAFB the posterior points are not included in this simplified version of QRS scoring because the Magellan program does not distinguish the �Initial R� that is required."
		points_V1post = Rpts_V1;  //  =Rpts_V1
		return points_V1post;
	}
		
	private int calcLead_V2ant(){
		//-------------------- DK
		QorRpts_V2 = ((qd_V2 > mapThreshold.get("qd_V2ant lower")) || (rd_V2 <= mapThreshold.get("rd_V2 lower")) || (ra_V2 <= mapThreshold.get("ra_V2 lower"))) ? 1: 0;  //  =IF(OR(qd_V2>0,rd_V2<=10,ra_V2<=100),1,0)
		points_V2ant=QorRpts_V2;  //  =QorRpts_V2
		return points_V2ant;
	}
	
	/** Used for VLH conduction type only.	 */
	private int calcLead_V2ant_notch(){
		//TODO: implement .04R notch = notch in initial 40 ms (of R), no math currently available to evaluate this.
		//TODO: implement Additional rule * (for LVH) if >= anterior/apical QRS points present (other then QS), then count QS in V1-V3.
		//-------------------- 
		Qpts_V1 = ((qd_V2 > mapThreshold.get("qd_V2ant lower")) && (rd_V2 > mapThreshold.get("rd_V2 lower"))) ? 1: 0; // =IF(AND(qd_V2>0,rd_V2>0),1,0)
		points_V1ant=Qpts_V1;  //  =Qpts_V1
		return points_V1ant;
	}

	private int calcLead_V2ant_RBBB(){
		//-------------------- DK
		//  =IF(qd_V2>=50,2,IF(OR(qd_V2>0,rd_V2<=10,ra_V2<=100),1,0))
		if(qd_V2  >= mapThreshold.get("qd_V2ant upper")){
			QorRpts_V2 = 2;
		}else{
			QorRpts_V2 = ((qd_V2 > mapThreshold.get("qd_V2ant lower")) || (rd_V2 <= mapThreshold.get("rd_V2 lower")) || (ra_V2 <= mapThreshold.get("ra_V2 lower"))) ? 1: 0;  //  =IF(OR(qd_V2>0,rd_V2<=10,ra_V2<=100),1,0)
		}
		points_V2ant=QorRpts_V2;  //  =QorRpts_V2
		return points_V2ant;
	}
	
	
	private int calcLead_V2ant_LAFB(){
		//-------------------- DK
		// 	=IF(OR( AND(qd_V2>0,rd_V2>0),   rd_V2<=10,ra_V2<=100)  ,1,0)
		QorRpts_V2 = ( 
				( (qd_V2>mapThreshold.get("qd_V2ant lower")) && (rd_V2>mapThreshold.get("rd_V2 lower")) ) 
				|| (rd_V2 <= mapThreshold.get("rd_V2 lower"))
				|| (ra_V2 <= mapThreshold.get("ra_V2 lower"))
				) ? 1: 0; 
		points_V2ant=QorRpts_V2;  //  =QorRpts_V2
		return points_V2ant;
	}
	
	/** Used for "LBBB" conduction type only. */
	private int calcLead_V2ant_LBBB(){
		//TODO: implement Additional Rule ** Exclude anterosuperior points if right axis deviation is present )mean QRS axis >=90 degrees
		int Qpts_V2 = 0;

		
		if( (rd_V2 <= mapThreshold.get("rd_V2 lower")) || (ra_V2 <= mapThreshold.get("ra_V2 lower")) ){
			Qpts_V2 += 1;
		}
		if( (rd_V2 <= mapThreshold.get("rd_V2 upper")) || (ra_V2 <= mapThreshold.get("ra_V2 upper")) ){
			Qpts_V2 += 1;
		}

		
		points_V2ant=Qpts_V2; 
		return points_V2ant;
	}

	private int calcLead_V2post(){
		//-------------------- DM
		//TODO: implement Additional rule ** (for all): (for posterolateral critera) exclude if right atrial overload present (suggesting RVH) if P positive amplitude in V1 or V2 P>=0.1 mV or aVF P>=0.175 mV.
		RATpts_V2 = (Rsra_V2 >= mapThreshold.get("Rsra_V2")) ? 1: 0;  //  =IF(Rsra_V2>=1.5,1,0)
		//Rpts_V2;  //  =IF(OR(rd_V2>=60,ra_V2>=2000),2,IF(OR(rd_V2>=50,ra_V2>=1500),1,0))
		if((rd_V2 >= mapThreshold.get("rd_V2 upper")) || (ra_V2 >= mapThreshold.get("ra_V2 upper"))){
			Rpts_V2= 2;
		}else{
			Rpts_V2 = ((rd_V2 >= mapThreshold.get("rd_V2 middle")) || (ra_V2 >= mapThreshold.get("ra_V2 middle")))? 1: 0;
		}
		QSpts_V2 = ((qa_V2 <= mapThreshold.get("qa_V2")) && (sa_V2 <= mapThreshold.get("sa_V2"))) ? 1: 0;  //  =IF(AND(qa_V2<=300,sa_V2<=300),1,0)
		points_V2post=RATpts_V2+Rpts_V2+QSpts_V2;  //  =RATpts_V2+Rpts_V2+QSpts_V2

		return points_V2post;
	}
	
	private int calcLead_V2post_RBBB(){
		//-------------------- DM
		//TODO: implement Additional rule ** (for all): (for posterolateral critera) exclude if right atrial overload present (suggesting RVH) if P positive amplitude in V1 or V2 P>=0.1 mV or aVF P>=0.175 mV.
		//Rpts_V2;  //  =IF(OR(rd_V2>=60,ra_V2>=2000),2,IF(OR(rd_V2>=50,ra_V2>=1500),1,0))
		if((rd_V2 >= mapThreshold.get("rd_V2 upper")) || (ra_V2 >= mapThreshold.get("ra_V2 upper"))){
			Rpts_V2= 2;
		}else{
			Rpts_V2 = ((rd_V2 >= mapThreshold.get("rd_V2 middle")) || (ra_V2 >= mapThreshold.get("ra_V2 middle")))? 1: 0;
		}
		points_V2post=Rpts_V2;  //  =Rpts_V2

		return points_V2post;
	}
	
	
	private int calcLead_V3(){
		//-------------------- DQ
		//QorRpts_V3;  //  =IF(OR(qd_V3>=30,rd_V3<=10),2,IF(OR(qd_V3>=20,rd_V3<=20),1,0))
		if((qd_V3 >= mapThreshold.get("qd_V3 upper")) || (rd_V3 <= mapThreshold.get("rd_V3 lower"))){
			QorRpts_V3= 2;
		}else{
			QorRpts_V3 = ((qd_V3 >= mapThreshold.get("qd_V3 lower")) || (rd_V3 <= mapThreshold.get("rd_V3 upper")))? 1: 0;
		}
		points_V3 = QorRpts_V3;  //  =QorRpts_V3
		return points_V3;
	}
	


	/** Used for VLH conduction type only. */
	private int calcLead_V3_notch(){
		//-------------------- DQ
		//TODO: implement .04R notch = notch in initial 40 ms (of R), no math currently available to evaluate this.
		//TODO: implement Additional rule * (for LVH) if >= anterior/apical QRS points present (other then QS), then count QS in V1-V3.
		//QorRpts_V3;  //  =IF(AND(qd_V3>30,rd_V3>0),2,IF(AND(qd_V3>0,rd_V3>0),1,0))
		if((qd_V3 > mapThreshold.get("qd_V3 upper")) && (rd_V3 > mapThreshold.get("rd_V3 lower"))){
			QorRpts_V3= 2;
		}else{
			QorRpts_V3 = ((qd_V3 > mapThreshold.get("qd_V3 lower")) && (rd_V3 > mapThreshold.get("rd_V3 lower")))? 1: 0; // "rd_V3 lower" not used.
		}
		points_V3 = QorRpts_V3;  //  =QorRpts_V3
		return points_V3;
	}
	
	
	private int calcLead_V4(){
		//--------------------
		Qpts_V4 = (qd_V4 >= mapThreshold.get("qd_V4")) ? 1: 0;  //  =IF(qd_V4>=20,1,0)
		// Rpts_V4;  //  =IF(OR(RQra_V4<=0.5,RSra_V4<=0.5),2,IF(OR(RQra_V4<=1,RSra_V4<=1,ra_V4<=500),1,0))
		//TODO: implement .04R notch = notch in initial 40 ms (of R), no math currently available to evaluate this.
		if((RQra_V4 <= mapThreshold.get("RQra_V4 lower")) || (RSra_V4 <= mapThreshold.get("RSra_V4 lower"))){ //IF(OR(RQra_V4<=0.5,RSra_V4<=0.5)
			Rpts_V4= 2;
		}else{
			Rpts_V4 = ((RQra_V4 <= mapThreshold.get("RQra_V4 upper")) || (RSra_V4 <= mapThreshold.get("RSra_V4 upper")) || (ra_V4 <= mapThreshold.get("ra_V4")))? 1: 0; //IF(OR(RQra_V4<=1,RSra_V4<=1,ra_V4<=500)
		}
		points_V4 =Qpts_V4+Rpts_V4;  //  =Qpts_V4+Rpts_V4

		return points_V4;
	}

	private int calcLead_V5(){
		//--------------------
		Qpts_V5 = (qd_V5 >= mapThreshold.get("qd_V5")) ? 1: 0;  //  =IF(qd_V5>=30,1,0)
		//Rpts_V5;  //  =IF(OR(RQra_V5<=1,RSra_V5<=1),2,IF(OR(RQra_V5<=2,RSra_V5<=2,ra_V5<=600),1,0))
		//TODO: implement .04R notch = notch in initial 40 ms (of R), no math currently available to evaluate this.
		if((RQra_V5 <= mapThreshold.get("RQra_V5 lower")) || (RSra_V5 <= mapThreshold.get("RSra_V5 lower"))){
			Rpts_V5= 2;
		}else{
			Rpts_V5 = ((RQra_V5 <= mapThreshold.get("RQra_V5 upper")) || (RSra_V5 <= mapThreshold.get("RSra_V5 upper")) || (ra_V5 <= mapThreshold.get("ra_V5")))? 1: 0;
		}
		points_V5 =Qpts_V5+Rpts_V5;  // =Qpts_V5+Rpts_V5

		return points_V5;
	}

	private int calcLead_V5_LBBB(){
		//--------------------
		//TODO: implement .04R notch = notch in initial 40 ms (of R), no math currently available to evaluate this.
		Qpts_V5 = ( (qd_V5 > mapThreshold.get("qd_V5")) || (RSra_V5 <= mapThreshold.get("RSra_V5 lower")) ) ? 1: 0;  

		Rpts_V5 = (ra_V5 > mapThreshold.get("ra_V5")) ? 1: 0;
		
		points_V5 =Qpts_V5+Rpts_V5;  // =Qpts_V5+Rpts_V5

		return points_V5;
	}
	
	private int calcLead_V6(){
		//--------------------
		Qpts_V6 = (qd_V6 >= mapThreshold.get("qd_V6")) ? 1: 0;  //  =IF(qd_V6>=30,1,0)
		// Rpts_V6;  //  =IF(OR(RQra_V6<=1,RSra_V6<=1),2,IF(OR(RQra_V6<=3,RSra_V6<=3,ra_V6<=600),1,0))
		//TODO: implement .04R notch = notch in initial 40 ms (of R), no math currently available to evaluate this.
		if((RQra_V6 <= mapThreshold.get("RQra_V6 lower")) || (RSra_V6 <= mapThreshold.get("RSra_V6 lower"))){
			Rpts_V6= 2;
		}else{
			Rpts_V6 = ((RQra_V6 <= mapThreshold.get("RQra_V6 upper")) || (RSra_V6 <= mapThreshold.get("RSra_V6 upper")) || (ra_V6 <= mapThreshold.get("ra_V6")))? 1: 0;
		}
		points_V6=Qpts_V6+Rpts_V6;  //  =Qpts_V6+Rpts_V6

		return points_V6;
	}

	private int calcLead_V6_LBBB(){
		//--------------------
		//TODO: implement .04R notch = notch in initial 40 ms (of R), no math currently available to evaluate this.
		Qpts_V6 = ( (qd_V6 > mapThreshold.get("qd_V6")) || (RSra_V6 <= mapThreshold.get("RSra_V6 lower")) ) ? 1: 0;  

		Rpts_V6 = (ra_V6 > mapThreshold.get("ra_V6")) ? 1: 0;
		
		points_V6=Qpts_V6+Rpts_V6;  //  =Qpts_V6+Rpts_V6

		return points_V6;
	}
	
	/** Calculate Ratio used by many of the calculations.
	 * Check for and fix divide by zero by setting the values to ridiculously large (9999999) or zero, as appropriate. 
	 */
	private void CalculateRatios(){
		RQra_I = (qa_I==0) ?  9999999: Math.abs(ra_I/qa_I) ;  //  =IF(qa_I=0,"",ra_I/qa_I)
		RQra_aVL = (qa_aVL==0) ? 9999999: Math.abs(ra_aVL/qa_aVL);  //  =IF(qa_aVL=0,"",ra_aVL/qa_aVL)
		RQra_aVF  = (qa_aVF==0) ? 9999999: Math.abs(ra_aVF/qa_aVF);  //  =IF(qa_aVF=0,"",ra_aVF/qa_aVF)
		RQra_V4  = (qa_V4==0) ? 9999999: Math.abs(ra_V4/qa_V4);  //  =IF(qa_V4=0,"",ra_V4/qa_V4)
		RQra_V5  = (qa_V5==0) ? 9999999: Math.abs(ra_V5/qa_V5);  //  =IF(qa_V5=0,"",ra_V5/qa_V5)
		RQra_V6  = (qa_V6==0) ? 9999999: Math.abs(ra_V6/qa_V6);  //  =IF(qa_V6=0,"",ra_V6/qa_V6)
		
		RSra_V1  = (sa_V1==0) ? 0: Math.abs(ra_V1/sa_V1);  //  =IF(sa_V1=0,0,ra_V1/sa_V1)
		Rsra_V2  = (sa_V2==0) ? 0: Math.abs(ra_V2/sa_V2);  //  =IF(sa_V2=0,0,ra_V2/sa_V2)
		RSra_V4  = (sa_V4==0) ? 9999999: Math.abs(ra_V4/sa_V4);  //  =IF(sa_V4=0,"",ra_V4/sa_V4)
		RSra_V5  = (sa_V5==0) ? 9999999: Math.abs(ra_V5/sa_V5);  //  =IF(sa_V5=0,"",ra_V5/sa_V5)
		RSra_V6  = (sa_V6==0) ? 9999999: Math.abs(ra_V6/sa_V6);  //  =IF(sa_V6=0,"",ra_V6/sa_V6)
	}
	
	/** Counts the parameters which have an invalid value of zero and creates a "/" separated list of them.
	 * Creates separate lists and counts for Q,R,S and other parameters. **/
	private int CountMissingParameters(){
		int count = 0;
		badQParameterCount = 0;
		badRParameterCount = 0;
		badSParameterCount = 0;
		badOtherParameterCount = 0;
		
		missingQParamList = "";
		missingRParamList = "";
		missingSParamList = "";
		missingOtherParameterList = "";
		
		if(qa_I==0){ 
			missingQParamList += "qa_I/";
			badQParameterCount++;
		}
		if(qa_aVL==0) {  missingQParamList += "qa_aVL/";badQParameterCount++; }
		if(qa_aVF==0) {  missingQParamList += "qa_aVF/";badQParameterCount++; }
		if(qa_V1==0)  {  missingQParamList += "qa_V1/"; badQParameterCount++; }
		if(qa_V2==0)  {  missingQParamList += "qa_V2/"; badQParameterCount++; }
		if(qa_V3==0)  {  missingQParamList += "qa_V3/"; badQParameterCount++; }
		if(qa_V4==0)  {  missingQParamList += "qa_V4/"; badQParameterCount++; }
		if(qa_V5==0)  {  missingQParamList += "qa_V5/"; badQParameterCount++; }
		if(qa_V6==0)  {  missingQParamList += "qa_V6/"; badQParameterCount++; }
		if(qd_I==0)   {  missingQParamList += "qd_I/";  badQParameterCount++; }
		if(qd_II==0)  {  missingQParamList += "qd_II/"; badQParameterCount++; }
		if(qd_aVL==0) {  missingQParamList += "qd_aVL/";badQParameterCount++; }
		if(qd_aVF==0) {  missingQParamList += "qd_aVF/";badQParameterCount++; }
		if(qd_V1==0)  {  missingQParamList += "qd_V1/"; badQParameterCount++; }
		if(qd_V2==0)  {  missingQParamList += "qd_V2/"; badQParameterCount++; }
		if(qd_V3==0)  {  missingQParamList += "qd_V3/"; badQParameterCount++; }
		if(qd_V4==0)  {  missingQParamList += "qd_V4/"; badQParameterCount++; }
		if(qd_V5==0)  {  missingQParamList += "qd_V5/"; badQParameterCount++; }
		if(qd_V6==0)  {  missingQParamList += "qd_V6/"; badQParameterCount++; }
		if(ra_I==0)   {  missingRParamList += "ra_I/";  badRParameterCount++; }
		if(ra_aVL==0) {  missingRParamList += "ra_aVL/";badRParameterCount++; }
		if(ra_aVF==0) {  missingRParamList += "ra_aVF/";badRParameterCount++; }
		if(ra_V1==0)  {  missingRParamList += "ra_V1/"; badRParameterCount++; }
		if(ra_V2==0)  {  missingRParamList += "ra_V2/"; badRParameterCount++; }
		if(ra_V3==0)  {  missingRParamList += "ra_V3/"; badRParameterCount++; }
		if(ra_V4==0)  {  missingRParamList += "ra_V4/"; badRParameterCount++; }
		if(ra_V5==0)  {  missingRParamList += "ra_V5/"; badRParameterCount++; }
		if(ra_V6==0)  {  missingRParamList += "ra_V6/"; badRParameterCount++; }
		if(rd_V1==0)  {  missingRParamList += "rd_V1/"; badRParameterCount++; }
		if(rd_V2==0)  {  missingRParamList += "rd_V2/"; badRParameterCount++; }
		if(rd_V3==0)  {  missingRParamList += "rd_V3/"; badRParameterCount++; }
		if(sa_V1==0)  {  missingSParamList += "sa_V1/"; badSParameterCount++; }
		if(sa_V2==0)  {  missingSParamList += "sa_V2/"; badSParameterCount++; }
		if(sa_V3==0)  {  missingSParamList += "sa_V3/"; badSParameterCount++; }
		if(sa_V4==0)  {  missingSParamList += "sa_V4/"; badSParameterCount++; }
		if(sa_V5==0)  {  missingSParamList += "sa_V5/"; badSParameterCount++; }
		if(sa_V6==0)  {  missingSParamList += "sa_V6/"; badSParameterCount++; }

		count = badQParameterCount + badRParameterCount + badSParameterCount;

		return count;
	}
	
	private int CalculatePositiveErrorPoints(){
		int pos = 0;
		pos += (qd_I==0)   ? 1 : 0;
		pos += (qd_II==0)  ? 2 : 0;
		pos += (qd_aVL==0) ? 1 : 0;
		pos += (qd_aVF==0) ? 3 : 0;
		pos += (qd_V1==0)  ? 1 : 0;
		pos += (qd_V2==0)  ? 1 : 0;
		pos += (qd_V3==0)  ? 2 : 0;
		pos += (qd_V4==0)  ? 1 : 0;
		pos += (qd_V5==0)  ? 1 : 0;
		pos += (qd_V6==0)  ? 1 : 0;
		pos += (ra_I==0)   ? 1 : 0;
		pos += (ra_V1==0)  ? 2 : 0;
		pos += (ra_V2==0)  ? 1 : 0;
		pos += (ra_V3==0)  ? 1 : 0;
		pos += (ra_V4==0)  ? 1 : 0;
		pos += (ra_V5==0)  ? 1 : 0;
		pos += (ra_V6==0)  ? 1 : 0;
		pos += (rd_V1==0)  ? 1 : 0;
		pos += (rd_V2==0)  ? 1 : 0;
		pos += (rd_V3==0)  ? 2 : 0;
			
		return pos;
	}
	
	private int CalculateNegativeErrorPoints(){
		int neg = 0;
		neg += (qa_I==0)   ? -1 : 0;
		neg += (qa_aVL==0) ? -1 : 0;
		neg += (qa_aVF==0) ? -2 : 0;
		neg += (qa_V4==0)  ? -2 : 0;
		neg += (qa_V5==0)  ? -2 : 0;
		neg += (qa_V6==0)  ? -2 : 0;
		neg += (sa_V1==0)  ? -1 : 0;
		neg += (sa_V2==0)  ? -1 : 0;
		neg += (sa_V4==0)  ? -2 : 0;
		neg += (sa_V5==0)  ? -2 : 0;
		neg += (sa_V6==0)  ? -2 : 0;
			
		return neg;
	}
	
	private void debugPrintValues(){
		debugPrintln ("-------------------");
		debugPrintln ("RQra_I:" +  RQra_I);
		debugPrintln ("RQra_aVL:" +  RQra_aVL);
		debugPrintln ("RQra_aVF:" +  RQra_aVF);
		debugPrintln ("RQra_V4:" +  RQra_V4);
		debugPrintln ("RQra_V5:" +  RQra_V5);
		debugPrintln ("RQra_V6:" +  RQra_V6);
		debugPrintln ("RSra_V1:" +  RSra_V1);
		debugPrintln ("Rsra_V2:" +  Rsra_V2);
		debugPrintln ("RSra_V4:" +  RSra_V4);
		debugPrintln ("RSra_V5:" +  RSra_V5);
		debugPrintln ("RSra_V6:" +  RSra_V6);
		debugPrintln ("-------------------");		
		debugPrintln ("Qpts_I:" +  Qpts_I);
		debugPrintln ("RATpts_I:" +  RATpts_I);
		debugPrintln ("points_I:" +  points_I);
		debugPrintln ("-------------------");
		debugPrintln ("RATpts_II:" +  RATpts_II);
		debugPrintln ("Qpts_II:" +  Qpts_II);
		debugPrintln ("points_II:" +  points_II);
		debugPrintln ("-------------------");
		debugPrintln ("Qpts_aVL:" +  Qpts_aVL);
		debugPrintln ("RATpts_aVL:" +  RATpts_aVL);
		debugPrintln ("points_aVL:" +  points_aVL);
		debugPrintln ("-------------------");
		debugPrintln ("Qpts_aVF:" +  Qpts_aVF);
		debugPrintln ("RATpts_aVF:" +  RATpts_aVF);
		debugPrintln ("points_aVF:" +  points_aVF);
		debugPrintln ("-------------------");
		debugPrintln ("Qpts_V1:" +  Qpts_V1);
		debugPrintln ("points_V1ant:" +  points_V1ant);
		debugPrintln ("-------------------");
		debugPrintln ("RATpts_V1:" +  RATpts_V1);
		debugPrintln ("Rpts_V1:" +  Rpts_V1);
		debugPrintln ("QSpts_V1:" +  QSpts_V1);
		debugPrintln ("points_V1post:" +  points_V1post);
		debugPrintln ("-------------------");
		debugPrintln ("QorRpts_V2:" +  QorRpts_V2);
		debugPrintln ("points_V2ant:" +  points_V2ant);
		debugPrintln ("-------------------");
		debugPrintln ("RATpts_V2:" +  RATpts_V2);
		debugPrintln ("Rpts_V2:" +  Rpts_V2);
		debugPrintln ("QSpts_V2:" +  QSpts_V2);
		debugPrintln ("points_V2post:" +  points_V2post);
		debugPrintln ("-------------------");
		debugPrintln ("QorRpts_V3:" +  QorRpts_V3);
		debugPrintln ("points_V3:" +  points_V3);
		debugPrintln ("-------------------");
		debugPrintln ("Qpts_V4:" +  Qpts_V4);
		debugPrintln ("Rpts_V4:" +  Rpts_V4);
		debugPrintln ("points_V4:" +  points_V4);
		debugPrintln ("-------------------");
		debugPrintln ("Qpts_V5:" +  Qpts_V5);
		debugPrintln ("Rpts_V5:" +  Rpts_V5);
		debugPrintln ("points_V5:" +  points_V5);
		debugPrintln ("-------------------");
		debugPrintln ("Qpts_V6:" +  Qpts_V6);
		debugPrintln ("Rpts_V6:" +  Rpts_V6);
		debugPrintln ("points_V6:" +  points_V6);
		debugPrintln ("-------------------");
		debugPrintln ("========================================================================================================");
	}
	
	
	/** debug utility method, only prints if verbose is true.
	 * 
	 * @param out - String to be printed
	 */
	private void debugPrint(String out){
		if (verbose) System.out.print(out);
	}

	/** debug utility method, only println (with line end) if verbose is true.
	 * 
	 * @param out - String to be printed
	 */
	private void debugPrintln(String out){
		if (verbose) System.out.println(out);
	}
}
