package dv8.output;

import java.io.File;
import java.io.IOException;

public class FileCreator {
	
	public static File recipeDir = new File(workingDir.getDir() + "\\files\\recipes\\");
	
	public static boolean createRecipeDir(){
		DebugOutput.out("Checking for the existance of the Recipe Directory.", 2);
		if(recipeDir.exists()){
			DebugOutput.out("Recipe Directory exists. ", 2);
			return true;
		}else{
			DebugOutput.out("Recipe Directory does not exist.  Attempting to create the directory.", 2);
			if(recipeDir.mkdirs()){
				DebugOutput.out("Successfully created the Recipe Directory.", 2);
				return true;				
			}else{
				System.out.println("Could not create the Recipe Directory");
				return false;
			}
		}
	}
	
	public static File mkFile(String recipeName){
		File recipeFile = new File(recipeDir.getAbsolutePath() + "\\" + recipeName + ".txt");
		if(recipeFile.exists()){
			if(recipeFile.delete()){
				try {
					if(recipeFile.createNewFile()){
						DebugOutput.out("Successfully created file : " + recipeFile.getAbsolutePath(), 3);
						return recipeFile;
					}else{
						System.out.println("Could not create file :" + recipeFile.getAbsolutePath());
						return null;
					}
				} catch (IOException e) {
					System.out.println("Could not create file :" + recipeFile.getAbsolutePath());
					System.out.println("IOException caused by recipeFile.createNewFile()    First try catch block.");
					e.printStackTrace();
					return null;
				}
			}else{
				System.out.println("Could not delete file : \n" + recipeFile.getAbsolutePath() + 
						"\n when attempting to write recipe for : " + recipeName);
				return null;
			}
		}else{
			try {
				if(recipeFile.createNewFile()){
					DebugOutput.out("Successfully created file : " + recipeFile.getAbsolutePath(), 3);
					return recipeFile;
				}else{
					System.out.println("Could not create file :" + recipeFile.getAbsolutePath());
					return null;
				}
			} catch (IOException e) {
				System.out.println("Could not create file :" + recipeFile.getAbsolutePath());
				System.out.println("IOException caused by recipeFile.createNewFile()    Second try catch block.");
				e.printStackTrace();
				return null;
			}
		}
	}
}
