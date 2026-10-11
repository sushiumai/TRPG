package character;

public abstract class Player extends Character {
	
	private int level;
	private int exp;
	private int nextExp;
	
	public Player(int maxHp, int power, int defence, int magicPower,
			int magicDefence, int speed, String name, int level, int exp, int nextExp){
		
		super(maxHp, power, defence, magicPower, magicDefence, speed, name);
		
		
	}
	
	public int getExp() {
		return this.exp;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getNextExp() {
		return this.nextExp;
	}
	
	public void setExp(int earnedExp) {
		this.exp += earnedExp;
	}
	
	public void setLevel() {
		this.level++;
	}

}
