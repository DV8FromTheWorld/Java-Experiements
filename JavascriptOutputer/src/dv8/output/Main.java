package dv8.output;

import java.io.File;

public class Main {
	
	public static String[] runArgs = new String[3];
	
	public static void main(String[] args){
		//runArgs = args;
		runArgs[0] = "2";
		DebugOutput.init();
		if(workingDir.getDir() !=null){
			ParseLib.parseTheLib();
			ParseJava.parseTheJava();
		}else{
			System.out.println("Did not parse libs nor java");
		}
	}
}
