package system;
import character.Character;

public abstract class BattleAction {
	
	protected Character actor;
	protected Character target;
	
	protected BattleAction(Character actor, Character target) {
		
		this.actor = actor;
		this.target = target;
	}
	
	protected abstract void execute();
	
	public Character getActor() {
		return this.actor;
	}
	public Character getTarget() {
		return this.target;
	}
	
}
