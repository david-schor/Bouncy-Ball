package Frame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
	
	@SuppressWarnings("serial")
	public class Game extends JPanel{
		
		//Initzial Variables
		int x = 0;
		int y = 0;
		int durchmesser = 50;
		int speedX = 3;
		int speedY = 1;
		public static int h;
		public static int w;
		
		public static void main(String[] args) throws InterruptedException {
			
			//Create Frame
			JFrame frame = new JFrame("Sample Frame");
			Game spiel = new Game();
			frame.add(spiel);
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			while(true){
				spiel.moveBall();
				spiel.repaint();
				h = (int) frame.getContentPane().getSize().getHeight();
				w = (int) frame.getContentPane().getSize().getWidth();
				spiel.BallCollision();
				Thread.sleep(10);
			}
		}
		
		//Move the ball
		private void moveBall(){
			x = x + speedX;
			y = y + speedY;
		}
		
		//Collision with wall
		public void BallCollision(){
			if(x + durchmesser > w){
				speedX = speedX > 0 ? -speedX : speedX;
			}
			if(x < 0){
				speedX = speedX < 0 ? -speedX : speedX;
			}
			if(y + durchmesser > h){
				speedY = speedY > 0 ? -speedY : speedY;
			}
			if(y < 0){
				speedY = speedY < 0 ? -speedY : speedY;
			}
		}
		
		//Draw Ball
		@Override
		public void paint(Graphics g){
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.fillOval(x, y, durchmesser, durchmesser);
		}

}