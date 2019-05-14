import java.awt.Graphics;
/**
 * 
 * @author gokuldeep
 *
 */
public class Projectile {
  
  private static final String PATH_PREFIX = "/";
	private int row ;
	private int col;
	public Image Img;
	public double SCALE_FACTOR = 0.04;
	public Projectile (int r, int c){
		row = r;
		col = c;
		Img = getImage();
	}
	public Image getImage() {
		Image Img = null;
		String getter = PATH_PREFIX+ "ball.png";
		try{
			Img = ImageIO.read(getClass().getResource(getter));
		}catch (IOException e) {
			
		}
		return Img;
		
	}
	public void draw (Graphics g) {
		g.drawImage(Img, 100, 100, null);
	}
	
	


}
