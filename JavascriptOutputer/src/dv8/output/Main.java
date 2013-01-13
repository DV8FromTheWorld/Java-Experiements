package dv8.output;

public class Main {
	
	public static String[] runArgs = new String[3];
	
	public static void main(String[] args){
		//runArgs = args;
		runArgs[0] = "2";
		DebugOutput.init();
		if(FileCreator.createRecipeDir()){
			System.out.println(FileCreator.mkFile("yo"));
			/*if(workingDir.getDir() !=null){
				System.out.println("Beginning Lib parsing...");
				ParseLib.parseTheLib();
				System.out.println("Lib parsing complete. Beginning Java parsing...");
				ParseJava.parseTheJava();
				System.out.println("Java parsing complete.  Beginning Javascript output...");
				JavascriptOutput.outputJavascript();
				System.out.println("Congratz, all done!");
			}else{
				System.out.println("Did not parse libs nor java");
			}*/
		}
		
	}
}
