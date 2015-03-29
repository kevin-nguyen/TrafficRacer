package game.input;

import game.Game;
import game.core.CoreObject;
import game.entity.Player;
import game.entity.RoadDetails;
import game.enums.GameState;
import game.libs.Audio;
import game.libs.Identities;
import game.utils.AudioPlayer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyInput extends KeyAdapter {

	private Player player;
	
	private Game game;
	
	private boolean spaceDown = false;
	
	private boolean rightDown = false;
	
	private boolean leftDown = false;
	
	private boolean downDown = false;
	
	private static boolean paused = false;
	
//	private boolean[] keyDown = new boolean[4];
	
	private boolean soundPlaying = false;
	
	
	
	ArrayList<Integer> keysDown;
	
	public KeyInput()
	{
		for(CoreObject obj : Game.getInstance().getController().getObjects())
		{
			if(obj.getId() == Identities.PLAYER)
				player = (Player) obj;
			
			
		}
		keysDown = new ArrayList<Integer>();
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		int key = e.getKeyCode();
		
		switch(Game.state)
		{
		case GAME:
			if(key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP){
				spaceDown = true;
			
			}
			
			if(key == KeyEvent.VK_RIGHT){
				rightDown = true;
			}
			
			if(key == KeyEvent.VK_LEFT){
				leftDown = true;
			}
			
			if(key == KeyEvent.VK_DOWN){
				downDown = true;
			}
			
			if(key == KeyEvent.VK_P){
				if(!paused)
					paused = true;
				else
					paused = false;
			}
			
			if(paused){
				Game.state = GameState.PAUSE;
			}

			
			if(spaceDown){
				player.setVelY(-5);
				if(player.getAccelerate() > -10 - Player.getUpgradedTopSpeed())
					player.accelerate(-.1f - Player.getUpgradedAccel());
				//player.setVelY(-.1f);
				if(!soundPlaying){
					AudioPlayer.loopSound(Audio.SOUND_REV);
					soundPlaying = true;
				}
			}
				

				
			if(rightDown){
				player.setVelX(5 + Player.getUpgradedX()); /////////////////////////////////////////trial
//				if(player.getAccelerate() > -10 - Player.getUpgradedTopSpeed())
//					player.accelerate(-.1f - Player.getUpgradedAccel());
//				
					
			}
			
			if(leftDown){
				player.setVelX(-5 - Player.getUpgradedX()); ///////////////////////////////////////trial
				
//				if(player.getAccelerate() > -10 - Player.getUpgradedTopSpeed())
//					player.accelerate(-.1f - Player.getUpgradedAccel());
				
			}
			
			

			

			
			if(spaceDown && rightDown){
				
				player.setVelX(5 + Player.getUpgradedX()); ///////////////////////////////////////trial
				player.setVelY(-5);
				if(player.getAccelerate() > -10 - Player.getUpgradedTopSpeed())
					player.accelerate(-.1f - Player.getUpgradedAccel());
				//player.setVelY(-.1f);
			
			}
			
			if(spaceDown && leftDown){
				
				player.setVelX(-5 - Player.getUpgradedX()); //////////////////////////////////////trial
				player.setVelY(-5);
				if(player.getAccelerate() > -10 - Player.getUpgradedTopSpeed())
					player.accelerate(-.1f - Player.getUpgradedAccel());
				//player.setVelY(-.1f);
			}
			
			if((spaceDown && !leftDown) && (spaceDown && !rightDown)){
				
//				player.setVelX(5 + Player.getUpgradedX()); ///////////////////////////////////////trial
				player.setVelY(-5);
				if(player.getAccelerate() > -10 - Player.getUpgradedTopSpeed())
					player.accelerate(-.1f - Player.getUpgradedAccel());
				//player.setVelY(-.1f);
			
			}
			
	
			
			if(downDown && !spaceDown){
				player.setVelY(5);
			}
			
			
			
			
//			if(!keysDown.contains(e.getKeyCode()))
//				keysDown.add(new Integer(e.getKeyCode()));
//			moveRect();

			break;
		case MENU:
//			if(key == KeyEvent.VK_S){
//				AudioPlayer.playSound(Audio.SOUND_REV);
//				Game.state = GameState.GAME;
//			}
			break;
		case OPTIONS:
			break;
		case PAUSE:
			if(key == KeyEvent.VK_P){
				paused = false;
			}
			if(!paused){
				Game.state = GameState.GAME;
			}
			break;
		case PROFILE:
			break;
		case SCORES:
			break;
		case UPGRADE:
			break;
		default:
			break;
		
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		

		int key = e.getKeyCode();
		
		switch(Game.state)
		{
		case GAME:
			if(key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP){
				spaceDown = false;
				
			}
			
			if(key == KeyEvent.VK_RIGHT){
				rightDown = false;
			}
			
			if(key == KeyEvent.VK_LEFT){
				leftDown = false;
			}
			
			if(key == KeyEvent.VK_DOWN){
				downDown = false;
			}
			
			if(!spaceDown){
				
			
				//player.setVelY(0);
				AudioPlayer.stopSound(Audio.SOUND_REV);
				soundPlaying = false;
				
				player.setAccelerate(0);
			}
			
			if(!rightDown){
				player.setVelX(0);
				if(spaceDown){
					if(player.getAccelerate() > -10 - Player.getUpgradedTopSpeed())
						player.accelerate(-.1f - Player.getUpgradedAccel());
				}
			}
			
			if(!leftDown){
				player.setVelX(0);
				if(spaceDown){
					if(player.getAccelerate() > -10 - Player.getUpgradedTopSpeed())
						player.accelerate(-.1f - Player.getUpgradedAccel());
				}
			}
			
			if(!spaceDown && !rightDown){
			//	for(float k = player.getVelY();k < 0.0; k+= 5)
					//player.setVelY(0);
				player.setVelX(0);
				//player.setAccelerate(0);
//				if(player.getAccelerate() < 0)
//					player.accelerate(.5f);
			}
			
			if(!spaceDown && !leftDown){
			//	for(float k = player.getVelY();k < 0.0; k+= 5)
				//	player.setVelY(0);
				player.setVelX(0);
				//player.setAccelerate(0);
//				if(player.getAccelerate() < 0)
//					player.accelerate(.5f);
			}
			
			if(!downDown && !spaceDown){
			//	for(float k = player.getVelY();k < 0.0; k+= 5)
					player.setVelY(0);
					//player.setAccelerate(0);
//					if(player.getAccelerate() < 0)
//						player.accelerate(.5f);
			}
			

			break;
		case MENU:
//			if(key == KeyEvent.VK_S){
//				
//				Game.state = GameState.GAME;
//			}
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		case PROFILE:
			break;
		case SCORES:
			break;
		case UPGRADE:
			break;
		default:
			break;
		}
	}
	
	
	public static boolean isPaused(){
		return paused;
	}


	public static void setPaused(boolean paused) {
		KeyInput.paused = paused;
	}


	public boolean isSpaceDown() {
		return spaceDown;
	}


	public void setSpaceDown(boolean isDown) {
		this.spaceDown = isDown;
	}


	public boolean isRightDown() {
		return rightDown;
	}


	public void setRightDown(boolean rightDown) {
		this.rightDown = rightDown;
	}


	public boolean isLeftDown() {
		return leftDown;
	}


	public void setLeftDown(boolean leftDown) {
		this.leftDown = leftDown;
	}


	public boolean isDownDown() {
		return downDown;
	}


	public void setDownDown(boolean downDown) {
		this.downDown = downDown;
	}

		
	}
	

