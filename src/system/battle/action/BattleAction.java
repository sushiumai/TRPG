package system.battle.action;
import character.Character;

public abstract class BattleAction {
	
	protected Character actor;
	private java.util.List<? extends Character> targets;
	
	protected BattleAction(Character actor, java.util.List<? extends Character> targets) {
		this.actor = actor;
		this.targets = targets;
	}
	
	public abstract void execute();
	
	public Character getActor() {
		return this.actor;
	}
	public java.util.List<Character> getTargets() {
		return new java.util.ArrayList<>(this.targets);
	}
	
}
