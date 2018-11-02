package edu.handong.csee.pp1.dp;

import static org.junit.Assert.*;

import org.junit.Test;

import net.lifove.clami.CLAMI;

public class CLAMITest {
	
	@Test
	public void testCLAMIHelp() {
		// Put a GitHub repository path you cloned in your laptop.
		String[] args = {"-h"};
		
		CLAMI.main(args);
	}
	
	@Test
	public void testCLAWithApacheProject() {
		
		String[] args = {"-f","data/Apache.arff","-l","isDefective","-p", "TRUE"};
		
		
		CLAMI.main(args);
	}
	
	@Test
	public void testCLAMIWithApacheProject() {
		
		String[] args = {"-f","data/Apache.arff","-l","isDefective","-p", "TRUE", "-m"};
		
		
		CLAMI.main(args);
	}
	
	@Test
	public void testCLAMIWithApacheProjectByRandomForest() {
		
		String[] args = {"-a", "weka.classifiers.trees.RandomForest",
				         "-f","data/Apache.arff","-l","isDefective","-p", "TRUE", "-m"};
		
		
		CLAMI.main(args);
	}
	
	@Test
	public void testCLAMIWithApacheProjectByBayesNet() {
		
		String[] args = {"-a", "weka.classifiers.bayes.BayesNet",
				         "-f","data/Apache.arff","-l","isDefective","-p", "TRUE", "-m"};
		
		
		CLAMI.main(args);
	}
	
	@Test
	public void testCLAMIWithYourSelectedProject() {
		
		// TASK3: Conduct defect prediction by using CLAMI models
		// complete this test case for the generated arff files from Task 2
		
		//String[] args = {"-f","data/[your_generated_metric_data].arff","-l","label","-p", "buggy", "-m"};
		String[] args = {"-f","data/PP1-DP.arff","-l","label","-p", "buggy", "-m"};
		CLAMI.main(args);
	}
	
	@Test
	public void testCLAMIWithYourSelectedProject2() {
		
		// TASK3: Conduct defect prediction by using CLAMI models
		// complete this test case for the generated arff files from Task 2
		
		//String[] args = {"-f","data/[your_generated_metric_data].arff","-l","label","-p", "buggy", "-m"};
		String[] args = {"-f","data/java-1.arff","-l","label","-p", "buggy", "-m"};
		CLAMI.main(args);
	}
	
	@Test
	public void testCLAMIWithYourSelectedProject3() {
		
		// TASK3: Conduct defect prediction by using CLAMI models
		// complete this test case for the generated arff files from Task 2
		
		//String[] args = {"-f","data/[your_generated_metric_data].arff","-l","label","-p", "buggy", "-m"};
		String[] args = {"-f","data/esapi-java.arff","-l","label","-p", "buggy", "-m"};
		CLAMI.main(args);
	}
	
	
	
	@Test
	public void testCLAMIWithApacheProjectToFindBestCutoffForPrecision() {
		
		// TASK4 TODO Use this method to find the best cutoff = 88
		/*
		50 : Precision: 0.7368421052631579
		65 : Precision: 0.7647058823529411
		70 : Precision: 0.7931034482758621
		80 : Precision: 0.7941176470588235
		83 : Precision: 0.7931034482758621
		85 : Precision: 0.7931034482758621
		86 : Precision: 0.8148148148148148
		87 : Precision: 0.8076923076923077
		88 : Precision: 0.8181818181818182 (v)
		89 : Precision: 0.8
		90 : Precision: 0.7894736842105263
		91 : Precision: 0.7142857142857143
		 */
		
		String bestCutoff = "88";
		
		String[] args = {"-f","data/Apache.arff","-l","isDefective","-p", "TRUE", "-m", "-c", bestCutoff};

		CLAMI.main(args);
	}
	
	@Test
	public void testCLAMIWithApacheProjectToFindBestCutoffForFmeasure() {
		
		// TASK5 TODO Use this method to find the best cutoff for f-measure
		
		/* 60 : F1: 0.6666666666666667
		 * 50 : F1: 0.7253886010362695
		 * 44 : F1: 0.721951219512195
		 * 43 : F1: 0.7272727272727272
		 * 42 : F1: 0.7523809523809524 (v)
		 * 41 : F1: 0.7476635514018692
		 * 40 : F1: 0.7476635514018692
		 * 38 : F1: 0.7272727272727273
		 * 30 : F1: 0.7296137339055794
		 * */
		String bestCutoff = "55";
		
		String[] args = {"-f","data/Apache.arff","-l","isDefective","-p", "TRUE", "-m", "-c", bestCutoff};
		CLAMI.main(args);
	}

}
