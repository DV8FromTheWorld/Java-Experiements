package dv8.output;

public class Main {
	public static void main(String[] args){
		ParseLib.parseTheLib();	
		System.out.println("Using \"apple\" returns: " + ParseLib.getFromLib("Item.apple"));
	}
}
