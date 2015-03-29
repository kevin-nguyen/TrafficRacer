package game.objects;

import game.Camera;
import game.Game;
import game.core.CoreObject;
import game.entity.Player;
import game.gfx.Textures;
import game.utils.BufferedImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CarObstacle extends CoreObject{
	private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
	private Camera camera;
	float theX = getX();
	long tickCount = 0;
	/*
	 * STUFF TO CHANGE FOR PROJECT
	 */
	//private float gravity = 1;
	private boolean crashed = false;
	private Random r = new Random();

	/////////////////////////////////
	
	public CarObstacle(float x, float y, int width, int height, int id,BufferedImage img) {
		super(x, y, width, height, id, img);
//		this.setSize(width, height);
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		if(!crashed){
		x += velX; 
		y -= velY;
		
		drive();
		offTheScreen();
		checkCollision();
		tickCount++;
		
		}
		
		
	}

	private void offTheScreen()
	{
		for(CoreObject obj : gameObjects)
		{
			if(obj instanceof Player)
			{
				if(obj.getId() == 1){ // if object is Player
					if(getTopBounds().getMinY() > (obj.getBottomBounds().getMinY() + (r.nextInt(2500-250) + 250))){ // if car is behind player by 250-2500
						velX = 0;
						
						y = obj.getY() - 600 - (r.nextInt(100-0) + 100); //redraws it at top
						
						
					
						
					}
					if(getBottomBounds().getMaxY() < obj.getBottomBounds().getMaxY() - 1700){
						
						velX = 0;
						y = obj.getY() - 600 - (r.nextInt(100-0) + 100);
						
						
					}
//					if(getBottomBounds().intersects(obj.getTopBounds())){
//						velX = 0;
//						velY = 0;
//						obj.setVelX(0);
//						obj.setVelY(0);
//						x = obj.getX() + 2;
//						crashed = true;
//						
//					}
//				
//					
//				}
//					
//				if(getBottomBounds().intersects(obj.getTopBounds()))
//				{
//					velY = 0;
//					crashed = true;
//					//y = obj.getY() - height;
//					//jumping = false;
//				}
//				if(getTopBounds().intersects(obj.getBottomBounds())){
//					velY = 0;
//					velX = 0;
//					crashed = true;
//					//y = obj.getY() + height;
//				}
//				if(getBottomBounds().intersects(obj.getTopBounds())){
//					velY = 0;
//					velX = 0;
//					crashed = true;
//				}
//				if(getRightBounds().intersects(obj.getLeftBounds())){
//					velX = 0;
//					velY = 0;
//					x = obj.getX() - 35;
//				}
//				if(getLeftBounds().intersects(obj.getRightBounds())){
//					velX = 0;
//					velY = 0;
//					x = obj.getX() + obj.getWidth() + 4;
				}
			}
		}
		
	}
	

	

	
	@Override
	public void render(Graphics g) {
		
//		g.setColor(Color.WHITE);
//		g.fillRect((int)x,(int)y, 30, 40);
		g.drawImage(image, (int)x, (int)y, null); 
		
		///////////////////////////////////////////////////////////////////
		//change this and put somewhere else
//		if(getY() > camera.getY()){
//			g.drawImage(image, (int)x, (int)y, null);
//			
//		}
		g.drawRect((int)x + 6, (int)y + (height - 6), width-12, 6);
	}
	private void checkCollision()
	{
		for(CoreObject obj : gameObjects)
		{
//			if(obj instanceof Player)
//			{
//				if(obj.getId() == 1){
//					if(getRightBounds().intersects(obj.getLeftBounds())){
//						velX =0;
//						velY = 0;
//						//obj.setVelY(0);
//						
//						if(obj.getAccelerate() > -4){
//							if(getX() > 260){
//								setX(obj.getX() - getWidth() - 10);
//							}
//							else{
//								obj.setVelX(0);
//								setX(259);
//								obj.setX(308);
//							}
//						}
//						else
//							crashed = true;
//						
//					}
//					else if(getLeftBounds().intersects(obj.getRightBounds())){
//						velX = 0;
//						velY = 0;
//					//	obj.setVelY(0);
//						if(obj.getAccelerate() > -4){
//							if(getX() < 450){
//								setX(obj.getX() + obj.getWidth() + 10);
//							}
//							else{
//								obj.setVelX(0);
//								setX(451);
//								obj.setX(402);
//								}
//						}
//						else
//							crashed = true;
//						
//						
//					}
//					
//				}
			/////////////////////////////////////////////////// FIX THIS!!!!
			if(obj.getId() != 12 && obj.getId() != 13 && obj.getId() != 1){
				if(getBottomBounds().intersects(obj.getTopBounds()))
				{
					setY(obj.getY()-200);
				}
				
				
//				if(getTopBounds().intersects(obj.getBottomBounds())){
//					obj.setY(y-2);
//					obj.setVelY(0);
//					crashed = true;
//					//y = obj.getY() + height;
//				}
//				if(getBottomBounds().intersects(obj.getTopBounds())){
//					velY = 0;
//					velX = 0;
//				}
//				if(getRightBounds().intersects(obj.getLeftBounds())){
//					velX = 0;
//					velY = 0;
//					x = obj.getX() - 35;
//				}
//				if(getLeftBounds().intersects(obj.getRightBounds())){
//					velX = 0;
//					velY = 0;
//					x = obj.getX() + obj.getWidth() + 4;
//				}
//			}
//			else if(obj instanceof CarOppositeDirection){
//				if(getTopBounds().intersects(obj.getTopBounds())){
//					
//					obj.setY(y - 100);
//				}
//				
//			}
			
		
		}
		}
	}

	/*
	 * STUFF TO CHANGE FOR PROJECT
	 */
	public void drive() // was "fall"
	{
		
		if(!crashed){
			velY =  .1f + (float)(Math.random() * ((3.5 - .1) + 1));
			setVelY(velY);
			
			//every so often the cars move either a little to left or right at random
			if(tickCount % 85 == 0){
				x = (float)(theX + (-10 + (int)(Math.random() * ((10 + 10) + 1))));
			}
		}

	}
	//////////////////////////////////
	public float getY(){
		return y;
	}

	/*
	 * GONNA CHANGE
	 */



	///////////////////////////
}


