package character;

import java.util.ArrayList;

import data.WeaponFactory;
import data.WeaponType;
import item.Weapon;
import skill.Skill;

public abstract class Character {
	
	private ArrayList<Weapon> weapon;
	protected int maxHp;
	protected int maxMp;
	protected int hp;
	protected int mp;
	protected int power;
	protected int magicPower;
	protected int defence;
	protected int speed;
	protected String name;
	protected ArrayList<Skill> skills;
	
	public Character(int maxHp, int maxMp, int power, int magicPower, int defence, int speed, String name){
		
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.maxMp = maxMp;
		this.mp = maxMp;
		this.power = power;
		this.magicPower = magicPower;
		this.defence = defence;
		this.speed = speed;
		this.name = name;
		this.skills = new ArrayList<>();
		this.weapon = new ArrayList<>();
		this.equip(WeaponFactory.createHands());
		
	}
	
	public void learnSkill(Skill skill) {
		this.skills.add(skill);
		
	}
	
	public void equip(Weapon w) {
		this.weapon.clear();
		this.weapon.add(w);
		if (this.weapon.get(0).getType() == WeaponType.NONE) {
			return;
		}
		gui.MessageViewer.println(String.format(data.MessageCatalog.EQUIP_LOG, this.getName(), this.weapon.get(0).getName()));
		
	}
	public void unequip() {
		if (this.weapon.get(0).getType() == WeaponType.NONE) {
			gui.MessageViewer.println(String.format(data.MessageCatalog.UNEQUIP_ERROR_LOG, this.getName()));
			return;
		}
		gui.MessageViewer.println(String.format(data.MessageCatalog.UNEQUIP_LOG, this.getName(), this.weapon.get(0).getName()));
		this.weapon.clear();
		this.weapon.add(WeaponFactory.createHands());
	}
	
	
	public int getMaxHp() {
		return this.maxHp;
	}
	public int getHp() {
		return this.hp;
	}
	public int getMaxMp() {
		return this.maxMp;
	}
	public int getMp() {
		return this.mp;
	}
	public int getPower() {
		int totalPower = 0;
		totalPower = totalPower + this.power + this.weapon.get(0).getPower();
		return totalPower;
	}
	public int getMagicPower() {
		if (this.weapon.isEmpty()) {
			return this.magicPower;
		} else {
			int totalMagicPower = 0;
			totalMagicPower = totalMagicPower + this.magicPower + this.weapon.get(0).getMagicPower();
			return totalMagicPower;
		}
	}
	public int getDefence() {
		return this.defence;
	}
	public int getSpeed() {
		return this.speed;
	}
	public String getName() {
		return this.name;
	}

	
	public void reduceMp(int mpCost) {
		this.mp -= mpCost;
		
		if (this.mp < 0) {
			this.mp = 0;
		}
	}
	public void reduceHp(int damage) {
		this.hp -= damage;
		
		if (this.hp < 0) {
			this.hp = 0;
		}
	}
	
}
