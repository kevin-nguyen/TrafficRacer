package game.utils;

import game.libs.Audio;
import game.libs.Images;
import game.libs.Reference;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceLoader {

	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	//loads all the images
	public static void loadImages()
	{
		try{
			//loads the title image
			Images.title = imageLoader.loadImage("carRacerTitle.png");
			Images.spritesheetTest = imageLoader.loadImage("32xSpriteSheet.png");
			Images.blueCar = imageLoader.loadImage("rsz_lightblue-car-top.png");
			Images.greenCar = imageLoader.loadImage("rsz_1green-car-top.png");
			Images.redCar = imageLoader.loadImage("rsz_red-sports-car-top-view-hi.png");
			Images.yellowCar = imageLoader.loadImage("rsz_1yellow-car-top.png");
			Images.blackBlueCar = imageLoader.loadImage("bluestripe-car.png");
			Images.blackRedCar = imageLoader.loadImage("rsz_black-car-redstripe-top-view-hi.png");
			Images.ghostCar = imageLoader.loadImage("ghostcar.png");
			Images.popoCar = imageLoader.loadImage("rsz_popo-car-top.png");
			Images.meteor = imageLoader.loadImage("meteorFire.png");
		} catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	

	
	
	
	public static void loadFonts()
	{
		Fonts.addFont(new Fonts("ROADMOVIE TRIAL___.ttf"));
	}
	
	public static void loadSounds()
	{
		AudioPlayer.addSound(Audio.SOUND_REV, "carRevSound.ogg");
		
		AudioPlayer.addMusic(Audio.MUSIC_SHOOT, "8-02_Shoot_to_Thrill.ogg");
		
		//AudioPlayer.addMusic(Audio.MUSIC_BACK, "backInBlack.oog");
	}
}
