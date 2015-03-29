package game;

import game.libs.Reference;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class Window{

	private static JFrame frame;
	private static String title;
	private static int width, height;
	
	public static void initWindow(String title)
	{
		Window.title = title;
		frame = new JFrame(title);
		
		
	}
	
	public static void addGame(Game game)
	{
		frame.add(game);
		
	}
	
//	public static void removeGame(Game game)
//	{
//		frame.remove(game);
//		game = new Game();
//		addGame(game);
//		game.revalidate();
//		game.load();
//		
//	}

	
	public static void createWindow()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//JFrame frame = new JFrame(TITLE); //creates frame with game title
		Image icon = Toolkit.getDefaultToolkit().getImage(Reference.SPRITE_LOCATION + "carIcon.png.png");
		Image cursor = toolkit.getImage(Reference.SPRITE_LOCATION + "theMouse.gif");
		frame.setIconImage(icon);
		frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "cursor"));
		frame.setSize(Game.WIDTH, Game.HEIGHT); //sets frame size
		//replaces default close operation to close open AL
		frame.addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						Game.exit();
					}
				});
		frame.setFocusable(true); // allows for user of key and mouse listener
		frame.setLocationRelativeTo(null); // sets frame in center of screen
		frame.setResizable(false); //frame not resizable
		
		frame.setVisible(true); //makes frame visible
		frame.pack(); // packs all the stuff above together
	}
	
	public static void setTitle(String title)
	{
		frame.setTitle(title);
	}
	
	
}
