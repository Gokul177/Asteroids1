import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class AsteroidGame{
	private ArrayList<Gameobject> GameObjects;
	private Gameobject BigAsteroid;
	private Gameobject SmallAsteroid;
	
	public AsteroidGame(){
		
		ArrayList<Gameobject> GameObjects = new ArrayList<>();
			
	}
	
	

	private void addAsteroid(){
		int r = (int)Math.random()*2;
		for(int i = 0; i<=10; i++){
			if(r<1){
				
				GameObjects.add(BigAsteroid);
			}
			else{
				GameObjects.add(SmallAsteroid);
			}
		}
			
		
	}
	
	public void keyHit(String s) {
		// TODO Auto-generated method stub
		
	}

	public void movewith() {
		// TODO Auto-generated method stub
		
	}

	public boolean collide() {
		// TODO Auto-generated method stub
		return false;
	}


}
