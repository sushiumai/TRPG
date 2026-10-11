package gui;

import java.awt.Color;

public class BackgroundPanel extends Window {

	private static final double FULL_SIZE_RATIO = 1.0;
	private static final double ZERO_MARGIN_RATIO = 0.0;
	
	public BackgroundPanel(int width, int height) {
		
		super(width, height, FULL_SIZE_RATIO, FULL_SIZE_RATIO,ZERO_MARGIN_RATIO,ZERO_MARGIN_RATIO);
		this.setBackground(Color.green);
		
	}
	
}
