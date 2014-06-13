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

			int[] result = qrs.calculateQRS_score_Full();
			String conductionTypeName = qrs.getConductionTypeName();
			int[] scarPercentages = qrs.getPercentLVScarBySegment();
			int badParamCount = qrs.badParameterCount;
			int posError = qrs.positiveError;
			int negError = qrs.negativeError;

			BufferedWriter  writer = null;
			String fileName=sPath+sRecord+ "_qrs.csv";

			try {
			    writer = new BufferedWriter(new OutputStreamWriter(
			          new FileOutputStream(fileName), "utf-8"));
			    writer.write("ConductionType,");
			    writer.write("Scar1, Scar2, Scar3, Scar4, Scar5, Scar6, Scar7, Scar8, Scar9, Scar10, Scar11, Scar12,");
			    writer.write("points_I, points_II, points_aVL, points_aVF, points_V1ant, points_V1post, points_V2ant, points_V2post, points_V3, points_V4, points_V5, points_V6, QRS_Score,");			    
			    writer.write("Bad Parameter Count, Positive Uncertainty, Negative Uncertainty, Bad Parameter List");
			    writer.newLine();

			    writer.write(conductionTypeName);
			    for(int sp:scarPercentages){
			    	writer.write( "," + sp);
			    }
			    for(int r:result){
			    	writer.write( "," + r);
			    }
			    writer.write("," + badParamCount + "," + posError + "," + negError + ",");
			    writer.write(qrs.missingParamList);
			    writer.newLine();

			    if(qrs.scode.size()==0){ 
			    	// no Marquette 12SL ECG analysis program statement codes found, so conduction type could not be determined
			    	// Therefore calculate all conductions types so that the researcher can choose the most appropriate.
			    	for(int type = 2;type<=6;type++){
			    		result = qrs.calculateQRS_score_Full(type);
						conductionTypeName = qrs.getConductionTypeName();
						scarPercentages = qrs.getPercentLVScarBySegment();
						
					    writer.write(conductionTypeName);
					    for(int sp:scarPercentages){
					    	writer.write( "," + sp);
					    }
					    for(int r:result){
					    	writer.write( "," + r);
					    }
					    writer.write(",unchanged,unchanged,unchanged,");
					    writer.write("unchanged");
					    writer.newLine();

			    	}
			    	
			    }
			    
			} catch (IOException ex) {
			  bRet = false;
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
			log.error(e.getMessage());
		}

		return bRet;
	}


	
	@Override
	protected void processReturnLine(String arg0) {
		// TODO Auto-generated method stub
	}
}
