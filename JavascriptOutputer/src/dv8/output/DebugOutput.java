package dv8.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DebugOutput {
	public static BufferedWriter log;
	private static boolean enabled = false;
	
	public static boolean init(){
		try{
			if(FileCreator.createDir(FileCreator.filesDir)){
				log = new BufferedWriter(new FileWriter(FileCreator.mkFile("log", false)));
				enabled = true;
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static void out(String s, int level){
		if(Config.DebugVerbose){
			try {
				System.out.println(s);
				if(enabled){
					log.write(s + "\n");
				}
			} catch (IOException e) {
				
			}
		}else if(level <= 2){
			try {
				System.out.println(s);
				if(enabled){
					log.write(s + "\n");
				}
			} catch (IOException e) {
				
			}
		}
		
	}

	public static String compensateAndSpace(int i){
		String bob = "";
		for(int j = (50 - i); j >=0; j--){
			bob = bob + " ";
		}
		return bob;
	}
}
