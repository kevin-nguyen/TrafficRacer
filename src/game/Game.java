package game;

import game.entity.NonMovingBack;
import game.entity.Player;
import game.entity.RoadDetails;
import game.enums.GameState;
import game.gfx.Renderer;
import game.gfx.Textures;
import game.input.KeyInput;
import game.input.MouseInput;
import game.libs.Identities;
import game.libs.Images;
import game.libs.Reference;
import game.objects.Block;
import game.objects.CarObstacle;
import game.objects.CarOppositeDirection;
import game.objects.Meteorite;
import game.screens.CrashScreen;
import game.screens.HighScoreScreen;
import game.screens.LoadScreen;
import game.screens.Menu;
import game.screens.OptionScreen;
import game.screens.PauseScreen;
import game.screens.ProfileScreen;
import game.screens.UpgradeScreen;
import game.utils.Button;
import game.utils.ResourceLoader;
import game.utils.files.TextFile;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import org.lwjgl.openal.AL;




public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = -8056194281387030261L;

	
	public static final int WIDTH = 720;
	public static final int HEIGHT = WIDTH / 4 *3;
	public static final String TITLE = "Car Racer";
	private static Game game = new Game(); //makes instance of game
	public static GameState state = GameState.LOADING;
	
	
	private boolean running = false;
	private Thread thread;
	private Renderer gfx;
	public Camera camera;
	private Menu menu;
	private UpgradeScreen upgrade;
	private ProfileScreen profile;
	private OptionScreen options;
	private CrashScreen crash;
	private PauseScreen pauseScreen;
	private HighScoreScreen highScore;
	private Controller controller = new Controller(); // controls all of our game objects
