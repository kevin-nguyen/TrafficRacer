package game.utils;

import game.libs.Reference;
import game.screens.LoadScreen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {

	private BufferedImage image;
	
	//buffers and loads the image
	public BufferedImage loadImage(String imagePath) throws IOException
	{
		LoadScreen.setMessage("Loading textures from " + Reference.SPRITE_LOCATION);
		image = ImageIO.read(new File(Reference.SPRITE_LOCATION + imagePath));
		return image;
		
	}
	
	
}
