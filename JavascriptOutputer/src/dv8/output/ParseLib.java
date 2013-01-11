package dv8.output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ParseLib {
	public static HashMap<String, String> mappings = new HashMap<String, String>();
	
	public static void parseTheLib(){
		String strLine;
		String sub1, sub2;
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader("C:\\Users\\GAKeener\\Desktop\\Java Experiments\\JavascriptOutputer\\files\\mappingLibs.txt"));
			while((strLine = br.readLine()) != null){
				if(strLine.indexOf("\"") == -1){
					
				}else{
				int start1, end1, start2;
				sub1 = strLine.substring((start1 = (strLine.indexOf("\"")+1)), (end1 = (strLine.indexOf("\"", (start1)))));
				sub2 = strLine.substring((start2 =(strLine.indexOf("\"", end1 + 1)+1)), (strLine.indexOf("\"", (start2 + 1))));
				System.out.println(sub1);
				System.out.println(sub2);
				mappings.put(sub1, sub2);
				}
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static String getFromLib(String key){
		System.out.println(key);
		return mappings.get(key);
	}
}
