package game.input;

import game.Game;
import game.entity.Player;
import game.enums.GameState;
import game.libs.Audio;
import game.screens.CrashScreen;
import game.screens.HighScoreScreen;
import game.screens.Menu;
import game.screens.OptionScreen;
import game.screens.PauseScreen;
import game.screens.ProfileScreen;
import game.screens.UpgradeScreen;
import game.utils.AudioPlayer;

















import game.utils.files.TextFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MouseInput extends MouseAdapter {

	/*
	 * true if mouse button pressed
	 */
	public static boolean pressed = false;
	
	public static int MOUSE_X, MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);
	
	private Menu menu = Game.getInstance().getMenu();
	private UpgradeScreen upgrade = Game.getInstance().getUpgradeScreen();
	private Player player = Game.getInstance().getPlayer();
	private CrashScreen crash = Game.getInstance().getCrashScreen();
	private Game game = Game.getInstance();
	private OptionScreen option = Game.getInstance().getOptions();
	private ProfileScreen profile = Game.getInstance().getProfileScreen();
	private HighScoreScreen scores = Game.getInstance().getHighScoreScreen();
	private PauseScreen pause = Game.getInstance().getPauseScreen();
	public static long timer;
	public boolean bugattiBought = false;
	public boolean sestoBought = false;
	@Override
	public void mouseClicked(MouseEvent e) {
		int mouse = e.getButton();
		Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);
		
		
		if(mouse == MouseEvent.BUTTON1)
		{
			switch(Game.state)
			{
			case GAME:
//				if(rect.intersects(player.pause))
//				{
//					Game.state = GameState.PAUSE;
//				}
				break;
			case MENU:
				if(rect.intersects(menu.play))
				{
					
					AudioPlayer.playSound(Audio.SOUND_REV);
					
					Game.state = GameState.GAME;
					timer = System.currentTimeMillis();
					
					if(Float.parseFloat(TextFile.readFile("startAcceleration.txt"))*10 > 0){
						player.startAcceleration(Float.parseFloat(TextFile.readFile("startAcceleration.txt")));
					}
					
					if(Integer.parseInt(TextFile.readFile("startSteering.txt")) > 0){
						Player.startSteering(Integer.parseInt(TextFile.readFile("startSteering.txt")));
					}
					
					if(Integer.parseInt(TextFile.readFile("startTopSpeed.txt")) > 0){
						Player.startTopSpeed(Integer.parseInt(TextFile.readFile("startTopSpeed.txt")));
					}
					
					
					
					AudioPlayer.playMusic(Audio.MUSIC_SHOOT);
					
					
				}
				else if(rect.intersects(menu.upgrade))
				{
					AudioPlayer.playSound(Audio.SOUND_REV); // plays rev sound when upgrade menu clicked
					if(Integer.parseInt(TextFile.readFile("./bugattiBought.txt")) == 1){
						bugattiBought = true;
					}
					if(Integer.parseInt(TextFile.readFile("./sestoBought.txt")) == 1){
						sestoBought = true;
					}
					
					if(Float.parseFloat(TextFile.readFile("startAcceleration.txt")) > 0){
						player.startAcceleration(Float.parseFloat(TextFile.readFile("startAcceleration.txt")));
						if(Float.parseFloat(TextFile.readFile("startAcceleration.txt")) > .9){
							upgrade.upAcceleration.setText("X");
							
						}
						else{
							upgrade.upAcceleration.setText(String.valueOf((int)(Float.parseFloat(TextFile.readFile("startAcceleration.txt"))*10)));
						}
					}
					
					if(Integer.parseInt(TextFile.readFile("startSteering.txt")) > 0){
						Player.startSteering(Integer.parseInt(TextFile.readFile("startSteering.txt")));
						if(Integer.parseInt(TextFile.readFile("startSteering.txt")) != 7){
							upgrade.upControl.setText(String.valueOf(Integer.parseInt(TextFile.readFile("startSteering.txt"))));
						}
						else{
							upgrade.upControl.setText("X");
						}
					}
					
					if(Integer.parseInt(TextFile.readFile("startTopSpeed.txt")) > 0){
						Player.startTopSpeed(Integer.parseInt(TextFile.readFile("startTopSpeed.txt")));
						if(Integer.parseInt(TextFile.readFile("startTopSpeed.txt")) != 6){
							upgrade.upMaxSpeed.setText(String.valueOf(Integer.parseInt(TextFile.readFile("startTopSpeed.txt"))));
						}
						else{
							upgrade.upMaxSpeed.setText("X");
						}
					}
					
					
					Game.state = GameState.UPGRADE;
					
				}
				else if(rect.intersects(menu.scoresList))
				{
					Player.getScores();
					scores.setName(TextFile.readFile("./playerName.txt"));
					AudioPlayer.playSound(Audio.SOUND_REV);
					//String [] theScores = scores.getScores();
					scores.score1.setText(Player.score1);
					scores.score2.setText(Player.score2);
					scores.score3.setText(Player.score3);
					Game.state = GameState.SCORES;
				}
				else if(rect.intersects(menu.options))
				{
					AudioPlayer.playSound(Audio.SOUND_REV);
					
					Game.state = GameState.OPTIONS;
				}
				else if(rect.intersects(menu.profile))
				{
					AudioPlayer.playSound(Audio.SOUND_REV);
					profile.setName(TextFile.readFile("./playerName.txt"));
					System.out.println(TextFile.readFile("./playerName.txt"));
					Game.state = GameState.PROFILE;
				}
				else if(rect.intersects(menu.quit))
				{
					
						Game.exit();
				}
				break;
			case OPTIONS:
				if(rect.intersects(option.back)){
					
					Game.state = GameState.MENU;
				}
				else if(rect.intersects(option.reset)){
					
					final JFrame newFrame = new JFrame();
					JButton ok = new JButton("RESET");
					
					JButton cancel = new JButton("Cancel");
					newFrame.setSize(Game.WIDTH/2, Game.HEIGHT/2);
					newFrame.setTitle("RESET GAME");
					JPanel panel = new JPanel();
					panel.setBackground(Color.WHITE);
					panel.setSize(Game.WIDTH/2, Game.HEIGHT/2);
					final JLabel name = new JLabel("ARE YOU CERTAIN YOU WANT TO RESET THE ENTIRE GAME?!?");
					ok.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							bugattiBought = false;
							sestoBought = false;
							Player.resetCash(0);
							Player.setUpgradedAccel(0);
							Player.setUpgradedTopSpeed(0);
							Player.setUpgradedX(0);
							upgrade.moneyLeft.setText("$0");
							player.startAcceleration(0);
							Player.startSteering(0);
							Player.startTopSpeed(0);
							upgrade.upAcceleration.setText("+");
							upgrade.upControl.setText("+");
							upgrade.upMaxSpeed.setText("+");
							upgrade.colorBlue.setText("");
							upgrade.colorRed.setText("");
							upgrade.bugatti.setText("");
							upgrade.sesto.setText("");
							TextFile.writeFile("savedCash.txt", "0");
							TextFile.writeFile("bugattiBought.txt", "0");
							TextFile.writeFile("sestoBought.txt", "0");
							TextFile.writeFile("startAcceleration.txt", "0");
							TextFile.writeFile("startSteering.txt", "0");
							TextFile.writeFile("startTopSpeed.txt", "0");
							TextFile.writeFile("highscore1.txt", "0");
							TextFile.writeFile("highscore2.txt", "0");
							TextFile.writeFile("highscore3.txt", "0");
						
							
							newFrame.dispose();
						}
					});
					cancel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							newFrame.dispose();
							
						}
					});
					panel.setSize(Game.WIDTH, Game.HEIGHT);
					panel.add(name);
					panel.add(ok);
					panel.add(cancel);
					newFrame.add(panel);
					newFrame.setFocusable(false);
					newFrame.setResizable(false);
					
					newFrame.setLocationRelativeTo(null);
					
					newFrame.setVisible(true);
					
				
			
					
				}
				break;
			case CRASH:
				if(rect.intersects(crash.mainMenu)){
					
					Game.state = GameState.MENU;
					upgrade.moneyLeft.setText(String.valueOf(Player.getCash()));
					//game.load();
					
					AudioPlayer.stopMusic(Audio.MUSIC_SHOOT);
				}
				else if(rect.intersects(crash.replay)){
					
					//Game.replayer();
					
					Game.state = GameState.GAME;
					AudioPlayer.stopMusic(Audio.MUSIC_SHOOT);
				}
				
				break;
			case PAUSE:
