package dv8.output;

import java.io.File;

public class Main {
	public static void main(String[] args){
		if(workingDir.getDir() !=null){
			ParseLib.parseTheLib();
			ParseJava.parseTheJava();
		}else{
			System.out.println("Did not parse libs nor java");
		}		
	}
}
