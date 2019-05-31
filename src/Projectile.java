import java.awt.Color;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	public double rot;
	Rectangle rect;
	ArrayList<Gameobject> Asteroid;
	public int scoreTotal = 0;
	
	public Projectile (ProjectileShip s, int rotation){
		System.out.println("projectile..");
		X = s.getX() + 20;
		Y = s.getY() - 10;
		rot = rotation;
		pos = s.getY();
		tm.start();
		rect = new Rectangle(5, 20);
		
	}
	Timer tm = new Timer(1, this);
	int  pos;
	int vel= 1;
	
	public void draw (Graphics g) {
		g.setColor(new Color(20, 100, 200));
		Graphics2D g2 = (Graphics2D) g.create();
		g2.rotate(Math.toRadians(rot));
		g2.fillRect(this.X, pos, 5, 20);
		ArrayList<Gameobject> hit = new ArrayList<>();
		for (Gameobject gobj: Asteroid) {
			if ((gobj.getX()< this.X && gobj.getX()+90 > this.X) && 
					(gobj.getY() < this.pos && gobj.getY()+100 > this.pos)) {
				hit.add(gobj);
				AsteroidGame.scoreTotal++;
			}
		}
		Asteroid.removeAll(hit);
		
		g2.rotate(-1 * Math.toRadians(rot));
		repaint();
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		pos = pos - vel;		
	}

	public Rectangle rect() {
		
		return rect;
	}
	
	public void add(ArrayList<Gameobject> Asteroid) {
		this.Asteroid = Asteroid;
	}
	
}
 