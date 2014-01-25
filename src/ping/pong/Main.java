/**
 * 
 */
package ping.pong;

import java.awt.geom.Rectangle2D;

import org.lwjgl.input.Keyboard;

import pretti.chris.library.MyWindow;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.input.Keyboard.*;



/**
 * @author Chris
 *
 */
public class Main extends MyWindow 
{
	Rectangle2D.Double player1;//has x coordinate, y coordinate, and width and height of paddle.
	Rectangle2D.Double player2;//SECOND PLAYER!
	Rectangle2D.Double ball;
	double vx, vy;
	static final int WINDOW_WIDTH = 1280,WINDOW_HEIGHT=720;
	public Main() 
	{
		super(WINDOW_WIDTH, WINDOW_HEIGHT);
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
		vx = -4;
		vy= 3;
		player1=new Rectangle2D.Double(10, 10, 50, 200);
		player2=new Rectangle2D.Double(WINDOW_WIDTH-60, 10, 50, 200);
		ball=new Rectangle2D.Double(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, 50, 50);
	}

	@Override
	public void input() 
	{
		int speed = 5;
		if(Keyboard.isKeyDown(KEY_W))
		{
			if(player1.y+player1.height<WINDOW_HEIGHT)//makes sure that can't go out of bounds top.
				player1.y+= speed;
			
		}
		if(Keyboard.isKeyDown(KEY_S))
		{
			if(player1.y>0)//makes sure that can't go out of bounds bottom.
				player1.y-= speed;
			
		}
		
		if(Keyboard.isKeyDown(KEY_UP))
		{
			if(player2.y+player2.height<WINDOW_HEIGHT)//makes sure that can't go out of bounds top.
				player2.y+= speed;
			
		}
		if(Keyboard.isKeyDown(KEY_DOWN))
		{
			if(player2.y>0)//makes sure that can't go out of bounds bottom.
				player2.y-= speed;
			
		}
		// TODO Auto-generated method stub
		
	}
	public void drawBall()
	{
		glBegin(GL_QUADS);
			glVertex2d(ball.getX(),ball.getY());
			glVertex2d(ball.getX()+ball.getWidth(),ball.getY());
			glVertex2d(ball.getX()+ball.getWidth(),ball.getY()+ball.getHeight());
			glVertex2d(ball.getX(),ball.getY()+ball.getHeight());
		glEnd();
	}
	public void draw()
	{
		super.draw();//this clears window.
		glColor3f(1,1,1);// this sets color of every vertex to white. 1,1,1 is white.
		drawPlayers();
		drawBall();
	}
	public void drawPlayers()
	{
		glBegin(GL_QUADS);//GL_QUADS makes a Quaderlateral.
			glVertex2d(player1.getX(),player1.getY());//Draws single vertex at that coordinate.
			glVertex2d(player1.getX()+player1.getWidth(),player1.getY());//draws another vertex.
			glVertex2d(player1.getX()+player1.getWidth(),player1.getY()+player1.getHeight());
			glVertex2d(player1.getX(),player1.getY()+player1.getHeight());
			glVertex2d(player2.getX(),player2.getY());//Draws single vertex at that coordinate.
			glVertex2d(player2.getX()+player2.getWidth(),player2.getY());//draws another vertex.
			glVertex2d(player2.getX()+player2.getWidth(),player2.getY()+player2.getHeight());
			glVertex2d(player2.getX(),player2.getY()+player2.getHeight());
		glEnd();
	}
	public void tick()
	{
		double my1=player1.y+player1.height/2;//finds middle of height
		double sy1=player2.y+player2.height/2;
		double b1=ball.y+ball.height/2;//finds middle of ball
		super.tick();
		ball.x+=vx;
		ball.y+=vy;
		if(ball.x+ball.width>WINDOW_WIDTH)
		{
			ball.x=WINDOW_WIDTH/2;
			vy=-4;
			vx=3;
			
		}
		if(ball.x<0)
		{
			ball.x=WINDOW_WIDTH/2;
			vy=-4;
			vx=3;
		}
		
		else if(ball.y+ball.height>WINDOW_HEIGHT||ball.y<0)//flips the velocity to bounce off walls.
		{
			vx*=1.1;
			vy*=-1;
		}
		
		if(player1.intersects(ball))
		{
			vx*=-1;
			vy+=(b1-my1)/10;
		}
		if(player2.intersects(ball))
		{
			vx*=-1;
			vy+=(b1-sy1)/10;
		}
	}

	
	

}
