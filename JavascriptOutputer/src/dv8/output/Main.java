package dv8.output;

public class Main {
	
	public static String[] runArgs = new String[3];
	
	public static void main(String[] args){
		runArgs = args;
		DebugOutput.init();
		Config.load();
		if(FileCreator.createRecipeDir()){
			if(workingDir.getDir() !=null){
				print("Beginning Lib parsing...");
				if(ParseLib.parseTheLib()){
					print("Lib parsing complete. Beginning Java parsing...");
					if(ParseJava.parseTheJava()){
						print("Java parsing complete.  Beginning Javascript output...");
						JavascriptOutput.outputJavascript();
						print("Congratz, all done!");
						
					}
				}
			}else{
				print("Did not parse libs nor java");
			}
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
