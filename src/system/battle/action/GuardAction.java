package system.battle.action;
import character.Character;
import skill.GuardSkill;
public class GuardAction extends BattleAction{

	private final GuardSkill skill;
	
	public GuardAction(Character actor, GuardSkill skill, java.util.List<? extends Character> targets) {
		super(actor, targets);
		this.skill = skill;
	}
	
	@Override
	public void execute() {
		for (Character target : this.getTargets()) {
			target.setDefending(true);
		}
		gui.MessageViewer.println(String.format(data.MessageCatalog.GUARD_LOG, actor.getName()));
	}

}
