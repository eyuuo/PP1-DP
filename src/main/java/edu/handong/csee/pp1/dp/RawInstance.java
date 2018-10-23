//인스턴스 하나한에어떤 조건이 적용될지.
package edu.handong.csee.pp1.dp;

public class RawInstance {
	
	String javaFilePath;
	
	static public final int NUMMETRICS = 6;
	// 인스턴스의 메트릭 값을 저장하는 field들.
	int[] values = new int[NUMMETRICS];
	//다 저장된것을 파일로 저장하면 된다.
	int linesOfCode;
	int numOfVariables;
	int numOfMethods;
	int numOfMethodInvocation;
	int numOfForLoops;
	int numOfIfStatements;
	
	public RawInstance(String path) {
		setJavaFilePath(path);
	}
	
	public int[] getValues() {
		return values;
	}

	public String getJavaFilePath() {
		return javaFilePath;
	}
	
	public void setJavaFilePath(String javaFilePath) {
		this.javaFilePath = javaFilePath;
	}
	
	public int getLinesOfCode() {
		return values[0];
	}
	
	public void setLinesOfCode(int linesOfCode) {
		values[0] = linesOfCode;
	}
	
	public int getNumOfVariables() {
		return values[1];
	}
	
	public void setNumOfVariables(int numOfVariables) {
		values[1] = numOfVariables;
	}
	
	public int getNumOfMethods() {
		return values[2];
	}

	public void setNumOfMethods(int numOfMethods) {
		values[2] = numOfMethods;
	}
	public int getNumOfMethodInvocation() {
		return values[3];
	}
	
	public void setNumOfMethodInvocations(int numOfMethodInvocation) {
		values[3] = numOfMethodInvocation;
	}
	public int getNumOfForLoops() {
		return values[4];
	}
	
	public void setNumOfForLoops(int numOfForLoops) {
		values[4] = numOfForLoops;
	}
	
	public int getNumOfIfStatements() {
		return values[5];
	}
	
	public void setNumOfIfStatements(int numOfIfStatements) {
		values[5] = numOfIfStatements;
	}
}