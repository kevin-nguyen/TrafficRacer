package game.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;













import java.util.Scanner;
import java.util.Timer;

import game.Game;
import game.Window;
import game.core.CoreObject;
import game.enums.GameState;
import game.gfx.Textures;
import game.input.KeyInput;
import game.input.MouseInput;
import game.libs.Audio;
import game.libs.Reference;
import game.objects.Block;
import game.objects.CarObstacle;
import game.objects.CarOppositeDirection;
import game.objects.Meteorite;
import game.screens.HighScoreScreen;
import game.utils.AudioPlayer;
import game.utils.BufferedImageLoader;
import game.utils.Button;
import game.utils.files.TextFile;

public class Player extends CoreObject{

	private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
	
	/*
	 * STUFF TO CHANGE FOR PROJECT
	 */
	

	private static int upGradedX;
	private static float upGradedAccel;
	private static int upGradedTopSpeed;
	private boolean crashed = false;
	private static int points = 0;
	public int currentHighScore;
	public static int [] highScores = new int[3];
	
	//private boolean timesTwo = false;
	private static HighScoreScreen scoreScreen;
	public static String score1, score2, score3;
	private Game game;
	private static String thecar;
	public static BufferedImage image;
	private int tickCounter = 0;
	//public Button pause;
	private int miles = 0;
	private static int cash = Integer.parseInt(TextFile.readFile("./savedCash.txt"));
	
	/////////////////////////////////
	
	public Player(float x, float y, int width, int height, int id,Textures tex) {
		super(x, y, width, height, id, tex);
//		this.setSize(width, height);
		
		
		// TODO Auto-generated constructor stub
	}
	public Player(float x, float y, int width, int height, int id,BufferedImage image) {
		super(x, y, width, height, id, image);
		
		
		
		// TODO Auto-generated constructor stub
	}

	

	// happens multiple times per second
	@Override
	public void tick() {
		if(crashed == false){ 
			x += velX; //maybe + upGradedX
			y += (velY + getAccelerate());
		
			drive(); // moves the player forward automatically increases speed with number of points
			checkCollision(); // checks to see if the player has hit any of the car objects
			
		
		
			
			miles = Math.abs((int)(y/5000)); // produces integer of total miles driven
			
			// adds one point each second player is playing, adds two points if in the left two lanes
			if((System.currentTimeMillis() - MouseInput.timer) > 1000)
			{
				if(getX() < 250)
					MouseInput.timer+=500;
				else
					MouseInput.timer+=1000;
				
				addPoints();
			}
			
			
			
		}
		//stuff that happens when the player crashes
		else if(crashed){
			currentHighScore = points;
	//		TextFile.writeFile("./highscores.txt", currentHighScore + "\n");
	//		setScores(currentHighScore);
			Game.state = GameState.CRASH; // goes to crash screen
			//highScores = scoreScreen.getScores();
			setCash(points * 2);
			TextFile.writeFile("./savedCash.txt", String.valueOf(cash));
			AudioPlayer.stopMusic(Audio.MUSIC_SHOOT); // music stops
			AudioPlayer.stopSound(Audio.SOUND_REV);
			setHighScore(currentHighScore);
			crashed = false; // resets the crashed variable to false for the next game

		}
		
	}
	

