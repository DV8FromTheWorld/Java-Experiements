package dv8.output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ParseLib {
	public static HashMap<String, String[]> mappings = new HashMap<String, String[]>();
	
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
					damageValue=null;
				}
					if(javaCode == null){
						System.out.println("Error with java code namings on line: " + currentLine);
					}else if(wikiMappings == null){
						System.out.println("Error with wiki namings on line : " + currentLine);
					}else{
						mappings.put(javaCode, new String[] {wikiMappings, damageValue});
					}
				}
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static String[] getFromLib(String key){
		return mappings.get(key);
	}
}
