package dv8.output;

public class DebugOutput {
	private static boolean enabled;
	private static int debugLevel;
	public static void init(){
		try{
			//if(Main.runArgs[0] != null){
				//if(Main.runArgs[0].equals("1") || Main.runArgs[0].equals("2") || Main.runArgs[0].equals("3")){
					//if(Main.run)
					enabled = true;
					debugLevel = 2;
					out("Debug Enabled.  Debug output level : " + debugLevel , 1);
				//}
			//}
		}catch(Exception e){
			
		}
	}
	
	public static void out(String s, int level){
		if(enabled && level <= debugLevel){
			System.out.println(s);
		}
	}
	public static String space(int i){
		String spacing = "";
		for(int j = 1; j <= i; j++){
			spacing = spacing + " ";
		}
		return spacing;		
	}
	public static String compensateAndSpace(int i){
		String bob = "";
		for(int j = (50 - i); j >=0; j--){
			bob = bob + " ";
		}
		return bob;
	}
}
