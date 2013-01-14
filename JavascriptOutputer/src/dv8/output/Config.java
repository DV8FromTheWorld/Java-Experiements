package dv8.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Config {
	public static boolean loggingToFile;
	public  static boolean firstRun;
	public static File configFile = new File(workingDir.getDir() + "\\files\\config.txt");
	
	public static boolean load(){
		if(configFile.exists()){
			firstRun = false;
			//TODO
			
			
			return true;
		}else {
			firstRun = true;
			DebugOutput.out("Did not find Config file, attempting to create one now...", 0);
			if((configFile = FileCreator.mkFile("config", false)) != null){
				if(populateDefaults()){
					DebugOutput.out("Successfully created new Config file and populated it with defaults.", 0);
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
	}	
		
	public static boolean populateDefaults(){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(configFile));
			out.write(
					"# Lines that start with a \"#\" are ignored.\n"+
					"#\n"+
					"# If verbose is enabled, lots more info is put out.  Very helpful.\n"+
					"DebugVerbose: false\n"+
					"#\n"+
					"# Defines the file that contains the java recipes.\n"+
					"JavaFile: parseMe.txt\n"+
					"#\n"+
					"# Defines the file that contains the libs to convert from java to javascript.\n"+
					"Libs: mappingLibs.txt"
					);
			out.close();
			return true;
		}catch(Exception e){
			DebugOutput.out("Created new Config files but could not populate new config with defaults", 0);
			e.printStackTrace();
			return false;
		}
	}
}
