package character;

public abstract class Enemy extends Character {
	
	protected int dropExp;
	
	public Enemy(int maxHp, int maxMp, int power, int magicPower,
			int defence, int speed, String name, int dropExp) {
		
		super(maxHp, maxMp, power, magicPower, defence, speed, name);
		this.dropExp = dropExp;
	}

}
