package dv8.output;

import java.io.BufferedWriter;
import java.io.FileWriter;

//Where the magic is completed
public class JavascriptOutput {
	
	public static void outputJavascript(){
		for(String[] stringArr : ParseJava.getRecipeSet()){
			String[] recipe = new String[12];
			String outputName = "";
			String itemName, itemAmount;
			for(int i = 0; i<=(stringArr.length - 2); i++){
				if(stringArr[i] != null){
					if(i == 0){
						recipe[i] = stringArr[i] + ",\n";
					}else if(i == 11){
						outputName = stringArr[i].substring(0, stringArr[i].indexOf(" "));
						recipe[i] = "[\"" +outputName+ "\",\"" +stringArr[i+1]+ "\"]\n";
					}else{
						itemName = stringArr[i].substring(0, stringArr[i].indexOf(" "));
						itemAmount = stringArr[i].substring(stringArr[i].indexOf(" ")+1);
						recipe[i] = "[\"" +itemName+ "\",\"" +itemAmount+ "\"],\n";
					}
				}else{
					recipe[i] = "\"\",\n";
				}
			}
			try{
				BufferedWriter out = new BufferedWriter(new FileWriter(FileCreator.mkFile(outputName, true)));
				out.write(
						"<script type=\"text/javascript\">\n"+
						"tierCraft(\n"+
						recipe[0] +
						recipe[1] +
						recipe[5] +
						recipe[6] +
						recipe[10] +
						recipe[9] +
						recipe[7] +
						recipe[8] +
						recipe[2] +
						recipe[3] +
						recipe[4] +
						recipe[11] +
						")\n" +
						"</script>");
				out.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
