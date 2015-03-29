package game.utils.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFile {

	private static String line;
	
	public static String readFile(String path)
	{
		File file = new File(path);
		Scanner scan;
		
		
			try {
				scan = new Scanner(file);
				while(scan.hasNextLine()){
				line = scan.nextLine();
				}
				scan.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

		
		return line;
	}
	
	public static void writeFile(String path, String text)
	{
		
		try {
			FileWriter file = new FileWriter(path);
			file.write(text);
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getLine(){
		return line;
	}
	
}
