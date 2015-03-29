package game.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.Camera;
import game.Game;
import game.core.CoreObject;
import game.entity.Player;


public class Block extends CoreObject {

	private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
	
	public Block(float x, float y, int width, int height, int id, BufferedImage image) {
		super(x, y, width, height, id, image);
		
		//this.image = image;
//		this.width = width;
//		this.height = height;
//		this.setSize(width, height);
		
	}

	@Override
	public void tick() {
	
		offScreen();
		
	}
	
	private void offScreen()
	{
		for(CoreObject obj : gameObjects)
		{
			if(obj instanceof Player)
			{
				if(obj.getId() == 1){
					if(getTopBounds().getMinY() > (obj.getBottomBounds().getMaxY() -600)){
						
						y = obj.getY() - 410;
						
						
					}
				}
			}
		}
	}
//					if(getBottomBounds().intersects(obj.getTopBounds())){
//						velX = 0;
//						velY = 0;
//						obj.setVelX(0);
//						obj.setVelY(0);
//						x = obj.getX() + 2;
//						
//						System.out.println("Left");
//					}
//					
//				}
//					
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
//			}
//			}
//		}
//		
//	}
	

	@Override
	public void render(Graphics g) {
	
		g.drawImage(image, (int)x, (int)y, width, height, null);
		
	}
	

}
