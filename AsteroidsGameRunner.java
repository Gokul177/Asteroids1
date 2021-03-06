import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class AsteroidsGameRunner {
		private JPanel panel;
		private AsteroidGame game = new AsteroidGame();
		private Timer timer;
		private int ticks;
		private KeyEvent e;
		// Notice this intuitive method for finding the screen size 
		public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		public static final int WIDTH = (int) (screenSize.getWidth()*3/4),HEIGHT=(int) (screenSize.getHeight()*3/4);

		public AsteroidsGameRunner() {
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						start();
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
					}
				}
			});
		}
	
		public static void main(String[] args) {
			new AsteroidsGameRunner();
		}

		private void start()  {
			JFrame frame = new JFrame("A S T E R O I D S");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				panel = new JPanel() {
				@Override
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
			        g.setColor(Color.gray);
			        g.fillOval(100, 100, 100, 100);
					Toolkit.getDefaultToolkit().sync();
				//	 game.createAsteroid();
					game.draw(g);
				}
			};
			panel.setBackground(new Color(50, 50, 50));
			panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
			frame.setLocation(WIDTH/10, HEIGHT/10);

			mapKeyStrokesToActions(panel);
			

			frame.add(panel);
			frame.pack();
			frame.setVisible(true);
			panel.requestFocusInWindow();
			timer = new Timer(10, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					updateGame();
					panel.repaint();
				}
			});
			timer.start();
			}

		// this method is called every time the timer goes off (which right now is every 10 milliseconds = 100 times per second
		protected void updateGame() {
			/*int i=0;
			ticks++;// keeps track of the number of times the timer has gone off
			if(ticks %100 == 0) {
				System.out.println(ticks/100+" seconds");
			//	game.move(ticks);
				
			}
			*/
			if(game.alive.getX() == 0) {
			   game.alive.setX(HEIGHT);
			}
			if(game.alive.getY() == 0) {
				game.alive.setY(WIDTH);
			}
			if(game.alive.collide()){
				System.out.println("YOU DIED!");
				game.alive.resetShip();
			}
		//	game.movewith();
		}

		private void mapKeyStrokesToActions(JPanel panel) {

			// A map is an Data storage interface which defines
			// an association of a key with a value
			// to "add" to a map you use the "put" method
			// to "get" from a map you use "get(key)" and the 
			// value associated with the key is returned (or null)
			ActionMap map = panel.getActionMap();
			InputMap inMap = panel.getInputMap();

			// code below associates pressing the up arrow with the command "up"
			// essentially creating the command "up" being broadcast any time the 
			// up key is hit
			inMap.put(KeyStroke.getKeyStroke("UP"), "up");
			inMap.put(KeyStroke.getKeyStroke((char) KeyEvent.VK_UP), "up");
			// code below associates the "up" action with anything in the 
			// actionPerformed method.  Right now, it just prints something
			map.put("up", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					hit("up");
				}

				
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
			panel.getActionMap().put("left",new AbstractAction(){

				@Override
				public void actionPerformed(ActionEvent e) {
					hit("left");
				}
			});
			inMap.put(KeyStroke.getKeyStroke("RIGHT"), "right");
			inMap.put(KeyStroke.getKeyStroke((char)KeyEvent.VK_RIGHT), "right");
			 map.put("right", new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {
					hit("right");
					
					
				}
			 });
			 inMap.put(KeyStroke.getKeyStroke("pressed DOWN"), "down");
				inMap.put(KeyStroke.getKeyStroke((char) KeyEvent.VK_DOWN), "down");
				// code below associates the "up" action with anything in the 
				// actionPerformed method.  Right now, it just prints something
				map.put("down", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						hit("down");
						
					}
				});
				inMap.put(KeyStroke.getKeyStroke("shift"), "shift");
				inMap.put(KeyStroke.getKeyStroke((char) KeyEvent.VK_SHIFT), "shift");
				map.put("shift", new AbstractAction(){
					@Override
					public void actionPerformed (ActionEvent e) {
						hit("shift");
					}
				});
				inMap.put(KeyStroke.getKeyStroke("SPACE"), "space");
				inMap.put(KeyStroke.getKeyStroke((char) KeyEvent.VK_SPACE), "space");
				map.put("space", new AbstractAction(){
					@Override
					public void actionPerformed (ActionEvent e) {
						shoot();
						
						
					}
				});
		}
	
		public void hit(String s) {
			game.keyHit(s);
			panel.repaint();
			
		}
		public void shoot () {
			game.shoot();
			panel.repaint();
		}
	
		protected void drawGame(Graphics g) {
			game.draw(g);
		}
		public void paintComponent(Graphics g)
	    {
	        g.setColor(Color.red);
	        g.drawOval(100, 10, 30, 40);
	    }

}
