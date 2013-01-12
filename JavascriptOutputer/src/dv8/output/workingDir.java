package dv8.output;

import java.io.File;
import java.nio.file.Files;

public class workingDir {
	
	public static String getDir(){
		return new File("").getAbsolutePath();
	}
}
