package game.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import game.Camera;
import game.Game;
import game.core.CoreObject;
import game.entity.Player;

public class CarOppositeDirection extends CoreObject{
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
	
	public CarOppositeDirection(float x, float y, int width, int height, int id,BufferedImage img) {
		super(x, y, width, height, id, img);
//		this.setSize(width, height);
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		if(!crashed){
		x += velX; 
		y += velY;
		
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
				if(obj.getId() == 1){
					if(getTopBounds().getMinY() > (obj.getBottomBounds().getMaxY() + (r.nextInt(2500-250) + 250))){
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
//						System.out.println("Left");
//					}
					
				}
					
//				if(getBottomBounds().intersects(obj.getTopBounds()))
//				{
//					velY = 0;
//					//y = obj.getY() - height;
//					//jumping = false;
//				}
//				if(getTopBounds().intersects(obj.getBottomBounds())){
//					velY = 0;
//					velX = 0;
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
		
	}
	private void checkCollision()
	{
		for(CoreObject obj : gameObjects)
		{
			if(obj.getId() != 12 && obj.getId() != 13 && obj.getId() != 1){
				if(getBottomBounds().intersects(obj.getTopBounds()))
				{
					setY(obj.getY()-200);
				}
			}
		}
//			if(obj instanceof Player)
//			{
//				if(obj.getId() == 1){
//					if(getRightBounds().intersects(obj.getLeftBounds())){
//						velX = 0;
//						velY = 0;
//						crashed = true;
//						
//						
//					}
//					else if(getLeftBounds().intersects(obj.getRightBounds())){
//						velX = 0;
//						velY=0;
//						
//						crashed = true;
//						
//					}
//					
//				}
//			
//			
//				////CHANGE THIS TO FIX PERCISION
//				if(getBottomBounds().intersects(obj.getTopBounds()))
//				{
//					obj.setY(y + obj.getHeight());
//					
//					y = obj.getY() - height;
//					crashed = true;
//				}
//				if(getTopBounds().intersects(obj.getBottomBounds())){
//					obj.setY(y + obj.getHeight());
//					crashed = true;
//					//y = obj.getY() + height;
//				}
//			}
//				if(getBottomBounds().intersects(obj.getTopBounds())){
//					obj.setY(y + obj.getHeight());
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
			}
		
	

	/*
	 * STUFF TO CHANGE FOR PROJECT
	 */
	public void drive() // was "fall"
	{
		if(!crashed){
			velY =  .1f + (float)(Math.random() * ((3 - .1) + 1));
			setVelY(velY);
			if(tickCount % 95 == 0 || tickCount % 70 == 0){
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




