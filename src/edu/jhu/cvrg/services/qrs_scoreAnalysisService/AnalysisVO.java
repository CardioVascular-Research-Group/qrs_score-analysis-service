package edu.jhu.cvrg.services.qrs_scoreAnalysisService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import edu.jhu.cvrg.dbapi.dto.PhysionetMethods;

//import edu.jhu.cvrg.waveform.model.PhysionetMethods;

public class AnalysisVO {

	private String userId;
	private long groupId;
	private long folderId;
	private String jobId;
	private String subjectId;
	private QRS_ScoreMethods algorithm;
	private List<String> inputFileNames;
	private String[] outputFileNames;
	public Map<String, Object> commandParamMap;
	
	private boolean sucess;
	private String errorMessage;
	
	public AnalysisVO(String jobId, String userId, long groupId, long folderId, String subjectId, QRS_ScoreMethods algorithm, List<String> inputFileNames, Map<String, Object> commandParamMap) {
		super();
		this.userId = userId;
		this.groupId = groupId;
		this.folderId = folderId;
		this.jobId = jobId;
		this.subjectId = subjectId;
		this.algorithm = algorithm;
		this.inputFileNames = inputFileNames;
		if(commandParamMap == null){
			this.commandParamMap = new HashMap<String, Object>();
		}else{
			this.commandParamMap = commandParamMap;	
		}
	}

	public String getUserId() {
		return userId;
	}

	public long getGroupId() {
		return groupId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public QRS_ScoreMethods getAlgorithm() {
		return algorithm;
	}

	public List<String> getFileNames() {
		return inputFileNames;
	}

	public Map<String, Object> getCommandParamMap() {
		return commandParamMap;
	}

	public long getFolderId() {
		return folderId;
	}

	public String getJobId() {
		return jobId;
	}

	public String[] getOutputFileNames() {
		return outputFileNames;
	}

	public void setOutputFileNames(String[] outputFileNames) {
		this.outputFileNames = outputFileNames;
	}
	
	public String getJobIdNumber(){
		return this.getJobId().replaceAll("\\D", "");
	}

	public boolean isSucess() {
		return sucess;
	}

	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
