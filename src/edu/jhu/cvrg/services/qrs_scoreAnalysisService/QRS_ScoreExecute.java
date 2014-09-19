package edu.jhu.cvrg.services.qrs_scoreAnalysisService;

import org.apache.log4j.Logger;

import edu.jhu.cvrg.services.qrs_scoreAnalysisService.wrapper.QRS_Score;
import edu.jhu.cvrg.services.qrs_scoreAnalysisService.wrapper.QRS_ScoreApplicationWrapper;
import edu.jhu.cvrg.waveform.service.ServiceUtils;


public class QRS_ScoreExecute extends Thread{
	
	public String errorMessage = "";
	
	private AnalysisVO analysis;
	private Logger log = Logger.getLogger(QRS_ScoreExecute.class);

	
	public QRS_ScoreExecute(AnalysisVO analysis) {
		this.analysis = analysis;
	}
	
	public QRS_ScoreExecute(ThreadGroup group, AnalysisVO analysis) {
		super(group, analysis.getUserId() + '|' + analysis.getSubjectId() + '|' + analysis.getAlgorithm().getName());
		
		this.analysis = analysis;
	}
	
	@Override
	public void run() {
		
		this.execute();
		
	}
	
	public void execute(){
	
		String[] asOutputFileHandles = null;
		//perform the analyze
		switch (analysis.getAlgorithm()) {
			case QRS_SCORE: 		asOutputFileHandles = this.executeV2_qrs_score();    	break;
			default: 			break;
		}
		
		analysis.setOutputFileNames(asOutputFileHandles);
	}
	

