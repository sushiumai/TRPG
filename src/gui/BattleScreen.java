package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class BattleScreen extends JPanel {
	
	public BattleScreen() {
		this.setLayout(new BorderLayout());
		
		JPanel enemyPanel = new JPanel();
		enemyPanel.setBackground(Color.red);
		
		JPanel commandPanel = new JPanel();
		commandPanel.setBackground(Color.BLUE);
		
		
		this.add(enemyPanel, BorderLayout.CENTER);
		this.add(commandPanel, BorderLayout.SOUTH);
		
	}

}
