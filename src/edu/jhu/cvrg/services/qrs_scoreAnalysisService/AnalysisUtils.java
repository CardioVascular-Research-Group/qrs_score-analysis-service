package edu.jhu.cvrg.services.qrs_scoreAnalysisService;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.log4j.Logger;

import edu.jhu.cvrg.analysis.vo.AnalysisResultType;
import edu.jhu.cvrg.analysis.vo.AnalysisType;
import edu.jhu.cvrg.analysis.vo.AnalysisVO;
import edu.jhu.cvrg.waveform.service.ServiceProperties;
import edu.jhu.cvrg.waveform.service.ServiceUtils;
import edu.jhu.cvrg.waveform.utility.WebServiceUtility;


public class AnalysisUtils {

	String errorMessage="";
	/** uri parameter for OMNamespace.createOMNamespace() - the namespace URI; must not be null, <BR>e.g. http://www.cvrgrid.org/physionetAnalysisService/ **/
	private String sOMNameSpaceURI = "http://www.cvrgrid.org/physionetAnalysisService/";  
	
	/** prefix parameter for OMNamespace.createOMNamespace() - the prefix<BR>e.g. physionetAnalysisService **/
	private String sOMNameSpacePrefix =  "physionetAnalysisService";  
	public Map<String, Object> mapCommandParam = null;
	public List<String> inputFileNames = null;
	private long folderID;
	private long groupID;
	String userID;
	String subjectID;
	
	private static final Logger log = Logger.getLogger(AnalysisUtils.class);
	
	private String sep = File.separator;
	
	public AnalysisVO parseInputParametersType2(OMElement param0, AnalysisType algorithm){
		AnalysisVO ret = null;
		debugPrintln("parseInputParametersType2()");
		try {
			Map<String, OMElement> params = ServiceUtils.extractParams(param0);
			
			String jobID     	= params.get("jobID").getText() ;
			userID 		     	= params.get("userID").getText() ;
			folderID      		= Long.parseLong(params.get("folderID").getText()) ;
			groupID      		= Long.parseLong(params.get("groupID").getText()) ;
			subjectID 			= params.get("subjectID").getText() ;
			OMElement parameterlist = (OMElement) params.get("parameterlist");
			debugPrintln("****  parameterlist ****: " + parameterlist);
			
			String inputPath = ServiceUtils.SERVER_TEMP_ANALYSIS_FOLDER + sep + jobID;
			StringTokenizer strToken = new StringTokenizer(params.get("fileNames").getText(), "^");
			List<String> fileNames = new ArrayList<String>();
			while (strToken.hasMoreTokens()) {
				String name = strToken.nextToken();
				//ServiceUtils.createTempLocalFile(params, name, userID, inputPath, name);
				fileNames.add(inputPath + sep + name);
			}
			
			inputFileNames = fileNames;

			if(parameterlist != null){
				debugPrintln("Building Command Parameter map...;");
				mapCommandParam = buildParamMap(parameterlist);
			}else{
				debugPrintln("There are no parameters, so Command Parameter map was not built.");
				mapCommandParam = new HashMap<String, Object>(); 
			}
			
			ret = new AnalysisVO(jobID, algorithm, AnalysisResultType.ORIGINAL_FILE, inputFileNames, mapCommandParam);
			
		} catch (Exception e) {
			errorMessage = "parseInputParametersType2 failed.";
			debugPrintln("parseInputParametersType2() " + e.getMessage());
			log.error(errorMessage + " " + e.getMessage());
		}
		
		return ret;
	}
	
