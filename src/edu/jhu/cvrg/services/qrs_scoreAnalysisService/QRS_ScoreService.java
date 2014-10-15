package edu.jhu.cvrg.services.qrs_scoreAnalysisService;

import org.apache.axiom.om.OMElement;
import org.apache.log4j.Logger;

import edu.jhu.cvrg.analysis.vo.AnalysisType;
import edu.jhu.cvrg.analysis.vo.AnalysisVO;
import edu.jhu.cvrg.analysis.wrapper.AnalysisWrapper;

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
		return callWrapper(param0, AnalysisType.QRS_SCORE);	
	}

	private OMElement callWrapper(org.apache.axiom.om.OMElement e, AnalysisType method) {
		debugPrintln(method.getOmeName() + "() started.");
		
		AnalysisUtils util = new AnalysisUtils();
		
		AnalysisVO analysis = util.parseInputParametersType2(e, method);          //(e, method);
		
		
		try {
			
			AnalysisWrapper algorithm = analysis.getType().getWrapper().getConstructor(AnalysisVO.class).newInstance(analysis);
			
			algorithm.defineInputParameters();
			algorithm.execute();
			
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
			
		return util.buildOmeReturnType2(analysis);
	}

	private void debugPrintln(String text){
		System.out.println("- QRS_ScoreService - " + text);
		log.info(text);
	}
}
