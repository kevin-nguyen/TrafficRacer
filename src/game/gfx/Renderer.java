package game.gfx;


import game.Controller;
import game.Game;
import game.enums.GameState;
import game.libs.Identities;
import game.libs.Reference;
import game.objects.Block;
import game.screens.Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Renderer {

	
	
	public void renderBackground(Graphics g)
	{
		
	
		switch(Game.state)
		{
		case GAME:
			//Game.getInstance().getController().render(g);
			break;
		case MENU:
			Game.getInstance().getMenu().render(g);
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		case SCORES:
			break;
		case UPGRADE:
			
			break;
		case PROFILE:
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UNKNOWN GAMESTATE", 150, 150);
			break;
		
		}
		
	}
	
	public void renderForeground(Graphics g)
	{
		switch(Game.state){
		case GAME:
			Game.getInstance().getController().render(g);

			break;
		case MENU:
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
			g.setColor(Color.RED);
			g.drawString("UNKNOWN GAMESTATE", 150, 150);
			break;
		
		}
		
		
	}

	public void renderOther(Graphics g)
	{
		switch(Game.state){
		case GAME:
			break;
		case LOADING:
			break;
		case MENU:
			break;
		case OPTIONS:
			Game.getInstance().getOptions().render(g);
			break;
		case PAUSE:
			Game.getInstance().getPauseScreen().render(g);
			break;
		case CRASH:
			Game.getInstance().getCrashScreen().render(g);
			
			break;
		case PROFILE:
			Game.getInstance().getProfileScreen().render(g);
			break;
		case SCORES:
			Game.getInstance().getHighScoreScreen().render(g);
			break;
		case UPGRADE:
			Game.getInstance().getUpgradeScreen().render(g);
			break;
		default:
			break;
		
		}
	}
}
