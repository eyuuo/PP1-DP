package edu.handong.csee.pp1.dp;

public class Main {
	
	static boolean INFO = true;
	
	public static void main(String[] args) {
		new Main().run(args);
	}

	private void run(String[] args) {
		String gitPath = args[0];
		String arffFilePathToBeSaved = args[1];
		
		MetricCollector metricCollector = new MetricCollector(gitPath,arffFilePathToBeSaved);
		
		metricCollector.collect();
		metricCollector.saveAnArffFile();//파일을 저장하는 부분.
	}
}
//디버깅하는 거 다시 알려달라고 하기.
//