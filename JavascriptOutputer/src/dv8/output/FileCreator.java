package dv8.output;

import java.io.File;
import java.io.IOException;

public class FileCreator {
	
	public static File filesDir = new File(getCurrentDir() + "\\files\\");
	public static File recipeDir = new File(filesDir.getAbsolutePath() + "\\recipes\\");
	
	public static boolean createFilesDir(){
		
		return true;
	}
	public static boolean createDir(File dir){
		DebugOutput.out("Checking for the existance of the \"" +dir.getName()+ "\" Directory.", 2);
		if(dir.exists()){
			DebugOutput.out("Directory exists. ", 2);
			return true;
		}else{
			DebugOutput.out("Directory does not exist.  Attempting to create the directory.", 2);
			if(dir.mkdirs()){
				DebugOutput.out("Successfully created the Directory.", 2);
				return true;				
			}else{
				DebugOutput.out("Could not create directory", 0);
				return false;
			}
		}
	}
	
	public static File mkFile(String fileName, boolean isRecipe){
		File newFile;
		if(isRecipe){
			newFile = new File(recipeDir.getAbsolutePath() + "\\" + fileName + ".txt");
		}else{
			newFile = new File(filesDir.getAbsolutePath() + "\\" + fileName + ".txt");
		}
		if(newFile.exists()){
			if(newFile.delete()){
				try {
					if(newFile.createNewFile()){
						DebugOutput.out("Successfully created file : " + newFile.getAbsolutePath(), 3);
						return newFile;
					}else{
						System.out.println("Could not create file :" + newFile.getAbsolutePath());
						return null;
					}
				} catch (IOException e) {
					DebugOutput.out("Could not create file :" + newFile.getAbsolutePath(), 0);
					DebugOutput.out("IOException caused by newFile.createNewFile()    First try catch block.", 0);
					e.printStackTrace();
					return null;
				}
			}else{
				DebugOutput.out("Could not delete file : \n" + newFile.getAbsolutePath() + " when attempting to write recipe for : " + fileName, 0);
				return null;
			}
		}else{
			try {
				if(newFile.createNewFile()){
					DebugOutput.out("Successfully created file : " + newFile.getAbsolutePath(), 3);
					return newFile;
				}else{
					DebugOutput.out("Could not create file :" + newFile.getAbsolutePath(), 0);
					return null;
				}
			} catch (IOException e) {
				DebugOutput.out("Could not create file :" + newFile.getAbsolutePath(), 0);
				DebugOutput.out("IOException caused by newFile.createNewFile()    Second try catch block.", 0);
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public static String getCurrentDir(){
		return new File("").getAbsolutePath();
	}
}
