
package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MainScreen extends JFrame {
	
	public static final String GAME_TITLE = "ドラゴンクエスト";
	
	public MainScreen() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(GAME_TITLE);
		this.setUndecorated(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.addKeyListener(new KeyAdapter(){
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					
					System.out.println("システムを終了します");
					System.exit(0);
				}
			}
		});
		
		
	}

}
