package kidsfight;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

	Player1 p;
	Player2 q;
	ImageIcon i;
	Image BackGroundImg; 
	Timer time;
	
	public Board() {
		p = new Player1();
		q = new Player2();
		addKeyListener(new AL());
		setFocusable(true);
		i = new ImageIcon("F:/java/MaraMari/src/kidsfight/background.gif");
		BackGroundImg = i.getImage();
		time = new Timer(5,this);
		time.start();
	}
	
	
	public void actionPerformed(ActionEvent e){
		limit();
		p.move();
		q.move();
		repaint();
	}
	
	public void paint (Graphics g){
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(BackGroundImg, 0, 0, null);
		g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
		g2d.drawImage(q.getImage(), q.getX(), q.getY(), null);
		
		System.out.println("px = " + p.getX() + "   qx = " +q.getX());
	}
	
	public void limit(){
		if(q.x-p.x<=80) {
			q.x = q.x + 2;
			p.x = p.x -2;
		}
	}
	
	private class AL extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			p.keyReleased(e);
			q.keyReleased(e);
		}
		public void keyPressed(KeyEvent e){
			p.keyPressed(e);
			q.keyPressed(e);
			
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_G && collisionCheck()) {
					i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player2/kicked.gif");
					q.player2Image = i.getImage();
					playSound();
					q.life = q.life-1;
			}
			
			if(key == KeyEvent.VK_H && collisionCheck()) {
				i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player2/kicked.gif");
				q.player2Image = i.getImage();
				playSound();
				q.life = q.life-1;
			}
			
			if(key == KeyEvent.VK_PAGE_UP && collisionCheck()) {
				i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player1/kicked.gif");
				p.player1Image = i.getImage();
				playSound();
				p.life = p.life-1;
			}
			if(key == KeyEvent.VK_PAGE_DOWN && collisionCheck()) {
				i = new ImageIcon("F:/java/MaraMari/src/kidsfight/Player1/kicked.gif");
				p.player1Image = i.getImage();
				playSound();
				p.life = p.life-1;
			}
		}
		
		public boolean collisionCheck(){
			Rectangle r1 = p.getBounds();
			Rectangle r2 = q.getBounds();
			
			if(r1.intersects(r2)) return true;
			else return false;
		}
		
		public void playSound() {
		    try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("F:/java/MaraMari/src/kidsfight/kick.wav").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
		}
		
	}
	
}
