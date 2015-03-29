package game.utils;

import game.libs.Reference;
import game.screens.LoadScreen;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {

	
	
	//games sound effects
	private static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	
	//games background music
	private static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	//adds sound effect
	public static void addSound(String key, String path)
	{
		LoadScreen.setMessage("Loading sounds from " + Reference.SOUND_LOCATION);;
		try {
			soundMap.put(key, new Sound(Reference.SOUND_LOCATION + path));
		} catch (SlickException e) {
			
			e.printStackTrace();
		}
	}
	
	//adds background music
	public static void addMusic(String key, String path)
	{
		LoadScreen.setMessage("Loading music from " + Reference.SOUND_LOCATION);
		try {
			musicMap.put(key, new Music(Reference.SOUND_LOCATION + path));
		} catch (SlickException e) {
			
			e.printStackTrace();
		}
	}
	
	//returns a sound effect
	public static Sound getSound(String key)
	{
		return soundMap.get(key);
	}
	
	//returns background music
	public static Music getMusic(String key)
	{
		return musicMap.get(key);
	}
	
	//plays sound effect
	public static void playSound(String key)
	{
		soundMap.get(key).play();;
		
	}
	
	public static void loopSound(String key)
	{
		soundMap.get(key).loop(-10, 100);
	}
	
	public static void stopSound(String key)
	{
		soundMap.get(key).stop();
	}
	
	//plays background music
	public static void playMusic(String key)
	{
		musicMap.get(key).loop();
	}
	
	public static void stopMusic(String key)
	{
		musicMap.get(key).stop();
	}
}
