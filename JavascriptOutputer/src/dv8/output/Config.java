package dv8.output;

public class Config {
	public static boolean loggingToFile;
	public static String configPath;
	public  static boolean firstRun;
	
	public static void load(){
		try{
			if(Main.runArgs[0].equals("-c")){
				DebugOutput.out("Worked like a charm.", 0);
				if(Main.runArgs[1] != null){
					
				}
			}
		}catch(Exception e){
			System.out.println("Sorry");

		}

	}
}
