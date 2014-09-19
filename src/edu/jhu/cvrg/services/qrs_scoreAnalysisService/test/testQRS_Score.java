/**
 * 
 */
package edu.jhu.cvrg.services.qrs_scoreAnalysisService.test;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

import edu.jhu.cvrg.services.qrs_scoreAnalysisService.QRS_ScoreService;

/**
 * @author mshipwa1
 *
 */
public class testQRS_Score {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("main() started.");
		OMFactory omFactory = OMAbstractFactory.getOMFactory(); 	 
		OMNamespace omNs = omFactory.createOMNamespace("http://www.cvrgrid.org/QRS_ScoreService/", "QRS_ScoreService"); 	 
		OMElement omeSqrs = omFactory.createOMElement("qrs_scoreWrapperType2", omNs); 
		
		addOMEChildLocal("jobID",
				"333333333", 
				omeSqrs,omFactory,omNs);
		addOMEChildLocal("userID",
				"444444444", 
				omeSqrs,omFactory,omNs);
		addOMEChildLocal("folderID",
				"555555555", 
				omeSqrs,omFactory,omNs);
		addOMEChildLocal("groupID",
				"666666666", 
				omeSqrs,omFactory,omNs);
		addOMEChildLocal("subjectID",
				"777777777", 
				omeSqrs,omFactory,omNs);
		addOMEChildLocal("parameterlist",
				"", 
				omeSqrs,omFactory,omNs);

		addOMEChildLocal("fileCount",
				"2", 
				omeSqrs,omFactory,omNs);
		addOMEChildLocal("fileNames",
				"/test/jhu315.dat^/test/jhu315.hea^", 
				omeSqrs,omFactory,omNs);
		addOMEChildLocal("verbose",
				"true", 
				omeSqrs,omFactory,omNs);

		try {
			QRS_ScoreService test = new QRS_ScoreService();
			
			OMElement omeQRS_Score_Result = test.qrs_scoreWrapperType2(omeSqrs);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** Local copy of utility, Wrapper around the 3 common functions for adding a child element to a parent OMElement.
	 * 
	 * @param name - name/key of the child element
	 * @param value - value of the new element
	 * @param parent - OMElement to add the child to.
	 * @param factory - OMFactory
	 * @param dsNs - OMNamespace
	 */
	private static void addOMEChildLocal(String name, String value, OMElement parent, OMFactory factory, OMNamespace dsNs){
		OMElement child = factory.createOMElement(name, dsNs);
		child.addChild(factory.createOMText(value));
		parent.addChild(child);
	}

}

