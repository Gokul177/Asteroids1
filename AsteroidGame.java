import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

public class AsteroidGame{
	private ArrayList<Gameobject> GameObjects;
	private Gameobject BigAsteroid;
	private Gameobject SmallAsteroid;
	public int Score;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) (screenSize.getWidth()*3/4),HEIGHT=(int) (screenSize.getHeight()*3/4);

	
	public AsteroidGame(){
		
		ArrayList<Gameobject> GameObjects = new ArrayList<>();
		this.Score++;
			
	}
	private void remove(){
		for(int i=GameObjects.size(); i < 0; i--){
			int a = GameObjects.get(i).getHealth();
			if(a == 0){
				GameObjects.remove(i);
				Score++;
			}	
		}	
	}

	private void addAsteroid(){
		int r = (int)(Math.random()*2);
		for(int i = 0; i<=10; i++){
			if(r<1){
				
				GameObjects.add(BigAsteroid);
			}
			else{
				GameObjects.add(SmallAsteroid);
			}
		}
		
	}
	
	public void moveAcrossScreen(Graphics j) { 
		for(int x = 100; x<WIDTH; x+=100){ 
			for(int y = 50; y<HEIGHT; y+=100){ 
				j.drawOval(x, y, 100, 100); 
				g.dispose(); 
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
