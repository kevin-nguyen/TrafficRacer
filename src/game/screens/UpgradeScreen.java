package game.screens;

import game.Game;
import game.entity.Player;
import game.libs.Images;
import game.libs.Reference;
import game.utils.Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class UpgradeScreen {


	public Button upControl, upAcceleration, upMaxSpeed, colorRed, colorBlue, bugatti, sesto, back, moneyLeft;
	
	//private int centerX = Game.WIDTH / 2;
	//private static int centerY = Game.HEIGHT / 2;
	
	//creates menu rectangle shapes
	public UpgradeScreen()
	{
		int fillerY = 110;
		upControl = new Button(Reference.CENTER_X , fillerY, 50, 50).setText("+");
		upAcceleration  = new Button(Reference.CENTER_X , fillerY+= 60, 50, 50).setText("+");
		upMaxSpeed  = new Button(Reference.CENTER_X , fillerY+= 60, 50, 50).setText("+");
		colorRed  = new Button(310 , 290, 50, 50).setText("");
		colorBlue  = new Button(210 , 290, 50, 50).setText("");
		bugatti  = new Button(250 , 375, 50, 50).setText("");
		sesto  = new Button(475 , 375, 50, 50).setText("");
		back = new Button(Reference.CENTER_X - 350 , fillerY + 220, 90, 50).setText("BACK");
		moneyLeft = new Button(Reference.CENTER_X + 100, 100, 200, 50).setText("$" + String.valueOf(Player.getCash()));
		
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
		
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial", Font.BOLD, 48));
		g.drawString("THE GARAGE", Game.WIDTH/2 - 150, 50);
		g.setFont(new Font("Arial", Font.BOLD, 36));
		g.drawString("Steering: ", 50, 150);
		g.drawString("Acceleration: ", 50, 210);
		g.drawString("Top Speed: ", 50, 270);
		g.drawString("Paint:", 50, 330);
		g.drawString("Blue", 200, 370);
		g.drawString("Red", 300, 370);
		g.drawString("Rare:", 50, 410);
		g.drawString("Bugatti", 210, 460);
		g.drawString("Sesto Elemento", 400, 460);
		g.drawString("Cash Left", Reference.CENTER_X + 110, 100);
		
		
		upControl.drawButton(g, 15);
		upAcceleration.drawButton(g, 15);
		upMaxSpeed.drawButton(g, 15);
		colorRed.drawButton(g, 10);
		colorBlue.drawButton(g, 10);
		bugatti.drawButton(g, 10);
		sesto.drawButton(g, 10);
		moneyLeft.drawButton(g, 10);
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		back.drawButton(g, 10);
		g.setFont(new Font("Arial", Font.PLAIN, 16));
		g.drawString("$500", Reference.CENTER_X - 50, 150);
		g.drawString("$500", Reference.CENTER_X - 50, 200);
		g.drawString("$500", Reference.CENTER_X - 50, 260);

		
	}
}
