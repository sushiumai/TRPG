package character;

import java.util.ArrayList;

import skill.Skill;

public abstract class Character {
	
	//変数の定義
	private int maxHp;
	private int hp;
	private int power;
	private int defence;
	private int magicPower;
	private int magicDefence;
	private int speed;
	
	private String name;
	
	private ArrayList<Skill> skills;
	
	
	//コンストラクタ
	public Character(int maxHp, int power, int defence, int magicPower, int magicDefence, int speed, String name){
		
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.power = power;
		this.defence = defence;
		this.magicPower = magicPower;
		this.magicDefence = magicDefence;
		this.speed = speed;
		this.name = name;
		this.skills = new ArrayList<>();
		
	}
	
	//メソッドの定義
	public void learnSkill(Skill skill) {
		
		this.skills.add(skill);
		
	}
	
	//ゲッターなどの定義
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public int getDefence() {
		return this.defence;
	}
	
	public int getMagicPower() {
		return this.magicPower;
	}
	
	public int getMagicDefence() {
		return this.magicDefence;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public String getName() {
		return this.name;
	}
	
}
