package parse;

import java.io.*;
public class Main {
	public static void main(String[] args){
		
		try{
			String strLine;
			String sub1,sub2;
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\GAKeener\\Desktop\\Java Experiments\\FileParser\\files\\yo.txt"));
			while((strLine = br.readLine()) != null){
				if(strLine.indexOf("\"") == -1){
					
				}else{
					sub1 = strLine.substring(0, strLine.indexOf("(")).trim();
					sub2 = strLine.substring(strLine.indexOf("\""), strLine.indexOf(")"));
					println('"' + sub1 +  ": [\"\",\"\"," + sub2 + "],");
				}
				
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("Didnt work you moron >.>");
		}
				
	}
	public static void println(String s){
		System.out.println(s);
	}
}
