package game.entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;






import java.io.IOException;
import java.util.ArrayList;

import javax.swing.RepaintManager;

import game.Game;
import game.core.CoreObject;
import game.libs.Identities;
import game.utils.BufferedImageLoader;


public class RoadDetails extends CoreObject {

	private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
//	private Graphics2D g2d;
//	private Game game;
	private int changeY = 0;
	private Player player;
	
	
	public RoadDetails(float x, float y, int width, int height, int id, BufferedImage lines){
		super(x, y, width, height, id, lines);
		//tick();

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
						
						y = obj.getY() - 600;
						System.out.println("Right");
						
					}

		
	}
			}
		}
	}
	

	
	BufferedImage image;
	
	BufferedImageLoader loader = new BufferedImageLoader();{
	try{
	image = loader.loadImage("theRoadLines.png");
	}catch(IOException e){
		e.printStackTrace();
	}
	}
	

	@Override
	public void render(Graphics g) {
		
		g.drawImage(image, (int)x, (int)y, width, height, null);
		
		}
		
//		int linesX = 155;
//		int linesY = 1;
//		for(int j = 1; j < 551; j += 50){ // loop for road lines going down
//			for(int k = 0; k < 328; k += 82){ // loop for road lines going across
//				g.drawImage( tex.blockLines, linesX + k, linesY + j, 32, 32, null);
//		
//	}
//}
	//}
	
	public float getY(){
		return y;
	}
	
}
