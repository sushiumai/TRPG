package gui;

import javax.swing.JPanel;

public class Window extends JPanel {
	
	public Window(int width, int height, double xSizeRatio, double ySizeRatio, double xMarginRatio, double yMarginRatio) {
		
		int windowWidth = (int) (width * xSizeRatio);
		int windowHeight= (int) (height * ySizeRatio);
		int xMargin = (int) (width * xMarginRatio);
		int yMargin = (int) (height * yMarginRatio);
		
		int windowX = width - (windowWidth + xMargin);
		int windowY = height - (windowHeight + yMargin);
		
		this.setBounds(windowX, windowY, windowWidth, windowHeight);
		
	}

}
