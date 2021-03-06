import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Gameobject implements ActionListener{
	private int X;
	private int Y; 
	private int Health = 1000;
	private Rectangle rect;
	int pos;
	
	public Gameobject() {
	  pos = (int)(800 * Math.random());
	  this.X = (int)(400 * Math.random());
	  rect = new Rectangle(this.X, pos);
		t.start();
	}
	 Timer t= new Timer(20, (ActionListener) this);
	int vel = 1;
	
	public void draw(Graphics g) {
	if( (this.X <=1200 && this.X >=100 )&& pos >= -80 ) {
		Graphics G = g.create();
		G.setColor(new Color(153, 102, 0));
	
		
		G.fillOval(this.X, pos, 100, 100);
		G.dispose();
	}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (rect.getHeight() > 400)
			this.X = this.X + vel;
		//if (rect.getWidth() < 400)
			this.pos = this.pos - vel;
		if (rect.getWidth() > 400)
			this.pos = this.pos + vel;
		// if (rect.getHeight() < 400)
			this.X = this.X + vel;
		
	}
	public int getHealth() {
		return Health;
	}
	
	public Rectangle rect() {

		return rect;
	}
	public boolean overlaps( Gameobject g) {
		return this.rect().intersects(g.rect());
	}
	
	
	public int getX() {
		return X;
	}
	
	
	public int getY() {
		return pos;
	}
	
}
