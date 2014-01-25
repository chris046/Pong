/**
 * 
 */
package ping.pong;

import java.awt.geom.Rectangle2D;

import pretti.chris.library.MyWindow;
import static org.lwjgl.opengl.GL11.*;



/**
 * @author Chris
 *
 */
public class Main extends MyWindow 
{
	Rectangle2D player1;//has x coordinate, y coordinate, and width and height of paddle.
	public Main() 
	{
		super(1280, 720);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Main();//Made main and will get stuck in infinite happy loop.

	}

	@Override
	public void initialize() 
	{
		// TODO Auto-generated method stub
		player1=new Rectangle2D.Double(10, 10, 50, 200);
	}

	@Override
	public void input() 
	{
		// TODO Auto-generated method stub
		
	}
	public void draw()
	{
		super.draw();//this clears window.
		glColor3f(1,1,1);// this sets color of every vertex to white. 1,1,1 is white.
		glBegin(GL_QUADS);//GL_QUADS makes a Quaderlateral.
			glVertex2d(player1.getX(),player1.getY());//Draws single vertex at that coordinate.
			glVertex2d(player1.getX()+player1.getWidth(),player1.getY());//draws another vertex.
			glVertex2d(player1.getX()+player1.getWidth(),player1.getY()+player1.getHeight());
			glVertex2d(player1.getX(),player1.getY()+player1.getHeight());
		glEnd();//When in end part make next line ^ to show ending stuff thing person ect.
		
	}
	
	

}
