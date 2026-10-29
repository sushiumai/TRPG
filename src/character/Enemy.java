package character;

public class Enemy extends Character {

	protected int dropExp;

	public Enemy(int maxHp, int maxMp, int power, int magicPower,
			int defense, int speed, String name, int dropExp) {

		super(maxHp, maxMp, power, magicPower, defense, speed, name);
		this.dropExp = dropExp;
	}
	
	public int getDropExp() {
		return this.dropExp;
	}

}
