package character;

import condition.StatusCondition;
import data.BattleStatus;
import item.Equipment;
import item.Weapon;
import item.WeaponFactory;
import java.util.ArrayList;
import java.util.List;
import skill.Skill;

public abstract class Character {

	private int hp;
	private int mp;
	protected BattleStatus baseStatus;
	private String name;
	protected List<Skill> skills;
	private final List<StatusCondition> conditions;
	private Equipment currentWeapon;
	protected Character(BattleStatus baseStatus, String name){
		
		this.baseStatus = baseStatus;
		this.name = name;
		this.hp = baseStatus.maxHp();
		this.mp = baseStatus.maxMp();
		this.skills = new ArrayList<>();
		this.currentWeapon = Equipment.HANDS;
		this.conditions = new ArrayList<>();
	}
	
	public void learnSkill(Skill skill) {
		this.skills.add(skill);
		
	}
	
	public void equipWeapon(Equipment newWeapon) {
		this.currentWeapon = newWeapon;
		gui.MessageViewer.printf(data.MessageCatalog.EQUIP_LOG, this.getName(), newWeapon.getName());//TODO:武器装備のコマンドを作った際、必ずここからは消す
	}
	public void unequipWeapon() {
		if (this.currentWeapon.getType() == null){
			gui.MessageViewer.print("予期しないエラー：武器の種類がnullです。");
			return;
		}
		//TODO:武器装備のコマンドを作った際、必ずここからは消す
		gui.MessageViewer.printf(data.MessageCatalog.UNEQUIP_LOG, this.getName(), this.currentWeapon.getName());
		this.currentWeapon = Equipment.HANDS;
	}

	public void addCondition(StatusCondition condition){
		this.conditions.add(condition);
	}


	public boolean hasCondition(Class<? extends StatusCondition> conditionClass){
		for (StatusCondition c : conditions){
			if (conditionClass.isInstance(c)){
				return true;
			}
		}
		return false;
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
		totalPower = totalPower + this.baseStatus.power() + this.currentWeapon.getPower();
		return totalPower;
	}
	public int getTotalMagicPower() {
			int totalMagicPower = 0;
			totalMagicPower = totalMagicPower + this.baseStatus.magicPower() + this.currentWeapon.getMagicPower();
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
	public Equipment getCurrentWeapon() {
		return this.currentWeapon;
	}
	public List<StatusCondition> getConditions() {
		return this.conditions;
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

	public void updateBaseStatus(BattleStatus newStatus){
		this.baseStatus = newStatus;
	}
	public boolean isAlive(){
		return this.hp > 0;
	}
	public boolean isDead(){
		return this.hp <= 0;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public void setName(String name) {
		this.name = name;
	}
}
