package dv8.output;

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
			
			System.out.println("=================  " + outputName +"  =================");
			System.out.print(
					"<script type=\"text/javascript\">\n"+
					recipe[0] +
					recipe[1] +
					recipe[2] +
					recipe[3] +
					recipe[4] +
					recipe[5] +
					recipe[6] +
					recipe[7] +
					recipe[8] +
					recipe[9] +
					recipe[10] +
					recipe[11] +
					")\n" +
					"</script>");
			System.out.println();
			System.out.println();
		}
	}
	
	public static String space(int i){
		String spacing = "";
		for(int j = 1; j <= i; j++){
			spacing = spacing + " ";
		}
		return spacing;		
	}
}
