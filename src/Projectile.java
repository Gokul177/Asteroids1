import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * 
 * @author gokuldeep
 *
 */
public class Projectile extends JPanel implements ActionListener {
	private int X ;
	private int Y;
	double rot;
	private Rectangle rect;
	
	public Projectile (ProjectileShip s, int rotation){
		System.out.println("projectile..");
		X = s.getX() + 20;
		Y = s.getY() - 10;
		rot = rotation;
		pos = s.getY();
		tm.start();
		rect = new Rectangle(X,Y,5,20);
		
	}
	Timer tm = new Timer(1, this);
	int  pos;
	int vel= 1;
	
	public void draw (Graphics g) {
		g.setColor(new Color(20, 100, 200));
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate(Math.toRadians(rot));
		g.drawRect(this.X,pos, 5, 20);
		g2.rotate(-1 * Math.toRadians(rot));
		repaint();
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		pos = pos - vel;		
	}
	public boolean overlaps( Gameobject g) {
		return this.rect().intersects(g.rect());
	}
	

}
 
