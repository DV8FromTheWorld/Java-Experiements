package dv8.output;

import java.io.BufferedWriter;

public class DebugOutput {
	private static int debugLevel;
	private static BufferedWriter br;
	
	public static void init(){
		try{
			//br = new BufferedWriter
			debugLevel = 2;
			out("Debug Enabled.  Debug output level : " + debugLevel , 1);
		}catch(Exception e){
			
		}
	}
	
	public static void out(String s, int level){
		if(level <= debugLevel){
			System.out.println(s);
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
