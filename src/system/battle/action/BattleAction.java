package system.battle.action;
import character.Character;
import character.Enemy;

import java.util.ArrayList;
import java.util.List;

public abstract class BattleAction {
	
	protected Character actor;
	protected java.util.List<? extends Character> targets;
	
	protected BattleAction(Character actor, java.util.List<? extends Character> targets) {
		this.actor = actor;
		this.targets = new ArrayList<>(targets);
	}
	
	public abstract void execute(List<Enemy> enemies);
	
	public Character getActor() {
		return this.actor;
	}
	public java.util.List<Character> getTargets() {
		return new ArrayList<>(this.targets);
	}
	public void setTargets(java.util.List<? extends Character> targets) {
		this.targets = new ArrayList<>(targets);
	}
	
}