//				if(rect.intersects(player.pause))
//				{
//					Game.state = GameState.GAME;
//				}
				if(rect.intersects(pause.resume)){
					Game.state = GameState.GAME;
					KeyInput.setPaused(false);
				}
				else if(rect.intersects(pause.quit)){
					Game.state = GameState.MENU;
					KeyInput.setPaused(false);
				}
				break;
			case SCORES:
				
				
				if(rect.intersects(upgrade.back)){
					
					Game.state = GameState.MENU;
				}
				
				break;
			case UPGRADE:
				if(rect.intersects(upgrade.upControl))
				{
					if(Player.getCash() >= 500){ // if player has more than 500 dollars
						if(Player.getUpgradedX() < 7){ // and is not fully upgraded
							Player.setUpgradedX(1);	 // upgrades cars control
					upgrade.upControl.setText(String.valueOf(Player.getUpgradedX())); //changes buttons text to upgrade number
					Player.setCash(-500); // takes 500 dollars from players total cash
					upgrade.moneyLeft.setText("$" + String.valueOf(Player.getCash()));
					TextFile.writeFile("startSteering.txt", String.valueOf(Player.getUpgradedX()));
					if(Player.getUpgradedX() == 7)
						upgrade.upControl.setText("X");
					
					TextFile.writeFile("./savedCash.txt", String.valueOf(Player.getCash()));
						}
					}
				}
				else if(rect.intersects(upgrade.upAcceleration))
				{
					if(Player.getCash() >= 500){
						if(Player.getUpgradedAccel() < 1){
							Player.setUpgradedAccel(.1f);
							
					upgrade.upAcceleration.setText(String.valueOf((int)(Player.getUpgradedAccel()*10)));
					Player.setCash(-500);
					upgrade.moneyLeft.setText("$" + String.valueOf(Player.getCash()));
					TextFile.writeFile("startAcceleration.txt", String.valueOf(Player.getUpgradedAccel()));
					if(Player.getUpgradedAccel() >= 1)
						upgrade.upAcceleration.setText("X");
					TextFile.writeFile("./savedCash.txt", String.valueOf(Player.getCash()));
						}
					}
				}
				else if(rect.intersects(upgrade.upMaxSpeed))
				{
					if(Player.getCash() >= 500){
						if(Player.getUpgradedTopSpeed() < 6){
							Player.setUpgradedTopSpeed(1);
					upgrade.upMaxSpeed.setText(String.valueOf(Player.getUpgradedTopSpeed()));
					Player.setCash(-500);
					upgrade.moneyLeft.setText("$" + String.valueOf(Player.getCash()));
					TextFile.writeFile("startTopSpeed.txt", String.valueOf(Player.getUpgradedTopSpeed()));
					if(Player.getUpgradedTopSpeed() == 6)
						upgrade.upMaxSpeed.setText("X");
					TextFile.writeFile("./savedCash.txt", String.valueOf(Player.getCash()));
					}
					}
				}
				else if(rect.intersects(upgrade.colorBlue))
				{
					Player.setImage("rsz_lamborghini-blue-car-top.png");
					upgrade.colorBlue.setText("X");
					upgrade.colorRed.setText("");
					upgrade.bugatti.setText("");
					upgrade.sesto.setText("");
				}
				else if(rect.intersects(upgrade.colorRed))
				{
					Player.setImage("rsz_lamborghini-redBlue-car-top.png");
					upgrade.colorBlue.setText("");
					upgrade.colorRed.setText("X");
					upgrade.bugatti.setText("");
					upgrade.sesto.setText("");
				}
				else if(rect.intersects(upgrade.bugatti))
				{
					if(bugattiBought){
						Player.setImage("rsz_bugatti.png");
						upgrade.colorBlue.setText("");
						upgrade.colorRed.setText("");
						upgrade.bugatti.setText("X");
						upgrade.sesto.setText("");
					}
					else if(!bugattiBought && Player.getCash() >= 5000){
					Player.setImage("rsz_bugatti.png");
					upgrade.colorBlue.setText("");
					upgrade.colorRed.setText("");
					upgrade.bugatti.setText("X");
					upgrade.sesto.setText("");
					Player.setCash(-5000);
					upgrade.moneyLeft.setText("$" + String.valueOf(Player.getCash()));
					bugattiBought = true;
					if(bugattiBought){
						TextFile.writeFile("./bugattiBought.txt", "1");
					}
					}
					
				}
				else if(rect.intersects(upgrade.sesto))
				{
					if(sestoBought){
						Player.setImage("rsz_sestoelemento.png");
						upgrade.colorBlue.setText("");
						upgrade.colorRed.setText("");
						upgrade.bugatti.setText("");
						upgrade.sesto.setText("X");
					}
					else if(!sestoBought && Player.getCash() >= 20000){
					Player.setImage("rsz_sestoelemento.png");
					upgrade.colorBlue.setText("");
					upgrade.colorRed.setText("");
					upgrade.bugatti.setText("");
					upgrade.sesto.setText("X");
					Player.setCash(-20000);
					upgrade.moneyLeft.setText("$" + String.valueOf(Player.getCash()));
					sestoBought = true;
					if(sestoBought){
						TextFile.writeFile("./sestoBought.txt", "1");
					}
					}
				}
				else if(rect.intersects(upgrade.back)){
					
					Game.state = GameState.MENU;
				}
				break;
			case PROFILE:
				if(rect.intersects(profile.back)){
					
					Game.state = GameState.MENU;
				}
				else if(rect.intersects(profile.changeName)){
					
					final JFrame newFrame = new JFrame();
					JButton ok = new JButton("OK");
					
					JButton cancel = new JButton("Cancel");
					newFrame.setSize(Game.WIDTH/2, Game.HEIGHT/2);
					newFrame.setTitle("Name Input");
					JPanel panel = new JPanel();
					panel.setBackground(Color.WHITE);
					panel.setSize(Game.WIDTH/2, Game.HEIGHT/2);
					final JTextField nameBox = new JTextField(10);
					ok.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							profile.setName(nameBox.getText());
							scores.setName(nameBox.getText());
							TextFile.writeFile("playerName.txt", nameBox.getText());
							//Player.drainCash();
							newFrame.dispose();
						}
					});
					cancel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							newFrame.dispose();
							
						}
					});
					panel.setSize(Game.WIDTH, Game.HEIGHT);
					panel.add(nameBox);
					panel.add(ok);
					panel.add(cancel);
					newFrame.add(panel);
					newFrame.setFocusable(false);
					newFrame.setResizable(false);
					
					newFrame.setLocationRelativeTo(null);
					
					newFrame.setVisible(true);
					
				}
				break;
			default:
				break;
			
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		pressed = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		pressed = false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
		
	}
	
}
