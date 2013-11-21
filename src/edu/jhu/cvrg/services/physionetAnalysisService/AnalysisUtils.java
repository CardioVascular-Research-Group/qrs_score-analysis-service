package edu.jhu.cvrg.services.physionetAnalysisService;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.log4j.Logger;

import edu.jhu.cvrg.waveform.model.PhysionetMethods;
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
	public String[] inputFileNames = null;
	private long folderID;
	private long groupID;
	
	private static final Logger log = Logger.getLogger(AnalysisUtils.class);
	
	private String sep = File.separator;
	
	public AnalysisVO parseInputParametersType2(OMElement param0, PhysionetMethods algorithm){
		AnalysisVO ret = null;
		
		try {
			Map<String, OMElement> params = ServiceUtils.extractParams(param0);
			
			String jobID     	= params.get("jobID").getText() ;
			String userID      	= params.get("userID").getText() ;
			folderID      		= Long.parseLong(params.get("folderID").getText()) ;
			groupID      		= Long.parseLong(params.get("groupID").getText()) ;
			String subjectID    = params.get("subjectID").getText() ;
			OMElement parameterlist = (OMElement) params.get("parameterlist");
			
			String inputPath = ServiceUtils.SERVER_TEMP_ANALYSIS_FOLDER + sep + jobID;
			StringTokenizer strToken = new StringTokenizer(params.get("fileNames").getText(), "^");
			String[] fileNames = new String[strToken.countTokens()];
			for (int i = 0; i < fileNames.length; i++) {
				String name = strToken.nextToken();
				//ServiceUtils.createTempLocalFile(params, name, userID, inputPath, name);
				fileNames[i] = inputPath + sep + name;
			}
			
			inputFileNames = fileNames;

			if(parameterlist != null){
				debugPrintln("Building Command Parameter map...;");
				mapCommandParam = buildParamMap(parameterlist);
			}else{
				debugPrintln("There are no parameters, so Command Parameter map was not built.");
				mapCommandParam = new HashMap<String, Object>(); 
			}
			
			ret = new AnalysisVO(jobID, userID, groupID, folderID, subjectID, algorithm, inputFileNames, mapCommandParam);
			
		} catch (Exception e) {
			errorMessage = "parseInputParametersType2 failed.";
			log.error(errorMessage + " " + e.getMessage());
		}
		
		return ret;
	}
	
	public Set<AnalysisVO> extractToAnalysisObject(OMElement e){
		
		Set<AnalysisVO> ret = new HashSet<AnalysisVO>();
		
		Map<String, OMElement> params = ServiceUtils.extractParams(e);
		String userId = params.get("userID").getText();
		long groupId = Long.parseLong(params.get("groupID").getText());
		
		
		
		Map<String, OMElement> records = ServiceUtils.extractParams(params.get("records"));
		for (String recordKey : records.keySet()) {
			Map<String, OMElement> record = ServiceUtils.extractParams(records.get(recordKey));
			String subjectID = record.get("subjectID").getText();
			long folderID = Long.parseLong(record.get("folderID").getText());
			
			Map<String, OMElement> algorithms = ServiceUtils.extractParams(record.get("algorithms"));
			for (String algorithmKey : algorithms.keySet()) {
				Map<String, OMElement> algorithm = ServiceUtils.extractParams(algorithms.get(algorithmKey));
				PhysionetMethods type = PhysionetMethods.getMethodByName(algorithmKey);
				
				String jobId = algorithm.get("jobID").getText();
				String inputPath = ServiceUtils.SERVER_TEMP_ANALYSIS_FOLDER + sep +jobId;
				
				StringTokenizer strToken = new StringTokenizer(algorithm.get("fileNames").getText(), "^");
				String[] fileNames = new String[strToken.countTokens()];
				for (int i = 0; i < fileNames.length; i++) {
					String name = strToken.nextToken();
					fileNames[i] = inputPath + sep + name;
					
					ServiceUtils.createTempLocalFile(params, name, inputPath, name);
				}
				
				ret.add(new AnalysisVO(jobId, userId, groupId, folderID, subjectID, type, fileNames, null));
			}
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

			omeReturn = omFactory.createOMElement(analysis.getAlgorithm().getOmeName(), omNs); 
	
			// Converts the array of filenames to a single "^" delimited String for output.
			if (errorMessage.length() == 0){
				addOMEChild("filecount", new Long(analysis.getOutputFileNames().length).toString(),omeReturn,omFactory,omNs);
				omeReturn.addChild( makeOutputOMElement(analysis.getOutputFileNames(), "filenamelist", "filename", omFactory, omNs) );
				addOMEChild("jobID", analysis.getJobId(), omeReturn, omFactory, omNs);
				
				sendResultsBack(analysis);
				
			}else{
				addOMEChild("error","If analysis failed, put your message here: \"" + errorMessage + "\"",omeReturn,omFactory,omNs);
			}
		} catch (Exception e) {
			errorMessage = "genericWrapperType2 failed.";
			log.error(errorMessage + " " + e.getMessage());
		}
		
		return omeReturn;
	}
	
	private void sendResultsBack(AnalysisVO analysis) {
		
		Map<String, String> parameterMap = new HashMap<String, String>();
		
		parameterMap.put("jobID", analysis.getJobId());
		parameterMap.put("groupID", String.valueOf(analysis.getGroupId()));
		parameterMap.put("folderID", String.valueOf(analysis.getFolderId()));
		
		String fileNames = "";
		for (String name : analysis.getOutputFileNames()) {
			fileNames+=(name+'^');
		}
		parameterMap.put("resultFileNames", fileNames);
		
		ServiceProperties props = ServiceProperties.getInstance();
		
		WebServiceUtility.callWebService(parameterMap, props.getProperty("dataTransferServiceMethod"), props.getProperty("dataTransferServiceName"), props.getProperty("dataTransferServiceURL"), null);
		
	}

	public OMElement buildAnalysisReturn(String jobID, Set<AnalysisVO> analysisSet, String returnOMEName){
		OMElement omeReturn = null;
		OMFactory omFactory = OMAbstractFactory.getOMFactory(); 	 
		OMNamespace omNs = omFactory.createOMNamespace(sOMNameSpaceURI, sOMNameSpacePrefix);
		omeReturn = omFactory.createOMElement(returnOMEName, omNs);
		try{
			
			for (AnalysisVO analysisVO : analysisSet) {
				OMElement omeAnalysis = omFactory.createOMElement("job", omNs);
				
				addOMEChild("subjectID", analysisVO.getSubjectId(), omeAnalysis, omFactory,omNs);
				addOMEChild("algorithm", analysisVO.getAlgorithm().getName(), omeAnalysis, omFactory,omNs);
				addOMEChild("status", "started", omeAnalysis, omFactory,omNs);
				
				omeReturn.addChild(omeAnalysis);
			}
		} catch (Exception e) {
			errorMessage = returnOMEName + " failed. "+ e.getMessage();
			addOMEChild("status", errorMessage, omeReturn, omFactory, omNs);
			log.error(errorMessage);
		}
		return omeReturn;
	}


	/** Converts the array of output (relative) filenames to a single OMElement whose sub-elements are the filenames.
	 * 
	 * @param asFileNames - array of (relative) file path/name strings.
	 * @return - a single OMElement containing the path/names.
	 */
	private OMElement makeOutputOMElement(String[] asFileNames, String sParentOMEName, String sChildOMEName, OMFactory omFactory, OMNamespace omNs){
		debugPrintln("makeOutputOMElement()" + asFileNames.length + " file names");
		OMElement omeArray = null;
		if (asFileNames != null) {
			try {
				omeArray = omFactory.createOMElement(sParentOMEName, omNs); 
				
				for(int i=0; i<asFileNames.length;i++){
					addOMEChild(sChildOMEName, asFileNames[i], omeArray,omFactory,omNs);					
				}
			}catch(Exception e){
				log.error(e.getMessage());
			}
		}
		return omeArray;
	}
	
	/** Wrapper around the 3 common functions for adding a child element to a parent OMElement.
	 * 
	 * @param name - name/key of the child element
	 * @param value - value of the new element
	 * @param parent - OMElement to add the child to.
	 * @param factory - OMFactory
	 * @param dsNs - OMNamespace
	 */
	private void addOMEChild(String name, String value, OMElement parent, OMFactory factory, OMNamespace dsNs){
		OMElement child = factory.createOMElement(name, dsNs);
		child.addChild(factory.createOMText(value));
		parent.addChild(child);
	}
	
	/** Moves the files listed in the array from the source root directory to Liferay.
	 * 
	 * @param fileNames - array of full file path/name strings.
	 * @return - array of the new full file path/name strings.
	 */
	protected static String[] moveFiles(String[] fileNames, long groupId, long folderId){
		String errorMessage = "";
		debugPrintln("moveFiles() from: local to: liferay");
		if (fileNames != null) {
			int iMovedCount=0;
			try {
				for(int i=0;i<fileNames.length;i++){
					
					File orign = new File(fileNames[i]);
					FileInputStream fis = new FileInputStream(orign);
					
					String path = ServiceUtils.extractPath(fileNames[i]);
					
					ServiceUtils.sendToLiferay(groupId, folderId, path, orign.getName(), orign.length(), fis);
					
					iMovedCount++;
				}
				if(iMovedCount != fileNames.length){
					errorMessage += "moveFiles() failed. " + iMovedCount + " of " + fileNames.length + " moved successfully.";
				}
				
			} catch (Exception e) {
				errorMessage += "moveFiles() failed.";
				log.error(errorMessage + " " + e.getMessage());
				return null;
			}
	    }
		return fileNames;		
	}
	
	/** Find the first filename in the array with the "hea" extension.
	 * 
	 * @param asInputFileNames - array of filenames to search
	 * @return - full path/name.ext as found in the array.
	 */
	public static String findHeaderPathName(String[] asInputFileNames){
		debugPrintln("findHeaderPathName()");
		return findPathNameExt(asInputFileNames, "hea");
	}

	/** Find the first filename in the array with the specified extension.
	 * 
	 * @param asInputFileNames - array of filenames to search
	 * @param sExtension - extension to look for, without the dot(".") e.g. "hea".
	 * @return - full path/name.ext as found in the array.
	 */
	public static String findPathNameExt(String[] asInputFileNames, String sExtension){
		debugPrintln("findHeaderPathName()");
		String sHeaderPathName="", sTemp="";
		int iIndexPeriod=0;
		
		for(int i=0;i<asInputFileNames.length;i++){
			sTemp = asInputFileNames[i];
			debugPrintln("- asInputFileNames[" + i + "]: " + asInputFileNames[i]);
			iIndexPeriod = sTemp.lastIndexOf(".");
			
			if( sExtension.contains(sTemp.substring(iIndexPeriod+1)) ){
				sHeaderPathName = sTemp;
				break;
			}
		}
		debugPrintln("- ssHeaderPathName: " + sHeaderPathName);
		return sHeaderPathName;
	}

	
	private static void debugPrintln(String text){
		log.debug("++ analysisUtils + " + text);
	}

}