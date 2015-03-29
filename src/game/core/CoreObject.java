package game.core;

import game.gfx.Textures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class CoreObject {

	protected float x, y, velX, velY, accelerate;
	protected int id;
	
	protected int width;
	protected int height;
	
	protected Textures tex;
	
	protected BufferedImage image;
	
	public CoreObject(float x, float y, int width, int height, int id, Textures tex)
	{
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
		this.width = width;
		this.height = height;
	}
	
	public CoreObject(float x, float y, int width, int height, int id, BufferedImage image)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.image = image;
	}
	
	public CoreObject(float x, float y, int id, BufferedImage image)
	{
		this.x = x;
		this.y = y;
		
		this.id = id;
		this.image = image;
		
	}
	
//	public CoreObject(int x, int y, int width, int height, int id, Textures tex)
//	{
//		this.x = x;
//		this.y = y;
//		this.id = id;
//		this.tex = tex;
//		this.width = width;
//		this.height = height;
//		
//	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	public Rectangle getTopBounds()
	{
		return new Rectangle((int)x + 11, (int)y, width-22, height-10); //50
	}

	
	public Rectangle getBottomBounds()
	{
		return new Rectangle((int)x + 11, (int)y + (height - 6), width-22, 6); //50
	}

	public Rectangle getRightBounds()
	{
		return new Rectangle((int)x + (width-11), (int)y + 5, 6, height - 10);
	}
	
	public Rectangle getLeftBounds()
	{
		return new Rectangle((int)x+5, (int)y+5, 6, height-10);
	}
	
	
	/**
	 * @return the x coordinate
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y coordinate
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param velX the velX to set
	 */
	public void setVelX(float velX) {
		this.velX = velX;
	}

	/**
	 * @param velY the velY to set
	 */
	public void setVelY(float velY) {
		this.velY = velY;
	}

	public float getVelY(){
		return this.velY;
	}
	public void setAccelerate(float accelerate){
		this.accelerate = accelerate;
	}
	public void accelerate(float accelerate){
		this.accelerate += accelerate;
	}
	
	
	
	public float getAccelerate(){
		return this.accelerate;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setSize(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
}
