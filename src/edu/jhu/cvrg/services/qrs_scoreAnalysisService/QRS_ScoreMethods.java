package edu.jhu.cvrg.services.qrs_scoreAnalysisService;
// this should be replaced with the primary key from the algorithm table.
public enum QRS_ScoreMethods{
	QRS_SCORE("QRS_SCORE", "qrs_scoreWrapperType2");
	
	private String name;
	private String omeName; 
	
	QRS_ScoreMethods(String name, String omeName){
		this.omeName = omeName;
		this.name = name;
	}
	
	public String getOmeName(){
		return omeName;
	}

	public String getName() {
		return name;
	}
	
	public static QRS_ScoreMethods getMethodByName(String name){
		
		for (QRS_ScoreMethods m : values()) {
			if(m.getName().equals(name) || m.toString().equals(name)){
				return m;
			}
		}
		return null;
	}
}