import java.awt.Graphics;
import java.util.ArrayList;

public class AsteroidGame {
	ProjectileShip alive;
	ArrayList<Projectile> bullet = new ArrayList<Projectile>();;
	ArrayList<Gameobject> Asteroid = new ArrayList<Gameobject>();
	String direction;
	int numBullets = 0;
	int index = 0;
	int score = 0;
	public AsteroidGame() {
		 alive = new ProjectileShip(500, 300);
	}

	
	public void keyHit(String s) {
		direction = s;
		alive.move(s);
	
	}

	public void shoot() {
			bullet.add(new Projectile(alive,alive.rotation1));
			numBullets+=1;
			System.out.println("number of bullet " + numBullets);
	}

	public boolean collide() {
		for(int i = 0; i < Gameobjects.size(); i ++){
			if(Gameobjects.get(i).overlaps(ProjectileShip)){
				return true;
				//end game
				}	
			}	
		}
		for(int i = 0; i < Asteriod.size(); i ++){
			for(int o; o < bullet.size(); o++){
				if((Asteriod.get(i)).overlaps(Projectile.get(o))){
					bullet.remove(o);
					if(Asteriod.get(i).rect().width()>100){
						int x = Asteriod.get(i).getXpos();
						int y = Asteriod.get(i).getYpos();
						double z = (int)(Math.random()*2);
						int ax = x + Math.cos(z)*50;
						int ay = y + Math.sin(z)*50;
						int bx = x + Math.cos(z)*50;
						int by = y + Math.sin(z)*50;
						//new asteriod a at (ax,ay) and radius of 50
						//new asteriod b at (bx,by) and radius of fifty
						Asteriod.add(a);
						Asteriod.add(b);
						score++;
					else{
						Asteriod.remove(i);
						score++;
					}	
				}		
			}
		}
		return false;
	}
	public void createAsteroid() {
		Gameobject ast = new Gameobject(alive);
			Asteroid.add(ast);
			
	}

	public void draw(Graphics g) {
		alive.draw(g);
		createAsteroid();
		ArrayList<Gameobject> movingA = new ArrayList<>();
			for(int i = 1; i< Asteroid.size()-1; i++) {
			if( Asteroid.get(i).overlaps(Asteroid.get(i-1))) {
				movingA.add(Asteroid.get(i));
			}else {
				Asteroid.get(i).draw(g);
			}
		}	
			for (Gameobject p : movingA) {
				System.out.println("removedAsteroid");
				Asteroid.remove(p);
			}			
		ArrayList<Projectile> bulletToRemove = new ArrayList<>();
		for (Projectile p:bullet) {
			if (p.pos <= -1000) {  // upper bound ?
				bulletToRemove.add(p);
			} else {
				p.draw(g);
			}
		}
		for (Projectile p : bulletToRemove) {
			//System.out.println("removed bullet");
			bullet.remove(p);
		}			
				
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
		
	}	

}
