package character;

import data.BattleStatus;
import item.Weapon;
import item.WeaponFactory;
import item.WeaponType;
import java.util.ArrayList;
import java.util.List;

import skill.Skill;

public abstract class Character {
	
	private final ArrayList<Weapon> weapon;
	private int hp;
	private int mp;
	protected BattleStatus baseStatus;
	private final String name;
	protected List<Skill> skills;
	private boolean isDefending = false;
	
	protected Character(BattleStatus baseStatus, String name){
		
		this.baseStatus = baseStatus;
		this.name = name;
		this.hp = baseStatus.maxHp();
		this.mp = baseStatus.maxMp();
		this.skills = new ArrayList<>();
		this.weapon = new ArrayList<>();
		this.weapon.add(WeaponFactory.createHands());
		
	}
	
	public void learnSkill(Skill skill) {
		this.skills.add(skill);
		
	}
	
	public void equip(Weapon w) {
		this.weapon.clear();
		this.weapon.add(w);
		if (this.weapon.getFirst().getType() == WeaponType.NONE) {
			return;
		}
		gui.MessageViewer.println(String.format(data.MessageCatalog.EQUIP_LOG, this.getName(), this.weapon.getFirst().getName()));
		
	}
	public void unequip() {
		if (this.weapon.getFirst().getType() == null){
			gui.MessageViewer.println("予期しないエラー：武器の種類がnullです。");
			return;
		}
		if (this.weapon.getFirst().getType() == WeaponType.NONE) {
			gui.MessageViewer.println(String.format(data.MessageCatalog.UNEQUIP_ERROR_LOG, this.getName()));
			return;
		}
		gui.MessageViewer.println(String.format(data.MessageCatalog.UNEQUIP_LOG, this.getName(), this.weapon.getFirst().getName()));
		this.weapon.clear();
		this.weapon.add(WeaponFactory.createHands());
	}
	
	public BattleStatus getBaseStatus() {
		return this.baseStatus;
	}
	public int getHp() {
		return this.hp;
	}
	public int getMp() {
		return this.mp;
	}
	public int getTotalPower() {
		int totalPower = 0;
		totalPower = totalPower + this.baseStatus.power() + this.weapon.getFirst().getPower();
		return totalPower;
	}
	public int getTotalMagicPower() {
			int totalMagicPower = 0;
			totalMagicPower = totalMagicPower + this.baseStatus.magicPower() + this.weapon.getFirst().getMagicPower();
			return totalMagicPower;
	}
	//TODO防具を作ったらいじる
	public int getDefense() {
		return this.baseStatus.defense();
	}
	public int getSpeed() {
		return this.baseStatus.speed();
	}
	public String getName() {
		return this.name;
	}
	public List<Skill> getSkills() {
		return this.skills;
	}
	public Weapon getWeapon() {
		return this.weapon.getFirst();
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
	public boolean isDefending() {
		return this.isDefending;
		
	}
	public void setDefending(boolean defending) {
		this.isDefending = defending;
	}

	public void updateBaseStatus(BattleStatus newStatus){
		this.baseStatus = newStatus;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
}
