package game.entity;

import game.core.CoreObject;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class NonMovingBack extends CoreObject{

	private Player player;
	//private boolean moving = false;
	
	//private Animation animeRight;
	
	public NonMovingBack(float x, float y, int width, int height, int id, BufferedImage lines){
		super(x, y, width, height, id, lines);
		
		
	}

	

	@Override
	public void tick() {
		
//		if(moving)
//			animeRight.runAnimation();
//		
	}

	@Override
	public void render(Graphics g) {
//		if(!moving){
//			g.drawImage(tex.water, (int)x, (int)y, null);
//		}
		g.drawImage(image, (int)x, (int)y, width, height, null);
//		if(moving)
//			animeRight.drawAnimation(g, x, y);
	}

}