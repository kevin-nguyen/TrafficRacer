package game.utils;

import game.libs.Reference;
import game.screens.LoadScreen;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Fonts {

	private static ArrayList<Fonts> fontList = new ArrayList<Fonts>();
	
	private static String fontPath;
	
	public Fonts(String filePath)
	{
		LoadScreen.setMessage("Loading fonts from " + Reference.FONT_LOCATION);
		//looks for fonts in the resources/filepath
		Fonts.fontPath = Reference.FONT_LOCATION + filePath;
		registerFont();
	}
	
	private void registerFont()
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		try{
			
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void addFont(Fonts font)
	{
		fontList.add(font);
	}
	
	
}