//	private KeyInput keyIn = new KeyInput();
	private static Textures tex;
	private Player player;

	private int time = 100;
	private int counter = 0;

	
	
	
	public static Game getInstance()
	{
		return game;
	}
	
	public Menu getMenu()
	{
		return menu;
	}
	
	public UpgradeScreen getUpgradeScreen()
	{
		return upgrade;
	}
	
	public HighScoreScreen getHighScoreScreen()
	{
		return highScore;
	}
	
	public ProfileScreen getProfileScreen() {
		
		return profile;
	}
	public OptionScreen getOptions() {
		
		return options;
	}
	public CrashScreen getCrashScreen(){
		
		return crash;
	}
	public PauseScreen getPauseScreen(){
		
		return pauseScreen;
	}
	public Controller getController()
	{
		return controller;
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	
	public void init()
	{
		//TextFile.writeFile("./highscores.txt", "hello");
		//System.out.println(TextFile.readFile("./test.txt"));
	}
	
	public void load() // change to private if not used to reload game
	{
		switch(counter){
		case 0:
			highScore = new HighScoreScreen();
			ResourceLoader.loadImages();
			counter++;
			LoadScreen.loadMore();
			return;
		case 1:
			profile = new ProfileScreen();
			ResourceLoader.loadFonts();
			counter++;
			LoadScreen.loadMore();
			return;
		case 2:
			//profileS
			pauseScreen = new PauseScreen();
			ResourceLoader.loadSounds();
			counter++;
			LoadScreen.loadMore();
			return;
		case 3:
			tex = new Textures();
			crash = new CrashScreen();
			counter++;
			LoadScreen.loadMore();
			return;
		case 4:
			options = new OptionScreen();
			menu = new Menu();
			
			counter++;
			LoadScreen.loadMore();
			return;
		case 5:
			gfx = new Renderer();
			upgrade = new UpgradeScreen();
			counter++;
			LoadScreen.loadMore();
			return;
		case 6:
			MouseInput mouse = new MouseInput();
			this.addMouseListener(mouse); //makes it able to click on menu items
			this.addMouseMotionListener(mouse); // allows mouse to listen to motion
			
			counter++;
			LoadScreen.loadMore();
			return;
		case 7:
			controller.addObject(new Block(100, -100, 400, 700, Identities.BLOCK_STREET, tex.blockStreet));
			controller.addObject(new Block(-10, 0, 100, 600, Identities.BLOCK_WATER, tex.waterFlow[0]));
			controller.addObject(new Block(510, 0, 250, 600, Identities.BLOCK_WATER, tex.waterFlow[1]));
			controller.addObject(new Block(-10, -600, 100, 600, Identities.BLOCK_WATER, tex.waterFlow[2]));
			controller.addObject(new Block(510, -600, 250, 600, Identities.BLOCK_WATER, tex.waterFlow[3]));
			int linesX = 100;
			int linesY = 1;
//			
//			for(int j = 1; j < 551; j += 50){ // loop for road lines going down
//				for(int k = 0; k < 328; k += 82){ // loop for road lines going across
			RoadDetails roadLines = new RoadDetails(linesX +1 , -100 , 398, 810, Identities.ROAD_LINES, tex.blockLines);
			
			controller.addObject(roadLines); //the road lines

			
			//controller.addObject(new Block(100, HEIGHT - 150, 140, 40, Identities.BLOCK_TWO_X, tex.blockTwoX));
			//controller.addObject(new CarOppositeDirection(105, 100, 32, 32, Identities.BLACK_BLUE_CAR, Images.blackBlueCar));
			controller.addObject(new CarOppositeDirection(105, -400, 49, 95, Identities.POPO_CAR, Images.popoCar));
			controller.addObject(new CarOppositeDirection(190, 110, 49, 98, Identities.BLACK_RED_CAR, Images.blackRedCar));
			controller.addObject(new CarOppositeDirection(190, -450, 49, 95, Identities.GHOST_CAR, Images.ghostCar));

			controller.addObject(new CarObstacle(275, -250, 49, 96, Identities.BLUE_CAR, Images.blueCar));
			controller.addObject(new CarObstacle(430, 200, 49, 96, Identities.GREEN_CAR, Images.greenCar));
			controller.addObject(new CarObstacle(275, 0, 49, 96, Identities.YELLOW_CAR, Images.yellowCar));
			controller.addObject(new CarObstacle(360, -600, 49, 99, Identities.RED_CAR, Images.redCar));
			controller.addObject(new Meteorite(280, -2000, 64, 64, Identities.METEORITE, Images.meteor));
			player = new Player(282, HEIGHT - 150,49, 100, Identities.PLAYER, Player.getImage());
			controller.addObject(player);
			//controller.addObject(player);
			//controller.addObject(new Block(Game.WIDTH/2, player.getY(), Game.WIDTH, 5, Identities.BLOCK_METAL, tex.blockMetal));
			this.addKeyListener(new KeyInput());
			
			camera = new Camera(0,0); // initializes camera
			counter++;
			LoadScreen.loadMore();
			return;
		case 8:
			counter++;
			LoadScreen.loadMore();
			state = GameState.MENU;
			return;
		}
		
		
		
		
		
		
		
		//AudioPlayer.playMusic(Audio.MUSIC_BACK);
		//AudioPlayer.playMusic(Audio.MUSIC_SHOOT);

		
	}
	
	public void replayer(){
		
		controller.reload();
		player.setVelX(0);
		player.setVelY(0);
		player.setMiles(0);
		player.setY(0);
		player.setCurrentHighScore(0);
//		keyIn.setDownDown(false);
//		keyIn.setLeftDown(false);
//		keyIn.setRightDown(false);
//		keyIn.setSpaceDown(false);
		


	}
	
	
	public void tick()
	{
		if(state == GameState.LOADING){
			time--;
			if(time <= 0){
				load();
				time = 50;
			}
		}
		if(state == GameState.GAME){
			controller.tick();
			camera.tick();
			if(KeyInput.isPaused()){
				state = GameState.PAUSE;
				}
			
			}
		if(state == GameState.PAUSE){
			
		}
		
		
		if(state == GameState.CRASH){
			
			//Window.removeGame(game);
			
			//game.replayer(); ///may not be needed;
			replayer();
			
			
		}
		
		if(state == GameState.MENU){
			
//			load();
			player.setCurrentHighScore(0);
			player.setPoints(0);
		}

		
	

			
		
	}
	

	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy(); // uses this because extends canvas
	
		
		if(bs == null)
		{
			createBufferStrategy(3); // if no bs, creates a bs triple buffering
			return;
		}
		
		//creates graphics instance
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		//////////////////////////////////////////////
		
		 // calls methods to render back and fore ground with graphics instance
		if(state == GameState.LOADING)
			LoadScreen.render(g);
		else if(state == GameState.UPGRADE)
			gfx.renderOther(g);
		else if(state == GameState.PAUSE){
			gfx.renderOther(g);
		}
		else if(state == GameState.CRASH){
			gfx.renderOther(g);
//			game.replayer();

		}
		else if(state == GameState.SCORES){
			gfx.renderOther(g);
		}
		else if(state == GameState.OPTIONS){
			gfx.renderOther(g);
		}
		else if(state == GameState.PROFILE){
			gfx.renderOther(g);
		}
		else{
			gfx.renderBackground(g);
			g2d.translate(camera.getX(), camera.getY());
			
			gfx.renderForeground(g);
			g2d.translate(-camera.getX(), -camera.getY());

		}
		
		
		/////////////////////////////////////////////
		
		g.dispose(); // gets rid of graphics instance
		bs.show(); // shows buffer strategy
	}
	
	
	@Override
	public void run() {
		load(); // initializes the game
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while(running) // while running, start timer
		{
			long currentTime = System.nanoTime(); // current time
			delta += (currentTime - lastTime) / n; //change in time 
			lastTime = currentTime;
			
			if(delta >= 1)
			{
				tick();
				ticks++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) // if time more than 1 sec
			{
				timer += 1000;
				System.out.println(ticks + " Ticks, FPS: " + frames);
				Window.setTitle(TITLE + "      FPS: " + frames);
				ticks = 0; //reset ticks
				frames = 0; // reset frames
			}
		}
		
		stop(); // stops the game
		
	}

	public static void main(String args[])
	{
		Window.initWindow(TITLE);
		Window.addGame(game);
		Window.createWindow();
		game.start(); // starts game
		

	}
	
	private synchronized void start()
	{
		if(running) // if running do nothing 
			return;
		else
			running = true; // if not running, run.
		thread = new Thread(this); //could use game instead of this
		thread.start(); //starts the thread
	}
	
	private synchronized void stop()
	{
		if(!running) // if stopped, do nothing
			return;
		else
			running = false; // if running, stop
		
		cleanUp();
		System.exit(1);
	}
	
	/*
	 * closes OPEN AL "audio library"
	 */
	
	private void cleanUp()
	{
		AL.destroy();
	}
	
	public static void exit()
	{
		game.stop();
	}
	
}
