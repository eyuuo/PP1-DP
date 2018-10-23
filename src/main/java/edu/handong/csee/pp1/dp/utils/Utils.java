package edu.handong.csee.pp1.dp.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;

import edu.handong.csee.pp1.dp.RawInstance;

public class Utils {
	
	static public ArrayList<File> getJavaFiles(String path){
		ArrayList<File> files = new ArrayList<File>();
		
		File directory = new File(path);//파일안에 path를 저장한다. 끝나게 해야한다...directory가 아니면 자바 파일이라고 인식....
		
		if(!directory.exists()) {
			System.err.println("Path is not existing. Check your git path!");
		}
		
		if(!directory.isDirectory()) {
			// path가 디렉토리가 아니라 java file이면 파일 목록에 추가 후 리턴. java 파일이 아니면 그냥 빈 목록 리턴.
			if(FilenameUtils.getExtension(directory.getName()).equals("java"))
				files.add(directory);
			
			return files;
		}
		
		// 여기까지 오면, directory는 정말 디럭터리 path임. 해당 directory에 있는 모든 자바 파일가져오기.
		for(File file:directory.listFiles()) {
			if(file.isDirectory())
				files.addAll(getJavaFiles(file.getPath()));
			else {
				if(FilenameUtils.getExtension(file.getName()).equals("java"))
					files.add(file);
			}
		}

		return files;
	}
	
	static public String readAFile(String file){
		String text ="";
		String thisLine="";
		//Open the file for reading
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((thisLine = br.readLine()) != null) { // while loop begins here
				text += thisLine + "\n";
			} // end while 
			br.close();
		} // end try
		catch (IOException e) {
			System.err.println("Error: " + e);
			//System.exit(0);
		}

		return text;
	}
	
	/**
	 * Write an arff file with instances
	 * @param instances Instances object
	 * @param targetFileName An arff file is saved with this parameter value
	 */
	static public void writeADataFile(ArrayList<RawInstance> rawInstances,String targetFileName){
		try {
			File file= new File(targetFileName);
			if(file.exists()){
				return;
			}

			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos=new DataOutputStream(fos);
			
			for(int i=0; i < rawInstances.size();i++) {
				dos.write(((i+1) + "," + rawInstances.get(i).getJavaFilePath() + "\n").getBytes());
			}

			dos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("FileName: " + targetFileName);
			System.exit(0);
		} 
	}
}