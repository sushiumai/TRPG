package system.battle.action;
import character.Character;
import condition.GuardCondition;
import data.MessageCatalog;
import gui.MessageViewer;
import skill.GuardSkill;
public class GuardAction extends BattleAction{

	private final GuardSkill skill;
	
	public GuardAction(Character actor, GuardSkill skill, java.util.List<? extends Character> targets) {
		super(actor, targets);
		this.skill = skill;
	}
	
	@Override
	public void execute() {
		MessageViewer.println(String.format(MessageCatalog.SKILL_LOG, this.actor.getName(), this.skill.getName()));
		for (Character target : this.getTargets()) {
			target.addCondition(new GuardCondition());
		}
		this.actor.reduceMp(this.skill.getMpCost());
	}

}
