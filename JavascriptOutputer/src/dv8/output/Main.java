package dv8.output;

import java.io.IOException;

public class Main {
	
	public static String[] runArgs = new String[3];
	
	public static void main(String[] args) throws InterruptedException, IOException{
		if(DebugOutput.init()){
			if(Config.load()){
				if(!Config.firstRun){
					print("Beginning Lib parsing...");
					if(ParseLib.parseTheLib()){
						print("Lib parsing complete. Beginning Java parsing...");
						if(FileCreator.createDir(FileCreator.recipeDir)){
							if(ParseJava.parseTheJava()){
								print("Java parsing complete.  Beginning Javascript output...");
								JavascriptOutput.outputJavascript();
								print("Congratz, all done!");
								DebugOutput.log.close();
								Thread.sleep(15000);
							}else{
								DebugOutput.log.close();
								Thread.sleep(15000);		
							}
						}else{
							DebugOutput.log.close();
							Thread.sleep(15000);
						}
					}else{
						DebugOutput.log.close();
						Thread.sleep(15000);
					}
				}else{
					DebugOutput.out(
							"\n\n"+
							"#########################################################################\n"+
							"Program stopping due to this being the first run.\n" +
							"Please check that the config options are to your liking before rerunning.\n" +
							"Config location: " + Config.configFile.getAbsolutePath()+"\n"+
							"#########################################################################", 0);
					DebugOutput.log.close();
					Thread.sleep(15000);
				}
			}else{
				DebugOutput.log.close();
				Thread.sleep(15000);
			}
		}else{
			DebugOutput.log.close();
			Thread.sleep(15000);
		}
	}
	
	public static void print(String s){
		String hashMarkSpacer = "";
		for(int i=0; i< s.length(); i++){
			hashMarkSpacer = hashMarkSpacer + "#";
		}
		DebugOutput.out("", 0);
		DebugOutput.out(hashMarkSpacer, 0);
		DebugOutput.out(s, 0);
		DebugOutput.out(hashMarkSpacer, 0);
		DebugOutput.out("", 0);
	}
}
