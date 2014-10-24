package edu.jhu.cvrg.services.qrs_scoreAnalysisService.wrapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.log4j.Logger;

import edu.jhu.cvrg.waveform.service.ApplicationWrapper;
import edu.jhu.cvrg.waveform.service.ServiceUtils;

public class QRS_ScoreApplicationWrapper  extends ApplicationWrapper{
	
	private static final String WORKING_DIR = "/";
	private String jobId;

	public QRS_ScoreApplicationWrapper() {
		log = Logger.getLogger(QRS_ScoreApplicationWrapper.class);
		this.jobId = "";
	}
	
	public QRS_ScoreApplicationWrapper(String identifier) {
		this();
		
		if(identifier != null){
			this.jobId = identifier;	
		}else{
			this.jobId = "";
		}
	}
	

	public boolean straussSelvesterQRS_score(String sHeaderFile, String sPath, QRS_Score qrs){
		boolean bRet = true;
		debugPrintln("straussSelvesterQRS_score()");
		debugPrintln("- sHeaderFile:" + sHeaderFile);
		debugPrintln("- sPath:" + sPath);
		try {
			int iIndexPeriod = sHeaderFile.lastIndexOf(".");
			String sRecord = sHeaderFile.substring(0, iIndexPeriod);

//			int[] result = qrs.calculateQRS_score_Full();
//			String conductionTypeName = qrs.getConductionTypeName();
//			int[] scarPercentages = qrs.getPercentLVScarBySegment();
//			int badParamCount = qrs.badParameterCount;
			int posError = qrs.positiveError;
			int negError = qrs.negativeError;

			BufferedWriter  writer = null;
			String fileName=sPath+sRecord+ "_qrs.csv";

			try {
			    writer = new BufferedWriter(new OutputStreamWriter(
			          new FileOutputStream(fileName), "utf-8"));

			    if(qrs.scode.size()==0){ 
			    	// no Marquette 12SL ECG analysis program statement codes found, so conduction type could not be determined
			    	// Therefore calculate all conductions types so that the researcher can choose the most appropriate.
			    	writer.write("LBBB_QRS_Score, RBBB+LAFB_QRS_Score, RBBB_QRS_Score, LAFB_QRS_Score, LVH_QRS_Score, No_confounders_QRS_Score, ");
			    	
				    writer.write("LBBB_Scar1, LBBB_Scar2, LBBB_Scar3, LBBB_Scar4, LBBB_Scar5, LBBB_Scar6, LBBB_Scar7, LBBB_Scar8, LBBB_Scar9, LBBB_Scar10, LBBB_Scar11, LBBB_Scar12,");
				    writer.write("LBBB_points_I, LBBB_points_II, LBBB_points_aVL, LBBB_points_aVF, LBBB_points_V1ant, LBBB_points_V1post, LBBB_points_V2ant, LBBB_points_V2post, LBBB_points_V3, LBBB_points_V4, LBBB_points_V5, LBBB_points_V6,");			    

				    writer.write("RBBB+LAFB_Scar1, RBBB+LAFB_Scar2, RBBB+LAFB_Scar3, RBBB+LAFB_Scar4, RBBB+LAFB_Scar5, RBBB+LAFB_Scar6, RBBB+LAFB_Scar7, RBBB+LAFB_Scar8, RBBB+LAFB_Scar9, RBBB+LAFB_Scar10, RBBB+LAFB_Scar11, RBBB+LAFB_Scar12,");
				    writer.write("RBBB+LAFB_points_I, RBBB+LAFB_points_II, RBBB+LAFB_points_aVL, RBBB+LAFB_points_aVF, RBBB+LAFB_points_V1ant, RBBB+LAFB_points_V1post, RBBB+LAFB_points_V2ant, RBBB+LAFB_points_V2post, RBBB+LAFB_points_V3, RBBB+LAFB_points_V4, RBBB+LAFB_points_V5, RBBB+LAFB_points_V6,");			    

				    writer.write("RBBB_Scar1, RBBB_Scar2, RBBB_Scar3, RBBB_Scar4, RBBB_Scar5, RBBB_Scar6, RBBB_Scar7, RBBB_Scar8, RBBB_Scar9, RBBB_Scar10, RBBB_Scar11, RBBB_Scar12,");
				    writer.write("RBBB_points_I, RBBB_points_II, RBBB_points_aVL, RBBB_points_aVF, RBBB_points_V1ant, RBBB_points_V1post, RBBB_points_V2ant, RBBB_points_V2post, RBBB_points_V3, RBBB_points_V4, RBBB_points_V5, RBBB_points_V6,");			    

				    writer.write("LAFB_Scar1, LAFB_Scar2, LAFB_Scar3, LAFB_Scar4, LAFB_Scar5, LAFB_Scar6, LAFB_Scar7, LAFB_Scar8, LAFB_Scar9, LAFB_Scar10, LAFB_Scar11, LAFB_Scar12,");
				    writer.write("LAFB_points_I, LAFB_points_II, LAFB_points_aVL, LAFB_points_aVF, LAFB_points_V1ant, LAFB_points_V1post, LAFB_points_V2ant, LAFB_points_V2post, LAFB_points_V3, LAFB_points_V4, LAFB_points_V5, LAFB_points_V6,");			    

				    writer.write("LVH_Scar1, LVH_Scar2, LVH_Scar3, LVH_Scar4, LVH_Scar5, LVH_Scar6, LVH_Scar7, LVH_Scar8, LVH_Scar9, LVH_Scar10, LVH_Scar11, LVH_Scar12,");
				    writer.write("LVH_points_I, LVH_points_II, LVH_points_aVL, LVH_points_aVF, LVH_points_V1ant, LVH_points_V1post, LVH_points_V2ant, LVH_points_V2post, LVH_points_V3, LVH_points_V4, LVH_points_V5, LVH_points_V6,");			    

				    writer.write("No_confounders_Scar1, No_confounders_Scar2, No_confounders_Scar3, No_confounders_Scar4, No_confounders_Scar5, No_confounders_Scar6, No_confounders_Scar7, No_confounders_Scar8, No_confounders_Scar9, No_confounders_Scar10, No_confounders_Scar11, No_confounders_Scar12,");
				    writer.write("No_confounders_points_I, No_confounders_points_II, No_confounders_points_aVL, No_confounders_points_aVF, No_confounders_points_V1ant, No_confounders_points_V1post, No_confounders_points_V2ant, No_confounders_points_V2post, No_confounders_points_V3, No_confounders_points_V4, No_confounders_points_V5, No_confounders_points_V6,");			    

				    
				    writer.write("Bad Q Parameter Count, Bad R Parameter Count, Bad S Parameter Count, Bad Q Parameter List, Bad R Parameter List, Bad S Parameter List, Positive Uncertainty, Negative Uncertainty");
				    writer.newLine();

				    StringBuffer QRSScoreBuff = new StringBuffer();
				    StringBuffer scarPointBuff = new StringBuffer();
				    
			    	for(int type = 2;type<=7;type++){
			    		int[] result = qrs.calculateQRS_score_Full(type);
						String conductionTypeName = qrs.getConductionTypeName();
						int[] scarPercentages = qrs.getPercentLVScarBySegment();
						
						QRSScoreBuff.append(result[12] + ","); // element 12 is QRS-Score
//						System.out.println(conductionTypeName + ": score = " + result[12]);
						//					    writer.write(conductionTypeName);
					    for(int sp:scarPercentages){
					    	scarPointBuff.append(sp + ",");
					    }
					    for(int point=0;point<12;point++){ // f0 through 11 are intermediate point calculations, element 12 is QRS-Score					    	
					    	scarPointBuff.append(result[point] + ",");
					    }
			    	}
			    	writer.write(QRSScoreBuff.toString());
			    	writer.write(scarPointBuff.toString());
				    writer.write(qrs.badQParameterCount + "," + qrs.badRParameterCount + "," + qrs.badSParameterCount + ",");
				    writer.write(qrs.missingQParamList + "," + qrs.missingRParamList + "," + qrs.missingSParamList + "," + qrs.positiveError + "," + qrs.negativeError);
				    writer.newLine();			    	
			    }else{
			    	// some Marquette 12SL ECG analysis program statement codes found, so conduction type is assumed to be amongst the codes.
					int[] result = qrs.calculateQRS_score_Full();
					String conductionTypeName = qrs.getConductionTypeName();
					int[] scarPercentages = qrs.getPercentLVScarBySegment();

				    writer.write("ConductionType, QRS_Score, ");
				    writer.write("Scar1, Scar2, Scar3, Scar4, Scar5, Scar6, Scar7, Scar8, Scar9, Scar10, Scar11, Scar12,");
				    writer.write("points_I, points_II, points_aVL, points_aVF, points_V1ant, points_V1post, points_V2ant, points_V2post, points_V3, points_V4, points_V5, points_V6,");			    
				    writer.write("Bad Q Parameter Count, Bad R Parameter Count, Bad S Parameter Count, Bad Q Parameter List, Bad R Parameter List, Bad S Parameter List, Positive Uncertainty, Negative Uncertainty");
				    writer.newLine();

				    writer.write(conductionTypeName + ",");
				    writer.write(result[12] + ","); // element 12 is QRS-Score
				    for(int sp:scarPercentages){
				    	writer.write(sp + ",");
				    }
				    for(int point=0;point<12;point++){ // f0 through 11 are intermediate point calculations, element 12 is QRS-Score					    	
				    	writer.write(result[point] + ",");
				    }

				    writer.write(qrs.badQParameterCount + "," + qrs.badRParameterCount + "," + qrs.badSParameterCount + ",");
				    writer.write(qrs.missingQParamList + "," + qrs.missingRParamList + "," + qrs.missingSParamList + "," + qrs.positiveError + "," + qrs.negativeError);
				    writer.newLine();
			    }
			    
			} catch (IOException ex) {
			  bRet = false;
			  debugPrintln(ex.getMessage());
			  ex.printStackTrace();
			} finally {
			   try {
				   writer.close();
			   }catch (Exception ex) {
				   bRet = false;
			   }
			}
			
			if(bRet){
//				stdReturnHandler();
				outputFilenames = new String[1];
				outputFilenames[0] = fileName;	
			}else{
				debugPrintln("- Encountered errors.");
			}
			
		} catch (Exception e) {
			bRet = false;
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.error(e.getMessage());
		}

		return bRet;
	}


	
	@Override
	protected void processReturnLine(String arg0) {
		// TODO Auto-generated method stub
	}
}
