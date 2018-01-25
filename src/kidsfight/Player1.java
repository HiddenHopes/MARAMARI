package kidsfight;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player1 {
	int x, dx, y, dy,life;
	ImageIcon i;
	Image player1Image;
	public Player1(){
		i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player1/still.gif");
		player1Image = i.getImage();
		x = 30;
		y = 270;
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
		return new Rectangle(x,y,130,111);
	}
	
	public Image getImage(){
		return player1Image; 
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		dx = 0;
		dy =0;
		y = 270;
		i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player1/still.gif");
		player1Image = i.getImage();
	}
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_A) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player1/walkback.gif");
			player1Image = i.getImage();
			dx = -2;
		}
		if(key == KeyEvent.VK_D) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player1/walk.gif");
			player1Image = i.getImage();
			dx = 2;
		}
		
		if(key == KeyEvent.VK_W) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player1/jump.gif");
			player1Image = i.getImage();
			y=190;
		}
		if(key == KeyEvent.VK_S) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player1/down.gif");
			player1Image = i.getImage();
		}
		
		if(key == KeyEvent.VK_G) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player1/highpunch.gif");
			player1Image = i.getImage();
		}
		
		if(key == KeyEvent.VK_H) {
			i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player1/highkick.gif");
			player1Image = i.getImage();
		}

	}
}
