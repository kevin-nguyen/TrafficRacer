package game;

import game.core.CoreObject;
import game.entity.Player;
import game.objects.CarObstacle;
import game.objects.CarOppositeDirection;
import game.objects.Meteorite;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Controller {

	private ArrayList<CoreObject> objects = new ArrayList<CoreObject>();
	private Random r = new Random();
	private Player player;
	
	public void tick()
	{
		for(CoreObject obj : objects)
		{
			obj.tick();
		}
	}
	

	public void render(Graphics g)
	{
		for(CoreObject obj: objects)
		{
			obj.render(g);
		}
	}
	
	public void addObject(CoreObject instance)
	{
		objects.add(instance);
		
	}
	
	public void removeObject(CoreObject instance)
	{
		objects.remove(instance);
	}
	
	public ArrayList<CoreObject> getObjects()
	{
		return objects;
	}
	
	public void reload()
	{
		for(CoreObject obj: objects)
		{
			if(obj instanceof CarObstacle || obj instanceof CarOppositeDirection || obj instanceof Meteorite){
				obj.setY(400); //obj.getY() -
			}
			else{
				obj.setY(0);
			}
		}
	}
	
}
