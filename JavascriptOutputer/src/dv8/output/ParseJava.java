package dv8.output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParseJava {
	public static void parseIt(){
		int i1, i2, i3, i4, i5;
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader("C:\\Users\\GAKeener\\Desktop\\Java Experiments\\JavascriptOutputer\\files\\parseMe.txt"));
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}