package dv8.output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Where the magic is given life
public class ParseJava {
	private static String strJava;
	public static ArrayList<String[]> convertedRecipeList = new ArrayList<String[]>();
	
	public static boolean parseTheJava(){
		int iTier, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, iOutput, iAmount;
		String[] recipe = new String[13];
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(FileCreator.filesDir + "\\"+ Config.JavaFileName));
				while((strJava = br.readLine()) != null){
					
					strJava = strJava.trim();
					recipe[0] = strJava.substring((iTier=strJava.indexOf("(")+1), (i1=strJava.indexOf(",", iTier)));
					recipe[1] = strJava.substring(i1+2, (i2=getProperIndex(i1)));
					recipe[2] = strJava.substring(i2+2, (i3=getProperIndex(i2)));
					recipe[3] = strJava.substring(i3+2, (i4=getProperIndex(i3)));
					recipe[4] = strJava.substring(i4+2, (i5=getProperIndex(i4)));
					recipe[5] = strJava.substring(i5+2, (i6=getProperIndex(i5)));
					recipe[6] = strJava.substring(i6+2, (i7=getProperIndex(i6)));
					recipe[7] = strJava.substring(i7+2, (i8=getProperIndex(i7)));
					recipe[8] = strJava.substring(i8+2, (i9=getProperIndex(i8)));
					recipe[9] = strJava.substring(i9+2, (i10=getProperIndex(i9)));
					recipe[10] = strJava.substring(i10+2, (iOutput=getProperIndex(i10)));
					recipe[11] = strJava.substring(iOutput+2, (iAmount=getProperIndex(iOutput)));
					recipe[12] = strJava.substring(iAmount+2, (strJava.indexOf(";")-1));
					
					convertToMappingFormat(recipe);
				}
			br.close();
			return true;
		}catch(IOException e){
			DebugOutput.out("Could not located the "+Config.JavaFileName+ " file.  Please make sure that it exists in the \"files\" folder", 0);
			return false;
		}
	}
	
	private static int getProperIndex(int startIndex){
		int failSafeIndex = strJava.indexOf("(),", startIndex);
		int index1 = strJava.indexOf("),", startIndex);
		int index2 = strJava.indexOf("null,", startIndex);
		if(failSafeIndex != -1){
			if(failSafeIndex < index1){
				index1 = strJava.indexOf("),", failSafeIndex + 2);
			}
		}		
		if(index1 == -1){
			return index2 + 4;
		}else if(index2 == -1){
			return index1 + 1;
		}else if(index1 < index2){
			return index1 + 1;
		}else{
			return index2 + 4;
		}
	}
	
	private static void convertToMappingFormat(String[] recipeArr){
		String[] convertedRecipeArr= new String[13];
		for(int i=0; i<=(recipeArr.length-1); i++){
			String itemName, itemAmount, itemDamage, itemNameConverted;
			int nameEnd, amountEnd;
			if(recipeArr[i].contains("null")){
				convertedRecipeArr[i] = null;
			}else if(recipeArr[i].contains("new ItemStack")){
				itemName = recipeArr[i].substring(recipeArr[i].indexOf("(")+1, (nameEnd=recipeArr[i].indexOf(",")));		
				if(recipeArr[i].indexOf(",", nameEnd+1) !=-1){
					itemAmount = recipeArr[i].substring((recipeArr[i].indexOf(",", nameEnd)+1), (amountEnd=recipeArr[i].indexOf(",", nameEnd+1)));
					itemDamage = recipeArr[i].substring((amountEnd+1), recipeArr[i].indexOf(")"));
					itemAmount = itemAmount.trim();
					itemDamage = itemDamage.trim();
				}else{
					itemAmount = recipeArr[i].substring(recipeArr[i].indexOf(",")+1, recipeArr[i].length()-1);
					itemDamage = "-1";
					itemAmount = itemAmount.trim();;
				}
				if((itemNameConverted = ParseLib.getFromLib(itemName + " " + itemDamage)) != null){
					DebugOutput.out(itemName + DebugOutput.compensateAndSpace((itemName).length()) +" found in lib   " + itemNameConverted, 3);
					convertedRecipeArr[i] = (itemNameConverted + " " + itemAmount);
				}else{
					DebugOutput.out("=====Could not located \"" + itemName + "\" in libs.======", 1);
				}
			}else if(i == 0 || i == 12){	//index 0 and 12 are the Tier and outputAmount respectively, which are always numbers.
				convertedRecipeArr[i] = recipeArr[i];			
			}else{
				DebugOutput.out("Unhandled string type.  Was not index 0 nor 12.  Was not handled by the Null check nor the ItemStack check", 0);
			}
		}
		convertedRecipeList.add(convertedRecipeArr);
	}
	
	public static ArrayList<String[]> getRecipeSet(){
		return convertedRecipeList;
	}
}