	//loads initial player image if none other selected
	static BufferedImageLoader loader = new BufferedImageLoader();{
	try{
	image = loader.loadImage(getCar());
	}catch(IOException e){
		try {
			image = loader.loadImage("rsz_lamborghini-redBlue-car-top.png"); // tries to load this car if selection isnt working
		} catch (IOException e1) { //if it doesnt work it throws error
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	}
	@Override
	public void render(Graphics g) {
		

		g.drawImage(image, (int)x, (int)y, null);  // draws car image
		
		//creates the on-screen HUD
		g.drawRect(Game.WIDTH - 130, (int)y - 325, 100, 50);
		g.setColor(Color.RED);
		g.setFont(new Font("Verdana", Font.BOLD, 36));
		g.drawString(Integer.toString(miles) + " miles", Game.WIDTH -90, (int)y - 280);
		g.drawString("MPH: " + Float.toString(Math.abs(getAccelerate()*10)), Game.WIDTH-200, (int)y - 240);
		g.setColor(Color.GREEN);
		g.setFont(new Font("Verdana", Font.BOLD, 24));
		
		g.drawString("2x POINTS", (Game.WIDTH/2) - 250, (int)y +30);
		
//		pause = new Button((Reference.CENTER_X/2)- 150, (int)getY(), 50, 50).setText("Pause");
//		pause.drawButton(g, 10);
		
//		g.drawRect((int)x + 11, (int)y, width-22, height-10); //top
//		g.drawRect((int)x + 11, (int)y + (height - 6), width-22, 6); // bottom
//		g.drawRect((int)x + (width-11), (int)y+5, 6, height-10);
//		g.drawRect((int)x+5, (int)y+5, 6, height-10);
		//g.drawRect((int)x, (int)y, width, height);
	}
	private void checkCollision()
	{
		for(CoreObject obj : gameObjects)
		{
			if(obj instanceof Block)
			{
				if(obj.getId() == 12){
					if(getRightBounds().intersects(obj.getRightBounds())){
						velX = 0;
						x = (obj.getX() + (obj.getWidth() -50));
						
						
					}
					else if(getLeftBounds().intersects(obj.getLeftBounds())){
						velX = 0;
						x = obj.getX() + 2;
						
						
					}
					
				}
			}
			else if(obj instanceof CarObstacle)
			{
				if(getTopBounds().intersects(obj.getBottomBounds())){
			
					velY =0;
					velX =0;
					obj.setVelY(0);
					obj.setVelX(0);
					crashed = true;
					//y = obj.getY() + height;
					
				}
				if(getTopBounds().intersects(obj.getTopBounds())){
					velY = 0;
					velX = 0;
					obj.setVelY(0);
					obj.setVelX(0);
					crashed = true;
				}
//				if(getBottomBounds().intersects(obj.getTopBounds())){
//					velY = 0;
//					obj.setVelY(0);
//					crashed = true;
//				}
				
				//////////////////////WORK HERE!
				if(getRightBounds().intersects(obj.getLeftBounds())){
					//velY +=2;
					//velX += 1;
					obj.setVelY(0);
					obj.setVelX(0);
					if(getAccelerate() > -1){
						//if(obj.getX() < 450){
							obj.setX(getX() + getWidth() + 10);
						}
						//else{
						//	velX = 0;
						//	obj.setX(451);
						//	setX(400);
					//	}
					//}
					else
						crashed = true;
				}
				
				if(getLeftBounds().intersects(obj.getRightBounds())){
					//velY +=2;
					//velX -= 1;
					obj.setVelY(0);
					obj.setVelX(0);
					if(getAccelerate() > -1){
						//if(obj.getX() > 250){
							obj.setX(getX() - obj.getWidth() - 10);
							
						}
//						else{
//							velX = 0;
//							obj.setX(259);
//							setX(308);
//						}
//					}
					else
						crashed = true;
				//}
				
				
			}
			}
			else if(obj instanceof CarOppositeDirection)
			{
				if(getTopBounds().intersects(obj.getBottomBounds())){
					velY = 0;
					velX = 0;
					obj.setVelY(0);
					crashed = true;
					//y = obj.getY() + height;
				}
				if(getBottomBounds().intersects(obj.getTopBounds())){
					velY = obj.getVelY();
					obj.setVelY(0);
					crashed = true;
					
				}
				if(getRightBounds().intersects(obj.getLeftBounds())){
					velY -=2;
					velX -=1;
					obj.setVelY(0);
					obj.setVelX(0);
					obj.setX(getX() + getWidth() + 10);
					crashed = true;
				}
				
				if(getLeftBounds().intersects(obj.getRightBounds())){
					velY -= 2;
					velX += 1;
					obj.setVelY(0);
					obj.setVelX(0);
					obj.setX(getX() - obj.getWidth() - 10);
					crashed = true;
				}
				
			}
			
			else if(obj instanceof Meteorite){
				if(getTopBounds().intersects(obj.getBottomBounds())){
					
					velY = 0;
					velX = 0;
					crashed = true;
				}
				else if(getRightBounds().intersects(obj.getLeftBounds())){
					
					velY = 0;
					velX = 0;
					crashed = true;
					
				}
				
				else if(getLeftBounds().intersects(obj.getRightBounds())){
					
					velY = 0;
					velX = 0;
					crashed = true;
					
				}
			}
					

			}
		}
	
		
	

	public void drive() // was "fall"
	{
		if(!crashed){
			//setVelY(-5);
			//velY += gravity;
			velY = -1;
		}
	}
	
//	public void score(Graphics g){
//		g.setColor(Color.BLUE);
//		g.setFont(new Font("Arial", Font.PLAIN, 24));
//		g.drawString("Score: 000", Reference.CENTER_X + 200, 50);
//	}
	
	public void addPoints()
	{
		
		if(!crashed){

			points++;
//			if(getX() < 240){
//				points+= 2;
//			
//			}
			
			
			
			}
		}
	
	
	

	public static void getScores(){
		
		score1 = TextFile.readFile("highscore1.txt");
		score2 = TextFile.readFile("highscore2.txt");
		score3 = TextFile.readFile("highscore3.txt");

	}
	
	public static void setHighScore(int score){
		
		int holder;
		getScores();
		
		highScores[0] = Integer.parseInt(score1);
		highScores[1] = Integer.parseInt(score2);
		highScores[2] = Integer.parseInt(score3);
		
		for(int k = 0; k < highScores.length; k++){
			
			if(score > highScores[k]){
				holder = highScores[k];
				highScores[k] = score;
				score = holder;
			}
		}
		
		TextFile.writeFile("highscore1.txt", String.valueOf(highScores[0]));
		TextFile.writeFile("highscore2.txt", String.valueOf(highScores[1]));
		TextFile.writeFile("highscore3.txt", String.valueOf(highScores[2]));
		
		
	}
	
//	public static void setScores(int currentHighScore){
//		String fillerScore;
//		try{
//		for(int j = 0; j < highScores.length; j++){
//			if(currentHighScore > Integer.parseInt(highScores[j])){
//				fillerScore = highScores[j];
//				highScores[j] = String.valueOf(currentHighScore);
//				
//				currentHighScore = Integer.parseInt(fillerScore);
//				
//			}
//		}
////		scoreScreen.score1.setText(highScores[0]);
////		scoreScreen.score2.setText(highScores[1]);
////		scoreScreen.score3.setText(highScores[2]);
//				}catch(NumberFormatException e){ e.printStackTrace();}
//			
//		
//		
//		
//		
//	}
//	
	

	
	public static BufferedImage getImage(){
		return image;
	}
	
	public static void setImage(String car){
		try {
			image = loader.loadImage(car);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setCar(String car){
		thecar = car;
	}
	
	public String getCar(){
		return thecar;
	}
	
	public boolean getCrashed(){
		return crashed;
	}
	
	public float getY(){
		return y;
	}
	public float getVelX(){
		return velX + Player.getUpgradedX();
	}
	
	public float getX(){
		return x;
	}

	public static void setUpgradedX(int num){
		upGradedX += num;
	}
	
	public static int getUpgradedX(){
		return upGradedX;
	}
	
	public static void startSteering(int num){
		upGradedX = num;
	}
	
	public static void setUpgradedAccel(float num){
		upGradedAccel += num;
	}
	
	public static void startAcceleration(float num){
		upGradedAccel = num;
	}
	
	public static float getUpgradedAccel(){
		return upGradedAccel;
	}

	public static void setUpgradedTopSpeed(int num)
	{
		upGradedTopSpeed += num;
	}
	
	public static int getUpgradedTopSpeed(){
		return upGradedTopSpeed;
	}
	
	public static void startTopSpeed(int num){
		upGradedTopSpeed = num;
	}
	
	public static int getPoints() {
		return points;
	}
	

	public void setPoints(int thepoints) {
		points = thepoints;
	}

//	public void saveScore(int points){
//		
//		if(TextFile.readFile("highscores.txt") != null){
//			Scanner cin = new Scanner(TextFile.getLine());
//		for(int i = 0; i < highScores.length; i++){
//			highScores[i] = cin.nextLine();
//		}
//		for(int k = 0; k < highScores.length; k++){
//			if(Integer.parseInt(currentHighScore) > Integer.parseInt(highScores[k])){
//				placeHolder = highScores[k];
//				highScores[k] = currentHighScore;
//				currentHighScore = placeHolder;
//				
//			}
//		}
//		cin.close();
//	}
//	else{
//		TextFile.writeFile("highscores.txt", currentHighScore);
//	}
//	}
//	
	public static int getCash() {
		return cash;
	}
	public static void setCash(int thecash) {
		cash += thecash;
	}
	public static void resetCash(int thecash){
		cash = thecash;
	}
	public static void drainCash(){
		cash = 0;
		TextFile.writeFile("./savedCash.txt", "0");
	}
	public int getMiles() {
		return miles;
	}
	public void setMiles(int miles) {
		this.miles = miles;
	}
	public void setCurrentHighScore(int current) {
		currentHighScore = current;
	}
}
