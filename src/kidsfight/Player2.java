package kidsfight;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player2 {
	int x, dx, y, dy, life;
	ImageIcon i;
	Image player2Image;
	public Player2(){
		i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player2/still.gif");
		player2Image = i.getImage();
		x = 650;
		y = 250;
		dx=0;
		dy=0;
		life = 100;
	}
	
	public void move(){
		x = x + dx;
		y = y + dy;
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,146,113);
	}
	
	public Image getImage(){
		return player2Image; 
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		dx = 0;
		dy =0;
		y = 250;
		i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player2/still.gif");
		player2Image = i.getImage();
	}
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player2/walkback.gif");
			player2Image = i.getImage();
			dx = 2;
		}
		if(key == KeyEvent.VK_LEFT) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player2/walk.gif");
			player2Image = i.getImage();
			dx = -2;
		}
		
		if(key == KeyEvent.VK_UP) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player2/jump.gif");
			player2Image = i.getImage();
			y=190;
		}
		if(key == KeyEvent.VK_DOWN) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player2/down.gif");
			player2Image = i.getImage();
		}
		
		if(key == KeyEvent.VK_PAGE_UP) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player2/highpunch.gif");
			player2Image = i.getImage();
		}
		
		if(key == KeyEvent.VK_PAGE_DOWN) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player2/highkick.gif");
			player2Image = i.getImage();
		}

	}
}
