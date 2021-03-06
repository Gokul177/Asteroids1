import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

import javafx.scene.shape.Shape;

public class ProjectileShip extends JPanel{
	private static final String PATH_PREFIX = "res/";
	private int X;
	private int Y;
	
	public Rectangle rect;
	
	public int speed;
	public static Image ship;
	public int rotation1= 0;
	ArrayList<Gameobject> Asteroid;
	
	public ProjectileShip (int x, int y) {
	  this.X = x;
	  this.Y = y;
	  speed = 0;
	  ship = getImage();
	  
  }
 
	public Image getImage() {
		 
		String getter = PATH_PREFIX+ "Spaceship.png";
		Image myImage = null;
		try{
			myImage = ImageIO.read(getClass().getResource(getter));
			myImage = myImage.getScaledInstance(45, 45,Image.SCALE_SMOOTH);
		}catch (IOException e) {
			
		}
		return myImage;
	}
	 
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (rotation1 != 0) {
			g2.rotate(Math.toRadians(rotation1));
		}
		g.drawImage(ship, this.X, this.Y, null);
		if (Asteroid != null) {
			for (Gameobject gobj : Asteroid) {
				if ((gobj.getX() < this.X && gobj.getX() + 90 > this.X)
						&& (gobj.getY() < this.getY() && gobj.getY() + 100 > this.getY())) {
					g2.dispose();
					g.drawString("GAME OVER", 400, 100);
					return;

				}
			}
		}
		if (rotation1 != 0) {
		   g2.rotate(-1 * Math.toRadians(rotation1));
		}
		
		repaint();
		
	}
	
	public void resetShip() {
		this.X = 500;
		this.Y = 300;
		this.speed = 0;
		ship = getImage();
		
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}

	public void move(String s) {
		
		if (s.equals("up")) {
			this.Y = this.Y - 40;
		}
		if(s.equals("down")) {
			this.Y = this.Y + 40;

		}
		if (s.equals("left")) {
			this.rotation1 = rotation1 +2;
	
			
		}
		if(s.equals("right")) {
			this.rotation1 = rotation1 - 2;
			
		}

	}

	public boolean collide() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setX(int height) {
		X = height;
		
	}

	public void setY(int width) {
		Y = width;
		
	}

	public Rectangle rect() {
		return this.rect;
	}
	public boolean overlaps (Gameobject a) {
		return this.rect.intersects(a.rect());
	}
	public void add(ArrayList<Gameobject> Asteroid) {
		this.Asteroid = Asteroid;
	}
}
