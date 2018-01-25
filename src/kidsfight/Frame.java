package kidsfight;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class Frame {
	public Frame(){
		JFrame frame = new JFrame();
		frame.add(new Board());
		frame.setTitle("Kids Fight Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(780, 420);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	public static void main(String[]args)throws Exception{
		new Frame();
		
		AudioInputStream sample;
		sample = AudioSystem.getAudioInputStream(new File("F:/java/MaraMari/src/kidsfight/rap.wav"));
		
		Clip clip = AudioSystem.getClip();
		clip.open(sample);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
