package system;
import character.Character;
public class GuardAction extends system.BattleAction{
	
	public GuardAction(Character actor) {
		super(actor, actor);
	}
	
	@Override
	protected void execute() {
		actor.setDefending(true);
		
		gui.MessageViewer.println(String.format(data.MessageCatalog.GUARD_LOG, actor.getName()));
	}

}
