package system;
import character.Character;

public abstract class BattleAction {
	
	protected Character actor;
	private java.util.List<? extends Character> targets;
	
	public BattleAction(Character actor, java.util.List<? extends Character> targets) {
		actor.setDefending(false);
		this.actor = actor;
		this.targets = targets;
	}
	
	protected abstract void execute();
	
	public Character getActor() {
		return this.actor;
	}
	public java.util.List<? extends Character> getTargets() {
		return this.targets;
	}
	
}