	/** Parses a service's incoming XML and builds a Map of all the parameters for easy access.
	 * @param param0 - OMElement representing XML with the incoming parameters.
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> buildParamMap(OMElement param0){
		debugPrintln("buildParamMap()");
	
		String key="";
		Object oValue = null;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		try {
			Iterator<OMElement> iterator = param0.getChildren();
			
			while(iterator.hasNext()) {
				OMElement param = iterator.next();
				key = param.getLocalName();
				oValue = param.getText();
				if(oValue.toString().length()>0){
					debugPrintln(" - Key/Value: " + key + " / '" + oValue + "'");
					paramMap.put(key,oValue);
				}else{
					Iterator<OMElement> iterTester = param.getChildren();
					if(iterTester.hasNext()){
						OMElement omValue = (OMElement)param;
						paramMap.put(key,param);
						debugPrintln(" - Key/OMElement Value: " + key + " / " + omValue.getText()); // param.getText());
					}else{
						debugPrintln(" - Key/Blank: " + key + " / '" + oValue + "'");
						paramMap.put(key,"");	
					}
				}

			}
		} catch (Exception e) {
			errorMessage = "buildParamMap() failed.";
			log.error(errorMessage + " " + e.getMessage());
			return null;
		}
		
		debugPrintln("buildParamMap() found " + paramMap.size() + " parameters.");
		return paramMap;
	}
	

	public OMElement buildOmeReturnType2(AnalysisVO analysis){
		OMElement omeReturn = null;
		try{
			OMFactory omFactory = OMAbstractFactory.getOMFactory(); 	 
			OMNamespace omNs = omFactory.createOMNamespace(sOMNameSpaceURI, sOMNameSpacePrefix); 	 

			omeReturn = omFactory.createOMElement(analysis.getType().getOmeName(), omNs); 
	
			// Converts the array of filenames to a single "^" delimited String for output.
			if (analysis.getErrorMessage() == null || analysis.getErrorMessage().length() == 0){
				ServiceUtils.addOMEChild("filecount", new Long(analysis.getOutputFileNames().size()).toString(),omeReturn,omFactory,omNs);
				omeReturn.addChild( ServiceUtils.makeOutputOMElement(analysis.getOutputFileNames(), "filenamelist", "filename", omFactory, omNs) );
				ServiceUtils.addOMEChild("jobID", analysis.getJobId(), omeReturn, omFactory, omNs);
				
				OMElement result = sendResultsBack(analysis);
				
				
				Map<String, OMElement> params = ServiceUtils.extractParams(result);
				
				omeReturn.addChild(params.get("fileList"));
			}else{
				if(analysis.getFileNames() != null && !analysis.getFileNames().isEmpty()){
					File tmpJobFolder = new File(ServiceUtils.extractPath(analysis.getFileNames().get(0)));
					for (File f : tmpJobFolder.listFiles()) {
						f.delete();
					}
					tmpJobFolder.delete();
				}
				
				ServiceUtils.addOMEChild("error",analysis.getErrorMessage(),omeReturn,omFactory,omNs);
			}
		} catch (Exception e) {
			errorMessage = "genericWrapperType2 failed.";
			log.error(errorMessage + " " + e.getMessage());
		}
		
		return omeReturn;
	}
	
	private OMElement sendResultsBack(AnalysisVO analysis) {
		
		Map<String, String> parameterMap = new HashMap<String, String>();
		
		parameterMap.put("jobID", analysis.getJobId());
		parameterMap.put("groupID", String.valueOf(this.groupID));
		parameterMap.put("folderID", String.valueOf(this.folderID));
		parameterMap.put("userID", this.userID);
		
		String fileNames = "";
		for (String name : analysis.getOutputFileNames()) {
			fileNames+=(name+'^');
		}
		parameterMap.put("resultFileNames", fileNames);
		
		ServiceProperties props = ServiceProperties.getInstance();
		
		return WebServiceUtility.callWebService(parameterMap, props.getProperty(ServiceProperties.DATATRANSFER_SERVICE_METHOD), props.getProperty(ServiceProperties.DATATRANSFER_SERVICE_NAME), props.getProperty(ServiceProperties.DATATRANSFER_SERVICE_URL), null);
		
		
		
	}
	
	private static void debugPrintln(String text){
		System.out.println("++ analysisUtils + " + text);
		log.info("++ analysisUtils + " + text);
	}

}
