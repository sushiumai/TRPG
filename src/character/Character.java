package character;

import java.util.ArrayList;

import skill.Skill;

public abstract class Character {
	
	protected int maxHp;
	protected int maxMp;
	protected int hp;
	protected int mp;
	protected int power;
	protected int magicPower;
	protected int speed;
	protected String name;
	protected ArrayList<Skill> skills;
	
	public Character(int maxHp, int maxMp, int power, int magicPower, int speed, String name){
		
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.maxMp = maxMp;
		this.mp = maxMp;
		this.power = power;
		this.magicPower = magicPower;
		this.speed = speed;
		this.name = name;
		this.skills = new ArrayList<>();
		
	}
	
	public void learnSkill(Skill skill) {
		
		this.skills.add(skill);
		
	}
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public int getMagicPower() {
		return this.magicPower;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setMaxHp(int hpUp) {
		this.maxHp += hpUp;
	}
	public void setMaxMp(int mpUp) {
		this.maxMp += mpUp;
	}
	public void setPower(int atkUp) {
		this.power += atkUp;
	}
	public void setMagicPower(int mtkUp) {
		this.magicPower += mtkUp;
	}
	public void setSpeed(int spdUp) {
		this.speed += spdUp;
	}
	
}
