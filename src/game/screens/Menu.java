package game.screens;

import game.Game;
import game.libs.Audio;
//import game.input.MouseInput;
import game.libs.Images;
import game.libs.Reference;
import game.utils.AudioPlayer;
import game.utils.Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
//import java.io.File;

//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;

public class Menu {
	
	public Button play, options, quit, upgrade, scoresList, profile;
	//private int centerX = Game.WIDTH / 2;
	//private static int centerY = Game.HEIGHT / 2;
	
	//creates menu rectangle shapes
	public Menu()
	{
		int fillerY = 150;
		play = new Button(Reference.CENTER_X - 150, fillerY, 300, 50).setText("Play");
		upgrade  = new Button(Reference.CENTER_X - 150, fillerY+= 60, 300, 50).setText("Upgrade");
		options  = new Button(Reference.CENTER_X - 150, fillerY+= 60, 300, 50).setText("Options");
		scoresList  = new Button(Reference.CENTER_X - 150, fillerY+= 60, 300, 50).setText("HighScores");
		quit  = new Button(Reference.CENTER_X - 150, fillerY+= 60, 300, 50).setText("Quit");
		profile  = new Button(Reference.CENTER_X + 210, fillerY, 100, 100).setText("Prof");
		
		
	}
	
	//creates standard menu button
//	public void drawButton(Graphics g, Rectangle rect, String text, int offsetX, Color c)
//	{
//		Font roadMovie = new Font("ROAD MOVIE", Font.PLAIN, 45);
//		g.setFont(roadMovie);
//		
//		g.drawRect(rect.x, rect.y, rect.width, rect.height);
//		g.drawString(text, rect.x + offsetX, rect.y + 40);
//	}
//	
	//creates and draws the menu button names 
	public void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		//g.drawImage(ImageIO.read(new File(Reference.SPRITE_LOCATION + "gameWater.png")), 0, 0);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.title, 105, 10, null);
		
		Font roadMovie = new Font("ROAD MOVIE", Font.PLAIN, 45);
		g.setFont(roadMovie);
		
		play.drawButton(g, 80);
		upgrade.drawButton(g, 70);
		options.drawButton(g, 70);
		scoresList.drawButton(g, 50);
		quit.drawButton(g, 85);
		profile.drawButton(g, 0);
		
//		drawButton(g, play, "Start", 90, Color.GREEN);
//		drawButton(g, upgrade, "Upgrade Car", 15, Color.BLUE);
//		drawButton(g, options, "Options", 65, Color.BLUE);
//		drawButton(g, scoresList, "HighScores", 27, Color.BLUE);
//		drawButton(g, quit, "Quit", 92, Color.RED);
//		drawButton(g, profile, "User", 0, Color.BLUE);
		
		
	}
	
}
