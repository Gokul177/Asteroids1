import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;


public class Gameobject implements Shape{
	public int health;
	public int x ,y;
	public int width;
	public int height;
	private Shape shape;
	boolean isCollide;
	
	public Gameobject(int center, int radius) {
		Circle circ1 = new Circle();
		circ1.setRadius((double)radius);
		
	}

public void draw(Graphics g) {
		g.drawOval(x,y,width,height);
	}

	@Override
	public boolean contains(Point2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(double arg0, double arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(double arg0, double arg1, double arg2, double arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PathIterator getPathIterator(AffineTransform arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PathIterator getPathIterator(AffineTransform arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean intersects(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean intersects(double arg0, double arg1, double arg2, double arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	public int getHealth(){
		return this.health;
	}
	public void remove(){
		if(this.getHealth()<=0){
		}

	}
}
