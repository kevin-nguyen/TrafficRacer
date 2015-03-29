package game.screens;

import game.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class LoadScreen {

	private static int width = 620;
	private static int numResources = 8;
	private static int loadAdd = width / numResources;
	private static int loadStatus = 0;
	
	private static String msg = "Loading resources...";
	
	
	public static void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial", Font.BOLD, 36));
		g.drawString("MacroHard Games", width/2 - 100, 100);
		g.setColor(Color.RED);
		g.drawRect(49, 399, width, 51);
		g.setFont(new Font("Arial", Font.PLAIN, 18));
		g.drawString(msg, 51, 395);
		g.setColor(Color.BLUE);
		g.fillRect(50,400, loadStatus, 50);
		
	}
	
	public static void loadMore()
	{
		loadStatus += loadAdd;
	}
	
	public static void setMessage(String msg)
	{
		LoadScreen.msg = msg;
	}
	
}
