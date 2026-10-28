package character;

import system.GrowthSystem;

public abstract class Player extends Character {
	
	protected int level;
	protected int exp;
	
	public Player(int maxHp, int maxMp, int power, int magicPower,
			int defence, int speed, String name, int level, int exp){
		
		super(maxHp, maxMp, power, magicPower, defence, speed, name);
		
		this.level = level;
		this.exp = exp;
	}
	
	public abstract void updateStats(int newLevel);
	
	public int getExp() {
		return this.exp;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getNextExp() {
		int nextLevel = this.level + 1;
		return GrowthSystem.EXP_TABLE[nextLevel] - this.exp;
	}
	
	public void setExp(int totalExp) {
		this.exp = totalExp;
	}
	
	public void levelUp() {
		this.level++;
	}
	
	
	
}
