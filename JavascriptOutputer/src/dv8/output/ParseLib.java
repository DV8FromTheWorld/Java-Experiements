package dv8.output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//Where the magic begins
public class ParseLib {
	public static HashMap<String, String> mappings = new HashMap<String, String>();
	
	public static void parseTheLib(){
		String strLine;
		String javaCode, wikiMappings, damageValue;
		int currentLine = 0;
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(workingDir.getDir() + "\\files\\mappingLibs.txt"));
			while((strLine = br.readLine()) != null){
				int javaStart, javaStop, damageStart, damageStop, wikiStart;
				currentLine++;
				if(strLine.indexOf("\"") == -1){
					
				}else{
				javaCode = strLine.substring((javaStart= (strLine.indexOf("\"")+1)), (javaStop = (strLine.indexOf("\"", (javaStart)))));
				if(strLine.indexOf(",") != -1){
					damageValue = strLine.substring((damageStart=strLine.indexOf("\"", javaStop+1)+1), (damageStop=strLine.indexOf("\"", damageStart+1)));
					wikiMappings = strLine.substring((wikiStart =(strLine.indexOf("\"", damageStop + 1)+1)), (strLine.indexOf("\"", (wikiStart + 1))));
				}else{
					wikiMappings = strLine.substring((wikiStart =(strLine.indexOf("\"", javaStop + 1)+1)), (strLine.indexOf("\"", (wikiStart + 1))));
					damageValue="-1";
				}
					if(javaCode == null){
						DebugOutput.out("Error with java code namings on line: " + currentLine, 1);
					}else if(wikiMappings == null){
						DebugOutput.out("Error with wiki namings on line : " + currentLine, 1);
					}else{
						wikiMappings = wikiMappings.toLowerCase();
						mappings.put((javaCode + " " + damageValue), wikiMappings);
					}
				}
			}
			br.close();
		}catch(IOException e){
			System.out.println("Could not located the mappingLibs.txt file.  Please make sure that it exists in the \"files\" folder");
		}
	}
	
	public static String getFromLib(String key){
		return mappings.get(key);
	}
}
