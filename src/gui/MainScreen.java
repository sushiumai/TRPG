import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;


package gui;

public class MainScreen extends JFrame {
	
	public static final String GAME_TITLE = "ドラゴンクエスト";
	
	public MainScreen() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(GAME_TITLE);
		this.setUndecorated(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
