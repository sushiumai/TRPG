package character;

import common.Job;
import system.GrowthSystem;

public abstract class Player extends Character {
	
	protected int level;
	protected int exp;
	private final int[] hpTable;
	private final int[] mpTable;
	private final int[] powerTable;
	private final int[] magicPowerTable;
	private final int[] speedTable;
	protected final Job job;
	
	public Player(int[] hpTable, int[] mpTable, int[] powerTable,
			int[] magicPowerTable, int[] speedTable, Job job, int level, int exp){
		
		super(hpTable[level], mpTable[level], powerTable[level], magicPowerTable[level],
				speedTable[level] / 2, speedTable[level], job.getName());
		
		this.hpTable = hpTable;
		this.mpTable = mpTable;
		this.powerTable = powerTable;
		this.magicPowerTable = magicPowerTable;
		this.speedTable = speedTable;
		this.job = job;
		this.level = level;
		this.exp = exp;
		applyStatus(level);
	}
	
	public int getExp() {
		return this.exp;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getNextExp() {
		int maxLevel = GrowthSystem.EXP_TABLE.length - 1;
		int nextLevel = this.level + 1;
		if (this.level == maxLevel) {
			return 0;
		}
		return GrowthSystem.EXP_TABLE[nextLevel] - this.exp;
	}
	
	public void setExp(int totalExp) {
		this.exp = totalExp;
	}
	public Job getJob() {
		return this.job;
	}
	
	public void levelUp() {
		this.level++;
	}
	
	public void updateStatus(int newLevel) {
		applyStatus(newLevel);
	}

	private void applyStatus(int newLevel) {
		this.maxHp = this.hpTable[newLevel];
		this.hp = this.hpTable[newLevel];
		this.maxMp = this.mpTable[newLevel];
		this.mp = this.mpTable[newLevel];
		this.power = this.powerTable[newLevel];
		this.magicPower = this.magicPowerTable[newLevel];
		this.speed = this.speedTable[newLevel];
		this.defense = this.speed / 2;
		this.level = newLevel;
	}
	
}