	/** This is the skeleton method which will be wrapped around the actual analysis algorithm's code or program call.
	 * It will be responsible for reformatting the array of input filenames into the parameters required by the algorithm's code. 
	 * Then it will reformat(if necessary) the return values as one or more output files and create a String array for the output.
	 * 
	 * @param inputFileNames - array of (absolute) input file path/name strings.
	 * @return  - array of (absolute) output file path/name strings or null if the analysis fails.
	 */
	private String[] executeV2_qrs_score(){
		debugPrintln("executeV2_qrs_score()");
		errorMessage = "executeV2_qrs_score() failed.";
		String[] asResultHandles=null;
		try {
			//*** The analysis algorithm should return a String array containing the full path/names of the result files.
			if(log.isDebugEnabled()){
				Object[] keys = analysis.getCommandParamMap().keySet().toArray();
				
				for(int i=0;i<keys.length;i++){
					debugPrintln("Key: \"" + (String)keys[i] + "\" Value: \"" + analysis.getCommandParamMap().get((String)keys[i]) + "\"");
				}
			}

			// WFDB files consist of a header file and one or more data files.
			// This function takes the header file as a parameter, and then uses it to look up the name(s) of the data file(s).
			String sHeaderPathName = AnalysisUtils.findHeaderPathName(analysis.getFileNames());
			String sHeaderPath = ServiceUtils.extractPath(sHeaderPathName);
			String sHeaderName = ServiceUtils.extractName(sHeaderPathName);
			
			debugPrintln("- sHeaderPathName: " + sHeaderPathName);
			debugPrintln("- sHeaderPath: " + sHeaderPath);
			debugPrintln("- sHeaderName: " + sHeaderName);
			
			//*** Insert the call to the analysis algorithm here:	
			QRS_ScoreApplicationWrapper appWrapper =  new QRS_ScoreApplicationWrapper(analysis.getJobIdNumber());

			debugPrintln("- Starting QRS_Score()");
			QRS_Score qrs = new QRS_Score();

			int missingQ = 0, missingR = 0, missingS = 0, missingOther = 0;
			String missingQList = "",missingRList = "",missingSList = "", missingOtherList = "";
			//---------------------------- Whole record parameters ---------------------------------
			if(analysis.getCommandParamMap().get("Name")!= null){  qrs.Name  = (String) analysis.getCommandParamMap().get("Name");	}else{missingOther++; missingOtherList += "Name/";} // Name
			if(analysis.getCommandParamMap().get("ID")  != null){  qrs.ID    = (String) analysis.getCommandParamMap().get("ID");	}else{missingOther++; missingOtherList += "ID/";} // ID
			if(analysis.getCommandParamMap().get("age") != null){  qrs.Age   = Float.parseFloat( (String) analysis.getCommandParamMap().get("age"));	}else{missingOther++; missingOtherList += "age/";} // age
			if(analysis.getCommandParamMap().get("sex") != null){ // options are "male", "female" or "Unknown"
				String sex = (String)  analysis.getCommandParamMap().get("sex");
				if(sex.equalsIgnoreCase("female")){
					qrs.Sex = 1;
				}else{
					qrs.Sex = 0; // default is male, so Unknown will be treated as male. 
				}
			}else{
				qrs.Sex = 0; // default is male, so Unknown will be treated as male. 
				missingOther++; // sex
				missingOtherList += "sex,";
			}
			 
			if(analysis.getCommandParamMap().get("ECG_000000072") != null){  qrs.qrsd   = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000072"));	}else{missingQ++; missingQList += "qrsd/";} // qrsd
			if(analysis.getCommandParamMap().get("ECG_000000838") != null){  qrs.qrsax  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000838"));	}else{missingQ++; missingQList += "qrsax/";} // qrsax

			//---------------------------- Q_Wave_Amplitude ----------------------------------------
			if(analysis.getCommandParamMap().get("ECG_000000652_0") != null){  qrs.qa_I   = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_0"));	}else{missingQ++; missingQList += "qa_I/";} // qa_I
			if(analysis.getCommandParamMap().get("ECG_000000652_4") != null){  qrs.qa_aVL = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_4"));	}else{missingQ++; missingQList += "qa_aVL/";} // qa_aVL
			if(analysis.getCommandParamMap().get("ECG_000000652_5") != null){  qrs.qa_aVF = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_5"));	}else{missingQ++; missingQList += "qa_aVF/";} // qa_aVF
			if(analysis.getCommandParamMap().get("ECG_000000652_6") != null){  qrs.qa_V1  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_6"));	}else{missingQ++; missingQList += "qa_V1/";} // qa_V1
			if(analysis.getCommandParamMap().get("ECG_000000652_7") != null){  qrs.qa_V2  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_7"));	}else{missingQ++; missingQList += "qa_V2/";} // qa_V2
			if(analysis.getCommandParamMap().get("ECG_000000652_8") != null){  qrs.qa_V3  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_8"));	}else{missingQ++; missingQList += "qa_V3/";} // qa_V3
			if(analysis.getCommandParamMap().get("ECG_000000652_9") != null){  qrs.qa_V4  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_9"));	}else{missingQ++; missingQList += "qa_V4/";} // qa_V4
			if(analysis.getCommandParamMap().get("ECG_000000652_10") != null){  qrs.qa_V5  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_10"));	}else{missingQ++; missingQList += "qa_V5/";} // qa_V5
			if(analysis.getCommandParamMap().get("ECG_000000652_11") != null){  qrs.qa_V6  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_11"));	}else{missingQ++; missingQList += "qa_V6/";} // qa_V6
			//---------------------------- Q_Wave_Duration -----------------------------------------
			if(analysis.getCommandParamMap().get("ECG_000000551_0") != null){  qrs.qd_I   = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000551_0"));	}else{missingQ++; missingQList += "qd_I/";} // qd_I
			if(analysis.getCommandParamMap().get("ECG_000000551_1") != null){  qrs.qd_II  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000551_1"));	}else{missingQ++; missingQList += "qd_II/";} // qd_II
			if(analysis.getCommandParamMap().get("ECG_000000551_4") != null){  qrs.qd_aVL = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000551_4"));	}else{missingQ++; missingQList += "qd_aVL/";} // qd_aVL
			if(analysis.getCommandParamMap().get("ECG_000000551_5") != null){  qrs.qd_aVF = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000551_5"));	}else{missingQ++; missingQList += "qd_aVF/";} // qd_aVF
			if(analysis.getCommandParamMap().get("ECG_000000551_6") != null){  qrs.qd_V1  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000551_6"));	}else{missingQ++; missingQList += "qd_V1/";} // qd_V1
			if(analysis.getCommandParamMap().get("ECG_000000551_7") != null){  qrs.qd_V2  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000551_7"));	}else{missingQ++; missingQList += "qd_V2/";} // qd_V2
			if(analysis.getCommandParamMap().get("ECG_000000551_8") != null){  qrs.qd_V3  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000551_8"));	}else{missingQ++; missingQList += "qd_V3/";} // qd_V3
			if(analysis.getCommandParamMap().get("ECG_000000551_9") != null){  qrs.qd_V4  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000551_9"));	}else{missingQ++; missingQList += "qd_V4/";} // qd_V4
			if(analysis.getCommandParamMap().get("ECG_000000551_10") != null){  qrs.qd_V5  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000551_10"));	}else{missingQ++; missingQList += "qd_V5/";} // qd_V5
			if(analysis.getCommandParamMap().get("ECG_000000551_11") != null){  qrs.qd_V6  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000551_11"));	}else{missingQ++; missingQList += "qd_V6/";} // qd_V6
			
			//---------------------------- R_Wave_Amplitude ----------------------------------------
			if(analysis.getCommandParamMap().get("ECG_000000750_0") != null){  qrs.ra_I   = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000750_0"));	}else{missingR++; missingRList += "ra_I/";} // ra_I
			if(analysis.getCommandParamMap().get("ECG_000000750_4") != null){  qrs.ra_aVL = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000750_4"));	}else{missingR++; missingRList += "ra_aVL/";} // ra_aVL
			if(analysis.getCommandParamMap().get("ECG_000000750_5") != null){  qrs.ra_aVF = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000750_5"));	}else{missingR++; missingRList += "ra_aVF/";} // ra_aVF
			if(analysis.getCommandParamMap().get("ECG_000000750_6") != null){  qrs.ra_V1  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000750_6"));	}else{missingR++; missingRList += "ra_V2/";} // ra_V1
			if(analysis.getCommandParamMap().get("ECG_000000750_7") != null){  qrs.ra_V2  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000750_7"));	}else{missingR++; missingRList += "ra_V2/";} // ra_V2
			if(analysis.getCommandParamMap().get("ECG_000000750_8") != null){  qrs.ra_V3  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000750_8"));	}else{missingR++; missingRList += "ra_V3/";} // ra_V3
			if(analysis.getCommandParamMap().get("ECG_000000750_9") != null){  qrs.ra_V4  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000750_9"));	}else{missingR++; missingRList += "ra_V4/";} // ra_V4
			if(analysis.getCommandParamMap().get("ECG_000000750_10") != null){  qrs.ra_V5  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000750_10"));	}else{missingR++; missingRList += "ra_V5/";} // ra_V5
			if(analysis.getCommandParamMap().get("ECG_000000750_11") != null){  qrs.ra_V6  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000750_11"));	}else{missingR++; missingRList += "ra_V6/";} // ra_V6
			//---------------------------- R_Wave_Duration -----------------------------------------
			if(analysis.getCommandParamMap().get("ECG_000000597_6") != null){  qrs.rd_V1  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000597_6"));	}else{missingR++; missingRList += "rd_V1/";} // rd_V1
			if(analysis.getCommandParamMap().get("ECG_000000597_7") != null){  qrs.rd_V2  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000597_7"));	}else{missingR++; missingRList += "rd_V2/";} // rd_V2
			if(analysis.getCommandParamMap().get("ECG_000000597_8") != null){  qrs.rd_V3  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000597_8"));	}else{missingR++; missingRList += "rd_V3/";} // rd_V3
			//---------------------------- S_Wave_Amplitude ----------------------------------------
			if(analysis.getCommandParamMap().get("ECG_000000652_6") != null){  qrs.sa_V1  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_6"));	}else{missingS++; missingSList += "sa_V1/";} // sa_V1
			if(analysis.getCommandParamMap().get("ECG_000000652_7") != null){  qrs.sa_V2  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_7"));	}else{missingS++; missingSList += "sa_V2/";} // sa_V2
			if(analysis.getCommandParamMap().get("ECG_000000652_8") != null){  qrs.sa_V3  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_8"));	}else{missingS++; missingSList += "sa_V3/";} // sa_V3
			if(analysis.getCommandParamMap().get("ECG_000000652_9") != null){  qrs.sa_V4  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_9"));	}else{missingS++; missingSList += "sa_V4/";} // sa_V4
			if(analysis.getCommandParamMap().get("ECG_000000652_10") != null){  qrs.sa_V5  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_10"));	}else{missingS++; missingSList += "sa_V5/";} // sa_V5
			if(analysis.getCommandParamMap().get("ECG_000000652_11") != null){  qrs.sa_V6  = Float.parseFloat( (String) analysis.getCommandParamMap().get("ECG_000000652_11"));	}else{missingS++; missingSList += "sa_V6";} // sa_V6

			boolean status = false;
			if( (missingQ+missingR+missingS+missingOther) > 5){
				errorMessage += " Missing " + (missingQ+missingR+missingS+missingOther) + " critical parameters.";
				debugPrintln(errorMessage);
			}else{
//				String conductionType = qrs.classifyConductionType();
//				int[] result = qrs.calculateQRS_score_Full();
//				String conductionTypeName = qrs.getConductionTypeName();
//				int[] scarPercentages = qrs.getPercentLVScarBySegment();
				status = appWrapper.straussSelvesterQRS_score(sHeaderName, sHeaderPath, qrs);
			}
			if( (missingQList.length()>0) || (missingRList.length()>0) || (missingSList.length()>0) || (missingOtherList.length()>0) ){
				debugPrintln("Missing Q parameter List: \"" + missingQList + "\"");
				debugPrintln("Missing R parameter List: \"" + missingRList + "\"");
				debugPrintln("Missing S parameter List: \"" + missingSList + "\"");
				debugPrintln("Missing \"Other\" parameter List: \"" + missingOtherList + "\"");
			}
			//*** If the analysis fails, this method should return a null.
			if(!status){
				asResultHandles = null;
				analysis.setErrorMessage(errorMessage);
			}else{
				//*** Reformat(if necessary) the return values as one or more output files.
				//*** Create a String array for the output.
				asResultHandles = appWrapper.getOutputFilenames();
			}
			analysis.setSucess(status);
		} catch (Exception e) {
			errorMessage = errorMessage + " " + e.getMessage();
			log.error(errorMessage);
			analysis.setErrorMessage(errorMessage);
		}		
		return asResultHandles;
	}

	
	private void debugPrintln(String text){
		System.out.println("-+ qrs_scoreAnalysisService.QRS_ScoreExecuter println :" + text);
		log.info("---  qrs_scoreAnalysisService.QRS_ScoreExecuter  info :" + text);
	}

}
