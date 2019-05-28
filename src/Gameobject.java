import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Gameobject implements ActionListener{
	private int X;
	private int Y; 
	private int health;
	private Rectangle rect;
	int pos;
	
	public Gameobject(ProjectileShip s) {
	  pos = (int)(800 * Math.random());
	  this.X = (int)(400 * Math.random());
	  rect = new Rectangle(this.X, pos);
		t.start();
	}
	 Timer t= new Timer(20, (ActionListener) this);
	int vel = 1;
		
	
	public void draw(Graphics g) {
	if( this.X <=800)
		g.drawOval(this.X, pos, 100, 100);
	
	}
/*	public int area() {
		
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if (rect.getHeight() > 400)
			this.X = this.X + vel;
		if (rect.getWidth() < 400)
			this.pos = this.pos - vel;
		if (rect.getWidth() > 400)
			this.pos = this.pos + vel;
		if (rect.getHeight() < 400)
			this.X = this.X + vel;
		
	}
	
	public Rectangle rect() {

		return rect;
	}
	public boolean overlaps( Gameobject g) {
		return this.rect().intersects(g.rect());
	}
		public int getHealth() {
		return health;
	}
	public int setHealth(int n){
		health = n;
		return health;
	}
}
