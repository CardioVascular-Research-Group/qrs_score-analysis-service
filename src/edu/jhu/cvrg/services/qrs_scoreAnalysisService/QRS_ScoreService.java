package edu.jhu.cvrg.services.qrs_scoreAnalysisService;
//
//import java.util.Map;
//import java.util.Set;

import org.apache.axiom.om.OMElement;
//import org.apache.axiom.om.impl.llom.util.AXIOMUtil;
import org.apache.log4j.Logger;

//import com.thoughtworks.xstream.XStream;

//import edu.jhu.cvrg.dbapi.dto.PhysionetMethods;
//import edu.jhu.cvrg.services.qrs_scoreAnalysisService.serviceDescriptionData.AlgorithmServiceData;


/** A collection of methods for building a generic Web Service to wrap around an arbitrary analysis algorithm..
 * 
 * @author Michael Shipway - 3/29/2012
 *
 */
public class QRS_ScoreService {
	
	private Logger log = Logger.getLogger(getClass().getName());
	
	/** For testing of service.
	 * @return version and usage text.
	 * @throws Exception
	 */
	public String getVersion() throws Exception{
		return "Version: 0.1.0 (05/28/2014)";
	}

	/** Strauss/Selvester's QRS-Score function wrapped in the Generic Analysis Service.
	 * 
	 * @param param0 - contains the input parameters coded as XML.
	 * @return - Result files names coded as XML.
	 * @throws Exception 
	 */
	public org.apache.axiom.om.OMElement qrs_scoreWrapperType2(org.apache.axiom.om.OMElement param0) throws Exception {
		return callWrapper(param0, QRS_ScoreMethods.QRS_SCORE);	
	}

	private OMElement callWrapper(org.apache.axiom.om.OMElement e, QRS_ScoreMethods method) {
//		debugPrintln(method.getOmeName() + "() started.");
		
		AnalysisUtils util = new AnalysisUtils();
		
		AnalysisVO analysis = util.parseInputParametersType2(e, method);          //(e, method);
		
		QRS_ScoreExecute execute = new QRS_ScoreExecute(analysis);
		
		//************* Calls the wrapper of the analysis algorithm. *********************
		execute.execute();
		//************* Return value will be stored on AnalysisVO.    *********************
		
		return util.buildOmeReturnType2(analysis);
	}

//	public org.apache.axiom.om.OMElement performAnalysis(org.apache.axiom.om.OMElement e) throws Exception {
//		AnalysisUtils util = new AnalysisUtils();
//		
//		
//		Set<AnalysisVO> jobs = util.extractToAnalysisObject(e);
//		
//		ThreadGroup trdGroup = new ThreadGroup("Analysis Group");
//		
//		CleanerThread manager = new CleanerThread(trdGroup);
//		
//		for (AnalysisVO analysisVO : jobs) {
//			PhysionetExecute execute = new PhysionetExecute(trdGroup, analysisVO);
//			manager.addFiles(execute.getName(), analysisVO.getFileNames());
//			execute.start();
//		}
//		
//		manager.start();
//		
//		return util.buildAnalysisReturn("TEST", jobs, "performAnalysis");	
//	}
//	
	

	private void debugPrintln(String text){
		System.out.println("- QRS_ScoreService - " + text);
		log.info(text);
	}
}
