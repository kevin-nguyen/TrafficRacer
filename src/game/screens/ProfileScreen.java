package game.screens;

import game.Game;
import game.entity.Player;
import game.libs.Reference;
import game.utils.Button;
import game.utils.files.TextFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfileScreen{

public Button back, changeName;


private String name;


	public ProfileScreen()
	{

		back = new Button(Reference.CENTER_X - 350 , 450, 90, 50).setText("BACK");
		changeName = new Button(Reference.CENTER_X - 45, Reference.CENTER_Y + 100, 150, 50).setText("Change Name");

		
		


		
	}
	

	//creates and draws the menu button names 
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
	
		//g.drawImage(ImageIO.read(new File(Reference.SPRITE_LOCATION + "gameWater.png")), 0, 0);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.BOLD, 48));
		g.drawString(getName() + "'s Profile", Game.WIDTH/2 - 200, 100);
		g.setFont(new Font("Arial", Font.BOLD, 36));
		g.drawString("Player Name: " + getName(), 50, 250);
		g.drawString("Current Cash: $" + Player.getCash(), 50, 300);
		

		
		Font roadMovie = new Font("ROAD MOVIE", Font.PLAIN, 45);
		g.setFont(roadMovie);
		

		g.setFont(new Font("Arial", Font.PLAIN, 24));
		back.drawButton(g, 10);
		changeName.drawButton(g, 0);
		

	}
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
}
