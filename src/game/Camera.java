package game;

import game.core.CoreObject;
import game.entity.Player;
import game.entity.RoadDetails;
import game.gfx.Textures;
import game.libs.Identities;
import game.objects.Block;

public class Camera {

	private float x, y;
	private Player player;
//	private Textures tex;
//	private RoadDetails roadLine = new RoadDetails(155, y+400, 400, 600, Identities.ROAD_LINES, tex.blockLines);
//	
//	
	
	public Camera(float x, float y)
	{
		this.x = x;
		this.y = y;
		for(CoreObject obj : Game.getInstance().getController().getObjects()){
			if(obj.getId() == Identities.PLAYER)
				player = (Player) obj;
		}
	}
	
	public void tick()
	{
		y = -player.getY() + Game.HEIGHT -200; // change to lower player
		

		
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}


	
	
	
	
	
}
