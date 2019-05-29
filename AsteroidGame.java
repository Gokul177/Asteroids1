import java.awt.Graphics;
import java.util.ArrayList;

public class AsteroidGame {
	ProjectileShip alive;
	ArrayList<Projectile> bullet = new ArrayList<Projectile>();;
	ArrayList<Gameobject> Asteroid = new ArrayList<Gameobject>();
	String direction;
	int numBullets = 0;
	int index = 0;
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
		for(int i = 0; i < Gameobjects.size(); i ++){
			for(int o; o < Projectile.size(); o++){
				if((Gameobjects.get(i)).overlaps(Projectile.get(o))){
					Projectile.remove(o);
					if(//Gameobject.get(i).isBig){
						int x = Gameobject.get(i)//.getXpos
						int y = Gameobject.get(i)//.getYpos
						double z = (int)(Math.random()*2);
						int ax = x + Math.cos(z)*50;
						int ay = y + Math.sin(z)*50;
						int bx = x + Math.cos(z)*50;
						int by = y + Math.sin(z)*50;
						//new asteriod a at (ax,ay) and radius of 50
						//new asteriod b at (bx,by) and radius of fifty
						Gameobject.add(a);
						Gameobject.add(b);
						
					else{
						Gameobject.remove(i)
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
	
		

}
