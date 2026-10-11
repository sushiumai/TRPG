package gui;

public class BattleCommandBox extends Window {
	
	private static final double X_COMMAND_SIZE_RATIO = 0.35;
	private static final double Y_COMMAND_SIZE_RATIO = 0.2;
	private static final double X_COMMAND_MARGIN_RATIO = 0.07;
	private static final double Y_COMMAND_MARGIN_RATIO = 0.75;

	public BattleCommandBox(int width, int height) {
		super(width, height, X_COMMAND_SIZE_RATIO, Y_COMMAND_SIZE_RATIO, X_COMMAND_MARGIN_RATIO, Y_COMMAND_MARGIN_RATIO);
		
	}
		
}
