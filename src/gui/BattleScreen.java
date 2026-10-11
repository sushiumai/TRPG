package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class BattleScreen extends JPanel {
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = screenSize.width;
	int height = screenSize.height;
	
	public BattleScreen() {
		
		this.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, width, height);
		
		BackgroundPanel backgroundPanel = new BackgroundPanel(width, height);
		BattleCommandBox battleCommandBox = new BattleCommandBox(width, height);
		StatusWindow statusWindow = new StatusWindow(width, height);
		
		layeredPane.add(backgroundPanel, Integer.valueOf(0));
		layeredPane.add(battleCommandBox, Integer.valueOf(1));
		layeredPane.add(statusWindow, Integer.valueOf(1));
		
		this.add(layeredPane);
		
	}

}
