package game.gfx;

import java.awt.image.BufferedImage;

import game.libs.Images;
import game.utils.SpriteSheet;

public class Textures {

	private SpriteSheet sheetTest;
	
	public BufferedImage blockStone;
	public BufferedImage blockMetal;
	public BufferedImage blockStreet;
	public BufferedImage blockLines;
	public BufferedImage blockTwoX;
	public BufferedImage water;
	public BufferedImage waterFlow[] = new BufferedImage[4];
	
	public Textures()
	{
		sheetTest = new SpriteSheet(Images.spritesheetTest, 32);
		
		initTextures();
	}
	
	
	private void initTextures()
	{
		blockStone = sheetTest.getSprite(1, 1);
		blockMetal = sheetTest.getSprite(2, 1);
		blockStreet = sheetTest.getSprite(3, 1);
		blockLines = sheetTest.getSprite(4, 1);
		blockTwoX = sheetTest.getSprite(5, 1);
		
		waterFlow[0] = sheetTest.getSprite(7,1);
		waterFlow[1] = sheetTest.getSprite(8, 1);
		waterFlow[2] = sheetTest.getSprite(7, 1);
		waterFlow[3] = sheetTest.getSprite(8, 1);
		
	}
	
}
