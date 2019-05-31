import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class AsteroidGame {
	ProjectileShip alive;
	ArrayList<Projectile> bullet = new ArrayList<Projectile>();
	ArrayList<Gameobject> Asteroid = new ArrayList<Gameobject>();
	String direction;
	int numBullets = 0;
	int index = 0;
	static int scoreTotal = 0;
	public AsteroidGame() {
		 alive = new ProjectileShip(500, 300);
	}

	
	public void keyHit(String s) {
		direction = s;
		alive.move(s);
	
	}
	public int score() {
		int total = 0;
		for(Projectile b : bullet) {
			total += b.scoreTotal;
		}
		return total;
	}
	public void shoot() {
		    Projectile p = new Projectile(alive,alive.rotation1);
			bullet.add(p);
			p.add(Asteroid);
			numBullets+=1;
			System.out.println("number of bullet " + numBullets);
	}

	
	public void createAsteroid() {
		Gameobject ast = new Gameobject();
			Asteroid.add(ast);
			
	}

	public void draw(Graphics g) {
		alive.draw(g);
		createAsteroid();
		ArrayList<Gameobject> movingA = new ArrayList<>();
			for(int i = 1; i< Asteroid.size()-1; i++) {
			if(Asteroid.get(i).overlaps(Asteroid.get(i-1))) {
				movingA.add(Asteroid.get(i));
			}else {
				Asteroid.get(i).draw(g);
			}
		}	
			for (Gameobject p : movingA) {
			//	System.out.println("removedAsteroid");
				Asteroid.remove(p);
			}	
		ArrayList<Projectile> bulletToRemove = new ArrayList<>();
		for (Projectile p:bullet) {
			if (p.pos <= -1000) {  
				bulletToRemove.add(p);
			} else {
				p.draw(g);
			}
		}
		for (Projectile p : bulletToRemove) {
			//System.out.println("removed bullet");
			bullet.remove(p);
		}			
	//	alive.add(Asteroid);		
	}


	public void drawIntro(Graphics g) {
		g.setColor(Color.white);
	
		g.drawString("-------     -------    --------   -------   ------   --------  ------    -------",

				250, 150);
		g.drawString("||        ||     ||                        ||         |                |          )    ||          ||      ||         |             |",
				250, 170);   
		g.drawString("||----||       ------            ||         |------     |  ---/     ||          ||      ||         |             |",
				250, 190);
		g.drawString("||        ||                  ||           ||         |                |          |    ||          ||      ||         |             |",
				250, 210); 
		g.drawString("||        ||      ------||           ||         |------    |           |   ||-----||   --|--     |------/",
				250, 230);
		g.drawString("Controls", 10, 10);
		g.drawString("-----", 10, 20);
		g.drawString("UP - Forward", 10, 30);
		g.drawString("  ", 10, 40);
		g.drawString("DOWN - Backward", 10, 50);
		g.drawString("  ", 10, 60);
		g.drawString("SPACE - Shoot", 10, 70);
		g.drawString("  ", 10, 80);
		g.drawString("RIGHT - Rotate Right", 10, 90);
		g.drawString("  ", 10, 100);
		g.drawString("LEFT - Rotate Left", 10, 110);
		g.drawString("Asteroids Hit: " + scoreTotal, 950, 50);
		
	}
	    	

}
