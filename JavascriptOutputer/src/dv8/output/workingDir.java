package dv8.output;

import java.io.File;

public class workingDir {
	
	public static String getDir(){
		return new File("").getAbsolutePath();
	}
}
