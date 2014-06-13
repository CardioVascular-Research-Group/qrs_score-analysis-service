package edu.jhu.cvrg.services.qrs_scoreAnalysisService.test;

import edu.jhu.cvrg.services.qrs_scoreAnalysisService.lookup.AlgorithmDetailLookup;
import edu.jhu.cvrg.services.qrs_scoreAnalysisService.serviceDescriptionData.AlgorithmServiceData;



public class testLookup {

	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		AlgorithmDetailLookup details = new AlgorithmDetailLookup();
		details.loadDetails();
		AlgorithmServiceData[] asdDetail = details.serviceList;
	}

}
