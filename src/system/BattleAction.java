package system;
import character.Character;

public class BattleAction {
	
	private Character acter;
	private Character target;
	private String command;
	
	public BattleAction(Character acter, Character target, String command) {
		
		this.acter = acter;
		this.target = target;
		this.command = command;
	}
	
	
	public Character getActer() {
		return this.acter;
	}
	public Character getTarget() {
		return this.target;
	}
	public String getCommand() {
		return this.command;
	}

}
