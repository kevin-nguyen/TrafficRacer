package game.screens;

import game.Game;
import game.entity.Player;
import game.libs.Images;
import game.utils.Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class CrashScreen {

	
	public Button mainMenu, replay;
	private Game game;
	
	//private int centerX = Game.WIDTH / 2;
	//private static int centerY = Game.HEIGHT / 2;
	
	//creates menu rectangle shapes
	public CrashScreen()
	{
		mainMenu = new Button(50, Game.HEIGHT - 100, 250, 50).setText("MENU");
		replay = new Button(350, Game.HEIGHT - 100, 250, 50).setText("REPLAY");
		
		//game = new Game();
		payment();
		
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
		g.setColor(Color.BLUE);

		g.setFont(new Font("Arial", Font.BOLD, 48));
		g.drawString("Points = " + Player.getPoints(), Game.WIDTH/2 - 150, Game.HEIGHT - 300);
		g.drawString("Cash Earned = $" + (Player.getPoints() * 2) , Game.WIDTH/2 - 200, Game.HEIGHT - 250);
		
		mainMenu.drawButton(g, 50);
		replay.drawButton(g, 40);


		
		
	}
	
	public static void payment(){
		Player.setCash(Player.getPoints() * 2);	
		
	}

	
	
}
