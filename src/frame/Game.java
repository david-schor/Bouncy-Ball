package frame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
	
	@SuppressWarnings("serial")
	public class Game extends JPanel{
		
		//Initzial Variables
		public int x = 0;
		public int y = 0;
		public int diameter = 50;
		public int speedX = 3;
		public int speedY = 1;
		public static int h;
		public static int w;
		
		public static void main(String[] args) throws InterruptedException {
			
			//Create Frame
			JFrame frame = new JFrame("Game Frame");
			Game game = new Game();
			frame.add(game);
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//Do Loop to call Methodes
			while(true){
				game.moveBall();
				game.repaint();
				h = (int) frame.getContentPane().getSize().getHeight();
				w = (int) frame.getContentPane().getSize().getWidth();
				game.ballCollision();
				Thread.sleep(10);
			}
		}
		
		//Move the ball
		private void moveBall(){
			x = x + speedX;
			y = y + speedY;
		}
		
		//Collision with Wall
		public void ballCollision(){
			if(x + diameter > w)
				speedX = speedX > 0 ? -speedX : speedX;
			
			if(x < 0)
				speedX = speedX < 0 ? -speedX : speedX;
			
			if(y + diameter > h)
				speedY = speedY > 0 ? -speedY : speedY;
			
			if(y < 0)
				speedY = speedY < 0 ? -speedY : speedY;
			
		}
		
		//Draw Ball
		@Override
		public void paint(Graphics g){
			super.paint(g);
			Graphics2D ball = (Graphics2D) g;
			ball.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			ball.fillOval(x, y, diameter, diameter);
		}

}
