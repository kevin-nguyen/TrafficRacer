package game.screens;

import game.Game;
import game.libs.Reference;
import game.utils.Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class OptionScreen {

	public Button back, reset;
	
	//private int centerX = Game.WIDTH / 2;
	//private static int centerY = Game.HEIGHT / 2;
	
	//creates menu rectangle shapes
	public OptionScreen()
	{

		back = new Button(Reference.CENTER_X - 350 , 450, 90, 50).setText("BACK");
		reset = new Button(Reference.CENTER_X - 100 ,Reference.CENTER_Y, 175, 50).setText("RESET");
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
		g.setColor(Color.WHITE);
		//g.drawImage(ImageIO.read(new File(Reference.SPRITE_LOCATION + "gameWater.png")), 0, 0);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		
		
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.BOLD, 48));
		g.drawString("OPTIONS", Game.WIDTH/2 - 100, 100);
		g.setFont(new Font("Arial", Font.BOLD, 36));
//		g.drawString("Steering: ", 50, 190);
//		g.drawString("Acceleration: ", 50, 250);
//		g.drawString("Top Speed: ", 50, 310);
		
		Font roadMovie = new Font("ROAD MOVIE", Font.PLAIN, 45);
		g.setFont(roadMovie);
		reset.drawButton(g, 10);
//		upControl.drawButton(g, 15);
//		upAcceleration.drawButton(g, 15);
//		upMaxSpeed.drawButton(g, 15);
//		colorRed.drawButton(g, 50);
//		colorBlue.drawButton(g, 50);
//		colorYellow.drawButton(g, 30);
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		back.drawButton(g, 10);
		
//		drawButton(g, play, "Start", 90, Color.GREEN);
//		drawButton(g, upgrade, "Upgrade Car", 15, Color.BLUE);
//		drawButton(g, options, "Options", 65, Color.BLUE);
//		drawButton(g, scoresList, "HighScores", 27, Color.BLUE);
//		drawButton(g, quit, "Quit", 92, Color.RED);
//		drawButton(g, profile, "User", 0, Color.BLUE);
		
		
	}
	
}
