package character;

public class BlueSlime extends Enemy {

	private static final int MAX_HP = 10;
	private static final int MAX_MP = 0;
	private static final int POWER = 2;
	private static final int MAGIC_POWER = 0;
	private static final int DEFENCE = 2;
	private static final int SPEED = 3;
	private static final String NAME = "青スライム";
	private static final int DROP_EXP = 3;
	
	public BlueSlime() {
		super(MAX_HP, MAX_MP, POWER, MAGIC_POWER, DEFENCE, SPEED, NAME, DROP_EXP);

	}

}
