package character;

import common.Job;
import data.GrowthTable;
import system.GrowthSystem;

public class Player extends Character {
	
	protected int level;
	protected int exp;
	protected final Job job;
	
	public Player(Job job, int level, int exp){
		
		super(job.getStatusAtLevel(level), job.getName());
		this.job = job;
		this.level = level;
		this.exp = exp;
		applyStatus(this.level);
	}
	
	public int getExp() {
		return this.exp;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getNextExp() {
		return GrowthSystem.getExpToNextLevel(this.level, this.exp);
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

	public void applyStatus(int newLevel) {
		this.updateBaseStatus(this.job.getStatusAtLevel(newLevel));
	}
	
}
