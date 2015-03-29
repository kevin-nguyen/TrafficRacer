package game.screens;

import game.Game;
import game.libs.Reference;
import game.utils.Button;
import game.utils.files.TextFile;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;

import javax.swing.JTextField;

public class HighScoreScreen {

public Button back, score1, score2, score3;
public int highScore1, highScore2, highScore3;
public static String[] high = new String[3];
public static String highScore;
private String name;
	//private int centerX = Game.WIDTH / 2;
	//private static int centerY = Game.HEIGHT / 2;
	
	//creates menu rectangle shapes
	public HighScoreScreen()
	{
		score1 = new Button(Reference.CENTER_X - 100, 100, 300, 50).setText(" ");
		score2 = new Button(Reference.CENTER_X - 100, 175, 300, 50).setText(" ");
		score3 = new Button(Reference.CENTER_X - 100, 250, 300, 50).setText(" ");
		back = new Button(Reference.CENTER_X - 350 , 450, 90, 50).setText("BACK");
	
		//high = getScores();
	}
	

	//creates and draws the menu button names 
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.BOLD, 48));
		//g.drawString("Player Name: " + getName(), Game.WIDTH/2 - 100, 250);
		g.drawString(getName() + "'s HighScores", Game.WIDTH/2 - 150, 100);
		g.setFont(new Font("Arial", Font.BOLD, 36));

		
		Font roadMovie = new Font("ROAD MOVIE", Font.PLAIN, 45);
		g.setFont(roadMovie);
		

		g.setFont(new Font("Arial", Font.PLAIN, 24));
		back.drawButton(g, 10);
		score1.drawButton(g, 10);
		score2.drawButton(g, 10);
		score3.drawButton(g, 10);
		

	}
	
//	public String[] getScores(){
//		int startidx = 0;
//		highScore = TextFile.readFile("./highscores.txt");
//		for(int j = 0; j < 3; j++){
//			for(int k = 0; k < highScore.length(); k++){
//				if(highScore.charAt(k) == ' '){
//					high[j] = highScore.substring(startidx, k);
//					startidx = k +1;
//				}
//			}
//		}
//			return high;
//	
//		
//		
//		
////		for(int k =0; k < high.length(); k++){
////			if(high.charAt(k) == ' '){
////				high1 = high.substring(startidx, k);
////			}
//		
//				
//		}
//		
		
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
		
	}

