package game.screens;

import game.Game;
import game.entity.Player;
import game.libs.Images;
import game.libs.Reference;
import game.utils.Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PauseScreen {

	private Player player;
	
	public Button resume, quit;
	private boolean paused = false;
	//private int centerX = Game.WIDTH / 2;
	//private static int centerY = Game.HEIGHT / 2;
	
	//creates menu rectangle shapes
	public PauseScreen()
	{
		resume = new Button(100, 200, 50, 50).setText("Resume");
		quit = new Button(100, 255, 50, 50).setText("Quit");
		
	
		
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
		g.drawImage(Images.title, 105, 10, null);
		
		Font roadMovie = new Font("ROAD MOVIE", Font.PLAIN, 45);
		g.setFont(roadMovie);
		
		
		resume.drawButton(g, 70);
		quit.drawButton(g, 70);


		
		
	}
	
	
}
